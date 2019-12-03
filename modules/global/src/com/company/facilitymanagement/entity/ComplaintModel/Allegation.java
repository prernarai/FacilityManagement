package com.company.facilitymanagement.entity.ComplaintModel;

import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;

@Table(name = "FACILITYMANAGEMENT_ALLEGATION")
@Entity(name = "facilitymanagement_Allegation")
@Listeners("facilitymanagement_AllegationListener")
public class Allegation extends StandardEntity {
    private static final long serialVersionUID = -1513942067573844119L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_ID")
    protected ReferenceValue type;

    @Column(name = "BUSINESS_KEY", unique = true)
    protected String businessKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPLAINT_ID")
    protected Complaint complaint;

    @Column(name = "SHAPE_MARK_OF_INJURY")
    protected String shapeMarkOfInjury;

    @Column(name = "OPEN_HAND_OR_CLOSED_FIST")
    protected String openHandOrClosedFist;

    @Column(name = "RECURRING_EVENT")
    protected String recurringEvent;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BODILY_INJURY_ID")
    protected ReferenceValue bodilyInjury;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUALIFIER1_ID")
    protected ReferenceValue qualifier1;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "QUALIFIER2_ID")
    protected ReferenceValue qualifier2;

    @Lookup(type = LookupType.SCREEN, actions = {"lookup"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RELATED_VICTIM_ID")
    protected Victim relatedVictim;

    @Lookup(type = LookupType.SCREEN, actions = {"lookup"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RELATED_PERP_ID")
    protected Perpetrator relatedPerp;

    public Perpetrator getRelatedPerp() {
        return relatedPerp;
    }

    public void setRelatedPerp(Perpetrator relatedPerp) {
        this.relatedPerp = relatedPerp;
    }

    public Victim getRelatedVictim() {
        return relatedVictim;
    }

    public void setRelatedVictim(Victim relatedVictim) {
        this.relatedVictim = relatedVictim;
    }

    public ReferenceValue getQualifier2() { return qualifier2; }

    public void setQualifier2(ReferenceValue qualifier2) { this.qualifier2 = qualifier2; }

    public ReferenceValue getQualifier1() { return qualifier1; }

    public void setQualifier1(ReferenceValue qualifier1) { this.qualifier1 = qualifier1; }

    public ReferenceValue getBodilyInjury() {
        return bodilyInjury;
    }

    public void setBodilyInjury(ReferenceValue bodilyInjury) {
        this.bodilyInjury = bodilyInjury;
    }

    public String getRecurringEvent() {
        return recurringEvent;
    }

    public void setRecurringEvent(String recurringEvent) {
        this.recurringEvent = recurringEvent;
    }

    public String getOpenHandOrClosedFist() {
        return openHandOrClosedFist;
    }

    public void setOpenHandOrClosedFist(String openHandOrClosedFist) {
        this.openHandOrClosedFist = openHandOrClosedFist;
    }

    public String getShapeMarkOfInjury() {
        return shapeMarkOfInjury;
    }

    public void setShapeMarkOfInjury(String shapeMarkOfInjury) {
        this.shapeMarkOfInjury = shapeMarkOfInjury;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }

    public ReferenceValue getType() {
        return type;
    }

    public void setType(ReferenceValue type) {
        this.type = type;
    }
}