package com.hiberus.checkout.service.impl;

import com.hiberus.checkout.model.Order;
import com.hiberus.checkout.repository.OrderRepository;
import com.hiberus.checkout.response.BillResponse;
import com.hiberus.checkout.response.LogisticResponse;
import com.hiberus.checkout.response.OrderResponse;
import com.hiberus.checkout.service.OrderService;
import com.hiberus.checkout.utils.Mapper;
import com.hiberus.checkout.webClient.BillService;
import com.hiberus.checkout.webClient.LogisticService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderServiceImpl implements OrderService {

	OrderRepository orderRepository;

	BillService billService;

	LogisticService logisticService;

	Mapper mapper;

	@Override
	public OrderResponse createOrder(final Order order) {
		final OrderResponse orderResponse = new OrderResponse();
		final BillResponse billResponse = billService
			.billOrder(mapper.mapToBill(order))
			.block();
		final LogisticResponse logisticResponse = logisticService
				.createSentOrder(mapper.mapToLogistic(order))
				.block();

		orderRepository.save(order);
		orderResponse.setPaymentResult(billResponse.getPaymentResult());
		orderResponse.setLogisticResult(logisticResponse.getOrderCreationResult());
		return  orderResponse;
	}

	@Override
	public Order getById(final Long clientId) {
		return orderRepository.findById(clientId).orElseThrow(RuntimeException::new);
	}
}