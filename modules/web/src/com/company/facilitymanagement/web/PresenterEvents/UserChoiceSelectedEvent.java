package com.company.facilitymanagement.web.PresenterEvents;

import com.haulmont.cuba.gui.events.UiEvent;
import org.springframework.context.ApplicationEvent;

public class UserChoiceSelectedEvent extends ApplicationEvent implements UiEvent {
    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    private String choiceDescription;
    public UserChoiceSelectedEvent(Object source) {
        super(source);

    }

    public String getChoiceDescription() {
        return choiceDescription;
    }

    public void setChoiceDescription(String choiceDescription) {
        this.choiceDescription = choiceDescription;
    }
}


