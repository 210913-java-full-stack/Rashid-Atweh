package BankApp;

import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Username {

    public static boolean running;
    private static Scanner scanner = new Scanner(System.in);
    private static String inputU;
    private static String inputP;
    private static String Username = inputU;


    private static Connection conn = ConnectionManager.getConnection();

    public static boolean Login() throws SQLException {

        System.out.println("Please enter your User Name & Password to begin. \nUsername:");
        inputU = scanner.nextLine();
        setUsername(inputU);

        String sql = "SELECT c.uname AS \"Username\", CONCAT(c.fname, \" \", c.lname) AS \"NAME & ID\" FROM customers c WHERE uname = ? LIMIT 1";
        PreparedStatement prepareStmt = conn.prepareStatement(sql);
        prepareStmt.setString(1, Username);
        ResultSet rs = prepareStmt.executeQuery(); //result set


        while (rs.next()) {

            while (running = true) {

                if (rs.getString("uname").equals(inputU)) {
                    // code to check DB for valid username will go here
                    System.out.println("Welcome back " + rs.getString("NAME & ID"));
                    // if user enters valid username then check password
                    setUsername(Username);
                    break;
                }
                else {
                    // code for unrecognized usernames
                    System.out.println("Sorry, Please try again.");
                    Login();
                    return running = false;
                }
            }
        }

        System.out.println("Please enter your password below");
        inputP = scanner.nextLine();

        String sqlP = "SELECT * FROM customers c WHERE uname = ? AND password = ?";
        PreparedStatement prepareStmt2 = conn.prepareStatement(sqlP);
        prepareStmt2.setString(1, Username);
        prepareStmt2.setString(2, inputP);
        ResultSet rsP = prepareStmt2.executeQuery(); //result set


        while (rsP.next()) {
            if (rsP.getString("password").equals(inputP)) {
                System.out.println("Thank you");
                Balances.balances();
            }
             else {
                // code for unrecognized usernames
                System.out.println("Sorry, \nPlease Try Again.");
                Login();
            }
//            return false;

        }
        return true;
    }

    public static String getUsername() {
        return Username;
    }

    public static void setUsername(String newUsername) {
        Username = newUsername;
    }
}