package com.wornrole.sample;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.worknrole.sample.realusage.activity.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static com.wornrole.sample.matchers.ListMatcher.childAtPosition;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by worknrole on 30/01/17.
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class IUTMainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void firstElementLaunchesFirstTestActivity() {
        // Click on the first elements
        onView(allOf(withId(R.id.itemLayout),
                childAtPosition(withId(R.id.list_view), 0), isDisplayed()))
                .perform(click());

        // Check if the main view of the second activity is visible
        // = The FirstTestActivity has been launched
        onView(withId(R.id.activityFirstTest))
                .check(matches(isDisplayed()));
    }
}
