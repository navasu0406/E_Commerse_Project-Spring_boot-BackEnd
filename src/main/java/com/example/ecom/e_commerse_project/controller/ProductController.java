package com.example.ecom.e_commerse_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom.e_commerse_project.model.Product;
import com.example.ecom.e_commerse_project.service.ProductService;

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
	public List<Product> getAllProducts(){
		return service.getAllProducts();
	}
	
	@GetMapping("/products/{id}")
	public Product getbyid(@PathVariable int id)
	{
		return service.getById(id);
	}
}
