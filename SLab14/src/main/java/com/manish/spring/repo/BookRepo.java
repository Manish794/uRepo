package com.manish.spring.repo;

import com.manish.spring.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, String> {

    Optional<BookEntity> findBookEntityByBookNameAndAuthorAndPublicationAndYearOfPublication(String bookName, String author, String publication, int year);


}
