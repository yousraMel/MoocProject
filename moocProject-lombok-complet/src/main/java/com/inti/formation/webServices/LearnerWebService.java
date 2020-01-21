package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Learner;
import com.inti.formation.services.LearnerService;

@RestController
@RequestMapping("/learner")
@CrossOrigin(origins = "*")
public class LearnerWebService {
	
	@Autowired
	private LearnerService service;
	
	@RequestMapping(value="/saveLearner", method=RequestMethod.POST)
	public Learner saveLearner(@RequestBody Learner learner) {
		return service.saveOrUpdateLearner(learner);
	}
	
	
	@RequestMapping(value="/updateLearner", method=RequestMethod.PUT)
	public Learner updateLearner(@RequestBody Learner learner) {
		return service.saveOrUpdateLearner(learner);
	}
	
	
	@RequestMapping(value="/deleteLearner/{idLearner}", method=RequestMethod.DELETE)
	public void deleteLearner(@PathVariable Long idLearner) {
		service.deleteLearner(idLearner);
	}
	
	@RequestMapping(value = "/getByIdLearner/{idLearner}", method = RequestMethod.GET)
	public Learner getByIdLearner(@PathVariable Long idLearner) {
		return service.getByIdLearner(idLearner);
	}
	
	@RequestMapping(value = "/getAllLearners", method = RequestMethod.GET)
	public List<Learner> findAll() {
		return service.getAllLearners();
	}

}
