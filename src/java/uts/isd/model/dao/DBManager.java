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
    //public Staff findStaff(String userID) throws SQLException{
    //    String sql = "select * from staff where \"userid\"="+userID;
    //    ResultSet rs=st.executeQuery(sql);
    //    Staff staff = null;
    //    if(rs.next()){
    //        staff = new Staff(rs.getString(1), rs.getString(2), rs.getString(3)
    //        , rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
    //    }
    //    return staff;
    //}
    //public void addStaff(String email, String password, String firstname, 
    //        String lastname, String othernames, String role) throws SQLException{
    //    String sql = "select max(\"staffid\") from staff";
    //    int staffID = 99999;
    //    int userID = 99999;
    //    ResultSet rs = st.executeQuery(sql);
    //    if(rs.next()){
    //        staffID = Integer.parseInt(rs.getString(1));
    //    }
    //    sql ="select max(\"userid\") from users";
    //    rs = st.executeQuery(sql);
    //    if(rs.next()){
    //        userID = Integer.parseInt(rs.getString(1));
    //    }
    //    userID += 1;
    //        sql = "insert into users (\"userid\", \"email\", \"password\") \nvalues ("
    //                +userID+", \'"
    //                +email+"\', \'"+password+"\')";
    //        st.executeUpdate(sql);
    //    staffID += 1;
    //        sql = "insert into staff (\"staffid\", \"userid\", \"firstname\", \"lastname\", \"othernames\", \"role\", \"email\")\nvalues("
    //                +staffID+", "+userID+", \'"+ firstname+ "\', \'"+lastname+"\', \'"+othernames+"\', \'"+role+"\', \'"+email+"\')";
    //        st.executeUpdate(sql);
    //}

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
}
