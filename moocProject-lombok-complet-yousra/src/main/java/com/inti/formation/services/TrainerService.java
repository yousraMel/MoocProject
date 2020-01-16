package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Trainer;
import com.inti.formation.iservices.ITrainerService;
import com.inti.formation.repositories.ITrainerRepository;

@Service
public class TrainerService implements ITrainerService {
	
	@Autowired
	private ITrainerRepository repo;

	@Override
	public Trainer saveOrUpdateTrainer(Trainer trainer) {
		// TODO Auto-generated method stub
		return repo.save(trainer);
	}

	@Override
	public void deleteTrainer(Long idTrainer) {
		repo.deleteById(idTrainer);
		
	}

	@Override
	public Trainer getByIdTrainer(Long idTrainer) {
		// TODO Auto-generated method stub
		return repo.findById(idTrainer).get();
	}

	@Override
	public List<Trainer> getAllTrainer() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
