package com.hiberus.bill.service.impl;

import com.hiberus.bill.model.BillResponse;
import com.hiberus.bill.model.BillRequest;
import com.hiberus.bill.service.BillService;
import com.hiberus.bill.service.PaymentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BillServiceImpl implements BillService {

    PaymentService paymentService;

    @Override
    public BillResponse billProducts(final BillRequest billRequest) {
        final BillResponse billResponse = new BillResponse();
        final Double total = billRequest.getProducts()
                .stream()
                .map(product -> product.getCost() * product.getQuantity())
                .reduce(0.0, Double::sum);
        billResponse.setPaymentResult(paymentService.payOrder(billRequest.getClientId(), total));
        billResponse.setTotal(total);
        billResponse.setPaymentDate(Instant.now());
        return billResponse;
    }
}
