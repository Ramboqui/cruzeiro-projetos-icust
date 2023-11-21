package com.cruzeiro.icust.model.dto;

import com.cruzeiro.icust.model.entities.user.ClienteEntity;
import com.cruzeiro.icust.model.enums.ICustStatusPedidoEnum;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ICustPedidoDTO {
	private Integer idPedido;

	private String icone;

	private String titulo;

	private String nomePrestadora;

	private ICustStatusPedidoEnum statusPedidoEnum;

	private ICustOfertaServicoDTO servico;

	private ClienteEntity cliente;
}
