package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Committee;
import com.inti.formation.iservices.ICommitteeService;

@RestController
@RequestMapping("/committeeApi")
@CrossOrigin(origins = "*")
public class CommitteeWebService {
	
	@Autowired
	private ICommitteeService service;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Committee saveOrUpdate(@RequestBody Committee c) {
		return service.saveOrUpdateCommittee(c);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Committee update(@RequestBody Committee c) {
		return service.saveOrUpdateCommittee(c);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Committee getById(@PathVariable("id") Long id) { 
		return service.getByIdCommittee(id);
	}

	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.deleteCommittee(id);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Committee> findAll() {
		return service.getAllCommittee();
	}

}
