/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import SalesTrack.Models.Stock;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class StockManager extends DataBaseManager{
    
    /**
     * The stock manager constructor
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public StockManager() throws ClassNotFoundException, SQLException
    {
        super();
    }
    
    /**
     * Adding a new stock
     * @param newStock
     * @return 
     */
    public boolean AddStock(Stock newStock)
    {
        boolean isStockAdded = false;
        String query = "INSERT INTO Stock(Stock_Name, Stock_Model_No, Stock_Quantity, Stock_Price_Per_Piece, Stock_Total_Price, Stock_Date) "
                     + "VALUES(?, ?, ?, ?, ?, ?)";
        try 
        {
            ps = con.prepareStatement(query);
            ps.setString(1, newStock.GetName());
            ps.setString(2, newStock.GetModelNo());
            ps.setInt(3, newStock.GetQuantity());
            ps.setDouble(4, newStock.GetPricePerPiece());
            ps.setDouble(5, newStock.GetTotalPrice());
            ps.setDate(6, newStock.GetDate());
            
            isStockAdded = ps.executeUpdate() > 0? true: false;
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return isStockAdded;
    }
    
    /**
     * Gets all available stock details
     * @return Array list of stocks
     */
    public ArrayList<Stock> GetAllStocksAvailable()
    {
        ArrayList<Stock> stocks = new ArrayList<>();
        String query = "SELECT * FROM Stock ORDER BY Stock_Date DESC";
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
                    Stock stock;
                    stock = new Stock
                            (
                            rs.getInt("Stock_ID"),
                            rs.getString("Stock_Name"),
                            rs.getString("Stock_Model_No"),
                            rs.getInt("Stock_Quantity"),
                            rs.getDouble("Stock_Price_Per_Piece"),
                            rs.getDouble("Stock_Total_Price"),
                            rs.getDate("Stock_Date")
                            );
                    /**
                     * Add to array list of stocks
                     */
                    stocks.add(stock);
                }
            }
            
       }
        catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return stocks;
    }
    
    /**
     * Gets the stock details as per the search keyword given
     * @param stockName
     * @return resultset of stock details
     */
    public ResultSet GetStockDetailsOnSearching(String stockName) 
    {
        String query = null;        
        query = "SELECT * FROM Stock WHERE Stock_Name LIKE ?";       
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
     * Deletes the stock details of a given stock ID
     * @param stockID
     * @return whether stock is deleted or not
     */
    public boolean DeleteStockDetails(String stockID) 
    {
        String query = null;
        boolean isStockDeleted = false;        
        query = "DELETE FROM Stock WHERE Stock_ID = ?";           
        try 
        {
            ps = con.prepareStatement(query);   
            ps.setString(1, stockID);
            isStockDeleted = ps.executeUpdate() > 0? true: false;   
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }        
        
        return isStockDeleted;
    }
    
    /**
     * Gets all stock details
     * @return resultset
     */
    public ResultSet GetAllStocks()
    {
        String query = null;        
        query = "SELECT * FROM Stock";       
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
     * Adding a new stock
     * @param newStock
     * @return 
     */
    public boolean UpdateStock(Stock newStock)
    {
        boolean isStockUpdated = false;
        String query = "UPDATE Stock "
                     + "SET Stock_Name = ?, Stock_Model_No = ?, Stock_Quantity = ?, Stock_Price_Per_Piece = ?, Stock_Total_Price = ?, Stock_Date = ? "
                     + "WHERE Stock_ID = ?";
        try 
        {
            ps = con.prepareStatement(query);            
            ps.setString(1, newStock.GetName());
            ps.setString(2, newStock.GetModelNo());
            ps.setInt(3, newStock.GetQuantity());
            ps.setDouble(4, newStock.GetPricePerPiece());
            ps.setDouble(5, newStock.GetTotalPrice());
            ps.setDate(6, newStock.GetDate());
            ps.setInt(7, newStock.GetID());
            
            isStockUpdated = ps.executeUpdate() > 0? true: false;
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return isStockUpdated;
    }
    
    /**
     * Gets the quantity of a given stock
     * @param stockID
     * @return the quantity
     */
    public int GetQuantityForStock(int stockID)
    {
        String query = null;        
        query = "SELECT Stock_Quantity FROM Stock WHERE Stock_ID = ?";  
        int quantity = 0;
        rs = null;
        try 
        {
            ps=con.prepareStatement(query);  
            ps.setInt(1, stockID);
            rs=ps.executeQuery();
            if(rs.next())
            {
                quantity = rs.getInt("Stock_Quantity");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
        
        return quantity;
    }
    
    /**
     * Updates the quantity of the stock
     * @param stockID
     * @param stockQuantity
     * @return boolean on whether stock quantity is updated or not
     */
    public boolean UpdateStockQuantity(int stockID, int stockQuantity)
    {
        boolean isStockQuantityUpdated = false;
        String query = "UPDATE Stock "
                     + "SET Stock_Quantity = ? "
                     + "WHERE Stock_ID = ?";
        try 
        {
            ps = con.prepareStatement(query);            
            ps.setInt(1, stockQuantity);
            ps.setInt(2, stockID);
            
            isStockQuantityUpdated = ps.executeUpdate() > 0? true: false;
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return isStockQuantityUpdated;
    }
    
    /**
     * Copies stock from main table to temp
     */
    public void CopyStockToTemp()
    {
        String truncateQuery = "TRUNCATE TABLE Temporary_Stock";
        String query = "INSERT INTO Temporary_Stock SELECT * FROM Stock";
        try 
        {
            ps = con.prepareStatement(truncateQuery);            
            if (ps.executeUpdate() >= 0)
            {
                ps = con.prepareStatement(query);  
                ps.executeUpdate();
            }
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }        
    }
    
    /**
     * Gets all temporary stock details
     * @return resultset
     */
    public ResultSet GetAllTemporaryStocks()
    {
        String query = null;        
        query = "SELECT * FROM Temporary_Stock";       
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
     * Gets the temp stock details as per the search keyword given
     * @param stockName
     * @return resultset of stock details
     */
    public ResultSet GetTempStockDetailsOnSearching(String stockName) 
    {
        String query = null;        
        query = "SELECT * FROM Temporary_Stock WHERE Stock_Name LIKE ?";       
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
     * Gets the quantity of a given temp stock
     * @param stockID
     * @return the quantity
     */
    public int GetQuantityForTempStock(int stockID)
    {
        String query = null;        
        query = "SELECT Stock_Quantity FROM Temporary_Stock WHERE Stock_ID = ?";  
        int quantity = 0;
        rs = null;
        try 
        {
            ps=con.prepareStatement(query);  
            ps.setInt(1, stockID);
            rs=ps.executeQuery();
            if(rs.next())
            {
                quantity = rs.getInt("Stock_Quantity");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
        
        return quantity;
    }
    
    /**
     * Updates the quantity of the stock
     * @param stockID
     * @param stockQuantity
     * @return boolean on whether stock quantity is updated or not
     */
    public boolean UpdateTempStockQuantity(int stockID, int stockQuantity)
    {
        boolean isStockQuantityUpdated = false;
        String query = "UPDATE Temporary_Stock "
                     + "SET Stock_Quantity = ? "
                     + "WHERE Stock_ID = ?";
        try 
        {
            ps = con.prepareStatement(query);            
            ps.setInt(1, stockQuantity);
            ps.setInt(2, stockID);
            
            isStockQuantityUpdated = ps.executeUpdate() > 0? true: false;
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return isStockQuantityUpdated;
    }
    
    /**
     * Gets the company id of a given company name
     * @param name
     * @return the company id
     */
    public int GetCompanyIDForStock(String name)
    {
        String query = null;        
        query = "SELECT Company_ID FROM Stock_To_Company_Mapping WHERE Company_Name = ?";  
        int id = 0;
        rs = null;
        try 
        {
            ps=con.prepareStatement(query);  
            ps.setString(1, name);
            rs=ps.executeQuery();
            if(rs.next())
            {
                id = rs.getInt("Company_ID");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
        
        return id;
    }
    
    public Double GetCompanyAmountForStock(int id)
    {
        String query = null;        
        query = "SELECT Company_Amount FROM Stock_To_Company_Mapping WHERE Company_ID = ?";  
        Double amount = 0.0;
        rs = null;
        try 
        {
            ps=con.prepareStatement(query);  
            ps.setInt(1, id);
            rs=ps.executeQuery();
            if(rs.next())
            {
                amount = rs.getDouble("Company_Amount");
            }
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } 
        
        return amount;
    }
    
    /**
     * Mapping the added stock to company
     * @param newStock
     * @return 
     */
    public boolean MapStockToCompany(Stock newStock)
    {
        boolean isMapped = false;
        int rowCount = 0, companyID = 0;
        Double newAmount = 0.0, currentAmount =0.0;
        String companyName = newStock.GetName();
        String validationQuery = "SELECT COUNT(*) AS Count FROM Stock_To_Company_Mapping WHERE "
                                + "Company_Name = ?";
        String query = "INSERT INTO Stock_To_Company_Mapping(Company_Name, Company_Amount, Company_Date) "
                     + "VALUES(?, ?, ?)";
        String updateQuery = "UPDATE Stock_To_Company_Mapping "
                            + "SET Company_Amount = ?, Company_Date = ? "
                            + "WHERE Company_ID = ?";
        try 
        {
            ps = con.prepareStatement(validationQuery);
            ps.setString(1, companyName);
            rs=ps.executeQuery();
            if(rs.next())
            {
                rowCount = rs.getInt("Count");
            }
            
            // Validating wether an entry for the company already exists
            if (rowCount == 1)
            {
                // If this is the case then an update need to be performed with new amount
                companyID = this.GetCompanyIDForStock(companyName);
                currentAmount =this.GetCompanyAmountForStock(companyID);
                newAmount = newStock.GetTotalPrice() + currentAmount;
                ps = con.prepareStatement(updateQuery);
                ps.setDouble(1, newAmount);
                ps.setDate(2, newStock.GetDate());
                ps.setDouble(3, companyID);

                isMapped = ps.executeUpdate() > 0? true: false;
            }
            else if (rowCount <= 0)
            {
                // If this is the case then a new row needs to be inserted.
                ps = con.prepareStatement(query);
                ps.setString(1, companyName);
                ps.setDouble(2, newStock.GetTotalPrice());
                ps.setDate(3, newStock.GetDate());

                isMapped = ps.executeUpdate() > 0? true: false;
            }
            else if (rowCount > 1)
            {
                JOptionPane.showMessageDialog(null, "Duplicate entry exists in company to stock mapping!");
            }
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return isMapped;
    }
    
    /**
     * Update stock to company mapping
     * @param newStock
     * @param IsNameUpdated
     * @return 
     */
    public boolean UpdateStockToCompanyMap(Stock newStock, boolean isNameUpdated, boolean isAmountUpdated, int companyID)
    {
        boolean isUpdated = false;
        String updateNameQuery = "UPDATE Stock_To_Company_Mapping "
                            + "SET Company_Name = ?, Company_Date = ? "
                            + "WHERE Company_ID = ?";
        String updateAmountQuery = "UPDATE Stock_To_Company_Mapping "
                            + "SET Company_Amount = ?, Company_Date = ? "
                            + "WHERE Company_ID = ?";
        try 
        {
            if (isNameUpdated)
            {
                ps = con.prepareStatement(updateNameQuery);
                ps.setString(1, newStock.GetName());
                ps.setDate(2, newStock.GetDate());
                ps.setInt(3, companyID);
                
                isUpdated = ps.executeUpdate() > 0? true: false;
            }
            else if(isAmountUpdated)
            {
                ps = con.prepareStatement(updateAmountQuery);
                ps.setDouble(1, newStock.GetTotalPrice());
                ps.setDate(2, newStock.GetDate());
                ps.setInt(3, companyID);
                
                isUpdated = ps.executeUpdate() > 0? true: false;
            }
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return isUpdated;
    }
    
    /**
     * Gets all company to stock mapping details
     * @return resultset
     */
    public ResultSet GetAllStockToCompanyMAappings()
    {
        String query = null;        
        query = "SELECT * FROM Stock_To_Company_Mapping";       
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
     * Updates the stock to company map with a new amount
     * @param companyID
     * @param amount
     * @return boolean on whether the map has been updated or not
     */
    public boolean UpdateStockToCompanyMapAmount(int companyID, Double amount)
    {
        boolean isMapUpdated = false;
        String query = "UPDATE Stock_To_Company_Mapping "
                     + "SET Company_Amount = ? "
                     + "WHERE Company_ID = ?";
        try 
        {
            ps = con.prepareStatement(query);            
            ps.setDouble(1, amount);
            ps.setInt(2, companyID);
            
            isMapUpdated = ps.executeUpdate() > 0? true: false;
        }
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return isMapUpdated;
    }
}
