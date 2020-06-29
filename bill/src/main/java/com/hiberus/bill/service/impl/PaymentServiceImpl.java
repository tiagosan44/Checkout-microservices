package com.hiberus.bill.service.impl;

import com.hiberus.bill.model.PaymentMethod;
import com.hiberus.bill.repository.ClientRepository;
import com.hiberus.bill.service.PaymentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PaymentServiceImpl implements PaymentService {

    ClientRepository clientRepository;

    @Override
    public String payOrder(final Long clientId, final Double total) {
        final PaymentMethod paymentMethod = clientRepository.findPaymentMethod();
        return "Payment at a cost of " + total + " with " + paymentMethod.getName() + " by user with Id " + clientId + " done";
    }
}
