package com.company.facilitymanagement.service;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.company.facilitymanagement.entity.ScheduleMgmt.Appointment;
import com.haulmont.cuba.core.global.DataManager;

import javax.inject.Inject;
import java.util.List;

public interface AppointmentService {
    String NAME = "facilitymanagement_AppointmentService";

    public List<Appointment> getAppointmentList();

}