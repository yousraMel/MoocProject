package com.inti.formation.webservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Answer;
import com.inti.formation.iservices.IAnswerService;
@RestController
@RequestMapping("/apiAnswer")
public class AnswerWebService {


	@Autowired
	private IAnswerService service;

	@RequestMapping(value = "/saveAnswer", method = RequestMethod.POST)
	public Answer save(@RequestBody Answer u) {

		return service.saveOrUpdateAnswer(u);

	}

	@RequestMapping(value = "/updateAnswer", method = RequestMethod.PUT)
	public Answer update(@RequestBody Answer u) {

		return service.saveOrUpdateAnswer(u);

	}

	@RequestMapping(value = "/getByIdAnswer/{id}", method = RequestMethod.GET)
	public Answer getById(@PathVariable("id") Long id) {

		return service.getByIdAnswer(id);

	}
	
	@RequestMapping(value="/deleteByIdAnswer/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		
		 service.deleteByIdAnswer(id);
		
	}
	
	@RequestMapping(value="/getAllAnswer",method=RequestMethod.GET)
	public List<Answer> findAll(){
		
		return service.getAllAnswer();
		
	}

}

