package com.company.facilitymanagement.web.screens.ChoiceScreens;

import com.haulmont.addon.bproc.service.BprocRuntimeService;
import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.cuba.core.global.Events;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.screen.ScreenFragment;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import com.company.facilitymanagement.web.PresenterEvents.UserChoiceSelectedEvent;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@UiController("facilitymanagement_ChoiceCardFragment")
@UiDescriptor("Choice-Card-fragment.xml")
@DashboardWidget(name="Choice Card")
public class ChoiceCardFragment extends ScreenFragment {
    @Inject
    private Notifications notifications;
    @Inject
    VBoxLayout content;
    @Inject
    UiComponents uiComponents;
    @Inject
    Action handleUserChoice;
    @Inject
    Events events;

    private static final String TEXT_STYLE = "custom-label";
    private static final String SOURCE_TEXT_STYLE = "source-label";
    private static final String ICON_STYLE = "icon-label";
    public void addChoiceDescription( String choiceDescription,String choiceId,String IconId){
        Label choiceIcon=  uiComponents.create(Label.NAME);
        choiceIcon.setIcon("font-icon:"+IconId);
        choiceIcon.setAlignment(Component.Alignment.MIDDLE_CENTER);
        choiceIcon.addStyleName("h1");
        choiceIcon.addStyleName(ICON_STYLE);
        Label choiceText=  uiComponents.create(Label.NAME);
        choiceText.setWidth("120px");
        //choiceText.setHtmlEnabled(true);
        // String htmlString=" <div class=\"container\">\n" +
        //        "    <p>"+choiceDescription+"</p> \n" +
        //        "  </div>";
        //choiceText.setStyleName("custom-label");

        choiceText.setValue(choiceDescription);
        choiceText.setAlignment(Component.Alignment.MIDDLE_CENTER.MIDDLE_CENTER);
        choiceText.setStyleName(TEXT_STYLE);
        Button choiceButton=uiComponents.create(Button.NAME);
        choiceButton.setId(choiceId);
        choiceButton.setAction(handleUserChoice);
        choiceButton.setCaption("Start");
        choiceButton.setAlignment(Component.Alignment.MIDDLE_CENTER);
        choiceButton.setStyleName("optionButton");;
        choiceButton.setWidth("120px");
        this.content.add(choiceIcon);
        this.content.add(choiceText);
        this.content.add(choiceButton);
    }
    @Subscribe("handleUserChoice")
    public void raiseUserChoiceSelectedEvent(Action.ActionPerformedEvent event)
    {

        Button sourceOfEvent=(Button)event.getComponent();
        UserChoiceSelectedEvent userChoiceSelectedEvent =new UserChoiceSelectedEvent(sourceOfEvent) ;
        userChoiceSelectedEvent.setChoiceDescription(sourceOfEvent.getId());
        events.publish(userChoiceSelectedEvent);

    }
}