package com.company.facilitymanagement.web.PresenterEvents;

import com.haulmont.cuba.gui.events.UiEvent;
import org.springframework.context.ApplicationEvent;

public class ComplaintCreatedEvent extends ApplicationEvent implements UiEvent {
    private String complaintId;
    public ComplaintCreatedEvent(Object source) {
        super(source);
    }

    /**
     * Create a new ApplicationEvent.
     *
     */
    public String getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(String complaintId) {
        this.complaintId = complaintId;
    }
}
