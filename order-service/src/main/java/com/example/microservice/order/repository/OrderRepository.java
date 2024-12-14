package com.example.microservice.order.repository;

import com.example.microservice.order.model.Order;
import io.micrometer.observation.annotation.Observed;
import org.springframework.data.jpa.repository.JpaRepository;

@Observed
public interface OrderRepository extends JpaRepository<Order, Long> {
}
