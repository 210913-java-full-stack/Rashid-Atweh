package BankApp;

import utils.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//Class to add funds to account

public class Withdraw {
        private static Scanner scanner = new Scanner(System.in);
        private static Connection conn = ConnectionManager.getConnection();


        public static void withdraw() throws SQLException {
            boolean running=true;
            System.out.println("How much would you like to withdraw today?");
            String inputD = scanner.nextLine();

            //Query to remove funds from Balance
            String sqlD = "Update balances b JOIN accounts_customers ac ON ac.account_id = b.account_id JOIN customers c ON c.customer_id = ac.customer_id SET balance = (balance - ?) WHERE uname = ?";
            PreparedStatement prepareStmtD = conn.prepareStatement(sqlD);
            prepareStmtD.setString(1, inputD);
            prepareStmtD.setString(2, Username.getUsername());
            prepareStmtD.executeUpdate();

            //Query to get that new Balance
            String sql = "SELECT balance FROM balances b JOIN accounts_customers ac ON ac.account_id = b.account_id JOIN customers c ON c.customer_id = ac.customer_id WHERE uname= ? ";
            PreparedStatement prepareStmt = conn.prepareStatement(sql);
            prepareStmt.setString(1, Username.getUsername());
            ResultSet rs = prepareStmt.executeQuery(); //result set

            if (rs.next()) {
                System.out.println("Thank You" + rs.getDouble("Uname"));
                Balances.balances();
            }
            else {
                Balances.balances();

            }

        }
    }
