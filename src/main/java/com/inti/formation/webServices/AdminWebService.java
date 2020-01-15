package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Admin;
import com.inti.formation.iservices.IAdminService;



@RestController
@RequestMapping("/apiAdmins")
public class AdminWebService {
	@Autowired
	private IAdminService service;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Admin save(@RequestBody Admin a) {

		return service.saveOrUpdateAdmin(a);
	}
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Admin update(@RequestBody Admin a) {
		
		return service.saveOrUpdateAdmin(a);
	}
	@RequestMapping(value = "/get/{idAdmin}", method = RequestMethod.GET)
	public Admin getById(@PathVariable("idAdmin") Long idAdmin) {
		return service.getByIdAdmin(idAdmin);
	}
	
	@RequestMapping(value = "/delete/{idAdmin}", method = RequestMethod.DELETE)
	public void delete (@PathVariable("idAdmin")Long idAdmin) {
		service.deleteAdmin(idAdmin);
		
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	
	public List<Admin>findAll(){
		
		return service.gettAllAdmin();
	}
	
	
	
}
