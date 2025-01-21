package com.example.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.example.inicio.config.JwtConfig;

@SpringBootApplication
@EnableConfigurationProperties(JwtConfig.class) 
public class InicioApplication {

	public static void main(String[] args) {
		SpringApplication.run(InicioApplication.class, args);
	}

}
