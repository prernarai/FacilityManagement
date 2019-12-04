package com.company.facilitymanagement.web.screens;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.company.facilitymanagement.entity.FacilityManagement.Visit;
import com.company.facilitymanagement.entity.ReferenceModel.Task;
import com.company.facilitymanagement.entity.ScheduleMgmt.Appointment;
import com.company.facilitymanagement.service.AppointmentService;
import com.company.facilitymanagement.service.ComplaintService;

import com.company.facilitymanagement.service.TaskService;
import com.company.facilitymanagement.service.VisitService;
import com.company.facilitymanagement.web.PresenterEvents.UserChoiceSelectedEvent;
import com.company.facilitymanagement.web.screens.ChoiceScreens.ChoiceCardFragment;
import com.company.facilitymanagement.web.screens.FileComplaint.FileComplaint;
import com.company.facilitymanagement.web.screens.ScheduleMgmt.AppointmentEdit;
import com.company.facilitymanagement.web.screens.complainant.ClientBrowse;
import com.company.facilitymanagement.web.screens.complaint.ComplaintBrowse;
import com.company.facilitymanagement.web.screens.facility.FacilityBrowse;
import com.company.facilitymanagement.web.screens.facility.VisitBrowse;
import com.haulmont.addon.bproc.entity.TaskData;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.web.app.main.MainScreen;
import org.springframework.context.event.EventListener;

import javax.inject.Inject;
import java.util.List;


@UiController("respSideMenuMainScreen")
@UiDescriptor("ext-main-screen.xml")
public class ExtMainScreen extends MainScreen {

   /* @Inject
    private BprocRuntimeService bprocRuntimeService;

    @Subscribe("launchBusinessProcess")
    private void onLaunchBusinessProcessClick(Button.ClickEvent event) {
        Map<String, Object> processVariables = new HashMap<>();
        bprocRuntimeService.startProcessInstanceByKey("file-a-complaint",processVariables);
    }*/
    @Inject
    CollectionContainer<Visit> visitDc;
   @Inject
   private ChoiceCardFragment choice1;
    @Inject
    private ChoiceCardFragment choice2;
    @Inject
    private ChoiceCardFragment choice3;
    @Inject
    private ChoiceCardFragment choice4;
    @Inject
    private ChoiceCardFragment choice5;
    @Inject
    private ChoiceCardFragment choice6;
    @Inject
    private Screens screens;
    @Inject
    private DataManager dataManager;
    @Inject
    private  CollectionContainer<Appointment>  appointmentsDc;
    @Inject
    private  CollectionContainer<Task>  taskDatasDc;
    @Inject
    ComplaintService complaintService;
    @Inject
    AppointmentService appointmentService;
    @Inject
    TaskService taskService;

    @Inject
    VisitService visitService;



    @Subscribe
   protected void onBeforeShow(BeforeShowEvent event) {
       this.choice1.addChoiceDescription("File a complaint","StartComplaintProcess","BULLHORN");
       this.choice2.addChoiceDescription("Manage facility",
               "MangeFacility","HOME");
       this.choice3.addChoiceDescription("My complaints",
               "MyComplaints","LIST");
       this.choice4.addChoiceDescription("Manage clients",
               "ManageClients","GROUP");
       this.choice5.addChoiceDescription("Manage visits",
               "ManageVisits","CALENDAR");
       this.choice6.addChoiceDescription("Manage training schedule",
               "TrainingSchedule","SNAPCHAT_GHOST");
        LoadVisits();
        LoadAppointments();
        LoadTasks();
   }


    private void LoadVisits() {
        //since loader is not working so trying the service. Need to figure out why loader not working on main widow
      List<Visit> visitList=visitService.getVisitList();
        visitDc.setItems(visitList);

    }
    private void LoadTasks() {
        //since loader is not working so trying the service. Need to figure out why loader not working on main widow
        List<Task> taskList=taskService.getTaskList();
        taskDatasDc.setItems(taskList);

    }
    private void LoadAppointments() {
        //since loader is not working so trying the service.
        List<Appointment> appointmentList=appointmentService.getAppointmentList();
        appointmentsDc.setItems(appointmentList);

    }
    @EventListener
    public void handleUserChoiceSelectedEvent(UserChoiceSelectedEvent event)
    {
        if(event.getChoiceDescription()=="StartComplaintProcess")
            this.startComplaint();
        if(event.getChoiceDescription()=="MangeFacility")
            this.startFacility();
        if(event.getChoiceDescription()=="MyComplaints")
            this.searchComplaint();
        if(event.getChoiceDescription()=="ManageClients")
            this.startClients();
        if(event.getChoiceDescription()=="ManageVisits")
            this.startVisit();
    }

    private void startClients() {
        ClientBrowse screen = screens.create(ClientBrowse.class, OpenMode.DIALOG);
        screens.show(screen);
    }

    private void startComplaint() {
        FileComplaint screen = screens.create(FileComplaint.class, OpenMode.DIALOG);
        screens.show(screen);
    }
    private void searchComplaint() {
        ComplaintBrowse screen = screens.create(ComplaintBrowse.class, OpenMode.DIALOG);
        screens.show(screen);
    }
    private void startFacility() {
        FacilityBrowse screen = screens.create(FacilityBrowse.class, OpenMode.DIALOG);
        screens.show(screen);
    }
    private void startVisit() {
        VisitBrowse screen = screens.create(VisitBrowse.class, OpenMode.DIALOG);
        screens.show(screen);
    }
    @Inject
    private ScreenBuilders screenBuilders;
    public void createAppointment() {
        //AppointmentEdit screen = screens.create(AppointmentEdit.class, OpenMode.DIALOG);
       // screens.show(screen);
        screenBuilders.editor(Appointment.class, this)
                .editEntity(new Appointment())
                .withLaunchMode(OpenMode.DIALOG)
                .build()
                .show();
    }

    public void refreshAppointment() {
        this.LoadAppointments();
    }

    public void refreshVisit() {
        List<Visit> visitList=visitService.getVisitList();
        visitDc.setItems(visitList);

    }


   /* @Install(to = "complaintsDl", target = Target.DATA_LOADER)
    protected List<Complaint> customersDlLoadDelegate(LoadContext<Complaint> loadContext) {
        return dataManager.loadList(loadContext);
    }*/
}