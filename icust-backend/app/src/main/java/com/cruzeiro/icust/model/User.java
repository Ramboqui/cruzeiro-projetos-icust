package com.cruzeiro.icust.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class User {

	private String nome;

	private String sobrenome;

	private String email;

	private String password;

	private boolean status;

}
