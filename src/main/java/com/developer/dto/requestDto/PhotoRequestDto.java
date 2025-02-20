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
public class PhotoRequestDto {

	@JsonProperty(value = "url_small")
	private String smallUrl;

	@JsonProperty(value = "url_medium")
	private String mediumUrl;

	@JsonProperty(value = "url_large")
	private String largeUrl;

	@JsonProperty(value = "description")
	private String description;

}
