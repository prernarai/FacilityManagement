package com.company.facilitymanagement.service;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
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

@Service(ComplaintService.NAME)
public class ComplaintServiceBean implements ComplaintService {
    @Inject
    DataManager dataManager;
    @Inject
    private Persistence persistence;

    @Inject
    private Metadata metadata;
    public List<Complaint> getComplaints()
    {

        List<Complaint> complaintList=dataManager.load(Complaint.class)
                .query("select e from facilitymanagement_Complaint e ")
                .view("complaint-detail-view")
                .list();
        return complaintList;
    }
    @Override
    public void setComplaintStatus(Complaint complaint, int statusValue)
    {
        try (Transaction tx = persistence.createTransaction()) {
            TypedQuery<ReferenceValue> query = getReferenceValueTypedQuery(
                    "complaintStatus",statusValue);
            ReferenceValue value = query.getFirstResult();
            complaint.setCurrentStatus(value);

            persistence.getEntityManager().merge(complaint);
            tx.commit();
        }

    }
    @Override
    public void setComplaintPriorty(Complaint complaint, int priorityValue)
    {
        try (Transaction tx = persistence.createTransaction()) {
            TypedQuery<ReferenceValue> query = getReferenceValueTypedQuery(
                    "complaintPriority",priorityValue);
            ReferenceValue value = query.getFirstResult();
            complaint.setPriority(value);

            persistence.getEntityManager().merge(complaint);
            tx.commit();
        }

    }
    @Override
    public void setAssignment(Complaint complaint, User assignedTo)
    {
        try (Transaction tx = persistence.createTransaction()) {
            complaint.setAssignedTo(assignedTo);

            persistence.getEntityManager().merge(complaint);
            tx.commit();
        }

    }
///this needs to move out as its own service
        private TypedQuery<ReferenceValue> getReferenceValueTypedQuery(String ReferenceCode, int value) {
        TypedQuery<ReferenceValue> query = persistence.getEntityManager().createQuery(
                "select c from facilitymanagement_ReferenceValue c where " +
                        "c.referenceCode.code= :referenceCode and c.value=:value", ReferenceValue.class);
        query.setParameter("referenceCode", ReferenceCode);
            query.setParameter("value", value);

        return query;
    }


}