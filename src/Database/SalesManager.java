/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import SalesTrack.Models.Sales;
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
public class SalesManager extends DataBaseManager{
    
    /**
     * The stock manager constructor
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public SalesManager() throws ClassNotFoundException, SQLException
    {
        super();
    }
    
    /**
     * Adding a new Sale
     * @param newSales
     * @return true or false
     */
    public boolean AddSales(Sales newSales)
    {
        boolean isSaleAdded = false,isQuantityUpdated = false;
        int currentStockQuantity = 0, toBeUpdatedStockQuantity = 0;
        String query = "INSERT INTO Purchase(Purchase_Stock_ID, Purchase_Stock_Name, Purchase_Quantity, Purchase_Amount, Purchase_GST, Purchase_Final_Amount, Purchase_Date) "
                     + "VALUES(?, ?, ?, ?, ?, ?, ?)";
        
        String updateStockQuery = null;                
        try
        {
            StockManager stockManager = new StockManager();            
            currentStockQuantity = stockManager.GetQuantityForStock(newSales.GetStockID());
            toBeUpdatedStockQuantity = currentStockQuantity - newSales.GetQuantity();
            if (toBeUpdatedStockQuantity >= 0)
            {
                try 
                {
                    ps = con.prepareStatement(query);
                    ps.setInt(1, newSales.GetStockID());
                    ps.setString(2, newSales.GetStockName());
                    ps.setInt(3, newSales.GetQuantity());
                    ps.setDouble(4, newSales.GetAmount());
                    ps.setDouble(5, newSales.GetGST());
                    ps.setDouble(6, newSales.GetFinalAmount());
                    ps.setDate(7, newSales.GetDate());

                    isSaleAdded = ps.executeUpdate() > 0? true: false;

                    // Logic to update the stock
                    if (isSaleAdded)
                    {   
                        isQuantityUpdated = stockManager.UpdateStockQuantity(newSales.GetStockID(), toBeUpdatedStockQuantity)? true: false;
                    }

                    //deallocation
                    stockManager = null;
                }
                catch (SQLException ex) 
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Not enough stock available!");
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        
        
        return isSaleAdded && isQuantityUpdated;
    }
    
    /**
     * Gets all available Sales details
     * @return Array list of sales
     */
    public ArrayList<Sales> GetAllSalesAvailable()
    {
        ArrayList<Sales> sales = new ArrayList<>();
        String query = "SELECT * FROM Purchase ORDER BY Purchase_Date DESC";
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
                    Sales sale;
                    sale = new Sales
                            (
                            rs.getInt("Purchase_ID"),
                            rs.getInt("Purchase_Stock_ID"),
                            rs.getString("Purchase_Stock_Name"),
                            rs.getInt("Purchase_Quantity"),
                            rs.getDouble("Purchase_Amount"),
                            rs.getDouble("Purchase_GST"),
                            rs.getDouble("Purchase_Final_Amount"),
                            rs.getDate("Purchase_Date")
                            );
                    /**
                     * Add to array list of sales
                     */
                    sales.add(sale);
                }
            }
            
       }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return sales;
    }
    
    /**
     * Gets the sales details as per the search keyword given
     * @param stockName
     * @return resultset of sales details
     */
    public ResultSet GetSalesDetailsOnSearching(String stockName) 
    {
        String query = null;        
        query = "SELECT * FROM Purchase WHERE Purchase_Stock_Name LIKE ?";       
        rs = null;
        try 
        {
            ps=con.prepareStatement(query);
            ps.setString(1, '%' + stockName + '%');            
            rs=ps.executeQuery();

        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
        
        return rs;
    }
    
    /**
     * Deletes the stock details of a given sales ID
     * @param salesID
     * @return whether sales is deleted or not
     */
    public boolean DeleteSalesDetails(String salesID) 
    {
        String query = null;
        boolean isSalesDeleted = false;        
        query = "DELETE FROM Sales WHERE Purchase_ID = ?";           
        try 
        {
            ps = con.prepareStatement(query);   
            ps.setString(1, salesID);
            isSalesDeleted = ps.executeUpdate() > 0? true: false;   
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }        
        
        return isSalesDeleted;
    }
    
    /**
     * Gets all sales details
     * @return resultset
     */
    public ResultSet GetAllSales()
    {
        String query = null;        
        query = "SELECT * FROM Purchase";       
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
     * Adding a new sale
     * @param newSale
     * @return 
     */
    public boolean UpdateSales(Sales newSale)
    {
        boolean isSalesUpdated = false;
        String query = "UPDATE Purchase "
                     + "SET Purchase_Stock_ID = ?, Purchase_Stock_Name = ?, Purchase_Quantity = ?, Purchase_Amount = ?, Purchase_GST = ?, Purchase_Final_Amount = ?, Purchase_Date = ? "
                     + "WHERE Purchase_ID = ?";
        try 
        {
            ps = con.prepareStatement(query);            
            ps.setInt(1, newSale.GetStockID());
            ps.setString(2, newSale.GetStockName());
            ps.setInt(3, newSale.GetQuantity());
            ps.setDouble(4, newSale.GetAmount());
            ps.setDouble(5, newSale.GetGST());
            ps.setDouble(6, newSale.GetFinalAmount());
            ps.setDate(7, newSale.GetDate());
            ps.setInt(8, newSale.GetID());
            
            isSalesUpdated = ps.executeUpdate() > 0? true: false;
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return isSalesUpdated;
    }
    
    /**
     *  Gets all sales details on a particular date
     * @param date
     * @return resultset
     */
    public ResultSet GetAllSalesOnDate(Date date)
    {
        String query = null;        
        query = "SELECT * FROM Purchase "
                + "WHERE Purchase_Date = ?";       
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
