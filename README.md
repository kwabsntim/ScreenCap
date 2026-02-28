#ScreenCap

This is a simple Android application built with Jetpack Compose.

## Purpose
This app was created to solve the problem of not having a built-in screen recorder on my phone. It provides a simple and accessible way to record your device's screen directly from the app.

## Features
- Uses Jetpack Compose for UI
- Demonstrates how to create and style a round button
- Modern Android app structure
- Designed to help users record their screen when their device lacks a default screen recorder

## How to Run
1. Open the project in Android Studio.
2. Connect an Android device or start an emulator.
3. Click the **Run** button or use `Shift + F10` to build and launch the app.

## Key Files
- `app/src/main/java/com/example/myapplication/MainActivity.kt`: Main activity and UI code.
- `app/build.gradle.kts`: App-level Gradle configuration.
- `build.gradle.kts`: Project-level Gradle configuration.

## Styling the Button
The button in `FilledButtonExample` uses `CircleShape` to make it round:
```kotlin
Button(
    onClick = { /* ... */ },
    shape = CircleShape,
    // ...other styling
) {
    Text("Start Recording")
}
```
You can further customize the button using the `colors`, `modifier`, and other parameters.

## Requirements
- Android Studio Flamingo or newer
- Kotlin 1.8+
- Gradle 8.0+

## License
This project is for learning purposes.
