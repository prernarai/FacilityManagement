package com.company.facilitymanagement.web.screens.FileComplaint.FileComplaintSteps;

import com.company.facilitymanagement.entity.ComplaintModel.Allegation;
import com.company.facilitymanagement.entity.FacilityManagement.Client;
import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.components.CheckBoxGroup;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import de.diedavids.cuba.wizard.gui.components.AbstractWizardStep;

import javax.inject.Inject;
import java.util.List;

@UiController("complaint-step3")
@UiDescriptor("complaint-step3.xml")
public class ComplaintStep3 extends AbstractWizardStep {
    @Inject
    Datasource<Allegation> allegationDs;
    @Inject DataManager dataManager;
    @Subscribe("allegationTypes")
    private void onVictimPickupValueChange(HasValue.ValueChangeEvent event) {
        if(event!=null && event.getValue()!=null)
        {
           // ReferenceValue selectedValue=(ReferenceValue) event.getValue();

            List<ReferenceValue> referenceValues= dataManager.load(ReferenceValue.class)
                    .query("select e from facilitymanagement_ReferenceValue e " +
                            "where e.referenceCode.code=:refCode and e.value=1")
                    .parameter("refCode", "allegationType")
                    .list();
            if(referenceValues!=null && !referenceValues.isEmpty())
            allegationDs.getItem().setType(referenceValues.get(0));

        }
    }
}