package com.company.facilitymanagement.listeners;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;
import com.company.facilitymanagement.service.DateDomainService;
import com.haulmont.cuba.core.EntityManager;
import com.haulmont.cuba.core.TypedQuery;
import com.haulmont.cuba.core.app.UniqueNumbersAPI;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.UserSessionSource;
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
    @Inject
    private UserSessionSource userSessionSource;
    @Override
    public void onBeforeInsert(Complaint entity, EntityManager entityManager) {
        String businessKey="Complaint-" +uniqueNumbersAPI.getNextNumber("complaintId");
        entity.setBusinessKey(businessKey);
        //This will be moved out of here because it may be different based on the priority of complaint.
        Date currentDate = dateDomainService.getDateAfterDays(10);
        entity.setVisitDueDate(currentDate);
        entity.setAssignedTo(userSessionSource.getUserSession().getUser());
        ReferenceValue status = getReferenceValue(entityManager,"complaintStatus",2);
        entity.setCurrentStatus(status);
        ReferenceValue priority = getReferenceValue(entityManager,"complaintPriority",2);
        entity.setCurrentStatus(priority);
        entityManager.merge(entity);
    }

    private ReferenceValue getReferenceValue(EntityManager entityManager,String refenceCode, int value) {
        TypedQuery<ReferenceValue> query=entityManager.createQuery(
                "select c from facilitymanagement_ReferenceValue c where " +
                        "c.referenceCode.code= :referenceCode and c.value=:value", ReferenceValue.class);
        query.setParameter("referenceCode",refenceCode );
        query.setParameter("value", value);
        return query.getFirstResult();
    }


}