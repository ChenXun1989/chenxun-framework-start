package com.chenxun.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath*:META-INF/spring/*.xml")
public class ChenxunFrameworkStartApplication {

	public static void main(String[] args) {
	   
		SpringApplication.run(ChenxunFrameworkStartApplication.class, args);
	}
}
