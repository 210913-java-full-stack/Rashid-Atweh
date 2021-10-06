package BankApp;

//import collections.ArrayList;
import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import static BankApp.Username.Login;


public class Balances {

    private int id;
    private static Scanner scanner = new Scanner(System.in);
    private static String inputD;
    private static Connection conn = ConnectionManager.getConnection();



    public static boolean balances() throws SQLException {
//        boolean running = true;
        System.out.println("\n~~~~~~~ MAIN MENU ~~~~~~~");
        System.out.println("\nPress 1 to see your Balance.");
        System.out.println("Press 2 to make a Deposit.");
        System.out.println("Press 3 to make a Withdrawal");
        System.out.println("Press 4 to open a New Account.");
        System.out.println("Press any other key to Quit.");
        String sql = "SELECT balance FROM balances b JOIN accounts_customers ac ON ac.account_id = b.account_id JOIN customers c ON c.customer_id = ac.customer_id WHERE uname= ? ";
        PreparedStatement prepareStmt = conn.prepareStatement(sql);
        prepareStmt.setString(1, Username.getUsername());
        ResultSet rs = prepareStmt.executeQuery(); //result set

        while (rs.next()) {

            String inputB = scanner.nextLine();

                switch (inputB) {
                    case "1":
                        // View Balance
                        System.out.println("\nYour balance is: $"+ rs.getString("balance"));
                        balances();
                        return false;

                    case "2":
                        //Deposits
                        Deposit.deposit();
                        return false;

                    case "3":
                        //Withdrawals
                        Withdraw.withdraw();
                        return false;

                    case "4":
                        //New Accounts
                        Account.accounts();

                    default:
                        // code to end program
                        Driver.end();
                        return false;
            }
       }
        return false;
    }


    public int getId() {
        int id = 0;
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        String name= "Test";
        return name;
    }
}