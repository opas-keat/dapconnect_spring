package com.praxis.dapconnect.module.department;

import com.praxis.dapconnect.share.entity.EntityBase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Getter
@Setter
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "department_seq")
@SQLDelete(sql = "UPDATE department SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
@FilterDef(
        name = "deletedUserFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedUserFilter",
        condition = "deleted = :isDeleted"
)
public class Department extends EntityBase {
    private String name;
    private Long parentId;

    public Department(String name, String createdBy,Long parentId) {
        this.setName(name);
        this.setCreatedBy(createdBy);
        this.setParentId(parentId);
    }

}