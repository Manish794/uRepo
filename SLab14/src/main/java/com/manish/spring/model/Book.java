package com.manish.spring.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable {
    private String bookId;
    private String bookName;
    private String author;
    private String publication;
    private int yearOfPublication;
    private double price;

}
