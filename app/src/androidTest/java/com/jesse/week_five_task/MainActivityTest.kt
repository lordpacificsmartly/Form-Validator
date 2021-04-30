package com.jesse.week_five_task


import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.CoreMatchers.anything
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



//UI test for the main activity
//This test checks for the visibility of the views present in the registration page

//@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

//    companion object{​
        private var name : String = "Lordpacific"
        private var phoneNumber : String = "07039826316"
        private var email : String = "jesseonoyeyan@gmail.com"
        private var gender : String = "Male"
//    }​

    @get: Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)


    //Test for visibility of main activity
    @Test
    fun test_isActivityInView(){
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }

      //Test for visibility of images
    @Test
      fun test_visibility_of_images(){
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        onView(withId(R.id.imageView1)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
    }

    //Test for visibility of title
    @Test
    fun text_isTitleTextDisplayed(){
        onView(withId(R.id.tvRegister)).check(matches(withText(R.string.registration_form)))
    }

    @Test
    fun is_userName_editTextInput_visible(){
        onView(withId(R.id.tvRegisterName)).check(matches(isDisplayed()))
    }


    @Test
    fun is_userPhone_editTextInput_visible(){
        onView(withId(R.id.tvRegisterPhone)).check(matches(isDisplayed()))
    }

    @Test
    fun is_userEmail_editTextInput_visible(){
        onView(withId(R.id.tvRegisterEmail)).check(matches(isDisplayed()))
    }


    @Test
    fun is_userGender_AutoCompleteInput_visible(){
        onView(withId(R.id.autoComplete)).check(matches(isDisplayed()))
    }

    @Test
    fun is_register_button_visible(){
        onView(withId(R.id.button)).check(matches(isDisplayed()))
        onView(withId(R.id.tvRegisterName)).perform(typeText(name))
        onView(withId(R.id.tvRegisterPhone)).perform(typeText(phoneNumber))
        onView(withId(R.id.tvRegisterEmail)).perform(typeText(email), closeSoftKeyboard())
//        onView(withId(R.id.autoComplete)).perform(click())
//        onView(withText("Male")).check(matches(isDisplayed()))
        onView(withHint("Sex")).check(matches(isDisplayed()))
                .perform(click())
    }

}





