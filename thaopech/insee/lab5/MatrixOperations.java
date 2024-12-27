package thaopech.insee.lab5;

import java.util.*;

/**
 * The MatrixOperations class provides functionality to create and perform various operations on matrices.
 * It allows users to create matrices through custom input, random generation, or predefined types like zero or one matrices.
 * Additionally, users can perform operations like transposing the matrix, calculating row and column sums,
 * finding the minimum and maximum elements, and displaying the diagonal elements.
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

    /**
     * Displays the matrix creation menu options to the user.
     */
    public static void displayCreationMenu() {
        System.out.println("Matrix Creation Menu:");
        System.out.println("1. User Input Matrix");
        System.out.println("2. Random Matrix (0-9)");
        System.out.println("3. All Zeros Matrix");
        System.out.println("4. All Ones Matrix");
        System.out.println("5. Diagonal Matrix");

        System.out.print("Enter your choice: ");
    }

    /**
     * Creates a matrix based on the user's choice.
     *
     * @param choice The choice selected by the user for creating the matrix:
     *               1 - Custom matrix via user input,
     *               2 - Random matrix with values between 0 and 9,
     *               3 - Matrix filled with zeros,
     *               4 - Matrix filled with ones,
     *               5 - Diagonal matrix.
     *
     * @throws IllegalArgumentException if an invalid choice is provided.
     */
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
                    throw new IllegalArgumentException("Error: Invalid choice");
                }
            }
        }
    }

    /**
     * Prompts the user to enter values for a custom matrix.
     * The user must provide the matrix elements for each row.
     */
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

    /**
     * Creates a diagonal matrix with ones on the diagonal and zeros elsewhere.
     */
    public static void createDiagonalMatrix() {
        createMatrix(5);
    }

    /**
     * Displays the matrix to the user. Each element is printed with a width of 2 characters for alignment.
     * The method ensures the matrix is displayed in a clear, tabular format.
     *
     * @param matrix The matrix to be displayed.
     */
    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int elem : row) {
                System.out.print(String.format("%3d", elem));
            }
            System.out.println();
        }
    }

    /**
     * Displays the operations menu for matrix operations.
     */
    public static void displayOperationsMenu() {
        System.out.println("\nMatrix Operations Menu:");
        System.out.println("1. Find Transpose of the Matrix");
        System.out.println("2. Calculate Sum of Rows and Columns");
        System.out.println("3. Find Minimum and Maximum Elements");
        System.out.println("4. Display Diagonal Elements");
        System.out.println("5. Exit");

        System.out.print("Enter your choice: ");
    }

    /**
     * Transposes the matrix and displays the transposed version.
     */
    public static void transposeMatrix() {
        int[][] transposedMatrix = new int[columns][rows];

        for (int transposedMatrixRow = 0; transposedMatrixRow < columns; transposedMatrixRow++) {
            for (int transposedMatrixCol = 0; transposedMatrixCol < rows; transposedMatrixCol++) {
                transposedMatrix[transposedMatrixRow][transposedMatrixCol]
                    = matrix[transposedMatrixCol][transposedMatrixRow];
            }
        }
        System.out.println("Transposed Matrix:");
        displayMatrix(transposedMatrix);
    }

    /**
     * Calculates and displays the sum of each row and each column in the matrix.
     */
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

    /**
     * Finds and displays the minimum and maximum elements in the matrix.
     */
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

    /**
     * Displays the diagonal elements of the matrix if it is square (rows == columns).
     *
     * If the matrix is not square, an error message is displayed.
     */
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

    /**
     * The main method for executing the program.
     * It provides the user with options for matrix creation and operations.
     *
     * @param args Command-line arguments (not used in this program).
     */
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
                System.out.println();

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
