package com.rutuja.SecurityRegistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SecurityRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityRegistryApplication.class, args);
	}

}
