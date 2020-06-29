package com.hiberus.checkout.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LogisticResponse {

    @NotNull
    @NotBlank
    Instant orderSentDate;

    @NotNull
    @NotBlank
    String orderState;

    @NotNull
    @NotBlank
    String orderCreationResult;
}