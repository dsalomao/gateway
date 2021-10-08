package com.gateway.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties(ServiceMapper.class)
@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

    // Bean de exposição dos endpoints dos micro serviços
	@Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {

        return builder.routes()
			.route(p -> p
            // Declarações das rotas do Micro serviço de veículos
                .path("/veiculos")
                .uri("http://localhost:8081/veiculos"))
			.route(p -> p
                .path("/veiculos/salvar")
                .uri("http://localhost:8081/veiculos/salvar"))
        	.build();
    }
}
