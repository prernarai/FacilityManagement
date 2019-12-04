package com.company.facilitymanagement.web.screens;

import com.haulmont.cuba.gui.screen.*;
import com.company.facilitymanagement.entity.ReferenceModel.Task;

@UiController("facilitymanagement_Task.browse")
@UiDescriptor("task-browse.xml")
@LookupComponent("tasksTable")
@LoadDataBeforeShow
public class TaskBrowse extends StandardLookup<Task> {
}