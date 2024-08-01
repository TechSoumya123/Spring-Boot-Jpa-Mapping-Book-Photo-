package com.developer.service.service;

import java.util.List;

import com.developer.dto.requestDto.BookRequestDto;
import com.developer.dto.responseDto.BookResponseDto;

public interface BookService {

	void createNewBook(BookRequestDto bookRequestDto) throws Exception;

	List<BookResponseDto> listBooks() throws Exception;
}
