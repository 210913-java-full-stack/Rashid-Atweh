//package BankApp;
//
//import utils.ConnectionManager;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//import static BankApp.Username.*;
//
//
//public class Bad {
//
//
//    public static boolean bun() throws SQLException {
//        System.out.println("Please reenter your Username below");
//        boolean running = true;
//        Scanner scanner = new Scanner(System.in);
//        String inputU = scanner.nextLine();
//        Connection conn = ConnectionManager.getConnection();
//        String sql = "SELECT c.uname, CONCAT(c.fname, \" \", c.lname) AS \"NAME & ID\" \n FROM customers c \n JOIN accounts_customers ac ON c.customer_id = ac.customer_id \n WHERE uname =\"" + inputU + "\"";
//        PreparedStatement prepareStmt = conn.prepareStatement(sql);
//        ResultSet rs = prepareStmt.executeQuery(); //result set
//
//
//        while (rs.next()) {
//            {
//                if (rs.getString("uname").equals(inputU)) {
//                    // code to check DB for valid username will go here
//                    System.out.println("Welcome back " + rs.getString("name & id"));
//                    // if user enters valid username then check password
//                    Username.pw();
//                } else {
//                    // code for unrecognized usernames
//                    Driver.end();
//                    running = false;
//                    return running;
//
//                }
//            return running;
//            }
//        }
//        return running;
//    }
//
//
//    public static boolean bpw() throws SQLException {
//
//        System.out.println("Please enter your password below");
//        Scanner scanner = new Scanner(System.in);
//        String inputP = scanner.nextLine();
//        Connection conn = ConnectionManager.getConnection();
//        String sql = "SELECT c.password FROM customers c WHERE password =\"" + inputP + "\"";
//        PreparedStatement prepareStmt = conn.prepareStatement(sql);
//        ResultSet rs = prepareStmt.executeQuery(); //result set
//
//        while (rs.next()) {
//            if (rs.getString("password").equals(inputP)) {
//                // code to check DB for valid username will go here
//                System.out.println("Welcome back " + rs.getString("name & id"));
//                // if user enters valid username then check password
//                Username.getUsername(Username);
//            } else {
//                // code for unrecognized usernames
//                Driver.end();
//                return false;
//            }
//        }
//        return false;
//    }
//
//
//    public Bad() throws SQLException {
//    }
//}
//
////
////    static boolean running;
////    static Scanner scanner = new Scanner(System.in);
////    static String inputU = scanner.nextLine();
////    static String inputP = scanner.nextLine();
////    static Connection conn = ConnectionManager.getConnection();
////    static String sql = "SELECT c.password FROM customers c WHERE password =\"" + inputU + "\"";
////    static PreparedStatement prepareStmt;
////
////    static {
////        try {
////            prepareStmt = conn.prepareStatement(sql);
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////    }
////
////    static ResultSet rs; //result set
////
////    static {
////        try {
////            rs = prepareStmt.executeQuery();
////        } catch (SQLException e) {
////            e.printStackTrace();
////        }
////    }
