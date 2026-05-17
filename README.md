Namma Mela – Community Hall Management App

 📱 Project Overview

Namma Mela is an Android application developed to help local communities manage public halls, events, and maintenance activities digitally. The app provides a transparent and easy-to-use platform for booking community halls, viewing upcoming events, managing maintenance requests, and connecting with key holders.

The main goal of the project is to improve community engagement and simplify hall management using modern Android technologies and Firebase cloud services.

 🏠 Home Dashboard

* Simple dashboard navigation
* Access all major modules

📅 Booking & Calendar

* Users can request hall bookings
* View booking status:

  * Pending
  * Approved
  * Rejected

👨‍💼 Admin Approval System

* Admin can approve or reject bookings
* Booking status updates in real time

 Maintenance Module

* Track maintenance items
* View repair cost and collected amount
* Progress bar for maintenance completion

 📇 Directory Module

* Displays key holder contact information
* One-tap phone call support

 👤 Authentication

* Firebase Authentication support
* User login/profile system

---

Tech Stack

| Technology                 | Usage               |
| -------------------------- | ------------------- |
| Kotlin                     | Android development |
| XML Layouts                | UI Design           |
| Firebase Realtime Database | Cloud database      |
| Firebase Authentication    | User authentication |
| RecyclerView               | Dynamic lists       |
| MVVM Architecture          | Project structure   |
| Material Design            | UI components       |

---

📂 Project Structure

```plaintext
com.nammamela.app
│
├── ui/
│   ├── main/
│   ├── calendar/
│   ├── booking/
│   ├── admin/
│   ├── maintenance/
│   └── profile/
│
├── model/
├── repository/
├── viewmodel/
└── utils/
```

---
🔥 Firebase Setup

 1. Create Firebase Project

* Open Firebase Console
* Create project named:
  `NammaMela`

2. Add Android App

Package name:

```plaintext
com.nammamela.app
```

 3. Download google-services.json

Place the file inside:

```plaintext
app/
```

 4. Enable Services

* Firebase Realtime Database
* Firebase Authentication



 ▶️ How to Run

1. Open project in Android Studio
2. Sync Gradle files
3. Connect Firebase
4. Add `google-services.json`
5. Run the app on emulator or Android device

---

 Minimum Requirements

* Android Studio Iguana or later
* API Level 24+
* Kotlin support enabled
* Internet connection for Firebase



* Push Notifications
* QR Code Check-In
* Regional Language Support
* Google Maps Integration
* AI-based Event Suggestions

---

👨‍💻 Developed By

Gowtham G M


📄 License

This project is developed for educational and academic purposes.
