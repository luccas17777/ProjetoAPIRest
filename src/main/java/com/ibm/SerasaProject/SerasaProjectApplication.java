package com.ibm.SerasaProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SerasaProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SerasaProjectApplication.class, args);
	}

}
