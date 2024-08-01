package com.developer.service.serviceImpl;

import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.developer.dto.requestDto.AuthorRequestDto;
import com.developer.model.Author;
import com.developer.repository.AuthorRepository;
import com.developer.service.service.AuthorService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;
	private final ModelMapper modelMapper;

	@Override
	public void addAuthor(AuthorRequestDto authorRequestDto) throws Exception {
		Author saveAuthor = authorRepository.save(modelMapper.map(authorRequestDto, Author.class));
		if (Objects.isNull(saveAuthor.getId())) {
			log.error("Saving new author was failed!");
			throw new Exception();
		}
	}

	@Override
	public Author findById(Long id) throws Exception {
		Optional<Author> optionalAuthor = authorRepository.findFirstById(id);
		return optionalAuthor.orElse(null);
	}

}
