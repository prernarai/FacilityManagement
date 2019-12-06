package com.company.facilitymanagement.web.screens.facility;

import com.haulmont.addon.dashboard.web.annotation.DashboardWidget;
import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.FacilityManagement.Deficiency;

@UiController("facilitymanagement_Deficiency.browse")
@UiDescriptor("deficiency-browse.xml")
@LookupComponent("deficienciesTable")

@LoadDataBeforeShow
public class DeficiencyBrowse extends StandardLookup<Deficiency> {
}