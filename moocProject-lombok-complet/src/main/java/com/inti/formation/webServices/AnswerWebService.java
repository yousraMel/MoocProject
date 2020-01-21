package com.inti.formation.webServices;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.security.access.prepost.PreAuthorize;
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
import com.inti.formation.services.AnswerService;
import com.inti.formation.services.QuestionService;
import com.inti.formation.utils.RestVerifier;


@RestController
@RequestMapping("/apiAnswer")
@CrossOrigin(origins = "*")
public class AnswerWebService {

	@Autowired
	AnswerService answerService;

	@Autowired
	QuestionService questionService;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
//	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.CREATED)
	public Answer save(@RequestBody @Valid Answer answer, BindingResult result, @RequestParam long idQuestion) {

		RestVerifier.verifyModelResult(result);

		Question question = questionService.find(idQuestion);
		return questionService.addAnswerToQuestion(answer, question);
	}

	@RequestMapping(value = "/updateAll", method = RequestMethod.POST)
//	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.OK)
	public void updateAll(@RequestBody List<Answer> answers) {
		for (int i = 0; i < answers.size(); i++) {
			Answer answer = answers.get(i);
			answer.setOrder(i + 1);

			answerService.update(answer);
		}
	}

	@RequestMapping(value = "/get/{answer_id}", method = RequestMethod.GET)
//	@PreAuthorize("permitAll")
	@ResponseStatus(HttpStatus.OK)
	public Answer find(@PathVariable Long idAnswer) {

		return answerService.find(idAnswer);
	}

	@RequestMapping(value = "/update/{answer_id}", method = RequestMethod.POST)
//	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.OK)
	public Answer update(@PathVariable Long idAnswer,@RequestBody @Valid Answer answer, BindingResult result) {

		RestVerifier.verifyModelResult(result);

		answer.setIdAnswer(idAnswer);
		return answerService.update(answer);
	}

	@RequestMapping(value = "/delete/{answer_id}", method = RequestMethod.DELETE)
//	@PreAuthorize("isAuthenticated()")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long idAnswer) {
		Answer answer = answerService.find(idAnswer);
		answerService.delete(answer);
	}
}
