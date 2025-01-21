package com.example.inicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.inicio.model.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}

