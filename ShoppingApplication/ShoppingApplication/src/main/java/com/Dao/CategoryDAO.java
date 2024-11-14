package com.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.Entity.Category;


@Repository
public class CategoryDAO {

	@Autowired
	SessionFactory factory;

	public Category saveCategory(Category category) {
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(category);

		tx.commit();

		return category;
	}

	public Category getCategory(int cid) {

		Session session = factory.openSession();
		Category category = session.get(Category.class, cid);

		return category;
	}

	public List<Category> getAllCategory() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Category.class);
		List<Category> list = criteria.list();
		return list;

	}

	public Category updateCategory(Category category) {

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.update(category);

		tx.commit();

		return category;
	}

	public Category deleteCategory(int cid) {
		Session session = factory.openSession();
		Category category = session.get(Category.class, cid);
		Transaction tx = session.beginTransaction();

		session.delete(category);

		tx.commit();

		return category;

	}

}
