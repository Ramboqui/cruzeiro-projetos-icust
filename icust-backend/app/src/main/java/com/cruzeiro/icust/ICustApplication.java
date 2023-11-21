package com.cruzeiro.icust;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.cruzeiro.icust" })
public class ICustApplication {

	public static void main(String[] args) {
		SpringApplication.run(ICustApplication.class, args);
	}

}
