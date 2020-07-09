package com.alg.springwebreactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringWebReactiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebReactiveApplication.class, args);
	}

}
