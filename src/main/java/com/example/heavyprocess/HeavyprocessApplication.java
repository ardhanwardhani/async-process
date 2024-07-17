package com.example.heavyprocess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class HeavyprocessApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeavyprocessApplication.class, args);
	}

}
