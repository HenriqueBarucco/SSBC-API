import com.henriquebarucco.ssbc.utils.Logger.Companion.getLogger
import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.slf4j.MDC
import org.springframework.web.util.ContentCachingRequestWrapper
import org.springframework.web.util.ContentCachingResponseWrapper
import java.util.UUID

class SemanticLoggingFilter : Filter {
    private val logger = getLogger()

    override fun doFilter(
        request: ServletRequest,
        response: ServletResponse,
        chain: FilterChain,
    ) {
        val req = ContentCachingRequestWrapper(request as HttpServletRequest, 1024 * 1024)
        val res = ContentCachingResponseWrapper(response as HttpServletResponse)

        val start = System.currentTimeMillis()
        val requestId = UUID.randomUUID().toString()

        try {
            MDC.put("requestId", requestId)
            MDC.put("method", req.method)
            MDC.put("path", req.requestURI)
            MDC.put("query", req.queryString ?: "")
            MDC.put("client", req.remoteAddr)

            chain.doFilter(req, res)
        } finally {
            val duration = System.currentTimeMillis() - start

            MDC.put("status", res.status.toString())
            MDC.put("latencyMs", duration.toString())

            logRequest(req)
            logResponse(res)

            MDC.clear()
            res.copyBodyToResponse()
        }
    }

    private fun logRequest(request: ContentCachingRequestWrapper) {
        val body = request.contentAsByteArray.decodeToString()

        logger.info(
            "request.received {}",
            mapOf(
                "body" to body.ifBlank { null },
                "headers" to extractHeaders(request),
            ),
        )
    }

    private fun logResponse(response: ContentCachingResponseWrapper) {
        val body = response.contentAsByteArray.decodeToString()

        logger.info(
            "response.sent {}",
            mapOf(
                "body" to body.ifBlank { null },
                "headers" to extractHeaders(response),
            ),
        )
    }

    private fun extractHeaders(req: HttpServletRequest): Map<String, String> = req.headerNames.toList().associateWith { req.getHeader(it) }

    private fun extractHeaders(res: HttpServletResponse): Map<String, String> = res.headerNames.associateWith { res.getHeader(it) }
}
