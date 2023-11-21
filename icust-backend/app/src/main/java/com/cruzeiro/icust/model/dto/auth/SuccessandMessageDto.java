package com.cruzeiro.icust.model.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccessandMessageDto {
	
	private boolean success;
	private String message;
	
	
}
