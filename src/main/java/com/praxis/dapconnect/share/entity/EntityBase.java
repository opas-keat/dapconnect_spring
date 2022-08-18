package com.praxis.dapconnect.share.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public abstract class EntityBase {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
    private Long id;

    @JsonIgnore
    @Column(name = "CREATED_BY", updatable = false, nullable = false)
    private String createdBy;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @CreationTimestamp
    @Column(name = "CREATED_TIME", updatable = false)
    private LocalDateTime createDateTime;

    @JsonIgnore
    @Column(name = "UPDATED_BY")
    private String updatedBy;

    @JsonIgnore
    @UpdateTimestamp
    @Column(name = "UPDATED_TIME")
    private LocalDateTime updateDateTime;

    @JsonIgnore
    private boolean deleted = Boolean.FALSE;

}
