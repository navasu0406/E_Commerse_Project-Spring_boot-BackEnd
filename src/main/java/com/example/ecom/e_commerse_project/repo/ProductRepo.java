package com.example.ecom.e_commerse_project.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ecom.e_commerse_project.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

}
