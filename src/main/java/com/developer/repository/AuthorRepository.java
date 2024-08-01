package com.developer.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developer.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

	Optional<Author> findFirstById(Long id);

}
