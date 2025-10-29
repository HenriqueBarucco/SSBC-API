package com.henriquebarucco.ssbc.external.lmstudio

import com.henriquebarucco.ssbc.external.lmstudio.dto.ChatCompletionResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "lmstudio-client", url = "\${lmstudio.url}")
interface LmStudioClient {
    @PostMapping(value = ["/v1/chat/completions"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun chatCompletions(
        @RequestBody payload: Map<String, Any>,
    ): ChatCompletionResponse
}
