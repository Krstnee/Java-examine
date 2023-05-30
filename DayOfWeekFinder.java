package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DayOfWeekFinder {
    public static void main(String[] args) {
        // Создаем объект типа Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя ввод даты
        System.out.print("Введите дату в формате (гггг-мм-дд): ");
        String dateString = scanner.nextLine();

        try {
            // Преобразуем строку с датой в объект типа Date
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date = sdf.parse(dateString);

            // Создаем объект типа Calendar и устанавливаем заданную дату
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);

            // Получаем номер дня недели (1 - воскресенье, 2 - понедельник, и т.д.)
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            // Определяем название дня недели
            String dayOfWeekName;
            switch (dayOfWeek) {
                case Calendar.SUNDAY:
                    dayOfWeekName = "Воскресенье";
                    break;
                case Calendar.MONDAY:
                    dayOfWeekName = "Понедельник";
                    break;
                case Calendar.TUESDAY:
                    dayOfWeekName = "Вторник";
                    break;
                case Calendar.WEDNESDAY:
                    dayOfWeekName = "Среда";
                    break;
                case Calendar.THURSDAY:
                    dayOfWeekName = "Четверг";
                    break;
                case Calendar.FRIDAY:
                    dayOfWeekName = "Пятница";
                    break;
                case Calendar.SATURDAY:
                    dayOfWeekName = "Суббота";
                    break;
                default:
                    dayOfWeekName = "Ошибка: недопустимый день недели";
            }

            // Выводим результат
            System.out.println("День недели для введенной даты: " + dayOfWeekName);
        } catch (Exception e) {
            System.out.println("Ошибка: неверный формат даты.");
        }

        // Закрываем Scanner
        scanner.close();
    }
}
