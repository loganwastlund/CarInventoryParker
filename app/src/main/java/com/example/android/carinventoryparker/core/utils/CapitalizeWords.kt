package com.example.android.carinventoryparker.core.utils

import java.util.Locale

fun capitalizeWords(input: String): String {
    return input.lowercase(Locale.ROOT).split(" ").joinToString(" ") { word ->
        word.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
        }
    }
}
