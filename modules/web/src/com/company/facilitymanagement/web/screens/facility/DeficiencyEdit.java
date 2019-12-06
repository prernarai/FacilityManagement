package com.company.facilitymanagement.web.screens.facility;

import com.company.facilitymanagement.entity.FacilityManagement.ProofOfCorrection;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.FacilityManagement.Deficiency;

import javax.inject.Inject;

@UiController("facilitymanagement_Deficiency.edit")
@UiDescriptor("deficiency-edit.xml")
@EditedEntityContainer("deficiencyDc")
@LoadDataBeforeShow
public class DeficiencyEdit extends StandardEditor<Deficiency> {
    @Inject
    private CollectionLoader<ProofOfCorrection> pocDl;

    @Subscribe
    protected void onBeforeShow(BeforeShowEvent event) {

        pocDl.setParameter("deficiency1", getEditedEntity());
        getScreenData().loadAll();
    }
}