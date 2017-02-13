package com.wornrole.sample;

import android.support.test.filters.SmallTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.worknrole.sample.externallibraries.butterknife.ButterKnifeActivity;

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
import static com.wornrole.sample.matchers.ImageViewMatcher.hasDrawable;

/**
 * Created by worknrole on 30/01/17.
 */

@RunWith(AndroidJUnit4.class)
@SmallTest
public class IUTFirstActivityTest {

    private String mSearchTerms;

    @Rule
    public ActivityTestRule<ButterKnifeActivity> mActivityRule =
            new ActivityTestRule<>(ButterKnifeActivity.class);

    @Before
    public void initSearchTerms() {
        mSearchTerms = "kitty snow";
    }

    @Test
    public void hasUpdateImageView() {
        // Type search terms
        onView(withId(R.id.searchTerms))
                .perform(typeText(mSearchTerms), closeSoftKeyboard());

        // Click on search button
        onView(withId(R.id.searchBtn))
                .perform(click());

        // Check if the image view has been loaded
        onView(withId(R.id.image))
                .check(matches(hasDrawable()));
    }
}
