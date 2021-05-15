package uts.isd.controller;

/**
 *
 * @author Lewis
 */
import uts.isd.controller.*;
import uts.isd.model.dao.*;
import uts.isd.model.*;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class TestDB {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            DBConnector connector = new DBConnector();
            Connection conn = connector.openConnection();
            DBManager db = new DBManager(conn);
            System.out.println("Test:");
            String test = "addstaff";//in.nextLine();
            System.out.println();
            if(test.equals("add")){
                System.out.print("User email: ");
                String email = in.nextLine();
                System.out.print("User name: ");
                String name = in.nextLine();
                System.out.print("User password: ");
                String password = in.nextLine();
                db.addUser( email, name, password);
                System.out.println("User is added to the database.");
            }else if(test.equals("find")){
                System.out.println("Email: ");
                String email = in.nextLine();
                System.out.println("Password: ");
                String password = in.nextLine();
                User u = db.findUser(email, password);
                if(u!=null){
                    System.out.println("User: "+u.getUsername()+" found.");
                }else{
                    System.out.println("User not found");
                }
            }else if(test.equals("delete")){
                System.out.println("Email: ");
                String email = in.nextLine();
                db.deleteUser(email);
                System.out.println("User Deleted");
            }else if(test.equals("validate email")){
                System.out.println("Email: ");
                String email = in.nextLine();
                Validator v = new Validator();
                System.out.println(v.validateEmail(email));
            }else if(test.equals("findstaff")){
                System.out.println("ID: ");
                String userID = in.nextLine();
                
                Staff staff = db.findStaff(userID);
                if(staff!=null){
                    System.out.println("staff found: "+staff.getEmail());
                }else{
                    System.out.println("staff not found");
                }
            }else if(test.equals("addstaff")){
                System.out.println("adding staff Jim Bob Jones sales");
                db.addStaff("jimbob@mail.com", "abc123", "Jim", "Jones", "Bob", "sales");
            }
            
            
            connector.closeConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
