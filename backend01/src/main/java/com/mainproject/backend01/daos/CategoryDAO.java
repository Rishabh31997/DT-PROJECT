package com.mainproject.backend01.daos;

import java.util.List;
import java.util.Set;

import com.mainproject.backend01.models.Category;
import com.mainproject.backend01.models.Product;

public interface CategoryDAO {

	public boolean addCategory(Category cat);
	public boolean updateCategory(Category cat);
	public void deletecategory(int categoryId);
	public List<Category> category();
	public Category getCategory(int categoryId);
	
}
