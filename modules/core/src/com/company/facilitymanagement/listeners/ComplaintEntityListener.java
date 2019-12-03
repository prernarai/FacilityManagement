package com.company.facilitymanagement.listeners;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.app.UniqueNumbersAPI;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;

@Component(ComplaintEntityListener.NAME)
public class ComplaintEntityListener implements BeforeInsertEntityListener<Complaint> {
    @Inject DataManager dataManager;
    public static final String NAME = "facilitymanagement_ComplaintEntityListener";
    @Inject
    UniqueNumbersAPI uniqueNumbersAPI;
    @Override
    public void onBeforeInsert(Complaint entity, EntityManager entityManager) {
        String businessKey="Complaint-" +uniqueNumbersAPI.getNextNumber("complaintId");
        entity.setBusinessKey(businessKey);
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.DATE, 10);
        currentDate = c.getTime();
        entity.setVisitDueDate(currentDate);
        entityManager.merge(entity);
    }

}