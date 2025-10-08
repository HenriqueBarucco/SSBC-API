package com.henriquebarucco.ssbc.configuration

import feign.codec.Encoder
import feign.form.spring.SpringFormEncoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FeignConfig {
    @Bean
    fun encoder(): Encoder = SpringFormEncoder()
}
