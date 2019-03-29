package com.dinoz.shop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Configuration
public class AppConfiguration {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private DiscoveryClient discoveryClient;

    private String getGatewayBaseUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("gateway");
        if (list != null && list.size() > 0 ) {
            return list.get(0).getUri().toString();
        }
        throw new RuntimeException("Failed to retrieve Product Service base URL");
    }

    public String getProductServiceURL() {
        return getGatewayBaseUrl() + "/product-service/products/";
    }
}
