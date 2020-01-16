package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Committee;

public interface CommitteRepository extends JpaRepository<Committee, Long> {

}
