package com.company.facilitymanagement.service;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.company.facilitymanagement.entity.ReferenceModel.Task;
import com.haulmont.addon.bproc.entity.TaskData;
import com.haulmont.cuba.security.entity.User;

import java.util.List;

public interface TaskService {
    String NAME = "facilitymanagement_TaskService";
    List<Task> getTaskList();

    void createTask(String taskType, User assignedTo, Complaint complaint);
}