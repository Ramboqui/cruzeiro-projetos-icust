package com.cruzeiro.icust.model.entities.user;

import com.cruzeiro.icust.model.User;
import com.cruzeiro.icust.model.entities.ICustPedidosEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClienteEntity extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;

	@Column
	private String nome;
	@Column
	private String sobrenome;
	@Column
	@Email
	private String email;
	@Column
	private String password;
	@Column
	private boolean status;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
	private List<ICustPedidosEntity> orderList;
}
