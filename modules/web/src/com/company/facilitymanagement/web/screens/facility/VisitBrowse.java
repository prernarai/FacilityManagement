package com.company.facilitymanagement.web.screens.facility;

import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.FacilityManagement.Visit;

@UiController("facilitymanagement_Visit.browse")
@UiDescriptor("visit-browse.xml")
@LookupComponent("visitsTable")
@LoadDataBeforeShow
public class VisitBrowse extends StandardLookup<Visit> {
}