import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class task30 {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите длину списка: ");
        while (!sc.hasNextInt()) {
            System.out.println("Некорректный ввод. Введите целое число.");
            sc.next(); // Пропустить некорректный ввод
        }
        int n = sc.nextInt();

        System.out.print("Введите начало диапазона: ");
        while (!sc.hasNextInt()) {
            System.out.println("Некорректный ввод. Введите целое число.");
            sc.next(); // Пропустить некорректный ввод
        }
        int min = sc.nextInt();

        System.out.print("Введите конец диапазона: ");
        while (!sc.hasNextInt()) {
            System.out.println("Некорректный ввод. Введите целое число.");
            sc.next(); // Пропустить некорректный ввод
        }
        int max = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int num = (int) (Math.random() * (max - min + 1) + min);
            numbers.add(num);
        }

        Collections.sort(numbers);

        System.out.print("Введите искомое число: ");
        while (!sc.hasNextInt()) {
            System.out.println("Некорректный ввод. Введите целое число.");
            sc.next(); // Пропустить некорректный ввод
        }
        int target = sc.nextInt();

        int index = binarySearch(numbers, target);
        if (index == -1)
            System.out.println("Заданное число не входит в список.");
        else
            System.out.println("Индекс заданного числа в списке: " + index);

        System.out.println(numbers);

        sc.close();
    }

    public static int binarySearch(List<Integer> numbers, int target) {
        int left = 0, right = numbers.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers.get(mid) == target) {
                return mid;
            } else if (numbers.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}