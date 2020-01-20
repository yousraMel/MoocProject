package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Learner;

public interface ILearnerService {
	
	public Learner saveOrUpdateLearner(Learner learner);
	public void deleteLearner (Long idLearner);
	public Learner getByIdLearner(Long idLearner);
	public List<Learner> getAllLearners();

}
