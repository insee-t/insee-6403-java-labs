/**
 * GuessGame.java
 * This class represents a basic number guessing game.
 * It includes methods for configuring the game, generating a random answer, and handling user input.
 * @author Insee Thaopech
 * @version 1.0
 */

package thaopech.insee.lab6;

import java.util.*;

public class GuessGame {

    // Static Scanner instance for user input
    public static final Scanner input = new Scanner(System.in);

    // Game properties
    private int min;
    private int max;
    private int maxTries;
    private int answer;
    private int attempts;

    // Constructors

    // Default constructor initializing default game parameters
    public GuessGame() {
        min = 1;
        max = 100;
        maxTries = 10;
        answer  = 0;
        attempts = 0;
    }

    // Parameterized constructor for custom game configuration
    public GuessGame(int min, int max, int maxTries) {
        this.min = min;
        this.max = max;
        this.maxTries = maxTries;
        answer  = 0;
        attempts = 0;
    }

    // Getters and Setters

    public int getMin() {
        return this.min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMaxTries() {
        return this.maxTries;
    }

    public void setMaxTries(int maxTries) {
        this.maxTries = maxTries;
    }

    public void configureGame(int min, int max, int maxTries) {
        setMin(min);
        setMax(max);
        setMaxTries(maxTries);
    }

    public int getAttempts() {
        return this.attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getAnswer() {
        return this.answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    // Generates a random answer within the specified range
    public void generateAnswer() {
        int min = getMin();
        int max = getMax();
        this.answer = min + (int) (Math.random() * ((max - min) + 1));
    }

    // Prompts the user to input a guess and returns it
    public int getUserGuess() {
        System.out.print(String.format("Enter an integer between %d and %d: ", min, max));
        return input.nextInt();
    }

    // Provides feedback on the user's guess
    public int numberGuessingResponse(int userGuess, int index) {

        int answer = getAnswer();
        if (userGuess == answer) {
            System.out.println("Congratulations! You've guessed the number in " + index + (index == 1 ? " attempt." : " attempts."));
            return 0;
        }
        if (userGuess > answer) {
            System.out.println("Try a lower number!");
            return 1;
        }
        System.out.println("Try a higher number!");
        return 1;
    }

    // Plays a single game instance
    public boolean playSingleGame() {

        System.out.println("Welcome to a number guessing game!");
        generateAnswer();

        for (int guessIndex = 1; guessIndex <= maxTries; guessIndex++) {
            int userGuess = getUserGuess();

            if (numberGuessingResponse(userGuess, guessIndex) == 0) {
                return true;
            }
        }

        System.out.println("Sorry, you've used all your attempts. The correct answer was: " + this.answer);
        return false;
    }
}
