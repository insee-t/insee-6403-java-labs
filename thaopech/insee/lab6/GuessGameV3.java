/**
 * GuessGameV3.java
 * This class extends GuessGameV2 and adds additional features such as game logging and record keeping.
 * It includes methods for configuring the game, playing a single game, and managing game records.
 * The class makes use of getters and setters for better encapsulation.
 * @author Insee Thaopech
 * @version 1.1
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

    // Indicates if the player has won the game
    private boolean win;

    // Summary of attempts made during the game
    private String attemptsSummary;

    // Index to track the number of recorded games
    private static int recordIndex = 0;

    // Default constructor
    public GuessGameV3() {
        super();
        setAttempts(0);
        this.win = false;
        this.guesses = new int[getMaxTries()];
        this.attemptsSummary = "";
    }

    // Parameterized constructor
    public GuessGameV3(int min, int max, int maxTries) {
        configureGame(min, max, maxTries);
        this.guesses = new int[maxTries];
        this.attemptsSummary = "";
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

    // Getter for win
    public boolean getWin() {
        return win;
    }

    // Setter for win
    public void setWin(boolean win) {
        this.win = win;
    }

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
        setAttempts(0);
        this.win = false;
        Arrays.fill(this.guesses, 0);
    }

    // Converts game details to a string representation
    @Override
    public String toString() {
        String attemptsSummary = getAttemptsSummary();
        attemptsSummary = attemptsSummary.substring(0, attemptsSummary.length() - 2);
        return String.format(
            "Range: [%d-%d], Max Tries: %d, Attempts: %d, Result: %s, Guesses: %s",
            getMin(), getMax(), getMaxTries(), getAttempts(),
            (getWin() ? "Win" : "Lose"), attemptsSummary);
    }

    // Plays a single game and returns true if the player wins
    @Override
    public boolean playSingleGame() {
        System.out.println("Welcome to the Record-Keeping Number Guessing Game!");
        generateAnswer();

        for (int i = 1; i <= getMaxTries(); i++) {
            int userGuess = getUserGuess();

            // Validate user guess
            while (userGuess < getMin() || userGuess > getMax()) {
                System.err.printf("The number must be between %d and %d\n", getMin(), getMax());
                userGuess = getUserGuess();
            }

            guesses[i] = userGuess;
            setAttempts(getAttempts() + 1);
            setAttemptsSummary(getAttemptsSummary()  + guesses[i] + ", ");

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
