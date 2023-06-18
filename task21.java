import java.util.Random;
import java.util.Scanner;

public class task21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String playAgain = "да";

        while (playAgain.equalsIgnoreCase("да")) {
            int randomNumber = random.nextInt(10) + 1;
            int tries = 3;

            System.out.println("Угадайте число от 1 до 10. У вас есть 3 попытки.");

            while (tries > 0) {
                System.out.print("Попытка №" + (4 - tries) + ": ");
                // Проверка на ввод целочисленного значения
                while (!scanner.hasNextInt()) {
                    System.out.println("Некорректный ввод. Введите целое число.");
                    scanner.next(); // Пропустить некорректный ввод
                }
                int guess = scanner.nextInt();

                if (guess == randomNumber) {
                    System.out.println("Вы угадали!");
                    break;
                } else {
                    System.out.println("Неправильно. " + (guess < randomNumber ? "Загаданное число больше." : "Загаданное число меньше."));
                }

                tries--;
            }

            if (tries == 0) {
                System.out.println("Извините, вы исчерпали все попытки. Загаданное число было: " + randomNumber);
            }

            System.out.print("Сыграем еще раз? (да/нет): ");
            // Проверка на ввод "да" или "нет"
            while (true) {
                String input = scanner.next();
                if (input.equalsIgnoreCase("да") || input.equalsIgnoreCase("нет")) {
                    playAgain = input;
                    break;
                } else {
                    System.out.println("Некорректный ввод. Введите 'да' или 'нет'.");
                }
            }
        }
    }
}