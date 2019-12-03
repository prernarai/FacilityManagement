package com.company.facilitymanagement.entity.FacilityManagement;

import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;

@Table(name = "FACILITYMANAGEMENT_VISIT")
@Entity(name = "facilitymanagement_Visit")
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