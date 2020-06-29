package com.hiberus.checkout.service;

import com.hiberus.checkout.model.Order;
import com.hiberus.checkout.response.OrderResponse;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public interface OrderService {

	OrderResponse createOrder(Order order);

	Order getById(Long clientId) throws NotFound;
}
