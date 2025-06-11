package com.cinemaproject.appcore.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Movie API")
                .version("1.0")
                .description("API for managing movies using Spring WebFlux and functional routing"));
    }

    // Puedes añadir más configuración si defines grupos o tags manualmente
}

