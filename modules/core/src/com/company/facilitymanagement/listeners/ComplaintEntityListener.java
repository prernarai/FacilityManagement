package com.company.facilitymanagement.listeners;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.company.facilitymanagement.service.DateDomainService;
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
    @Inject
    DateDomainService dateDomainService;
    @Override
    public void onBeforeInsert(Complaint entity, EntityManager entityManager) {
        String businessKey="Complaint-" +uniqueNumbersAPI.getNextNumber("complaintId");
        entity.setBusinessKey(businessKey);
        Date currentDate = dateDomainService.getDateAfterDays(10);
        entity.setVisitDueDate(currentDate);
        entityManager.merge(entity);
    }



}