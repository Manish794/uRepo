package com.manish.spring.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.Date;


@Data
@Entity
@Table(name="myusers")
public class UserEntity implements Serializable {

    @Id
    @GenericGenerator(
            name = "userIdGenerator",
            strategy = "com.manish.spring.jpa.IdGenerator"
    )
    @GeneratedValue( generator = "userIdGenerator")
    private String userId;
    private String fullName;
    private long phone;
    private String email;
    private String loginPassword;

    @Temporal(TemporalType.DATE)
    private Date creationDate;

}
