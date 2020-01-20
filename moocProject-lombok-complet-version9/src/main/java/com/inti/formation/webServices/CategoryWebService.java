package com.inti.formation.webServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.formation.entities.Category;
import com.inti.formation.iservices.ICategoryService;

@RestController
@RequestMapping("/apiCategory")
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryWebService {
	


	@Autowired
	private ICategoryService service;
	
	@RequestMapping(value="/savecategory", method=RequestMethod.POST)
	public Category saveCategory (@RequestBody Category c) {
		return service.saveOrUpdateCategory(c);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.PUT)
	public Category updateCategory (@RequestBody Category c) {
		return service.saveOrUpdateCategory(c);
	}
	
	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public Category getByIdCategory (@PathVariable Long id) {
		return service.getByIdCategory(id);
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void deleteCategory (@PathVariable Long id) {
		service.deleteCategory(id);
	}
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Category> findAllCategory () {
		return service.getAllCategory();
	}
}
