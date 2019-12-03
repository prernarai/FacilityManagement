package com.company.facilitymanagement.web.screens.complainant;

import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.ComplaintModel.Complainant;

@UiController("facilitymanagement_Complainant.browse")
@UiDescriptor("complainant-browse.xml")
@LookupComponent("complainantsTable")
@LoadDataBeforeShow
public class ComplainantBrowse extends StandardLookup<Complainant> {
}