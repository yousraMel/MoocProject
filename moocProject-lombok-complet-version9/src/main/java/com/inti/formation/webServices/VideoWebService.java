package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Video;
import com.inti.formation.iservices.IVideoService;

@RestController
@RequestMapping("/videoApi")
public class VideoWebService {
	
	@Autowired
	private IVideoService service;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Video saveOrUpdate(@RequestBody Video c) {
		return service.saveOrUpdateVideo(c);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Video update(@RequestBody Video c) {
		return service.saveOrUpdateVideo(c);
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Video getById(@PathVariable("id") Long id) { 
		return service.getByIdVideo(id);
	}

	@RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		service.deleteVideo(id);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Video> findAll() {
		return service.getAllVideo();
	}


}
