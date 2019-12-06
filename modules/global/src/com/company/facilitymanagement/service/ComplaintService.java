package com.company.facilitymanagement.service;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.haulmont.cuba.security.entity.User;

import java.util.List;

public interface ComplaintService {
    String NAME = "facilitymanagement_ComplaintService";
    List<Complaint> getComplaints();

    void setComplaintStatus(Complaint complaint, int statusValue);

    void setComplaintPriorty(Complaint complaint, int priorityValue);

    void setAssignment(Complaint complaint, User assigneTo);
}