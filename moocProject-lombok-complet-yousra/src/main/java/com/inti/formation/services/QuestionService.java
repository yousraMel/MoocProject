package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Question;
import com.inti.formation.iservices.IQuestionService;
import com.inti.formation.repositories.IQuestionRepository;

@Service
public class QuestionService implements IQuestionService {

	@Autowired
	private IQuestionRepository repo;

	@Override
	public Question saveOrUpdateQuestion(Question question) {
		return repo.save(question);
	}

	@Override
	public void deleteQuestion(Long idQuestion) {
		repo.deleteById(idQuestion);
	}

	@Override
	public Question getByIdQuestion(Long idQuestion) {
		return repo.findById(idQuestion).get();
	}

	@Override
	public List<Question> getAllQuestions() {
		return repo.findAll();
	}

}
