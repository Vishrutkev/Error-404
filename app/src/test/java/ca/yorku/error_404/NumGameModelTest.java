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

        org.junit.Assert.assertTrue("Incorrect generated number length" , expectedArrLength == randNumList.length);
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
            expectedNumList = Arrays.copyOf(randNumList, expectedNumList.length + 1);
        }

        org.junit.Assert.assertArrayEquals(expectedNumList, randNumList);
    }

    /**
     * Test if userInput is incorrect by checking if isCorrect boolean
     * turns false and latestScore turns 0
     */
    @Test
    public void test_incorrectInput01() {
        throw new UnsupportedOperationException();
    }

    /**
     * Test if userInput is correct by checking if isCorrect boolean
     * turns true and latestScore is not 0
     */
    @Test
    public void test_correctInput01() {
        throw new UnsupportedOperationException();
    }

    /**
     * Test if difficulty will match with userSelection
     */
    @Test
    public void test_selectDifficulty01() {
        //generate random num 1-3 as userSelection input and compare with difficulty
        throw new UnsupportedOperationException();
    }

    /**
     * Test if difficulty doesn't match with userSelection
     * then throw IllegalArgumentException
     */
    @Test
    public void test_selectDifficulty02() {
        //generate random num 1-3 as userSelection input and compare with difficulty
        throw new UnsupportedOperationException();
    }

    /**
     * Test if highScore is updated if highScore is less than latestScore
     */
    @Test
    public void test_updateHighScore01() {
        throw new UnsupportedOperationException();
    }

    /**
     * Test if highScore does not update if highScore is more than latestScore
     */
    @Test
    public void test_updateHighScore02() {
        throw new UnsupportedOperationException();
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
