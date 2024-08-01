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
public class AuthorRequestDto {

	@JsonProperty(value = "first_name")
	private String firstName;

	@JsonProperty(value = "last_name")
	private String lastName;

	@JsonProperty(value = "gender")
	private String gender;

	@JsonProperty(value = "birth_date")
	private String birthDate;

	@JsonProperty(value = "nationality")
	private String nationality;

	@JsonProperty(value = "phone_number")
	private String phoneNumber;

	@JsonProperty(value = "email")
	private String email;
}
