package com.example.pdf.config

import com.example.pdf.config.properties.PdfProperties
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@EnableConfigurationProperties(PdfProperties::class)
class WebConfig