package com.company.facilitymanagement.web.screens.FileComplaint;

import com.company.facilitymanagement.entity.ComplaintModel.*;
import com.company.facilitymanagement.entity.FacilityManagement.Facility;
import com.company.facilitymanagement.service.ComplaintService;
import com.company.facilitymanagement.service.TaskService;
import com.company.facilitymanagement.service.VisitService;
import com.company.facilitymanagement.web.PresenterEvents.ComplaintCreatedEvent;
import com.company.facilitymanagement.web.PresenterEvents.UserChoiceSelectedEvent;
import com.haulmont.addon.bproc.service.BprocRuntimeService;
import com.haulmont.cuba.core.global.*;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.data.DsContext;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.haulmont.cuba.security.entity.User;
import de.diedavids.cuba.wizard.gui.components.Wizard;
import org.springframework.context.event.EventListener;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UiController("file-complaint")
@UiDescriptor("file-complaint.xml")
public class FileComplaint extends AbstractWindow {
    @Inject
    protected Metadata metadata;
    @Inject
    protected Datasource<Complainant> complainantDs;
    @Inject
    protected Datasource<Complaint> complaintDs;

    @Inject
    protected Datasource<Facility> facilityDs;
    @Inject
    protected Datasource<Allegation> allegationDs;
    @Inject
    protected Datasource<Perpetrator> perpetratorDs;
    @Inject
    protected Datasource<Victim> victimDs;


    @Inject
    protected Wizard fileComplaintWizard;
    @Inject
    protected DsContext dsContext;

    @Inject
    BprocRuntimeService businesProcessService;
    @Inject
    DataManager dataManager;
    @Override
    protected void init(InitEvent initEvent) {
        // super.init(initEvent);
        Complainant complainant = initComplainant();
        Complaint complaint = initComplaint(complainant);
        initFacility(complaint);
        Allegation allegation = initAllegation(complaint);
        initVictim(allegation);
        initPerp(allegation);
    }

    private void initPerp(Allegation allegation) {
        Perpetrator perp = metadata.create(Perpetrator.class);
        perp.setAllegation(allegation);
        allegation.setRelatedPerp(perp);
        perpetratorDs.setItem(perp);
    }

    private void initVictim(Allegation allegation) {
        Victim victim = metadata.create(Victim.class);
        victim.setAllegation(allegation);
        allegation.setRelatedVictim(victim);
        victimDs.setItem(victim);

    }

    private Allegation initAllegation(Complaint complaint) {
        Allegation allegation = metadata.create(Allegation.class);
        allegation.setComplaint(complaint);
        allegationDs.setItem(allegation);


        return allegation;
    }

    private void initFacility(Complaint complaint) {
        //Facility facility = metadata.create(Facility.class);
        //facilityDs.setItem(facility);
        // complaint.setFacility(facility);

    }

    private Complainant initComplainant() {
        Complainant complainant = metadata.create(Complainant.class);
        complainantDs.setItem(complainant);
        return complainant;

    }

    private Complaint initComplaint(Complainant complainant) {
        Complaint complaint = metadata.create(Complaint.class);
        complaint.setReportingParty(complainant);
        complaintDs.setItem(complaint);
        return complaint;

    }
    @Inject
    Events events;
    @Override
    public void ready() {
        fileComplaintWizard.addWizardFinishClickListener(event -> {

            dsContext.commit();
            ComplaintCreatedEvent complaintCreatedEvent=new ComplaintCreatedEvent(complaintDs.getItem());
            complaintCreatedEvent.setComplaintId(complaintDs.getItem().getBusinessKey());

           // startBusinessProcess(complaintDs.getItem());
            createTasks();
            showNotification("Complaint captured successfully and complaint id is :-" + complaintDs.getItem().getBusinessKey(), NotificationType.TRAY);
            close(COMMIT_ACTION_ID);
            events.publish(complaintCreatedEvent);
        });
        //fileComplaintWizard.addWizardCancelClickListener(this::);
    }

    @Inject
    TaskService taskService;
    @Inject
    private UserSessionSource userSessionSource;
    @Inject
    VisitService visitService;
    @Inject
    private ComplaintService complaintService;

    private void createTasks() {
        taskService.createTask("2HourCall",
                userSessionSource.getUserSession().getUser(),complaintDs.getItem());
        visitService.createVisit("typeOfVisit", userSessionSource.getUserSession().getUser(),
                complaintDs.getItem(),complaintDs.getItem().getFacility());

        //complaintService.setComplaintStatus(complaintDs.getItem(),2);
        //complaintService.setComplaintPriorty(complaintDs.getItem(),1);
        //complaintService.setAssignment(complaintDs.getItem(),userSessionSource.getUserSession().getUser());
    }
    private void startBusinessProcess(Complaint complaint) {

        Map<String, Object> processVariables = new HashMap<>();
        processVariables.put("complaintBusinessKey", complaint.getBusinessKey());
        processVariables.put("complaint", complaint);

     User ibUser= dataManager.load(User.class)
                .query("select u from sec$User u where u.lastName=:lastName ")
                .parameter("lastName", "smith")
                .view(View.MINIMAL)
                .one();
        processVariables.put("userId", ibUser);
        businesProcessService.startProcessInstanceByKey(
                "file-a-complaint",
                processVariables);
    }
    @EventListener
    protected void onComplaintCreated(ComplaintCreatedEvent event) {
        Complaint complaint=dataManager.load(Complaint.class)
                .query("select u from facilitymanagement_Complaint u " +
                        "where u.businessKey=:businessKey")
                .parameter("businessKey",event.getComplaintId())
                .view(View.LOCAL)
                .one();
       // complaintService.setComplaintStatus(complaintDs.getItem(),2);
       // complaintService.setComplaintPriorty(complaintDs.getItem(),1);
       // complaintService.setAssignment(complaintDs.getItem(),userSessionSource.getUserSession().getUser());
    }
    /*private void sendByEmail() {

        EmailInfo emailInfo = new EmailInfo()

        emailService.sendEmailAsync(emailInfo);
    }*/


}