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
  
 ### Create java class for test
Create java class in **app/java/com.sourcey.materiallogindemo (androidtest)**

- 1.Add "@RunWith(AndroidJUnit4.class)" to the code. (ex.my class name is CheckLogin)
 ```javascript
 @RunWith(AndroidJUnit4.class)
public class CheckLogin {
}
 
   ```
   The @Runwith annotation will tell the JUnit to run the tests in this class using the Android JUnit test runner.

  [AndroidJUnit4](https://developer.android.com/reference/android/support/test/runner/AndroidJUnit4) - AndroidJUnit4 Description
  
  - 2.Add "@Rule" the activity will be launched using the @Rule before test code begins
 ```javascript
 @RunWith(AndroidJUnit4.class)
@Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
 
   ```
