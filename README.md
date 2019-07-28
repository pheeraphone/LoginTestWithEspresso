# UI Automate Test With Espresso : Login Test
You need to prepare your machine by download and install Android Studio from https://developer.android.com/studio/.

### Set Up Espresso
Go to **app/build.gradle** in your project

- 1.Add dependencies
 ```javascript
 //espresso
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.1.0'
    androidTestImplementation 'androidx.test:runner:1.1.0'
    androidTestImplementation 'androidx.test:rules:1.1.0'
  ```
- 2.Add defaultConfig
 ```javascript
    testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
  ```
