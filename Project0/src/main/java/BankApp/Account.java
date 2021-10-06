package BankApp;

import utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Account {

    private static final Connection conn = ConnectionManager.getConnection();
    private static final Scanner scanner = new Scanner(System.in);
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

    private static int AID;
    private static int CID;

    public static void accounts() throws SQLException {
        System.out.println("Thank you for inquiring about opening a new account.");
        System.out.println("You must be referred by a current Avengers member.\n");


        System.out.println("Please Enter you First Name");
        String inputF = scanner.nextLine();
        setFname(inputF);

        System.out.println("Please Enter you Last Name");
        String inputL = scanner.nextLine();
        setLname(inputL);

        System.out.println("Please Enter you UserName / SuperHero Name");
        String inputU = scanner.nextLine();
        setUname(inputU);

        System.out.println("Please enter your Password");
        String inputP = scanner.nextLine();
        setPassword(inputP);

        System.out.println("How much would you like to Deposit?");
        String inputB = scanner.nextLine();
        setBalance(inputB);

        System.out.println("Thank You");
        System.out.println(inputF + inputL + inputU + inputP + inputB);



//        Find AID
        String sqlAID = "#SELECT * FROM balances b ORDER BY account_id DESC LIMIT 1 ";
        PreparedStatement prepareStmtAID = conn.prepareStatement(sqlAID);
        prepareStmtAID.executeQuery(); //result set
        ResultSet rsAID = prepareStmtAID.executeQuery();

            while (rsAID.next()) {
                AID = rsAID.getInt(AID) + 1;
                setAID(AID);

        }

// Find Cid
        String sqlCID = "#SELECT * FROM balances b ORDER BY account_id DESC LIMIT 1 ";
        PreparedStatement prepareStmtCID = conn.prepareStatement(sqlCID);
        prepareStmtCID.executeQuery(); //result set
        ResultSet rsCID = prepareStmtCID.executeQuery();


            while (rsCID.next()) {
            CID = rsCID.getInt(CID) + 1;
            setCID(CID);
    }

// SQL to set up account ids
        String sqlA = "INSERT INTO accounts_customers (account_id, customer_id) VALUES (?,?);"; //,
        PreparedStatement prepareStmtA = conn.prepareStatement(sqlA);
        prepareStmtA.setString(1, String.valueOf(getAID()));
        prepareStmtA.setString(2, String.valueOf(getCID()));
        prepareStmtA.executeUpdate();

// SQL to set up input user details
        String sqlU = "INSERT INTO customers (customer_id, fname, lname, uname, password) VALUES (?, ?, ?, ?, ?) ";
        PreparedStatement prepareStmtU = conn.prepareStatement(sqlU);
        prepareStmtU.setString(1, String.valueOf(getCID()));
        prepareStmtU.setString(2, getFname());
        prepareStmtU.setString(3, getLname());
        prepareStmtU.setString(4, getUname());
        prepareStmtU.setString(5, getPassword());
        prepareStmtU.executeUpdate();

// SQL for inserting Funds into balance
        String sqlB = "INSERT INTO balances (account_id, balance) VALUES (?, ?);";
        PreparedStatement prepareStmtB = conn.prepareStatement(sqlB);
        prepareStmtB.setString(1, String.valueOf(getAID()));
        prepareStmtB.setString(2, getBalance());
        prepareStmtB.executeUpdate();


// Display Balance
        String sqlB2 = "SELECT balance FROM balances b JOIN accounts_customers ac ON ac.account_id = b.account_id JOIN customers c ON c.customer_id = ac.customer_id WHERE uname= ? ";
        PreparedStatement prepareStmtB2 = conn.prepareStatement(sqlB2);
        prepareStmtB2.setString(1, getUname());
        ResultSet rsB2 = prepareStmtB2.executeQuery(); //result set


       if (rsB2.next()) {
            System.out.println("Your New Balance Is: $" + rsB2.getString("balance"));
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
        Password = newPassword;
    }

    //Balance getter / setters
    public static String getBalance() {
        return Balance;
    }

    public static void setBalance(String newBalance) {
        Balance= newBalance;
    }

    //Account_id getter / setters
    public static int getAID() {
        return AID;
    }

    public static void setAID(int newAID) {
        AID = newAID;
    }

    //Account_id getter / setters
    public static int getCID() {
        return CID;
    }

    public static void setCID(int newCID) {
        CID= newCID;
    }

}