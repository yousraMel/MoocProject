package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Question;
import com.inti.formation.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionWebService {
	
	@Autowired
	private QuestionService service;
	
	@RequestMapping(value="/saveQuestion", method=RequestMethod.POST)
	public Question saveQuestion(@RequestBody Question question) {
		return service.saveOrUpdateQuestion(question);
	}
	
	
	@RequestMapping(value="/updateQuestion", method=RequestMethod.PUT)
	public Question updateQuestion(@RequestBody Question question) {
		return service.saveOrUpdateQuestion(question);
	}
	
	
	@RequestMapping(value="/deleteQuestion/{idQuestion}", method=RequestMethod.DELETE)
	public void deleteQuestion(@PathVariable Long idQuestion) {
		service.deleteQuestion(idQuestion);
	}
	
	@RequestMapping(value = "/getByIdQuestion/{idQuestion}", method = RequestMethod.GET)
	public Question getByIdQuestion(@PathVariable Long idQuestion) {
		return service.getByIdQuestion(idQuestion);
	}
	
	@RequestMapping(value = "/getAllQuestions", method = RequestMethod.GET)
	public List<Question> findAll() {
		return service.getAllQuestions();
	}

}
