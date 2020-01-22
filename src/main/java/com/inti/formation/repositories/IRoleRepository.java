package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entites.Role;

 

public interface IRoleRepository extends JpaRepository<Role, Long> {
	Role findByRoleName(String roleName);
}
