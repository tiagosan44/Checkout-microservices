package com.hiberus.bill.service;

public interface PaymentService {

    String payOrder(Long clientId, Double total);
}
