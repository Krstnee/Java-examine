import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Zad22 {
    public static void main(String[] args) {
        try {
            LocalDate currentDate = LocalDate.now();
            int year = 2022;
            Month month = currentDate.getMonth();

            // Получение списка рабочих дней в указанном месяце
            List<LocalDate> workDays = getWorkDays(year, month);

            // Вывод расписания
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            System.out.println("Рабочий календарь на " + month.toString() + " " + year + ":");

            for (LocalDate workDay : workDays) {
                System.out.println(workDay.format(formatter));
            }
        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }

    // Метод для получения списка рабочих дней в указанном месяце
    private static List<LocalDate> getWorkDays(int year, Month month) {
        List<LocalDate> workDays = new ArrayList<>();
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());

        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            if (currentDate.getDayOfWeek() != DayOfWeek.SUNDAY) {
                workDays.add(currentDate);
            }
            currentDate = currentDate.plusDays(1);
        }

        // Перенос смены на понедельник, если она попадает на воскресенье
        for (int i = 0; i < workDays.size(); i += 3) {
            if (workDays.get(i).getDayOfWeek() == DayOfWeek.SUNDAY) {
                workDays.remove(i);
                workDays.add(i + 1, workDays.get(i).plusDays(1));
            }
        }

        return workDays;
    }
}
