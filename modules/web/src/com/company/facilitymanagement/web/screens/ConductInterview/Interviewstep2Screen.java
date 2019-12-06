package com.company.facilitymanagement.web.screens.ConductInterview;

import com.company.facilitymanagement.entity.ComplaintModel.Allegation;
import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.company.facilitymanagement.entity.FacilityManagement.Facility;
import com.company.facilitymanagement.web.screens.complaint.Allegationitemframe;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.LinkButton;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.screen.OpenMode;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import de.diedavids.cuba.wizard.gui.components.AbstractWizardStep;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
@UiController("InterviewStep2-screen")
@UiDescriptor("InterviewStep2-screen.xml")
public class Interviewstep2Screen extends AbstractWizardStep {
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    protected Datasource<Complaint> complaintDs;
    @Inject
    private LinkButton facilityNumberLink;
    @Inject
    Allegationitemframe allegationFrame;

    @Override
    public void onActivate() {
       this.facilityNumberLink.setCaption(complaintDs.getItem().getFacility().getBusinessKey());
       Complaint complaint= complaintDs.getItem();
       InitiateAllegation( complaint);
    }

    @Override
    public void init(Map<String, Object> params) {
        //this.facilityNumberLink.setCaption(complaintDs.getItem().getFacility().getBusinessKey());
        //Complaint complaint= complaintDs.getItem();
        //InitiateAllegation( complaint);

    }
    public void onFacilityLinkClicked(Component component)
    {
        screenBuilders.editor(Facility.class, this)
                .editEntity(complaintDs.getItem().getFacility())
                .withLaunchMode(OpenMode.DIALOG)
                .build()
                .show();
    }


    private void InitiateAllegation(Complaint complaint) {
        if(complaint.getAllegations()!=null)
        {
            List<Allegation> allegationList=complaint.getAllegations();
            allegationFrame.setAllegationData(allegationList.get(0));

        }
    }

    public void onAllegationLinkClicked() {
        //  openWindow("Allegationitemframe",
        //     WindowManager.OpenType.DIALOG.width(800).height(300).closeable(true).resizable(true).modal(false));
        screenBuilders.editor(Allegation.class, this)
                .editEntity(new Allegation())
                .withLaunchMode(OpenMode.DIALOG)
                .build()
                .show();
    }
}