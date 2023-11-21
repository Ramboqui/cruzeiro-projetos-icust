package com.cruzeiro.icust.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tipo_oferta_servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ICustTipoOfertaServicoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTipoOfertaServico;

	@Column(unique = true)
	private String nomeTipoOfertaServico;

	@Column
	private String icone;
}
