# UI Automate Test With Espresso : Login Test
## Prepare
- You need to download and install Android Studio from https://developer.android.com/studio/
- Some android test project (you can clone this project for example)
- SDK API 24
- [BasicSample](https://developer.android.com/training/testing/espresso/basics) - Basic Espresso sample


## Set Up Espresso
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
  
 ## Create java class for test
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
@Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
 
   ```
  - 3.@Before used to specify which method should be executed before each test case (ex. use before register account for verify login case success in test case)
   ```javascript
    @Before
    public void RegisterEmail() throws InterruptedException  { //For Register New Account
        onView(withId(R.id.link_signup)).perform(click());
        onView(withId(R.id.input_name))
                .perform(typeText("Pheeraphone"), closeSoftKeyboard());
        onView(withId(R.id.input_address))
                .perform(typeText("SCB Test"), closeSoftKeyboard());
        onView(withId(R.id.input_email))
                .perform(typeText("pheeraphone.m@scb.com"), closeSoftKeyboard());
        onView(withId(R.id.input_mobile))
                .perform(typeText("0826780159"), closeSoftKeyboard());
        onView(withId(R.id.input_password))
                .perform(typeText("12345678"), closeSoftKeyboard());
        onView(withId(R.id.input_reEnterPassword))
                .perform(typeText("12345678"), closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(click());
        Thread.sleep(7000);
        onView(withId(R.id.btn_logout)).perform(click());
 
   ```

 - 4.@Test create your test function and annotate it with @Test which will tell JUnit that this is a test.
   ```javascript
    @Test
    public void LoginSuccess() throws InterruptedException{
        onView(withId(R.id.input_email))
                .perform(typeText("pheeraphone.m@scb.com"), closeSoftKeyboard());
        onView(withId(R.id.input_password))
                .perform(typeText("12345678"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        Thread.sleep(7000);
        onView(withId(R.id.btn_logout)).check(matches(isDisplayed()));
    }
 
   ```
   
   Besides @Before @Test you can add methods used inside the test class,which are @Test, @Before, @BeforeClass, @After, @AfterClass, @Rule

[Methods used inside the test class](https://www.guru99.com/junit-test-framework.html) - JUnit Test Cases @Before @BeforeClass Annotation

[JUnit method order execution](https://garygregory.wordpress.com/2011/09/25/understaning-junit-method-order-execution/) - Understanding JUnit method order execution
   

 ## The main components of Espresso
 - ViewMatchers – allows us to find a view in the view hierarchy.You can pass one or more of these to the **onView()**
 - ViewActions – allows us to perform automated actions on the view. Such as **clicks** etc.
 - ViewAssertions – allows us to assert the state of the view. **check()** is method Most of the time
 
 Example Click on id=btn_login

  ```javascript
    onView(withId(R.id.btn_login)).perform(click());
  ```
    
 Example Check id=btn_logout visible on screen

  ```javascript
    onView(withId(R.id.btn_logout)).check(matches(isDisplayed()));
  ```
  
   ## Espresso idling resources
   - Android espresso library does provide a class that helps to pause the test until the resource is idle.
   [About Espresso idling resources](Espresso idling resources) - Read more information about idling resources
  
  ## How to run Test
  - To run a single test, open the Project window, and then right-click a test and click Run
  - To test all methods in a class, right-click a class or method in the test file and click Run
  - To run all tests in a directory, right-click on the directory and select Run tests
  - you click the Export Test Results button in the Test Runner tab of the Run tool window.Test results can export to XML,HTML or XSL template
  [About Run Test](https://developer.android.com/training/testing/unit-testing/instrumented-unit-tests.html) - Read more information
  

   
