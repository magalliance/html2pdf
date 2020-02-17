package com.example.pdf.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.function.Executable

class ConverterTest {

    @Test
    fun `money to string`() {
        Assertions.assertAll(
                Executable { Assertions.assertEquals("ноль рублей 01 копейка", Converter.Money.toStr(0.0149)) },
                Executable { Assertions.assertEquals("один рубль 02 копейки", Converter.Money.toStr(01.0151)) }
        )
    }
}