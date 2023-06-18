import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Zad40 {
    public static void main(String[] args) {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        long startTime = System.currentTimeMillis();

        // Поток, отображающий данные о времени каждые 5 секунд
        executor.scheduleAtFixedRate(() -> {
            long currentTime = System.currentTimeMillis();
            long elapsedTime = (currentTime - startTime) / 1000; // Время в секундах
            System.out.println("Прошло " + elapsedTime + " секунд");
        }, 0, 5, TimeUnit.SECONDS);

        // Поток, выводящий сообщение каждые 7 секунд
        executor.scheduleAtFixedRate(() -> {
            System.out.println("Сообщение каждые 7 секунд");
        }, 0, 7, TimeUnit.SECONDS);

        // Поток, выводящий сообщение каждые 10 секунд
        executor.scheduleAtFixedRate(() -> {
            System.out.println("Сообщение каждые 10 секунд");
        }, 0, 10, TimeUnit.SECONDS);

        // Остановка программы через 1 минуту
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Остановка всех потоков и завершение программы
        executor.shutdown();
    }
}
