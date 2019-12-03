package com.company.facilitymanagement.entity.ReferenceModel;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Table(name = "FACILITYMANAGEMENT_EVENT_TIME_LINE")
@Entity(name = "facilitymanagement_EventTimeLine")
public class EventTimeLine extends StandardEntity {
    @NotNull
    @Column(name = "OBJECT_KEY", nullable = false)
    protected UUID objectKey;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OBJECT_TYPE_ID")
    protected ReferenceValue objectType;

    @Temporal(TemporalType.DATE)
    @Column(name = "EVENT_DATE")
    protected Date eventDate;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EVENT_TYPE_ID")
    protected ReferenceValue eventType;

    public ReferenceValue getEventType() { return eventType; }

    public void setEventType(ReferenceValue eventType) { this.eventType = eventType; }

    public Date getEventDate() { return eventDate; }

    public void setEventDate(Date eventDate) { this.eventDate = eventDate; }

    public ReferenceValue getObjectType() { return objectType; }

    public void setObjectType(ReferenceValue objectType) { this.objectType = objectType; }

    public UUID getObjectKey() { return objectKey; }

    public void setObjectKey(UUID objectKey) { this.objectKey = objectKey; }
}