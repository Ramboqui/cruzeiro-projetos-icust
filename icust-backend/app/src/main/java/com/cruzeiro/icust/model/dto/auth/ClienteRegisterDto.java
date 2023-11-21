package com.cruzeiro.icust.model.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRegisterDto {
	private String email;
	private String password;
	private String nome;
	private String sobrenome;
}
