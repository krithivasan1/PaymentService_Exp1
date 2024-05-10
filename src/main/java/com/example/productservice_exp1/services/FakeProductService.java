package com.example.productservice_exp1.services;

import com.example.productservice_exp1.dtos.FakeStoreProductDTO;
import com.example.productservice_exp1.exceptions.ProductNotFoundException;
import com.example.productservice_exp1.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service("FakeProductService")
public class FakeProductService implements ProductService {

    @Autowired
    private RestTemplate restTemplate;

    // Calling the fake product service and get all the products
    @Override
    public List<Product> getAllProducts() {
        List<Product> listProduct = new ArrayList<Product>();
        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject("https://fakestoreapi.com/products", FakeStoreProductDTO[].class);
        for (FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS) {
            Product product = new Product();
            product.setId(fakeStoreProductDTO.getId());
            product.setTitle(fakeStoreProductDTO.getTitle());
            product.setDescription(fakeStoreProductDTO.getDescription());
            product.setImage(fakeStoreProductDTO.getImage());
            product.setPrice(fakeStoreProductDTO.getPrice());
            product.setCategory(fakeStoreProductDTO.toProduct().getCategory());
            listProduct.add(product);
        }
        return listProduct;
    }

    @Override
    public Product getSingleProduct(Integer productId) throws ProductNotFoundException {
        ResponseEntity<FakeStoreProductDTO> responseFakeStoreProductDTO = restTemplate.getForEntity("https://fakestoreapi.com/products/" + productId, FakeStoreProductDTO.class);
        FakeStoreProductDTO fakeStoreProductDTO = responseFakeStoreProductDTO.getBody();
        if(fakeStoreProductDTO==null){
            throw new ProductNotFoundException("Product id "+productId+ " cannot found");
        }
        return fakeStoreProductDTO.toProduct();
    }

    @Override
    public Product deleteSingleProduct(Integer productId) throws ProductNotFoundException {
        Product product = getSingleProduct(productId);
        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(productId));
        restTemplate.delete("https://fakestoreapi.com/products/" + productId, params);
        return product;
    }

    @Override
    public Page<Product> productWithPage(Integer pageNumber, Integer pageSize, String sort) {
        return null;
    }


}
