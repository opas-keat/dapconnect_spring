package com.praxis.dapconnect.documentTemplate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class DocumentTemplate {
    @Id
    private Integer id;

    @Column()
    private String name;

    @Column()
    private String shortDescription;

    @Column()
    private String author;

    @Column()
    private String description;

    @Column()
    private String content;

    @Column()
    private LocalDateTime lastUpdated;

    @Column()
    private LocalDateTime created;

}
