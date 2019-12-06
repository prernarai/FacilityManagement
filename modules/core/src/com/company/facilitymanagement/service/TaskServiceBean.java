package com.company.facilitymanagement.service;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;
import com.company.facilitymanagement.entity.ReferenceModel.Task;
import com.haulmont.addon.bproc.entity.TaskData;
import com.haulmont.addon.bproc.service.BprocTaskService;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.TypedQuery;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.core.global.View;
import com.haulmont.cuba.security.entity.User;
import org.apache.pdfbox.jbig2.util.log.Logger;
import org.apache.pdfbox.jbig2.util.log.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service(TaskService.NAME)
public class TaskServiceBean implements TaskService {
    @Inject
    private Persistence persistence;

    @Inject
    private Metadata metadata;


    private static final Logger log = LoggerFactory.getLogger(TaskServiceBean.class);
    @Inject
    DataManager dataManager;
    @Override
    public List<Task> getTaskList() {
        List<Task> taskList=dataManager.load(Task.class)
                .query("select e from facilitymanagement_Task e ")
                .view("task-view")
                .list();
        return taskList;

    }

    @Override
    public void createTask(String taskType, User assignedTo, Complaint complaint) {

        log.info("in create task call");
       if (taskType.equalsIgnoreCase("2HourCall")) {
            log.info("in create task call function");
            create2HourCall(assignedTo, complaint);
       }
        if (taskType.equalsIgnoreCase("approveItinerary")) {
            createApproveItinerary();
        }
    }

    private void create2HourCall(User assignedTo, Complaint complaint) {
        Task newTask = metadata.create(Task.class);
        newTask.setAssigne(assignedTo);
        newTask.setDescription("Call law enforcement");
        newTask.setName("2 hour call to law enforcement");
        newTask.setAssigne(assignedTo);
        newTask.setDueDate(new Date());
        newTask.setForComplaint(complaint);

        try (Transaction tx = persistence.createTransaction()) {
            TypedQuery<ReferenceValue> query = getReferenceValueTypedQuery("taskStatus");
            ReferenceValue value = query.getFirstResult();
            newTask.setStatus(value);
            persistence.getEntityManager().persist(newTask);
            tx.commit();
        }

    }
    private void createApproveItinerary() {
        Task newTask = metadata.create(Task.class);
        User assignedTo= dataManager.load(User.class)
                .query("select u from sec$User u where u.lastName=:lastName ")
                .parameter("lastName", "jane")
                .view(View.MINIMAL)
                .one();
        newTask.setDescription("Approve Itinerary");
        newTask.setName("Approve Itinerary");
        newTask.setAssigne(assignedTo);
        newTask.setDueDate(new Date());


        try (Transaction tx = persistence.createTransaction()) {
            TypedQuery<ReferenceValue> query = getReferenceValueTypedQuery("taskStatus");
            ReferenceValue value = query.getFirstResult();
            newTask.setStatus(value);
            persistence.getEntityManager().persist(newTask);
            tx.commit();
        }

    }
///this needs to move out as its own service
    private TypedQuery<ReferenceValue> getReferenceValueTypedQuery(String ReferenceCode) {
        TypedQuery<ReferenceValue> query = persistence.getEntityManager().createQuery(
                "select c from facilitymanagement_ReferenceValue c where " +
                        "c.referenceCode.code= :referenceCode and c.value=1", ReferenceValue.class);
        query.setParameter("referenceCode", ReferenceCode);

        return query;
    }


}

