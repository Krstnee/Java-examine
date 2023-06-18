import java.sql.*;
import java.util.Scanner;

public class task41 {
    public static void exportExcel(String tablename, String filename) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Exam", "root", "root")) {
            System.out.println("Успешное подключение к базе данных.");

            String query = "SELECT * FROM " + tablename;
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Вывод текущего состояния таблицы " + tablename);
            while (rs.next()) {
                String str1_new = rs.getString("ID1");
                String str2_new = rs.getString("ID2");
                System.out.printf("%s %s%n", str1_new, str2_new);
            }

            System.out.println("Имя файла для сохранения: " + filename);
            String query1 = "SELECT 'ID1', 'ID2' UNION ALL SELECT * FROM "
                    + tablename + " INTO OUTFILE '/usr/local/mysql-8.0.31-macos12-arm64/Excel/"
                    + filename + "'";
            PreparedStatement stmt2 = connection.prepareStatement(query1);
            stmt2.executeQuery();

            System.out.println("Данные успешно занесены в Excel файл.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createQuery(String tablename) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Exam", "root", "root");
        System.out.println("Connection done");

        String createQuery = "CREATE TABLE IF NOT EXISTS " + tablename + " (ID1 VARCHAR(255), ID2 VARCHAR(255))";
        Statement statement = connection.createStatement();
        statement.executeUpdate(createQuery);
        System.out.println("Таблица успешно создана!");
    }
    public static void insertSQL(String tablename, String ID1, String ID2) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Exam", "root", "root")) {
            System.out.println("Connection done");

            String createQuery = "CREATE TABLE IF NOT EXISTS " + tablename + " (ID1 VARCHAR(255), ID2 VARCHAR(255))";
            Statement statement = connection.createStatement();
            statement.executeUpdate(createQuery);
            System.out.println("Таблица успешно создана!");

            String insertQuery = "INSERT INTO " + tablename + " (ID1, ID2) VALUES (?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);
            stmt.setString(1, ID1);
            stmt.setString(2, ID2);
            stmt.executeUpdate();

            System.out.println("Данные успешно добавлены в таблицу " + tablename);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showData(String tablename) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Exam", "root", "root")) {
            System.out.println("Connection done");

            String showQuery = "SELECT * FROM " + tablename;
            PreparedStatement statement = connection.prepareStatement(showQuery);
            ResultSet result = statement.executeQuery();

            System.out.println("Данные находящиеся в таблице " + tablename + ":");
            while (result.next()) {
                System.out.print(result.getString("ID1") + " ");
                System.out.print(result.getString("ID2") + " ");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("""
                1. Вывести все таблицы из MySQL.
                2. Создать таблицу в MySQL.
                3. Ввести две строки с клавиатуры, результат сохранить в MySQL с последующим
                выводом в консоль.
                4.Подсчитать размер ранее введенных строк, результат сохранить в MySQL с
                последующим выводом в консоль.
                5. Объединить две строки в единое целое, результат сохранить в MySQL с последующим
                выводом в консоль.
                6. Сравнить две ранее введенные строки, результат сохранить в MySQL с последующим
                выводом в консоль.
                7. Сохранить все данные (вышеполученные результаты) из MySQL в Excel и вывести на экран.
                """);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя таблицы с которой хотели бы работать");
        String tablename = scanner.nextLine();
        String a = "";
        String b = "";
        boolean exitRequested = false;

        while (!exitRequested) {

            System.out.println("Выберите действие (введите число от 1 до 8):");
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка ввода! Пожалуйста, введите число от 1 до 8:");
                scanner.next();
            }
            int choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                    String mySQLurl = "jdbc:mysql://localhost:3306/Exam";
                    Connection con = DriverManager.getConnection(mySQLurl, "root", "root");
                    System.out.println("Успешное подключение к базе данных. ");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("Show Tables");
                    System.out.println("Таблицы из текущей базы данных. ");
                    while (rs.next()) {
                        System.out.print(rs.getString(1));
                        System.out.println();
                    }
                }
                case 2 -> createQuery(tablename);
                case 3 -> {
                    a = scanner.nextLine();
                    System.out.println("Введите строку 1: ");
                    a = scanner.nextLine();
                    System.out.println("Введите строку 2: ");
                    b = scanner.nextLine();
                    insertSQL(tablename, a, b);
                    showData(tablename);
                }
                case 4 -> {
                    int sizeA = a.getBytes().length;
                    int sizeB = b.getBytes().length;
                    String sizeAA = String.valueOf(sizeA);
                    String sizeBB = String.valueOf(sizeB);
                    insertSQL(tablename, sizeAA, sizeBB);
                    showData(tablename);
                }
                case 5 -> {
                    String res = a + b;
                    insertSQL(tablename, "Сумма строк: ", res);
                    showData(tablename);
                }
                case 6 -> {
                    boolean AB = a.equals(b);
                    boolean BA = a.equals(b);
                    String sAB = String.valueOf(AB);
                    String sBA = String.valueOf(BA);
                    insertSQL(tablename, sAB, sBA);
                    showData(tablename);
                }
                case 7 -> {
                    String filename = scanner.nextLine();
                    System.out.println("Введите название файла с расширение xlsx:");
                    filename = scanner.nextLine();
                    exportExcel(tablename, filename);
                }
                case 8 -> {
                    exitRequested = true;
                    continue;
                }
                default -> System.out.println("Неверный выбор. Пожалуйста, выберите число от 1 до 8 или введите '8' для выхода.");
            }
        }
    }
}