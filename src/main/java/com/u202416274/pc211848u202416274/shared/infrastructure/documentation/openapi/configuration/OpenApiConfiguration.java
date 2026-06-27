package com.u202416274.pc211848u202416274.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

/**
 * OpenAPI configuration for Swagger UI.
 *
 * @author Victor Paredes Maza
 */
@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "PC2 Platform API",
                version = "1.0.0",
                description = "RESTful API for PC2 Platform."
        )
)
public class OpenApiConfiguration {
}