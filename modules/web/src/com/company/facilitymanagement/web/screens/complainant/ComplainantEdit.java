package com.company.facilitymanagement.web.screens.complainant;

import com.haulmont.addon.bproc.web.processform.ProcessForm;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.ComplaintModel.Complainant;

import javax.inject.Inject;

@UiController("facilitymanagement_Complainant.edit")
@UiDescriptor("complainant-edit.xml")
@EditedEntityContainer("complainantDc")
@LoadDataBeforeShow
@ProcessForm
public class ComplainantEdit extends StandardEditor<Complainant> {
    @Inject
    protected Metadata metadata;
    @Subscribe
    protected void onInit(InitEvent event) {
        Complainant complainant = metadata.create(Complainant.class);
        setEntityToEdit(complainant);
    }
}