// NumberGuessingOOPGameV3.java
// This class is the main driver for the Number Guessing Game V3.
// It allows users to configure the game, play multiple rounds, and view game records.
// The class integrates with GuessGameV3 for game logic and maintains a user-friendly interface.
/**
 * @author Insee Thaopech
 * @version 1.0
 */

package thaopech.insee.lab6;

import java.util.*;

public class NumberGuessingOOPGameV3 {

    // Instance of the GuessGameV3 for managing a single game
    private GuessGameV3 game;

    // Static Scanner instance for user input
    public static final Scanner input = new Scanner(System.in);

    // Configures the game by setting minimum, maximum values, and the maximum number of tries
    public void configure() {
        this.game = new GuessGameV3();

        int defaultMaxTries = 10; // Default value for maximum tries

        System.out.print("Enter the min value: ");
        int min = input.nextInt();

        System.out.print("Enter the max value: ");
        int max = input.nextInt();

        this.game.configureGame(min, max, defaultMaxTries);

        System.out.print("Enter the maximum number of tries: ");
        int maxTries = input.nextInt();

        min = this.game.getMin();
        max = this.game.getMax();

        this.game.configureGame(min, max, maxTries);
        GuessGameV3.addGameRecord(this.game); // Add the configured game to records
    }

    // Allows users to play multiple games or view records
    public void playGames() {
        int choice;
        this.game.playSingleGame(); // Play the first game

        do {
            System.out.println("Do you want to:");
            System.out.println("1. Play again");
            System.out.println("2. View game records");
            System.out.println("3. Quit");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    configure();
                    this.game.playSingleGame();
                    break;
                case 2:
                    viewRecords();
                    break;
                default:
                    break;
            }
        } while (choice != 3);

        System.out.println("Thank you for playing the Number Guessing Game V3!");
    }

    // Displays the records of past games
    public static void viewRecords() {
        System.out.println("View:");
        System.out.println("1. Complete Records");
        System.out.println("2. Specific Game Record");

        int selection = input.nextInt(); // Get user's selection
        GuessGameV3[] gameHistory = GuessGameV3.getGameRecords(); // Retrieve all game records

        switch (selection) {
            case 1:
                // Show all game records
                for (int index = 0; index < GuessGameV3.getRecordIndex(); index++) {
                    System.out.println("Game " + (index + 1) + ": " + gameHistory[index].getGameLog());
                }
                break;

            default:
                boolean validInput = false;
                int gameNumber = 0;

                // Continuously prompt for a valid game number
                while (!validInput) {
                    System.out.print("Enter the game number to view: ");
                    if (input.hasNextInt()) {
                        gameNumber = input.nextInt();
                        if (gameNumber >= 1 && gameNumber <= GuessGameV3.getRecordIndex()) {
                            validInput = true;
                        } else {
                            System.err.println("Please provide a number between 1 and " + GuessGameV3.getRecordIndex() + ".");
                        }
                    } else {
                        System.err.println("Invalid input. Please enter a numeric value.");
                        input.next();
                    }
                }

                // Display the specific game record
                System.out.println(gameHistory[gameNumber - 1].getGameLog());
                break;
        }
    }

    // Main method to start the program
    public static void main(String[] args) {
        NumberGuessingOOPGameV3 program = new NumberGuessingOOPGameV3();
        program.configure(); // Initial game configuration
        program.playGames(); // Start the game loop
        input.close(); // Close the Scanner
    }
}
