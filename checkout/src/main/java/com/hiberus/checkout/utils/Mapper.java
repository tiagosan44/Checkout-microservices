package com.hiberus.checkout.utils;

import com.hiberus.checkout.model.Order;
import com.hiberus.checkout.request.BillRequest;
import com.hiberus.checkout.request.LogisticRequest;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public BillRequest mapToBill(final Order order) {
        BillRequest billRequest = new BillRequest();
        billRequest.setClientId(order.getId());
        billRequest.setProducts(order.getProducts());
        return billRequest;
    }

    public LogisticRequest mapToLogistic(final Order order) {
        LogisticRequest logisticRequest = new LogisticRequest();
        logisticRequest.setClientId(order.getId());
        logisticRequest.setDirection(order.getDirection());
        logisticRequest.setProducts(order.getProducts());
        return logisticRequest;
    }
}
