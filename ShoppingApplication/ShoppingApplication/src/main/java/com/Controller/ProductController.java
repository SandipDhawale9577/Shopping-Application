package com.Controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Entity.Product;
import com.Service.ProductService;

@RestController
public class ProductController {
	@Autowired
	SessionFactory factory;

	@Autowired
	ProductService service;

	// localhost:8080/products/3
	@RequestMapping("products/{cid}")
	public Product addProduct(@RequestBody Product product, @PathVariable int cid) {

		return service.addProduct(product, cid);

	}

	@PostMapping("saveproduct")
	public Product saveproduct(@RequestBody Product product) {
		return service.saveproduct(product);
	}

	@PostMapping("save")
	public ModelAndView saveUserData(Product userfrombrowser, HttpServletRequest request) {

		// HttpServletRequest used to images folder path
		MultipartFile filedata = userfrombrowser.getImages();

		// MultipartFile object contains image data

		String filename = filedata.getOriginalFilename();

		System.out.println(filename);// xyz.jpg\
		HttpSession httpsession = request.getSession();
		httpsession.setAttribute("imagename", filename);

		File file = new File(request.getServletContext().getRealPath("/images"), filename);

		try {
			// transfer to is method of MultipartFile
			filedata.transferTo(file);

			System.out.println("File uploaded successfully");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ModelAndView modelandview = new ModelAndView();

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		userfrombrowser.setImagepath(filename);

		session.save(userfrombrowser);

		tx.commit();

		return modelandview;
	}

//
//	
//	
//		// {"pid":1 , "name":pen,"price":20}
//		 //clientProduct ==> [pid=1 , name=pen , price=20] 
	@RequestMapping("updateproducts")
	public Product updateProduct(Product clientProduct) {

		System.out.println("called");
		return service.updateProduct(clientProduct);

	}


	@RequestMapping("deleteproduct")
	public Product deleteProduct(@RequestBody Product product) {
		return service.deleteProduct(product);
	}

	@RequestMapping("allProducts")
	public List<Product> allProducts() {

		return service.allProducts();
	}

	@RequestMapping("viewproduct/{pid}")
	public Product viewproduct(@PathVariable int pid) {
		return service.viewproduct(pid);
	}

}