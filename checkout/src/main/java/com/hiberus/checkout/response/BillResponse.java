package com.hiberus.checkout.response;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
public class BillResponse {

    @NotNull
    @NotBlank
    Instant paymentDate;

    @NotNull
    @NotBlank
    String paymentResult;

    @NotNull
    @NotBlank
    Double total;
}
