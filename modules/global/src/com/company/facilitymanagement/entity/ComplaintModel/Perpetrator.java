package com.company.facilitymanagement.entity.ComplaintModel;

import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;

@NamePattern("%s %s|firstName,lastName")
@Table(name = "FACILITYMANAGEMENT_PERPETRATOR")
@Entity(name = "facilitymanagement_Perpetrator")
public class Perpetrator extends StandardEntity {
    @Column(name = "FIRST_NAME")
    protected String firstName;

    @Column(name = "LAST_NAME")
    protected String lastName;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RELATIONSHIP_TO_VICTIM_ID")
    protected ReferenceValue relationshipToVictim;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RELATIONSHIP_TO_FACILITY_ID")
    protected ReferenceValue relationshipToFacility;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "relatedPerp")
    protected Allegation allegation;

    public Allegation getAllegation() {
        return allegation;
    }

    public void setAllegation(Allegation allegation) {
        this.allegation = allegation;
    }

    public ReferenceValue getRelationshipToFacility() { return relationshipToFacility; }

    public void setRelationshipToFacility(ReferenceValue relationshipToFacility) { this.relationshipToFacility = relationshipToFacility; }

    public ReferenceValue getRelationshipToVictim() { return relationshipToVictim; }

    public void setRelationshipToVictim(ReferenceValue relationshipToVictim) { this.relationshipToVictim = relationshipToVictim; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }
}