package com.developer.service.service;

import com.developer.dto.requestDto.CategoryRequestDto;
import com.developer.model.Category;

public interface CategoryService {

	void createNewCategory(CategoryRequestDto categoryRequestDto) throws Exception;

	Category checkById(Long id) throws Exception;
}
