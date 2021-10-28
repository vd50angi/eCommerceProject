package com.cogent.ecommerce.service;

import java.util.Optional;

import com.cogent.ecommerce.model.Category;

public interface CategoryService {

	Optional<String> deleteCategoryById(String id);

	Optional<String> updateCategory(String id, Category category);

}
