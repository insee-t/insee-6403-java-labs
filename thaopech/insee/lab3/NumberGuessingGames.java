// #+title: The numberGuessingGames Program
// #+author: Insee thaopech
// #+id: 673040640-3
// #+sec: 2
// #+last_updated: 2024 Dec 6
// 
// The program allows the user to play the [[#ConfigurableNumberGuessingGame][ConfigurableNumberGuessingGame]] several times until the user indicates that he/she wants to stop playing the game.  
// * The answer will be random each time the user chooses to play again. 
// On the other hand, the program will not ask the user to config (min,max,number of tries) again.
// * After the game ends, the program gives an option to play again if the user enters “y” or “Y”. If the user enters other values, the program will quit and print the message  “Thank you for playing our games. Bye!"

package thaopech.insee.lab3;

import java.util.Scanner;  // Import the Scanner class

public class NumberGuessingGames {

    private static int min, max, numOfTries, target;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter the min value:");
        min = scanner.nextInt();

        max = getMax();
        while (max < min) {
            System.err.println("The max value must be at least equal to the min value");
            max = getMax();
        }

        numOfTries = getNumOfTries();

        while (numOfTries <= 0) {
            System.err.println("The maximum number of tries must be greater than 0");
            numOfTries = getNumOfTries();
        }

        numberGuessingGame();

        System.out.print("What to play again (Y or y):");
        char userResponse = scanner.next().charAt(0);
        while(Character.toUpperCase(userResponse) == 'Y') {
            numberGuessingGame();
            System.out.print("What to play again (Y or y):");
            userResponse = scanner.next().charAt(0);
        }

        System.out.println("Thank you for playing our games. Bye!");
        System.out.println("Welcome to a number guessing game!");
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
        System.out.print("Enter the maximum number of tires:");
        return scanner.nextInt();
    }

    public static int getUserGuess() {
        System.out.print("Enter an integer between " + min + " and " + max + ":");
        return scanner.nextInt();
    }

    public static int numberGuessingGame() {

        target = min + (int)(Math.random() * ((max - min) + 1));

        for (int index = 1, userGuess; index <= numOfTries; index++) {

            userGuess = getUserGuess();
            while (userGuess < min || userGuess > max) {
                System.err.println("The number must between " +  min + " and " + max);
                userGuess = getUserGuess();
            }

            if (numberGuessingResponse(userGuess, index) == 0) {
                return 0;
            }
        }

        System.out.println("You have tried " + numOfTries + " times. You ran out of guesses");
        System.out.println("The answer is " + target);
        return 0;
    }
}
