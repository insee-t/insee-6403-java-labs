// #+title: The Dealer Program
// #+author: Insee thaopech
// #+id: 673040640-3
// #+sec: 2
// #+last_updated: 2024 Dec 6
//  
// This program accepts three arguments then processes and displays dealer information.
// * The output should be
// 
// : Dealer's name : <dealerName>
// : Number of clients : <NumClient>
// : Gender : <dealerGender>
// 
// #+begin_src java

  package thaopech.insee.lab2;


  public class Dealer {

      public static void main(String[] args) {
          //
        // Check for exactly 3 arguments
          if (args.length != 3) {
              System.err.println("Error: Invalid number of arguments. Please provide exactly three arguments.");
              System.exit(0);
          }
        // Extract arguments
          String dealerName = args[0];
          long numClient = Long.parseLong(args[1]);
          String dealerGender = args[2];
          System.out.println("Dealer's name: " + dealerName);
          System.out.println("Number of clients :" + numClient);
          System.out.println("Gender: " + dealerGender);

          System.exit(0);
      }
  }
// #+end_src
// 
// #+RESULTS:
// 
// #+begin_src sh
//   java thaopech.insee.lab2.Dealer "Boss Paul" 1000000 Male
// #+end_src
// 
// #+RESULTS:
// | Dealer's | name: | Boss    | Paul     |
// | Number   | of    | clients | :1000000 |
// | Gender:  | Male  |         |          |
// 
// #+begin_src sh
//   java thaopech.insee.lab2.Dealer "Boss Paul"
// #+end_src
// 
// #+RESULTS:
// 
// #+begin_src sh
//   java thaopech.insee.lab2.Dealer
// #+end_src
// 
// #+RESULTS:
