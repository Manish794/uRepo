package com.manish.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
    public String getBooks(){
        return "Hai this is response from getBook";
    }

}
