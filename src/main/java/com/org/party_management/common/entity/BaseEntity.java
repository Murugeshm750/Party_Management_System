package com.org.party_management.common.entity;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;


@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity implements Serializable {
    @Column(name = "Created_Date", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "Updated_Date", updatable = false)
    private LocalDateTime updatedDate;

    @PrePersist
    protected void onCreate(){
        createdDate = LocalDateTime.now();
        updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updatedDate = LocalDateTime.now();
    }

    public LocalDateTime getCreatedDate(){
        return createdDate;
    }

    public LocalDateTime getUpdatedDate(){
        return updatedDate;
    }


}
