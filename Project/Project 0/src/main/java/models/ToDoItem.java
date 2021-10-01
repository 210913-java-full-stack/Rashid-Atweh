package models;

import java.util.ArrayList;

public class ToDoItem extends ArrayList<String> {
    private int id;
    private String name;

   /* private boolean complete;

    public ToDoItem() {
        complete = false;
    } */

    public ToDoItem(String name) {
        //complete = false;
        this.id = id;
        this.name = name;

    }

    public ToDoItem(int id, String name) {
        //complete = false;
        this.id = id;
        this.name = name;

    }

   /* public ToDoItem(int id, String name, boolean complete) {
        this.id = id;
        this.name = name;
        this.complete = complete;
    } */


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return name;
    }

    public void setMessage(String name) {
        this.name = name;
    }

  /*  public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    */
}
