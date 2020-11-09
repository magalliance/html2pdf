package com.byvalcev.pdf.config

import com.byvalcev.pdf.config.properties.PdfProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(PdfProperties::class)
class WebConfig