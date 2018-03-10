/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

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
public class IncomeManager extends DataBaseManager{
    
    /**
     * The stock manager constructor
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public IncomeManager() throws ClassNotFoundException, SQLException
    {
        super();
    }
    
    /**
     * Adding a new Income
     * @param newIncome
     * @return 
     */
    public boolean AddIncome(Income newIncome)
    {
        boolean isIncome = false;
        String query = "INSERT INTO Income(Income_Name, Income_Amount, Income_Date) "
                     + "VALUES(?, ?, ?)";
        try 
        {
            ps = con.prepareStatement(query);
            ps.setString(1, newIncome.GetName());
            ps.setDouble(2, newIncome.GetAmount());
            ps.setDate(3, newIncome.GetDate());
            
            isIncome = ps.executeUpdate() > 0? true: false;
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return isIncome;
    }
    
    /**
     * Gets all available income details
     * @return Array list of income
     */
    public ArrayList<Income> GetAllIncomesAvailable()
    {
        ArrayList<Income> incomes = new ArrayList<>();
        String query = "SELECT * FROM Income ORDER BY Income_Date DESC";
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
                    Income income;
                    income = new Income
                            (
                            rs.getInt("Income_ID"),
                            rs.getString("Income_Name"),
                            rs.getDouble("Income_Amount"),
                            rs.getDate("Income_Date")
                            );
                    /**
                     * Add to array list of incomes
                     */
                    incomes.add(income);
                }
            }
            
       }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return incomes;
    }
    
    /**
     * Gets the income details as per the search keyword given
     * @param incomeName
     * @return resultset of income details
     */
    public ResultSet GetIncomeDetailsOnSearching(String incomeName) 
    {
        String query = null;        
        query = "SELECT * FROM Income WHERE Income_Name LIKE ?";       
        rs = null;
        try 
        {
            ps=con.prepareStatement(query);
            ps.setString(1, '%' + incomeName + '%');            
            rs=ps.executeQuery();

        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
        
        return rs;
    }
    
    /**
     * Deletes the income details of a given income ID
     * @param incomeID
     * @return whether stock is deleted or not
     */
    public boolean DeleteIncomeDetails(String incomeID) 
    {
        String query = null;
        boolean isIncomeDeleted = false;        
        query = "DELETE FROM Income WHERE Income_ID = ?";           
        try 
        {
            ps = con.prepareStatement(query);   
            ps.setString(1, incomeID);
            isIncomeDeleted = ps.executeUpdate() > 0? true: false;   
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }        
        
        return isIncomeDeleted;
    }
    
    /**
     * Gets all income details
     * @return resultset
     */
    public ResultSet GetAllIncomes()
    {
        String query = null;        
        query = "SELECT * FROM Income";       
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
     * Adding a new income
     * @param newIncome
     * @return 
     */
    public boolean UpdateIncome(Income newIncome)
    {
        boolean isIncomeUpdated = false;
        String query = "UPDATE Income "
                     + "SET Income_Name = ?, Income_Amount = ?, Income_Date = ? "
                     + "WHERE Income_ID = ?";
        try 
        {
            ps = con.prepareStatement(query);            
            ps.setString(1, newIncome.GetName());
            ps.setDouble(2, newIncome.GetAmount());
            ps.setDate(3, newIncome.GetDate());
            ps.setInt(4, newIncome.GetID());
            
            isIncomeUpdated = ps.executeUpdate() > 0? true: false;
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return isIncomeUpdated;
    }
}
