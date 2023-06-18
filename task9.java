package com.example.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class task9 {
    public static void main(String[] args) {
        // Создаем объект типа Scanner для чтения ввода пользователя
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем у пользователя ввод даты
        System.out.print("enter the date in the format (yyyy-mm-dd): ");
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
                    dayOfWeekName = "sunday";
                    break;
                case Calendar.MONDAY:
                    dayOfWeekName = "monday";
                    break;
                case Calendar.TUESDAY:
                    dayOfWeekName = "TUESDAY";
                    break;
                case Calendar.WEDNESDAY:
                    dayOfWeekName = "WEDNESDAY";
                    break;
                case Calendar.THURSDAY:
                    dayOfWeekName = "THURSDAY";
                    break;
                case Calendar.FRIDAY:
                    dayOfWeekName = "FRIDAY";
                    break;
                case Calendar.SATURDAY:
                    dayOfWeekName = "SATURDAY";
                    break;
                default:
                    dayOfWeekName = "wrong format";
            }

            // Выводим результат
            System.out.println("Day of the week: " + dayOfWeekName);
        } catch (Exception e) {
            System.out.println("wrong format");
        }

        // Закрываем Scanner
        scanner.close();
    }
}
