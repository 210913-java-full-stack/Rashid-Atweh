package utils;

import collections.MyLinkedList;
import views.MainMenu;
import views.MarkItemComplete;
import views.View;
import views.ViewToDoItems;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


/**
 * ViewManager class is designed as a singleton which handles rendering the different console I/O views we have.
 * It does this by maintaining a list of possible views, and when navigate is invoked with the name of a view it
 * searches the list for that view and queues it up to be rendered in the next goToNextView() call from main.
 * goToNextView calls the view's renderView() method.
 */
public class ViewManager {
    private static ViewManager viewManager;
    private static View nextView;
    private MyLinkedList<View> viewList;
    private boolean running;
    private Connection conn;
    private Scanner scanner;

    private ViewManager() {
        viewManager = this;
        running = true;
        conn = ConnectionManager.getConnection();
        scanner = new Scanner(System.in);
        viewList = new MyLinkedList<>();


        //set up views
        viewList.add(new MainMenu(scanner));
        viewList.add(new MarkItemComplete(scanner));
        viewList.add(new ViewToDoItems(scanner));
    }

    /**
     * This is the method to retrieve the singleton instance of our ViewManager
     */
    public static ViewManager getViewManager() {
        if(viewManager == null) {
            viewManager = new ViewManager();
        }
        return viewManager;
    }

    /**
     * This searches the list for a view by name and queues that view up to be rendered
     * next time the main loop calls goToNextView();
     *
     */
    public void navigate(String destination) {
        for(View view : viewList) {
            if(view.getViewName().equals(destination)) {
                nextView = view;
            }
        }
    }

    /**
     * This is called from the main loop, and just calls the queued next view's render method.
     *
     */
    public void goToNextView() throws SQLException {
        nextView.renderView();
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public Connection getConn() {
        return conn;
    }
}
