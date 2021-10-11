package BankApp;

import utils.ConnectionManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

// Main method that will start the program

public class Driver {
    static boolean running = true;
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {

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
