
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Zad37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите операцию:");
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");
        System.out.println("5. Возведение в степень");
        System.out.println("6. Логарифм");

        int choice = scanner.nextInt();
        double result = 0.0;

        switch (choice) {
            case 1:
                result = performAddition(scanner);
                break;
            case 2:
                result = performSubtraction(scanner);
                break;
            case 3:
                result = performMultiplication(scanner);
                break;
            case 4:
                result = performDivision(scanner);
                break;
            case 5:
                result = performPower(scanner);
                break;
            case 6:
                result = performLogarithm(scanner);
                break;
            default:
                System.out.println("Ошибка: Неправильный выбор операции.");
                return;
        }

        System.out.println("Результат: " + result);

        // Запись результата в файл
        try {
            FileWriter fileWriter = new FileWriter("result.txt");
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println("Результат: " + result);
            printWriter.close();
            System.out.println("Результат записан в файл result.txt");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл.");
            e.printStackTrace();
        }
    }

    // Метод для выполнения операции сложения
    private static double performAddition(Scanner scanner) {
        System.out.print("Введите первое число: ");
        double num1 = scanner.nextDouble();
        System.out.print("Введите второе число: ");
        double num2 = scanner.nextDouble();
        return num1 + num2;
    }

    // Метод для выполнения операции вычитания
    private static double performSubtraction(Scanner scanner) {
        System.out.print("Введите первое число: ");
        double num1 = scanner.nextDouble();
        System.out.print("Введите второе число: ");
        double num2 = scanner.nextDouble();
        return num1 - num2;
    }

    // Метод для выполнения операции умножения
    private static double performMultiplication(Scanner scanner) {
        System.out.print("Введите первое число: ");
        double num1 = scanner.nextDouble();
        System.out.print("Введите второе число: ");
        double num2 = scanner.nextDouble();
        return num1 * num2;
    }

    // Метод для выполнения операции деления
    private static double performDivision(Scanner scanner) {
        System.out.print("Введите делимое: ");
        double dividend = scanner.nextDouble();
        System.out.print("Введите делитель: ");
        double divisor = scanner.nextDouble();

        if (divisor == 0) {
            System.out.println("Ошибка: Деление на ноль.");
            return 0.0;
        }

        return dividend / divisor;
    }

    // Метод для выполнения операции возведения в степень
    private static double performPower(Scanner scanner) {
        System.out.print("Введите число: ");
        double base = scanner.nextDouble();
        System.out.print("Введите степень: ");
        double exponent = scanner.nextDouble();
        return Math.pow(base, exponent);
    }

    // Метод для выполнения операции логарифма
    private static double performLogarithm(Scanner scanner) {
        System.out.print("Введите число: ");
        double number = scanner.nextDouble();

        if (number <= 0) {
            System.out.println("Ошибка: Логарифм от неположительного числа или нуля.");
            return 0.0;
        }

        return Math.log(number);
    }
}
