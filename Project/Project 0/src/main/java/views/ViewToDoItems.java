package views;

import DAOs.ToDoItemDAO;
import collections.MyLinkedList;
import models.ToDoItem;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * This view shows the ToDoItems in a list.
 */
public class ViewToDoItems extends View{


    public ViewToDoItems(/*String viewName, */Scanner scanner) {
        super("ViewToDoList", scanner);
    }


    /**
     * This render method simply prints out the ToDoItems indicating which are complete. Then it navigates back
     * to main menu
     *
     */
    @Override
    public void renderView() throws SQLException {
        //retrieve list
        MyLinkedList<ToDoItem> list;
        ToDoItemDAO dao = new ToDoItemDAO(viewManager.getConn());
        list = dao.getAllItems();

        System.out.println("========== To Do List: ==========");
        /*for(int i = 0; i < list.size(); i++) {
            System.out.print(i + ") [");
            if(list.get(i).isComplete()) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            System.out.println("] " + list.get(i).getMessage());
        }
        */
        System.out.println("=================================");


        //navigate back to main menu
        viewManager.navigate("MainMenu");
    }
}
