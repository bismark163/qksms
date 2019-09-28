package com.moez.QKSMS.feature.main.pages

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.moez.QKSMS.R


fun checkThatConversationInArchive(conversationName: String) {
    Espresso.onView(ViewMatchers.withText(conversationName))
            .check(ViewAssertions.matches(ViewMatchers.withText(conversationName)))
}


fun unarchiveConversation() {
    Espresso.onView(ViewMatchers.withId(R.id.unarchive))
            .perform(ViewActions.click())
}

fun longClickOnScheduledMessage() {
    Espresso.onView(ViewMatchers.withId(R.id.recipients))
            .perform(ViewActions.longClick())
}



