package com.company.facilitymanagement.web.screens.ScheduleMgmt;

import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.ScheduleMgmt.Appointment;

@UiController("facilitymanagement_Appointment.browse")
@UiDescriptor("appointment-browse.xml")
@LookupComponent("appointmentsTable")
@LoadDataBeforeShow
public class AppointmentBrowse extends StandardLookup<Appointment> {
}