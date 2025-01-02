        // fix the format
        // ? Make sure they're instance though.
package thaopech.insee.lab6.v1;

import java.util.*;

public class NumberGuessingOOPGame {

    private GuessGame game;
    public static Scanner input = new Scanner(System.in);

    // Figure 2
    public void configure() {
        this.game = new GuessGame();
        this.game.configureGame();
    }

    // Figure 3
    public void playGames() {
        boolean playAgain;
        do {
            boolean result = this.game.playSingleGame();
            System.out.println(result ? "You win!" : "Better luck next time.");
            System.out.print("Do you want to play again? (y\\n): ");
            playAgain = input. next().equalsIgnoreCase("y");
            if (playAgain) {
                configure();
            }
        } while (playAgain);

        System.out.println("Thank you for playing the Number Guessing Game!");
    }

    public static void main(String[] args) {
        NumberGuessingOOPGame program = new NumberGuessingOOPGame();
        program.configure();
        program.playGames();
    }
}
