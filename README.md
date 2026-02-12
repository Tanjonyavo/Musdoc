# Musdoc — Android Music Therapy App

Musdoc is an Android application designed to support emotional well-being through music therapy.  
Users can explore curated music by emotional state, play audio tracks, and manage favorites in a simple and focused interface.

This project was built as a student project to demonstrate Android fundamentals, Kotlin development, and basic mobile architecture.

---


## Features

- Emotional categories (stress, anxiety, depression, etc.)
- Built-in audio player
- Favorite tracks system
- Local music catalog
- Multi-screen navigation
- Simple user flow

---

## Screenshots



<p float="left">
  <img src="screenshots/home.jpg" width="200"/>
  <img src="screenshots/list.jpg" width="200"/>
  <img src="screenshots/player.jpg" width="200"/>
  <img src="screenshots/favorites.jpg" width="200"/>
</p>

---

Validation & Testing Strategy

Framework: JUnit 5
Build tool: Maven
Run tests:

mvn test

Total test coverage includes validation of:

Core Game Logic

Move initialization correctness

Capture detection during move execution

Move without capture validation

Position repetition detection (3-fold repetition tracking)

Piece coordinate handling and state integrity

Check detection:

King in check by Rook

King in check by Pawn

King not in check

UI Logic

Game cadence selection (Blitz / Rapid / Classical)

Proper configuration of game time

Clock decrement logic

Clock stop at zero

Proper formatting of timer display

Game over window rendering and message validation

Stability Tests

Music player initialization without runtime exceptions

Example of Validated Rules
Rule / Behavior	Test Type	Status
Move coordinate assignment	Unit	✔
Capture detection	Unit	✔
Non-capture move	Unit	✔
Repetition counter	Unit	✔
King in check detection	Logic	✔
Clock decrement	Unit	✔
Clock stop at 0	Unit	✔
Cadence configuration (UI interaction)	Functional	✔
Key Technical Features

Rule-based move validation

Board state management

Check detection engine

Game timer system

Modular piece hierarchy

Automated validation tests

## Tech Stack

- Kotlin
- Android SDK
- ViewBinding
- MVVM (light architecture)
- SQLite
- MediaPlayer API
- Gradle

---

## Getting Started

### Requirements

- Android Studio
- JDK 11 or higher

### Build

```bash
./gradlew assembleDebug
</p>

---

## Tech Stack

- Kotlin
- Android SDK
- ViewBinding
- MVVM (light architecture)
- SQLite
- MediaPlayer API
- Gradle

---

## Getting Started

### Requirements

- Android Studio
- JDK 11 or higher

### Build

```bash
./gradlew assembleDebug
