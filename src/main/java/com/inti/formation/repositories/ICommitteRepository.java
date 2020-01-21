package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.inti.formation.entities.Committee;

public interface ICommitteRepository extends JpaRepository<Committee, Long> {
	
	 @Query(value="SELECT COUNT(trainer_id) FROM committee WHERE idCommittee=:x",nativeQuery=true)
	 int nbrOfMembers(@Param("x") Long idCommittee); 

}
