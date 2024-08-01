package com.developer.dto.responseDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookResponseDto {

	@JsonProperty(value = "id")
	private Long id;

	@JsonProperty(value = "title")
	private String title;

	@JsonProperty(value = "isbn")
	private String isbn;

	@JsonProperty(value = "rating")
	private Double rating;

	@JsonProperty(value = "publish_date")
	private String publishDate;
}
