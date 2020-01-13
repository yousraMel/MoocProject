package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Quiz;
import com.inti.formation.iservices.IQuizService;
@RestController
@RequestMapping("/apiQuiz")
public class QuizWebService {

	@Autowired
	private IQuizService service;

	@RequestMapping(value = "/saveQuiz", method = RequestMethod.POST)
	public Quiz save(@RequestBody Quiz u) {

		return service.saveOrUpdateQuiz(u);

	}

	@RequestMapping(value = "/updateQuiz", method = RequestMethod.PUT)
	public Quiz update(@RequestBody Quiz u) {

		return service.saveOrUpdateQuiz(u);

	}

	@RequestMapping(value = "/getByIdQuiz/{id}", method = RequestMethod.GET)
	public Quiz getById(@PathVariable("id") Long id) {

		return service.getByIdQuiz(id);

	}
	
	@RequestMapping(value="/deleteByIdQuiz/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		
		 service.deleteByIdQuiz(id);
		
	}
	
	@RequestMapping(value="/getAllQuiz",method=RequestMethod.GET)
	public List<Quiz> findAll(){
		
		return service.getAllQuiz();
		
	}

}


