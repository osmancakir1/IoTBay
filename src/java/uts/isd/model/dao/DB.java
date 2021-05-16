/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;
import java.sql.Connection;

/**
 *
 * @author Lewis
 */
public abstract class DB {
//    protected String URL = "jdbc:derby://localhost:1527/";
//    protected String db = "assignmentDB";
//    protected String dbuser = "ISD";
//    protected String dbpass = "asdf";
//    protected String driver = "org.apache.derby.jdbc.ClientDriver";
    protected Connection conn;
    
    
    protected final String serverName = "localhost";
    protected final String dbName = "assignmentDB";
    protected final String portNumber = "1433";
    protected final String userID = "sa";
    protected final String password = "123456";
    protected final String URL = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
}
