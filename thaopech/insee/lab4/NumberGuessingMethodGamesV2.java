// +title: The NumberGuessingMethodGamesV2 Program
// #+author: Insee thaopech
// #+id: 673040640-3
// #+sec: 2
// #+last_updated: 2024 Dec 20
//
/*
 * This program implements a number guessing game where the user is tasked with
 * guessing a randomly generated target number within a specified range and
 * within a limited number of attempts.
 *
 * The user sets a minimum and maximum range for the target number, as well as
 * the maximum number of guesses allowed. After each guess, the program will
 * indicate if the guessed number is too high or too low. The user can choose
 * to play multiple rounds and can also view a history of their guesses.
 *
 * Key features:
 * - Allows the user to input a range (min and max values) and a maximum number of tries.
 * - Guides the user through the guessing process with feedback on each guess.
 * - Allows the user to view all previous guesses or select a specific guess.
 * - The game continues in a loop until the user decides to stop playing.
*/

package thaopech.insee.lab4;

import java.util.Scanner;  // Import the Scanner class

public class NumberGuessingMethodGamesV2 {

    private static int min, max, numTries, target, gameIndex;
    private static int[] gameLogs= new int[11];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        gameIndex = 1;
        configure();
        playGames();
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
        System.out.print("Enter an integer between " + min + " and " + max + ":");
        return scanner.nextInt();
    }

    public static void playGame() {

        System.out.println("Welcome to a number guessing game!");
        genAnswer();

        for (int guessIndex = 1; guessIndex <= numTries; guessIndex++) {
            int userGuess = getUserGuess();
            while (userGuess < min || userGuess > max) {
                System.err.println(String.format("The number must be between %d and %d", min, max));
                userGuess = getUserGuess();
            }

            if (numberGuessingResponse(userGuess, guessIndex) == 0) {
                return;
            }
        }

        System.out.println(String.format("You have tried %d times. You ran out of guesses", numTries));
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

    // public static bool validGuess()

    public static void genAnswer() {
        target = min + (int)(Math.random() * ((max - min) + 1));
    }

    public static void playGames() {

        String userInput;
        do {
            playGame();
            displayGuessesLoop();
            System.out.print("What to play again (Y or y):");
            userInput = scanner.next();
        } while(userInput.equalsIgnoreCase("y"));

        System.out.println("Thank you for playing our games. Bye!");
        scanner.close();
        System.exit(0);
    }

    public static void displayGuessesLoop() {

        System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit:");
        String userOption = scanner.next();
        displayGuesses(userOption);

        while (userOption.equalsIgnoreCase("a") || userOption.equalsIgnoreCase("g")) {
            System.out.print("Enter 'a' to list all guesses, 'g' for a specific guess, or any other key to quit:");
            userOption = scanner.next();
            displayGuesses(userOption);
        }
    }

    public static void displayGuesses(String userOption) {

        if (userOption.equalsIgnoreCase("a")) {
            for (int logIndex = 1; logIndex <= gameIndex; logIndex++) {
                System.out.println("Guess " + logIndex + ": " + gameLogs[logIndex]);
            }
        } else if (userOption.equalsIgnoreCase("g")){
            System.out.print("Enter the guess number:");
            int logOption = scanner.nextInt();
            System.out.println("Guess " + logOption + ": " + gameLogs[logOption]);
        }
    }
}
