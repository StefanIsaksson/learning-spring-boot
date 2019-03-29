package com.dinoz.productservice.repository;

import com.dinoz.productservice.model.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getProducts();

    Product createProduct(Product product);

    Product getProduct(String id);

    Product updateProduct(Product product);

    void deleteProduct(String id);
}
