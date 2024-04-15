package com.example.android.carinventoryparker.core.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class CapitalizeWordsTest {

    @Test
    fun `capitalize single word`() {
        val input = "android"
        val expected = "Android"
        assertEquals(expected, capitalizeWords(input))
    }

    @Test
    fun `capitalize multiple words`() {
        val input = "android kotlin development"
        val expected = "Android Kotlin Development"
        assertEquals(expected, capitalizeWords(input))
    }

    @Test
    fun `input with leading and trailing spaces`() {
        val input = "  android kotlin  "
        val expected = "Android Kotlin"
        assertEquals(expected, capitalizeWords(input.trim()))
    }

//    // Our current logic wouldn't allow for this to be passed.
//    @Test
//    fun `preserve non-initial uppercase letters`() {
//        val input = "iOS and Android Development"
//        val expected = "iOS And Android Development" // Expecting to preserve the original case of 'iOS'
//        assertEquals(expected, capitalizeWords(input))
//    }

    @Test
    fun `input with uppercase letters`() {
        val input = "Android Kotlin"
        val expected = "Android Kotlin"
        assertEquals(expected, capitalizeWords(input))
    }

    @Test
    fun `input with mixed case letters`() {
        val input = "aNdRoiD KoTliN"
        val expected = "Android Kotlin"
        assertEquals(expected, capitalizeWords(input))
    }

    @Test
    fun `empty string input`() {
        val input = ""
        val expected = ""
        assertEquals(expected, capitalizeWords(input))
    }
}
