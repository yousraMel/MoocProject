package com.inti.formation.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.formation.entities.Answer;
import com.inti.formation.entities.Question;
import com.inti.formation.exceptions.ActionRefusedException;
import com.inti.formation.exceptions.ResourceUnavailableException;
import com.inti.formation.iservices.IAnswerService;
import com.inti.formation.iservices.IQuestionService;

import com.inti.formation.repositories.IAnswerRepository;

@Service("AnswerService")
@Transactional
public class AnswerService implements IAnswerService {

	private static final Logger logger = LoggerFactory.getLogger(AnswerService.class);
	private IAnswerRepository answerRepository;

	@Autowired
	private IQuestionService questionService;

	@Autowired
	public AnswerService(IAnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}

	public void setQuestionService(IQuestionService questionService) {
		this.questionService = questionService;
	}

	@Override
	public Answer find(Long id) throws ResourceUnavailableException {
		Answer answer = answerRepository.findById(id).get();

		if (answer == null) {
			logger.error("Answer " + id + " not found");
			throw new ResourceUnavailableException("Answer " + id + " not found");
		}

		return answer;
	}

	@Override
	public Answer save(Answer answer) {
		return answerRepository.save(answer);
	}

	@Override
	public Answer update(Answer newAnswer) throws ResourceUnavailableException{
		Answer currentAnswer = find(newAnswer.getId());

		mergeAnswers(currentAnswer, newAnswer);
		return answerRepository.save(currentAnswer);
	}

	@Override
	public void delete(Answer answer) throws ResourceUnavailableException {

		if (questionService.checkIsCorrectAnswer(answer.getQuestion(), answer.getId())) {
			throw new ActionRefusedException("The correct answer can't be deleted");
		}

		answerRepository.delete(answer);
	}

	private void mergeAnswers(Answer currentAnswer, Answer newAnswer) {
		currentAnswer.setText(newAnswer.getText());

		if (newAnswer.getOrder() != null) {
			currentAnswer.setOrder(newAnswer.getOrder());
		}
	}

	@Override
	public List<Answer> findAnswersByQuestion(Question question) {
		return answerRepository.findByQuestionOrderByOrderAsc(question);
	}

	@Override
	public int countAnswersInQuestion(Question question) {
		return answerRepository.countByQuestion(question);
	}

}
