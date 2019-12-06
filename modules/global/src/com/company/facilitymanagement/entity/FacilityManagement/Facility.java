package com.company.facilitymanagement.entity.FacilityManagement;

import com.company.facilitymanagement.entity.ComplaintModel.Complaint;
import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;
import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@NamePattern("%s %s|businessKey,name")
@Table(name = "FACILITYMANAGEMENT_FACILITY")
@Entity(name = "facilitymanagement_Facility")
@Listeners("facilitymanagement_FacilityChangeListener")

public class Facility extends StandardEntity {
    private static final long serialVersionUID = 3908426525392471556L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "CAPACITY")
    protected String capacity;

    @Column(name = "ADDRESS_LINE1")
    protected String addressLine1;

    @Column(name = "ADDRESS_LINE2")
    protected String addressLine2;

    @Column(name = "CITY")
    protected String city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STATE_ID")
    protected ReferenceValue state;

    @Column(name = "ZIP")
    protected String zip;

    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "facility")
    protected List<Complaint> complaintList;

    @Column(name = "BUSINESS_KEY")
    protected String businessKey;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "facility")
    protected List<CientWithFacility> clients;

    @Temporal(TemporalType.DATE)
    @Column(name = "LICENSE_DATE")
    protected Date licenseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LICENSE_STATUS_ID")
    protected ReferenceValue licenseStatus;

    @OneToMany(mappedBy = "facility")
    protected List<Visit> visitList;

    @OrderBy("dueDate")
    @OneToMany(mappedBy = "forFacility")
    protected List<Deficiency> lsitOfDeficiency;

    public List<Deficiency> getLsitOfDeficiency() {
        return lsitOfDeficiency;
    }

    public void setLsitOfDeficiency(List<Deficiency> lsitOfDeficiency) {
        this.lsitOfDeficiency = lsitOfDeficiency;
    }

    public List<Visit> getVisitList() {
        return visitList;
    }

    public void setVisitList(List<Visit> visitList) {
        this.visitList = visitList;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public ReferenceValue getLicenseStatus() {
        return licenseStatus;
    }

    public void setLicenseStatus(ReferenceValue licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    public Date getLicenseDate() {
        return licenseDate;
    }

    public void setLicenseDate(Date licenseDate) {
        this.licenseDate = licenseDate;
    }

    public List<CientWithFacility> getClients() {
        return clients;
    }

    public void setClients(List<CientWithFacility> clients) {
        this.clients = clients;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public ReferenceValue getState() {
        return state;
    }

    public void setState(ReferenceValue state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}