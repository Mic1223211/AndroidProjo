package com.example.androidprojo;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ChangeTextBehaviorTest {
    public static final String STRING_TO_BETYPED = "AndroidProjo";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void changeText_sameActivity(){

        onView(withId(R.id.editTextUserInput)).perform(typeText(STRING_TO_BETYPED),closeSoftKeyboard());

        onView(withId(R.id.changeTextBt)).perform(click());
        onView(withId(R.id.textToBeChanged)).check(matches(withText(STRING_TO_BETYPED)));
    }

    @Test
    public void changeText_newActivity(){
        onView(withId(R.id.editTextUserInput)).perform(typeText(STRING_TO_BETYPED),closeSoftKeyboard());
        onView(withId(R.id.activityChangeTextBtn)).perform(click());
        onView(withId(R.id.show_text_view)).check(matches(withText(STRING_TO_BETYPED)));
    }

}