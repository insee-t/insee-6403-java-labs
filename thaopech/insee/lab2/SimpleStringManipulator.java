// #+title: The SimpleStringManipulator Program
// #+author: Insee thaopech
// #+id : 673040640-3
// #+sec : 2
// #+last_updated: 2024 Dec 6
// 
// This program accepts two arguments and performs simple manipulations.
// 
// ** First String Processing:
// - If the first string starts with a vowel (a, e, i, o, u, case-insensitive), convert the first character to uppercase.
// - Else, convert the first character to lowercase.
// 
// ** Second String Processing:
// - If the second string ends with a consonant (any letter that's not a vowel, case-insensitive), convert the last character to uppercase.
// - Else, convert the last character to lowercase.
// 
// ** Result String:
// - Concatenate the modified first string and the modified second string.
// 
// * The output should be
// 
// : First String: <firstString>
// : Second String: <secString>
// : Resultng Sting: <result>
// 
// #+begin_src java

  package thaopech.insee.lab2;


  public class SimpleStringManipulator {

      public static boolean isVowel(char c) {
        char lowerChar = Character.toLowerCase(c);
        return lowerChar == 'a' || lowerChar == 'e' || lowerChar == 'i' || lowerChar == 'o' || lowerChar == 'u';
    }

      public static String firstStringProcess(String firstString, char firstChar) {

          if (isVowel(firstChar)) {

              // Prepend uppercase version of first character.
          return firstString = Character.toUpperCase(firstChar) + firstString.substring(1);
          }
          // Prepend lowercase version of first character.
          return firstString = firstChar + firstString.substring(1);
      }

      public static String secStringProcess(String secString, char lastChar) {

          if (!isVowel(lastChar)) {
              // Append uppercase version of last character.
              return secString.substring(0, secString.length() - 1) + Character.toUpperCase(lastChar);
          }
          // Append lowercase version of first character.
          return secString.substring(0, secString.length() - 1) + lastChar;
      }

      public static void main(String[] args) {

          // Check if number of arguments is valid.
          if (args.length != 2) {
              System.err.println("Invalid number of arguments. Please provide exactly two strings as arguments.");
              return;
          }

          String firstString = args[0];
          String secString = args[1];

          // Get first character from first string and convert to lowercase.
          char firstCharOfFirstString = Character.toLowerCase(firstString.charAt(0));

          // Get last character from second string and covert to lowercase.
          char lastCharOfSecString = Character.toLowerCase(secString.charAt(secString.length() - 1));

          System.out.println("First String: " + firstString);
          System.out.println("Second String: " + secString);
          // Process first and second string.
          firstString = firstStringProcess(firstString, firstCharOfFirstString);
          secString = secStringProcess(secString, lastCharOfSecString);

          // Output
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
