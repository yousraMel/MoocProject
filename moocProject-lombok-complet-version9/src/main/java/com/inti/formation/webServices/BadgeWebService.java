package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Badge;
import com.inti.formation.services.BadgeService;

@RestController
@RequestMapping("/badge")
public class BadgeWebService {
	
	@Autowired
	private BadgeService service;
	
	@RequestMapping(value="/saveBadge", method=RequestMethod.POST)
	public Badge saveBadge(@RequestBody Badge badge) {
		return service.saveOrUpdateBadge(badge);
	}
	
	
	@RequestMapping(value="/updateBadge", method=RequestMethod.PUT)
	public Badge updateBadge(@RequestBody Badge badge) {
		return service.saveOrUpdateBadge(badge);
	}
	
	
	@RequestMapping(value="/deleteBadge/{idBadge}", method=RequestMethod.DELETE)
	public void deleteBadge(@PathVariable Long idBadge) {
		service.deleteBadge(idBadge);
	}
	
	@RequestMapping(value = "/getByIdBadge/{idBadge}", method = RequestMethod.GET)
	public Badge getByIdBadge(@PathVariable Long idBadge) {
		return service.getByIdBadge(idBadge);
	}
	
	@RequestMapping(value = "/getAllBadges", method = RequestMethod.GET)
	public List<Badge> findAll() {
		return service.getAllBadges();
	}

}
