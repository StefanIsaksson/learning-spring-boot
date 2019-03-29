package com.dinoz.productservice.service;

import com.dinoz.productservice.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product createProduct(Product product);

    Product getProduct(String id);

    Product updateProduct(Product product);

    void deleteProduct(String id);
}
