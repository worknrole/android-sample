package com.wornrole.sample.matchers;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.ImageView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * Created by worknrole on 30/01/17.
 *
 * A matcher for Espresso checking some properties of an ImageView
 */

public class ImageViewMatcher {

    public static Matcher<View> hasDrawable() {
        return new BoundedMatcher<View, AppCompatImageView>(AppCompatImageView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("has drawable");
            }

            @Override
            protected boolean matchesSafely(AppCompatImageView item) {
                return item.getDrawable() != null;
            }
        };
    }
}
