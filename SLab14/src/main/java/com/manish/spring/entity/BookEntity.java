package com.manish.spring.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Data

@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name="mybooks")
public class BookEntity {

    @Id
    @GenericGenerator(
            name = "bookIdGenerator",
            strategy = "com.manish.spring.jpa.IdGenerator"
    )
    @GeneratedValue( generator = "bookIdGenerator")
    private String bookId;
    private String bookName;
    private String author;
    private String publication;
    private int yearOfPublication;
    private double price;

    @Temporal(TemporalType.DATE)
    private Date creationDate;
}
