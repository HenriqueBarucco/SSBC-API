package com.henriquebarucco.ssbc.configuration

import SemanticLoggingFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered

@Configuration
class FilterConfig {
    @Bean
    fun semanticLoggingFilter(): FilterRegistrationBean<SemanticLoggingFilter> {
        val registration = FilterRegistrationBean(SemanticLoggingFilter())
        registration.order = Ordered.HIGHEST_PRECEDENCE
        registration.addUrlPatterns("/*")
        return registration
    }
}
