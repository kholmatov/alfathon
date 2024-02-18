package com.kholmatov.alfathon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kholmatov.alfathon.ui.theme.AlfathonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlfathonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LetterButtons()
                }
            }
        }
    }
}

@Composable
fun LetterButtons() {
    LazyColumn {
        items(28) { index ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                repeat(4) { innerIndex ->
                    val letter = getLetter(index * 4 + innerIndex) // Get corresponding letter
                    Button(
                        onClick = { /* Handle button click here */ },
                        modifier = Modifier.weight(1f) // Ensure equal width for each button
                    ) {
                        Text(letter)
                    }
                }
            }
        }
    }
}

// Define a list of 28 Arabic letters
private val letters = listOf(
    "ا", "ب", "ت", "ث", "ج", "ح", "خ", "د", "ذ", "ر", "ز", "س", "ش", "ص", "ض",
    "ط", "ظ", "ع", "غ", "ف", "ق", "ك", "ل", "م", "ن", "ه", "و", "ي"
)

// Get the letter at a given index
private fun getLetter(index: Int): String = letters[index % letters.size]

@Preview(showBackground = true)
@Composable
fun LetterButtonsPreview() {
    AlfathonTheme {
        LetterButtons()
    }
}