package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.EvaluationQuiz;
import com.inti.formation.iservices.IEvaluationQuizService;
import com.inti.formation.repositories.IEvaluationQuizRepository;

@Service
public class EvaluationQuizService implements IEvaluationQuizService {
	
	@Autowired
	IEvaluationQuizRepository repo;

	@Override
	public EvaluationQuiz saveOrUpdateEvaluationQuiz(EvaluationQuiz evalQuiz) {
		return repo.save(evalQuiz);
	}

	@Override
	public void deleteByIdEvaluationQuiz(Long id) {
		repo.delete(repo.getOne(id));

	}

	@Override
	public EvaluationQuiz getByIdEvaluationQuiz(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<EvaluationQuiz> getAllEvaluationQuiz() {
			return repo.findAll();
	}

}
