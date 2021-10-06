package BankApp;

import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Username {

        static boolean running;
        private static Scanner scanner = new Scanner(System.in);
        private static String inputU;
        private static String inputP;
        private static String Username = inputU;
        private static String Password = inputP;
        private static Connection conn = ConnectionManager.getConnection();

    public static boolean Login() throws SQLException {

        System.out.println("Please enter your User Name & Password to begin. \nUsername:");
//        Scanner scanner = new Scanner(System.in);
        inputU = scanner.nextLine();
//        Connection conn = ConnectionManager.getConnection();
        setUsername(inputU);
        String sql = "SELECT * FROM customers c WHERE uname = ?";
        PreparedStatement prepareStmt = conn.prepareStatement(sql);
        prepareStmt.setString(1, Username);
        ResultSet rs = prepareStmt.executeQuery(); //result set




        while (rs.next()) {

            while (running = true) {

                if (rs.getString("uname").equals(inputU)) {
                    // code to check DB for valid username will go here
                    System.out.println("Welcome back " + rs.getString("fname"));
                    // if user enters valid username then check password
                    setUsername(Username);
                    break;

                    //return running = true;
                } else {
                    // code for unrecognized usernames
                    System.out.println("Sorry, Please try again.");
                    //Bad.bun();
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
            //System.out.println(rs.getString("PassWord"));

            //need to get pw by index. currently, works with any pw
            if (rsP.getString("password").equals(inputP)) {
                // code to check DB for valid username will go here
                System.out.println("Thank you");
                Balances.bh();
                return false;
            }
            else {
                // code for unrecognized usernames
                Driver.end();
//                Bad.bpw();
                return false;
            }

        }
        return true;
    }

    public static String getUsername() {
        return Username;
    }
    public static void setUsername(String newUsername) {
        Username = newUsername;
    }
//    public static String getPassword() {
//        return Password;
//    }

}



//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        Connection conn = ConnectionManager.getConnection();
//        String sql = "SELECT c.uname, CONCAT(c.fname, \" \", c.lname) AS \"NAME & ID\" \n FROM customers c \n JOIN accounts_customers ac ON c.customer_id = ac.customer_id \n WHERE uname =\"" + input + "\"";
//        PreparedStatement prepareStmt = conn.prepareStatement(sql);
//        ResultSet rs = prepareStmt.executeQuery(); //result set

//System.out.println(rs.getString("name & id"));


//        Scanner scanner = new Scanner(System.in);
//        String inputP = scanner.nextLine();
//        Connection conn = ConnectionManager.getConnection();