package BankApp;

import DAOs.ToDoItemDAO;
import Utilities.ConnectionManager;
import models.ToDoItem;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.ArrayList;

public class Driver {

    public static void main(String[] args){
        //This is where I will start my code

        try {
            Connection conn = ConnectionManager.getConnection();

            ToDoItem newItem = new ToDoItem("Build a UI for our app");
            ToDoItemDAO dao = new ToDoItemDAO(conn);
            dao.save(newItem);


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> cars = new ArrayList<String>();
        cars.add("Volvo");
        cars.add("BMW");
        cars.add("Ford");
        cars.add("Mazda");
        System.out.println(cars);


        Scanner sc = new Scanner(System.in);
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