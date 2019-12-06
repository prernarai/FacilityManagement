package com.company.facilitymanagement.web.screens.facility;

import com.company.facilitymanagement.entity.FacilityManagement.CientWithFacility;
import com.company.facilitymanagement.entity.FacilityManagement.Deficiency;
import com.company.facilitymanagement.entity.FacilityManagement.Visit;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.FacilityManagement.Facility;

import javax.inject.Inject;

@UiController("facilitymanagement_Facility.edit")
@UiDescriptor("facility-edit.xml")
@EditedEntityContainer("facilityDc")
@LoadDataBeforeShow
public class FacilityEdit extends StandardEditor<Facility> {
    @Inject
    private CollectionLoader<Visit> visitsDl;
    @Inject
    private CollectionLoader<CientWithFacility> clientsDl;
    @Inject
    private CollectionLoader<Deficiency> deficiencyDl;

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {
        visitsDl.setParameter("facility", getEditedEntity());
        clientsDl.setParameter("facility", getEditedEntity());
        deficiencyDl.setParameter("facility", getEditedEntity());
        getScreenData().loadAll();
    }
}