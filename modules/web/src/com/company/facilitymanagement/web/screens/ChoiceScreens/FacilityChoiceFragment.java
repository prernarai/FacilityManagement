package com.company.facilitymanagement.web.screens.ChoiceScreens;

import com.company.facilitymanagement.web.PresenterEvents.UserChoiceSelectedEvent;
import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.cuba.gui.screen.ScreenFragment;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import org.springframework.context.event.EventListener;

import javax.inject.Inject;

@UiController("facilitymanagement_FacilityChoiceFragment")
@UiDescriptor("Facility-Choice-fragment.xml")
@DashboardWidget(name="Facility choices")
public class FacilityChoiceFragment extends ScreenFragment {
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


    @Subscribe
    private void onAttach(AttachEvent event) {
        this.choice1.addChoiceDescription("File an incident report",
                "StartComplaintProcess", "BULLHORN");
        this.choice2.addChoiceDescription("Chat about deficiency",
                "CHATWITHUS", "WECHAT");
        this.choice3.addChoiceDescription("Manage civil penalties",
                "MangeFacility", "HOME");
        this.choice4.addChoiceDescription("Pick schedule for visits",
                "MyComplaints", "LIST");
        this.choice5.addChoiceDescription("Update Capacity",
                "TrainingSchedule", "GROUP");

        this.choice6.addChoiceDescription("Schedule Training",
                "TrainingSchedule", "CALENDAR");

    }

    @EventListener
    public void handleUserChoiceSelectedEvent(UserChoiceSelectedEvent event) {
        if (event.getChoiceDescription() == "StartComplaintProcess") {

        }

    }
}