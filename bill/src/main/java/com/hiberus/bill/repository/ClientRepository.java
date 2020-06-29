package com.hiberus.bill.repository;

import com.hiberus.bill.model.PaymentMethod;

public interface ClientRepository {

    PaymentMethod findPaymentMethod();
}
