package com.company.facilitymanagement.entity.ComplaintModel;

import com.company.facilitymanagement.entity.FacilityManagement.Client;
import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@NamePattern("%s %s|firstName,lastName")
@Table(name = "FACILITYMANAGEMENT_VICTIM")
@Entity(name = "facilitymanagement_Victim")
public class Victim extends StandardEntity {
    private static final long serialVersionUID = 3812676616824459657L;

    @Column(name = "FIRST_NAME")
    protected String firstName;

    @Column(name = "LAST_NAME")
    protected String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_BIRTH")
    protected Date dateOfBirth;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "WERE_THEY_IN_FACILITY_ID")
    protected ReferenceValue wereTheyInFacility;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENT_NUMBER_ID")
    protected com.company.facilitymanagement.entity.FacilityManagement.Client clientNumber;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "relatedVictim")
    protected Allegation allegation;

    public Allegation getAllegation() {
        return allegation;
    }

    public void setAllegation(Allegation allegation) {
        this.allegation = allegation;
    }

    public void setClientNumber(Client clientNumber) { this.clientNumber = clientNumber; }

    public Client getClientNumber() { return clientNumber; }

    public ReferenceValue getWereTheyInFacility() {
        return wereTheyInFacility;
    }

    public void setWereTheyInFacility(ReferenceValue wereTheyInFacility) {
        this.wereTheyInFacility = wereTheyInFacility;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
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