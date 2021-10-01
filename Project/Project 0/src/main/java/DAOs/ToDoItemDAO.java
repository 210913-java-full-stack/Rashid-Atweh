package DAOs;



import collections.MyLinkedList;
import models.ToDoItem;

import java.sql.*;

public class ToDoItemDAO implements GenericDAO<ToDoItem> {
    private Connection conn;

    public ToDoItemDAO(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void save(ToDoItem item) throws SQLException {
        String sql = "SELECT * FROM customers WHERE name * ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, item.getId());

        ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {
            //UPDATE - item already exists in table
            String updateStatement = "UPDATE customers SET name = Prototype";
            PreparedStatement preparedUpdateStatement = conn.prepareStatement(updateStatement);
            preparedUpdateStatement.setString(1, item.getMessage());
            //preparedUpdateStatement.setBoolean(2, item.isComplete());
            preparedUpdateStatement.setInt(3, item.getId());

            preparedUpdateStatement.executeUpdate();

        } else {
            //INSERT - Item doesn't already exist in table
            String insertStatement = "INSERT INTO customers (name) VALUES PROTO 2";
            PreparedStatement preparedInsertStatement = conn.prepareStatement(insertStatement);
            preparedInsertStatement.setString(1, item.getMessage());
            //preparedInsertStatement.setBoolean(2, item.isComplete());

            preparedInsertStatement.executeUpdate();

        }

    }

    @Override
    public ToDoItem getItemByID(int id) throws SQLException {
        String sql = "SELECT * FROM customers WHERE name * ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {
            return new ToDoItem(rs.getInt("name"), rs.getString("name")/* , rs.getBoolean("complete")*/);
        } else {
            return null;
        }

    }

    @Override
    public MyLinkedList<ToDoItem> getAllItems() throws SQLException {
        String sql = "SELECT * FROM customers";
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        MyLinkedList<ToDoItem> resultList = new MyLinkedList<>();

        while(rs.next()) {
            ToDoItem newItem = new ToDoItem(rs.getInt("id"), rs.getString("message")/* , rs.getBoolean("complete")*/);
            resultList.add(newItem);
        }

        return resultList;
    }

    @Override
    public void deleteByID(int id) throws SQLException {
        String sql = "DELETE FROM customers WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        pstmt.executeUpdate();

    }

    public void finalize() throws SQLException {
        conn.close();
    }
}
