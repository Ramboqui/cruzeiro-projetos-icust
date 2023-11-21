package com.cruzeiro.icust.model.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class PrestadorDetails {
	private String username;
	private String email;
	private Integer id;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestadorLoginResponseDto {
	private boolean success;
	private String message;
	private String token;
	private PrestadorDetails teacher;

	public void setTeacher(String username, String email, Integer id) {
		this.teacher = new PrestadorDetails(username, email, id);
	}
}
