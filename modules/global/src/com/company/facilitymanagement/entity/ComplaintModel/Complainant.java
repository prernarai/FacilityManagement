package com.company.facilitymanagement.entity.ComplaintModel;

import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseLongIdEntity;
import com.haulmont.cuba.core.entity.Creatable;
import com.haulmont.cuba.core.entity.HasUuid;
import com.haulmont.cuba.core.entity.Updatable;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@NamePattern("%s|firstName")
@Table(name = "FACILITYMANAGEMENT_COMPLAINANT")
@Entity(name = "facilitymanagement_Complainant")
public class Complainant extends BaseLongIdEntity implements HasUuid, Creatable, Updatable {
    private static final long serialVersionUID = 6593833869239346151L;

    @Column(name = "UUID")
    protected UUID uuid;

    @Column(name = "CREATE_TS")
    protected Date createTs;

    @Column(name = "CREATED_BY", length = 50)
    protected String createdBy;

    @Column(name = "UPDATE_TS")
    protected Date updateTs;

    @Column(name = "UPDATED_BY", length = 50)
    protected String updatedBy;

    @Column(name = "FIRST_NAME")
    protected String firstName;

    @Column(name = "LAST_NAME")
    protected String lastName;

    @Column(name = "ADDRESS_LINE1")
    protected String addressLine1;

    @Column(name = "ADDRESS_LINE2")
    protected String addressLine2;

    @Column(name = "CITY")
    protected String city;

    @Column(name = "STATE")
    protected String state;

    @Column(name = "ZIP_CODE")
    protected String zipCode;

    @Column(name = "PHONE_NUMBER")
    protected String phoneNumber;

    @Column(name = "EMAIL_ID")
    protected String emailId;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RELATIONSHIP_WITH_FACILITY_ID")
    protected ReferenceValue relationshipWithFacility;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DOES_COMPLAINTANT_WANTS_TO_BE_CONFIDENTIAL_ID")
    protected ReferenceValue doesComplaintantWantsToBeConfidential;

    public ReferenceValue getDoesComplaintantWantsToBeConfidential() {
        return doesComplaintantWantsToBeConfidential;
    }

    public void setDoesComplaintantWantsToBeConfidential(ReferenceValue doesComplaintantWantsToBeConfidential) {
        this.doesComplaintantWantsToBeConfidential = doesComplaintantWantsToBeConfidential;
    }

    public ReferenceValue getRelationshipWithFacility() {
        return relationshipWithFacility;
    }

    public void setRelationshipWithFacility(ReferenceValue relationshipWithFacility) {
        this.relationshipWithFacility = relationshipWithFacility;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public Date getUpdateTs() {
        return updateTs;
    }

    @Override
    public void setUpdateTs(Date updateTs) {
        this.updateTs = updateTs;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreateTs() {
        return createTs;
    }

    public void setCreateTs(Date createTs) {
        this.createTs = createTs;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}