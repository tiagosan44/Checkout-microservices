package com.hiberus.logistic.service.impl;

import com.hiberus.logistic.model.LogisticRequest;
import com.hiberus.logistic.model.LogisticResponse;
import com.hiberus.logistic.repository.OrderRepository;
import com.hiberus.logistic.service.LogisticService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class LogisticServiceImpl implements LogisticService {

    OrderRepository orderRepository;

    @Override
    public LogisticResponse createSentOrder(final LogisticRequest logisticRequest) {
        final LogisticResponse logisticResponse = new LogisticResponse();
        final String orderCreationResult = orderRepository.createSentOrder(logisticRequest);
        logisticResponse.setOrderCreationResult(orderCreationResult);
        logisticResponse.setOrderSentDate(Instant.now());
        logisticResponse.setOrderState("SENT");
        return logisticResponse;
    }
}
