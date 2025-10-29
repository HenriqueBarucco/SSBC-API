package com.henriquebarucco.ssbc.external.lmstudio

import com.henriquebarucco.ssbc.external.lmstudio.dto.ChatCompletionResponse
import com.henriquebarucco.ssbc.utils.Logger.Companion.getLogger
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.Base64
import kotlin.math.min

@Component
class LmStudioService(
    private val client: LmStudioClient,
    @Value("\${lmstudio.model}") private val model: String,
    @Value("\${lmstudio.max-retries}") private val maxRetries: Int,
    @Value("\${lmstudio.retry-base-delay}") private val retryBaseDelaySeconds: Double,
) {
    private val logger = getLogger()

    fun performImageExtraction(imageBytes: ByteArray): String {
        val payload =
            mapOf(
                "model" to model,
                "messages" to buildMessagesWithImage(imageBytes),
                "stream" to false,
                "temperature" to 0,
                "max_tokens" to 200,
            )

        var attempt = 0
        var lastError: Exception? = null

        while (attempt <= maxRetries) {
            try {
                val resp: ChatCompletionResponse = client.chatCompletions(payload)
                val content =
                    resp.choices
                        .firstOrNull()
                        ?.message
                        ?.content
                        ?.trim()
                if (!content.isNullOrBlank()) {
                    logger.info("[LMSTUDIO] Extraction completed on attempt=${attempt + 1}")
                    return content
                }
                throw IllegalStateException("Empty content returned by LM Studio")
            } catch (ex: Exception) {
                lastError = ex
                if (attempt >= maxRetries) break
                val delaySec = min(retryBaseDelaySeconds * (1 shl attempt), 10.0)
                logger.warn(
                    "[LMSTUDIO] Attempt ${attempt + 1} failed: ${ex.javaClass.simpleName}: ${ex.message}. Retrying in ${"%.2f".format(
                        delaySec,
                    )}s ...",
                )
                try {
                    Thread.sleep((delaySec * 1000).toLong())
                } catch (_: InterruptedException) {
                    Thread.currentThread().interrupt()
                    break
                }
                attempt += 1
            }
        }

        logger.error("[LMSTUDIO] All attempts failed", lastError)

        return ""
    }

    private fun buildMessagesWithImage(imageBytes: ByteArray): List<Map<String, Any>> {
        val b64 = Base64.getEncoder().encodeToString(imageBytes)
        val mime = "image/jpeg"
        val dataUrl = "data:$mime;base64,$b64"

        logger.info("[LMSTUDIO] Payload image size (base64 chars)=${b64.length}")

        val instruction = (
            "Como um segurança de um sistema de monitoramento, analise a imagem fornecida " +
                "e descreva detalhadamente (mas de forma breve) o que você vê. " +
                "Procure por qualquer atividade suspeita, intrusos ou objetos fora do lugar. " +
                "Forneça uma descrição clara e concisa do cenário capturado na imagem."
        )

        return listOf(
            mapOf(
                "role" to "user",
                "content" to
                    listOf(
                        mapOf(
                            "type" to "text",
                            "text" to instruction,
                        ),
                        mapOf(
                            "type" to "image_url",
                            "image_url" to mapOf("url" to dataUrl),
                        ),
                    ),
            ),
        )
    }
}
