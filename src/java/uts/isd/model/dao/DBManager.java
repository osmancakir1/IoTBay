/**
 *
 * @author Lewis
 */
package uts.isd.model.dao;

import uts.isd.model.User;
import java.sql.*;

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
    String sql = "select * from users where \"email\" = \'"+email+"\' and \"password\" = \'"+password+"\'";
    ResultSet rs=st.executeQuery(sql);
    User u=null;
    if(rs.next()){
        u = new User(rs.getString(1), rs.getString(2), rs.getString(3));
    }
   //setup the select sql query string       
   //execute this query using the statement field       
   //add the results to a ResultSet       
   //search the ResultSet for a user using the parameters               
   return u;   
}

//Add a user-data into the database   
public void addUser(String email, String name, String password) throws SQLException {
    String str = "insert into users (\"email\", \"username\", \"password\", \nvalues (\'"+email+"\', \'"+name+"\', \'"+password+"\', \'\')";
    System.out.println(str);//code for add-operation       
    st.executeUpdate(str);   
}


//update a user details in the database   
public void updateUser( String email, String name, String password) throws SQLException {       
   //code for update-operation   

}       

//delete a user from the database   
public void deleteUser(String email) throws SQLException{       
    String sql = "delete from users where \"email\" = \'"+ email +"\'";
    System.out.println(sql);
    st.executeUpdate(sql);
}


 

}