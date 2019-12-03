package com.company.facilitymanagement.entity.ReferenceModel;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamePattern("%s|label")
@Table(name = "FACILITYMANAGEMENT_TAG")
@Entity(name = "facilitymanagement_Tag")
public class Tag extends StandardEntity {
    private static final long serialVersionUID = 5570581261831049387L;

    @NotNull
    @Column(name = "LABEL", nullable = false)
    protected String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}