package com.company.facilitymanagement.web.screens.complaint;

import com.company.facilitymanagement.entity.ComplaintModel.Allegation;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.DataComponents;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.model.InstanceLoader;
import com.haulmont.cuba.gui.screen.ScreenFragment;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;
import java.util.UUID;

@UiController("facilitymanagement_AllegationLineItemFragment")
@UiDescriptor("Allegation-Line-Item-fragment.xml")
public class AllegationLineItemFragment extends ScreenFragment {
    private String allegationId;
    @Inject
    private InstanceContainer<Allegation> allegationDc;
    @Inject
    private DataComponents dataComponents;
    public String getAllegationId() {
        return allegationId;
    }

    public void setAllegationId(String allegationId) {
        this.allegationId = allegationId;
    }
    public void loadData(String complaintId)
    {
       this.createCustomerLoader(complaintId);
    }
    private void createCustomerLoader(String complaintId) {
        InstanceLoader<Allegation> loader = dataComponents.createInstanceLoader();
        loader.setQuery("select e from facilitymanagement_Allegation e where e.complaint.id = :complaintId");
        loader.setParameter("complaintId",complaintId);
        loader.setContainer(allegationDc);
        loader.setDataContext(getScreenData().getDataContext());
    }
}