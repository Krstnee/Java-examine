public class task18_main {
    public static void main(String[] args) {
        // Пример создания объекта Binary из десятичного числа
        task18 binary1 = task18.fromDecimal(5, 8);
        System.out.println("Binary1: " + binary1.toString()); // 00000101

        // Пример преобразования Binary в десятичное число
        int decimal1 = binary1.toDecimal();
        System.out.println("Decimal1: " + decimal1); // 5

        // Пример создания объекта Binary из строки
        task18 binary2 = task18.fromString("101010");
        System.out.println("Binary2: " + binary2.toString()); // 101010

        // Пример преобразования Binary в десятичное число
        int decimal2 = binary2.toDecimal();
        System.out.println("Decimal2: " + decimal2); // 42
    }
}
