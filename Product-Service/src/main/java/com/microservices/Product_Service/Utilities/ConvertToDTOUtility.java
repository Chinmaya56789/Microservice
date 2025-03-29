package com.microservices.Product_Service.Utilities;

import com.microservices.Product_Service.DTO.ProductCreateRequest;
import com.microservices.Product_Service.DTO.ProductResponse;
import com.microservices.Product_Service.Models.Product;


public interface ConvertToDTOUtility {
    static ProductResponse productResponse(Product p){
        return ProductResponse.builder().name(p.getName()).category(p.getCategory()).description(p.getDescription()).build();
    }
    static Product toProduct(ProductCreateRequest p){
        return Product.builder().name(p.getName()).category(p.getCategory()).description(p.getDescription()).build();
    }
}
