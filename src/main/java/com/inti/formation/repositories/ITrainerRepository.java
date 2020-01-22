package com.inti.formation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inti.formation.entities.Trainer;

public interface ITrainerRepository extends JpaRepository<Trainer, Long>{
	
//	@Query("SELECT t FROM Trainer t WHERE t.trainerState =:t.trainerState")
//	List<Trainer> findByTrainerState(@Param("trainerState") String trainerState);
	
	List<Trainer> findByTrainerState(String trainerState);
	


}
