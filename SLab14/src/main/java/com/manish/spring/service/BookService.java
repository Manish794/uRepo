package com.manish.spring.service;

import com.manish.spring.entity.BookEntity;
import com.manish.spring.model.Book;
import com.manish.spring.model.Response;
import com.manish.spring.model.User;
import com.manish.spring.repo.BookRepo;
import com.manish.spring.transformer.BookTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Response<List<Book>> getBooks(){
        Response<List<Book>> response = new Response<>();
        List<BookEntity> entities = bookRepo.findAll();
        if(entities == null || entities.size() == 0){
            response.setStatus("ERROR");
            response.setErrorCode("BOOK_NOT_FOUND");
            response.setErrorMessage("No Books found ");
        } else {
            response.setData(BookTransformer.transformEntitiesToBook(entities));
        }
        return response;
    }

    @Transactional
    public Response<Book> addBook(Book book){
        Response<Book> response = new Response<>();
        Optional<BookEntity> bookEntity = bookRepo.findBookEntityByBookNameAndAuthorAndPublicationAndYearOfPublication(book.getBookName(), book.getAuthor(), book.getPublication(),  book.getYearOfPublication());
        if(bookEntity.isPresent()) {
            response.setStatus("ERROR");
            response.setErrorCode("ERROR_ADD_BOOK");
            response.setErrorMessage("Book is already available");
        } else {
            BookEntity entity =  bookRepo.save(BookTransformer.transformBookToEntity(book));
            response.setData(BookTransformer.transformEntityToBook(entity));
        }
        return response;
    }

}
