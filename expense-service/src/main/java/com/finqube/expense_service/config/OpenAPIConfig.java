package com.finqube.expense_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI expenseAppAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Expense App API")
                        .description("API documentation for Expense Tracking Application")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Sabari")
                                .email("sabari@example.com")
                        ));
    }
}
