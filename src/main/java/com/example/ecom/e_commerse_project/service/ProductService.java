package com.example.ecom.e_commerse_project.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
		
		return repo.findById(id).orElse(null);
	}
	@Autowired
	private CloudinaryService cloudinaryService;

	public Product addProduct(Product product, MultipartFile image) throws IOException {

	    String imageUrl = cloudinaryService.uploadImage(image);

	    product.setImageUrl(imageUrl);

	    return repo.save(product);
	}

}
