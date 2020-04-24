package com.myntra.kuber.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {

    @CreatedDate
    @Column(name = "time_insert", columnDefinition = "TIMESTAMP")
    protected long insertTime;


    @LastModifiedDate
    @Column(name = "time_updated", columnDefinition = "TIMESTAMP")
    protected long updateTime;

    @LastModifiedBy
    @Column(name = "updated_by")
    protected String updatedBy;
}
