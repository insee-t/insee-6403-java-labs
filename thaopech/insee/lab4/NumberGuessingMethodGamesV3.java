// #+title: The NumberGuessingMethodGamesV3 Program
// #+author: Insee thaopech
// #+id: 673040640-3
// #+sec: 2
// #+last_updated: 2024 Dec 20
/*
 * This is an enhanced version of the number guessing game. The user is tasked
 * with guessing a randomly generated target number within a specified range
 * and with a limited number of guesses. The program tracks the player's
 * performance across multiple games and provides feedback on each round.
 *
 * Key features:
 * - Configurable game parameters: minimum and maximum range, and maximum tries.
 * - Provides feedback on whether the guessed number is too high or too low.
 * - Tracks the history of guesses for each game, allowing the user to view past guesses.
 * - Keeps track of win statistics: total games played, games won, win ratio, average guesses per game, and high score (fewest guesses).
 * - Allows the user to play multiple rounds and displays detailed statistics after the game ends.
 *
 * The game continues until the user decides to quit, and the program will print out
 * detailed statistics such as win ratio, average number of guesses, and high score.
 */
package thaopech.insee.lab4;

import java.util.*;
import java.text.NumberFormat;

public class NumberGuessingMethodGamesV3 {

    private static final int MAX = (int)(1e9);
    private static int min, max, numTries, target, guessIndex, highscore, numWin, numGame, totalGuess;
    private static boolean isWin = false;
    private static ArrayList<Integer> guessHistory = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        highscore = MAX; // Set high score to a large number
        numWin = 0;
        numGame = 0;
        totalGuess = 0;
        guessIndex = 1;
        configure();  // Configuring the game parameters
        playGames();  // Start playing the game
    }

    public static int numberGuessingResponse(int userGuess, int index) {
        if (userGuess == target) {
            System.out.println("Congratulations!");
            System.out.println("You have tried " + index + (index == 1 ? " time" : " times"));
            return 0;
        }
        if (userGuess > target) {
            System.out.println("Try a lower number!");
            return 1;
        }
        System.out.println("Try a higher number!");
        return 1;
    }

    public static int getMax() {
        System.out.print("Enter the max value:");
        return scanner.nextInt();
    }

    public static int getNumOfTries() {
        System.out.print("Enter the maximum number of tries:");
        return scanner.nextInt();
    }

    public static int getUserGuess() {
        System.out.print(String.format("Enter an integer between %d and %d:", min, max));
        return scanner.nextInt();
    }

    public static void playGame() {
        guessHistory.clear();

        System.out.println("Welcome to a number guessing game!");
        genAnswer();

        for (guessIndex = 1; guessIndex <= numTries; guessIndex++) {
            int userGuess = getUserGuess();
            while (userGuess < min || userGuess > max) {
                System.err.println(String.format("The number must be between %d and %d", min, max));
                userGuess = getUserGuess();
            }

            guessHistory.add(userGuess);

            if (numberGuessingResponse(userGuess, guessIndex) == 0) {
                isWin = true;
                return;
            }
        }

        --guessIndex;
        System.out.println(String.format("You have tried %d times. You ran out of guesses", numTries));
        isWin = false;
    }

    public static void configure() {
        System.out.print("Enter the min value:");
        min = scanner.nextInt();

        max = getMax();
        while (max < min) {
            System.err.println("The max value must be at least equal to the min value");
            max = getMax();
        }

        numTries = getNumOfTries();
        while (numTries <= 0) {
            System.err.println("The maximum number of tries must be greater than 0");
            numTries = getNumOfTries();
        }
    }

    public static void genAnswer() {
        target = min + (int)(Math.random() * ((max - min) + 1));
    }

    public static void playGames() {
        String userInput;
        do {
            playGame();
            int currentNumGuesses = guessHistory.size();
            ++numGame;
            displayGuessesLoop();
            System.out.println(String.format("Game log: Answer: %d, Guesses: %d, Win: %b", target, currentNumGuesses, isWin));
            numWin += (isWin ? 1 : 0);
            totalGuess += currentNumGuesses;
            highscore = Math.min(highscore, currentNumGuesses);

            System.out.print("What to play again (Y or y):");
            userInput = scanner.next();
        } while (userInput.equalsIgnoreCase("y"));

        System.out.println("Thank you for playing our games. Bye!");
        System.out.println("===== All Games Stats =====");
        System.out.println(String.format("Total games played: %d", numGame));
        System.out.println(String.format("Total games won: %d", numWin));
        System.out.println("Win ratio: " + getFormattedWinRatio(numWin, numGame));
        System.out.println(String.format("Average number of guesses per game: %d", totalGuess / numGame));
        System.out.println(String.format("High score (the lowest number of guesses): %d", highscore));
        scanner.close();
        System.exit(0);
    }

    public static void displayGuessesLoop() {
        String userInput;
        do {
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit:");
            userInput = scanner.next();
            displayGuesses(userInput);
        } while (userInput.equalsIgnoreCase("a") || userInput.equalsIgnoreCase("g"));
    }

    public static void displayGuesses(String userInput) {
        if (userInput.equalsIgnoreCase("a")) {
            int index = 1;
            for (var guess : guessHistory) {
                System.out.println(String.format("Guess %d: %d", index, guess));
                ++index;
            }
        } else if (userInput.equalsIgnoreCase("g")) {
            System.out.print("Enter the guess number:");
            int logOption = scanner.nextInt();
            --logOption;
            if (logOption >= 0 && logOption < guessHistory.size()) {
                System.out.println("Guess " + (logOption + 1) + ": " + guessHistory.get(logOption));
            } else {
                System.out.println("Invalid guess number.");
            }
        }
    }

    public static String getFormattedWinRatio(int wins, int games) {
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMinimumFractionDigits(1);
        return percentFormat.format((double) wins / games);
    }
}
