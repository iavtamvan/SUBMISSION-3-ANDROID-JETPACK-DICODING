package com.iavariav.submission1.ui.movie;

import androidx.test.rule.ActivityTestRule;

import com.iavariav.submission1.R;
import com.iavariav.submission1.testing.SingleFragmentActivity;
import com.iavariav.submission1.utils.RecyclerViewItemCountAssertion;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

public class MovieFragmentTest {
    @Rule
    public ActivityTestRule<SingleFragmentActivity> activityRule = new ActivityTestRule<>(SingleFragmentActivity.class);
    private MovieFragment bookmarkFragment = new MovieFragment();

    @Before
    public void setUp() {
        activityRule.getActivity().setFragment(bookmarkFragment);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void loadCourses() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_movie)).check(new RecyclerViewItemCountAssertion(20));
    }
}