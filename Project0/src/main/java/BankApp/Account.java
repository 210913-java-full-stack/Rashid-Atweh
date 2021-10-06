package BankApp;

import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Account {

    private static Connection conn = ConnectionManager.getConnection();
    private static Scanner scanner = new Scanner(System.in);
    private static String inputB;
    private static String inputF;
    private static String inputL;
    private static String inputU;
    private static String inputP;
    private static String Balance = inputB;
    private static String Fname = inputF;
    private static String Lname = inputL;
    private static String Uname = inputU;
    private static String Password = inputP;

    // Set up method to find AID & CID and add 1
    private static String AID;
    private static String CID;

    public static void accounts() throws SQLException {
        boolean running=true;
        System.out.println("Thank you for inquiring about opening a new account.");

        System.out.println("Please Enter you First Name");
        String inputF = scanner.nextLine();
        setFname(Fname);

        System.out.println("Please Enter you Last Name");
        String inputL = scanner.nextLine();
        setLname(Lname);

        System.out.println("Please Enter you User / Super Name");
        String inputU = scanner.nextLine();
        setUname(Uname);

        System.out.println("Please enter your Password");
        String inputP = scanner.nextLine();
        setPassword(Password);

        System.out.println("How much would you like to Deposit?");
        String inputB = scanner.nextLine();
        setBalance(String.valueOf(Balance));

        System.out.println("Thank You");

// SQL to set up account ids ******
        String sqlA = "INSERT INTO accounts_customers (customer_id, account_id) VALUES (?, ?);";
        PreparedStatement prepareStmtA = conn.prepareStatement(sqlA);
        prepareStmtA.setString(1, getCID());
        prepareStmtA.setString(2, getAID());
        prepareStmtA.executeUpdate();

// SQL to set up input user details
        String sqlU = "INSERT INTO customers (customer_id, fname, lname, uname, password) VALUES (?, ?, ?, ?, ?) ";
        PreparedStatement prepareStmtU = conn.prepareStatement(sqlU);
        prepareStmtU.setString(1,"0007");
        prepareStmtU.setString(2, getFname());
        prepareStmtU.setString(3, getLname());
        prepareStmtU.setString(4, getUname());
        prepareStmtU.setString(5, getPassword());
        prepareStmtU.executeUpdate();

// SQL for inserting Funds into balance
        String sqlB = "INSERT INTO balances (account_id, balance) VALUES (?, ?);";
        PreparedStatement prepareStmtB = conn.prepareStatement(sqlB);
        prepareStmtB.setString(1, getAID());
        prepareStmtB.setString(2, getBalance());
        prepareStmtB.executeUpdate();


// Select Balances
        String sqlB2 = "SELECT balance FROM balances b JOIN accounts_customers ac ON ac.account_id = b.account_id JOIN customers c ON c.customer_id = ac.customer_id WHERE uname= ? ";
        PreparedStatement prepareStmtB2 = conn.prepareStatement(sqlB2);
        prepareStmtB2.setString(1, getUname());
        ResultSet rsS = prepareStmtB2.executeQuery(); //result set

       if (rsS.next()) {
            System.out.println("Your New Balance Is: $" + rsS.getString("balance"));
            Balances.balances();

        }

    }

    //First Name getter / setters
    public static String getFname() {
        return Fname;
    }

    public static void setFname(String newFname) {
        Fname = newFname;
    }


    //Last Name getter / setters
    public static String getLname() {
        return Lname;
    }

    public static void setLname(String newLname) {
        Lname = newLname;
    }


    //UserName getter / setters
    public static String getUname() {
        return Uname;
    }

    public static void setUname(String newUname) {
        Uname = newUname;
    }


    //Password getter / setters
    public static String getPassword() {
        return Password;
    }

    public static void setPassword(String newPassword) {
        Password = Password;
    }

    //Balance getter / setters
    public static String getBalance() {
        return Balance;
    }

    public static void setBalance(String newBalanace) {
        Balance= Balance;
    }

    //Account_id getter / setters
    public static String getAID() {
        return AID;
    }

    public static void setAID(String newAID) {
        AID= AID;
    }

    //Account_id getter / setters
    public static String getCID() {
        return CID;
    }

    public static void setCID(String newCID) {
        CID= CID;
    }
}