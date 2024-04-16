package com.example.android.carinventoryparker.core.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class CapitalizeWordsKtTest {

    @Test
    fun `capitalize single word`() {
        val input = "android"
        val expected = "Android"
        assertEquals(expected, capitalizeWords(input))
    }

    @Test
    fun `capitalize multiple words`() {
        val input = "android kotlin"
        val expected = "Android Kotlin"
        assertEquals(expected, capitalizeWords(input))
    }

    @Test
    fun `input with uppercase letters`() {
        val input = "iOS and android development"
        val expected = "iOS and Android Development"
        assertEquals(expected, capitalizeWords(input))
    }
}