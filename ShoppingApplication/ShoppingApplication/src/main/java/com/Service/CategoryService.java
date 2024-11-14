
package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.*;
import com.Entity.Category;


@Service
public class CategoryService {


	@Autowired
	CategoryDAO dao;
	
	public Category saveCategory(Category category)
	{
		return dao.saveCategory(category);
		
	}
	public Category getCategory(int cid) {
		return dao.getCategory(cid);
	}
	public Category updateCategory(Category category) {
	
		return dao.updateCategory(category);
	}
	public Category deleteCategory(int cid) {
		return dao.deleteCategory(cid);
	}
	public List<Category> getAllCategory(){
		
		return dao.getAllCategory();
	}
}