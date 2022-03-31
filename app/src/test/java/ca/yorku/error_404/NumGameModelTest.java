package ca.yorku.error_404;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class NumGameModelTest {

    /**
     * Test if NumGameModel.generateRandomNumber() generates the correct
     * number of random numbers to add to the sequence based on difficulty
     */
    @Test
    public void test_generateRandomNumber01() {
        Random rnd = new Random();
        int difficulty = rnd.nextInt(3) + 1;
        int[] randNumList = NumGameModel.generateRandomNumber(difficulty);
        int expectedArrLength = difficulty;

        org.junit.Assert.assertTrue("Incorrect generated number length", expectedArrLength == randNumList.length);
    }

    /**
     * Test if NumGameModel.generateRandomNumber() can add correctly
     * to an array sequence when called numerous times
     */
    @Test
    public void test_generateRandomNumber02() {
        Random rnd = new Random();
        int difficulty = rnd.nextInt(3) + 1;
        int[] randNumList = new int[0];
        int[] expectedNumList = new int[0];
        for (int i = 0; i < 2; i++) {
            randNumList = NumGameModel.generateRandomNumber(difficulty);
            expectedNumList = Arrays.copyOf(randNumList, expectedNumList.length + difficulty);
        }
        org.junit.Assert.assertArrayEquals(expectedNumList, randNumList);
    }

    /**
     * Test if userInput is incorrect by checking if isCorrect boolean
     * turns false and latestScore turns 0
     */
    @Test
    public void test_incorrectInput01() {
        int[] randNumList = {2, 3, 4, 9, 3};
        int userInput = 43563;
        NumGameModel.incorrectInput(userInput);

        org.junit.Assert.assertEquals(0, NumGameModel.getLatestScore());
        org.junit.Assert.assertEquals(false, NumGameModel.getIsCorrect());
    }

    /**
     * Test if userInput is correct by checking if isCorrect boolean
     * turns true and latestScore is not 0
     */
    @Test
    public void test_correctInput01() {
        int[] randNumList = {4, 9, 9, 5, 2};
        int userInput = 49952;
        NumGameModel.correctInput(userInput);

        org.junit.Assert.assertEquals(true, NumGameModel.getIsCorrect());
    }

    /**
     * Test if difficulty will match with userSelection
     */
    @Test
    public void test_selectDifficulty01() {
        //generate random num 1-3 as userSelection input and compare with difficulty
        Random rnd = new Random();
        int randDifficulty = rnd.nextInt(3) + 1;
        int difficulty = NumGameModel.selectDifficulty(randDifficulty);

        org.junit.Assert.assertEquals(randDifficulty, difficulty);
    }

    /**
     * Test if difficulty doesn't match with userSelection
     * then throw IllegalArgumentException
     */
    @Test
    public void test_selectDifficulty02() {
        //generate random num 1-3 as userSelection input and compare with difficulty
        Random rnd = new Random();
        int randDifficulty = rnd.nextInt(3) + 1;
        int difficulty = NumGameModel.selectDifficulty(randDifficulty);

        org.junit.Assert.assertEquals(randDifficulty, difficulty);
    }

    /**
     * Test if highScore is updated if highScore is less than latestScore
     */
    @Test
    public void test_updateHighScore01() {
        int highScore = 10;
        int latestScore = 11;
        NumGameModel.updateHighScore(latestScore);
        int result = NumGameModel.getHighScore();

        org.junit.Assert.assertEquals(11, result);
    }

    /**
     * Test if highScore does not update if highScore is more than latestScore
     */
    @Test
    public void test_updateHighScore02() {
        int highScore = 10;
        int latestScore = 3;
        NumGameModel.updateHighScore(latestScore);
        int result = NumGameModel.getHighScore();

        org.junit.Assert.assertEquals(10, result);
    }

    /**
     * Test if latestScore is added correctly when isCorrect is True
     * and based on difficulty selected
     */
    @Test
    public void test_updateLatestScore01() {
        throw new UnsupportedOperationException();
    }

    /**
     * Test if latestScore is not updated when isCorrect is False
     */
    @Test
    public void test_updateLatestScore02() {
        throw new UnsupportedOperationException();
    }

}
