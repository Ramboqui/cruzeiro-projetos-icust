package com.cruzeiro.icust.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ICustTipoOfertaServicoDTO {
	private Integer idTipoOfertaServico;

	private String nomeTipoOfertaServico;

	private String icone;
}
