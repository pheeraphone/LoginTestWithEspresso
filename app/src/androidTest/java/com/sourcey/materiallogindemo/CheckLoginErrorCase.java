package com.sourcey.materiallogindemo;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;


@RunWith(AndroidJUnit4.class)
public class CheckLoginErrorCase {
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void LoginFailCaseInputEmailWrongFormat() {
        onView(withId(R.id.input_email))
                .perform(typeText("pheeraphone.mscb.com"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.input_email)).check(matches(hasErrorText("enter a valid email address")));
        onView(withId(R.id.btn_logout)).check(doesNotExist());
        onView(withText("Login failed")).inRoot(withDecorView(not(mainActivityActivityTestRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));

    }
    @Test
    public void LoginFailCaseInputPasswordLessThan4character (){
        onView(withId(R.id.input_email))
                .perform(typeText("pheeraphone.m@scb.com"), closeSoftKeyboard());
        onView(withId(R.id.input_password))
                .perform(typeText("123"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.input_password)).check(matches(hasErrorText("between 4 and 10 alphanumeric characters")));
        onView(withId(R.id.btn_logout)).check(doesNotExist());
        onView(withText("Login failed")).inRoot(withDecorView(not(mainActivityActivityTestRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));

    }

    @Test
    public void LoginFailCaseInputPasswordMoreThan10character (){
        onView(withId(R.id.input_email))
                .perform(typeText("pheeraphone.m@scb.com"), closeSoftKeyboard());
        onView(withId(R.id.input_password))
                .perform(typeText("12345678901"), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.input_password)).check(matches(hasErrorText("between 4 and 10 alphanumeric characters")));
        onView(withId(R.id.btn_logout)).check(doesNotExist());
        onView(withText("Login failed")).inRoot(withDecorView(not(mainActivityActivityTestRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));


    }


}
