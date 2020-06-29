package com.hiberus.checkout.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "logistic-config")
@Data
public class LogisticProperties {

    String logisticServiceURL;
}
