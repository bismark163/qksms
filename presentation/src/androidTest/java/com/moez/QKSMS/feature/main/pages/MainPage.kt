package com.moez.QKSMS.feature.main.pages

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.moez.QKSMS.R


fun clickOnCreateNewConversationButton() {
    Espresso.onView(ViewMatchers.withId(R.id.compose))
            .perform(ViewActions.click())
}

fun enterTextInSearchField(elementId: Int, searchText: String) {
    Espresso.onView(ViewMatchers.withId(elementId))
            .perform(RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.typeText(searchText)))
}

fun clickOnFirstItemInContactList() {
    Espresso.onView(ViewMatchers.withId(R.id.contacts))
            .perform(RecyclerViewActions
                    .actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
}

fun archiveConversationBySwipe() {
    Espresso.onView(ViewMatchers.withId(R.id.title))
            .perform(ViewActions.swipeLeft())
}

fun checkThatToastAppears() {
    Espresso.onView(ViewMatchers.withText("Archived conversation"))
            .check(ViewAssertions.matches(ViewMatchers
                    .withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)))
}

fun clickOnDeleteConversation() {
    Espresso.onView(ViewMatchers.withId(R.id.delete))
            .perform(ViewActions.click())
}

fun deleteConversation() {
    Espresso.onView(ViewMatchers.withId(android.R.id.button1))
            .perform(ViewActions.click())
}

fun checkThatConversationDeleted(conversationName: String) {
    Espresso.onView(ViewMatchers.withText(conversationName))
            .check(doesNotExist())
}

fun checkThatConversationAppears(conversationName: String) {
    Espresso.onView(ViewMatchers.withText(conversationName))
            .check(ViewAssertions.matches(ViewMatchers.withText(conversationName)))
}


