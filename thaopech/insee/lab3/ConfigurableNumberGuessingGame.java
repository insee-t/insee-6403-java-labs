// #+title: The ConfigurableNumberGuessingGame Program
// #+author: Insee thaopech
// #+id: 673040640-3
// #+sec: 2
// #+last_updated: 2024 Dec 6
// 
// The program simulates a guessing game of which a user guesses a number from <min> to <max>. The answer is randomly generated then a user enters a number via the console. 
// * Each time a number is entered, one of the following three possible outputs will be displayed. 
// 	1. “Congratulations!”	if the number entered is the same as the answer.
//  2. “Try a lower number!” 	if the number entered is higher than the answer.
//  3. “Try a higher number!” 	if the number entered is smaller than the answer.  
// 
// * The game ends when the user guesses the answer correctly or the user guesses the number incorrectly <numOfTries> times. 
// 
// * The program asks the user to enter the min value, the max value, and the maximum number of tries.
// ** The program also checks and detects configuration settings that the user may enter as following
// *** The program checks whether the max value is at least equal to the min value. If not, the program will keep asking for the new max value until the max value is not less than the max value. 
// *** The program checks whether the number of maximum tries is greater than 0. If not, the program will keep asking for the new maximum tries until the maximum tries is greater than 0. 
// *** The program checks whether a number is outside the minimum or maximum values. If it is, the program asks the user to enter a number again and does not increment the number of tries.  
// 
package thaopech.insee.lab3;

import java.util.Scanner;  // Import the Scanner class

public class ConfigurableNumberGuessingGame {

    private static int min, max, numOfTries, target;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter the min value: ");
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

        target = min + (int)(Math.random() * ((max - min) + 1));

        System.out.println("Welcome to a number guessing game!");

        for (int index = 1, userGuess; index <= numOfTries; index++) {

            userGuess = getUserGuess();
            while (userGuess < min || userGuess > max) {
                System.err.println("The number must between " +  min + " and " + max);
                userGuess = getUserGuess();
            }

            if (numberGuessingResponse(userGuess, index) == 0) {
                scanner.close();
                System.exit(0);
            }
        }

        System.out.println("You have tried " + numOfTries + " times. You ran out of guesses");
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

    public static int getMax() {
        System.out.print("Enter the max value: ");
        return scanner.nextInt();
    }

    public static int getNumOfTries() {
        System.out.print("Enter the maximum number of tires: ");
        return scanner.nextInt();
    }

    public static int getUserGuess() {
        System.out.print("Enter an integer between " + min + " and " + max + ": ");
        return scanner.nextInt();
    }
}
