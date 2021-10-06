package DAOs;



import BankApp.Balances;
import BankApp.Driver;
import collections.MyLinkedList;
import java.sql.*;

public class DAO implements GenericDAO<Balances> {
    private Connection conn;

    public DAO(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void save(Balances item) throws SQLException {
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
    public Balances getItemByID(int id) throws SQLException {
        String sql = "SELECT * FROM customers WHERE name * ";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);

        ResultSet rs = pstmt.executeQuery();

        if(rs.next()) {
            return null;//new Balances(rs.getInt("name"), rs.getString("name")/* , rs.getBoolean("complete")*/);
        } else {
            return null;
        }

    }

    @Override
    public MyLinkedList<Balances> getAllItems() throws SQLException {
        String sql = "SELECT * FROM customers";
        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        MyLinkedList<Balances> resultList = new MyLinkedList<>();

        while(rs.next()) {
            //Balances newItem = new Balances(rs.getInt("id"), rs.getString("message")/* , rs.getBoolean("complete")*/);
            //resultList.add(newItem);
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
