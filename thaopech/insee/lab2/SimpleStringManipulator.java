// #+title: The SimpleStringManipulator Program
// #+author: Insee thaopech
// #+id : 673040640-3
// #+sec : 2
// #+last_updated: 2024 Nov 29
// 
// This program accepts two arguments and performs simple manipulations.
// 
// * First String Processing:
// - If the first string starts with a vowel (a, e, i, o, u, case-insensitive), convert the first character to uppercase.
// - Else, convert the first character to lowercase.
// 
// * Second String Processing:
// - If the second string ends with a consonant (any letter that's not a vowel, case-insensitive), convert the last character to uppercase.
// - Else, convert the last character to lowercase.
// 
// * Result String:
// - Concatenate the modified first string and the modified second string.
// 
// * The output should be
// 
// First String: <firstString>
// Second String: <secString>
// Resultng Sting: <result>
// 
// #+begin_src java

  package thaopech.insee.lab2;


  public class SimpleStringManipulator {

      public static void main(String[] args) {
          if (args.length != 2) {
              System.err.println("Invalid number of arguments. Please provide exactly two strings as arguments.");
              return;
          }
          String firstString = args[0];
          String secString = args[1];
          char firstCharOfFirstString = Character.toLowerCase(firstString.charAt(0));
          char lastCharOfSecString = Character.toLowerCase(secString.charAt(secString.length() - 1));

          System.out.println("First String: " + firstString);
          System.out.println("Second String: " + secString);

          if (firstCharOfFirstString == 'a' ||
              firstCharOfFirstString == 'e' ||
              firstCharOfFirstString == 'i' ||
              firstCharOfFirstString == 'o' ||
              firstCharOfFirstString == 'u') {
              firstString = Character.toUpperCase(firstCharOfFirstString) + firstString.substring(1);
          } else {
              firstString = firstCharOfFirstString + firstString.substring(1);
          }

          if (lastCharOfSecString != 'a' &&
              lastCharOfSecString != 'e' &&
              lastCharOfSecString != 'i' &&
              lastCharOfSecString != 'o' &&
              lastCharOfSecString != 'u') {
              secString = secString.substring(0, secString.length() - 1) + Character.toUpperCase(lastCharOfSecString);
          } else {
              secString = secString.substring(0, secString.length() - 1) + lastCharOfSecString;
          }

          String result = firstString + secString;
          System.out.println("Resulting String: " + result);

          System.exit(0);
      }
  }
// #+end_src
// 
// #+RESULTS:
// 
// #+begin_src sh
//   java thaopech.insee.lab2.SimpleStringManipulator Apple banana
// #+end_src
// 
// #+RESULTS:
// | First     | String: | Apple       |
// | Second    | String: | banana      |
// | Resulting | String: | Applebanana |
// 
// #+begin_src sh
//   java thaopech.insee.lab2.SimpleStringManipulator bat man
// #+end_src
// 
// #+RESULTS:
// | First     | String: | bat    |
// | Second    | String: | man    |
// | Resulting | String: | batmaN |
// 
// #+begin_src sh
//   java thaopech.insee.lab2.SimpleStringManipulator apple orange
// #+end_src
// 
// #+RESULTS:
// | First     | String: | apple       |
// | Second    | String: | orange      |
// | Resulting | String: | Appleorange |
