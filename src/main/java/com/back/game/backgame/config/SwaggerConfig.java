package com.back.game.backgame.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI(){
        return new OpenAPI()
//                .components(new Components()
//                        .addSecuritySchemes("bearer-key",new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"))
//                )
                .info(new Info().title("back game")
                        .description("Consumer API for backend game app")
                        .version("V 0.1.5")
                        .termsOfService("https://www.frc.com/")
                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
                .externalDocs(new ExternalDocumentation()
                        .description("SpringShop Wiki Documentation")
                        .url("https://springshop.wiki.github.org/docs"));
    }
}
