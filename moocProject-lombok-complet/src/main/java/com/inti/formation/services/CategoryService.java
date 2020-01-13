package com.inti.formation.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.formation.entities.Category;
import com.inti.formation.iservices.ICategoryService;
import com.inti.formation.repositories.ICategoryRepository;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private ICategoryRepository repo;

	@Override
	public Category saveOrUpdateCategory(Category category) {
		// TODO Auto-generated method stub
		return repo.save(category);
	}

	@Override
	public void deleteCategory(Long idCategory) {
		repo.deleteById(idCategory);
		
	}

	@Override
	public Category getByIdCategory(Long idCategory) {
		// TODO Auto-generated method stub
		return repo.findById(idCategory).get();
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

}
