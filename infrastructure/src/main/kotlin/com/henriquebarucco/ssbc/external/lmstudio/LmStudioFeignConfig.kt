package com.henriquebarucco.ssbc.external.lmstudio

import feign.Request
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.concurrent.TimeUnit

@Configuration
class LmStudioFeignConfig(
    @Value("\${lmstudio.timeout-seconds}") private val timeoutSeconds: Long,
) {
    @Bean
    fun feignRequestOptions(): Request.Options {
        val timeoutMs = TimeUnit.SECONDS.toMillis(timeoutSeconds).toInt()
        return Request.Options(timeoutMs, timeoutMs, true)
    }
}
