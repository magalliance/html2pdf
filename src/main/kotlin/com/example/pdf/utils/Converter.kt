package com.example.pdf.utils

import com.github.moneytostr.MoneyToStr
import com.itextpdf.html2pdf.*
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider
import com.itextpdf.layout.font.FontProvider
import com.example.pdf.config.properties.PdfProperties
import java.io.*
import org.springframework.core.io.InputStreamResource
import org.springframework.stereotype.Service

@Service
class Converter (
        pdfProperties: PdfProperties
) {
    private val fontsPath = pdfProperties.fontsPath
    private var converterProperties: ConverterProperties? = ConverterProperties()
    private var fontProvider: FontProvider? = DefaultFontProvider(false, false, false)

    init {
        fontProvider?.addDirectory(fontsPath)
        converterProperties?.fontProvider = fontProvider
    }

    fun toStream(html: String?): InputStreamResource {
        val out = ByteArrayOutputStream()
        HtmlConverter.convertToPdf(html, out, converterProperties)
        out.close()
        return InputStreamResource(ByteArrayInputStream(out.toByteArray()))
    }

    object Money {
        private val moneyToStr = MoneyToStr(MoneyToStr.Currency.RUR, MoneyToStr.Language.RUS, MoneyToStr.Pennies.NUMBER)
        fun toStr(amount: Double?): String {
            return moneyToStr.convert(amount)
        }
    }
}