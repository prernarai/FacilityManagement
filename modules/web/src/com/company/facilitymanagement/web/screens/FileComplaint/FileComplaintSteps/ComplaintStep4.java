package com.company.facilitymanagement.web.screens.FileComplaint.FileComplaintSteps;

import com.company.facilitymanagement.entity.ComplaintModel.Victim;
import com.company.facilitymanagement.entity.FacilityManagement.Client;
import com.company.facilitymanagement.entity.FacilityManagement.Facility;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import de.diedavids.cuba.wizard.gui.components.AbstractWizardStep;

import javax.inject.Inject;

@UiController("complaint-step4")
@UiDescriptor("complaint-step4.xml")
public class ComplaintStep4 extends AbstractWizardStep {

    @Inject
    private TextField<String> lastName;
    @Inject
    private TextField<String> firstName;
    @Inject
    Datasource<Victim> victimDs;

    @Subscribe("victimPickup")
    private void onVictimPickupValueChange(HasValue.ValueChangeEvent event) {
        if(event!=null && event.getValue()!=null)
        {
            Client selectedClient=(Client) event.getValue();
            victimDs.getItem().setFirstName(selectedClient.getFirstName());
            victimDs.getItem().setLastName(selectedClient.getLastName());

        }
    }
}