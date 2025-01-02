package thaopech.insee.lab6;

import java.util.*;

public class NumberGuessingOOPGameV2 {

    private GuessGameV2 game;
    public static Scanner input = new Scanner(System.in);

    // Figure 2
    public void configure() {
        this.game = new GuessGameV2();
        this.game.configureGame();
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
    }
}
