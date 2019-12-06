package com.company.facilitymanagement.web.screens.ConductInterview;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;
import com.company.facilitymanagement.entity.ReferenceModel.Task;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Events;
import com.haulmont.cuba.gui.components.AbstractWindow;
import com.haulmont.cuba.gui.data.Datasource;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;
import de.diedavids.cuba.wizard.gui.components.Wizard;


import javax.inject.Inject;
import java.util.Map;
import java.util.UUID;

@UiController("conductInterview-screen")
@UiDescriptor("conductInterview-screen.xml")
public class ConductinterviewScreen extends   AbstractWindow {
    private Task passedTask;
    @Inject
    Events events;
    @Inject
    protected Wizard conductInterview;
    @Inject
    DataManager dataManager;
    @Inject
    protected Datasource<Task> taskDs;
    @Inject
    protected Datasource<Complaint> complaintDs;
    @Override
    public void init(Map<String, Object> params) {
        super.init(params);
        //if(this.passedTask!=null)
       // {

        //}
    }
    public void ready() {
        Task loadedTask= dataManager.load(Task.class).id(passedTask.getId()).view("task-view").one();
        taskDs.setItem(loadedTask);
        Complaint loadedComplaint=dataManager.load(Complaint.class).id(loadedTask.getForComplaint().getId()).view("complaint-detail-view").one();
        complaintDs.setItem(loadedComplaint);

        conductInterview.addWizardFinishClickListener(event -> {
            showNotification("Task has been successfully completed", NotificationType.TRAY);
            close(COMMIT_ACTION_ID);
           // ReferenceValue taskStatus=dataManager.loadValue("Select e from facilitymanagement_ReferenceValue e" +
                 //   "where e.referenceCode.code='taskStatus' and e.value=3",ReferenceValue.class)

            ReferenceValue taskStatus= dataManager.load(ReferenceValue.class)
                    .query("Select e from facilitymanagement_ReferenceValue e where e.referenceCode.code='taskStatus' and e.value=3")
                    .view("_local")
                    .one();
            loadedTask.setStatus(taskStatus);
            dataManager.commit(loadedTask);
        });
    }

    public Task getPassedTask() {
        return passedTask;
    }

    public void setPassedTask(Task passedTask) {
        this.passedTask = passedTask;
    }
}