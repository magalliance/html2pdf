package com.byvalcev.pdf.web

import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.router

@Component
class Routes (
        private val apiHandler: ApiHandler
) {
    @Bean
    fun route() = router {
        accept(MediaType.APPLICATION_JSON_UTF8).nest {
            POST("/html2pdf", apiHandler::convert2Pdf)
        }
    }
}