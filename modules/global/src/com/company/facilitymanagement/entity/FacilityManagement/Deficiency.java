package com.company.facilitymanagement.entity.FacilityManagement;

import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@NamePattern("%s|sectionNumber")
@Table(name = "FACILITYMANAGEMENT_DEFICIENCY")
@Entity(name = "facilitymanagement_Deficiency")
public class Deficiency extends StandardEntity {
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SECTION_NUMBER_ID")
    protected ReferenceValue sectionNumber;

    @Column(name = "COMMENTS")
    protected String comments;

    @Column(name = "POC")
    protected String poc;

    @Temporal(TemporalType.DATE)
    @Column(name = "DUE_DATE")
    protected Date dueDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_CORRECTED")
    protected Date dateCorrected;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FOR_FACILITY_ID")
    protected Facility forFacility;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VISIT_IDENTIFIED_ID")
    protected Visit visitIdentified;

    @Temporal(TemporalType.DATE)
    @Column(name = "VISIT_CORRECTED")
    protected Date visitCorrected;

    @OneToMany(mappedBy = "deficiency")
    protected List<ProofOfCorrection> pocList;

    @Lookup(type = LookupType.DROPDOWN)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEFICIENCY_STATUS_ID")
    protected ReferenceValue deficiencyStatus;

    public ReferenceValue getDeficiencyStatus() {
        return deficiencyStatus;
    }

    public void setDeficiencyStatus(ReferenceValue deficiencyStatus) {
        this.deficiencyStatus = deficiencyStatus;
    }

    public List<ProofOfCorrection> getPocList() {
        return pocList;
    }

    public void setPocList(List<ProofOfCorrection> pocList) {
        this.pocList = pocList;
    }

    public Date getVisitCorrected() {
        return visitCorrected;
    }

    public void setVisitCorrected(Date visitCorrected) {
        this.visitCorrected = visitCorrected;
    }

    public Visit getVisitIdentified() {
        return visitIdentified;
    }

    public void setVisitIdentified(Visit visitIdentified) {
        this.visitIdentified = visitIdentified;
    }

    public Facility getForFacility() {
        return forFacility;
    }

    public void setForFacility(Facility forFacility) {
        this.forFacility = forFacility;
    }

    public Date getDateCorrected() {
        return dateCorrected;
    }

    public void setDateCorrected(Date dateCorrected) {
        this.dateCorrected = dateCorrected;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getPoc() {
        return poc;
    }

    public void setPoc(String poc) {
        this.poc = poc;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public ReferenceValue getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(ReferenceValue sectionNumber) {
        this.sectionNumber = sectionNumber;
    }
}