package com.hiberus.logistic.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @NotNull
    @NotBlank
    Long id;

    @NotNull
    @NotBlank
    Integer quantity;

    @NotNull
    @NotBlank
    Double cost;
}
