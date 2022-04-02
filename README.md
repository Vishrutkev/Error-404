# Number Memorization Game
A Java based Android Studio app project on a number memorization game.

## Project Information

This is a java based application created in Android Studio. 

The app uses multiple classes for each page and a NumGameModel.java that contains
all the methods used to perform the functions needed for the app.

Junit test cases are used to test the methods used in NumGameModel.java

Espresso test cases are used to test the app interface.

## How to Run Project

Clone the project into Android Studio and running the app will run the random number memorization game.

## Game Rules

User can choose three difficulty levels: easy, medium and hard.
Easy will add 1 single new digit each round, medium will add 2 new digits each round and hard will add 3 new digits each round.

A generated number sequence will be displayed to the user based on the difficulty level selected.

Correct input will increment the user's score by the difficulty level (i.e. medium level will add 2 points to the score each correct input).

The user's high score will be kept so when the user's latest score becomes greater than the high score, it will update the high score.
