package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entites.Chapter;
import com.inti.formation.iservice.IChapterService;

@RestController
@RequestMapping("/apiChapters")
@CrossOrigin("*")
public class ChapterWebService {
	@Autowired
	private IChapterService service;


	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Chapter save(@RequestBody Chapter c) {

		return service.saveOrUpdateChapter(c);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Chapter update(@RequestBody Chapter c) {

		return service.saveOrUpdateChapter(c);
	}

	@RequestMapping(value = "/get/{idChapter}", method = RequestMethod.GET)
	public Chapter getById(@PathVariable("idChapter") Long idChapter) {
		return service.getByIdChapter(idChapter);
	}

	@RequestMapping(value ="/delete/{idChapter}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("idChapter") Long idChapter) {
		service.deleteChapter(idChapter);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Chapter>findAll(){
		
		return service.getAllChapter();
	}
}