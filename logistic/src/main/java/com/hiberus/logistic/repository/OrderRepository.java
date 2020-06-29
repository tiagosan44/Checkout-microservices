package com.hiberus.logistic.repository;

import com.hiberus.logistic.model.LogisticRequest;

public interface OrderRepository {

    String createSentOrder(LogisticRequest logisticRequest);
}
