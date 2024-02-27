package com.kholmatov.alfathon.view

import android.app.AlertDialog

import android.content.Context
import android.media.MediaPlayer

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.ImageView
import android.widget.TextView

import androidx.recyclerview.widget.RecyclerView
import com.kholmatov.alfathon.R
import com.kholmatov.alfathon.model.AlphaBets

import kotlin.collections.ArrayList

class AlphaBetAdapter(val c:Context,val alphaList:ArrayList<AlphaBets>):
 RecyclerView.Adapter<AlphaBetAdapter.AlphaViewHolder>()

{
    private val context = c
    private var mediaPlayer: MediaPlayer? = null



    inner class AlphaViewHolder(val v:View):RecyclerView.ViewHolder(v){
        val alphaImgs = v.findViewById<ImageView>(R.id.alphaImg)
        val alphaName = v.findViewById<TextView>(R.id.alphaName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlphaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.item_list,parent,false)
        return AlphaViewHolder(v)
    }

    override fun onBindViewHolder(holder: AlphaViewHolder, position: Int) {

       val alphaList = alphaList[position]
        holder.alphaImgs.setImageResource(alphaList.alphaImg)
        holder.alphaName.text = alphaList.alphaName
        holder.v.setOnClickListener {
            /**set speak*/
            playLetterSound(alphaList.alphaSound)
            /**set Dialog*/
            showAlpha(alphaList.alphaForm,alphaList.alphaName, alphaList.alphaSound)
        }

    }

    private fun playLetterSound(resId: Int) {


        mediaPlayer?.stop() // Stop any previous sound
        if (resId != 0) {
            mediaPlayer = MediaPlayer.create(this.context, resId)
            mediaPlayer?.start()
        } else {
            Log.e("MainActivity", "Invalid resource ID for file: $resId")
        }
    }

    private fun showAlpha(img: Int, name: String, alphaSound: Int) {
        val inflater = LayoutInflater.from(c)
        val setView = inflater.inflate(R.layout.show_item,null)
        /**set view */
        val nameAlpha = setView.findViewById<TextView>(R.id.alphaNames)
        val imgAlpha = setView.findViewById<ImageView>(R.id.alphaImgs)
        val btnCancel = setView.findViewById<ImageView>(R.id.btnCancel)
        nameAlpha.text = name
        imgAlpha.setImageResource(img)
        val showDialog = AlertDialog.Builder(c)
        showDialog.setCancelable(true)
        showDialog.setView(setView)
        val openDialog = showDialog.create()
        btnCancel.setOnClickListener { openDialog.dismiss() }
        openDialog.show()
        nameAlpha.setOnClickListener { nameAlpha.animate()
            .scaleX(1.2f)
            .scaleY(1.2f)
            .setDuration(200)
            .withEndAction {
                nameAlpha.scaleX = 1f
                nameAlpha.scaleY = 1f
            }
            .start()
            playLetterSound(alphaSound)
        }

        imgAlpha.setOnClickListener {
            nameAlpha.animate()
                .scaleX(1.2f)
                .scaleY(1.2f)
                .setDuration(200)
                .withEndAction {
                    nameAlpha.scaleX = 1f
                    nameAlpha.scaleY = 1f
                }
                .start()

            playLetterSound(alphaSound) }
    }

    override fun getItemCount(): Int {
        return alphaList.size
    }


}