package com.developer.service.service;

import com.developer.dto.requestDto.PhotoRequestDto;
import com.developer.model.Photo;

public interface PhotoService {

	void createNewPhoto(PhotoRequestDto photoRequestDto) throws Exception;

	Photo checkById(Long id);
}
