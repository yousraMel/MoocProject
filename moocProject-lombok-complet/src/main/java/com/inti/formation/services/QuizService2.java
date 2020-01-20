package com.inti.formation.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.formation.entities.Question;
import com.inti.formation.entities.Quiz;
import com.inti.formation.exceptions.ActionRefusedException;
import com.inti.formation.exceptions.InvalidParametersException;
import com.inti.formation.exceptions.ResourceUnavailableException;
import com.inti.formation.iservices.IQuestionService;
import com.inti.formation.iservices.IQuizService;
import com.inti.formation.iservices.IQuizService2;
import com.inti.formation.repositories.QuizRepository;
import com.inti.formation.repositories.QuizRepository2;
import com.inti.formation.support.Response;
import com.inti.formation.support.Result;



@Service("QuizService2")
@Transactional
public class QuizService2 implements IQuizService2 {

	private static final Logger logger = LoggerFactory.getLogger(QuizService2.class);
	private QuizRepository2 quizRepository;

	private IQuestionService questionService;

	@Autowired
	public QuizService2(QuizRepository2 quizRepository, IQuestionService questionService) {
		this.quizRepository = quizRepository;
		this.questionService = questionService;
	}

	@Override
	public Quiz save(Quiz quiz) {
		return quizRepository.save(quiz);
	}

	@Override
	public Page<Quiz> findAll(Pageable pageable) {
		return quizRepository.findAll(pageable);
	}

	@Override
	public Page<Quiz> findAllPublished(Pageable pageable) {
		return quizRepository.findByIsPublishedTrue(pageable);
	}

	@Override
	public Quiz find(Long id) throws ResourceUnavailableException {
		Quiz quiz = quizRepository.findById(id).get();

		if (quiz == null) {
			logger.error("Quiz " + id + " not found");
			throw new ResourceUnavailableException("Quiz " + id + " not found");
		}

		return quiz;
	}

	@Override
	public Quiz update(Quiz newQuiz) throws ResourceUnavailableException {
		Quiz currentQuiz = find(newQuiz.getIdQuiz());

		mergeQuizzes(currentQuiz, newQuiz);
		return quizRepository.save(currentQuiz);
	}

	@Override
	public void delete(Quiz quiz) throws ResourceUnavailableException {
		quizRepository.delete(quiz);
	}

	private void mergeQuizzes(Quiz currentQuiz, Quiz newQuiz) {
		currentQuiz.setName(newQuiz.getName());
		currentQuiz.setDescription(newQuiz.getDescription());
	}

	@Override
	public Page<Quiz> search(String query, Pageable pageable) {
		return quizRepository.searchByName(query, pageable);
	}

//	@Override
//	public Page<Quiz> findQuizzesByUser(User user, Pageable pageable) {
//		return quizRepository.findByCreatedBy(user, pageable);
//	}

	@Override
	public Result checkAnswers(Quiz quiz, List<Response> answersBundle) {
		Result results = new Result();

		for (Question question : quiz.getQuestions()) {
			boolean isFound = false;

			if (!question.getIsValid()) {
				continue;
			}

			for (Response bundle : answersBundle) {
				if (bundle.getQuestion().equals(question.getId())) {
					isFound = true;
					results.addAnswer(questionService.checkIsCorrectAnswer(question, bundle.getSelectedAnswer()));
					break;
				}
			}

			if (!isFound) {
				throw new InvalidParametersException("No answer found for question: " + question.getText());
			}
		}

		return results;
	}

	@Override
	public void publishQuiz(Quiz quiz) {
		int count = questionService.countValidQuestionsInQuiz(quiz);

		if (count > 0) {
			quiz.setIsPublished(true);
			quizRepository.save(quiz);
		} else {
			throw new ActionRefusedException("The quiz doesn't have any valid questions");
		}
	}

}
