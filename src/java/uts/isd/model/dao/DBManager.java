/**
 *
 * @author Lewis
 */
package uts.isd.model.dao;

import uts.isd.model.User;
import java.sql.*;
import java.util.ArrayList;
import uts.isd.controller.Validator;
import uts.isd.model.Customer;
import uts.isd.model.IotDevices;
import uts.isd.model.Order;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
 */
public class DBManager {

    private Statement st;

    public DBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

//Find user by email and password in the database   
    public User findUser(String email, String password) throws SQLException {
        String sql = "select * from users where \"email\" = \'" + email + "\' and \"password\" = \'" + password + "\'";
        ResultSet rs = st.executeQuery(sql);
        User u = null;
        if (rs.next()) {
            u = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
        }
        //setup the select sql query string       
        //execute this query using the statement field       
        //add the results to a ResultSet       
        //search the ResultSet for a user using the parameters    
        return u;
    }

    public Customer findCustomer(int userid) throws SQLException {
        String sql = "select * from customers where userid = '" + userid + "'";
        ResultSet rs = st.executeQuery(sql);
        Customer u = null;
        if (rs.next()) {
            u = new Customer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
        }
        return u;
    }

//Add a user-data into the database   
    public void addUser(int userId, String name, String password) throws SQLException {
        String str = "insert into users (\"userid\", \"email\", \"password\")\n"
                + "values(" + userId + ", '" + name + "', '" + password + "');";
        System.out.println(str);//code for add-operation       
        st.executeUpdate(str);
    }

//update a user details in the database   
    public void updateUser(String email, String name, String password) throws SQLException {
        //code for update-operation   

    }

//delete a user from the database   
    public void deleteUser(String email) throws SQLException {
        String sql = "delete from users where \"email\" = \'" + email + "\'";
        System.out.println(sql);
        st.executeUpdate(sql);
    }

    public ArrayList<IotDevices> listAllDevices() throws Exception {
        String sql = "Select * from iot_devices";
        ResultSet rs = st.executeQuery(sql);
        ArrayList<IotDevices> listAllDevices = new ArrayList<>();
        while (rs.next()) {
            IotDevices devices = new IotDevices(rs.getInt(1), rs.getString(2), rs.getInt(3));
            listAllDevices.add(devices);
        }
        return listAllDevices;
    }

    public int addOrder(Order order) throws Exception {
        try {

            String str = "INSERT INTO [dbo].[orders]\n"
                    + "([customerId]\n"
                    + ",[paymentId]\n"
                    + ",[deviceId]\n"
                    + ",[status]\n"
                    + ",[invoiceId]\n"
                    + ",[date]\n"
                    + ",[quantity])\n"
                    + "     VALUES\n"
                    + "(" + order.getCustomerID()
                    + "," + order.getPaymentID()
                    + "," + order.getDeviceID()
                    + ",'" + order.getStatus()
                    + "'," + order.getInvoiceID()
                    + ",'" + order.getDate()
                    + "'," + order.getCount() + ")";
            System.out.println(str);
            return st.executeUpdate(str);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

    }

    public ArrayList<Order> listOrderByCustomer(int customerId, String orderIdSearch, String dateSearch) throws SQLException {
        String sql = "SELECT [orderId], "
                + "[customerId]\n"
                + "      ,[paymentId]\n"
                + "      ,[deviceId]\n"
                + "      ,[status]\n"
                + "      ,[invoiceId]\n"
                + "      ,[date]\n"
                + "      ,[quantity]\n"
                + "\n"
                + "  FROM [assignmentDB].[dbo].[orders] where customerId = " + customerId;
        if (orderIdSearch != null && !orderIdSearch.isEmpty() && Validator.validateInteger(orderIdSearch, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            sql += "\n"
                    + "and orderId = " + orderIdSearch;
        }
        if (dateSearch != null && !dateSearch.isEmpty()) {
            sql += "\n"
                    + "and [date] = '" + dateSearch + "'";
        }
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Order> orders = new ArrayList<>();
        while (rs.next()) {
            Order o = new Order(rs.getInt("orderId"), rs.getInt("customerId"),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getInt(6),
                    rs.getInt(8),
                    rs.getDate(7));
            orders.add(o);
        }
        return orders;
    }

    public ArrayList<Order> listOrderByCustomerSaved(int customerId, String orderIdSearch, String dateSearch) throws SQLException {
        String sql = "SELECT [orderId], "
                + "[customerId]\n"
                + "      ,[paymentId]\n"
                + "      ,[deviceId]\n"
                + "      ,[status]\n"
                + "      ,[invoiceId]\n"
                + "      ,[date]\n"
                + "      ,[quantity]\n"
                + "\n"
                + "  FROM [assignmentDB].[dbo].[orders] where customerId = " + customerId + " and status = 'Saved'";
        if (orderIdSearch != null && !orderIdSearch.isEmpty() && Validator.validateInteger(orderIdSearch, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            sql += "\n"
                    + "and orderId = " + orderIdSearch;
        }
        if (dateSearch != null && !dateSearch.isEmpty()) {
            sql += "\n"
                    + "and [date] = '" + dateSearch + "'";
        }
        System.out.println(sql);
        ResultSet rs = st.executeQuery(sql);
        ArrayList<Order> orders = new ArrayList<>();
        while (rs.next()) {
            Order o = new Order(rs.getInt("orderId"), rs.getInt("customerId"),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getInt(6),
                    rs.getInt(8),
                    rs.getDate(7));
            orders.add(o);
        }
        return orders;
    }

    public Order getOrderById(int orderId, int customerId) throws SQLException {
        String sql = "Select * from orders where orderId = " + orderId + " and customerId = " + customerId;
        ResultSet rs = st.executeQuery(sql);
        Order o = null;
        if (rs.next()) {
            o = new Order(rs.getInt("orderId"), rs.getInt("customerId"),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getInt(6),
                    rs.getInt(8),
                    rs.getDate(7));
        }
        return o;
    }

    public void updateOrderEdit(Order order) throws SQLException {
        String sql = "UPDATE [dbo].[orders]\n"
                + "   SET [paymentId] = " + order.getPaymentID()
                + "      ,[deviceId] = " + order.getDeviceID()
                + "      ,[invoiceId] = " + order.getInvoiceID()
                + "      ,[quantity] = " + order.getCount()
                + " WHERE orderId = " + order.getOrderID();
        st.executeUpdate(sql);
    }

    public void deleteOrder(int orderId) throws SQLException {
        String sql = "UPDATE [dbo].[orders]\n"
                + "   SET [status] = 'Canceled' "
                + " WHERE orderId = " + orderId;
        st.executeUpdate(sql);
    }

    public void submitRequest(String[] orderIds) throws SQLException {
        if (orderIds != null && orderIds.length > 0) {
            String ids = "(";
            ids += orderIds[0];
            for (int i = 1; i < orderIds.length; i++) {
                ids += ", " + orderIds[i];
            }
            ids += ")";
            String sql = "UPDATE [dbo].[orders]\n"
                    + "   SET [status] = 'Submitted' "
                    + " WHERE orderId in " + ids;
            st.executeUpdate(sql);
        }
    }

}
