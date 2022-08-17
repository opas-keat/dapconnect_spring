package com.praxis.dapconnect.department;

import com.praxis.dapconnect.share.entity.EntityBase;
import lombok.Data;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Data
@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "department_seq")
@SQLDelete(sql = "UPDATE department SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
//@FilterDef(
//        name = "deletedUserFilter",
//        parameters = @ParamDef(name = "isDeleted", type = "boolean")
//)
//@Filter(
//        name = "deletedUserFilter",
//        condition = "deleted = :isDeleted"
//)
public class Department extends EntityBase {
    private String name;

    public Department() {
    }
    public Department(String name, String createdBy) {
        this.setName(name);
        this.setCreatedBy(createdBy);
    }

}