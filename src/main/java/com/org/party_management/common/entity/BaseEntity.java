package com.org.party_management.common.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.io.Serializable;
import java.time.LocalDateTime;


@MappedSuperclass
public abstract class BaseEntity implements Serializable {
    @Column(name = "Created_Date", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "Update_Date", updatable = false)
    private LocalDateTime updateDate;

    @PrePersist
    protected void onCreate(){
        createdDate = LocalDateTime.now();
        updateDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate(){
        updateDate = LocalDateTime.now();
    }

    public LocalDateTime getCreatedDate(){
        return createdDate;
    }

    public LocalDateTime getUpdateDate(){
        return updateDate;
    }


}
