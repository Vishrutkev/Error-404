package ca.yorku.error_404;

import java.util.Arrays;
import java.util.Random;

public class NumGameModel {

    /**
     * Method to to generate a random double value
     * For loop to generate 1,2 or 3 random numbers depending on the users difficulty selection
     * Adds generated random nunmber to the end of the memorization sequence
     *
     * @param difficulty int type for difficulty level user selected
     * @return int from 1-9
     */
    private int difficulty = 0;
    private int[] randNumList = {};
    private static int highScore = 0;
    private int latestScore = 0;
    private boolean isCorrect;

    public int[] generateRandomNumber(int difficulty) {
        Random rnd = new Random();
        for (int i = 0; i < difficulty; i++) {
            int randNum = rnd.nextInt(9) + 1;
            randNumList = Arrays.copyOf(randNumList, randNumList.length + 1);
            randNumList[randNumList.length - 1] = randNum;
        }
        return randNumList;
    }

    public void PlayButton() {
        throw new UnsupportedOperationException();
    }

    /**
     * Method to redirect user to user_sequence_inputt_page.xml
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
     * Convert number sequence and user input to string
     * Check for incorrect input and make latestScore equal to zero if input is incorrect
     *
     * @return None
     */
    public void incorrectInput(int userInput) {
        String randNumStr = "";
        String userInputStr = "";

        for (int i = 0; i < randNumList.length; i++) {
            randNumStr += randNumList[i];
        }
        userInputStr = String.valueOf(userInput);
        if (!randNumStr.equalsIgnoreCase(userInputStr)) {
            //displayText
            isCorrect = false;
            latestScore = 0;
        }
    }

    /**
     * Method to display correct number sequence and incorrect sequence
     *
     * @return None
     */
    public void displayCorrectIncorrectSequence() {
        throw new UnsupportedOperationException();
    }


    /**
     * Convert number sequence and user input to string
     * Check for correct input and make isCorrect equal true
     * Method to call updateLatestScore() and addToSequence() and redirect
     * user to user_sequence_page.xml with a new sequence to input guess
     *
     * @return None
     */
    public void correctInput(int userInput) {
        String randNumStr = "";
        String userInputStr = "";

        for (int i = 0; i < randNumList.length; i++) {
            randNumStr += randNumList[i];
        }
        userInputStr = String.valueOf(userInput);
        if (randNumStr.equalsIgnoreCase(userInputStr)) {
            isCorrect = true;
            generateRandomNumber(difficulty);
            updateLatestScore();
        }
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
     * Method to update user's high score if latestScore
     * is greater than previous high score
     *
     * @return None
     */
    public void updateHighScore(int latestScore) {
        if (highScore < latestScore) {
            highScore = latestScore;
        }
    }

    /**
     * Method to update user's latest score whenever user
     * enters the sequence correctly
     *
     * @return None
     */
    public void updateLatestScore() {
        if (isCorrect && difficulty == 1) {
            latestScore += 1;
        } else if (isCorrect && difficulty == 2) {
            latestScore += 2;
        } else if (isCorrect && difficulty == 3) {
            latestScore += 3;
        }
    }

    /**
     * Method to return user's high score
     *
     * @return int
     */
    public static int getHighScore() {
        return highScore;
    }


}
