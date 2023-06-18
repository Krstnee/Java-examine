import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class task36 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер файла: ");
        String fileName = scanner.nextLine();

        System.out.print("Введите операцию (+, *, -): ");
        String operation = scanner.nextLine();

        Path filePath = Paths.get(fileName + ".txt");

        try {
            double result = processFile(filePath, operation);
            System.out.println("Результат: " + result);

            File outFile = new File(fileName + "_out.txt");
            FileWriter writer = new FileWriter(outFile);
            writer.write(Double.toString(result));
            writer.close();

            System.out.printf("Результат сохранен в файле: %s%n", outFile.getName());

        } catch (IOException e) {
            System.err.println("Ошибка при обработке файла: " + e.getMessage());
        }
    }

    private static double processFile(Path filePath, String operation) throws IOException {
        double a;
        double b;

        try (Scanner scanner = new Scanner(filePath)) {
            a = scanner.nextDouble();
            b = scanner.nextDouble();
        }

        switch (operation) {
            case "+":
                return a + b;
            case "*":
                return a * b;
            case "-":
                return a - b;
            default:
                throw new IllegalArgumentException("Некорректная операция: " + operation);
        }
    }
}