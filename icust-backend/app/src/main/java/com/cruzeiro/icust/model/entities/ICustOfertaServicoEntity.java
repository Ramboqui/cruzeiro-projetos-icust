package com.cruzeiro.icust.model.entities;

import com.cruzeiro.icust.model.entities.user.PrestadorEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "oferta_servico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ICustOfertaServicoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idOfertaServico;

	@Column
	private String titulo;

	@Column
	private String descricao;

	@Column
	private Double valor;

	@Column
	private String foto;

//	@Column(columnDefinition = "json")
//	@Type(Jsonty)
//	private List<String> modeloDaPeca;

	@Column
	private double nota;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_tipo_oferta_servico")
	private ICustTipoOfertaServicoEntity tipoDeServico;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_prestador")
	private PrestadorEntity prestador;
}
