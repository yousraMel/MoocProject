package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inti.formation.entities.Learner;

public interface ILearnerRepository extends JpaRepository<Learner, Long> {

}
