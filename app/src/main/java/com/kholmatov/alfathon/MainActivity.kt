package com.kholmatov.alfathon

import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kholmatov.alfathon.ui.theme.AlfathonTheme

class MainActivity : ComponentActivity() {
    private val letters = listOf(
        "ا", "ب", "ت", "ث", "ج", "ح", "خ", "د", "ذ", "ر", "ز", "س", "ش", "ص", "ض",
        "ط", "ظ", "ع", "غ", "ف", "ق", "ك", "ل", "م", "ن", "ه", "و", "ي"
    )

    private val audioFiles = listOf(
        "alif", "ba", "taa", "tha", "jeem", "ha", "khaa", "dal",
        "dhal", "raa", "jaa", "seen", "sheen", "saad", "dhaad",
        "toa", "dhaa", "ain", "ghain", "faa", "qaaf", "kaaf",
        "laam", "meem", "noon", "haa", "waw", "yaa"
    )


    private var mediaPlayer: MediaPlayer? = null

    private fun getResourceId(audioFileName: String): Int {
        return resources.getIdentifier(audioFileName, "raw", packageName)
    }

    private fun checkResourceExistence(resourceName: String): Boolean {
//        Log.d("MainActivity"," $packageName, $resourceName")
        val resId = resources.getIdentifier(resourceName, "raw", packageName)
        return resId != 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlfathonTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LetterButtons(letters, playLetterSound = ::playLetterSound)
                }
            }
        }
    }

    private fun playLetterSound(letter: String) {

        val audioFileName = audioFiles[letters.indexOf(letter)] //alif.mp3
//        val audioFileName = "alif.mp3"
//        if (checkResourceExistence(audioFileName)) {
//            // Ресурс существует, продолжаем выполнение кода
//            Log.d("MainActivity", "Resource $audioFileName. OK!")
//        } else {
//            // Ресурс не существует
//            Log.e("MainActivity", "Resource $audioFileName does not exist.")
//        }



        mediaPlayer?.stop() // Stop any previous sound

        val resId = getResourceId(audioFileName)
//        Log.d("MainActivity", "Resource ID for $audioFileName: $resId")
        if (resId != 0) {
            mediaPlayer = MediaPlayer.create(this, resId)
            mediaPlayer?.start()
        } else {
            Log.e("MainActivity", "Invalid resource ID for file: $audioFileName")
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
    }
}

@Composable
fun LetterButtons(
    letters: List<String>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(5.dp),
    playLetterSound: (String) -> Unit
) {
    val columns = GridCells.Fixed(4)

    LazyVerticalGrid(
        modifier = modifier,
        columns = columns,
        horizontalArrangement = Arrangement.SpaceBetween,
        contentPadding = contentPadding
    ) {
        items(letters) { letter ->
            Card(
                modifier = Modifier
                    .padding(1.dp)
                    .fillMaxWidth(0.25f)
                    .aspectRatio(1f)
                    .clickable {
                        playLetterSound(letter)
                    }
                    .border(
                        width = 2.dp,
                        color = Color.DarkGray,
                        shape = RectangleShape
                    )
            ) {
                Text(
                    text = letter,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(20.dp)
                )
            }
        }
    }
}
