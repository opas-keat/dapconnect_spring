package com.praxis.dapconnect.domain.model.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public abstract class EntityBase {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,generator = "default_gen")
    private Long id;

    @Column(name = "CREATED_BY", updatable = false,nullable = false)
    private String createdBy;

    @CreationTimestamp
    @Column(name = "CREATED_TIME", updatable = false)
    private LocalDateTime createDateTime;

    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @UpdateTimestamp
    @Column(name = "UPDATED_TIME")
    private LocalDateTime updateDateTime;

    private boolean deleted = Boolean.FALSE;

}
