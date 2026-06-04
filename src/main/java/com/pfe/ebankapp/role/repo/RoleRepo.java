package com.pfe.ebankapp.role.repo;

import java.util.Optional; // Optional is used to avoid nulls when querying

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.ebankapp.role.entity.Role; 
// This is the entity class for which this repository handles DB operations

// Interface for Role repository
// By extending JpaRepository, it automatically gets methods like save(), findById(), findAll(), deleteById(), etc.
public interface RoleRepo extends JpaRepository<Role, Long> {

    // Custom query method: finds a Role by its name
    // Returns Optional<Role> to safely handle cases when no role is found
    Optional<Role> findByName(String name);
}