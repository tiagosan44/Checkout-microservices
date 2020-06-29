package com.hiberus.checkout.webClient;

import com.hiberus.checkout.request.BillRequest;
import com.hiberus.checkout.response.BillResponse;
import reactor.core.publisher.Mono;

public interface BillService {

    Mono<BillResponse> billOrder(BillRequest billRequest);
}
