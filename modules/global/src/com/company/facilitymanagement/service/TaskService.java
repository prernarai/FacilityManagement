package com.company.facilitymanagement.service;

import com.haulmont.addon.bproc.entity.TaskData;

import java.util.List;

public interface TaskService {
    String NAME = "facilitymanagement_TaskService";
    List<TaskData> getTaskList();
}