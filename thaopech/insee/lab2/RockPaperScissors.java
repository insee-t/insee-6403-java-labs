// #+title: The RockPaperScissors Program
// #+author: Insee thaopech
// #+id: 673040640-3
// #+sec: 2
// #+last_updated: 2024 Dec 6
// 
// This program accepts two arguments then calculate logic of normal game of Rock-Paper-Scissors.
// 1. Rock crushes Scissors: Rock wins.
// 2. Scissors cut Paper: Scissors win.
// 3. Paper covers Rock: Paper wins.
// 4. If both players choose the same option, the result is a tie.
// * The output should be
// 
// : Player 1 chooses: <player1>
// : Player 2 chooses: <player2>
// 
// - If Player 1 wins: "Player 1 wins!"
// - If Player 2 wins: "Player 2 wins!"
// - If it's a tie: "It's a tie!"
// 
// 
// #+begin_src java

  package thaopech.insee.lab2;


  public class RockPaperScissors {

      // Use enum make code more understandable
      public enum Choice {
          ROCK,
          PAPER,
          SCISSORS
      }

      public static void main(String[] args) {
          
          // Check if exactly 2 arguments are provided
          if (args.length != 2) {
              System.err.println("Error: Invalid number of arguments. Please provide exactly two arguments.");
              System.exit(0);
          }
          Choice player1 = null;
          Choice player2 = null;

          try {
              player1 = Choice.valueOf(args[0].toUpperCase());
              player2 = Choice.valueOf(args[1].toUpperCase());
          } catch (IllegalArgumentException e) {
              System.err.println("Error: Invalid choice(s). Valid choices are 'rock', 'paper', or 'scissors'.");
              return;
          }

          // Output choices and result
          System.out.println("Player 1 chooses: " + player1);
          System.out.println("Player 2 chooses: " + player2);
        
          String result = getResult(player1, player2);
          System.out.println(result);

          System.exit(0);
      }
    
      // Calculate rock paper scissors based on stated logic
      public static Choice getCounterChoice(Choice choice) {

          switch (choice) {
              case PAPER:
                  return Choice.ROCK;
              case ROCK:
                  return Choice.SCISSORS;
              case SCISSORS:
                  return Choice.PAPER;
              default:
                  throw new IllegalArgumentException();
          }
      }

      // Function that determine who wins
      public static String getResult(Choice player1, Choice player2) {

          if (player1 == player2) {
              return "It's a tie!";
          } 
          if (player2 == getCounterChoice(player1)) {
              return "Player 1 wins!";
          }
          return "Player 2 wins!";
      }
  }
// #+end_src
// 
// #+RESULTS:
// 
// #+begin_src sh
//   java thaopech.insee.lab2.RockPaperScissors rock paper
// #+end_src
// 
// #+RESULTS:
// | Player | 1 | chooses: | rock  |
// | Player | 2 | chooses: | paper |
// | Player | 2 | wins!    |       |
// 
// #+begin_src sh
//   java thaopech.insee.lab2.RockPaperScissors
// #+end_src
// 
// #+RESULTS:
// 
// #+begin_src sh 
//   java thaopech.insee.lab2.RockPaperScissors gun rocket
// #+end_src
// 
// #+RESULTS:
