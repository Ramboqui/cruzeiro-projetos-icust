package com.cruzeiro.icust.model.entities.user;

import com.cruzeiro.icust.model.User;
import com.cruzeiro.icust.model.entities.ICustOfertaServicoEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "prestador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrestadorEntity extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPrestador;

	@Column
	private String nome;
	@Column
	private String sobrenome;

	@Email
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private boolean status;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "prestador", cascade = CascadeType.ALL)
	private List<ICustOfertaServicoEntity> ofertasdeServico;

}
