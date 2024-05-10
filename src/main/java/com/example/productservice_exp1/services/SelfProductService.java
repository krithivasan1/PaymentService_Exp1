package com.example.productservice_exp1.services;

import com.example.productservice_exp1.exceptions.ProductNotFoundException;
import com.example.productservice_exp1.models.Product;
import com.example.productservice_exp1.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductService")
public class SelfProductService implements ProductService {

    ProductRepository productRepository;

    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getSingleProduct(Integer productId) throws ProductNotFoundException {
        return productRepository.findById(productId).get();
    }

    @Override
    public Product deleteSingleProduct(Integer productId) throws ProductNotFoundException {
        return null;
    }

    @Override
    public Page<Product> productWithPage(Integer pageNumber, Integer pageSize, String sort) {
        Pageable pageable = null;
        if (sort != null) {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, sort);
        } else {
            pageable = PageRequest.of(pageNumber,pageSize);
        }


        return productRepository.findAll(pageable);
    }
}
