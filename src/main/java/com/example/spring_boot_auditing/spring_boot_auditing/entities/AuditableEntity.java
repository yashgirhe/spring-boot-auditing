package com.example.spring_boot_auditing.spring_boot_auditing.entities;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

//@MappedSuperclass indicates that a class is a superclass and is not associated with
// a specific database table, but its fields (or properties) can be inherited by
// child entity classes that are associated with tables.

@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@MappedSuperclass
@Audited
public class AuditableEntity {

    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String updatedBy;
}
