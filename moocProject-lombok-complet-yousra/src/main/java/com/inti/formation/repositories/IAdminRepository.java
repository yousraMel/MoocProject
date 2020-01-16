package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Admin;

public interface IAdminRepository extends JpaRepository<Admin, Long> {

}
