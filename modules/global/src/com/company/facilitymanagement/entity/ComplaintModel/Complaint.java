package com.company.facilitymanagement.entity.ComplaintModel;

import com.company.facilitymanagement.entity.FacilityManagement.Facility;
import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.PublishEntityChangedEvents;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NamePattern("%s|businessKey")
@PublishEntityChangedEvents
@Table(name = "FACILITYMANAGEMENT_COMPLAINT")
@Entity(name = "facilitymanagement_Complaint")
@Listeners("facilitymanagement_ComplaintEntityListener")
public class Complaint extends StandardEntity {
    private static final long serialVersionUID = -6446373312195274937L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IS_ABUSE_REPORT_REQUIRED_ID")
    protected ReferenceValue isAbuseReportRequired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IS_ABUSE_REPORT_FILED_ID")
    protected ReferenceValue isAbuseReportFiled;

    @Temporal(TemporalType.DATE)
    @Column(name = "VISIT_DUE_DATE")
    protected Date visitDueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SOURCE_OF_COMPLAINT_ID")
    protected ReferenceValue sourceOfComplaint;

    @Lob
    @Column(name = "WHAT_HAPPENED")
    protected String whatHappened;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DID_INCIDENT_TAKE_PLACE_IN_FACILITY_ID")
    protected ReferenceValue didIncidentTakePlaceInFacility;

    @Column(name = "OTHER_DETAILS_OF_LOCATION", length = 1000)
    protected String otherDetailsOfLocation;

    @OneToMany(mappedBy = "complaint")
    protected List<ComplaintStatus> status;

    @OneToMany(mappedBy = "complaint")
    protected List<Allegation> allegations;

    @Column(name = "BUSINESS_KEY")
    protected String businessKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACILITY_ID")
    protected Facility facility;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REPORTING_PARTY_ID")
    protected Complainant reportingParty;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRIORITY_ID")
    protected ReferenceValue priority;

    public ReferenceValue getPriority() {
        return priority;
    }

    public void setPriority(ReferenceValue priority) {
        this.priority = priority;
    }

    public Complainant getReportingParty() { return reportingParty; }

    public void setReportingParty(Complainant reportingParty) { this.reportingParty = reportingParty; }

    public String getOtherDetailsOfLocation() {
        return otherDetailsOfLocation;
    }

    public void setOtherDetailsOfLocation(String otherDetailsOfLocation) {
        this.otherDetailsOfLocation = otherDetailsOfLocation;
    }

    public ReferenceValue getDidIncidentTakePlaceInFacility() {
        return didIncidentTakePlaceInFacility;
    }

    public void setDidIncidentTakePlaceInFacility(ReferenceValue didIncidentTakePlaceInFacility) {
        this.didIncidentTakePlaceInFacility = didIncidentTakePlaceInFacility;
    }

    public String getWhatHappened() {
        return whatHappened;
    }

    public void setWhatHappened(String whatHappened) {
        this.whatHappened = whatHappened;
    }

    public void setSourceOfComplaint(ReferenceValue sourceOfComplaint) {
        this.sourceOfComplaint = sourceOfComplaint;
    }

    public ReferenceValue getSourceOfComplaint() {
        return sourceOfComplaint;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public List<Allegation> getAllegations() {
        return allegations;
    }

    public void setAllegations(List<Allegation> allegations) {
        this.allegations = allegations;
    }

    public List<ComplaintStatus> getStatus() {
        return status;
    }

    public void setStatus(List<ComplaintStatus> status) {
        this.status = status;
    }

    public Date getVisitDueDate() {
        return visitDueDate;
    }

    public void setVisitDueDate(Date visitDueDate) {
        this.visitDueDate = visitDueDate;
    }

    public ReferenceValue getIsAbuseReportFiled() {
        return isAbuseReportFiled;
    }

    public void setIsAbuseReportFiled(ReferenceValue isAbuseReportFiled) {
        this.isAbuseReportFiled = isAbuseReportFiled;
    }

    public ReferenceValue getIsAbuseReportRequired() {
        return isAbuseReportRequired;
    }

    public void setIsAbuseReportRequired(ReferenceValue isAbuseReportRequired) {
        this.isAbuseReportRequired = isAbuseReportRequired;
    }

}