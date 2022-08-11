package com.praxis.dapconnect.domain.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Data
@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "department_seq")
public class Department extends EntityBase{

    String name;
}
