package com.cogent.ecommerce.repository;

import java.util.List;
import java.util.Optional;

import com.cogent.ecommerce.model.Category;

public interface CategoryRepository {
	
	public String addCategory(Category category );
	public String deleteCartById(String id) ;
	public void deleteAllCategories();
	public Optional<List<Category>> getCategoryById(String id) ;
	public Optional<List<Category>> getCategory();
	public String updateCategory(Category category);
	public boolean isCategoryExists(String id);
	String updateCategory();
	Optional<java.awt.List> getCategory(Category category);
	String deleteCategoryById(String id);
	


}
