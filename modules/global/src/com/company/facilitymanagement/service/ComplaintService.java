package com.company.facilitymanagement.service;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;

import java.util.List;

public interface ComplaintService {
    String NAME = "facilitymanagement_ComplaintService";
    List<Complaint> getComplaints();
}