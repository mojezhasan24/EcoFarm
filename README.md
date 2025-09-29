🌱 EcoHarvester – SIH 2025 (PS: 25075)

<!-- Replace with actual banner -->

<p align="center"> <img src="https://img.shields.io/badge/Android-Java-green?logo=android" /> <img src="https://img.shields.io/badge/Architecture-MVVM-blue" /> <img src="https://img.shields.io/badge/Database-Room-orange" /> <img src="https://img.shields.io/badge/Build-Gradle-yellow" /> </p>
🚜 Project Overview

EcoHarvester is a gamified mobile application designed to promote sustainable farming practices among farmers. Through interactive missions, rewards, and social engagement, the app educates and motivates users to adopt eco-friendly techniques—such as composting, mulching, and soil testing.

Although full network connectivity and hardware integration may come later, this first version uses local storage (Room DB) for authentication and mission tracking. Later versions can migrate to cloud / Firebase for real-time syncing and richer features.

🎯 Objectives & Features

✨ Features
🔐 User Authentication – Local signup & login using Room DB
🗂 Mission Dashboard – Daily & weekly missions like composting, drip irrigation, soil testing
🏆 Gamification – Earn points & unlock badges for completed missions
📊 Leaderboard – Compete with peers & track rankings
👤 Profile Section – View progress, badges, and achievements
🧩 Modular Architecture (MVVM) – Easy to maintain and extend
☁️ Future Ready – Firebase/cloud integration can be added anytime


🧱 Project Structure
EcoHarvester/
 ├── app/
 │   ├── src/
 │   │   ├── main/
 │   │   │   ├── java/com/example/ecoharvester/
 │   │   │   │   ├── EcoHarvesterApp.java / .kt (Application class)  
 │   │   │   │   ├── MainActivity  
 │   │   │   │   ├── data/         (Room, DAOs, Entities)  
 │   │   │   │   ├── repository/   (business logic)  
 │   │   │   │   ├── ui/           (activities / fragments / composables)  
 │   │   │   │   ├── viewmodel/     (ViewModels)  
 │   │   │   │   └── di/           (Dependency Injection modules)  
 │   │   │   ├── res/  
 │   │   │   │   ├── layout/  
 │   │   │   │   ├── values/  
 │   │   │   │   └── drawable/  
 │   │   │   └── AndroidManifest.xml  
 ├── build.gradle  
 └── settings.gradle  

🛠 Setup Instructions
Clone the repository:
git clone <your-repo-url>

Open in Android Studio: Open > EcoHarvester

Sync Gradle (if not automatic)

Run on emulator or a physical device

Use the Sign Up screen to register a user

Access Dashboard to view missions

Mark mission as completed -> points / ranking update

💡 Future Enhancements (Planned)

Migrate authentication & data storage to Firebase / cloud

Allow offline + sync mode

Add push notifications to remind missions

Real-world sensors / IoT integration (soil moisture, weather APIs)

Community features: peer challenges, sharing progress

Advanced analytics & adaptability (suggest missions based on location, climate)

Security hardening & encrypted data storage

📚 References & Credits

SIH 2025 Problem 25075 “Gamified Platform for Sustainable Farming Practices”

Android Jetpack components (Room, ViewModel, Navigation)

Material Design guidelines

Open-source icons and resources
