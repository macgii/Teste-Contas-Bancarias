package com.payco.banco.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig{
	
	@Bean
	public OpenAPI springContasBancariasOpenAPI() {
		return new OpenAPI()
				.info(new Info()
					.title("API de Contas Bancárias")
					.description("API de gerenciamento de contas bancárias que permite criar, buscar, atualizar e deletar contas")
					.version("v1.0.0"));
	}
	
}

