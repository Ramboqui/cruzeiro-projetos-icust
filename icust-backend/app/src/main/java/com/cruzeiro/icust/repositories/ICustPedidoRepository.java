package com.cruzeiro.icust.repositories;

import com.cruzeiro.icust.model.entities.ICustPedidosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustPedidoRepository extends JpaRepository<ICustPedidosEntity, Integer> {
}
