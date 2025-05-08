package com.kholmatov.alfathon.com.kholmatov.alfathon

//package com.kholmatov.alfathon

import android.content.Context
import com.kholmatov.alfathon.model.AlphaBets

object AlphaData {

    private val audioFiles = listOf(
        "alif", "ba", "taa", "tha", "jeem", "ha", "khaa", "dal",
        "dhal", "raa", "jaa", "seen", "sheen", "saad", "dhaad",
        "toa", "dhaa", "ain", "ghain", "faa", "qaaf", "kaaf",
        "laam", "meem", "noon", "haa", "waw", "yaa"
    )

    private val pronounce = listOf(
        "alef", "baa’", "ta’", "tha’", "gem", "ha’", "kha’", "dal",
        "thal", "ra’", "zain", "sen", "shen", "sad", "da’",
        "ta’", "tha’", "ain", "ghain", "fa’", "qaaf", "kaf",
        "lam", "meem", "noon", "ha’", "waw", "yaa’"
    )

    private val arabicLetters = listOf(
        "ا", "ب", "ت", "ث", "ج", "ح", "خ", "د",
        "ذ", "ر", "ز", "س", "ش", "ص", "ض",
        "ط", "ظ", "ع", "غ", "ف", "ق", "ك",
        "ل", "م", "ن", "ه", "و", "ي"
    )

    fun getAll(context: Context): List<AlphaBets> {
        val list = mutableListOf<AlphaBets>()
        for ((i, item) in audioFiles.withIndex()) {
            val img = context.resources.getIdentifier(item, "drawable", context.packageName)
            val form = context.resources.getIdentifier("${item}form", "drawable", context.packageName)
            val sound = context.resources.getIdentifier(item, "raw", context.packageName)
            list.add(AlphaBets(img, form, sound, pronounce[i].capitalize(), arabicLetters[i]))
        }
        return list
    }
}