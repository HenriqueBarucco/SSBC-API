package com.henriquebarucco.ssbc.configuration

import io.swagger.v3.oas.models.ExternalDocumentation
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License
import io.swagger.v3.oas.models.servers.Server
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig(
    @Value("\${spring.application.name}")
    private val applicationName: String,
) {
    @Bean
    fun customOpenAPI(): OpenAPI =
        OpenAPI()
            .info(
                Info()
                    .title(applicationName)
                    .description("API documentation for $applicationName")
                    .version("v1")
                    .contact(
                        Contact()
                            .name(applicationName),
                    ).license(
                        License()
                            .name("Apache 2.0")
                            .url("https://www.apache.org/licenses/LICENSE-2.0.html"),
                    ),
            ).externalDocs(
                ExternalDocumentation()
                    .description("Swagger UI")
                    .url("/docs"),
            ).servers(
                listOf(
                    Server().apply {
                        url = "/"
                        description = "Default Server URL"
                    },
                ),
            )
}
