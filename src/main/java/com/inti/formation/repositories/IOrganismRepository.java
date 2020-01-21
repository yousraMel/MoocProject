package com.inti.formation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Organism;

public interface IOrganismRepository extends JpaRepository<Organism, Long>{
	
	List<Organism> findByOrganismState(String organismState);

}
