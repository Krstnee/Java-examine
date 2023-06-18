import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Zad37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите число для логарифма:");
        double number = scanner.nextDouble();

        System.out.println("Введите основание логарифма:");
        double base = scanner.nextDouble();

        // Проверка основания логарифма
        if (base <= 0 || base == 1) {
            System.out.println("Основание логарифма должно быть положительным и не равным 1.");
            return;
        }
        

        System.out.println("Выберите действие:");
        System.out.println("1. Сложение");
        System.out.println("2. Вычитание");
        System.out.println("3. Умножение");
        System.out.println("4. Деление");
        System.out.println("5. Возведение в степень");
        int choice = scanner.nextInt();

        double result = 0;
        String operation = "";

        switch (choice) {
            case 1:
                operation = "сложения";
                result = Math.log(number) + Math.log(base);
                break;
            case 2:
                operation = "вычитания";
                result = Math.log(number) - Math.log(base);
                break;
            case 3:
                operation = "умножения";
                result = Math.log(number) * Math.log(base);
                break;
            case 4:
                operation = "деления";
                result = Math.log(number) / Math.log(base);
                break;
            case 5:
                operation = "возведения в степень";
                result = Math.pow(Math.log(number), Math.log(base));
                break;
            default:
                System.out.println("Неверный выбор операции.");
                return;
        }

        System.out.println("Результат " + operation + ": " + result);

        // Запись результата в файл
        try {
            File file = new File("result.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("Результат " + operation + ": " + result);
            writer.close();
            System.out.println("Результат успешно записан в файл result.txt.");
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл.");
            e.printStackTrace();
        }

        scanner.close();
    }
}
