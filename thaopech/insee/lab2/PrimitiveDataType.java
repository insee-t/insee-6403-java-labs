// #+title: The PrimitiveDataType Program
// #+author: Insee thaopech
// #+id: 673040640-3
// #+sec: 2
// #+last_updated: 2024 Nov 29
// 
//  This program input student ID and name then processes and output the following.
// 
//  Student ID : <studentNum>
//  First Name : <firstName>
//  Byte Value: number of letter in first name.
//  Int Value: last six digits of student ID.
//  Long Value: student ID without dashes or spaces.
//  Float Value: myByte / 100.
//  Double Value: last four digits of student ID / 10000.
//  Boolean Value: is last digits of student ID odd or not?
// 
// 
// #+begin_src java

  package thaopech.insee.lab2;


  public class PrimitiveDataType {

      public static void main(String[] args) {

          String studentNum = args[0];
          String firstName = args[1];
          byte myByte = (byte)args[1].length();
          short myShort = (short)((short)myByte * (short)21);
          String studentNumWithOutSpecial = studentNum.replaceAll("-", "").replace(" ", "");
          long myLong = Long.parseLong(studentNumWithOutSpecial);

          // Get last 6 digits
          int myInt = (int)(myLong % 10000000);
          float myFloat = (float)((float)myByte / 100);
          double myDouble = (double)((double)(myLong % 10000) / 10000);
          char myChar = firstName.charAt(0);
          int lastDig = myInt % 10;
          boolean myBoolean = (myInt & 1) != 0;
        
          System.out.println("Student ID: " + studentNum);
          System.out.println("First Name: " + firstName);
          System.out.println("Byte Value: " + myByte);
          System.out.println("Short Value: " + myShort);
          System.out.println("Int Value: " + myInt);
          System.out.println("Long Value: " + myLong);
          System.out.println("Float Value: " + myFloat);
          System.out.println("Double Value: " + myDouble);
          System.out.println("Char Value: " + myChar);
          System.out.println("Boolean Value: " + myBoolean);

          System.exit(0);
      }    
  }
// #+end_src
// 
// #+RESULTS:
// 
// #+begin_src sh
//   java thaopech.insee.lab2.PrimitiveDataType 673040640-3 Insee
// #+end_src
// 
// #+RESULTS:
// | Student | ID:    | 673040640-3 |
// | First   | Name:  |       Insee |
// | Byte    | Value: |           5 |
// | Short   | Value: |         105 |
// | Int     | Value: |      406403 |
// | Long    | Value: |  6730406403 |
// | Float   | Value: |        0.05 |
// | Double  | Value: |      0.6403 |
// | Char    | Value: |           I |
// | Boolean | Value: |        true |
