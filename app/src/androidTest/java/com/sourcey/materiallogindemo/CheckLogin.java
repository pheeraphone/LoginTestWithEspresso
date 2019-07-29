package com.sourcey.materiallogindemo;

import androidx.test.espresso.idling.CountingIdlingResource;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

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

    private CountingIdlingResource countingResource;
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    @Before
    public void RegisterEmail() throws InterruptedException  { //For Register New Account
        onView(withId(R.id.link_signup)).perform(click());
        onView(withId(R.id.input_name))
                .perform(typeText("Pheeraphone"), closeSoftKeyboard());
        onView(withId(R.id.input_address))
                .perform(typeText("Test"), closeSoftKeyboard());
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

    }


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


}
