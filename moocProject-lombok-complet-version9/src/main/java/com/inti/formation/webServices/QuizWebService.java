package com.inti.formation.webServices;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Question;
import com.inti.formation.entities.Quiz;
import com.inti.formation.services.QuestionService;
import com.inti.formation.services.QuizService;
import com.inti.formation.support.Response;
import com.inti.formation.support.Result;
import com.inti.formation.utils.RestVerifier;


@RestController
@RequestMapping("/apiQuiz")
@CrossOrigin(origins = "*")
public class QuizWebService {

	

	private static final Logger logger = LoggerFactory.getLogger(QuizWebService.class);

	@Autowired
	private QuizService quizService;

	@Autowired
	private QuestionService questionService;

//	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
//	@PreAuthorize("permitAll")
//	@ResponseStatus(HttpStatus.OK)
//	public Page<Quiz> findAll(Pageable pageable,
//			@RequestParam(required = false, defaultValue = "false") Boolean published) {
//
//		if (published) {
//			return quizService.findAllPublished(pageable);
//		} else {
//			return quizService.findAll(pageable);
//		}
//	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	@PreAuthorize("permitAll")
	@ResponseStatus(HttpStatus.OK)
	public List<Quiz> findAll() {
			return quizService.findAll();
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	@PreAuthorize("permitAll")
	@ResponseStatus(HttpStatus.OK)
	public List<Quiz> searchAll(@RequestParam(required = true) String filter,
			@RequestParam(required = false, defaultValue = "false") Boolean onlyValid) {
		return quizService.search(filter);
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	@PreAuthorize("isAuthenticated()")
	@PreAuthorize("permitAll")
	@ResponseStatus(HttpStatus.CREATED)
	public Quiz save(@RequestBody @Valid Quiz quiz, BindingResult result) {

		logger.debug("The Quiz " + quiz.getName() + " is going to be created");

		RestVerifier.verifyModelResult(result);

		return quizService.save(quiz);
	}

	@RequestMapping(value = "/{quiz_id}", method = RequestMethod.GET)
	@PreAuthorize("permitAll")
	@ResponseStatus(HttpStatus.OK)
	public Quiz find(@PathVariable Long quiz_id) {

		return quizService.find(quiz_id);
	}

	@RequestMapping(value = "/{quiz_id}", method = RequestMethod.POST)
//	@PreAuthorize("isAuthenticated()")
	@PreAuthorize("permitAll")
//	@ResponseStatus(HttpStatus.OK)
	public Quiz update(@PathVariable Long quiz_id, @Valid Quiz quiz, BindingResult result) {

		RestVerifier.verifyModelResult(result);

		quiz.setIdQuiz(quiz_id);
		return quizService.update(quiz);
	}

	@RequestMapping(value = "delete/{quiz_id}", method = RequestMethod.DELETE)
//	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long quiz_id) {
		Quiz quiz = quizService.find(quiz_id);
		quizService.delete(quiz);
	}

	@RequestMapping(value = "/{quiz_id}/questions", method = RequestMethod.GET)
	@PreAuthorize("permitAll")
	@ResponseStatus(HttpStatus.OK)
	public List<Question> findQuestions(@PathVariable Long quiz_id,
			@RequestParam(required = false, defaultValue = "false") Boolean onlyValid) {

		Quiz quiz = quizService.find(quiz_id);

		if (onlyValid) {
			return questionService.findValidQuestionsByQuiz(quiz);
		} else {
			return questionService.findQuestionsByQuiz(quiz);
		}

	}

	@RequestMapping(value = "/publish/{quiz_id}", method = RequestMethod.POST)
//	@PreAuthorize("isAuthenticated()")
	@PreAuthorize("permitAll")
	@ResponseStatus(HttpStatus.OK)
	public void publishQuiz(@PathVariable long quiz_id) {
		Quiz quiz = quizService.find(quiz_id);
		
		quizService.publishQuiz(quiz);
	}

	@RequestMapping(value = "/{quiz_id}/submitAnswers", method = RequestMethod.POST)
	@PreAuthorize("permitAll")
	@ResponseStatus(HttpStatus.OK)
	public Result playQuiz(@PathVariable long quiz_id, @RequestBody List<Response> answersBundle) {
		Quiz quiz = quizService.find(quiz_id);
		return quizService.checkAnswers(quiz, answersBundle);
	}

}
