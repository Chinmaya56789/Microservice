package com.microservices.Product_Service.Reposetories;

import com.microservices.Product_Service.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
