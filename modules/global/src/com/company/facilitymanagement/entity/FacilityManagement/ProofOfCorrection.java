package com.company.facilitymanagement.entity.FacilityManagement;

import com.company.facilitymanagement.entity.ReferenceModel.ReferenceValue;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import java.util.Date;

@NamePattern("%s|proofType")
@Table(name = "FACILITYMANAGEMENT_PROOF_OF_CORRECTION")
@Entity(name = "facilitymanagement_ProofOfCorrection")
public class ProofOfCorrection extends StandardEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROOF_TYPE_ID")
    protected ReferenceValue proofType;

    @Temporal(TemporalType.DATE)
    @Column(name = "PROVIDED_DATE")
    protected Date providedDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEFICIENCY_ID")
    protected Deficiency deficiency;

    public Deficiency getDeficiency() {
        return deficiency;
    }

    public void setDeficiency(Deficiency deficiency) {
        this.deficiency = deficiency;
    }

    public Date getProvidedDate() {
        return providedDate;
    }

    public void setProvidedDate(Date providedDate) {
        this.providedDate = providedDate;
    }

    public ReferenceValue getProofType() {
        return proofType;
    }

    public void setProofType(ReferenceValue proofType) {
        this.proofType = proofType;
    }
}