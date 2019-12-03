package com.company.facilitymanagement.service;

import com.haulmont.addon.bproc.entity.TaskData;
import com.haulmont.addon.bproc.service.BprocTaskService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(TaskService.NAME)
public class TaskServiceBean implements TaskService {
@Inject
    BprocTaskService bprocTaskService;
    @Override
    public List<TaskData> getTaskList() {
        List<TaskData> result=bprocTaskService.createTaskDataQuery()
                .processDefinitionKey("file-a-complaint")
                .orderByTaskCreateTime()
                .desc()
                .list();
        return result;
    }
}