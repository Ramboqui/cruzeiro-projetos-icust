package com.cruzeiro.icust.repositories;

import com.cruzeiro.icust.model.entities.user.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer> {

    Optional<ClienteEntity> findByEmail(String email);

    Boolean existsByEmail(String email);
}
