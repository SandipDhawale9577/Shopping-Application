package com.Controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Category;
import com.Entity.ObjectNotFoundException;
import com.Service.CategoryService;

@RestController

@RequestMapping("categoryapis")
public class CategoryControllers {
	@Autowired
	CategoryService service;

	// Controller gives Category object to Service
	// Service gives same Category object to DAO class
	// DAO class will add that category object in Database

	@PostMapping("saveCategory")

	public Category saveCategory(@RequestBody Category category) {
		System.out.println(category);

		service.saveCategory(category);

		return category;

		// To create JSON String , Spring uses getter methods

	}

	@RequestMapping("getCategory/{cid}")
	public Category getCategory(@PathVariable int cid) {
		Category category = service.getCategory(cid);
		if (category == null) {
			throw new ObjectNotFoundException("record not found with " + cid);
		} else {
			return category;
		}

	}

	@PutMapping("updateCategory")
	public Category updateCategory(@RequestBody Category category) {

		return service.updateCategory(category);

	}

	@DeleteMapping("deleteCategory/{cid}")
	public Category deleteCategory(@PathVariable int cid) {

		Category category = service.getCategory(cid);
		if (category == null) {
			throw new ObjectNotFoundException("record not found with " + cid);
		} else {
			service.deleteCategory(cid);
			return category;

		}
	}

	@RequestMapping("getAllCategory")
	public List<Category> getAllCategory() {
		return service.getAllCategory();
	}

}
