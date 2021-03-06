package com.ardhacodes.subs1_jetpack.ui.main

import androidx.core.content.MimeTypeFilter.matches
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.ardhacodes.subs1_jetpack.R
import com.ardhacodes.subs1_jetpack.utils.MoviesTvDataDummy
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import java.util.concurrent.CompletableFuture.allOf
import java.util.regex.Pattern.matches

class MainActivityInsTest
{
    private val mov = MoviesTvDataDummy.DataMovies()
    private val tv = MoviesTvDataDummy.DataTvShow()

    @get:Rule
    var activityrule = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun loadMovie(){
//        onView(withText("Movie")).perform(click())
        onView(withId(R.id.rv_movie)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(mov.size))
    }

    @Test
    fun loadTvShow(){
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tv.size))
    }


    @Test
    fun detailMovie() {
        onView(withId(R.id.rv_movie)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(mov.size))

        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.cardView2)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(ViewAssertions.matches(withText(mov[0].title)))

        onView(withId(R.id.tv_genre)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(ViewAssertions.matches(withText(mov[0].genre)))

        onView(withId(R.id.tv_duration)).check(ViewAssertions.matches(isDisplayed()))
//        onView(withId(R.id.tv_duration)).check(ViewAssertions.matches(withText(mov[0].duration)))
        onView(withId(R.id.tv_duration)).check(ViewAssertions.matches(withText("Duration : ${mov[0].duration}")))

        onView(withId(R.id.tv_year)).check(ViewAssertions.matches(isDisplayed()))
//        onView(withId(R.id.tv_year)).check(ViewAssertions.matches(withText(mov[0].yearrelease)))
        onView(withId(R.id.tv_year)).check(ViewAssertions.matches(withText("Release : ${mov[0].yearrelease}")))

        onView(withId(R.id.tv_score)).check(ViewAssertions.matches(isDisplayed()))
//        onView(withId(R.id.tv_score)).check(ViewAssertions.matches(withText(mov[0].score)))
        onView(withId(R.id.tv_score)).check(ViewAssertions.matches(withText("Score : ${mov[0].score}")))

        onView(withId(R.id.tv_overview)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(ViewAssertions.matches(withText(mov[0].overview)))

        Espresso.pressBack()
    }

    @Test
    fun detailTv() {
        //Load Tv Show
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(tv.size))

        //Displaying
        onView(withId(R.id.rv_tv)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(0))
        onView(withId(R.id.rv_tv)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))

        onView(withId(R.id.cardView2)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.tv_title)).check(ViewAssertions.matches(withText(tv[0].title)))

        onView(withId(R.id.tv_genre)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.tv_genre)).check(ViewAssertions.matches(withText(tv[0].genre)))

        onView(withId(R.id.tv_duration)).check(ViewAssertions.matches(isDisplayed()))
//        onView(withId(R.id.tv_duration)).check(ViewAssertions.matches(withText(tv[0].duration)))
        onView(withId(R.id.tv_duration)).check(ViewAssertions.matches(withText("Duration : ${tv[0].duration}")))

        onView(withId(R.id.tv_year)).check(ViewAssertions.matches(isDisplayed()))
//        onView(withId(R.id.tv_year)).check(ViewAssertions.matches(withText(tv[0].yearrelease)))
        onView(withId(R.id.tv_year)).check(ViewAssertions.matches(withText("Release : ${tv[0].yearrelease}")))

        onView(withId(R.id.tv_score)).check(ViewAssertions.matches(isDisplayed()))
//        onView(withId(R.id.tv_score)).check(ViewAssertions.matches(withText(tv[0].score)))
        onView(withId(R.id.tv_score)).check(ViewAssertions.matches(withText("Score : ${tv[0].score}")))

        onView(withId(R.id.tv_overview)).check(ViewAssertions.matches(isDisplayed()))
        onView(withId(R.id.tv_overview)).check(ViewAssertions.matches(withText(tv[0].overview)))

        Espresso.pressBack()
    }
}

