
import DAOs.CarDAO;
import DAOs.ToDoItemDAO;
import models.CarModel;
import models.ToDoItem;
import utils.ConnectionManager;
import utils.ViewManager;


import java.sql.*;


//This is where our program starts, with the main method and contains the menus and primary loop.
public class Driver {
    public static void main(String[] args) {
        //viewManager
        ViewManager viewManager = ViewManager.getViewManager();


        /**
         * This is our main loop, it keep running until something sets the viewManager "running" flag = false;
         * With every loop we invoke the viewManager singleton's goToNextView() method.
         */
        viewManager.navigate("MainMenu");
        while(viewManager.isRunning()) {
            try{
                viewManager.goToNextView();
            } catch(SQLException e) {
                e.printStackTrace();
            }

        }
    }
}