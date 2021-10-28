package com.cogent.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.ecommerce.model.Category;
import com.cogent.ecommerce.repository.CategoryRepository;

@Service	
public class CategoryServiceImpl implements CategoryService {
//	
//	public static CategoryService getInstance() {
//		if(categoryService==null) {
//			categoryService= new CategoryServiceImpl();
//			return categoryService;
//		}
//		return categoryService;
//	}
	
	@Autowired

CategoryRepository categoryRepository;
	
	@Override
	public String addCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.addCategory(category);
	}

	@Override
	public Optional<String> deleteCategoryById(String id) {
		// TODO Auto-generated method stub
		return categoryRepository.deleteCategoryById(id);
	}
	

	@Override
	public void deleteAllCategorys() {
		// TODO Auto-generated method stub
		categoryRepository.deleteAllCategorys();
	}

	@Override
	public Optional<Category> getCategoryByID(String id) {
		// TODO Auto-generated method stub
		return categoryRepository.getCategoryByID(id);
	}

	@Override
	public Optional<List<Category>> getCategory() {
		// TODO Auto-generated method stub
		return categoryRepository.getCatagory();
	}

	@Override
	public Optional<String> updateCategory(String id, Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.updateCategory(id, category);
	}

	@Override
	public boolean isCategoryExist(String Id) {
		// TODO Auto-generated method stub
		return categoryRepository.isCategoryExist(Id);
	}


}	
	
	
	
	
	
	
	

	
	
}
    