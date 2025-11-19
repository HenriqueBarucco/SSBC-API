package com.henriquebarucco.ssbc.configuration

import SemanticLoggingFilter
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered

@Configuration
class FilterConfig(
    @Value("\${logging.uris-to-ignore}")
    private val urisToIgnore: String,
) {
    @Bean
    fun semanticLoggingFilter(): FilterRegistrationBean<SemanticLoggingFilter> {
        val registration = FilterRegistrationBean(SemanticLoggingFilter(urisToIgnore.split(",")))
        registration.order = Ordered.HIGHEST_PRECEDENCE
        registration.addUrlPatterns("/*")
        return registration
    }
}
