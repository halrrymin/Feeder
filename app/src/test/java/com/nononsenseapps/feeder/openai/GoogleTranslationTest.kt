package com.nononsenseapps.feeder.openai

import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test

class GoogleTranslationTest {
    @Test
    fun languageAliases() {
        assertEquals("en", googleLanguageCode("English"))
        assertEquals("zh-CN", googleLanguageCode("zh"))
        assertEquals("zh-TW", googleLanguageCode("zh-Hant"))
        assertEquals("iw", googleLanguageCode("he"))
    }

    @Test
    fun responseParsing() {
        assertEquals("Bonjour", googleFirstTranslation(Json.parseToJsonElement("[[\"Bonjour\",\"hello\"],\"en\"]")))
        assertNull(googleFirstTranslation(Json.parseToJsonElement("[[],null]")))
    }
}
