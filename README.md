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
Screenshots

![WhatsApp Image 2025-09-30 at 1 13 35 AM](https://github.com/user-attachments/assets/24100a8d-6317-40b2-9c36-f6a4bd4fb1bd)

Signup form

![WhatsApp Image 2025-09-30 at 1 10 44 AM](https://github.com/user-attachments/assets/1f49e973-9c29-4ef2-87b3-0ae3cb8747d7)

![WhatsApp Image 2025-09-30 at 1 11 29 AM](https://github.com/user-attachments/assets/3d2f55f2-8dd1-471c-a107-9fcb5dc58aa5)

Login Form

![WhatsApp Image 2025-09-30 at 1 12 22 AM](https://github.com/user-attachments/assets/b65a1d53-4eb6-40b6-a472-f597069edccc)

Basic Dashboard

![WhatsApp Image 2025-09-30 at 1 12 36 AM](https://github.com/user-attachments/assets/64e706de-9494-4fb6-8281-9b4a37edc7a8)

User Settings

![WhatsApp Image 2025-09-30 at 1 12 46 AM](https://github.com/user-attachments/assets/8a2c5418-e2b8-4ce4-a6c5-40e4e59523b3)

Dummy Leaderboards




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
