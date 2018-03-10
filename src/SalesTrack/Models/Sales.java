/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesTrack.Models;

import java.sql.Date;

/**
 *
 * @author Panickar
 */
public class Sales {
    
    private int ID;
    private int Stock_ID;
    private String Stock_Name;
    private int Quantity;
    private Double Amount;
    private Double GST;
    private Double Final_Amount;
    private Date Date;
    
    public Sales()
    {
        this.ID = 0;
        this.Stock_ID = 0;
        this.Stock_Name = null;
        this.Quantity = 0;
        this.Amount = 0.0;
        this.GST = 0.0;
        this.Final_Amount = 0.0;
        this.Date = null;   
    }
    
    public Sales(int id, int stockID, String stockName, int quantity, Double amount, Double gst, Double finalAmount, Date date)
    {
        this.ID = id;
        this.Stock_ID = stockID;
        this.Stock_Name = stockName;
        this.Quantity = quantity;
        this.Amount = amount;
        this.GST = gst;
        this.Final_Amount = finalAmount;
        this.Date = date;   
    }
    
    public int GetID()
    {
        return this.ID;
    }
    
    public int GetStockID()
    {
        return this.Stock_ID;
    }
    
    public String GetStockName()
    {
        return this.Stock_Name;
    }
    
    public int GetQuantity()
    {
        return this.Quantity;
    }
    
    public Double GetAmount()
    {
        return this.Amount;
    }
    
    public Double GetGST()
    {
        return this.GST;
    }
    
    public Double GetFinalAmount()
    {
        return this.Final_Amount;
    }
    
    public Date GetDate()
    {
        return this.Date;
    }
    
    public void SetID(int id)
    {
        this.ID = id;
    }
    
    public void SetStockID(int stockID)
    {
        this.Stock_ID = stockID;
    }
    
    public void  SetStockName(String stockName)
    {
        this.Stock_Name = stockName;
    }
    
    public void SetQuantity(int quantity)
    {
        this.Quantity = quantity;
    }
    
    public void SetAmount(Double amount)
    {
        this.Amount = amount;
    }
    
    public void SetGST(Double gst)
    {
        this.GST = gst;
    }
    
    public void SetFinalAmount(Double finalAmount)
    {
        this.Final_Amount = finalAmount;
    }
    
    public void SetDate(Date date)
    {
        this.Date = date;
    }
}
