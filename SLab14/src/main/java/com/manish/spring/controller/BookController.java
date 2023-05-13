package com.manish.spring.controller;

import com.manish.spring.model.Book;
import com.manish.spring.model.Response;
import com.manish.spring.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response<List<Book>> getBooks(){
        log.info("BookController-> getBooks called");
        return bookService.getBooks();
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Response<Book> addBook(@RequestBody Book book){
        log.info("BookController-> addUser called");
        return bookService.addBook(book);
    }



}
