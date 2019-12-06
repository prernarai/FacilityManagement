package com.company.facilitymanagement.service;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.company.facilitymanagement.entity.FacilityManagement.Facility;
import com.company.facilitymanagement.entity.FacilityManagement.Visit;
import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;
import com.company.facilitymanagement.entity.ReferenceModel.Task;
import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.TypedQuery;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.security.entity.User;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;


@Service(VisitService.NAME)
public class VisitServiceBean implements VisitService {

    @Inject
    DataManager dataManager;
    @Override
    public List<Visit> getVisitList() {
        List<Visit> visitList=dataManager.load(Visit.class)
                .query("select e from facilitymanagement_Visit e ")
                .view("visit-view")
                .list();
        return visitList;
    }
    @Inject
    private Metadata metadata;
    @Inject
    private Persistence persistence;

    @Inject  DateDomainService dateDomainService;
    @Override
    public void createVisit(String visitType, User assignedTo, Complaint complaint, Facility facility) {
        Visit visit = metadata.create(Visit.class);
        visit.setFacility(facility);
        visit.setComplaint(complaint);
        visit.setVisitDate( dateDomainService.getDateAfterDays(10));

        try (Transaction tx = persistence.createTransaction()) {
            TypedQuery<ReferenceValue> query = getReferenceValue("typeOfVisit",1);
            ReferenceValue value = query.getFirstResult();
            visit.setTypeOfVisit(value);
            TypedQuery<ReferenceValue> query1 = getReferenceValue("visitStatus",1);
            ReferenceValue value1 = query1.getFirstResult();
            visit.setStatus(value1);
            persistence.getEntityManager().persist(visit);
            tx.commit();
        }
    }
    ///need to pull this out in service
    private TypedQuery<ReferenceValue> getReferenceValue(String ReferenceCode, int value) {
        TypedQuery<ReferenceValue> query = persistence.getEntityManager().createQuery(
                "select c from facilitymanagement_ReferenceValue c where " +
                        "c.referenceCode.code= :referenceCode and c.value=:value", ReferenceValue.class);
        query.setParameter("referenceCode", ReferenceCode);
        query.setParameter("value", value);

        return query;
    }


}