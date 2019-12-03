package com.company.facilitymanagement.listeners;

import com.company.facilitymanagement.entity.FacilityManagement.Client;
import com.company.facilitymanagement.entity.FacilityManagement.Facility;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.app.UniqueNumbersAPI;
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

@Component(ClientEntityListener.NAME)
public class ClientEntityListener implements BeforeInsertEntityListener<Client> {
    public static final String NAME = "facilitymanagement_ClientChangeListener";
    @Inject
    UniqueNumbersAPI uniqueNumbersAPI;
  
    @Override
    public void onBeforeInsert(Client entity, EntityManager entityManager) {
        String businessKey="Client-" +uniqueNumbersAPI.getNextNumber("clientId");
        entity.setBusinessKey(businessKey);
        entityManager.merge(entity);
    }
}