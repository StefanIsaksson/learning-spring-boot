package com.dinoz.shop.service;

import com.dinoz.shop.configuration.AppConfiguration;
import com.dinoz.shop.model.Product;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@SpringComponent
@UIScope
public class ProductServiceImpl implements ProductService
{

    @Autowired
    AppConfiguration appConfiguration;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Product> getProducts(String filterText) {
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                appConfiguration.getProductServiceURL(),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>(){});
        if(filterText == null || filterText.isEmpty() ){
            return response.getBody();
        }
        return response.getBody().stream().filter(p -> p.getName().toLowerCase().contains(filterText.toLowerCase().trim())).collect(Collectors.toList());
    }

    @Override
    public Product getProduct(String id) {
        return restTemplate.getForObject(appConfiguration.getProductServiceURL() + id, Product.class);
    }

    @Override
    public void saveProduct(Product product) {
        restTemplate.put(appConfiguration.getProductServiceURL(), product);
    }

    @Override
    public void deleteProduct(String id) {

    }

}
