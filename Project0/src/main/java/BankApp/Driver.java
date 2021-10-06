package BankApp;

import collections.MyArrayList;
import collections.MyListInterface;
import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Driver {
    static boolean running = true;

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
            System.out.println("Welcome to the Avengers First Bank");
            try {
                Username.Login();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            break;

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