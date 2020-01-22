package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Trainer;

public interface ITrainerService {
	
    public Trainer saveOrUpdateTrainer(Trainer trainer);
    public void deleteTrainer (Long idTrainer);
    public Trainer getByIdTrainer(Long idTrainer);
    public List<Trainer> getAllTrainer();
    public List<Trainer> findByTrainerState(String trainerState);

}
