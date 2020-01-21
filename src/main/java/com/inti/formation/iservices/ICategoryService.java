package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Category;

public interface ICategoryService {
	
    public Category saveOrUpdateCategory(Category category);
    public void deleteCategory (Long idCategory);
    public Category getByIdCategory(Long idCategory);
    public List<Category> getAllCategory();

}
