/**
 *
 * @author Lewis
 */
package uts.isd.model.dao;

import uts.isd.model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import uts.isd.model.Payment;

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
        String read = "SELECT * FROM ISDUSER.USERS WHERE EMAIL = '" + email + "' AND PASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(read);

        while (rs.next()) {
            String userEmail = rs.getString(1);
            String userPass = rs.getString(3);
            if(userEmail.equals(email) && userPass.equals(password)) {
                String userName = rs.getString(2);
                String userPhone = rs.getString(4);
                
                return new User(userEmail, userName, userPass, userPhone);
            }
        }

        return null; 
    }

    //Add a user-data into the database   
    public void addUser(String email, String name, String password, String phone) throws SQLException {
        st.executeUpdate("INSERT INTO ISDUSER.USERS " + "VALUES ('" + email + "', '" + name + "', '" + password + "', '" + phone + "')"); 

    }

    //update a user details in the database   
    public void updateUser(String email, String name, String password, String phone) throws SQLException {       
       st.executeUpdate("UPDATE ISDUSER.USERS SET NAME='" + name + "', PASSWORD='" + password + "', PHONE='" + phone + "' WHERE EMAIL='" + email + "'");   

    }       

    //delete a user from the database   
    public void deleteUser(String email) throws SQLException{       
         st.executeUpdate("DELETE FROM ISDUSER.USERS WHERE EMAIL='" + email + "'");
    }
    
    public ArrayList<User> fetchUsers() throws SQLException {
        String fetch = "SELECT * FROM USERS";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<User> temp = new ArrayList();

        while (rs.next()) {
            String email = rs.getString(1);
            String name = rs.getString(2);
            String password = rs.getString(3);
            String phone = rs.getString(4);
            temp.add(new User(email, password, name, phone));
        }

        return temp;
    }
    public boolean checkUser(String email, String password) throws SQLException {
       String fetch = "SELECT * FROM ISDUSER.USERS WHERE EMAIL = '" + email + "' AND PASSWORD='" + password + "'";
       ResultSet rs = st.executeQuery(fetch);

       while (rs.next()) {
           String userEmail = rs.getString(1);
           String userPass = rs.getString(3);
           if (userEmail.equals(email) && userPass.equals(password)) {
               //irrelevant comment
               return true;
           }
       }
       return false;
   }
    
    public void addPayment(String cardNumber, String cardExpiry, String cardCVC, String userEmail) throws SQLException {
        st.executeUpdate("INSERT INTO ISDUSER.PAYMENT (cardNumber, cardExpiry, cardCVC, userEmail) VALUES ('" + cardNumber + "', '" + cardExpiry + "', '" + cardCVC + "'," + userEmail + ")");
    }
    
    public void updatePayment(String cardNumber, String newCardNumber, String newExpiry, String newCVC) throws SQLException {
        st.executeUpdate("UPDATE ISDUSER.PAYMENT SET cardNumber='" + newCardNumber + "', cardExpiry='" + newExpiry + "', cardCVC='" + newCVC + ", WHERE creditCardNumber='" + cardNumber + "'");
    }
    
    public void deletePayment(String cardNumber) throws SQLException {
        st.execute("DELETE FROM ISDUSER.PAYMENT WHERE cardNumber='" + cardNumber + "'");
    }
    public Payment getPayment(String cardNumber, String userEmail) throws SQLException {
        try {
            ResultSet rs = st.executeQuery("SELECT * FROM ISDUSER.PAYMENT WHERE cardNumber='" + cardNumber + "'");
            return new Payment(rs.getString("cardNumber"), rs.getString("cardExpiry"), rs.getString("cardCVC"), rs.getString("userEmail"));
        } catch (Exception ex) {
            return null;
        }
    }
}
