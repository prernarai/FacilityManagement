package com.company.facilitymanagement.entity.ReferenceModel;

import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Table(name = "FACILITYMANAGEMENT_OBJECT_AND_TAGS")
@Entity(name = "facilitymanagement_ObjectAndTags")
public class ObjectAndTags extends StandardEntity {
    private static final long serialVersionUID = -966535925149677550L;

    @Lookup(type = LookupType.DROPDOWN)
    @NotNull
    @OnDelete(DeletePolicy.CASCADE)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TAG_ID")
    protected ObjectAndTags tag;

    @NotNull
    @Column(name = "RELATED_OBJECT_IF", nullable = false)
    protected UUID relatedObjectIf;

    public UUID getRelatedObjectIf() {
        return relatedObjectIf;
    }

    public void setRelatedObjectIf(UUID relatedObjectIf) {
        this.relatedObjectIf = relatedObjectIf;
    }

    public ObjectAndTags getTag() {
        return tag;
    }

    public void setTag(ObjectAndTags tag) {
        this.tag = tag;
    }
}