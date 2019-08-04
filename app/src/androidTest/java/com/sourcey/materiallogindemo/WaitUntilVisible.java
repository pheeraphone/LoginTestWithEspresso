package com.sourcey.materiallogindemo;

import androidx.test.espresso.idling.CountingIdlingResource;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.not;

public class WaitUntilVisible {
    CountingIdlingResource mIdlingRes = new CountingIdlingResource("WaitVisible");
    public void WaitByID(int Idverify) {
        try {
            onView(withId(Idverify)).check(matches(isDisplayed()));
        } catch (Exception notvisible) {
            mIdlingRes.increment();
            try {
                onView(withId(Idverify)).check(matches(not(isDisplayed())));
            } catch (Exception visible) {
                mIdlingRes.decrement();
            }
        }
    }

    public CountingIdlingResource getIdlingResource()
    {
        return mIdlingRes;
    }

}
