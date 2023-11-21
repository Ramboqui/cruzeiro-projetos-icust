package com.cruzeiro.icust.model.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class ClienteDetails {
	private String username;
	private String email;
	private Integer id;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteLoginResponseDto {
	private boolean success;
	private String message;
	private String token;
	private ClienteDetails cliente;

	public void setCliente(String username, String email, Integer id) {
		this.cliente = new ClienteDetails(username, email, id);
	}
	
	
}
