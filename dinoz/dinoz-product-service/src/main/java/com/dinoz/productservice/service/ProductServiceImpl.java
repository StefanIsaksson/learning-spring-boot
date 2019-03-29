package com.dinoz.productservice.service;

import com.dinoz.productservice.model.Product;
import com.dinoz.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService
{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.createProduct(product);
    }

    @Override
    public Product getProduct(String id) {
        return productRepository.getProduct(id);
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteProduct(id);
    }
}
