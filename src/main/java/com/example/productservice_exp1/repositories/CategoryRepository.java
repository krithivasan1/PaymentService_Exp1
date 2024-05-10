package com.example.productservice_exp1.repositories;

import com.example.productservice_exp1.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository  extends JpaRepository<Category,Integer> {

public Category findByTitle(String title);
public List<Category> findAll();
}
