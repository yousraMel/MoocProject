package com.inti.formation.webServices;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Role;
import com.inti.formation.entities.User;
import com.inti.formation.iservices.IRoleService;
import com.inti.formation.iservices.IUserService;

@RestController
@RequestMapping("/apiUser")
@CrossOrigin(origins = "*")

public class UserWebService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserWebService.class);
	
	@Autowired
	private IUserService service;
	
	@Autowired
	private IRoleService roleservice;

	@RequestMapping(value = "/registration/{roleName}", method = RequestMethod.POST)
	public User save(@RequestBody User user, @PathVariable("roleName") String roleName) {
		
			Set<Role> roles = new HashSet<Role>();
			roles.add(roleservice.findByRoleName(roleName));
			user.setRoles(roles);
			System.out.println(user);
			System.out.println(service.saveOrUpdateUser(user));
			return service.saveOrUpdateUser(user);
			
	}
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public User updateUser(@RequestBody User user) {
		
		return service.saveOrUpdateUser(user);
	}
	@RequestMapping(value = "/get/{idUser}", method = RequestMethod.GET)
	public User getByIdUser(@PathVariable("idUser") Long idAdmin) {
		return service.getByIdUser(idAdmin);
	}
	
	@RequestMapping(value = "/delete/{idUser}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable("idUser")Long idUser) {
		service.deleteUser(idUser);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<User> findAll(){
		return service.gettAllUser();
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public User login(@PathVariable String email, @PathVariable String password){
		User u = service.login(email, password);
		Long id = u.getId();
		Set<Role> role = u.getRoles();
		System.out.println(id);
		System.out.println(role);
		return u;
	}
	
	
	
}
