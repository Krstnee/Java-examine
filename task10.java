import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.Locale;
import java.util.Scanner;

public class task10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите дату в формате ДД.ММ.ГГ: ");
        String inputDate = scanner.nextLine();

        try {
            int weekNumber = getWeekNumber(inputDate);
            System.out.println("Неделя " + weekNumber);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static int getWeekNumber(String inputDate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy");
            LocalDate date = LocalDate.parse(inputDate, formatter);
            WeekFields weekFields = WeekFields.of(Locale.getDefault());
            int weekNumber = date.get(weekFields.weekOfWeekBasedYear());
            return weekNumber;
        } catch (Exception e) {
            throw new IllegalArgumentException("Неверный формат даты");
        }
    }
}
