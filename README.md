# 📱 Alfathon — Arabic Alphabet Learning App

**Alfathon** is an educational Android app designed to help users learn and practice the Arabic alphabet. Users can browse all 28 Arabic letters, see their visual form, hear their pronunciation, and test their knowledge through interactive quizzes.

## ✨ Features

- 🧠 **Interactive Test Mode**  
  Test your ability to recognize Arabic letters with 3-option quizzes and instant feedback.

- 🔊 **Audio Pronunciation**  
  Each letter comes with native-like audio playback to reinforce pronunciation.

- 🔡 **Visual Forms**  
  Displays both the isolated Arabic character and its basic shape.

- 🎨 **Clean & Intuitive UI**  
  User-friendly layout, optimized for focus and clarity.

- 🔁 **Instant Feedback**  
  Hear the letter and see whether your answer was correct before proceeding.

## 📂 Project Structure

```
app/
├── java/com.kholmatov.alfathon/
│   ├── MainActivity.kt
│   ├── TestActivity.kt
│   ├── AlphaData.kt
│   └── model/AlphaBets.kt
├── res/
│   ├── layout/
│   │   ├── activity_main.xml
│   │   └── activity_test.xml
│   ├── values/
│   │   └── styles.xml
│   ├── raw/           ← contains all pronunciation audio files
│   └── drawable/      ← contains all letter images and forms
```

## 🛠 Setup Instructions

1. Clone this repo or download the source
2. Open the project in **Android Studio**
3. Make sure you have:
   - Android SDK 21+
   - Kotlin support
4. To run:
   - Select a device/emulator
   - Click ▶️ Run

## 📦 Build Info

- **Min SDK:** 21  
- **Target SDK:** 33+  
- **Language:** Kotlin  
- **UI Toolkit:** Android Views + RecyclerView  
- **Audio:** Local `.mp3` files in `res/raw/`

## 🗒 License

This project is for educational and non-commercial use.