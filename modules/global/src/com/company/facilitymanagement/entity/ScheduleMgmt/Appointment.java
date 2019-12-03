package com.company.facilitymanagement.entity.ScheduleMgmt;

import com.company.facilitymanagement.entity.FacilityManagement.Facility;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import java.util.Date;

@Table(name = "FACILITYMANAGEMENT_APPOINTMENT")
@Entity(name = "facilitymanagement_Appointment")
public class Appointment extends StandardEntity {

    @Column(name = "TOPIC")
    protected String topic;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WHO_IS_WORKER_ID")
    protected User whoIsWorker;

    @Lookup(type = LookupType.SCREEN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VISITING_TO_ID")
    protected Facility visitingTo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "START_DATE_TIME")
    protected Date startDateTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "END_TIME")
    protected Date endTime;

    public Date getEndTime() { return endTime; }

    public void setEndTime(Date endTime) { this.endTime = endTime; }

    public Date getStartDateTime() { return startDateTime; }

    public void setStartDateTime(Date startDateTime) { this.startDateTime = startDateTime; }

    public Facility getVisitingTo() { return visitingTo; }

    public void setVisitingTo(Facility visitingTo) { this.visitingTo = visitingTo; }

    public User getWhoIsWorker() { return whoIsWorker; }

    public void setWhoIsWorker(User whoIsWorker) { this.whoIsWorker = whoIsWorker; }

    public String getTopic() { return topic; }

    public void setTopic(String topic) { this.topic = topic; }

    }