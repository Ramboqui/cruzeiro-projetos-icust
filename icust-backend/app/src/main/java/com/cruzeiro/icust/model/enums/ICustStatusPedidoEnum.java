package com.cruzeiro.icust.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ICustStatusPedidoEnum {
	PEDIDO_FEITO, EM_ANDAMENTO, EM_ENTREGA, FINALIZADO;
}
