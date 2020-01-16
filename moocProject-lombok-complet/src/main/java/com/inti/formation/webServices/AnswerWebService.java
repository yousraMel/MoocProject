package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Choice;
import com.inti.formation.iservices.IAnswerService;
@RestController
@RequestMapping("/apiAnswer")
public class AnswerWebService {


	@Autowired
	private IAnswerService service;

	@RequestMapping(value = "/saveAnswer", method = RequestMethod.POST)
	public Choice save(@RequestBody Choice u) {

		return service.saveOrUpdateAnswer(u);

	}

	@RequestMapping(value = "/updateAnswer", method = RequestMethod.PUT)
	public Choice update(@RequestBody Choice u) {

		return service.saveOrUpdateAnswer(u);

	}

	@RequestMapping(value = "/getByIdAnswer/{id}", method = RequestMethod.GET)
	public Choice getById(@PathVariable("id") Long id) {

		return service.getByIdAnswer(id);

	}
	
	@RequestMapping(value="/deleteByIdAnswer/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		
		 service.deleteByIdAnswer(id);
		
	}
	
	@RequestMapping(value="/getAllAnswer",method=RequestMethod.GET)
	public List<Choice> findAll(){
		
		return service.getAllAnswer();
		
	}

}

