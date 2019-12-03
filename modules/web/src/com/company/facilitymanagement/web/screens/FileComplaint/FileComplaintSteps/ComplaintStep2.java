package com.company.facilitymanagement.web.screens.FileComplaint.FileComplaintSteps;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.company.facilitymanagement.entity.FacilityManagement.Facility;
import com.haulmont.cuba.gui.ScreenBuilders;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import de.diedavids.cuba.wizard.gui.components.AbstractWizardStep;

import javax.inject.Inject;
import java.util.Map;

@UiController("complaint-step2")
@UiDescriptor("complaint-step2.xml")
public class ComplaintStep2 extends AbstractWizardStep {
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private LookupPickerField facility;
    @Inject
    protected Datasource<Facility> facilityDs;
    @Inject
    protected Datasource<Complaint> complaintDs;

    @Inject
    private TextField<String> addressLine1;
    @Inject
    private LinkButton facilityNumberLink;

    @Subscribe("facility")
    private void onFacilityValueChange(HasValue.ValueChangeEvent event) {
        if(event!=null && event.getValue()!=null)
        {
            Facility selectedFacility=(Facility)event.getValue();
            addressLine1.setValue(selectedFacility.getAddressLine1());
            this.facilityNumberLink.setCaption(selectedFacility.getBusinessKey());
            complaintDs.getItem().setFacility(selectedFacility);
            facilityDs.setItem(selectedFacility);
        }
    }

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

    }

   public void onFacilityLinkClicked(Component component)
   {
       screenBuilders.editor(Facility.class, this)
               .editEntity(facilityDs.getItem())
               .build()
               .show();
   }
}