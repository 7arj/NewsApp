#  Android News App (Kotlin, MVVM)

An **Android news application** built using **Kotlin** and **MVVM architecture**, which fetches and displays real-time news from a public REST API.  
The app demonstrates clean architecture, proper state handling, and best practices used in production Android apps.

---

## Features

-  **MVVM Architecture** (Model–View–ViewModel)
-  **REST API integration** using Retrofit
-  **Kotlin Coroutines** for asynchronous network calls
-  **RecyclerView** with CardView-based UI
-  **Image loading & caching** using Glide
-  **Loading state handling** with ProgressBar
-  **Error state handling** (network / API failures)
-  **Click navigation** to open full news articles in browser
-  **Secure API key handling** using Gradle BuildConfig

---

## 🧱 Architecture

The app follows **MVVM (Model–View–ViewModel)** to ensure separation of concerns and testability.

---

## Tech Stack

- **Language:** Kotlin
- **Architecture:** MVVM
- **Networking:** Retrofit + Gson
- **Async:** Kotlin Coroutines
- **UI:** RecyclerView, MaterialCardView, ViewBinding
- **Image Loading:** Glide
- **API:** GNews API 


## Getting Started

1. ### Clone the repository
 ```
git clone https://github.com/7arj/NewsApp.git
```
2. ### Open in Android Studio
 - Android Studio Koala (2024.1.1+) recommended

3. ### Add API Key
Create / update gradle.properties (project root):
```
GNEWS_API_KEY=your_api_key_here
```

