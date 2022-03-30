package ca.yorku.error_404;

import android.text.style.EasyEditSpan;
import android.util.DisplayMetrics;
import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class AppUserInterfaceTest {

    /**
     *Tests if playButton correctly redirects to Difficulty Selection Page
     *
     * @throws InterruptedException
     */
    @Test
    public void test_playButton() throws InterruptedException {
        ActivityScenario.launch(MainActivity.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.playButton1)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("EASY")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     *Tests if easyButton correctly redirects to Number Sequence Page
     *
     * @throws InterruptedException
     */
    @Test
    public void test_difficultyButton01() throws InterruptedException {
        ActivityScenario.launch(DifficultySelectionPage.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.easyButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("READY")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     *Tests if mediumButton correctly redirects to Number Sequence Page
     *
     * @throws InterruptedException
     */
    @Test
    public void test_difficultyButton02() throws InterruptedException {
        ActivityScenario.launch(DifficultySelectionPage.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.mediumButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("READY")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     *Tests if hardButton correctly redirects to Number Sequence Page
     *
     * @throws InterruptedException
     */
    @Test
    public void test_difficultyButton03() throws InterruptedException {
        ActivityScenario.launch(DifficultySelectionPage.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.hardButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("READY")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     * Tests if readButton correctly redirects to user input page
     *
     * @throws InterruptedException
     */
    @Test
    public void test_readyButton() throws InterruptedException {
        ActivityScenario.launch(Number_Sequence_Page.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.readyButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("CHECK")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     * Tests if checkButton with correct input redirects to correct input page
     *
     * @throws InterruptedException
     */
    @Test
    public void test_checkButtonCorrectInput() throws InterruptedException {
        ActivityScenario.launch(DifficultySelectionPage.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.easyButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.readyButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.editTextNumber)).perform(ViewActions.typeText(Integer.toString(NumGameModel.getNumList()[0])));
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.checkButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("NEXT ROUND")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     * Tests if checkButton with incorrect input redirects to incorrect input page
     *
     * @throws InterruptedException
     */
    @Test
    public void test_checkButtonIncorrectInput() throws InterruptedException {
        ActivityScenario.launch(DifficultySelectionPage.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.easyButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.readyButton)).perform(ViewActions.click());
        Thread.sleep(2000);

        int num = NumGameModel.getNumList()[0];
        num = num + 11;
        String incorrectNum = Integer.toString(num).substring(1);

        Espresso.onView(ViewMatchers.withId(R.id.editTextNumber)).perform(ViewActions.typeText(incorrectNum));
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.checkButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("Return To\nMain Page")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     * Tests if helpIcon on Difficulty selection page opens help icon popup
     *
     * @throws InterruptedException
     */
    @Test
    public void test_helpIcon01() throws InterruptedException {
        ActivityScenario.launch(DifficultySelectionPage.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.helpIconButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.pressBackUnconditionally();
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("EASY")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     * Tests if helpIcon on Number sequence page opens help icon popup
     *
     * @throws InterruptedException
     */
    @Test
    public void test_helpIcon02() throws InterruptedException {
        ActivityScenario.launch(Number_Sequence_Page.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.helpIconButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.pressBackUnconditionally();
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("READY")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     * Tests if helpIcon on correct input page opens help icon popup
     *
     * @throws InterruptedException
     */
    @Test
    public void test_helpIcon03() throws InterruptedException {
        ActivityScenario.launch(Correct_input_Score_Page.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.helpIconButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.pressBackUnconditionally();
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("NEXT ROUND")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     * Tests if helpIcon on incorrect input page opens help icon popup
     *
     * @throws InterruptedException
     */
    @Test
    public void test_helpIcon04() throws InterruptedException {
        ActivityScenario.launch(Incorrect_input_Score_Page.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.helpIconButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.pressBackUnconditionally();
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("Return To\nMain Page")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     * Tests if exitIcon on difficulty selection page opens exit icon popup and clicks yes
     *
     * @throws InterruptedException
     */
    @Test
    public void test_exitIcon01a() throws InterruptedException {
        ActivityScenario.launch(DifficultySelectionPage.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.exitIconButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.yesButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("PLAY")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     * Tests if exitIcon on difficulty selection page opens exit icon popup and clicks no
     *
     * @throws InterruptedException
     */
    @Test
    public void test_exitIcon01b() throws InterruptedException {
        ActivityScenario.launch(DifficultySelectionPage.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.exitIconButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.noButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("EASY")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     * Tests if exitIcon on number selection page opens exit icon popup and clicks yes
     *
     * @throws InterruptedException
     */
    @Test
    public void test_exitIcon02a() throws InterruptedException {
        ActivityScenario.launch(Number_Sequence_Page.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.exitIconButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.yesButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("PLAY")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     * Tests if exitIcon on number selection page opens exit icon popup and clicks no
     *
     * @throws InterruptedException
     */
    @Test
    public void test_exitIcon02b() throws InterruptedException {
        ActivityScenario.launch(Number_Sequence_Page.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.exitIconButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.noButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("READY")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     * Tests if exitIcon on correct input page opens exit icon popup and clicks yes
     *
     * @throws InterruptedException
     */
    @Test
    public void test_exitIcon03a() throws InterruptedException {
        ActivityScenario.launch(Correct_input_Score_Page.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.exitIconButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.yesButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("PLAY")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     * Tests if exitIcon on correct input page opens exit icon popup and clicks no
     *
     * @throws InterruptedException
     */
    @Test
    public void test_exitIcon03b() throws InterruptedException {
        ActivityScenario.launch(Correct_input_Score_Page.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.exitIconButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.noButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("NEXT ROUND")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     * Tests if exitIcon on incorrect input page opens exit icon popup and clicks yes
     *
     * @throws InterruptedException
     */
    @Test
    public void test_exitIcon04a() throws InterruptedException {
        ActivityScenario.launch(Incorrect_input_Score_Page.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.exitIconButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.yesButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("PLAY")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

    /**
     * Tests if exitIcon on incorrect input page opens exit icon popup and clicks no
     *
     * @throws InterruptedException
     */
    @Test
    public void test_exitIcon04b() throws InterruptedException {
        ActivityScenario.launch(Incorrect_input_Score_Page.class);
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.exitIconButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withId(R.id.noButton)).perform(ViewActions.click());
        Thread.sleep(2000);
        Espresso.onView(ViewMatchers.withText("Return To\nMain Page")).check(ViewAssertions.matches(ViewMatchers.isDisplayed()));
    }

}
