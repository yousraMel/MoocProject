package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Learner;
import com.inti.formation.iservices.ILearnerService;
import com.inti.formation.repositories.ILearnerRepository;

@Service
public class LearnerService implements ILearnerService {

	@Autowired
	private ILearnerRepository repo;

	@Override
	public Learner saveOrUpdateLearner(Learner learner) {
		return repo.save(learner);
	}

	@Override
	public void deleteLearner(Long idLearner) {
		repo.deleteById(idLearner);
	}

	@Override
	public Learner getByIdLearner(Long idLearner) {
		return repo.findById(idLearner).get();
	}

	@Override
	public List<Learner> getAllLearners() {
		return repo.findAll();
	}

}
