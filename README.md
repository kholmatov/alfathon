# 📱 Alfathon — Arabic Alphabet Learning App

**Alfathon** is an educational Android app designed to help users learn and practice the Arabic alphabet. Users can browse all 28 Arabic letters, see their visual form, hear their pronunciation, and test their knowledge through interactive quizzes.

<table>
  <tr>
    <td><img src="https://play-lh.googleusercontent.com/56F8cyT4MSJ6QUxSLIkIkiNiHvAQg0PWEqk5sfumVKQkhbBjs2ks1Yl_Ty0mPFtLpw=w2560-h1440-rw" alt="Alfathon Screenshot 1" width="100%"/></td>
    <td><img src="https://play-lh.googleusercontent.com/0GxiIGQvl8V7JtNGyiTV-zb6pkhCTa8eSAUUcdJGvP3tKypjlA8NKhLj8rqxSHO4Gg=w2560-h1440-rw" alt="Alfathon Screenshot 2" width="100%"/></td>
  </tr>
</table>

## 🚀 Demo

Try the latest demo [here](https://play.google.com/store/apps/details?id=com.kholmatov.alfathon).

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
