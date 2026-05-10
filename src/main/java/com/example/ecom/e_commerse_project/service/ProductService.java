package com.example.ecom.e_commerse_project.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.ecom.e_commerse_project.model.Product;
import com.example.ecom.e_commerse_project.repo.ProductRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ProductService {

	  @Autowired
	    private ObjectMapper mapper;
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
	 // UPDATE PRODUCT (FULL SAFE VERSION)
    public Product updateProduct(int id, String data, MultipartFile image) throws Exception {

        Product existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // 1. Update JSON fields if provided
        if (data != null && !data.isEmpty()) {

            Product newData = mapper.readValue(data, Product.class);

            if (newData.getName() != null)
                existing.setName(newData.getName());

            if (newData.getDescription() != null)
                existing.setDescription(newData.getDescription());

            if (newData.getBrand() != null)
                existing.setBrand(newData.getBrand());

            if (newData.getPrice() != null)
                existing.setPrice(newData.getPrice());

            if (newData.getCategory() != null)
                existing.setCategory(newData.getCategory());

            if (newData.getRelease_date() != null)
                existing.setRelease_date(newData.getRelease_date());

            if (newData.getQuantity() != 0)
                existing.setQuantity(newData.getQuantity());
        }

        // 2. Update image if provided
        if (image != null && !image.isEmpty()) {
            String imageUrl = cloudinaryService.uploadImage(image);
            existing.setImageUrl(imageUrl);
        }

        return repo.save(existing);
    }
	public void deleteProduct(int id) {
		repo.deleteById(id);
		
	}

}
