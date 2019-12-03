package com.company.facilitymanagement.web.screens.complaint;

import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.ComplaintModel.Complaint;

@UiController("facilitymanagement_Complaint.browse")
@UiDescriptor("complaint-browse.xml")
@LookupComponent("complaintsTable")
@LoadDataBeforeShow
public class ComplaintBrowse extends StandardLookup<Complaint> {
}