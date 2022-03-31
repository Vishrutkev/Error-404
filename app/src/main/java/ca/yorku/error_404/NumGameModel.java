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

    public static int[] generateRandomNumber(int difficulty) {
        Random rnd = new Random();
        for (int i = 0; i < difficulty; i++) {
            int randNum = rnd.nextInt(9) + 1;
            randNumList = Arrays.copyOf(randNumList, randNumList.length + 1);
            randNumList[randNumList.length - 1] = randNum;
        }
        return randNumList;
    }

    /** Convert int to int[]
     *
     */

    public static int[] Int_to_array(int n)
    {
        int j = 0;
        int len = Integer.toString(n).length();
        int[] arr = new int[len];
        while(n!=0)
        {
            arr[len-j-1] = n%10;
            n=n/10;
            j++;
        }
        return arr;
    }

    /**  Check if the Arrays are equal or not?
     *
     */

    public static boolean trueorFalse(int[] genNum, int[] num1){
        return Arrays.equals(num1, genNum);

    }



    /**
     * Method to check for incorrect input and make latestScore equal
     * to zero if input is incorrect
     *
     * @return None
     */
    public static void incorrectInput() {
            isCorrect = false;
            latestScore = 0;
    }

    /**
     * Method to call updateLatestScore() and generateRandomNumber() and
     * redirect user to user_sequence_page.xml with a new sequence to input
     * guess
     *
     * @return None
     */
    public static void correctInput() {
        isCorrect = true;
        generateRandomNumber(difficulty);
        updateLatestScore();
    }

    /**
     * Convert number sequence and user input to string
     * Check for correct input and make isCorrect equal true
     * Method to call updateLatestScore() and addToSequence() and redirect
     * user to user_sequence_page.xml with a new sequence to input guess
     *
     * @return None
     */
    public static Boolean isEquals(String userInput) {
        String randNumStr = "";

        for (int i = 0; i < randNumList.length; i++) {
            randNumStr += randNumList[i];
        }
        System.out.println("RandomNum: " + randNumStr);
        System.out.println("userInput: " + userInput);
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

}
