package com.developer.service.serviceImpl;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.developer.dto.requestDto.BookRequestDto;
import com.developer.dto.responseDto.BookResponseDto;
import com.developer.model.Author;
import com.developer.model.Book;
import com.developer.model.Category;
import com.developer.model.Page;
import com.developer.model.Photo;
import com.developer.repository.BookRepository;
import com.developer.repository.PageRepository;
import com.developer.service.service.AuthorService;
import com.developer.service.service.BookService;
import com.developer.service.service.CategoryService;
import com.developer.service.service.PhotoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

	private final BookRepository bookRepository;
	private final ModelMapper modelMapper;
	private final AuthorService authorService;
	private final PhotoService photoService;
	private final CategoryService categoryService;
	private final PageRepository pageRepository;

	@Override
	public void createNewBook(BookRequestDto bookRequestDto) throws Exception {
		Author author = authorService.findById(bookRequestDto.getAuthorId());
		if (Objects.isNull(author)) {
			log.error("Author {} not found", bookRequestDto.getAuthorId());
			throw new Exception();
		}

		Photo photo = photoService.checkById(bookRequestDto.getPhotoId());
		if (Objects.isNull(photo)) {
			log.error("Photo-Id {} not found.", bookRequestDto.getPhotoId());
		}

		Category category = categoryService.checkById(bookRequestDto.getCategoryId());
		if (Objects.isNull(category)) {
			log.error("Category-Id {} not found", bookRequestDto.getCategoryId());
		}
		Page page = modelMapper.map(bookRequestDto.getPageDto(), Page.class);
		Book book = new Book();
		book.setTitle(bookRequestDto.getTitle());
		book.setIsbn(bookRequestDto.getIsbn());
		book.setPublishDate(bookRequestDto.getPublishDate());
		book.setRating(bookRequestDto.getRating());
		book.setAuthors(Collections.singletonList(author));
		book.setCategories(Collections.singletonList(category));
		book.setPhoto(photo);
		bookRepository.save(book);
		page.setBook(book);
		pageRepository.save(page);

	}

	@Override
	public List<BookResponseDto> listBooks() throws Exception {
		return bookRepository.findAll().stream().map(book -> modelMapper.map(book, BookResponseDto.class))
				.collect(Collectors.toList());
	}

}
