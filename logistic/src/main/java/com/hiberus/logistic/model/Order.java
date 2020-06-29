package com.hiberus.logistic.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {

    String id;

    Long clientId;

    String direction;

    List<Product> products;
}
