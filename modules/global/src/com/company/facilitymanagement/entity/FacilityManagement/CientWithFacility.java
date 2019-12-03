package com.company.facilitymanagement.entity.FacilityManagement;

import com.haulmont.cuba.core.entity.StandardEntity;

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