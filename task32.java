import java.util.Random;
import java.util.Scanner;

public class task32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = 0;
        int columns = 0;

        try {
            System.out.print("Введите количество строк: ");
            rows = scanner.nextInt();

            System.out.print("Введите количество столбцов: ");
            columns = scanner.nextInt();

            int[][] matrix = generateRandomMatrix(rows, columns);

            System.out.println("Сгенерированная матрица:");
            printMatrix(matrix);
        } catch (Exception e) {
            System.out.println("Ошибка: введены некорректные данные.");
        }
    }

    public static int[][] generateRandomMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = random.nextInt(100);
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
