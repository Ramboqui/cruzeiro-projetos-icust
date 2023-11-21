package com.cruzeiro.icust.model.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class AdminDetails {
	String username;
	int id;

}

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminLoginResponseDto {
	private boolean success;
	private String message;
	private String token;
	private AdminDetails admin;

	public void setAdmin(String username, Integer id) {
		this.admin = new AdminDetails();
		this.admin.setUsername(username);
		this.admin.setId(id);
	}

}
