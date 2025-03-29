package com.microservices.Product_Service.Controllers;


import com.microservices.Product_Service.DTO.ProductCreateRequest;
import com.microservices.Product_Service.DTO.ProductResponse;
import com.microservices.Product_Service.Models.Product;
import com.microservices.Product_Service.Services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ProductController {

    private ProductService productService;


    @GetMapping("/product/getProduct/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable String id){

            return ResponseEntity.status(HttpStatus.OK).body(productService.getProduct(id));
    }

    @PostMapping("/product/addProduct")
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductCreateRequest p){
            return  ResponseEntity.status(HttpStatus.CREATED).body(productService.addProduct(p));
    }


}
