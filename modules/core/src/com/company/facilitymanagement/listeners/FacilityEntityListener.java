package com.company.facilitymanagement.listeners;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.company.facilitymanagement.entity.FacilityManagement.Facility;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.TransactionalDataManager;
import com.haulmont.cuba.core.app.UniqueNumbersAPI;
import com.haulmont.cuba.core.app.events.EntityChangedEvent;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.inject.Inject;
import java.util.UUID;

@Component(FacilityEntityListener.NAME)
public class FacilityEntityListener implements BeforeInsertEntityListener<Facility> {
    public static final String NAME = "facilitymanagement_FacilityChangeListener";
    @Inject
    UniqueNumbersAPI uniqueNumbersAPI;

    @Override
    public void onBeforeInsert(Facility entity, EntityManager entityManager) {
        String businessKey="Facility-" +uniqueNumbersAPI.getNextNumber("facilityId");
        entity.setBusinessKey(businessKey);
        entityManager.merge(entity);
    }
}