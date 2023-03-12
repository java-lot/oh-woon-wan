package com.javalot.ohwoonwan.domain;

import jakarta.persistence.*;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class TimestampEntity {
    @Column(name = "`create_at`", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(name = "`update_at`")
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedBy
    private LocalDateTime updatedAt;
    @Column(name = "`deleted_at`")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime deletedAt;
}