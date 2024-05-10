package com.example.productservice_exp1.dtos;


import com.example.productservice_exp1.models.Category;
import com.example.productservice_exp1.models.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class FakeStoreProductDTO {
    Long id;
    String title;
    String description;
    long price;
    String image;
    String category;

    public Product toProduct(){
        Product product = new Product();
        product.setId(this.id);
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImage(this.image);
        Category category1 = new Category();
        category1.setTitle(this.category);
        product.setCategory(category1);
        return product;
    }
}
