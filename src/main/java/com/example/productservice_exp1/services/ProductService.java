package com.example.productservice_exp1.services;

import com.example.productservice_exp1.exceptions.ProductNotFoundException;
import com.example.productservice_exp1.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();

    public Product getSingleProduct(Integer productId) throws ProductNotFoundException;

    public Product deleteSingleProduct(Integer productId) throws ProductNotFoundException;

    public Page<Product> productWithPage(Integer pageNumber, Integer pageSize, String sort);
}
