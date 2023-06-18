import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class task1
{
    public static void exportExcel(String tablename, String filename) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Exam", "root", "1172093Nik")) {
            System.out.println("Успешное подключение к базе данных.");

            String query = "SELECT * FROM " + tablename;
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            System.out.println("Вывод текущего состояния таблицы " + tablename);
            while (rs.next()) {
                int id1_new = rs.getInt("ID1");
                int id2_new = rs.getInt("ID2");
                double res_new = rs.getDouble("RES");
                System.out.printf("%d %d %.2f%n", id1_new, id2_new, res_new);
            }

            System.out.println("Имя файла для сохранения: " + filename);
            String query1 = "SELECT 'ID1', 'ID2', 'RES' UNION ALL SELECT * FROM "
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
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Exam", "root", "1172093Nik")) {
            System.out.println("Connection done");

            String createQuery = "CREATE TABLE IF NOT EXISTS " + tablename + " (ID1 INT, ID2 INT, RES DOUBLE)";
            Statement statement = connection.createStatement();
            statement.executeUpdate(createQuery);
            System.out.println("Таблица успешно создана!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void insertSQL(String tablename, int ID1, int ID2, double Result) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Exam", "root", "1172093Nik")) {
            System.out.println("Connection done");

            String createQuery = "CREATE TABLE IF NOT EXISTS " + tablename + " (ID1 INT, ID2 INT, RES DOUBLE)";
            Statement statement = connection.createStatement();
            statement.executeUpdate(createQuery);
            System.out.println("Таблица успешно создана!");

            String insertQuery = "INSERT INTO " + tablename + " (ID1, ID2, RES) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(insertQuery);
            stmt.setInt(1, ID1);
            stmt.setInt(2, ID2);
            stmt.setDouble(3, Result);
            stmt.executeUpdate();

            System.out.println("Данные успешно добавлены в таблицу " + tablename);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void showData(String tablename) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Exam", "root", "1172093Nik")) {
            System.out.println("Connection done");

            String showQuery = "SELECT * FROM " + tablename;
            PreparedStatement statement = connection.prepareStatement(showQuery);
            ResultSet result = statement.executeQuery();

            System.out.println("Данные находящиеся в таблице " + tablename + ":");
            while (result.next()) {
                System.out.print(result.getInt("ID1") + " ");
                System.out.print(result.getInt("ID2") + " ");
                System.out.print(result.getDouble("RES") + " ");
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void slozhenie(String tablename, int A, int B)
    {
        double res = A + B;
        insertSQL(tablename, A, B, res);
        showData(tablename);
    }
    public static void vichetanie(String tablename, int A, int B)
    {
        double res = A - B;
        insertSQL(tablename, A, B, res);
        showData(tablename);
    }
    public static void umnozhenie(String tablename, int A, int B)
    {
        double res = A * B;
        insertSQL(tablename, A, B, res);
        showData(tablename);
    }
    public static void delenie(String tablename, int A, int B)
    {
        double res = (double) A / B;
        insertSQL(tablename, A, B, res);
        showData(tablename);
    }
    public static void ostatok(String tablename, int A, int B)
    {
        double res = A % B;
        insertSQL(tablename, A, B, res);
        showData(tablename);
    }
    public static void modul(String tablename, int A)
    {
        double res = abs(A);
        insertSQL(tablename, A, 0, res);
        showData(tablename);
    }
    public static void stepen(String tablename, int A, int B)
    {
        long res = (long) pow(A, B);
        insertSQL(tablename, A, B, res);
        showData(tablename);
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("""
                 Выберите дейтсвие:\s
                1. Вывести все таблицы из MySQL.
                2. Создать таблицу в MySQL.
                3. Сложение чисел, результат сохранить в MySQL с последующим выводом в консоль.
                4. Вычитание чисел, результат сохранить в MySQL с последующим выводом в консоль.
                5. Умножение чисел, результат сохранить в MySQL с последующим выводом в консоль.
                6. Деление чисел, результат сохранить в MySQL с последующим выводом в консоль.
                7. Деление чисел по модулю (остаток), результат сохранить в MySQL с последующим
                выводом в консоль.
                8. Возведение числа в модуль, результат сохранить в MySQL с последующим выводом в
                консоль.
                9. Возведение числа в степень, результат сохранить в MySQL с последующим выводом в
                консоль.
                10. Сохранить все данные (вышеполученные результаты) из MySQL в Excel и вывести на экран""");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя таблицы с которой хотели бы работать");
        String tablename = scanner.nextLine();
        boolean exitRequested = false;

        while (!exitRequested) {

            System.out.println("Выберите действие (введите число от 1 до 11) (11 выход из программы):");
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка ввода! Пожалуйста, введите число от 1 до 11 (11 выход из программы):");
                scanner.next();
            }
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                    String mySQLurl = "jdbc:mysql://localhost:3306/Exam";
                    Connection con = DriverManager.getConnection(mySQLurl, "root", "1172093Nik");
                    System.out.println("Успешное подключение к базе данных. ");
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery("Show Tables");
                    System.out.println("Таблицы из текущей базы данных. ");
                    while (rs.next()) {
                        System.out.print(rs.getString(1)); // print нужен чтобы выводились не через строку,
                        // так как ей присуща \n
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("Введите имя таблицы, которую хотите создать: ");
                    createQuery(tablename);
                    break;
                case 3:
                    int A = scanner.nextInt();
                    int B = scanner.nextInt();
                    slozhenie(tablename, A, B);
                    break;
                case 4:
                    A = scanner.nextInt();
                    B = scanner.nextInt();
                    vichetanie(tablename, A, B);
                    break;
                case 5:
                    A = scanner.nextInt();
                    B = scanner.nextInt();
                    umnozhenie(tablename, A, B);
                    break;
                case 6:
                    A = scanner.nextInt();
                    B = scanner.nextInt();
                    delenie(tablename, A, B);
                    break;
                case 7:
                    A = scanner.nextInt();
                    B = scanner.nextInt();
                    ostatok(tablename, A, B);
                    break;
                case 8:
                    A = scanner.nextInt();
                    modul(tablename, A);
                    break;
                case 9:
                    A = scanner.nextInt();
                    B = scanner.nextInt();
                    stepen(tablename, A, B);
                    break;
                case 10:
                    System.out.println("Введите имя файла: ");
                    String filename = scanner.next();
                    exportExcel(tablename, filename);
                case 11:
                    exitRequested = true;
                    continue;
                default:
                    System.out.println("Неверный выбор. Пожалуйста, выберите число от 1 до 11. Чтобы выйти введите 11");
                    break;
            }
        }
    }
}