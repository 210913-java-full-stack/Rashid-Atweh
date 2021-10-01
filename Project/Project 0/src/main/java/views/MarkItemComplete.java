package views;

import DAOs.ToDoItemDAO;
import collections.MyLinkedList;
import models.ToDoItem;

import java.sql.SQLException;
import java.util.Scanner;

/**
 * This is the view that prints a list of items and prompt the user to select one to mark complete.
 */
public class MarkItemComplete extends View{


    public MarkItemComplete(/*String viewName, */Scanner scanner) {
        super("MarkItemComplete", scanner);
    }

    /**
     * This view prints out a list of items for reference, and prompts the user to choose one, then it marks it
     * complete before it then queues up ViewToDoList menu in order to see our newly completed item marked correctly.
     *
     */
    @Override
    public void renderView() throws SQLException {
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

        System.out.print("\nEnter item number to mark complete: ");
        String choice = scanner.nextLine();
        //list.get(Integer.parseInt(choice)).setComplete(true);
        dao.save(list.get(Integer.parseInt(choice)));

        viewManager.navigate("ViewToDoList");

    }
}
