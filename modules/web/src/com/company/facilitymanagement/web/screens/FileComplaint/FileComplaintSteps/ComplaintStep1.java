package com.company.facilitymanagement.web.screens.FileComplaint.FileComplaintSteps;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import de.diedavids.cuba.wizard.gui.components.AbstractWizardStep;

import javax.inject.Inject;
import java.util.Map;

@UiController("complaint-step1")
@UiDescriptor("complaint-step1.xml")
public class ComplaintStep1 extends AbstractWizardStep {
    @Inject
    protected Datasource<Complaint> complaintDs;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        this.complaintDs.getItem().setWhatHappened("What did you see?");

    }
}