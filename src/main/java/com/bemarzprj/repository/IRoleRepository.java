package com.bemarzprj.repository;

import com.bemarzprj.model.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long>
{
    Optional<Role> findByName(String role);
}
