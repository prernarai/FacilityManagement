package com.company.facilitymanagement.web.screens.complainant;

import com.company.facilitymanagement.entity.ComplaintModel.Complainant;
import com.haulmont.addon.bproc.web.processform.ProcessForm;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("facilitymanagement_ComplainantScreen")
@UiDescriptor("complainant-screen.xml")
@ProcessForm
public class ComplainantScreen extends Screen {
    @Inject
    protected Metadata metadata;
    @Inject
    InstanceContainer complainantDc;
    @Inject
    DataContext dataContext;
    @Subscribe
    protected void onInit(InitEvent event) {
        Complainant complainant = metadata.create(Complainant.class);
        dataContext.merge(complainant);
       complainantDc.setItem(complainant);

    }
    @Subscribe("handleCreateComplainant")
    public void raiseHandleCreateComplainant(Action.ActionPerformedEvent event) {


        this.dataContext.commit();
    }
}