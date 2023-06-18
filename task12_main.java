public class task12_main {
    public static void main(String[] args) {
        task12 a = new task12(5.0);
        task12 b = new task12(2.0);

        task12 sum = task12.add(a, b);
        System.out.println("Сумма: " + sum.getValue());

        task12 quotient = task12.divide(a, b);
        System.out.println("Частное: " + quotient.getValue());

        task12 power = task12.power(a, b);
        System.out.println("Возведение в степень: " + power.getValue());
    }
}
