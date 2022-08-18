package com.praxis.dapconnect.module.content;

import com.praxis.dapconnect.share.entity.EntityBase;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;

@Getter
@Setter
@NoArgsConstructor
@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "content_seq")
@SQLDelete(sql = "UPDATE content SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class Content extends EntityBase {

    @Column(length = 10)
    @Size(min = 10, max = 10)
    private String sendDate;

    @Column(length = 50)
    @Size(min = 1, max = 50)
    @NotNull(message = "bookNo is required")
    @Pattern(regexp="^[\\w-_. ]+$", message = "bookNo must be a string")
    private String bookNo;

    @Column(length = 10)
    @Size(min = 10, max = 10)
    private String bookDate;

    @Column(length = 1)
    @Size(min = 1, max = 1)
    private String speed;

    @Column(length = 10)
    @Size(min = 1, max = 10)
    private String senderDepartmentCode;

    @Column(length = 10)
    @Size(min = 1, max = 10)
    private String receiverDepartmentCode;

    @Column(length = 1)
    @Size(min = 1, max = 1)
    private String letterStatus;

    @Column(length = 2000)
    @Size(min = 1, max = 2000)
    @NotNull(message = "subject is required")
    @Pattern(regexp="^[\\w-_. ]+$", message = "subject must be a string")
    private String subject;

    @Column(length = 255)
    @Size(max = 255)
    @Pattern(regexp="^[\\w-_. ]+$", message = "subject must be a string")
    private String description;

    @Column(length = 255)
    @Size(max = 255)
    @Pattern(regexp="^[\\w-_. ]+$", message = "subject must be a string")
    private String reference;

    @Column(length = 1000)
    @Size(min = 1, max = 1000)
    private String sendFrom;

    @Column(length = 1000)
    @Size(min = 1, max = 1000)
    private String sendTo;

    @Column(length = 255)
    @Size(max = 255)
    @Pattern(regexp="^[\\w-_. ]+$", message = "subject must be a string")
    private String attachment;

    @Column(length = 1)
    @Size(min = 1, max = 1)
    private String receiverStatus;

    @Column(length = 10)
    @Size(min = 10, max = 10)
    private String receiveDate;

}
