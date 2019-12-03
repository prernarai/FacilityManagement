package com.company.facilitymanagement.entity.ReferenceModel;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.entity.HasUuid;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@NamePattern("%s|description")
@Table(name = "FACILITYMANAGEMENT_REFERENCE_CODE")
@Entity(name = "facilitymanagement_ReferenceCode")
public class ReferenceCode extends BaseIntegerIdEntity implements HasUuid {
    private static final long serialVersionUID = -6050317171607798573L;

    @Column(name = "UUID")
    protected UUID uuid;

    @Composition
    @OnDeleteInverse(DeletePolicy.UNLINK)
    @OneToMany(mappedBy = "referenceCode")
    protected List<ReferenceValue> referenceValueList;

    @NotNull
    @Column(name = "CODE", nullable = false, unique = true)
    protected String code;

    @NotNull
    @Column(name = "DESCRIPTION", nullable = false)
    protected String description;

    public List<ReferenceValue> getReferenceValueList() {
        return referenceValueList;
    }

    public void setReferenceValueList(List<ReferenceValue> referenceValueList) {
        this.referenceValueList = referenceValueList;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }
}