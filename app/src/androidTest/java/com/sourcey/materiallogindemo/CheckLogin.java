package com.sourcey.materiallogindemo;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.idling.CountingIdlingResource;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class CheckLogin {
    private String name_register = "Pheeraphone" ;
    private String address_register = "address test" ;
    private String email_register = "pheeraphone.m@a.com" ;
    private String mobile_register = "0826780159" ;
    private String password_register = "12345678" ;
    private CountingIdlingResource mIdlingRes = new CountingIdlingResource("WaitUntilVisible");
    WaitUntilVisible WaitLogout = new WaitUntilVisible();
    CountingIdlingResource registerWait = WaitLogout.getIdlingResource();

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Before
    public void setUp()
    {
        IdlingRegistry.getInstance().register(registerWait);
        RegisterEmail();
    }

    @Test
    public void LoginSuccess() throws InterruptedException{
        onView(withId(R.id.input_email))
                .perform(typeText(email_register), closeSoftKeyboard());
        onView(withId(R.id.input_password))
                .perform(typeText(password_register), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        WaitLogout.WaitByID(R.id.btn_logout);
        onView(withId(R.id.btn_logout)).check(matches(isDisplayed()));
    }

    @After
    public void teardown()
    {
       IdlingRegistry.getInstance().unregister(registerWait);
    }

    public void RegisterEmail() { //For Register New Account
        onView(withId(R.id.link_signup)).perform(click());
        onView(withId(R.id.input_name))
                .perform(typeText(name_register), closeSoftKeyboard());
        onView(withId(R.id.input_address))
                .perform(typeText(address_register), closeSoftKeyboard());
        onView(withId(R.id.input_email))
                .perform(typeText(email_register), closeSoftKeyboard());
        onView(withId(R.id.input_mobile))
                .perform(typeText(mobile_register), closeSoftKeyboard());
        onView(withId(R.id.input_password))
                .perform(typeText(password_register), closeSoftKeyboard());
        onView(withId(R.id.input_reEnterPassword))
                .perform(typeText(password_register), closeSoftKeyboard());
        onView(withId(R.id.btn_signup)).perform(click());
        WaitLogout.WaitByID(R.id.btn_logout);
        onView(withId(R.id.btn_logout)).perform(click());

    }




}
