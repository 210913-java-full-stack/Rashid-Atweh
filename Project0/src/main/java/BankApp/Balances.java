package BankApp;

//import collections.ArrayList;
import collections.MyArrayList;
import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//import static BankApp.Account.aid;


public class Balances {

    private int id;
    private static Scanner scanner = new Scanner(System.in);
    private static String inputD;
    private static Connection conn = ConnectionManager.getConnection();



    public static boolean balances() throws SQLException {
        System.out.println("\n~~~~~~~~ MAIN MENU ~~~~~~~~");
        System.out.println("\nPress 1 to see your Balance.");
        System.out.println("Press 2 to make a Deposit.");
        System.out.println("Press 3 to make a Withdrawal");
        System.out.println("Press 4 to open a New Account.");
        System.out.println("Press any other key to Quit.");
        String inputB = scanner.nextLine();

        String sql = "SELECT * FROM balances b JOIN accounts_customers ac ON ac.account_id = b.account_id JOIN customers c ON c.customer_id = ac.customer_id WHERE uname= ? ";
        PreparedStatement prepareStmt = conn.prepareStatement(sql);
        prepareStmt.setString(1, Username.getUsername());
        ResultSet rs = prepareStmt.executeQuery(); //result set
        MyArrayList<String> accounts = new MyArrayList<String>();

                switch (inputB) {
                    case "1":

                        if (rs.next()) {
//                        Code to display multiple balances will show here
                            accounts.add(String.valueOf(rs));

                            System.out.println("\nYour balance is: $" + accounts);
                            break;
//                            balances();
                        }
                        else {
                            balances();
                            return false;
                        }

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
                        return false;

                    default:
                        // code to end program
                        Driver.end();
                        return false;
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