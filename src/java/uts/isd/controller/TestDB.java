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
            System.out.println("Test no:");
            String test = in.nextLine();
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
            }
            
            
            connector.closeConnection();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
