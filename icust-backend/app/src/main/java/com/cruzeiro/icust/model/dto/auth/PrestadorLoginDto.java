package com.cruzeiro.icust.model.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestadorLoginDto {
	private String email;
	private String password;
}
