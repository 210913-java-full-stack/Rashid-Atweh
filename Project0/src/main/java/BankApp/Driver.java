package BankApp;

import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class Driver {
    static boolean running = true;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
//
//        /*
//        This is kyles hint code
//        When we do the array list we are literally making our own version of the collections we already are familiar with
//
//         */
//        List<String> newList = new ArrayList<>();
//        newList.add("Hello");
//
//        MyListInterface<String> myNewList = new MyArrayList<>();
//        myNewList.add("Hello");
//
//    }
//
//    public static void start() {
        Connection conn = ConnectionManager.getConnection();
        while (running = true) {
            System.out.println("Welcome to the First Avengers Bank");
            System.out.println("Press 1 to Login.");
            System.out.println("Press 2 to Open an Account.");
            System.out.println("Press any other key to Quit.");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                try {
                    Username.Login();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;

                case "2":
                    Account.accounts();

                default:
                    end();
            }
        }
    }




    public static void end() {
            System.out.println("\nGoodbye.\n");
            running = false;
            System.exit(0);
        }
    }



//       try
//        {
//            Connection conn = ConnectionManager.getConnection();
//            String sql = "SELECT * FROM customers WHERE";
//            PreparedStatement prepareStmt = conn.prepareStatement(sql);
//            ResultSet rs =prepareStmt.executeQuery(); //result set
//
//            while(rs.next())
//            {
//                System.out.println(rs.getString("fname"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }