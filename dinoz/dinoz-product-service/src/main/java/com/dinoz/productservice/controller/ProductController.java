package com.dinoz.productservice.controller;

import com.dinoz.productservice.model.Product;
import com.dinoz.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public List<Product> findAllProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{productId}")
    public Product findBook(@PathVariable Long productId) {
        return productService.getProduct(productId);
    }

}
