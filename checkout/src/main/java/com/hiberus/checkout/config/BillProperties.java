package com.hiberus.checkout.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "bill-config")
@Data
public class BillProperties {

    String billServiceURL;
}
