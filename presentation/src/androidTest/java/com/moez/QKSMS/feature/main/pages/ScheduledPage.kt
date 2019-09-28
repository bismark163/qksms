package com.moez.QKSMS.feature.main.pages

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.moez.QKSMS.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher

fun checkThatMessageIsScheduled(conversationName: String) {
    Espresso.onView(ViewMatchers.withText(conversationName))
            .check(ViewAssertions.matches(ViewMatchers.withText(conversationName)))
}

fun checkThatScheduledMessageDeleted(conversationName: String) {
    Espresso.onView(ViewMatchers.withText(conversationName))
            .check(ViewAssertions.doesNotExist())
}

//Created via recorder
fun deleteScheduledMessage() {
    val linearLayout2 = Espresso.onView(
            Matchers.allOf(childAtPosition(
                    childAtPosition(
                            ViewMatchers.withId(R.id.custom),
                            0),
                    1),
                    ViewMatchers.isDisplayed()))
    linearLayout2.perform(ViewActions.click())
}

//Created via recorder
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