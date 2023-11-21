package com.cruzeiro.icust.model.request;

import com.cruzeiro.icust.model.entities.ICustOfertaServicoEntity;
import com.cruzeiro.icust.model.entities.user.ClienteEntity;
import com.cruzeiro.icust.model.enums.ICustStatusPedidoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ICustPedidosRequest {

	private String icone;

	private String titulo;

	private ICustStatusPedidoEnum statusPedidoEnum;

	private Integer servicoID;

	private Integer clienteID;
}
