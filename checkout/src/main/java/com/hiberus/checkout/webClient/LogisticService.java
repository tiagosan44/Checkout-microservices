package com.hiberus.checkout.webClient;

import com.hiberus.checkout.request.LogisticRequest;
import com.hiberus.checkout.response.LogisticResponse;
import reactor.core.publisher.Mono;

public interface LogisticService {

    Mono<LogisticResponse> createSentOrder(LogisticRequest logisticRequest);
}
