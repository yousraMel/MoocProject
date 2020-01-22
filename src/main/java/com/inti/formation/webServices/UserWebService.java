package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entites.User;
import com.inti.formation.iservice.IUserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/apiUser")
public class UserWebService {
	
@Autowired
private IUserService service;

 @RequestMapping(value="/save", method = RequestMethod.POST)
 public User save(@RequestBody User u ) {
	 
	 return service.saveOrUpdateUser(u);
 }
	@RequestMapping(value = "/update" , method = RequestMethod.PUT)
    public User update (@RequestBody User u) {
		
		return service.saveOrUpdateUser(u);
	}
	
	@RequestMapping(value="/get/{idUser}", method = RequestMethod.GET)
	public User getById(@PathVariable("idUser") Long  idUser) {
	 
		return service.getByIdUser(idUser);
	}
	@RequestMapping(value="/delete/{idUser}",method = RequestMethod.DELETE) 
	
	public void delete(@PathVariable("idUser")Long idUser) {
		service.deleteUser(idUser);
		
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	
	public List<User>findAll(){
		
		return service.getAllUser();
	}
	
	
	}	
	
 
