package com.cruzeiro.icust.model.dto;

import com.cruzeiro.icust.model.User;
import com.cruzeiro.icust.model.entities.ICustPedidosEntity;
import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Email;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientePedidoDTO extends User {
	private Integer idCliente;

	private String nome;

	private String sobrenome;
}
