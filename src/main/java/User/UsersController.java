package User;

import DbHelper.DbConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UsersController {
    private static Scanner sc = new Scanner(System.in);
    private static PreparedStatement ps;
    private static ResultSet rs;

    public static boolean addNewUser() {
        System.out.println("Enter you username: ");
        String username = sc.next();

        System.out.println("Enter your password: ");
        String password = sc.next();


        try {
            ps = DbConnection.getConnection().prepareStatement("INSERT INTO CowsAndBulls (username, password) " + " VALUES('"
                    + username + "', '" + password + "')");
            ps.execute();
            System.out.println("Your registration is successful. ");
            return true;

        }
        catch (SQLException e) {
            e.getMessage();
            return false;
        }
    }
    public static void editUser() {

        System.out.print("Enter your current username: ");
        String username = sc.next();

        System.out.print("Enter what you want to change: username or password ");
        String object= sc.next();
        System.out.println("Enter the updated value: ");
        String update = sc.next();

        try {
            ps = DbConnection.getConnection().prepareStatement("UPDATE CowsAndBulls SET " + object + " = '" + update + "' WHERE username= "+ username);
            ps.execute();
            System.out.println("Successfully edited " + object + ". ");
        } catch(SQLException e) {
            e.printStackTrace();

        }

    }
    public static void deleteUser() {

        System.out.print("Enter you username: ");
        String username = sc.next();

        try {

            ps = DbConnection.getConnection().prepareStatement("DELETE FROM CowsAndBulls WHERE username="+ username);
            ps.execute();
            System.out.println("Successfully deleted user. ");
        } catch(SQLException e) {
            e.getMessage();

        }

    }
    public static boolean loginIn() {
        System.out.print("Enter your username: ");
        String username = sc.next().trim();
        System.out.print("Enter your password: ");
        String password = sc.next().trim();

        try {
            ps = DbConnection.getConnection().prepareStatement("SELECT * FROM CowsAndBulls WHERE username='" + username + "';");
            rs = ps.executeQuery();

            String passwordCheck = "";
            while (rs.next()) {
                passwordCheck = rs.getString("password");

            }
            System.out.println("Successfully login. ");
            return true;

        } catch (SQLException e) {
            // e.printStackTrace();
            System.out.println("Unable to login, try again. ");
            return false;
        }
    }
}
