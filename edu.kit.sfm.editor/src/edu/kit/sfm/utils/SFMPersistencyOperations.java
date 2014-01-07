package edu.kit.sfm.utils;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;

import edu.kit.sfm.servicefeaturemodel.Service;

public class SFMPersistencyOperations {

	/* LOAD EMF MODELS - procedures */

	public static Service loadModel(String modelName) {
		// Load service model:
		String projectName = "";
		IEditorPart editorPart = (IEditorPart) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editorPart != null) {
			IFileEditorInput input = (IFileEditorInput) editorPart
					.getEditorInput();
			IFile file = input.getFile();
			IProject activeProject = file.getProject();
			projectName = activeProject.getName();
		}
		String path = Platform.getLocation().toString() + "/" + projectName
				+ "/" + modelName;

		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(URI.createFileURI(path),
				true);
		return (Service) resource.getContents().get(0);
	}

	public static Service loadModelFromWorkspace(String modelName) {
		/* local variables */
		URI workspaceURI = null;

		// construct workspace URI
		IEditorPart editorPart = (IEditorPart) PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (editorPart != null) {
			IFileEditorInput input = (IFileEditorInput) editorPart
					.getEditorInput();
			IFile file = input.getFile();
			IProject activeProject = file.getProject();
			String projectName = activeProject.getName();
			String path = "/" + projectName + "/" + modelName;
			workspaceURI = URI.createPlatformResourceURI(path, true);
		}

		// generate resource
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(workspaceURI, true);
		return (Service) resource.getContents().get(0);
	}

	/* save EMF Model */

	public static void saveModel(Resource resource) {

		// save
		try {
			resource.save(null);

			// error handling
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}