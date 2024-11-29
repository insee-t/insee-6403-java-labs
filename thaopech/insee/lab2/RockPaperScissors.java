// #+title: The RockPaperScissors Program
// #+author: Insee thaopech
// #+id: 673040640-3
// #+sec: 2
// #+last_updated: 2024 Nov 29
// 
// This program accepts two arguments then calculate logic of normal game of rock paper and scissors.
// Rock crushes Scissors: Rock wins.
// Scissors cut Paper: Scissors win.
// Paper covers Rock: Paper wins.
// If both players choose the same option, the result is a tie.
// * The output should be
// 
// Player 1 chooses: <player1>
// Player 2 chooses: <player2>
// 
// If Player 1 wins: "Player 1 wins!"
// If Player 2 wins: "Player 2 wins!"
// If it's a tie: "It's a tie!"
// 
// 
// #+begin_src java

  package thaopech.insee.lab2;


  public class RockPaperScissors {

      // Use enum make code more understandable.
      public enum Choice {
          rock,
          paper,
          scissors
      }
    
      // Calculate rock paper scissors based on state logic.
      public static Choice RockPaperScissorsCal(Choice choice) {

          switch (choice) {
              case paper:
                  return Choice.rock;
              case rock:
                  return Choice.scissors;
              case scissors:
                  return Choice.paper;
              default:
                  throw new IllegalArgumentException();
          }
      }

      // Function that determine who wins.
      public static String RockPaperScissorsResponse(Choice player1, Choice player2) {

          if (player1 == player2) {
              return "It's a tie!";
          } 
          if (player2 == RockPaperScissorsCal(player1)) {
              return "Player 1 wins!";
          }
          return "Player 2 wins!";
      }

      public static void main(String[] args) {
          
          // Check if number of arguments valid.
          if (args.length != 2) {
              System.err.println("Error: Invalid number of arguments. Please provide exactly two arguments.");
              System.exit(0);
          }
          Choice player1 = null;
          Choice player2 = null;

          try {
              player1 = Choice.valueOf(args[0].toLowerCase());
              player2 = Choice.valueOf(args[1].toLowerCase());
          } catch (IllegalArgumentException e) {
              System.err.println("Error: Invalid choice(s). Valid choices are 'rock', 'paper', or 'scissors'.");
              System.exit(0);
          }

          // Output
          System.out.println("Player 1 chooses: " + player1);
          System.out.println("Player 2 chooses: " + player2);
        
          String result = RockPaperScissorsResponse(player1, player2);
          System.out.println(result);

          System.exit(0);
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
