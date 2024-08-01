package com.developer.service.serviceImpl;

import java.util.Objects;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.developer.dto.requestDto.PhotoRequestDto;
import com.developer.model.Photo;
import com.developer.repository.PhotoRepository;
import com.developer.service.service.PhotoService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

	private final PhotoRepository photoRepository;
	private final ModelMapper modelMapper;

	@Override
	public void createNewPhoto(PhotoRequestDto photoRequestDto) throws Exception {
		Photo savePhoto = photoRepository.save(modelMapper.map(photoRequestDto, Photo.class));
		if (Objects.isNull(savePhoto.getId())) {
			log.error("Saving new Photo was failed!");
			throw new Exception();
		}
	}

	@Override
	public Photo checkById(Long id) {
		Optional<Photo> optionalPhoto = photoRepository.findFirstById(id);
		return optionalPhoto.orElse(null);
	}

}
