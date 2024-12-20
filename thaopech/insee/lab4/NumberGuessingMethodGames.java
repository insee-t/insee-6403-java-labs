// #+title: The NumberGuessingMethodGames Program
// #+author: Insee thaopech
// #+id: 673040640-3
// #+sec: 2
// #+last_updated: 2024 Dec 20
//
/*
 * This program implements a number guessing game with multiple rounds.
 * It begins by configuring the game with a minimum and maximum number range,
 * and the maximum number of guesses allowed per round. The `configure()` method
 * is called to initialize these settings. Each time the game is played,
 * the `genAnswer()` method generates a new random answer within the specified range.
 * The `playGame()` method then starts a new round where the user guesses the number
 * and is given feedback until the answer is guessed correctly or the maximum
 * number of guesses is reached. After completing a game, the `playGames()` method
 * can be called to initiate further rounds if desired.
 */

package thaopech.insee.lab4;

import java.util.Scanner; // Import the Scanner class

public class NumberGuessingMethodGames {

    private static int min, max, numTries, target;

    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
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

    public static int getNumTries() {
        System.out.print("Enter the maximum number of tries:");
        return scanner.nextInt();
    }

    public static int getUserGuess() {
        System.out.print(String.format("Enter an integer between %d and %d:", min, max));
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

        numTries = getNumTries();
        while (numTries <= 0) {
            System.err.println("The maximum number of tries must be greater than 0");
            numTries = getNumTries();
        }

    }

    // public static bool validGuess()

    public static void genAnswer() {
        target = min + (int) (Math.random() * ((max - min) + 1));
    }

    public static void playGames() {
        String userInput;
        do {
            playGame();
            System.out.print("What to play again (Y or y):");
            userInput = scanner.next();
        } while (userInput.equalsIgnoreCase("y"));

        System.out.println("Thank you for playing our games. Bye!");
        scanner.close();
        System.exit(0);
    }
}
