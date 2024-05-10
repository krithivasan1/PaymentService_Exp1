package com.example.productservice_exp1.controllers;

import com.example.productservice_exp1.exceptions.ProductNotFoundException;
import com.example.productservice_exp1.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.productservice_exp1.services.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("SelfProductService")ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();

    }

    @GetMapping("/products/{productId}")
    public Product getSingleProduct(@PathVariable Integer productId) throws ProductNotFoundException {
        return productService.getSingleProduct(productId);
    }

    @DeleteMapping("/products/{productId}")
    public Product deleteSingleProduct(@PathVariable Integer productId) throws ProductNotFoundException {
        return productService.deleteSingleProduct(productId);
    }

    @GetMapping("/products/{pageNumber}/{pageSize}/")
    public Page<Product> getAllProducts(@PathVariable Integer pageNumber, @PathVariable Integer pageSize ){
        return productService.productWithPage(pageNumber,pageSize,"price");
    }
}
