package com.example.productservice_exp1.repositories;

import com.example.productservice_exp1.models.Category;
import com.example.productservice_exp1.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<Product,Integer> {


    Optional<Product> findById(Integer integer);

    List<Product> findAll();

    List<Product> findByCategory(Category category);
}
