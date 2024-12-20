package thaopech.insee.lab5;

import java.util.*;

/**
 * A utility class that provides methods for analyzing arrays of numbers.
 * @author Insee Thaopech
 * @version 1.0
 */
public class NumberAnalyzer {
    /**
     * Finds both the minimum and maximum values in an array.
     * @param numbers the array to analyze
     * @return an array of two elements where index 0 is minimum and index 1 is maximum
     */
    public static int[] findMinMax(int[] numbers) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (var number: numbers) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }

        return new int[] {min, max};
    }

    /**
     * Calculates the running average of numbers up to each position.
     * For example: input [1,2,3] returns [1.0, 1.5, 2.0]
     * @param numbers the input array
     * @return array of running averages
     */
    public static double[] calculateRunningAverages(int[] numbers) {
        double sum = 0;
        double[] result = new double[numbers.length];

        for (int index = 0; index < numbers.length; index++) {
            sum += numbers[index];
            result[index] = sum / (index + 1);
        }

        return result;
    }

    /**
     * Checks if the array is sorted in ascending order.
     * @param numbers the array to check
     * @return true if sorted, false otherwise
     */
    public static boolean isSorted(int[] numbers) {
        int prev = numbers[0];
        for (int number : numbers) {
            if (number < prev) {
                return false;
            }
            prev = number;
        }
        return true;
    }

    public static void printArray(int[] arr) {
        for (int elem: arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers1 = {4, 2, 7, 1, 9};
        String numbers1String = Arrays.toString(numbers1);
        String numbers1Formatted = "{" + numbers1String.substring(1, numbers1String.length() - 1) + "}";
        System.out.println("Testing with array: " + numbers1Formatted);


        int[] minMax = findMinMax(numbers1);

        System.out.println("Minimum value: " + minMax[0]);
        System.out.println("Maximum value: " + minMax[1]);

        System.out.println("\nRunning averages:");
        double[] runningAvg = calculateRunningAverages(numbers1);
        for (int index = 0; index < numbers1.length; index++) {
            System.out.println(String.format("Position %d: %.2f", index, runningAvg[index]));
        }

        System.out.println("\nTesting if arrays are sorted:");
        printArray(numbers1);
        System.out.println("numbers1 is sorted: " + isSorted(numbers1));

        int[] number2 = {1, 2, 3, 4, 5};
        printArray(number2);
        System.out.println("numbers2 is sorted: " + isSorted(number2));
    }
}
