# Android_Studio_Project
Android Projects

Overview

This repository contains a collection of Android projects demonstrating core concepts like the Android Life Cycle, notifications, maps and navigation, and a simple calculator app. Each project is a self-contained example of key Android functionalities, designed to help you understand the foundation of
Android app development.

Projects Included:

1.) HiAndroid

2.)Life Cycle of Android

3.)Calculator

4.)Notifications

5.)Maps and Navigation

Projects

1.) HiAndroid

Overview
The "HiAndroid" project is a simple "Hello, World!" app designed to get you familiar with basic Android development, layout design, and running your first Android application.

Steps:
Setup:

Open Android Studio and create a new project.
Choose the "Empty Activity" template.
Add a TextView to the layout XML file with the text "Hello, World!".
Run the application on an emulator or device.

Key Concepts:
Creating a new Android project.
Using TextView to display text.
Basic layout design with XML.

2.) Life Cycle of Android

Overview
This project demonstrates the Life Cycle of an Android app. Understanding the life cycle is essential to managing app states and optimizing resources.

Steps:
Create a New Project:

Open Android Studio and create a new project with a blank activity.
Override Life Cycle Methods:

In the MainActivity.java file, override the main life cycle methods like:
onCreate()
onStart()
onResume()
onPause()
onStop()
onDestroy()

Log Life Cycle Events:
Use Log.d() to print life cycle events in the log.
Observe how different states are triggered during the app’s lifecycle.

Key Concepts:
Understanding Activity life cycle in Android.
Managing app resources during different states.

3.) Calculator

Overview
The Calculator project demonstrates building a basic Android app that performs arithmetic operations. It involves handling user inputs, processing calculations, and displaying results.

Steps:
Create a New Project:

Open Android Studio and create a new project with a blank activity.
Design the Layout:

Use Button widgets for numbers and operations.
Use a TextView to display the calculation result.

Implement Functionality:
Set OnClickListener for each button to perform the corresponding operation (addition, subtraction, etc.).
Store input in a StringBuilder or similar method to handle multiple digits.

Key Concepts:
Handling user input in Android.
Implementing basic arithmetic operations.
Using TextView and Button widgets.

4.) Notifications

Overview
The Notifications project demonstrates how to show notifications in an Android app, notifying users of important events even when the app is in the background.

Steps:
Create a New Project:

Open Android Studio and create a new project.
Create Notification Channel (for Android 8.0 and above):

Use NotificationChannel to set up notification channels.

Build Notification:
Use NotificationCompat.Builder to create a notification.
Set notification properties like title, message, and icon.

Display Notification:
Use NotificationManager to display the notification.

Key Concepts:
Sending notifications to users.
Handling background notifications.
Notification channels for newer Android versions.
5.) Maps and Navigation

Overview
The Maps and Navigation project demonstrates how to integrate Google Maps into your Android application, allowing users to view maps and get directions to specific locations.

Steps:
Set Up Google Maps:

Go to the Google Cloud Console and enable the Maps SDK for Android.
Obtain an API key and configure it in your Android project’s AndroidManifest.xml.

Add Google Maps Fragment:
Use MapFragment in your layout XML to display the map.

Add Markers and Directions:
Use GoogleMap.addMarker() to add markers at specific locations.
Implement Polyline to show routes between two points.

Key Concepts:
Google Maps integration in Android apps.
Displaying locations and routes on a map.
Using GoogleMap API to customize map behavior
