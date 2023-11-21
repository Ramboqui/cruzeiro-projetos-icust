package com.cruzeiro.icust.repositories;

import com.cruzeiro.icust.model.entities.ICustOfertaServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustOfertaServicoRepository extends JpaRepository<ICustOfertaServicoEntity, Integer>,
		JpaSpecificationExecutor<ICustOfertaServicoEntity> {
}
