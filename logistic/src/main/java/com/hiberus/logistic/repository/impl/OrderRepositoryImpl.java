package com.hiberus.logistic.repository.impl;

import com.hiberus.logistic.model.LogisticRequest;
import com.hiberus.logistic.model.Order;
import com.hiberus.logistic.repository.OrderRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import java.util.Random;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderRepositoryImpl implements OrderRepository {

    @Override
    public String createSentOrder(final LogisticRequest logisticRequest) {
        final Order order = new Order();
        final Random rand = new Random();
        order.setId(Integer.toString(rand.nextInt(10)));
        order.setClientId(logisticRequest.getClientId());
        order.setDirection(logisticRequest.getDirection());
        order.setProducts(logisticRequest.getProducts());
        return "Order with id " + order.getId() + " sent to direction " + order.getDirection()
                + " for client with id " + order.getClientId();
    }
}
