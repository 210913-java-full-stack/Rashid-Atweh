package BankApp;

import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Deposit {
    private static Scanner scanner = new Scanner(System.in);
    private static Connection conn = ConnectionManager.getConnection();


    public static void deposit() throws SQLException {
        boolean running=true;
        System.out.println("How much would you like to deposit today?");
        String inputD = scanner.nextLine();

        String sqlD = "Update balances b JOIN accounts_customers ac ON ac.account_id = b.account_id JOIN customers c ON c.customer_id = ac.customer_id SET balance = (balance + ?) WHERE uname = ?";
        PreparedStatement prepareStmtD = conn.prepareStatement(sqlD);
        prepareStmtD.setString(1, inputD);
        prepareStmtD.setString(2, Username.getUsername());
        ResultSet rs = prepareStmtD.executeQuery(); //result set


        if (rs.next()) {
            //System.out.println("Your balance is: $" + rs.getDouble("insert_id"));
            System.out.println("Your new balance is: $" + rs.getDouble("balance"));
            Balances.bh();
        }
        else {
            Balances.bh();

        }

    }
}
