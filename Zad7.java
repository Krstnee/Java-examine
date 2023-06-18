import java.util.Scanner;

public class Zad7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Введите слово: ");
            String word = scanner.nextLine();

            for (int i = 0; i < 6; i++) {
                System.out.println(word);
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}
