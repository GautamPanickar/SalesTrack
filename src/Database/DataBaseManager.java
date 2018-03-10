/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author arun
 */

// This class maintain all tha database activities
public class DataBaseManager {
    
    private String szDriver          = null;
    private String szDomainAddress   = null;    // Hold domain address for connection
    private String szUserName        = null;
    private String szDomainPassword  = null;    // Hold database password
    
    // connection and query execution variables.
    protected Connection          con  = null;
    protected PreparedStatement   ps   = null;
    protected ResultSet           rs   = null;

    // constructor which initialize 
    // database driver
    // domain address
    // user name of database
    // password
    public DataBaseManager() throws ClassNotFoundException, SQLException 
    {
        szDriver          = "com.mysql.jdbc.Driver";
        szDomainAddress   = "jdbc:mysql://localhost:3306/SalesTrack";
        szUserName        = "root";
        szDomainPassword  = "";
        
        // function to init connection settings
        SetConection();
        
    }
    
    // Connection management
    /***************************************************************************************************/
    // function create a my sql connection
    private void  SetConection()
    {
        try
        {
            // creating a database connection.
            Class.forName( szDriver );
            con=DriverManager.getConnection( szDomainAddress, szUserName, szDomainPassword );
        }
        // database connection error
        catch( SQLException ex )
        {
            JOptionPane.showMessageDialog(null, " Please check the database connection ");
        }
        // driver error
        catch( ClassNotFoundException ex )
        {
            JOptionPane.showMessageDialog(null, " Database driver problem  ");
        }
        
    }
    
    // function to close the connection
    public void closeConection() throws SQLException
    {
        con.close();
    }
    
    
    // public functions to manage database operations
    /*******************************************************************************************************/
    
    /**
     * Validating the user
     * @param username
     * @param password
     * @return 
     */
    public boolean IsUserValid(String username, String password)
    {
        String query = null;
        if (null != username && null != password)
        {
            try
            {
                query = "SELECT 1 FROM USer WHERE Username = ? AND Password = ?";
                ps = con.prepareStatement( query );
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                
                return rs.next();
            }
            catch (SQLException ex) 
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        
        return false;
    }   
}



