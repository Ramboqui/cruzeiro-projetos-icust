package com.cruzeiro.icust.repositories;

import com.cruzeiro.icust.model.entities.user.PrestadorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrestadorRepository extends JpaRepository<PrestadorEntity, Integer> {

    Optional<PrestadorEntity> findByEmail(String email);

    Boolean existsByEmail(String email);
}
