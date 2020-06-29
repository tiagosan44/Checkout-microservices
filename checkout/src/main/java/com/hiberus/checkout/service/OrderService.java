package com.hiberus.checkout.service;

import com.hiberus.checkout.model.Order;
import com.hiberus.checkout.response.OrderResponse;

public interface OrderService {

	OrderResponse createOrder(Order order);

	Order getById(Long clientId);
}
