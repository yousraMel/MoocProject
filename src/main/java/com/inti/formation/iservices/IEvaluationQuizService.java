package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.EvaluationQuiz;

public interface IEvaluationQuizService {
	public EvaluationQuiz saveOrUpdateEvaluationQuiz(EvaluationQuiz u);
	public void deleteByIdEvaluationQuiz(Long id);
	public EvaluationQuiz getByIdEvaluationQuiz(Long  id);
	public List<EvaluationQuiz> getAllEvaluationQuiz();

}
