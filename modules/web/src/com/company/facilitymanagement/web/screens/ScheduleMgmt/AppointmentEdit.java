package com.company.facilitymanagement.web.screens.ScheduleMgmt;

import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.ScheduleMgmt.Appointment;

@UiController("facilitymanagement_Appointment.edit")
@UiDescriptor("appointment-edit.xml")
@EditedEntityContainer("appointmentDc")
@LoadDataBeforeShow
public class AppointmentEdit extends StandardEditor<Appointment> {
}