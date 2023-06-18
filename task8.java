public class task8 {
    public static void main(String[] args) {
        int count = 10; // Количество чисел для вывода
        try {
            printCubes(count);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static void printCubes(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("Количество должно быть положительным числом");
        }

        for (int i = 1; i <= count; i++) {
            int cube = i * i * i;
            System.out.println("Куб числа " + i + ": " + cube);
        }
    }
}
