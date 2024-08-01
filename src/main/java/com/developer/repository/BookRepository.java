package com.developer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developer.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
