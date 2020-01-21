package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Certification;

public interface ICertificationRepository extends JpaRepository<Certification, Long> {

}
