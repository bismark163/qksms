/*
 * Copyright (C) 2017 Moez Bhatti <moez.bhatti@gmail.com>
 *
 * This file is part of QKSMS.
 *
 * QKSMS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * QKSMS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with QKSMS.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.moez.QKSMS.feature.main

import android.view.View
import android.view.ViewGroup
import android.view.ViewStub
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Root
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItem
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4

import com.moez.QKSMS.R
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.lang.Thread.sleep


@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    val test_text: String = "teeest"

    @Test
    fun openDIalogWithContact() {
        onView(withId(R.id.compose)).perform(click())
        onView(withId(R.id.chips)).perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, typeText("First Contact")))
        onView(withId(R.id.contacts))
                .perform(actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.message)).perform(typeText(test_text))
        onView(withId(R.id.send)).perform(click())
        onView(withText(test_text)).check(matches(withText(test_text)))
    }

    @Test
    fun sendConversationToArchieve() {
        onView(withId(R.id.title)).perform(swipeLeft())
        onView(withText("Archived conversation")).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))


    }






    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }

     fun focusAndEnterText(text: String)  {onView(
            Matchers.allOf(childAtPosition(
                    Matchers.allOf(withId(R.id.chips),
                            childAtPosition(
                                    withClassName(Matchers.`is`("android.widget.LinearLayout")),
                                    2)),
                    0),
                    isDisplayed())).perform(click(), typeText(text))}


}