package com.cruzeiro.icust.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ICustOfertaServicoDTO {

	private Integer idOfertaServico;

	private String titulo;

	private String descricao;

	private Double valor;

	private String foto;

	private double nota;

	private ICustTipoOfertaServicoDTO tipoDeServico;

	private PrestadorOfertaServicoDTO prestador;
}
