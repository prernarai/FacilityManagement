package com.company.facilitymanagement.entity.ReferenceModel;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.company.facilitymanagement.entity.FacilityManagement.Facility;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import java.util.Date;

@Table(name = "FACILITYMANAGEMENT_TASK")
@Entity(name = "facilitymanagement_Task")
public class Task extends StandardEntity {
    @Column(name = "NAME")
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ASSIGNE_ID")
    protected User assigne;

    @Column(name = "DESCRIPTION")
    protected String description;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOR_FACILITY_ID")
    protected Facility forFacility;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOR_COMPLAINT_ID")
    protected Complaint forComplaint;

    @Lookup(type = LookupType.DROPDOWN)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID")
    protected ReferenceValue status;

    @Temporal(TemporalType.DATE)
    @Column(name = "DUE_DATE")
    protected Date dueDate;

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public ReferenceValue getStatus() {
        return status;
    }

    public void setStatus(ReferenceValue status) {
        this.status = status;
    }

    public Complaint getForComplaint() {
        return forComplaint;
    }

    public void setForComplaint(Complaint forComplaint) {
        this.forComplaint = forComplaint;
    }

    public Facility getForFacility() {
        return forFacility;
    }

    public void setForFacility(Facility forFacility) {
        this.forFacility = forFacility;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAssigne() {
        return assigne;
    }

    public void setAssigne(User assigne) {
        this.assigne = assigne;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}