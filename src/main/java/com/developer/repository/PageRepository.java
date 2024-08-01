package com.developer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.developer.model.Page;

public interface PageRepository extends JpaRepository<Page, Long> {

}
