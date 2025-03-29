package com.microservices.Product_Service.Services;

import com.microservices.Product_Service.DTO.ProductCreateRequest;
import com.microservices.Product_Service.DTO.ProductResponse;
import com.microservices.Product_Service.Models.Product;
import com.microservices.Product_Service.Reposetories.ProductRepository;
import com.microservices.Product_Service.Utilities.ConvertToDTOUtility;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class ProductService {
    private ProductRepository prodRepo;


    public ProductResponse getProduct(String id){

        Optional<Product> response= prodRepo.findById(id);
        return response.map(ConvertToDTOUtility::productResponse).orElse(null);
    }

    public ProductResponse addProduct(ProductCreateRequest p) {

        Product prod= ConvertToDTOUtility.toProduct(p);
        Product savedproduct= prodRepo.save(prod);

        return ConvertToDTOUtility.productResponse(savedproduct);
    }
}
