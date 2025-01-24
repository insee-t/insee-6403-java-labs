// GuessGameV3.java
// This class extends GuessGameV2 and adds additional features such as game logging and record keeping.
// It includes methods for configuring the game, playing a single game, and managing game records.
// The class makes use of getters and setters for better encapsulation.
/**
 * @author Insee Thaopech
 * @version 1.0
 */
package thaopech.insee.lab6;

import java.util.*;

public class GuessGameV3 extends GuessGameV2 {

    // Maximum number of games that can be recorded
    private static final int MAX_GAMES = 100;

    // Array to store game records
    private static GuessGameV3[] gameRecords = new GuessGameV3[MAX_GAMES];

    // Stores guesses made during the game
    private int[] guesses;

    // Count of guesses made
    private int guessCount;

    // Indicates if the player has won the game
    private boolean win;

    // Summary of attempts made during the game
    private String attemptsSummary;

    // Index to track the number of recorded games
    private static int recordIndex = 0;

    // Default constructor
    public GuessGameV3() {
        super();
        this.guessCount = 0;
        this.win = false;
        this.guesses = new int[getMaxTries()];
    }

    // Parameterized constructor
    public GuessGameV3(int min, int max, int maxTries) {
        configureGame(min, max, maxTries);
        this.guesses = new int[maxTries];
    }

    // Getter for MAX_GAMES
    public static int getMaxGames() {
        return MAX_GAMES;
    }

    // Getter for gameRecords
    public static GuessGameV3[] getGameRecords() {
        return gameRecords;
    }

    // Getter for recordIndex
    public static int getRecordIndex() {
        return recordIndex;
    }

    // Setter for recordIndex
    public static void setRecordIndex(int index) {
        recordIndex = index;
    }

    // Getter for guesses
    public int[] getGuesses() {
        return guesses;
    }

    // Setter for guesses
    public void setGuesses(int[] guesses) {
        this.guesses = guesses;
    }

    // Getter for guessCount
    public int getGuessCount() {
        return guessCount;
    }

    // Setter for guessCount
    public void setGuessCount(int guessCount) {
        this.guessCount = guessCount;
    }

    // Getter for win
    public boolean isWin() {
        return win;
    }

    // Setter for win
    public void setWin(boolean win) {
        this.win = win;
    }

    // Getter for attemptsSummary
    public String getAttemptsSummary() {
        return attemptsSummary;
    }

    // Setter for attemptsSummary
    public void setAttemptsSummary(String attemptsSummary) {
        this.attemptsSummary = attemptsSummary;
    }

    // Configures the game with the given parameters
    @Override
    public void configureGame(int min, int max, int maxTries) {
        setMin(min);
        setMax(max);
        setMaxTries(maxTries);
        this.guessCount = 0;
        this.win = false;
        Arrays.fill(this.guesses, 0);
    }

    // Converts game details to a string representation
    @Override
    public String toString() {
        return String.format(
            "Range: [%d-%d], Max Tries: %d, Attempts: %d, Result: %s, Guesses: %s",
            getMin(), getMax(), getMaxTries(), getGuessCount(),
            (isWin() ? "Win" : "Lose"), getAttemptsSummary()
        );
    }

    // Plays a single game and returns true if the player wins
    @Override
    public boolean playSingleGame() {
        System.out.println("Welcome to the Number Guessing Game V2!");
        generateAnswer();

        for (int i = 0; i < getMaxTries(); i++) {
            int userGuess = getUserGuess();

            // Validate user guess
            while (userGuess < getMin() || userGuess > getMax()) {
                System.err.printf("The number must be between %d and %d\n", getMin(), getMax());
                userGuess = getUserGuess();
            }

            this.guesses[i] = userGuess;

            // Check if the guess is correct
            if (numberGuessingResponse(userGuess, i) == 0) {
                setWin(true);
                return true;
            }
        }

        // Notify the user if they lose
        System.out.printf("Sorry, you've used all your attempts. The correct answer was: %d\n", getAnswer());
        return false;
    }

    // Generates a summary of the game and returns it as a string
    public String getGameLog() {
        StringBuilder summary = new StringBuilder();
        for (int i = 0; i < getGuessCount(); i++) {
            summary.append(i == getGuessCount() - 1 ? guesses[i] : guesses[i] + ", ");
        }
        setAttemptsSummary(summary.toString());
        return toString();
    }

    // Adds a game record to the gameRecords array
    public static void addGameRecord(GuessGameV3 game) {
        if (recordIndex >= MAX_GAMES) {
            System.out.println("Maximum games limit reached. This will be the final session.");
            return;
        }
        gameRecords[recordIndex] = game;
        recordIndex++;
    }

    // Returns the total number of games played
    public static int getGameCount() {
        return recordIndex;
    }
}
