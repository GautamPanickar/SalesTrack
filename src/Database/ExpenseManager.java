/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import SalesTrack.Models.Expense;
import SalesTrack.Models.Income;
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
public class ExpenseManager extends DataBaseManager{
    
    /**
     * The stock manager constructor
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public ExpenseManager() throws ClassNotFoundException, SQLException
    {
        super();
    }
    
    /**
     * Adding a new Expense
     * @param newExpense
     * @return 
     */
    public boolean AddExpense(Expense newExpense)
    {
        boolean isExpense = false;
        String query = "INSERT INTO Expense(Expense_Name, Expense_Amount, Expense_Date) "
                     + "VALUES(?, ?, ?)";
        try 
        {
            ps = con.prepareStatement(query);
            ps.setString(1, newExpense.GetName());
            ps.setDouble(2, newExpense.GetAmount());
            ps.setDate(3, newExpense.GetDate());
            
            isExpense = ps.executeUpdate() > 0? true: false;
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return isExpense;
    }
    
    /**
     * Gets all available expense details
     * @return Array list of expense
     */
    public ArrayList<Expense> GetAllExpensesAvailable()
    {
        ArrayList<Expense> expenses = new ArrayList<>();
        String query = "SELECT * FROM Expense ORDER BY Expense_Date DESC";
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
                    Expense expense;
                    expense = new Expense
                            (
                            rs.getInt("Expense_ID"),
                            rs.getString("Expense_Name"),
                            rs.getDouble("Expense_Amount"),
                            rs.getDate("Expense_Date")
                            );
                    /**
                     * Add to array list of incomes
                     */
                    expenses.add(expense);
                }
            }
            
       }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return expenses;
    }
    
    /**
     * Gets the expense details as per the search keyword given
     * @param expenseName
     * @return resultset of expense details
     */
    public ResultSet GetExpenseDetailsOnSearching(String expenseName) 
    {
        String query = null;        
        query = "SELECT * FROM Expense WHERE Expense_Name LIKE ?";       
        rs = null;
        try 
        {
            ps=con.prepareStatement(query);
            ps.setString(1, '%' + expenseName + '%');            
            rs=ps.executeQuery();

        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
        
        return rs;
    }
    
    /**
     * Deletes the expense details of a given expense ID
     * @param expenseID
     * @return whether expense is deleted or not
     */
    public boolean DeleteExpenseDetails(String expenseID) 
    {
        String query = null;
        boolean isExpenseDeleted = false;        
        query = "DELETE FROM Expense WHERE Expense_ID = ?";           
        try 
        {
            ps = con.prepareStatement(query);   
            ps.setString(1, expenseID);
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
    public ResultSet GetAllExpenses()
    {
        String query = null;        
        query = "SELECT * FROM Expense";       
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
    public boolean UpdateExpense(Expense newExpense)
    {
        boolean isExpenseUpdated = false;
        String query = "UPDATE Expense "
                     + "SET Expense_Name = ?, Expense_Amount = ?, Expense_Date = ? "
                     + "WHERE Expense_ID = ?";
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
     *  Gets all expense details on a particular date
     * @param date
     * @return resultset
     */
    public ResultSet GetAllExpensesOnDate(Date date)
    {
        String query = null;        
        query = "SELECT * FROM Expense "
                + "WHERE Expense_Date = ?";       
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
