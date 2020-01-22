package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Certification;
import com.inti.formation.iservices.ICertificationService;

@RestController
@RequestMapping("/certificationApi")
@CrossOrigin(origins = "*")
public class CertificationWebService {
	
	@Autowired
	private ICertificationService service;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Certification saveOrUpdate(@RequestBody Certification c) {
		
		return service.saveOrUpdateCertification(c);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Certification update(@RequestBody Certification c) {
		return service.saveOrUpdateCertification(c);
	}

	@RequestMapping(value = "/get/{certificationId}", method = RequestMethod.GET)
	public Certification getById(@PathVariable("certificationId") Long certificationId) { 
		return service.getByIdCertification(certificationId);
	}

	@RequestMapping(value="/delete/{certificationId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("certificationId") Long certificationId) {
		service.deleteCertification(certificationId);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Certification> findAll() {
		return service.getAllCertification();
	}

}
