package com.springboot.microservice.paymentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MySpringBootMicroservicePaymentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringBootMicroservicePaymentServiceApplication.class, args);
	}

}
