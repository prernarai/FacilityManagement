package com.company.facilitymanagement.web.screens.facility;

import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.FacilityManagement.CientWithFacility;

@UiController("facilitymanagement_CientWithFacility.browse")
@UiDescriptor("cient-with-facility-browse.xml")
@LookupComponent("cientWithFacilitiesTable")
@LoadDataBeforeShow
public class CientWithFacilityBrowse extends StandardLookup<CientWithFacility> {
}