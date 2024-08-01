package com.developer.service.serviceImpl;

import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.developer.dto.requestDto.CategoryRequestDto;
import com.developer.model.Category;
import com.developer.repository.CategoryRepository;
import com.developer.service.service.CategoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

	private final CategoryRepository categoryRepository;
	private final ModelMapper modelMapper;

	@Override
	public void createNewCategory(CategoryRequestDto categoryRequestDto) throws Exception {
		Category savecategory = categoryRepository.save(modelMapper.map(categoryRequestDto, Category.class));
		if (Objects.isNull(savecategory.getId())) {
			log.error("Saving new category was failed");
			throw new Exception();
		}
	}

	@Override
	public Category checkById(Long id) throws Exception {
		Optional<Category> optionalCategory = categoryRepository.findFirstById(id);
		return optionalCategory.orElse(null);
	}

}
