package com.example.microservice.product.repository;

import com.example.microservice.product.model.Product;
import io.micrometer.observation.annotation.Observed;
import org.springframework.data.mongodb.repository.MongoRepository;

@Observed
public interface ProductRepository extends MongoRepository<Product, String> {
}
