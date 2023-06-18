import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class task29 {
    public static void main(String[] args) {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();

        // заполнение списка случайными числами от 1 до 100
        for (int i = 0; i < 100; i++) {
            list.add(rand.nextInt(100) + 1);
        }

        System.out.println("До сортировки: ");
        for (int i = 0; i < 100; i++) {
            // System.out.print чтобы числа были на одной строчке
            System.out.print(list.get(i) + " ");
        }

        // сортировка списка по убыванию
        Collections.sort(list, Collections.reverseOrder());

        System.out.println("\nПосле сортировки: ");
        // вывод первых 10 значений списка
        for (int i = 0; i < 10; i++) {
            System.out.print(list.get(i) + " ");
        }
    }
}