package com.manish.spring.transformer;

import com.manish.spring.entity.BookEntity;
import com.manish.spring.model.Book;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BookTransformer {

    public static List<Book> transformEntitiesToBook(List<BookEntity> bookEntities){
        if(bookEntities != null && bookEntities.size() > 0) {
            List<Book> users = new ArrayList<>(bookEntities.size());
            for(BookEntity entity : bookEntities){
                users.add(transformEntityToBook(entity));
            }
            return users;
        }
        return null;
    }

    public static Book transformEntityToBook(BookEntity bookEntity){
        if(bookEntity != null) {
        Book.BookBuilder builder = Book.builder()
                .bookId(bookEntity.getBookId())
                .bookName(bookEntity.getBookName())
                .author(bookEntity.getAuthor())
                .publication(bookEntity.getPublication())
                .price(bookEntity.getPrice())
                .yearOfPublication(bookEntity.getYearOfPublication());
        Book book = builder.build();
        return book;
        }
        return null;
    }

    public static BookEntity transformBookToEntity(Book book){
        if(book != null) {
            return BookEntity.builder()
                    .bookId(book.getBookId())
                    .bookName(book.getBookName())
                    .author(book.getAuthor())
                    .publication(book.getPublication())
                    .price(book.getPrice())
                    .yearOfPublication(book.getYearOfPublication())
                    .creationDate(new Date())
                    .build();
        }
        return null;
    }

}
