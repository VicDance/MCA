package com.mca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mca.data.service", "com.mca.controller", "com.mca.service"})
public class McaApplication {

	public static void main(String[] args) {
		SpringApplication.run(McaApplication.class, args);
	}

}