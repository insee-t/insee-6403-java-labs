package thaopech.insee.lab5;

import java.util.*;

interface MatrixFiller {
    public void fill(int row, int col);
}

/**
 * A program that helps you work with matrices in two main phases:
 * 1. Matrix Creation Phase - where you create your initial matrix
 * 2. Matrix Operations Phase - where you perform various calculations on your
 * matrix
 *
 * @author Insee Thaopech
 * @version 1.0
 */
public class MatrixOperations {
    private static int[][] matrix;
    private static int rows;
    private static int columns;
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_RANDOM_VALUE = 10;

    public static void displayCreationMenu() {
        System.out.println("Matrix Creation Menu:");
        System.out.println("1. User Input Matrix");
        System.out.println("2. Random Matrix (0-9)");
        System.out.println("3. All Zeros Matrix");
        System.out.println("4. All Ones Matrix");
        System.out.println("5. Diagonal Matrix");

        System.out.print("Enter your choice: ");
    }

    public static void createMatrix(int choice) {
        if (choice == 1) {
            createCustomMatrix();
            return;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                switch (choice) {
                case 2:
                    matrix[row][col] = (int)(Math.random() * MAX_RANDOM_VALUE);
                    break;
                case 3:
                    // Matrix already initialized with zeros
                    break;
                case 4:
                    matrix[row][col] = 1;
                    break;
                case 5:
                    matrix[row][col] = (row == col) ? 1 : 0;
                    break;
                default:
                    throw new IllegalArgumentException("Error:Invalid choice");
                }
            }
        }
    }

    public static void createCustomMatrix() {
        System.out.println("Enter matrix elements:");
        scanner.nextLine();
        for (int row = 0; row < rows; row++) {
            boolean validInput = false;
            while (!validInput) {
                try {
                    String line = scanner.nextLine();  // Read the entire line for the row
                    String[] elements = line.split("\\s+");  // Split by spaces

                    if (elements.length != columns) {
                        System.err.println(String.format("Error: Please enter exactly %d elements for the row.", columns));
                        continue;
                    }

                    // Convert each element to an integer and fill the matrix
                    for (int index = 0; index < columns; index++) {
                        matrix[row][index] = Integer.parseInt(elements[index]);
                    }
                    validInput = true;
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input. Please enter valid integers.");
                }
            }
        }
    }

    public static void createDiagonalMatrix() {
        createMatrix(5);
    }

    public static int findMaxElementLength() {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int elem : row) {
                max = Math.max(max, Integer.toString(elem).length());
            }
        }
        return max;
    }

    public static void displayMatrix(int[][] matrix) {
        int maxElementLength = findMaxElementLength();
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(String.format("%" + (maxElementLength + 2) + "d", elem));
            }
            System.out.println();
        }
    }

    public static void displayOperationsMenu() {
        System.out.println("\nMatrix Operations Menu:");
        System.out.println("1. Find Transpose of the Matrix");
        System.out.println("2. Calculate Sum of Rows and Columns");
        System.out.println("3. Find Minimum and Maximum Elements");
        System.out.println("4. Display Diagonal Elements");
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
    }

    public static void transposeMatrix() {
        int[][] transposedMatrix = new int[columns][rows];

        for (int transposedMatrixRow = 0; transposedMatrixRow < columns; transposedMatrixRow++) {
            for (int transposedMatrixCol = 0; transposedMatrixCol < rows; transposedMatrixCol++) {
                transposedMatrix[transposedMatrixRow][transposedMatrixCol]
                    = matrix[transposedMatrixCol][transposedMatrixRow];
            }
        }
        displayMatrix(transposedMatrix);
    }

    public static void calculateSums() {
        int sum;
        for (int row = 0; row < rows; row++) {
            sum = 0;
            for (int elem : matrix[row]) {
                sum += elem;
            }
            System.out.println(String.format("Row %d sum: %d", row + 1, sum));
        }

        System.out.println();

        for (int col = 0; col < columns; col++) {
            sum = 0;
            for (int row = 0; row < rows; row++) {
                sum += matrix[row][col];
            }
            System.out.println(String.format("Column %d sum: %d", col + 1, sum));
        }
    }

    public static void findMinMax() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int elem : row) {
                min = Math.min(min, elem);
                max = Math.max(max, elem);
            }
        }
        System.out.println("Minimum element: " + min);
        System.out.println("Maximum element: " + max);
    }

    public static void displayDiagonal() {
        if (rows != columns) {
            System.err.println("Matrix is not square. Cannot display diagonal elements");
            return;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (row == col) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        boolean continueProgram = true;
        while (continueProgram) {
            displayCreationMenu();
            int choice = scanner.nextInt();
            if (choice >= 1 && choice <= 4) {
                // For options 1-4, get matrix dimensions
                System.out.print("Enter number of rows: ");
                rows = scanner.nextInt();
                System.out.print("Enter number of columns: ");
                columns = scanner.nextInt();

                if (rows <= 0 || columns <= 0) {
                    System.out.println("Error: Dimensions must be greater than 0");
                    continue;
                }

                matrix = new int[rows][columns];
                createMatrix(choice);
            } else if (choice == 5) {
                // Diagonal matrix must be square
                System.out.print("Enter size of square matrix: ");
                rows = columns = scanner.nextInt();

                if (rows <= 0) {
                    System.out.println("Error: Size must be greater than 0");
                    continue;
                }

                matrix = new int[rows][rows];
                createDiagonalMatrix();
            } else {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            System.out.println("\nCreated Matrix:");
            displayMatrix(matrix);

            // Operations menu loop
            boolean continueOperations = true;
            while (continueOperations) {
                displayOperationsMenu();
                int operation = scanner.nextInt();

                switch (operation) {
                    case 1:
                        transposeMatrix();
                        break;
                    case 2:
                        calculateSums();
                        break;
                    case 3:
                        findMinMax();
                        break;
                    case 4:
                        displayDiagonal();
                        break;
                    case 5:
                        continueOperations = false;
                        continueProgram = false;
                        break;
                    default:
                        System.out.println("Invalid operation choice.");
                }
            }
        }
        scanner.close();
    }
}
