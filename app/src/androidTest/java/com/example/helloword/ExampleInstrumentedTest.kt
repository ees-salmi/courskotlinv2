package com.example.helloword

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
        @Test
        fun useAppContext() {
            // Context of the app under test.
            val appContext = InstrumentationRegistry.getInstrumentation().targetContext
            assertEquals("com.example.helloword", appContext.packageName)
        }
        @Test
        fun click_button_test() {
            onView(withId(R.id.edittexttest))
                .perform(typeText("Bonjour saad"))
            onView(withId(R.id.btntest))
                .perform(click())
            onView(withId(R.id.textviewtest))
                .check(matches(withText("Bonjour saad")))
        }
    // créer deux classes en dart vehicule et voiture qui hérite de vehicule
    // avec une méthode démarer() qui affiche que la voiture est démarré


}
class GestionStock {
    var quantite: Int = 50

    fun retirerArticles(nombre: Int): Int {
        if (nombre > quantite) {
            throw Exception("Stock insuffisant")
        }
        quantite -= nombre
        return quantite
    }
}

