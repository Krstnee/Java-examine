import java.util.Scanner;

public class task11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите число: ");
            int number = scanner.nextInt();

            if (number < 0) {
                throw new IllegalArgumentException("Число должно быть неотрицательным");
            }

            long factorial = calculateFactorial(number);
            System.out.println("Факториал числа " + number + " = " + factorial);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Произошла ошибка при вводе числа");
        } finally {
            scanner.close();
        }
    }

    public static long calculateFactorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * calculateFactorial(number - 1);
        }
    }
}
