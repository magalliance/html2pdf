package com.byvalcev.pdf.config.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(prefix = "pdf")
class PdfProperties {
    lateinit var fontsPath: String
}