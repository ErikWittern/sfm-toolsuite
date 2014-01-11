package edu.kit.sfm.utils;

import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class NumberOfPerformanceRunsDialog extends TitleAreaDialog {
	  private Text numberOfPerformanceRuns;

	  private String numberOfRuns;

	  public NumberOfPerformanceRunsDialog(Shell parentShell) {
	    super(parentShell);
	  }

	  @Override
	  public void create() {
	    super.create();
	    setTitle("Number of performance runs");
	    setMessage("Please provide the amount of performance runs you want to conduct.", IMessageProvider.INFORMATION);
	  }

	  @Override
	  protected Control createDialogArea(Composite parent) {
	    Composite area = (Composite) super.createDialogArea(parent);
	    Composite container = new Composite(area, SWT.NONE);
	    container.setLayoutData(new GridData(GridData.FILL_BOTH));
	    GridLayout layout = new GridLayout(2, false);
	    container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
	    container.setLayout(layout);

	    createNumberOfPerformanceRuns(container);

	    return area;
	  }

	  private void createNumberOfPerformanceRuns(Composite container) {
	    Label lbtFirstName = new Label(container, SWT.NONE);
	    lbtFirstName.setText("Number of runs");

	    GridData dataFirstName = new GridData();
	    dataFirstName.grabExcessHorizontalSpace = true;
	    dataFirstName.horizontalAlignment = GridData.FILL;

	    numberOfPerformanceRuns = new Text(container, SWT.BORDER);
	    numberOfPerformanceRuns.setText("100");
	    numberOfPerformanceRuns.setLayoutData(dataFirstName);
	  }


	  @Override
	  protected boolean isResizable() {
	    return true;
	  }

	  // save content of the Text fields because they get disposed
	  // as soon as the Dialog closes
	  private void saveInput() {
	    numberOfRuns = numberOfPerformanceRuns.getText();
	  }

	  @Override
	  protected void okPressed() {
	    saveInput();
	    super.okPressed();
	  }

	  public String getNumberOfPerformanceRuns() {
	    return numberOfRuns;
	  }
}
