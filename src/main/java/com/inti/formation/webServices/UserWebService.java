package com.inti.formation.webServices;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.User;
import com.inti.formation.iservices.IUserService;

@RestController
@RequestMapping("/apiUser")
@CrossOrigin(origins = "*")

public class UserWebService {
	
	@Autowired
	private IUserService service;
	
//	@Autowired
//	private IRoleService roleservice;

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public User save(@RequestBody User user) {
		
//			Set<Role> roles = null;
//			roles.add(roleservice.findByRoleName(roleName));
//			user.setRoles(roles);
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
	
	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	public User signIn(@RequestBody User user){
		return service.login(user.getEmail(), user.getPassword());
	}
	
	
	
	
//	@RequestMapping(value = "/getRole", method = RequestMethod.POST)
//	public String getRole(@RequestBody User user){
//			user = service.getByIdUser(user.getId());
//		return user.getRoles().iterator().next().getRoleName();
//	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public User login(@PathVariable String email, @PathVariable String password){
//		return service.login(email, password);
//	}
//	
	
	
}
