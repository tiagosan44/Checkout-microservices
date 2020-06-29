package com.hiberus.bill.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
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
