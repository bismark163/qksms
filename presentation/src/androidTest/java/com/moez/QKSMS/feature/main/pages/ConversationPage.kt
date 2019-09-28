package com.moez.QKSMS.feature.main.pages

import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.PickerActions
import androidx.test.espresso.matcher.ViewMatchers
import com.moez.QKSMS.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher

fun enterTextInMessageField(messageText: String) {
    Espresso.onView(ViewMatchers.withId(R.id.message))
            .perform(ViewActions.typeText(messageText))
}

fun clickOnSendButton() {
    Espresso.onView(ViewMatchers.withId(R.id.send))
            .perform(ViewActions.click())
}

fun checkThatMessageSent (messageText: String) {
    Espresso.onView(ViewMatchers.withText(messageText))
            .check(ViewAssertions.matches(ViewMatchers.withText(messageText)))
}

fun closeConversation() {
    Espresso.onView(ViewMatchers.withContentDescription("Navigate up"))
            .perform(ViewActions.click())
}

fun openMenu() {
    Espresso.onView(ViewMatchers.withId(R.id.attach))
            .perform(ViewActions.click())
}

fun clickOnSchedule() {
    Espresso.onView(ViewMatchers.withId(R.id.scheduleLabel))
            .perform(ViewActions.click())
}

//Created via recorder
fun setDataForSheduledMessage() {
    Espresso.onView(ViewMatchers.withClassName(Matchers.equalTo(DatePicker::class.java!!.getName())))
            .perform(PickerActions.setDate(2019, 10, 30))

}

//Created via recorder
fun clickOkButton() {
    val appCompatButton = Espresso.onView(

            Matchers.allOf(ViewMatchers.withId(android.R.id.button1), ViewMatchers.withText("OK"),
                    childAtPosition(
                            childAtPosition(
                                    ViewMatchers.withClassName(Matchers.`is`("android.widget.ScrollView")),
                                    0),
                            3)))
    appCompatButton.perform(ViewActions.scrollTo(), ViewActions.click())
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
