package com.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.Dao.ProductDAO;
import com.Entity.Product;

@Service
public class ProductService {

	@Autowired
	 ProductDAO dao;
	public Product addProduct(Product product,@PathVariable int cid)
	{
		return dao.addProduct(product, cid);
	}
//	
	public Product updateProduct(Product clientProduct)
	{
		return dao.updateProduct(clientProduct);
}

	public Product saveproduct(Product product) {
		// TODO Auto-generated method stub
		return dao.saveproduct(product);
	}
//
//	
	public Product deleteProduct(Product product) {
	// TODO Auto-generated method stub
		return dao.deleteProduct(product);
	}
	public List<Product> allProducts()
	{
		return dao.allProducts();
	}
	public Product viewproduct(int pid) {
		// TODO Auto-generated method stub
		return dao.viewproduct(pid);
	}
	}

