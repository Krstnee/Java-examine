public class task20 {
    public static int round(double number) {
        if (number < 0) {
            return (int) (number - 0.5);
        } else {
            return (int) (number + 0.5);
        }
    }

    public static int abs(int number) {
        if (number < 0) {
            return -number;
        } else {
            return number;
        }
    }

    public static int pow(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Отрицательные показатели степени не поддерживаются");
        }

        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }

    public static void main(String[] args) {
        double number = 3.7;
        int rounded = task20.round(number);
        System.out.println("Округленное значение " + number + ": " + rounded);

        int negativeNumber = -5;
        int absolute = task20.abs(negativeNumber);
        System.out.println("Модуль числа " + negativeNumber + ": " + absolute);

        int base = 2;
        int exponent = 3;
        int power = task20.pow(base, exponent);
        System.out.println(base + " в степени " + exponent + ": " + power);
    }
}
