import java.util.Random;
import java.util.Scanner;

public class task13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите размер матрицы: ");

        try {
            int n = scanner.nextInt();

            if (n <= 0) {
                throw new IllegalArgumentException("Размер матрицы должен быть положительным числом");
            }

            int[][] matrix = new int[n][n];
            Random random = new Random();

            // Заполнение матрицы случайными числами
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = random.nextInt(100) + 1;
                }
            }

            // Поиск суммы граничных элементов
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += matrix[0][i]; // Верхняя строка
                sum += matrix[n-1][i]; // Нижняя строка
                if (i > 0 && i < n-1) {
                    sum += matrix[i][0]; // Левый столбец
                    sum += matrix[i][n-1]; // Правый столбец
                }
            }

            // Пока сумма граничных элементов не станет равной 666,
            // продолжаем заполнять матрицу случайными числами
            while (sum != 666) {
                int i = random.nextInt(n);
                int j = random.nextInt(n);
                int value = random.nextInt(100) + 1;
                if (matrix[i][j] != value) {
                    if (i == 0 || i == n-1 || j == 0 || j == n-1) {
                        sum -= matrix[i][j];
                        matrix[i][j] = value;
                        sum += value;
                    } else {
                        matrix[i][j] = value;
                    }
                }
            }

            // Вывод матрицы на экран
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка при вводе размера матрицы");
        } finally {
            scanner.close();
        }
    }
}
