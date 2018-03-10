/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import SalesTrack.Models.Credit;
import SalesTrack.Models.Expense;
import SalesTrack.Models.Income;
import SalesTrack.Models.Stock;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class CreditManager extends DataBaseManager{
    
    /**
     * The stock manager constructor
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public CreditManager() throws ClassNotFoundException, SQLException
    {
        super();
    }
    
    /**
     * Adding a new Credit
     * @param newCredit
     * @return 
     */
    public boolean AddCredit(Credit newCredit)
    {
        boolean isCredit = false;
        String query = "INSERT INTO Credit(Credit_Stock_ID, Credit_Stock_Name, Credit_Amount, Credit_Date, Credit_Status) "
                     + "VALUES(?, ?, ?, ?, ?)";
        try 
        {
            ps = con.prepareStatement(query);
            ps.setInt(1, newCredit.GetCompanyID());
            ps.setString(2, newCredit.GetCompanyName());
            ps.setDouble(3, newCredit.GetAmount());
            ps.setDate(4, newCredit.GetDate());
            ps.setString(5, newCredit.GetStatus());
            
            isCredit = ps.executeUpdate() > 0? true: false;
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return isCredit;
    }
    
    /**
     * Gets all available Credit details
     * @return Array list of Credit
     */
    public ArrayList<Credit> GetAllCreditsAvailable()
    {
        ArrayList<Credit> credits = new ArrayList<>();
        String query = "SELECT * FROM Credit ORDER BY Credit_Date DESC";
        try 
        {
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            if(rs.isBeforeFirst())
            {
                while(rs.next())
                {                    
                    /**
                     * constructing stock object.
                     */
                    Credit credit;
                    credit = new Credit
                            (
                            rs.getInt("Credit_ID"),
                            rs.getInt("Credit_Stock_ID"),        
                            rs.getString("Credit_Stock_Name"),
                            rs.getDouble("Credit_Amount"),
                            rs.getDate("Credit_Date"),
                            rs.getString("Credit_Status")
                            );
                    /**
                     * Add to array list of credits
                     */
                    credits.add(credit);
                }
            }
            
       }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return credits;
    }
    
    /**
     * Gets the Credit details as per the search keyword given
     * @param creditName
     * @return resultset of Credit details
     */
    public ResultSet GetCreditDetailsOnSearching(String creditName) 
    {
        String query = null;        
        query = "SELECT * FROM Credit WHERE Credit_Stock_Name LIKE ?";       
        rs = null;
        try 
        {
            ps=con.prepareStatement(query);
            ps.setString(1, '%' + creditName + '%');            
            rs=ps.executeQuery();

        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
        
        return rs;
    }
    
    /**
     * Deletes the Credit details of a given Credit ID
     * @param creditID
     * @return whether expense is deleted or not
     */
    public boolean DeleteCreditDetails(String creditID) 
    {
        String query = null;
        boolean isCreditDeleted = false;        
        query = "DELETE FROM Credit WHERE Credit_ID = ?";           
        try 
        {
            ps = con.prepareStatement(query);   
            ps.setString(1, creditID);
            isCreditDeleted = ps.executeUpdate() > 0? true: false;   
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }        
        
        return isCreditDeleted;
    }
    
    /**
     * Gets all Credit details
     * @return resultset
     */
    public ResultSet GetAllCredits()
    {
        String query = null;        
        query = "SELECT * FROM Credit";       
        rs = null;
        try 
        {
            ps=con.prepareStatement(query);           
            rs=ps.executeQuery();

        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
        
        return rs;
    }
    
    /**
     * Updating a new Credit
     * @param newCredit
     * @return 
     */
    public boolean UpdateCredit(Credit newCredit)
    {
        boolean isCreditUpdated = false;
        String query = "UPDATE Credit "
                     + "SET Credit_Stock_ID = ?,Credit_Stock_Name = ?, Credit_Amount = ?, Credit_Date = ?, Credit_Status = ?"
                     + "WHERE Credit_ID = ?";
        try 
        {
            ps = con.prepareStatement(query);  
            ps.setInt(1, newCredit.GetCompanyID());
            ps.setString(2, newCredit.GetCompanyName());
            ps.setDouble(3, newCredit.GetAmount());
            ps.setDate(4, newCredit.GetDate());
            ps.setString(5, newCredit.GetStatus());
            ps.setInt(6, newCredit.GetID());
            
            isCreditUpdated = ps.executeUpdate() > 0? true: false;
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return isCreditUpdated;
    }
}
