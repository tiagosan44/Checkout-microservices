package com.hiberus.checkout.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hiberus.checkout.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
