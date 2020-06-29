package com.hiberus.checkout;

import com.hiberus.checkout.config.BillProperties;
import com.hiberus.checkout.config.LogisticProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableConfigurationProperties({BillProperties.class, LogisticProperties.class})
public class CheckoutApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckoutApplication.class, args);
	}

	@RequestMapping("/")
	public String home() {
		return "Hello Docker World";
	}
}
