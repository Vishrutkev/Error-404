package ca.yorku.error_404;

import java.util.Arrays;
import java.util.Random;

public class NumGameModel {

    /**
     * Method to to generate a random double value
     *
     * @param difficulty int type for difficulty level user selected
     * @return int from 1-9
     */
    private int difficulty = 0;

    public static int[] generateRandomNumber(int difficulty) {
        int randNumList[] = {};
        Random rnd = new Random();
        for (int i = 0; i < difficulty; i++) {
            int randNum = rnd.nextInt(9) + 1;
            randNumList = Arrays.copyOf(randNumList, randNumList.length + 1);
            randNumList[randNumList.length - 1] = randNum;
        }
        return randNumList;
    }

    /**
     * Method to redirect user to user_sequence_input_page.xml
     *
     * @return None
     */
    public void readyButton() {
        throw new UnsupportedOperationException();
    }

    /**
     * Method to display help icon page popup and call
     * helpPopupExit() when clicked on exit icon
     *
     * @return None
     */
    public void helpButton() {
        throw new UnsupportedOperationException();
    }

    /**
     * Method to exit help icon page popup and return
     * to current page user is on
     *
     * @return None
     */
    public void helpPopupExit() {
        throw new UnsupportedOperationException();
    }

    /**
     * Method to display correct number sequence and incorrect sequence
     * user inputted and call updateHighScore() and updateLatestScore()
     *
     * @return None
     */
    public void incorrectInput() {
        throw new UnsupportedOperationException();
    }

    /**
     * Method to call updateLatestScore() and addToSequence() and redirect
     * user to user_sequence_page.xml with a new sequence to input guess
     *
     * @return None
     */
    public void correctInput() {
        throw new UnsupportedOperationException();
    }

    /**
     * Method to display return to main page popup
     *
     * @return None
     */
    public void homeButton() {
        throw new UnsupportedOperationException();
    }

    /**
     * Method to exit main page popup and display yes
     * button to call homePopupYes() and exit, and no
     * button to call homePopupNo() and close popup
     *
     * @return None
     */
    public void homePopup() {
        throw new UnsupportedOperationException();
    }

    /**
     * Method to exit current page and return to
     * main_page1 if high score equals 0, otherwise
     * return to main_page2
     *
     * @return None
     */
    public void homePopupYes() {
        throw new UnsupportedOperationException();
    }

    /**
     * Method to close return to main page popup
     *
     * @return None
     */
    public void homePopupNo() {
        throw new UnsupportedOperationException();
    }

    /**
     * Method to choose a difficulty level where
     * easy (1) = 1 points each correct user guess
     * medium (2) = 2 points each correct user guess
     * hard (3) = 3 points each correct user guess
     *
     * @return int
     */
    public int selectDifficulty(int userselection) {
        if (userselection == 1) {
            difficulty = 1;
        } else if (userselection == 2) {
            difficulty = 2;
        } else {
            difficulty = 3;
        }
        return difficulty;
    }

    /**
     * Method to call generateRandomNumber() and add
     * a new number to the sequence needed to memorize
     *
     * @return None
     */
    public void addToSequence() {
        throw new UnsupportedOperationException();
    }

    /**
     * Method to update user's high score if latestScore
     * is greater than previous high score
     *
     * @return None
     */
    public void updateHighScore() {
        throw new UnsupportedOperationException();
    }

    /**
     * Method to update user's latest score whenever user
     * corrects the sequence correctly
     *
     * @return None
     */
    public void updateLatestScore() {
        throw new UnsupportedOperationException();
    }

    /**
     * Method to check if user's input matches the sequence needed
     * to be memorized and call correctInput() if correct input
     * and call incorrectInput() if incorrect input
     *
     * @return None
     */
    public void checkInput() {
        throw new UnsupportedOperationException();
    }


}
