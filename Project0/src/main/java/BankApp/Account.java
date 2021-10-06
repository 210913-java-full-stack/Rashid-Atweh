package BankApp;

import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Account {

    private static Scanner scanner = new Scanner(System.in);
    private static Connection conn = ConnectionManager.getConnection();


    public static void deposit() throws SQLException {
        boolean running=true;
        System.out.println("How much would you like to deposit today?");
        String inputD = scanner.nextLine();

        String sql = " ? ? ";
        PreparedStatement prepareStmt = conn.prepareStatement(sql);
//        prepareStmt.setString(1, );
//        prepareStmt.setString(2, Username.getUsername());
        ResultSet rs = prepareStmt.executeQuery(); //result set


        if (rs.next()) {
            //System.out.println("Your balance is: $" + rs.getDouble("insert_id"));
            System.out.println("Your new balance is: $" + rs.getDouble("balance"));
//            Balances.bh();
        }
        else {
            Balances.bh();

        }

    }
}
