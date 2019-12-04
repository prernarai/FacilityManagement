package com.company.facilitymanagement.service;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.company.facilitymanagement.entity.FacilityManagement.Facility;
import com.company.facilitymanagement.entity.FacilityManagement.Visit;
import com.haulmont.cuba.security.entity.User;

import java.util.List;

public interface VisitService {
    String NAME = "facilitymanagement_VisitService";


    List<Visit> getVisitList();

    void createVisit(String taskType, User assignedTo, Complaint complaint, Facility facility);
}