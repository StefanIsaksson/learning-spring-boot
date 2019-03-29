package com.dinoz.shop.service;

import com.dinoz.shop.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(String filterText);

    Product getProduct(String id);

    void saveProduct(Product product);

    void deleteProduct(String id);
}
