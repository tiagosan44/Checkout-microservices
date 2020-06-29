package com.hiberus.checkout.webClient.impl;

import com.hiberus.checkout.request.BillRequest;
import com.hiberus.checkout.response.BillResponse;
import com.hiberus.checkout.webClient.BillService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BillServiceImpl implements BillService {

    @Autowired
    @Qualifier("billService-webClient")
    WebClient webClient;

    @Override
    public Mono<BillResponse> billOrder(final BillRequest billRequest) {
        return webClient
                .post()
                .uri(ub -> ub.path("/bill").build())
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(Mono.just(billRequest), BillRequest.class)
                .retrieve()
                .bodyToMono(BillResponse.class);
    }
}
