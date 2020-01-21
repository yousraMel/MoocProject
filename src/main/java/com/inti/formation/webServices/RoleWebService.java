package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Role;
import com.inti.formation.services.RoleService;

@RestController
@RequestMapping("/apiRole")
@CrossOrigin(origins = "*")
public class RoleWebService {
	
	@Autowired
	private RoleService service;
	
	@RequestMapping(value="/saveRole", method=RequestMethod.POST)
	public Role saveRole(@RequestBody Role Role) {
		return service.saveOrUpdateRole(Role);
	}
	
	@RequestMapping(value="/updateRole", method=RequestMethod.PUT)
	public Role updateRole(@RequestBody Role Role) {
		return service.saveOrUpdateRole(Role);
	}
	
	@RequestMapping(value="/deleteRole/{idRole}", method=RequestMethod.DELETE)
	public void deleteRole(@PathVariable Long idRole) {
		service.deleteRole(idRole);
	}
	
	@RequestMapping(value = "/getByIdRole/{idRole}", method = RequestMethod.GET)
	public Role getByIdRole(@PathVariable Long idRole) {
		return service.getByIdRole(idRole);
	}
	
	@RequestMapping(value = "/getByRoleName/", method = RequestMethod.GET)
	public Role getByRoleName(@PathVariable String roleName) {
		return service.findByRoleName(roleName);
	}
	
	@RequestMapping(value = "/getAllRoles", method = RequestMethod.GET)
	public List<Role> findAll() {
		return service.getAllRoles();
	}

}
