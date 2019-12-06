package com.company.facilitymanagement.web.screens.ChoiceScreens;

import com.company.facilitymanagement.web.PresenterEvents.UserChoiceSelectedEvent;
import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.bali.events.Subscription;
import com.haulmont.cuba.gui.screen.*;
import org.springframework.context.event.EventListener;

import javax.inject.Inject;
import java.util.function.Consumer;

@UiController("facilitymanagement_ReporterChoiceFragment")
@UiDescriptor("Reporter-Choice-fragment.xml")
@DashboardWidget(name="Reporter choices")
public class ReporterChoiceFragment extends ScreenFragment {
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


    @Subscribe
    private void onAttach(AttachEvent event) {
        this.choice1.addChoiceDescription("File a complaint",
                "StartComplaintProcess","BULLHORN");
        this.choice2.addChoiceDescription("Chat to report",
                "CHATWITHUS","WECHAT");
        this.choice3.addChoiceDescription("Search facilities",
                "MangeFacility","HOME");
        this.choice4.addChoiceDescription("Search complaints",
                "MyComplaints","LIST");
        this.choice5.addChoiceDescription("Schedule training",
                "TrainingSchedule","CALENDAR");



    }
    @EventListener
    public void handleUserChoiceSelectedEvent(UserChoiceSelectedEvent event)
    {
        if(event.getChoiceDescription()=="StartComplaintProcess")
        {

        }

    }

}