package com.inti.formation.webServices;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Assignment;
import com.inti.formation.iservices.IAssignmentService;

@RestController
@RequestMapping("/apiAssignment")
@CrossOrigin("*")
public class AssignmentWebService {

	@Autowired
	private IAssignmentService service;

	@RequestMapping(value="/save", method=RequestMethod.POST)
	public Assignment saveAssignment (@RequestBody Assignment c) {
		return service.saveOrUpdateAssignment(c);
	}

	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public Assignment updateAssignment (@RequestBody Assignment c) {
		return service.saveOrUpdateAssignment(c);
	}

	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public Assignment getByIdAssignment (@PathVariable Long id) {
		return service.getByIdAssignment(id);
	}

	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void deleteAssignment (@PathVariable Long id) {
		service.deleteAssignment(id);
	}

	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Assignment> findAllAssignment () {
		return service.getAllAssignment();
	}
}