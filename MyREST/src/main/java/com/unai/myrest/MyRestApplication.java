package com.unai.myrest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.unai.myrest.upload.StorageService;

@SpringBootApplication
public class MyRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRestApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(StorageService storageService) {
		return args -> {
			// Inicializamos el servicio de ficheros
			storageService.deleteAll();
			storageService.init();
		};
	}

}
