package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Organism;
import com.inti.formation.iservices.IOrganismService;
@RestController
@RequestMapping("/apiOrganism")
@CrossOrigin(origins = "*")
public class OrganismWebService {
	@Autowired
	private IOrganismService service;

	@RequestMapping(value = "/saveOrganism", method = RequestMethod.POST)
	public Organism save(@RequestBody Organism u) {

		return service.saveOrUpdateOrganism(u);

	}

	@RequestMapping(value = "/updateOrganism", method = RequestMethod.PUT)
	public Organism update(@RequestBody Organism u) {

		return service.saveOrUpdateOrganism(u);

	}

	@RequestMapping(value = "/getByIdOrganism/{id}", method = RequestMethod.GET)
	public Organism getById(@PathVariable("id") Long id) {

		return service.getByIdOrganism(id);

	}
	
	@RequestMapping(value="/deleteByIdOrganism/{id}",method=RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		
		 service.deleteByIdOrganism(id);
		
	}
	
	@RequestMapping(value="/getAllOrganism",method=RequestMethod.GET)
	public List<Organism> findAll(){
		return service.getAllOrganism();
	}
	
	@RequestMapping(value="/validate",method=RequestMethod.GET)
	public Organism validate(@PathVariable String organismState){
		return service.findByOrganismState(organismState);
	}

}

