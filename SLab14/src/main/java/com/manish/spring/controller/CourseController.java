package com.manish.spring.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @GetMapping(value="/get-all-course", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getCourses(){
        return "Hai this is response from getBook";
    }

}
