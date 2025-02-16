package com.satya.springkafkaschemaregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.satya.*"})
public class SpringKafkaSchemaRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaSchemaRegistryApplication.class, args);
	}

}
