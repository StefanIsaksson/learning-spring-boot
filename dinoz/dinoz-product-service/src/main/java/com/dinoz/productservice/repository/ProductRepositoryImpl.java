package com.dinoz.productservice.repository;

import com.dinoz.productservice.model.Product;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

    private List<Product> products = Arrays.asList(
            new Product(1L, "T-Rex", "King of Dinsoaurs", 500L),
            new Product(2L, "Stegosaur", "Herbivour", 200L)
    );

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
    public Product getProduct(Long id) {
        return products.stream().filter(b -> b.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public Product updateProduct(Product product) {
        Product existingProduct = getProduct(product.getId());
        if(products.remove(existingProduct)){
            products.add(product);
            return product;
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        Product existingProduct = getProduct(id);
        products.remove(existingProduct);
    }
}
