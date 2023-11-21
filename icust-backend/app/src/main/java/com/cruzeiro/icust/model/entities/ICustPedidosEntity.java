package com.cruzeiro.icust.model.entities;

import com.cruzeiro.icust.model.entities.user.ClienteEntity;
import com.cruzeiro.icust.model.enums.ICustStatusPedidoEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pedido")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ICustPedidosEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPedido;

	@Column
	private String icone;

	@Column
	private String titulo;

	@Column
	private String nomePrestadora;

	@Column
	@Enumerated(EnumType.ORDINAL)
	private ICustStatusPedidoEnum statusPedidoEnum;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_oferta_servico")
	private ICustOfertaServicoEntity servico;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_cliente")
	private ClienteEntity cliente;
}
