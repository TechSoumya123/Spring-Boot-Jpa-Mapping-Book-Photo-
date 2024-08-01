package com.developer.controller.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.developer.dto.requestDto.AuthorRequestDto;
import com.developer.dto.requestDto.BookRequestDto;
import com.developer.dto.requestDto.CategoryRequestDto;
import com.developer.dto.requestDto.PhotoRequestDto;
import com.developer.service.service.AuthorService;
import com.developer.service.service.BookService;
import com.developer.service.service.CategoryService;
import com.developer.service.service.PhotoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ApplicationControler {

	private final AuthorService authorService;
	private final CategoryService categoryService;
	private final BookService bookService;
	private final PhotoService photoService;

	@PostMapping(path = { "/photo/new" })
	public ResponseEntity<Object> uploadNewPhoto(@RequestBody PhotoRequestDto photoRequestDto) {
		try {
			log.info("TRACING-REQUEST upload new photo with req: \n{}", photoRequestDto);
			photoService.createNewPhoto(photoRequestDto);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Error while request upload new photo {} ,\n{}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/category/new")
	public ResponseEntity<Object> createNewCategory(@RequestBody CategoryRequestDto categoryRequestDto) {
		try {

			log.info("TRACING-REQUEST create new category with req: \n{}", categoryRequestDto);
			categoryService.createNewCategory(categoryRequestDto);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Error while request create new category  {}, \n{}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}

	@PostMapping("/author/new")
	public ResponseEntity<Object> createNewAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
		try {
			log.info("TRACCING-REQUEST add author with req: \n{}", authorRequestDto);
			authorService.addAuthor(authorRequestDto);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.info("Error while request create new author {}, \n{}", e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/book/new")
	public ResponseEntity<Object> createNewBook(@RequestBody BookRequestDto bookRequestDto) {
		try {
			log.info("TRACING-REQUEST add author with: \n{}", bookRequestDto);
			bookService.createNewBook(bookRequestDto);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("Error while request create new book {}, \n{}", e.getMessage(), e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAllBooks")
	public ResponseEntity<Object> getAllBooks() {
		try {
			log.info("TRACCING-REQUEST get all books");
			return new ResponseEntity<>(bookService.listBooks(), HttpStatus.OK);
		} catch (Exception e) {
			log.info("Error while get all books {}, \n{}", e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	}

}
