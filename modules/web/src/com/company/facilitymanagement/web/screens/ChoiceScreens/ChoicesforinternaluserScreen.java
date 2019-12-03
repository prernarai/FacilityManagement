package com.company.facilitymanagement.web.screens.ChoiceScreens;

import com.company.facilitymanagement.web.PresenterEvents.UserChoiceSelectedEvent;
import com.haulmont.addon.bproc.entity.ProcessDefinitionData;
import com.haulmont.addon.bproc.entity.ProcessInstanceData;
import com.haulmont.addon.bproc.service.BprocRepositoryService;
import com.haulmont.addon.bproc.service.BprocRuntimeService;
import com.haulmont.addon.bproc.web.processform.ProcessFormScreens;
import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.screen.*;
import org.springframework.context.event.EventListener;

import javax.inject.Inject;
import java.util.Map;
import java.util.HashMap;
@UiController("facilitymanagement_ChoicesforinternaluserScreen")
@UiDescriptor("choicesForInternalUser-screen.xml")
public class ChoicesforinternaluserScreen extends Screen {
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
    private BprocRuntimeService bprocRuntimeService;
    @Inject
    private ProcessFormScreens processFormScreens;

    @Inject
    private BprocRepositoryService bprocRepositoryService;
    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        this.choice1.addChoiceDescription("File a complaint",
                "StartComplaintProcess","SEARCH");
        this.choice2.addChoiceDescription("Manage facility",
                "MangeFacility","HOME");
        this.choice3.addChoiceDescription("My complaints",
                "MyComplaints","LIST");
        this.choice4.addChoiceDescription("Manage clients",
                "ManageClients","GROUP");
        this.choice5.addChoiceDescription("Manage training schedule",
                "TrainingSchedule","CALENDAR");
        this.choice6.addChoiceDescription("My Incident Reports",
                "ManageReports","SNAPCHAT_GHOST");

    }


    @EventListener
    public void handleUserChoiceSelectedEvent(UserChoiceSelectedEvent event)
    {
        if(event.getChoiceDescription()=="StartComplaintProcess")
            this.startInterview();
    }
    private void startInterview() {

        Map<String, Object> processVariables = new HashMap<>();
        ProcessInstanceData processInstance= bprocRuntimeService.startProcessInstanceByKey("file-a-complaint",processVariables);

        ProcessDefinitionData processDefinitionData = findProcessDefinitionData();
        processFormScreens.createStartProcessForm(processDefinitionData, this)
                .show();
        ////Note what this code for, what is this start for?
           // Map<String, Object> processVariables = new HashMap<>();
           //ProcessInstanceData processInstance= bprocRuntimeService.startProcessInstanceByKey("file-a-complaint",processVariables);
       // processFormScreens.createStartProcessForm(bprocRepositoryService.
             //   getProcessDefinitionById(processInstance.getProcessDefinitionId()), this)
              //  .show();
    }
    private ProcessDefinitionData findProcessDefinitionData() {
       // SampleItem sampleItem = sampleItemDc.getItem();
        return bprocRepositoryService.createProcessDefinitionDataQuery()
                .processDefinitionKey("file-a-complaint")
                .latestVersion()
                .singleResult();

    }

}