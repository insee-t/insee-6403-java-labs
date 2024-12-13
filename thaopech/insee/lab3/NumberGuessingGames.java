// +title: The numberGuessingGames Program
// #+author: Insee thaopech
// #+id: 673040640-3
// #+sec: 2
// #+last_updated: 2024 Dec 6
// 
// The program allows the user to play the [[#[[./thaopech/insee/lab3/ConfigurableNumberGuessingGame.java][The ConfigurableNumberGuessingGame program]]][ConfigurableNumberGuessingGame]] several times until the user indicates that he/she wants to stop playing the game.  
// * The answer will be random each time the user chooses to play again. 
// On the other hand, the program will not ask the user to config (min,max,number of tries) again.
// * After the game ends, the program gives an option to play again if the user enters “y” or “Y”. If the user enters other values, the program will quit and print the message  “Thank you for playing our games. Bye!"

package thaopech.insee.lab3;

import java.util.*;

public class NumberGuessingGames {

    private static int min, max, numTries, target;
    private static Scanner scanner = new Scanner(System.in);
    private static final String CONGRATULATIONS = "Congratulations!";
    private static final String TRY_LOWER = "Try a lower number!";
    private static final String TRY_HIGHER = "Try a higher number!";
    private static final String INVALID_INPUT_MESSAGE = "Invalid input. Please enter an integer.";

    public static void main(String[] args) {
        min = safeInput("Enter the min value:");
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

        String userInput;
        do {
            numberGuessingGame();
            System.out.print("What to play again (Y or y):");
            userInput = scanner.next();
        } while (userInput.equalsIgnoreCase("y"));

        System.out.println("Thank you for playing our games. Bye!");
        scanner.close();
    }

    public static int numberGuessingResponse(int userGuess, int index) {
        if (userGuess == target) {
            System.out.println(CONGRATULATIONS);
            System.out.println("You have tried " + index + (index == 1 ? " time" : " times"));
            return 0;
        }
        if (userGuess > target) {
            System.out.println(TRY_LOWER);
            return 1;
        }
        System.out.println(TRY_HIGHER);
        return 1;
    }

    public static int safeInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.err.println(INVALID_INPUT_MESSAGE);
                scanner.next(); // Clear the invalid input
            }
        }
    }

    public static int getMax() {
        return safeInput("Enter the max value:");
    }

    public static int getNumOfTries() {
        return safeInput("Enter the maximum number of tries:");
    }

    public static int getUserGuess() {
        System.out.print(String.format("Enter an integer between %d and %d:", min, max));
        return scanner.nextInt();
    }

    public static int numberGuessingGame() {
        System.out.println("Welcome to a number guessing game!");
        target = generateRandomNumber(min, max);

        for (int index = 1, userGuess; index <= numTries; index++) {
            userGuess = getUserGuess();
            while (userGuess < min || userGuess > max) {
                System.err.println(String.format("The number must between %d and %d", min, max));
                userGuess = getUserGuess();
            }

            if (numberGuessingResponse(userGuess, index) == 0) {
                return 0;
            }
        }

        System.out.println(String.format("You have tried %d times. You ran out of guesses", numTries));
        System.out.println("The answer is " + target);
        return 0;
    }

    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
