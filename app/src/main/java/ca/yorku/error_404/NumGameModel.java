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
    private static int difficulty = 0;
    private static int[] randNumList = {};
    private static int highScore = 0;
    private static int latestScore = 0;
    private static boolean isCorrect;
    private static String userGuess = "";
    private static int maxLength = 9;
    private static int textSize = 36;
    private static int[] textSizes = {maxLength, textSize};
    private static int count = 0;

    public static int[] generateRandomNumber(int difficulty) {
        Random rnd = new Random();
        for (int i = 0; i < difficulty; i++) {
            int randNum = rnd.nextInt(9) + 1;
            randNumList = Arrays.copyOf(randNumList, randNumList.length + 1);
            randNumList[randNumList.length - 1] = randNum;
        }
        return randNumList;
    }


    /**
     * Method to check for incorrect input and make latestScore equal
     * to zero if input is incorrect
     *
     * @return None
     */
    public static void incorrectInput() {
            isCorrect = false;
    }

    /**
     * Method to call updateLatestScore() and generateRandomNumber() udpate
     * latest score and redirect user to user_sequence_page.xml with a
     * new sequence to input
     * guess
     *
     * @return None
     */
    public static void correctInput() {
        isCorrect = true;
        generateRandomNumber(difficulty);
        updateLatestScore();
        updateHighScore();
    }

    /**
     * Convert number sequence and user input to string
     * Check for correct input and make isCorrect equal true
     * Method to call correctInput() and redirect
     * user to user_sequence_page.xml with a new sequence to input guess
     *
     * @return None
     */
    public static Boolean isEquals(String userInput) {
        String randNumStr = "";

        for (int i = 0; i < randNumList.length; i++) {
            randNumStr += randNumList[i];
        }

        if (randNumStr.equalsIgnoreCase(userInput)) {
            correctInput();
            return true;
        }
        else {
            incorrectInput();
            return false;
        }
    }

    /**
     * Method to choose a difficulty level where
     * easy (1) = 1 points each correct user guess
     * medium (2) = 2 points each correct user guess
     * hard (3) = 3 points each correct user guess
     *
     * @return int
     */
    public static int[] selectDifficulty(int userselection) {
        if (userselection == 1) {
            difficulty = 1;

        } else if (userselection == 2) {
            difficulty = 2;
        } else {
            difficulty = 3;
        }
        return generateRandomNumber(difficulty);
    }

    /**
     * Method to update user's high score if latestScore
     * is greater than previous high score
     *
     * @return None
     */
    public static void updateHighScore() {
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
    public static void updateLatestScore() {
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

    /**
     * Method to return user's latest score
     *
     * @return int
     */
    public static int getLatestScore() {
        return latestScore;
    }


    /**
     * Helper Method to return the random number sequence
     *
     * @return int[]
     */
    public static int[] getNumList() {
        return randNumList;
    }

    /**
     * Helper Method to return difficulty level
     *
     * @return int
     */
    public static int getDifficulty() {
        return difficulty;
    }

    /**
     * Helper Method to set userGuess
     *
     * @return int
     */
    public static void setUserGuess(String userGuessInput) {userGuess = userGuessInput;}

    /**
     * Helper Method to get userGuess
     *
     * @return int
     */
    public static String getUserGuess() {return userGuess.trim().replace(" ", "");}

    /**
     * Helper Method remove brackets, commas, and spaces
     * in array when converting it to string
     *
     * @return int
     */
    public static String formatArr(String arrayStr) {
        arrayStr = arrayStr.replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "")
                .trim();
        return arrayStr;
    }

    /**
     * Helper method to update generated sequence text size
     * when text goes off screen
     *
     * @return int[]
     */
    public static int[] updateSizes() {
        textSizes[0] += 1;
        if (count < 7) {
            textSizes[1] = (int)(textSizes[1] * 0.8);
        }
        else {
            textSizes[1] = (int)(textSizes[1] * 0.9);
        }
        count++;
        return textSizes;
    }

    /**
     * Helper method to know when to call updateSizes()
     *
     * @return int[]
     */
    public static int[] getTextSizes() {
        return textSizes;
    }

    /**
     * Helper method to reset score
     *
     * @return none
     */
    public static void resetGame() {
        int[] tempArr = {};
        randNumList = tempArr;
        latestScore = 0;
    }

}
