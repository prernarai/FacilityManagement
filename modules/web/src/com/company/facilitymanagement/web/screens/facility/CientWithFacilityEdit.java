package com.company.facilitymanagement.web.screens.facility;

import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.FacilityManagement.CientWithFacility;

@UiController("facilitymanagement_CientWithFacility.edit")
@UiDescriptor("cient-with-facility-edit.xml")
@EditedEntityContainer("cientWithFacilityDc")
@LoadDataBeforeShow
public class CientWithFacilityEdit extends StandardEditor<CientWithFacility> {
}