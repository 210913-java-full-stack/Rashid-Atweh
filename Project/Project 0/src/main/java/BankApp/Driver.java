package BankApp;

import Utilities.ConnectionManager;
import DAOs.ToDoItemDAO;
import models.ToDoItem;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class Driver {

    public static void main(String[] args) {
        //This is where I will start my code

        try {
            Connection conn = ConnectionManager.getConnection();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }


        boolean running = true;
        int i = 0;
        Scanner sc = new Scanner(System.in);


        while (running) {
            System.out.println("===Bank App===\nEnter selection:\n\n1) Log In.\n2) Transaction History.\nQ) Quit");
            String input = sc.nextLine();
            ArrayList<Object> history = new ArrayList<>();


            switch (input) {
                case "1":
                    //Log in input
                    System.out.println("Welcome,\nPlease enter Username Below");
                    String inputU = sc.nextLine();

                    if ("test".equals(inputU)) {
                        System.out.println("Welcome Back " + inputU + "!");
                    }
                    else {
                        System.out.println("Unrecognized Username");
                    }

                    System.out.println("\nPlease enter Password Below");
                    String inputP = sc.nextLine();

                    if ("test".equals(inputP)) {
                        //Here you want a for loop to iterate through all of the items in the list that gets returned from history.get()
                        for (i = 0; i < history.size(); i++) {

                            System.out.println("\nWelcome Back " + inputU + "! \nYour transaction history is : " + history.get(i));
                        }

                    }
                    else if ("*".equals(inputP)) {
                        System.out.println("Unrecognized Password,\nTry again");
                        sc.nextLine();
                        System.out.println("Unrecognized Password,\nTry again");
                        sc.nextLine();
                    } else {
                        System.out.println("Unrecognized Password, \nGoodbye");
                        running = false;
                    }

                    break;

                case "2":
                    // access balances
                    for (i = 0; i < history.size(); i++) {

                        System.out.println("Thank You. \nYour balance is $" + history);
                    }
                    running = false;

                case "Q":
                case "q":
                    System.out.println("Thanks for visiting");
                    running = false;

                    break;


                    }

        }


    }
}