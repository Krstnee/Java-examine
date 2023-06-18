import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);
    protected static String mysqlUrl = "jdbc:mysql:///test10";
    protected static Connection con;
    static String tablename = "phone";

    static {
        try {
            // в модулях должен быть подключен mysql-connector
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            con = DriverManager.getConnection(mysqlUrl, "root", "root");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createTable() throws SQLException{
        Statement stmt = con.createStatement();
        String query = "CREATE TABLE IF NOT EXISTS " + tablename + " (id integer,  manufacturer varchar(255), model varchar(255), release_year year, diagonal numeric(8, 2))";
        stmt.executeUpdate(query);
    }
    public static void addPhone() throws SQLException{
        ArrayList<String> phone = new ArrayList<>();

        System.out.println("enter phone's id: ");
        String id = scan.nextLine();
        phone.add(id);

        System.out.println("enter phone's manufacturer: ");
        String manufacturer = scan.nextLine();
        phone.add(manufacturer);

        System.out.println("enter phone's model: ");
        String model = scan.nextLine();
        phone.add(model);

        System.out.println("enter phone's release year: ");
        String release_year = scan.nextLine();
        phone.add(release_year);

        System.out.println("enter phone's diagonal: ");
        String diagonal = scan.nextLine();
        phone.add(diagonal);

        String query = "INSERT INTO " + tablename + " (id, manufacturer, model, release_year, diagonal) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, phone.get(0));
        stmt.setString(2, phone.get(1));
        stmt.setString(3, phone.get(2));
        stmt.setString(4, phone.get(3));
        stmt.setString(5, phone.get(4));
        stmt.executeUpdate();

        System.out.println("done");
    }
    public static void showPhones() throws SQLException {
        Statement stmt1 = con.createStatement();
        ResultSet rs = stmt1.executeQuery("SELECT * FROM " + tablename);
        while (rs.next()) {
            String id = rs.getString("id");
            String manufacturer = rs.getString("manufacturer");
            String model = rs.getString("model");
            String release_year = rs.getString("release_year");
            String diagonal = rs.getString("diagonal");

            System.out.println(id + ' ' + manufacturer + ' ' + model + ' ' + release_year + ' ' + diagonal);
        }
    }
    public static void deletePhone() throws SQLException{
        scan.nextLine();
        System.out.print("enter the phone's ID to be deleted: ");
        String input_ID = scan.nextLine();
        String query2 = "SET SQL_SAFE_UPDATES = 0";
        String query3 = "DELETE FROM " + tablename + " WHERE ID = '" + input_ID + "'";
        String query4 = "SET SQL_SAFE_UPDATES = 1";
        PreparedStatement stmt1 = con.prepareStatement(query2);
        PreparedStatement stmt2 = con.prepareStatement(query3);
        PreparedStatement stmt3 = con.prepareStatement(query4);
        stmt1.executeUpdate();
        stmt2.executeUpdate();
        stmt3.executeUpdate();
        System.out.println("done");
    }

    public static void main(String[] args) throws SQLException{
        System.out.println("Hello!");
        createTable();
        addPhone();
        showPhones();
        deletePhone();
        showPhones();

    }
}