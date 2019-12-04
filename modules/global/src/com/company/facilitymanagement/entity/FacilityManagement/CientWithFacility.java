package com.company.facilitymanagement.entity.FacilityManagement;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import java.util.Date;

@Table(name = "FACILITYMANAGEMENT_CIENT_WITH_FACILITY")
@Entity(name = "facilitymanagement_CientWithFacility")
public class CientWithFacility extends StandardEntity {
    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    protected Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    protected Date endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FACILITY_ID")
    protected Facility facility;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_ID")
    protected Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Date getEndDate() { return endDate; }

    public void setEndDate(Date endDate) { this.endDate = endDate; }

    public Date getStartDate() { return startDate; }

    public void setStartDate(Date startDate) { this.startDate = startDate; }
}