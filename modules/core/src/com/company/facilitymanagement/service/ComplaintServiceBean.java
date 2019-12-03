package com.company.facilitymanagement.service;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.haulmont.cuba.core.global.DataManager;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service(ComplaintService.NAME)
public class ComplaintServiceBean implements ComplaintService {
    @Inject
    DataManager dataManager;
    public List<Complaint> getComplaints()
    {

        List<Complaint> complaintList=dataManager.load(Complaint.class)
                .query("select e from facilitymanagement_Complaint e ")
                .view("complaint-detail-view")
                .list();
        return complaintList;
    }

}