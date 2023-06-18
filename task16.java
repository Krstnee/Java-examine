// Интерфейс Progress
interface Progress {
    double getElement(int n); // Метод для вычисления n-го элемента прогрессии
    double getSum(int n); // Метод для вычисления суммы первых n элементов прогрессии
}

// Класс арифметической прогрессии
class ArithmeticProgression implements Progress {
    private double a; // Первый член прогрессии
    private double d; // Разность прогрессии

    public ArithmeticProgression(double a, double d) {
        this.a = a;
        this.d = d;
    }

    public double getElement(int n) {
        return a + (n - 1) * d;
    }

    public double getSum(int n) {
        return (n / 2.0) * (2 * a + (n - 1) * d);
    }
}

// Класс геометрической прогрессии
class GeometricProgression implements Progress {
    private double a; // Первый член прогрессии
    private double r; // Знаменатель прогрессии

    public GeometricProgression(double a, double r) {
        this.a = a;
        this.r = r;
    }

    public double getElement(int n) {
        return a * Math.pow(r, n - 1);
    }

    public double getSum(int n) {
        if (r == 1) {
            return a * n;
        } else {
            return a * (Math.pow(r, n) - 1) / (r - 1);
        }
    }
}

// Пример использования классов
public class task16 {
    public static void main(String[] args) {
        ArithmeticProgression arithmeticProgression = new ArithmeticProgression(2, 3);
        System.out.println("Арифметическая прогрессия:");
        System.out.println("Элемент 5: " + arithmeticProgression.getElement(5));
        System.out.println("Сумма первых 5 элементов: " + arithmeticProgression.getSum(5));

        GeometricProgression geometricProgression = new GeometricProgression(2, 3);
        System.out.println("Геометрическая прогрессия:");
        System.out.println("Элемент 5: " + geometricProgression.getElement(5));
        System.out.println("Сумма первых 5 элементов: " + geometricProgression.getSum(5));
    }
}
