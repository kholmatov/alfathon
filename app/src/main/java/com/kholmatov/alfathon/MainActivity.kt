package com.kholmatov.alfathon

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
//import androidx.compose.foundation.BorderStroke
//import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
//import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
//import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.graphics.RectangleShape
//import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.style.TextAlign
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kholmatov.alfathon.ui.theme.AlfathonTheme

class MainActivity : ComponentActivity() {
    private var textToSpeech: TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlfathonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LetterButtons(letters, speakLetter = ::speakLetter, textToSpeech = textToSpeech)
                }
            }
        }

        // Initialize TextToSpeech outside of onCreate function
        textToSpeech = TextToSpeech(this) { status ->
            // Handle initialization status
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        textToSpeech?.shutdown()
    }

//    private fun speakLetter(letter: String) {
//        textToSpeech?.speak(letter, TextToSpeech.QUEUE_ADD, null, "letterId")
//    }

    // ... rest of the code remains the same
}

// Define a list of 28 Arabic letters
val letters = listOf(
    "ا", "ب", "ت", "ث", "ج", "ح", "خ", "د", "ذ", "ر", "ز", "س", "ش", "ص", "ض",
    "ط", "ظ", "ع", "غ", "ف", "ق", "ك", "ل", "م", "ن", "ه", "و", "ي"
)

// Define speakLetter function outside MainActivity
fun speakLetter(letter: String, textToSpeech: TextToSpeech?) {
    textToSpeech?.speak(letter, TextToSpeech.QUEUE_ADD, null, "letterId")
}

@Composable
fun LetterButtons(
    letters: List<String>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(5.dp),
    speakLetter: (String, TextToSpeech?) -> Unit,
    textToSpeech: TextToSpeech?, // Add textToSpeech parameter
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
                        speakLetter(letter, textToSpeech)
                    }.border(
                        width = 2.dp,
                        color = Color.DarkGray,
                        shape = RectangleShape
                    )
            ) {
                Text(
                    text = letter,
                    fontSize = 40.sp,
                    textAlign = TextAlign.Center,
//                    contentPadding = TextAlign.Center,
                    modifier = Modifier.padding(20.dp)
                )
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun LetterButtonsPreview() {
//    AlfathonTheme {
//        LetterButtons(letters = letters, speakLetter = ::speakLetter, textToSpeech = textToSpeech)
//    }
//}