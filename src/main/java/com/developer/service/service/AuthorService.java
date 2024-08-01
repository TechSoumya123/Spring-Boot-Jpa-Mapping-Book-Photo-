package com.developer.service.service;

import com.developer.dto.requestDto.AuthorRequestDto;
import com.developer.model.Author;

public interface AuthorService {

	void addAuthor(AuthorRequestDto authorRequestDto) throws Exception;

	Author findById(Long id) throws Exception;
}
