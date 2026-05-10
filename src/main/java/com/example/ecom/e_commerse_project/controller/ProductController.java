package com.example.ecom.e_commerse_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecom.e_commerse_project.model.Product;
import com.example.ecom.e_commerse_project.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping
	public String hello()
	{
		 return "This is home page";
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts(){
		return new ResponseEntity<>(service.getAllProducts(),HttpStatus.OK);
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getbyid(@PathVariable int id)
	{
		Product product=service.getById(id);
		if(product!=null)
			return new ResponseEntity<>(product,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/products")
	public ResponseEntity<?> addproduct(
	        @RequestParam("data") String data,
	        @RequestParam("image") MultipartFile image)
	{
	    try {

	        ObjectMapper mapper = new ObjectMapper();

	        Product product = mapper.readValue(data, Product.class);

	        Product savedProduct = service.addProduct(product, image);

	        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

	    } catch(Exception e) {

	        return new ResponseEntity<>(e.getMessage(),
	                HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
}
