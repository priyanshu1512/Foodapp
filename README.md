# Recipe and Book Explorer App

## Overview
This Android application showcases recipes and books using modern Android development practices. It fetches recipe data from TheMealDB API and book data from OpenLibrary API, displaying them in an organized, tabbed interface using Jetpack Compose.

## Features
- *Tabbed Navigation*: Switch between Recipes and Books categories
- *Recipe Categories*: Browse various food categories with images and descriptions
- *Book Collection*: Explore popular books with cover images and author details
- *Detail Views*: View detailed information about each recipe category
- *Modern UI*: Built with Material Design 3 components

## Technical Stack
- *Language*: Kotlin
- *UI Framework*: Jetpack Compose
- *Architecture*: MVVM (Model-View-ViewModel)
- *Network*: Retrofit for API calls
- *Image Loading*: Coil for asynchronous image loading
- *Navigation*: Jetpack Navigation Compose
- *Concurrency*: Kotlin Coroutines for asynchronous operations

## APIs Used
- TheMealDB API: https://www.themealdb.com/api/json/v1/1/
- OpenLibrary API: https://openlibrary.org/search.json

## Project Structure

app/
├── src/
│   ├── main/
│   │   ├── java/eu/tutorials/myrecipeapp/
│   │   │   ├── ApiService.kt
│   │   │   ├── Category.kt
│   │   │   ├── Book.kt
│   │   │   ├── MainActivity.kt
│   │   │   ├── MainViewModel.kt
│   │   │   ├── RecipeApp.kt
│   │   │   ├── RecipeScreen.kt
│   │   │   ├── CategoryDetailScreen.kt
│   │   │   └── Screen.kt
│   │   └── res/
│   │       └── ...
└── build.gradle


## Setup Instructions
1. Clone the repository
2. Open the project in Android Studio
3. Sync project with Gradle files
4. Run the app on an emulator or physical device

## Dependencies
gradle
dependencies {
    // Jetpack Compose
    implementation "androidx.compose.ui:ui"
    implementation "androidx.compose.material3:material3"
    
    // Navigation
    implementation "androidx.navigation:navigation-compose"
    
    // Network
    implementation "com.squareup.retrofit2:retrofit"
    implementation "com.squareup.retrofit2:converter-gson"
    
    // Image Loading
    implementation "io.coil-kt:coil-compose"
}


## Screenshots
![list](https://github.com/user-attachments/assets/ae24be30-656a-4078-ab6d-d17f0d6e5384)
![bl](https://github.com/user-attachments/assets/6f8b5392-0c52-4083-9147-6f79e09858ec)
![ap](https://github.com/user-attachments/assets/8468932f-1335-41b7-ab9e-49de54baf9c0)
![ll](https://github.com/user-attachments/assets/b99db897-f9e4-41b5-b1bf-393fb5e187f1)
![re](https://github.com/user-attachments/assets/57e16bb6-cffb-466d-8785-7506e34ff3f8)

## Future Enhancements

- Search functionality for both recipes and books
- Book detail screen
- Favorites feature
- Offline support using Room database
- User authentication
- Share functionality

## Contributing
Feel free to fork this project and submit pull requests. For major changes, please open an issue first to discuss what you would like to change.

## Author
[Your Name]

## Acknowledgments
- TheMealDB for the recipe API
- OpenLibrary for the books API
- Android development community

---
For any queries or issues, please open an issue in the repository.
