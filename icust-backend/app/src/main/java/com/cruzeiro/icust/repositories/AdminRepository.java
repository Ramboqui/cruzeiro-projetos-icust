package com.cruzeiro.icust.repositories;

import com.cruzeiro.icust.model.entities.user.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {

    Optional<AdminEntity> findByUsername(String username);

    Boolean existsByUsername(String username);
}
