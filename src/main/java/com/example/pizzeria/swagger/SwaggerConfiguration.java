package com.example.pizzeria.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class SwaggerConfiguration {
    @Bean
    public OpenAPI springDocOpenApi() {
        return new OpenAPI()
                .info(springDocapiInfo());
                /*.security(List.of(new SecurityRequirement()));*/

    }
    Info springDocapiInfo() {
        return new Info()
                .title("Pizzeria")
                .version("1.0.0");
    }
}
