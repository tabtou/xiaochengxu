package com.mxl.base;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@MappedSuperclass
public class BaseEntityModel extends BaseModel {
    private static final long serialVersionUID = -6163675075289529459L;
    @Column(
            name = "ENTITY_NAME"
    )
    @JsonIgnore
    String entityName = this.getClass().getSimpleName();
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "DATECREATED"
    )
    @CreatedDate
    protected Date dateCreated = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            name = "DATEMODIFED"
    )
    @LastModifiedDate
    protected Date dateModified = new Date();
    @Column(
            name = "DELETED"
    )
    protected Boolean deleted = false;
    @Id
    @Column(
            name = "ID",
            nullable = false
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO
    )
    Long id;

    public BaseEntityModel() {
    }

    public boolean equals(Object obj) {
        if (null != obj && obj instanceof BaseEntityModel) {
            BaseEntityModel domain = (BaseEntityModel)obj;
            if (this.id == domain.id) {
                return true;
            }
        }

        return false;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    public Date getDateModified() {
        return this.dateModified;
    }

    public Long getId() {
        return this.id;
    }

    public int hashCode() {
        if (this.id == null) {
            this.id = 0L;
        }

        return HashCodeBuilder.reflectionHashCode(this.id);
    }

    public Boolean isDeleted() {
        return this.deleted;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntityName() {
        return this.entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Boolean getDeleted() {
        return this.deleted;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
