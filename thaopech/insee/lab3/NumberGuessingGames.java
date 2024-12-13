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

    public static void main(String[] args) {

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

        String userInput;
        do {
            numberGuessingGame();
            System.out.print("What to play again (Y or y):");
            userInput = scanner.next();
        }
        while(userInput.equalsIgnoreCase("y"));

        System.out.println("Thank you for playing our games. Bye!");
        scanner.close();
        System.exit(0);
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

    public static int numberGuessingGame() {

        System.out.println("Welcome to a number guessing game!");
        target = min + (int)(Math.random() * ((max - min) + 1));

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
}
