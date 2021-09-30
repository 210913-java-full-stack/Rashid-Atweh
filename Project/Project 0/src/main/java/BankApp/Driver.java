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

    public static void main(String[] args){
        //This is where I will start my code

        Scanner sc = new Scanner(System.in);

        try {
            Connection conn = ConnectionManager.getConnection();

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        ArrayList<String> test = new ArrayList<String>();
        test.add("test1");
        test.add("test2");
        test.add("test3");
        test.add("test4");
        System.out.println(test);
        boolean running = true;
        int b = 12;
            while(running) {
                System.out.println("===Bank App===\nEnter selection:\n\n1) Log In.\n2) Check Balance.\nQ) Quit");
                String input = sc.nextLine();

                switch(input)  {
                    case "1":
                        //Log in input
                        System.out.println("Welcome, Please enter Username Below");
                        String inputU = sc.nextLine();

                            if ("test".equals(inputU)) {
                                System.out.println("Welcome Back User!");
                            }

                               else {
                                    System.out.println("Unrecognized Username");
                                }
                        System.out.println("Thank You, Please enter Password Below");
                        String inputP = sc.nextLine();

                        if ("test".equals(inputP)) {
                            System.out.println("Welcome Back User, Your Balance is currently: " + b);
                        }
                            else if("abc".equals(inputP)){
                                System.out.println("Unrecognized Password, Try again");
                                sc.nextLine();
                                System.out.println("Unrecognized Password, Try again");
                                sc.nextLine();
                    }
                            else {
                        System.out.println("Unrecognized Password, Goodbye");
                        running = false;
                    }

                        break;

                    case "2":
                        // access balances
                        System.out.println("Thank You. Your balance is $" + b);
                        break;


                    case "Q":
                        case "q":
                            System.out.println("Thanks for visiting");
                        running = false;
                        break;



                }

            }

    }
}