package thaopech.insee.lab5;

import java.util.*;

/**
 * Implements various recursive methods for array and number operations. Demostrates the use of recursion for solving problmes.
 */
public class RecursiveMethods {
    /**
     * Recursively finds the sum of digits in a number.
     * Example: For the number 123, the answer is 1+2+3 = 6
     * @param number the input number
     * @return sum of digits
     */
    public static int sumOfDigits(int number) {
        int sum = 0;
        if (number == 0) {
            return 0;
        }
        sum += number % 10;
        sum += sumOfDigits(number / 10);
        return sum;
    }

    /**
     * Swap two elemets in array.
     * @param arr the array of elements to swap
     * @param first first elements to swap
     * @param second second elements to swap
     */
    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
        return;
    }

    /**
     * Recursively reverses an array between start and end indices.
     * @param arr the array to reverse
     * @param start starting index
     * @param end ending index
     */
    public static void reverseArray(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        swap(arr, start, end);
        reverseArray(arr, start + 1, end - 1);
    }

    /**
     * Recursively checks if an array is palindrome.
     * @param arr the array to check
     * @param start starting index
     * @param end ending index
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(int[] arr, int start, int end) {
        if (start > end) {
            return true;
        }
        if (arr[start] != arr[end]) {
            return false;
        }
        return isPalindrome(arr, start+ 1, end - 1);
    }

    /**
     * Print elements in array.
     * @param arr the array to print
     */
    public static void printArray(int[] arr) {
        for (int elem: arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Demonstrate each recursive method with example inputs
        int number1 = 45;
        int number2 = 12345;
        System.out.println(String.format("Sum of digits in %d: %d", number1, sumOfDigits(number1)));
        System.out.println(String.format("Sum of digits in %d: %d\n", number2, sumOfDigits(number2)));

        int[] array = {1, 2, 3, 4, 5};

        System.out.println("Original array:");
        printArray(array);

        reverseArray(array , 0, 4);

        System.out.println("Reversed array:");
        printArray(array);

        int[] palindromeNum = {1, 2, 3, 2, 1};
        int[] notPalindromeNum = {1, 2, 1, 2};
        System.out.println("\nTesting palindrome:");
        printArray(palindromeNum);
        System.out.println("Is palindrome: " + isPalindrome(palindromeNum, 0, palindromeNum.length - 1));

        System.out.println("\nTesting palindrome:");
        printArray(notPalindromeNum);
        System.out.println("Is palindrome: " + isPalindrome(notPalindromeNum, 0, notPalindromeNum.length - 1));
    }

}
