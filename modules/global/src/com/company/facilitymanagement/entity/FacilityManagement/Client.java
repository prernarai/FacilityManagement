package com.company.facilitymanagement.entity.FacilityManagement;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Listeners;

import javax.persistence.*;
import java.util.Date;

@NamePattern("%s|businessKey")
@Table(name = "FACILITYMANAGEMENT_CLIENT")
@Entity(name = "facilitymanagement_Client")
@Listeners("facilitymanagement_ClientChangeListener")
public class Client extends StandardEntity {
    @Column(name = "FIRST_NAME")
    protected String firstName;

    @Column(name = "LAST_NAME")
    protected String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_BIRTH")
    protected Date dateOfBirth;

    @Column(name = "BUSINESS_KEY")
    protected String businessKey;

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
}