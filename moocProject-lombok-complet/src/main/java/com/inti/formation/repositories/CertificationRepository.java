package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Certification;

public interface CertificationRepository extends JpaRepository<Certification, Long> {

}
