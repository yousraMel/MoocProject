package com.inti.formation.webServices;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Answer;
import com.inti.formation.entities.Question;
import com.inti.formation.entities.Quiz;
import com.inti.formation.services.AnswerService;
import com.inti.formation.services.QuestionService;
import com.inti.formation.services.QuizService;
import com.inti.formation.utils.RestVerifier;

@RestController
@RequestMapping("/apiQuestion")
@CrossOrigin(origins = "*")
public class QuestionWebService {

	@Autowired
	private QuestionService questionService;

	@Autowired
	private QuizService quizService;

	@Autowired
	private AnswerService answerService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.CREATED)
	public Question save(@RequestBody @Valid Question question, @RequestParam Long idQuiz, BindingResult result) {

		RestVerifier.verifyModelResult(result);

		Quiz quiz = quizService.find(idQuiz);
		question.setQuiz(quiz);

		return questionService.save(question);
	}

	@RequestMapping(value = "/updateAll", method = RequestMethod.POST)
//	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.OK)
	public void updateAll(@RequestBody List<Question> questions) {
		for (int i = 0; i < questions.size(); i++) {
			Question question = questions.get(i);
			question.setOrder(i + 1);

			questionService.update(question);
		}
	}

	@RequestMapping(value = "/{question_id}", method = RequestMethod.GET)
	@PreAuthorize("permitAll")
	@ResponseStatus(HttpStatus.OK)
	public Question find(@PathVariable Long question_id) {

		return questionService.find(question_id);
	}

	@RequestMapping(value = "/update/{question_id}", method = RequestMethod.POST)
//	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.OK)
	public Question update(@PathVariable Long question_id, @Valid Question question, BindingResult result) {

		RestVerifier.verifyModelResult(result);

		question.setIdQuestion(question_id);
		return questionService.update(question);

	}

	@RequestMapping(value = "/delete/{question_id}", method = RequestMethod.DELETE)
//	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long question_id) {
		Question question = questionService.find(question_id);
		questionService.delete(question);
	}

	@RequestMapping(value = "/{question_id}/answers", method = RequestMethod.GET)
	@PreAuthorize("permitAll")
	@ResponseStatus(HttpStatus.OK)
	public List<Answer> findAnswers(@PathVariable Long question_id) {
		Question question = questionService.find(question_id);
		return answerService.findAnswersByQuestion(question);
	}

	@RequestMapping(value = "/{question_id}/correctAnswer", method = RequestMethod.GET)
	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.OK)
	public Answer getCorrectAnswer(@PathVariable Long question_id) {
		Question question = questionService.find(question_id);
		return questionService.getCorrectAnswer(question);
	}

	@RequestMapping(value = "/{question_id}/correctAnswer", method = RequestMethod.POST)
	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.OK)
	public void setCorrectAnswer(@PathVariable Long question_id, @RequestParam Long answer_id) {

		Question question = questionService.find(question_id);
		Answer answer = answerService.find(answer_id);
		questionService.setCorrectAnswer(question, answer);
	}

}
