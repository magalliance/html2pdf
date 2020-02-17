package com.example.pdf.web

import com.example.pdf.utils.Converter
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import reactor.core.publisher.switchIfEmpty


@Component
class ApiHandler(
        private val converter: Converter
) {
    /**
     * Конвертация из HTML в поток байт для PDF
     *
     * @param request ServerRequest
     * @return Mono<ServerResponse>
     */
    fun convert2Pdf(request: ServerRequest): Mono<ServerResponse> {
        return request
                .bodyToMono<String>()
                .flatMap {
                    ServerResponse
                            .ok()
                            .contentType(MediaType.APPLICATION_OCTET_STREAM)
                            .body(converter.toStream(it).toMono())
                }.switchIfEmpty {
                    ServerResponse
                            .ok()
                            .contentType(MediaType.APPLICATION_JSON_UTF8)
                            .body("Empty request".toMono())
                }
    }
}