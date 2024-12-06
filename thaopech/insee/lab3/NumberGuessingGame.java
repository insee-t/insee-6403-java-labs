// #+title: The NumberGuessingGame Program
// #+author: Insee thaopech
// #+id: 673040640-3
// #+sec: 2
// #+last_updated: 2024 Dec 6
// 
// The program simulates a guessing game of which a user guesses a number from 1 to 10. The answer is randomly generated then a user enters a number via the console. 
// * Each time a number is entered, one of the following three possible outputs will be displayed. 
// 	1. “Congratulations!”	if the number entered is the same as the answer.
//  2. “Try a lower number!” 	if the number entered is higher than the answer.
//  3. “Try a higher number!” 	if the number entered is smaller than the answer.  
// 
// * The game ends when the user guesses the answer correctly or the user guesses the number incorrectly 5 times. 
//
package thaopech.insee.lab3;

import java.util.Scanner;  // Import the Scanner class

public class NumberGuessingGame {

    public static int target;

    public static void main(String[] args) {

        int min = 1;
        int max = 10;
        target = min + (int)(Math.random() * ((max - min) + 1));

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Welcome to a number guessing game!");

        for (int index = 1, userGuess; index <= 5; index++) {
            System.out.print("Enter an integer between " + min + " and " + max + ": ");

            userGuess = scanner.nextInt();

            if (numberGuessingResponse(userGuess, index) == 0) {
                scanner.close();
                System.exit(0);
            }
        }

        System.out.println("You have tried 5 times. You ran out of guesses");
        System.out.println("The answer is " + target);
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
}
