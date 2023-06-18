package task_15;

import java.util.Scanner;

public class linearFunction extends functionConstructor {
    @Override
    public void calculateFunction() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Работа с функцией вида y = k * x + b");

        System.out.print("Введите значение переменной x ");
        double x = scan.nextDouble();

        System.out.print("Введите значение углового коэффициента k ");
        double k = scan.nextDouble();

        System.out.print("Введите значение свободного коэффициента b ");
        double b = scan.nextDouble();

        double y = x * k + b;

        System.out.println("Значение функции с заданными параметрами в точке x равно " + y);
    }
}
