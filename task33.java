import java.util.Random;
import java.util.Scanner;

public class task33 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите количество строк: ");
            int rows = scanner.nextInt();

            System.out.print("Введите количество столбцов: ");
            int columns = scanner.nextInt();

            int[][] array = generateRandomArray(rows, columns);

            System.out.println("Сгенерированная коллекция:");
            printArray(array);

            int max = array[0][0];
            int min = array[0][0];
            int maxRow = 0;
            int maxColumn = 0;
            int minRow = 0;
            int minColumn = 0;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    int value = array[i][j];
                    if (value > max) {
                        max = value;
                        maxRow = i;
                        maxColumn = j;
                    }
                    if (value < min) {
                        min = value;
                        minRow = i;
                        minColumn = j;
                    }
                }
            }

            System.out.println("Максимальное значение: " + max + " (Индекс: [" + maxRow + "][" + maxColumn + "])");
            System.out.println("Минимальное значение: " + min + " (Индекс: [" + minRow + "][" + minColumn + "])");
        }catch (Exception e) {
            System.out.println("Ошибка: введены некорректные данные.");
        }

    }

    public static int[][] generateRandomArray(int rows, int columns) {
        int[][] array = new int[rows][columns];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = random.nextInt(100);
            }
        }

        return array;
    }

    public static void printArray(int[][] array) {
        int rows = array.length;
        int columns = array[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
