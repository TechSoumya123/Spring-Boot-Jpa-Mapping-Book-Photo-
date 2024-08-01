package com.developer.dto.requestDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookRequestDto {

	@JsonProperty(value = "title")
	private String title;

	@JsonProperty(value = "isbn")
	private String isbn;

	@JsonProperty(value = "rating")
	private Double rating;

	@JsonProperty(value = "publish_date")
	private String publishDate;

	@JsonProperty(value = "author_id")
	private Long authorId;

	@JsonProperty(value = "photo_id")
	private Long photoId;
	
	@JsonProperty(value = "category_id")
	private Long categoryId;

	@JsonProperty(value = "page_detail")
	private PageDto pageDto;

	@Data
	private static class PageDto {

		@JsonProperty(value = "total_pages")
		private int totalPages;

		@JsonProperty(value = "total_chapters")
		private int chapter;
	}

}
