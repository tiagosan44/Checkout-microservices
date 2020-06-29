package com.hiberus.bill.repository.impl;

import com.hiberus.bill.model.PaymentMethod;
import com.hiberus.bill.repository.ClientRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ClientRepositoryImpl implements ClientRepository {

    List<PaymentMethod> paymentMethods = new ArrayList<>();

    {
        paymentMethods.add(new PaymentMethod(1, "Credit card ..78", "2789 7976 4365 3478"));
        paymentMethods.add(new PaymentMethod(2, "Credit card ..58", "2789 7976 4365 4758"));
        paymentMethods.add(new PaymentMethod(3, "Credit card ..05", "2789 7976 4365 9305"));
    }

    @Override
    public PaymentMethod findPaymentMethod() {
        final Random rand = new Random();
        return paymentMethods.get(rand.nextInt(paymentMethods.size()));
    }
}
