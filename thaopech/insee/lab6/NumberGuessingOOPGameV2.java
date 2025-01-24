package thaopech.insee.lab6;

import java.util.*;

public class NumberGuessingOOPGameV2 {

    private GuessGameV2 game;
    public static final Scanner input = new Scanner(System.in);

    // Figure 2
    public void configure() {
        this.game = new GuessGameV2();

        int defaultMaxTries = 10;

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
        System.out.println("Game Configuration: " + this.game.toString());
    }

    // Figure 3
    public void playGames() {
        boolean playAgain;
        do {
            boolean result = this.game.playSingleGame();
            System.out.println(result ? "You win!" : "Better luck next time.");
            System.out.print("Do you want to play again? (y\\n): ");
            playAgain = input.next().equalsIgnoreCase("y");
            if (playAgain) {
                configure();
            }
        } while (playAgain);

        System.out.println("Thank you for playing the Number Guessing Game V2!");
    }

    public static void main(String[] args) {
        NumberGuessingOOPGameV2 program = new NumberGuessingOOPGameV2();
        program.configure();
        program.playGames();
        input.close();
    }
}
