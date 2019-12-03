package com.company.facilitymanagement.entity.ComplaintModel;

import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import java.util.Date;

@Table(name = "FACILITYMANAGEMENT_COMPLAINT_STATUS")
@Entity(name = "facilitymanagement_ComplaintStatus")
public class ComplaintStatus extends StandardEntity {
    private static final long serialVersionUID = -1745821783092594052L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COMPLAINT_ID")
    protected Complaint complaint;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATUS_ID")
    protected ReferenceValue status;

    @Temporal(TemporalType.DATE)
    @Column(name = "START_DATE")
    protected Date startDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "END_DATE")
    protected Date endDate;

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public ReferenceValue getStatus() {
        return status;
    }

    public void setStatus(ReferenceValue status) {
        this.status = status;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
}