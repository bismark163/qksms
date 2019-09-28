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
package com.moez.QKSMS.feature.main.tests

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.moez.QKSMS.R
import com.moez.QKSMS.feature.main.MainActivity
import com.moez.QKSMS.feature.main.pages.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)

    val TEST_TEXT: String = "Prose pozvonit chem u kogo-to zanimat"
    val SEARCH_NUMBER: String = "8-800-555-35-35"



    @Test
    fun sendConversationToArchiveAndDelete() {
        clickOnCreateNewConversationButton()
        enterTextInSearchField(R.id.chips, SEARCH_NUMBER)
        clickOnFirstItemInContactList()

        enterTextInMessageField(TEST_TEXT)
        clickOnSendButton()
        closeConversation()

        archiveConversationBySwipe()
        checkThatToastAppears()
        openBurgerMenu()
        openArchivedTab()
        checkThatConversationInArchive(SEARCH_NUMBER)

        longClickOnConversation()
        clickOnDeleteConversation()
        deleteConversation()
        checkThatConversationDeleted(SEARCH_NUMBER)
    }

    @Test
    fun takeConversationFromArchive() {
        clickOnCreateNewConversationButton()
        enterTextInSearchField(R.id.chips, SEARCH_NUMBER)
        clickOnFirstItemInContactList()

        enterTextInMessageField(TEST_TEXT)
        clickOnSendButton()
        closeConversation()

        archiveConversationBySwipe()
        checkThatToastAppears()
        openBurgerMenu()
        openArchivedTab()

        longClickOnConversation()
        unarchiveConversation()
        openBurgerMenu()
        openInboxTab()
        checkThatConversationAppears(SEARCH_NUMBER)

        longClickOnConversation()
        clickOnDeleteConversation()
        deleteConversation()
        checkThatConversationDeleted(SEARCH_NUMBER)
    }

    @Test
    fun createAndDeleteConversation() {
        clickOnCreateNewConversationButton()
        enterTextInSearchField(R.id.chips, SEARCH_NUMBER)
        clickOnFirstItemInContactList()

        enterTextInMessageField(TEST_TEXT)
        clickOnSendButton()
        checkThatMessageSent(TEST_TEXT)
        closeConversation()

        longClickOnConversation()
        clickOnDeleteConversation()
        deleteConversation()
        checkThatConversationDeleted(SEARCH_NUMBER)
    }


    @Test
    fun sendScheduledMessageAndDelete() {
        clickOnCreateNewConversationButton()
        enterTextInSearchField(R.id.chips, SEARCH_NUMBER)
        clickOnFirstItemInContactList()

        enterTextInMessageField(TEST_TEXT)
        openMenu()
        clickOnSchedule()
        setDataForSheduledMessage()
        clickOkButton()
        clickOkButton()
        clickOnSendButton()
        closeConversation()

        openBurgerMenu()
        openScheduledTab()
        checkThatMessageIsScheduled(SEARCH_NUMBER)
        longClickOnScheduledMessage()
        deleteScheduledMessage()
        checkThatScheduledMessageDeleted(SEARCH_NUMBER)

    }


}


