package com.company.facilitymanagement.web.screens.facility;

import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.FacilityManagement.Facility;

@UiController("facilitymanagement_Facility.edit")
@UiDescriptor("facility-edit.xml")
@EditedEntityContainer("facilityDc")
@LoadDataBeforeShow
public class FacilityEdit extends StandardEditor<Facility> {
}