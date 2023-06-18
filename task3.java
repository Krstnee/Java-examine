import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите натуральное число: ");
            int number = scanner.nextInt();
            extractDigits(number);
        } catch (Exception e) {
            System.out.println("Ошибка ввода: введите корректное натуральное число.");
        }
    }

    public static void extractDigits(int number) {
        try {
            String numberString = String.valueOf(number); // Преобразование числа в строку
            for (int i = 0; i < numberString.length(); i++) {
                char digitChar = numberString.charAt(i); // Получение символа из строки
                int digit = Character.getNumericValue(digitChar); // Преобразование символа в цифру
                System.out.println(digit);
            }
        } catch (Exception e) {
            System.out.println("Ошибка при извлечении цифр из числа.");
        }
    }
}
