package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Trainer;

public interface ITrainerRepository extends JpaRepository<Trainer, Long>{

}
