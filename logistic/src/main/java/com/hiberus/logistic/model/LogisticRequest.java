package com.hiberus.logistic.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LogisticRequest {

    @NotNull
    @NotBlank
    Long clientId;

    @NotNull
    @NotBlank
    String direction;

    @NotEmpty
    List<Product> products;
}
