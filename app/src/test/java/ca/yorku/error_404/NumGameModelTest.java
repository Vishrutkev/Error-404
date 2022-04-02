package ca.yorku.error_404;

import org.junit.Test;

import java.awt.font.NumericShaper;
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
        NumGameModel.resetGame();
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
        NumGameModel.resetGame();
    }

    /**
     * Test if userInput is incorrect by checking if isCorrect boolean
     * turns false
     */
    @Test
    public void test_incorrectInput01() {
        int[] randNumList = {2, 3, 4, 9, 3};
        String userInput = "43563";

        org.junit.Assert.assertEquals(false, NumGameModel.isEquals(userInput));
        NumGameModel.resetGame();
    }

    /**
     * Test if userInput is correct by checking if isCorrect boolean
     * turns true
     */
    @Test
    public void test_correctInput01() {
        NumGameModel.setRandNumList(new int[]{4, 9, 9, 5, 2});
        String userInput = "49952";

        org.junit.Assert.assertEquals(true, NumGameModel.isEquals(userInput));
        NumGameModel.resetGame();
    }

    /**
     * Test if difficulty will match with userSelection
     */
    @Test
    public void test_selectDifficulty01() {
        //generate random num 1-3 as userSelection input and compare with difficulty
        org.junit.Assert.assertEquals(1, NumGameModel.selectDifficulty(1).length);
        NumGameModel.resetGame();
    }

    /**
     * Test if difficulty will match with userSelection
     *
     */
    @Test
    public void test_selectDifficulty02() {
        //generate random num 1-3 as userSelection input and compare with difficulty

        org.junit.Assert.assertEquals(2, NumGameModel.selectDifficulty(2).length);
        NumGameModel.resetGame();
    }

    /**
     * Test if highScore is updated if highScore is less than latestScore
     */
    @Test
    public void test_updateHighScore01() {
        NumGameModel.setHighScore(10);
        NumGameModel.setLatestScore(11);
        NumGameModel.updateHighScore();
        int result = NumGameModel.getHighScore();

        org.junit.Assert.assertEquals(11, result);
        NumGameModel.resetGame();
    }

    /**
     * Test if highScore does not update if highScore is more than latestScore
     */
    @Test
    public void test_updateHighScore02() {
        NumGameModel.setHighScore(10);
        NumGameModel.setLatestScore(3);
        NumGameModel.updateHighScore();
        int result = NumGameModel.getHighScore();

        org.junit.Assert.assertEquals(10, result);
        NumGameModel.resetGame();
    }

    /**
     * Test if latestScore is added correctly when isCorrect is True
     * and based on difficulty selected
     */
    @Test
    public void test_updateLatestScore01() {
        NumGameModel.setIsCorrect(true);
        NumGameModel.setDifficulty(3);
        NumGameModel.setLatestScore(0);
        NumGameModel.updateLatestScore();
        int result = NumGameModel.getLatestScore();

        org.junit.Assert.assertEquals(3, result);
        NumGameModel.resetGame();
    }

    /**
     * Test if latestScore is not updated when isCorrect is False
     */
    @Test
    public void test_updateLatestScore02() {
        NumGameModel.setIsCorrect(false);
        NumGameModel.setDifficulty(3);
        NumGameModel.setLatestScore(10);
        NumGameModel.updateLatestScore();
        int result = NumGameModel.getLatestScore();

        org.junit.Assert.assertEquals(10, result);
        NumGameModel.resetGame();
    }

}

