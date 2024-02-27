package com.kholmatov.alfathon

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kholmatov.alfathon.model.AlphaBets
import com.kholmatov.alfathon.view.AlphaBetAdapter

class MainActivity : ComponentActivity() {

    private val audioFiles = listOf(
        "alif", "ba", "taa", "tha", "jeem", "ha", "khaa", "dal",
        "dhal", "raa", "jaa", "seen", "sheen", "saad", "dhaad",
        "toa", "dhaa", "ain", "ghain", "faa", "qaaf", "kaaf",
        "laam", "meem", "noon", "haa", "waw", "yaa"
    )


    private val pronounce = listOf(
       "alef",  "baa’", "ta’", "tha’", "gem", "ha’", "kha’", "dal",
        "thal", "ra’", "zain", "sen", "shen", "sad", "da’",
        "ta’", "tha’", "ain", "ghain", "fa’", "qaaf", "kaf",
        "lam", "meem", "noon", "ha’", "waw", "yaa’"
    )

    private lateinit var alphaAdapter:AlphaBetAdapter
    private lateinit var alphaRecycler : RecyclerView
    private lateinit var alphaList:ArrayList<AlphaBets>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        alphaList = ArrayList()
        alphaRecycler = findViewById(R.id.alphaRecycler)
        alphaAdapter = AlphaBetAdapter(this,alphaList)

        val layoutM = GridLayoutManager(this,2)
        alphaRecycler.layoutManager = layoutM
        alphaRecycler.adapter = alphaAdapter
        /**set dummy List*/
        alphaLists()

    }


    private fun alphaLists() {

        for (item in audioFiles) {
            val alphaImg = resources.getIdentifier(item, "drawable", packageName)
            val alphaForm = resources.getIdentifier("${item}form", "drawable", packageName)
            val alphaSound = resources.getIdentifier(item, "raw", packageName)
            val alphaName = "${pronounce[audioFiles.indexOf(item)].capitalize()}"
            alphaList.add(AlphaBets(alphaImg, alphaForm, alphaSound, alphaName))
        }
    }



}