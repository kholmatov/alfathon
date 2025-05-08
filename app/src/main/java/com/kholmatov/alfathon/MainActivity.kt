package com.kholmatov.alfathon

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kholmatov.alfathon.model.AlphaBets
import com.kholmatov.alfathon.view.AlphaBetAdapter
import com.kholmatov.alfathon.com.kholmatov.alfathon.AlphaData

class MainActivity : ComponentActivity() {

    private lateinit var alphaAdapter: AlphaBetAdapter
    private lateinit var alphaRecycler: RecyclerView
    private lateinit var alphaList: ArrayList<AlphaBets>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Launch test activity
        val testButton: Button = findViewById(R.id.testButton)
        testButton.setOnClickListener {
            startActivity(Intent(this, TestActivity::class.java))
        }

        // Load data
        alphaList = AlphaData.getAll(this) as ArrayList<AlphaBets>

        // Set up RecyclerView
        alphaRecycler = findViewById(R.id.alphaRecycler)
        alphaAdapter = AlphaBetAdapter(this, alphaList)
        alphaRecycler.layoutManager = GridLayoutManager(this, 2)
        alphaRecycler.adapter = alphaAdapter
    }
}