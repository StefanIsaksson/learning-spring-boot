package com.dinoz.productservice.controller;

import com.dinoz.productservice.model.Product;
import com.dinoz.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public Product findProduct(@PathVariable String id) {
        return productService.getProduct(id);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public @ResponseBody Product updateProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Object deleteProduct(@PathVariable(value = "id") String id){
        productService.deleteProduct(id);
        return null;
    }

}
