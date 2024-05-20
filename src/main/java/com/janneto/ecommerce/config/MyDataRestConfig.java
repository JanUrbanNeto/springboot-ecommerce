package com.janneto.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.janneto.ecommerce.entity.Product;
import com.janneto.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        
        HttpMethod[] theUnsoportedActions = { HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.POST };
        
        config.getExposureConfiguration()
                .forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsoportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsoportedActions));
        
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsoportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsoportedActions));

        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
    }
    
}
