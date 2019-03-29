package com.dinoz.productservice.repository;

import com.dinoz.productservice.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("1", "T-Rex", "King of Dinsoaurs", 500D),
            new Product("2", "Dracorex", "Herbivour", 200D)
    ));

    @Override
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public Product createProduct(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Product getProduct(String id) {
        return products.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Product updateProduct(Product product) {
        Product existingProduct = getProduct(product.getId());
        if(existingProduct != null) {
            products.remove(existingProduct);
        }
        products.add(product);
        return product;
    }

    @Override
    public void deleteProduct(String id) {
        Product existingProduct = getProduct(id);
        products.remove(existingProduct);
    }
}
