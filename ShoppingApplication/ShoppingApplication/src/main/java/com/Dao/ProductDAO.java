package com.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Entity.Category;
import com.Entity.Product;

import java.util.ArrayList;

@Repository
public class ProductDAO {
	@Autowired
	SessionFactory factory;

	public Product addProduct(Product product, @PathVariable int cid) {
		System.out.println("Category id is " + cid);

		Session session = factory.openSession();

		Category category = session.load(Category.class, cid);

		System.out.println("Products from given catergory are :- " + category.getProducts());

		/* get list of product and add product into it */

		List<Product> productlist = category.getProducts();

		Transaction transaction = session.beginTransaction();

		productlist.add(product);

		transaction.commit();

		System.out.println("product added into database");

		return product;

	}

	public Product updateProduct(Product clientProduct) {
		Session session = factory.openSession();
		Product productfromdb = session.load(Product.class, clientProduct.getPid());
		productfromdb.setName(clientProduct.getName());
		productfromdb.setPrice(clientProduct.getPrice());
		productfromdb.setPid(clientProduct.getPid());
		Transaction transaction = session.beginTransaction();

		session.update(clientProduct);

		transaction.commit();

		return clientProduct;
	}

	public Product saveproduct(Product product) {

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		session.save(product);

		tx.commit();

		return product;
	}

	public Product deleteProduct(Product product) {
		// TODO Auto-generated method stub

		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Product.class);
		List<Product> products = criteria.list();
		session.delete(products);
		Transaction tx = session.beginTransaction();

		tx.commit();

		return product;
	}

	public List<Product> allProducts() {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Product.class);
		List<Product> list = criteria.list();
		return list;
		// [pid=1 name=pen price=100] Product class object
		// Spring calls getter methods to read data of variables and then create JSON
		// String
	}

	public Product viewproduct(int pid) {
		Session session = factory.openSession();

		Product product = session.get(Product.class, pid);

		return product;

	}
}
