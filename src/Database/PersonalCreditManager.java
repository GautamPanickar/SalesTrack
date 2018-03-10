/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import SalesTrack.Models.Expense;
import SalesTrack.Models.Income;
import SalesTrack.Models.PersonalCredit;
import SalesTrack.Models.Stock;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class PersonalCreditManager extends DataBaseManager{
    
    /**
     * The stock manager constructor
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public PersonalCreditManager() throws ClassNotFoundException, SQLException
    {
        super();
    }
    
    /**
     * Adding a new PersonalCredit
     * @param newPersonalCredit
     * @return 
     */
    public boolean AddPersonalCredit(PersonalCredit newPersonalCredit)
    {
        boolean isCredit = false;
        String query = "INSERT INTO Personal_Credit(Credit_Name, Credit_Amount, Credit_Date) "
                     + "VALUES(?, ?, ?)";
        try 
        {
            ps = con.prepareStatement(query);
            ps.setString(1, newPersonalCredit.GetName());
            ps.setDouble(2, newPersonalCredit.GetAmount());
            ps.setDate(3, newPersonalCredit.GetDate());
            
            isCredit = ps.executeUpdate() > 0? true: false;
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return isCredit;
    }
    
    /**
     * Gets all available PersonalCredits details
     * @return Array list of PersonalCredits
     */
    public ArrayList<PersonalCredit> GetAllPersonalCreditsAvailable()
    {
        ArrayList<PersonalCredit> credit = new ArrayList<>();
        String query = "SELECT * FROM Personal_Credit ORDER BY Credit_Date DESC";
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
                    PersonalCredit pc;
                    pc = new PersonalCredit
                            (
                            rs.getInt("Credit_ID"),
                            rs.getString("Credit_Name"),
                            rs.getDouble("Credit_Amount"),
                            rs.getDate("Credit_Date")
                            );
                    /**
                     * Add to array list of incomes
                     */
                    credit.add(pc);
                }
            }
            
       }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return credit;
    }
    
    /**
     * Gets the PersonalCredit details as per the search keyword given
     * @param personalCreditName
     * @return resultset of PersonalCredit details
     */
    public ResultSet GetPersonalCreditDetailsOnSearching(String personalCreditName) 
    {
        String query = null;        
        query = "SELECT * FROM Personal_Credit WHERE Credit_Name LIKE ?";       
        rs = null;
        try 
        {
            ps=con.prepareStatement(query);
            ps.setString(1, '%' + personalCreditName + '%');            
            rs=ps.executeQuery();

        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
        
        return rs;
    }
    
    /**
     * Deletes the personal credit details of a given expense ID
     * @param creditID
     * @return whether expense is deleted or not
     */
    public boolean DeletePersonalCreditDetails(String creditID) 
    {
        String query = null;
        boolean isExpenseDeleted = false;        
        query = "DELETE FROM Personal_Credit WHERE Credit_ID = ?";           
        try 
        {
            ps = con.prepareStatement(query);   
            ps.setString(1, creditID);
            isExpenseDeleted = ps.executeUpdate() > 0? true: false;   
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }        
        
        return isExpenseDeleted;
    }
    
    /**
     * Gets all expense details
     * @return resultset
     */
    public ResultSet GetAllPersonalCredits()
    {
        String query = null;        
        query = "SELECT * FROM Personal_Credit";       
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
     * Updating a new expense
     * @param newExpense
     * @return 
     */
    public boolean UpdatePersonalCredit(PersonalCredit newExpense)
    {
        boolean isExpenseUpdated = false;
        String query = "UPDATE Personal_Credit "
                     + "SET Credit_Name = ?, Credit_Amount = ?, Credit_Date = ? "
                     + "WHERE Credit_ID = ?";
        try 
        {
            ps = con.prepareStatement(query);            
            ps.setString(1, newExpense.GetName());
            ps.setDouble(2, newExpense.GetAmount());
            ps.setDate(3, newExpense.GetDate());
            ps.setInt(4, newExpense.GetID());
            
            isExpenseUpdated = ps.executeUpdate() > 0? true: false;
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return isExpenseUpdated;
    }
    
    /**
     *  Gets all Cpersonal redit details on a particular date
     * @param date
     * @return resultset
     */
    public ResultSet GetAllPersonalCreditsOnDate(Date date)
    {
        String query = null;        
        query = "SELECT * FROM Personal_Credit "
                + "WHERE Credit_Date = ?";       
        rs = null;
        try 
        {
            ps=con.prepareStatement(query);   
            ps.setDate(1, date);
            rs=ps.executeQuery();

        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
        
        return rs;
    }
}
