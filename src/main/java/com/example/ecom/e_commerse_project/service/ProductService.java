package com.example.ecom.e_commerse_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecom.e_commerse_project.model.Product;
import com.example.ecom.e_commerse_project.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo repo;
	public List<Product> getAllProducts() {
		
		return repo.findAll();
	}
	public Product getById(int id) {
		
		return repo.findById(id).orElse(new Product());
	}

}
