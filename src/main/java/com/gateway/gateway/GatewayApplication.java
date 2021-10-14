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
            // Declarações das rotas do Micro serviço de veículos
			.route(p -> p
                .path("/veiculos")
                .uri("http://localhost:8081/veiculos"))
			.route(p -> p
                .path("/veiculos/salvar")
                .uri("http://localhost:8081/veiculos/salvar"))

            // Declarações das rotas do Micro serviço de reparos
            .route(p -> p   
                .path("/reparos")
                .uri("http://localhost:8082/reparos"))
            .route(p -> p
                .path("/reparos/salvar")
                .uri("http://localhost:8082/reparos/salvar"))

            // Declarações das rotas do Micro serviço de compras
            .route(p -> p   
                .path("/compras")
                .uri("http://localhost:8083/compras"))
            .route(p -> p
                .path("/compras/salvar")
                .uri("http://localhost:8083/compras/salvar"))

            // Declarações das rotas do Micro serviço de vendas
            .route(p -> p   
                .path("/vendas")
                .uri("http://localhost:8084/vendas"))
            .route(p -> p
                .path("/vendas/salvar")
                .uri("http://localhost:8084/vendas/salvar"))
        	.build();
    }
}
