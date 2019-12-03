package com.company.facilitymanagement.web.screens.complaint;

import com.company.facilitymanagement.entity.ComplaintModel.Allegation;
import com.company.facilitymanagement.entity.FacilityManagement.Facility;
import com.company.facilitymanagement.entity.ScheduleMgmt.Appointment;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.WindowManager;
import com.haulmont.cuba.gui.components.AbstractEditor;
import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.Frame;
import com.haulmont.cuba.gui.components.LinkButton;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.screen.OpenMode;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

@UiController("complaint-edit")
@UiDescriptor("complaint-edit.xml")
public class ComplaintEdit extends AbstractEditor<Complaint> {
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    protected Datasource<Complaint> complaintDs;
    @Inject
    private LinkButton facilityNumberLink;
    @Inject
    Allegationitemframe allegationFrame;

    @Override
    protected void postInit() {
        this.facilityNumberLink.setCaption(complaintDs.getItem().getFacility().getBusinessKey());
        Complaint complaint= complaintDs.getItem();
        InitiateAllegation( complaint);

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