package com.company.facilitymanagement.listeners;

import com.company.facilitymanagement.entity.ComplaintModel.Allegation;
import com.company.facilitymanagement.entity.FacilityManagement.Client;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.app.UniqueNumbersAPI;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component(AllegationListener.NAME)
public class AllegationListener implements BeforeInsertEntityListener<Allegation> {
    public static final String NAME = "facilitymanagement_AllegationListener";

    @Inject
    UniqueNumbersAPI uniqueNumbersAPI;

    @Override
    public void onBeforeInsert(Allegation entity, EntityManager entityManager) {
        String businessKey="All-" +uniqueNumbersAPI.getNextNumber("allegationId");
        entity.setBusinessKey(businessKey);
        entityManager.merge(entity);
    }
}