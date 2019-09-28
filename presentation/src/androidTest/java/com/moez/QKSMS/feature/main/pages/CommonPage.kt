package com.moez.QKSMS.feature.main.pages

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import com.moez.QKSMS.R

fun openBurgerMenu() {
    Espresso.onView(ViewMatchers.withContentDescription("Open navigation drawer"))
            .perform(ViewActions.click())
}

fun openArchivedTab() {
    Espresso.onView(ViewMatchers.withId(R.id.archived))
            .perform(ViewActions.click())
}

fun longClickOnConversation() {
    Espresso.onView(ViewMatchers.withId(R.id.title))
            .perform(ViewActions.longClick())
}

fun openInboxTab() {
    Espresso.onView(ViewMatchers.withId(R.id.inbox))
            .perform(ViewActions.click())
}

fun openScheduledTab() {
    Espresso.onView(ViewMatchers.withId(R.id.scheduled))
            .perform(ViewActions.click())
}
