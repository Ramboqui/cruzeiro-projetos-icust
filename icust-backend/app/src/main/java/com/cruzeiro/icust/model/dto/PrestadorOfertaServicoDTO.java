package com.cruzeiro.icust.model.dto;

import com.cruzeiro.icust.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestadorOfertaServicoDTO {

	private Integer idPrestador;

	private String nome;

	private String sobrenome;
}
