/**
 *
 * @author Lewis
 */
package uts.isd.model.dao;

import uts.isd.model.*;
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
public Staff findStaff(String userID) throws SQLException{
    String sql = "select * from staff where \"userid\"="+userID;
    ResultSet rs=st.executeQuery(sql);
    Staff staff = null;
    if(rs.next()){
        staff = new Staff(rs.getString(1), rs.getString(2), rs.getString(3)
        , rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
    }
    return staff;
}
public void addStaff(String email, String password, String firstname, 
        String lastname, String othernames, String role) throws SQLException{
    String sql = "select max(\"staffid\") from staff";
    int staffID = 99999;
    int userID = 99999;
    ResultSet rs = st.executeQuery(sql);
    if(rs.next()){
        staffID = Integer.parseInt(rs.getString(1));
    }
    sql ="select max(\"userid\") from users";
    rs = st.executeQuery(sql);
    if(rs.next()){
        userID = Integer.parseInt(rs.getString(1));
    }
    userID += 1;
        sql = "insert into users (\"userid\", \"email\", \"password\") \nvalues ("
                +userID+", \'"
                +email+"\', \'"+password+"\')";
        st.executeUpdate(sql);
    staffID += 1;
        sql = "insert into staff (\"staffid\", \"userid\", \"firstname\", \"lastname\", \"othernames\", \"role\", \"email\")\nvalues("
                +staffID+", "+userID+", \'"+ firstname+ "\', \'"+lastname+"\', \'"+othernames+"\', \'"+role+"\', \'"+email+"\')";
        st.executeUpdate(sql);
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