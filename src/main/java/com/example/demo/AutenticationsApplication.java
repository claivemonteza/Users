package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(info = @Info(title = "Users API REST", version = "1.0", description = "Get information about users via a RESTful API", 
contact=@Contact(name="Claive Monteza", url="https://claivemonteza.github.io/portfolio-v1/", email="claivemonteza@gmail.com"),
license=@License(name="Apache 2.0",url="https://www.apache.org/licenses/LICENSE-2.0")))
@SpringBootApplication
public class AutenticationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutenticationsApplication.class, args);
	}

}
