package com.hiberus.logistic.service;

import com.hiberus.logistic.model.LogisticRequest;
import com.hiberus.logistic.model.LogisticResponse;

public interface LogisticService {

    LogisticResponse createSentOrder(LogisticRequest logisticRequest);
}
