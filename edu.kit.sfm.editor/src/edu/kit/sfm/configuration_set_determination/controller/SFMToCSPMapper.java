package edu.kit.sfm.configuration_set_determination.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import choco.Choco;
import choco.cp.model.CPModel;
import choco.kernel.model.constraints.Constraint;
import choco.kernel.model.variables.integer.IntegerVariable;
import edu.kit.sfm.servicefeaturemodel.Excludes;
import edu.kit.sfm.servicefeaturemodel.MandatoryServiceFeature;
import edu.kit.sfm.servicefeaturemodel.OR;
import edu.kit.sfm.servicefeaturemodel.OptionalServiceFeature;
import edu.kit.sfm.servicefeaturemodel.Requires;
import edu.kit.sfm.servicefeaturemodel.Service;
import edu.kit.sfm.servicefeaturemodel.ServiceFeature;
import edu.kit.sfm.servicefeaturemodel.ServiceFeatureDiagram;
import edu.kit.sfm.servicefeaturemodel.XOR;


public class SFMToCSPMapper {
	
	private CPModel m;
	private HashMap<String, IntegerVariable> mapping;
	private long processingTime;
	
	public SFMToCSPMapper(){
		m = new CPModel();
		mapping = new HashMap<String, IntegerVariable>();
		//cost = Choco.makeIntVar("ivar2", 1, 3, Options.V_NO_DECISION);
		processingTime = 0;
	}
	
	public CPModel getCSPforSFM(Service service){
		
		long startTime = System.currentTimeMillis();
		
		/**
		 * --------------
		 * 1. Handle root
		 * --------------
		 */
		ServiceFeatureDiagram diag = service.getServiceFeatureDiagram();
		if(diag.getServiceFeatures().size() != 1){
			throw new IllegalArgumentException("Too many or no root feature.");
		}
		ServiceFeature root = diag.getServiceFeatures().get(0);
		if(root instanceof MandatoryServiceFeature){
			MandatoryServiceFeature msf = (MandatoryServiceFeature) root;
			//System.out.println("Root is Mandatory SF: " + msf.getName());
			IntegerVariable rootVar = Choco.makeBooleanVar(msf.getId());
			mapping.put(msf.getId(), rootVar);
			m.addVariable(rootVar);
			m.addConstraint(Choco.eq(rootVar, 1));
		} else if (root instanceof OptionalServiceFeature){
			OptionalServiceFeature osf = (OptionalServiceFeature) root;
			//System.out.println("Root is Optional SF: " + osf.getName());
			IntegerVariable rootVar = Choco.makeBooleanVar(osf.getId());
			mapping.put(osf.getId(), rootVar);
			m.addVariable(rootVar);
		}
		
		
		/**
		 * -----------------------------------------
		 * 2. Iterate SFM - Create Feature Variables
		 * -----------------------------------------
		 */
		TreeIterator<EObject> tree1 = root.eAllContents();
		while(tree1.hasNext()){
			EObject e = tree1.next();
			if(e instanceof ServiceFeature){
				ServiceFeature sf = (ServiceFeature) e;
				IntegerVariable v = Choco.makeBooleanVar(sf.getId());
				mapping.put(sf.getId(), v);
				m.addVariable(v);
			}
		}
		
		
		/**
		 * -----------------------------------
		 * 3. Iterate SFM - Create Constraints
		 * -----------------------------------
		 */
		TreeIterator<EObject> tree = root.eAllContents();
		while(tree.hasNext()){
			EObject e = tree.next();
			if(e instanceof MandatoryServiceFeature){
				MandatoryServiceFeature msf = (MandatoryServiceFeature) e;
				//System.out.println("Mandatory SF: " + msf.getName());
				createMandatoryConstraint(msf);
			} else if (e instanceof OptionalServiceFeature){
				OptionalServiceFeature osf = (OptionalServiceFeature) e;
				//System.out.println("Optional SF: " + osf.getName());
				createOptionalConstraint(osf);
			} else if (e instanceof XOR){
				XOR xor = (XOR) e;
				//System.out.println("XOR: " + xor);
				createXORConstraint(xor);
			} else if (e instanceof OR){
				OR or = (OR) e;
				//System.out.println("OR:" + or);
				createORConstraint(or);
			} else if (e instanceof Requires){
				Requires req = (Requires) e;
				//System.out.println("Requires " + req.getServiceFeature().getName());
				createRequiresConstraint(req);
			} else if (e instanceof Excludes){
				Excludes exc = (Excludes) e;
				//System.out.println("Excludes " + exc.getServiceFeature().getName());
				createExcludesConstraint(exc);
			}
		}

		long endTime = System.currentTimeMillis();
		processingTime = (endTime - startTime);
		
		return m;
	}
	
	
	/**
	 * Creates constraint for mandatory feature
	 * (parent is always another sf)
	 * @param child
	 */
	public void createMandatoryConstraint(MandatoryServiceFeature child){
		ServiceFeature parent = (ServiceFeature) child.eContainer();
		m.addConstraint(Choco.eq(
			mapping.get(parent.getId()), 
			mapping.get(child.getId())
		));
		//m.addConstraint(Choco.ifOnlyIf(
		//		Choco.eq(mapping.get(child.getId()), 1)
		//		));
	}
	
	
	/**
	 * Creates constraint for optional feature ONLY if parent is also ServiceFeature
	 * (cases where the parent is a GroupRelationship (XOR,OR) are handled elsewhere) 
	 * @param child
	 */
	public void createOptionalConstraint(OptionalServiceFeature child){
		if(child.eContainer() instanceof ServiceFeature){
			ServiceFeature parent = (ServiceFeature) child.eContainer();
			m.addConstraint(Choco.implies(
				selFeature(child),
				selFeature(parent)
			));
		}
	}
	
	
	/**
	 * Creates constraint for OR
	 * P <=> C1 || C2 || ... || Cn
	 * @param or
	 */
	public void createORConstraint(OR or){
		ServiceFeature parent = (ServiceFeature) or.eContainer();
		if(or.getOptionalServiceFeatures().size() == 0){
			throw new IllegalArgumentException("SFM contains or node without children.");
		} else if(or.getOptionalServiceFeatures().size() == 1){
			ServiceFeature child = or.getOptionalServiceFeatures().get(0);
			m.addConstraint(Choco.implies(
				selFeature(parent),
				selFeature(child)
			));
		} else if (or.getOptionalServiceFeatures().size() == 2) {
			Constraint[] constraintList = new Constraint[or.getOptionalServiceFeatures().size()];
			int i = 0;
			for(OptionalServiceFeature osf : or.getOptionalServiceFeatures()){
				constraintList[i] = selFeature(osf);
				i++;
			}
			Constraint resultConstraint = Choco.or(constraintList[0], constraintList[1]);
			m.addConstraint(equivalent(
								selFeature(parent), 
								resultConstraint)
							);
		} else {
			Constraint resultConstraint;
			Constraint[] constraintList = new Constraint[or.getOptionalServiceFeatures().size()];
			int i = 0;
			for(OptionalServiceFeature osf : or.getOptionalServiceFeatures()){
				constraintList[i] = Choco.eq(mapping.get(osf.getId()), 1);
				i++;
			}
			resultConstraint = Choco.or(constraintList[0], constraintList[1]);
			for(int j = 0; j < constraintList.length - 2; j++){
				resultConstraint = Choco.or(resultConstraint, constraintList[j+2]);
			}
			m.addConstraint(equivalent(
								selFeature(parent), 
								resultConstraint)
							);
		}
	}
	
	
	/**
	 * Creates constraint for XOR
	 * Parent <=> (-C2 && -C3 && ... && -Cn) && ... && (-C1 && -C2 && ... && -Cn-1)
	 * @param xor
	 */
	public void createXORConstraint(XOR xor){
		ServiceFeature parent = (ServiceFeature) xor.eContainer();
		if(xor.getOptionalServiceFeatures().size() == 0){
			throw new IllegalArgumentException("SFM contains xor node without children.");
		} else if (xor.getOptionalServiceFeatures().size() == 1) {
			ServiceFeature child = xor.getOptionalServiceFeatures().get(0);
			m.addConstraint(Choco.eq(
					mapping.get(parent.getId()), 
					mapping.get(child.getId())
					));
		} else {			
			ArrayList<Constraint> constraintList = new ArrayList<Constraint>();
			List<OptionalServiceFeature> childList = xor.getOptionalServiceFeatures();
			// For every child...
			for (int i = 0; i < childList.size(); i++) {
				// ...create constraint-list without this child BUT with parent... 
				// (contains: [-C2, -C3, ..., -Cn, P])
				ArrayList<Constraint> constraintsWithoutCurrent = new ArrayList<Constraint>();
				for (int k = 0; k < childList.size(); k++) {
					constraintsWithoutCurrent.add(unselFeature(childList.get(k)));
				}
				constraintsWithoutCurrent.remove(i);
				constraintsWithoutCurrent.add(selFeature(parent));
				// ...to create a constraint out of it:
				constraintList.add(equivalent(
							selFeature(childList.get(i)),
							groupAnd(constraintsWithoutCurrent)
						));
			}
			m.addConstraint(groupAnd(constraintList));
		}
	}
	
	
	/**
	 * Creates constraint for Requires
	 * @param req
	 */
	public void createRequiresConstraint(Requires req){
		ServiceFeature demanding = (ServiceFeature) req.eContainer();
		ServiceFeature required = req.getServiceFeature();
		m.addConstraint(Choco.implies( selFeature(demanding), selFeature(required) )); 
	}
	
	
	/**
	 * Creates constraint for Excludes
	 * @param exc
	 */
	public void createExcludesConstraint(Excludes exc){
		ArrayList<Constraint> excludesList = new ArrayList<Constraint>();
		excludesList.add(selFeature((ServiceFeature) exc.eContainer()));
		excludesList.add(selFeature(exc.getServiceFeature()));
		m.addConstraint(Choco.not(groupAnd(excludesList)));
	}

	
	/**
	* Models the logical EQUIVALENT of 2 constraints: a <-> b.
	* @param c1 - Constraint a || IntegerVariable
	* @param c2 - Constraint b || IntegerVariable
	* @return - Constraint representing the logical equivalent of a and b
	*/
	protected Constraint equivalent(Constraint c1, Constraint c2) {
		return Choco.and( Choco.implies(c1, c2), Choco.implies(c2, c1) );
	}
   
	
	/**
	* Models the andNot Group
	* (Example: -C1 && -C2 && ... && -Cn)
	* @param constraintList
	* @return
	*/
	protected Constraint groupNotAnd(List<OptionalServiceFeature> featureList) {
		Constraint resultConstraint = null;
		Constraint[] constraintList = new Constraint[featureList.size()];
		int i = 0;
		for(OptionalServiceFeature osf : featureList){
			constraintList[i] = Choco.eq(mapping.get(osf.getId()), 0);
			i++;
		}
		switch(constraintList.length){
			case 0:	
				break;
			case 1:	resultConstraint = constraintList[0];
				break;
			case 2: resultConstraint = Choco.and(constraintList[0], constraintList[1]);
				break;
			default: resultConstraint = Choco.and(constraintList[0], constraintList[1]);
				for(int j = 0; j < constraintList.length - 2; j++){
					resultConstraint = Choco.or(resultConstraint, constraintList[j+2]);
				}
		}
	   return resultConstraint;
   }
	
	
	/**
	* Models the logical AND for a group of <code>Constraints</code> or <code>IntegerValues</code>.
	* @param cons - List of <code>constraints</code> or <code>IntegerValues</code>
	* @return - Constraint representing the logical conjunction of all input parameter
	*/
	protected Constraint groupAnd(ArrayList<Constraint> constraintList) {
		switch(constraintList.size()){
			case 0:	
				break;
			case 1:	
				return constraintList.get(0);
			case 2: 
				return Choco.and(constraintList.get(0), constraintList.get(1));
			default: 
				Constraint resultConstraint = Choco.and(constraintList.get(0), constraintList.get(1));
				for(int j = 0; j < constraintList.size() - 2; j++){
					resultConstraint = Choco.and(resultConstraint, constraintList.get(j+2));
				}
				return resultConstraint;
		}
		return null;
	}
	
	
	/**
	 * Returns constraint that selects feature
	 * @param sf
	 * @return
	 */
	protected Constraint selFeature(ServiceFeature sf){
		return Choco.eq(mapping.get(sf.getId()), 1);
	}
	
	
	/**
	 * Returns constraint that unselects feature
	 * @param sf
	 * @return
	 */
	protected Constraint unselFeature(ServiceFeature sf){
		return Choco.eq(mapping.get(sf.getId()), 0);
	}
	
	
	/**
	 * Returns the processing time.
	 * @return
	 */
	public long getProcessingTime(){
		return processingTime;
	}
	
	
}
