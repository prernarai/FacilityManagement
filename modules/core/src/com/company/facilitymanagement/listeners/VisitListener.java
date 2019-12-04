package com.company.facilitymanagement.listeners;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.company.facilitymanagement.entity.FacilityManagement.Visit;
import com.company.facilitymanagement.service.DateDomainService;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.app.UniqueNumbersAPI;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import java.util.Date;

@Component(VisitListener.NAME)
public class VisitListener implements BeforeInsertEntityListener<Visit> {
    public static final String NAME = "facilitymanagement_VisitListener";

    @Inject
    DataManager dataManager;
    @Inject
    UniqueNumbersAPI uniqueNumbersAPI;
    @Inject
    DateDomainService dateDomainService;
    @Override
    public void onBeforeInsert(Visit entity, EntityManager entityManager) {
        String businessKey="visit-" +uniqueNumbersAPI.getNextNumber("visitId");
        entity.setBusinessKey(businessKey);

        entityManager.merge(entity);
    }
}