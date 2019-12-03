package com.company.facilitymanagement.service;

import com.company.facilitymanagement.entity.ScheduleMgmt.Appointment;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(AppointmentService.NAME)
public class AppointmentServiceBean implements AppointmentService {
    @Inject
    DataManager dataManager;
    public List<Appointment> getAppointmentList()
    {

        List<Appointment> AppointmentList=dataManager.load(Appointment.class)
                .query("select e from facilitymanagement_Appointment e ")
                .view("appointment-view")
                .list();
        return AppointmentList;
    }

}