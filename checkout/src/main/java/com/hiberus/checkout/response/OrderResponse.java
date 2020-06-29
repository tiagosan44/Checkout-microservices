package com.hiberus.checkout.response;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class OrderResponse {

    @NotNull
    @NotBlank
    String paymentResult;

    @NotNull
    @NotBlank
    String logisticResult;
}
