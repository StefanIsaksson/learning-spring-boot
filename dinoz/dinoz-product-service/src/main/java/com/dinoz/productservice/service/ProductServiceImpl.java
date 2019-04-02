package com.dinoz.productservice.service;

import com.dinoz.productservice.model.Product;
import com.dinoz.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
    public Product getProduct(String id) {
        return productRepository.getProduct(id);
    }

    @Override
    public Product saveProduct(Product product) {
        if(product.getId() == null){
            product.setId(UUID.randomUUID().toString());
            productRepository.createProduct(product);
            return product;
        }
        Product existingProduct = productRepository.getProduct(product.getId());
        if(existingProduct != null) {
            productRepository.updateProduct(product);
        } else {
            productRepository.createProduct(product);
        }
        return product;
    }

    @Override
    public void deleteProduct(String id) {
        productRepository.deleteProduct(id);
    }
}
