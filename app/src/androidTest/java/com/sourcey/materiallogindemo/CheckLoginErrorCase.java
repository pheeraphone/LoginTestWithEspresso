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
    private String errortext_password = "between 4 and 10 alphanumeric characters" ;
    private String password_lessthan4character = "123" ;
    private String password_morethan10character = "12345678901" ;
    private String email_correct = "pheeraphone.m@a.com" ;
    private String email_invalid = "pheeraphone.ma.com" ;
    private String errortext_email = "enter a valid email address" ;
    private String errortext_loginfailed = "Login failed" ;

    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void LoginFailCaseInputEmailWrongFormat() {
        onView(withId(R.id.input_email))
                .perform(typeText(email_invalid), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.input_email)).check(matches(hasErrorText(errortext_email)));
        onView(withId(R.id.btn_logout)).check(doesNotExist());
        onView(withText(errortext_loginfailed)).inRoot(withDecorView(not(mainActivityActivityTestRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));

    }
    @Test
    public void LoginFailCaseInputPasswordLessThan4character (){
        onView(withId(R.id.input_email))
                .perform(typeText(email_correct), closeSoftKeyboard());
        onView(withId(R.id.input_password))
                .perform(typeText(password_lessthan4character), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.input_password)).check(matches(hasErrorText(errortext_password)));
        onView(withId(R.id.btn_logout)).check(doesNotExist());
        onView(withText(errortext_loginfailed)).inRoot(withDecorView(not(mainActivityActivityTestRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));

    }

    @Test
    public void LoginFailCaseInputPasswordMoreThan10character (){
        onView(withId(R.id.input_email))
                .perform(typeText(email_correct), closeSoftKeyboard());
        onView(withId(R.id.input_password))
                .perform(typeText(password_morethan10character), closeSoftKeyboard());
        onView(withId(R.id.btn_login)).perform(click());
        onView(withId(R.id.input_password)).check(matches(hasErrorText(errortext_password)));
        onView(withId(R.id.btn_logout)).check(doesNotExist());
        onView(withText(errortext_loginfailed)).inRoot(withDecorView(not(mainActivityActivityTestRule.getActivity().getWindow().getDecorView()))).check(matches(isDisplayed()));


    }


}
