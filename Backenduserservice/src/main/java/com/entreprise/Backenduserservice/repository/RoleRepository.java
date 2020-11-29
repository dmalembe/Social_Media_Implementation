package com.entreprise.Backenduserservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entreprise.Backenduserservice.models.ERole;
import com.entreprise.Backenduserservice.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Optional<Role> findByNom(ERole nom);
	
}
