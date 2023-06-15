package com.example.demo;

import java.util.Scanner;
public class GCDBasic {
    public static int findGCD(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int number1 = scanner.nextInt();

        System.out.print("Введите второе число: ");
        int number2 = scanner.nextInt();

        int gcd = findGCD(number1, number2);
        System.out.println("НОД чисел " + number1 + " и " + number2 + " равен: " + gcd);

        scanner.close();
    }
}
