package com.company.facilitymanagement.entity.FacilityManagement;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import java.util.Date;

@Table(name = "FACILITYMANAGEMENT_VISIT")
@Entity(name = "facilitymanagement_Visit")
@Listeners("facilitymanagement_VisitListener")
public class Visit extends StandardEntity {
    @Column(name = "BUSINESS_KEY")
    protected String businessKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_OF_VISIT_ID")
    protected ReferenceValue typeOfVisit;

    @Lookup(type = LookupType.DROPDOWN)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WAS_ANNOUNCED_ID")
    protected ReferenceValue wasAnnounced;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACILITY_ID")
    protected Facility facility;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPLAINT_ID")
    protected Complaint complaint;

    @Temporal(TemporalType.DATE)
    @Column(name = "VISIT_DATE")
    protected Date visitDate;

    @Temporal(TemporalType.TIME)
    @Column(name = "START_TIME")
    protected Date startTime;

    @Temporal(TemporalType.TIME)
    @Column(name = "END_TIME")
    protected Date endTime;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID")
    protected ReferenceValue status;

    public ReferenceValue getStatus() { return status; }

    public void setStatus(ReferenceValue status) { this.status = status; }

    public Date getEndTime() { return endTime; }

    public void setEndTime(Date endTime) { this.endTime = endTime; }

    public Date getStartTime() { return startTime; }

    public void setStartTime(Date startTime) { this.startTime = startTime; }

    public Date getVisitDate() { return visitDate; }

    public void setVisitDate(Date visitDate) { this.visitDate = visitDate; }

    public Complaint getComplaint() { return complaint; }

    public void setComplaint(Complaint complaint) { this.complaint = complaint; }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public ReferenceValue getWasAnnounced() {
        return wasAnnounced;
    }

    public void setWasAnnounced(ReferenceValue wasAnnounced) {
        this.wasAnnounced = wasAnnounced;
    }

    public ReferenceValue getTypeOfVisit() {
        return typeOfVisit;
    }

    public void setTypeOfVisit(ReferenceValue typeOfVisit) {
        this.typeOfVisit = typeOfVisit;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }
}