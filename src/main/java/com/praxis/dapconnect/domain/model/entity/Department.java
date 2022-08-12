package com.praxis.dapconnect.domain.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Data
@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "department_seq")
@SQLDelete(sql = "UPDATE department SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Department extends EntityBase{
    private String name;

    public Department() {
    }

    public Department(String name, String createdBy) {
        this.setName(name);
        this.setCreatedBy(createdBy);
    }

    public Department(String name) {
        this.setName(name);
    }

}



//public interface DepartmentResult{
//    String getId();
//    String getName();
//}
