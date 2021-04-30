package com.jesse.week_five_task

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test


class ValidatePhoneNumberTest {

    @Test
    fun `valid username,phoneNumber,email and gender returns true`() {
        val result = Validate.validateRegistrationInput(
            "Jesse",
            "07039826316",
            "jesseonoyeyan@gmail.com",
            "Male"
        )
        assertTrue(result)
    }
    @Test
    fun `empty username returns false`() {
        val result = Validate.validateRegistrationInput(
            "",
            "07039826316",
            "jesseonoyeyan@gmail.com",
            "Male"
        )
        assertFalse(result)
    }
    @Test
    fun `empty phoneNumber returns false`() {
        val result = Validate.validateRegistrationInput(
            "Jesse",
            "",
            "jesseonoyeyan@gmail.com",
            "Male"
        )
        assertFalse(result)
    }
    @Test
    fun `empty email returns false`() {
        val result = Validate.validateRegistrationInput(
            "Jesse",
            "07039826316",
            "",
            "Male"
        )
        assertFalse(result)
    }
    @Test
    fun `empty gender selection returns false`() {
        val result = Validate.validateRegistrationInput(
            "Jesse",
            "07039826316",
            "jesseonoyeyan@gmail.com",
            ""
        )
        assertFalse(result)
    }
    @Test
    fun `phone number not starting with 0 or 123 returns false`() {
        val result = Validate.validateRegistrationInput(
            "Jesse",
            "59015525620",
            "jesseonoyeyan@gmail.com",
            "Male"
        )
        assertFalse(result)
    }
}
