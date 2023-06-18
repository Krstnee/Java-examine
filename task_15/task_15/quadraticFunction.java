package task_15;

import java.util.Scanner;

public class quadraticFunction extends functionConstructor {
    @Override
    public void calculateFunction() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Работа с функцией вида y = a * x ^ 2 + b * x + c");

        System.out.print("Введите значение переменной x ");
        double x = scan.nextDouble();

        System.out.print("Введите значение старшего коэффициента a ");
        double a = scan.nextDouble();
        while (a == 0) {
            System.out.println("Старший коэффициент не может равняться 0");
            System.out.print("Введите значение старшего коэффициента a ");
            a = scan.nextDouble();
        }

        System.out.print("Введите значение второго коэффициента b ");
        double b = scan.nextDouble();

        System.out.print("Введите значение свободного коэффициента c ");
        double c = scan.nextDouble();

        scan.close();

        double y = a * Math.pow(x, 2) + b * x + c;

        System.out.print("Значение функции с заданными параметрами в точке x равно " + y);
    }
}
