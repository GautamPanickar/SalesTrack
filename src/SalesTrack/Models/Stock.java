/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesTrack.Models;

import java.sql.Date;

/**
 *
 * @author User
 */
public class Stock {
    
    private int ID;
    private String Name;
    private String Model_No;
    private int Quantity;
    private Double Price_Per_Piece;
    private Double Total_Price;
    private Date Date;
    
    public Stock()
    {
        this.ID = 0;
        this.Name = null;
        this.Model_No = null;
        this.Quantity = 0;
        this.Price_Per_Piece = 0.0;
        this.Total_Price = 0.0;
        this.Date = null;
    }
    
    public Stock(int id, String name, String modelNo, int quantity, Double pricePerPiece, Double totalPrice, Date date)
    {
        this.ID = id;
        this.Name = name;
        this.Model_No = modelNo;
        this.Quantity = quantity;
        this.Price_Per_Piece = pricePerPiece;
        this.Total_Price = totalPrice;
        this.Date = date;        
    }
    
    public int GetID()
    {
        return this.ID;
    }
    
    public String GetName()
    {
        return this.Name;
    }
    
    public String GetModelNo()
    {
        return this.Model_No;
    }
    
    public int GetQuantity()
    {
        return this.Quantity;
    }
    
    public Double GetPricePerPiece()
    {
        return this.Price_Per_Piece;
    }
    
    public Double GetTotalPrice()
    {
        return this.Total_Price;
    }
    
    public Date GetDate()
    {
        return this.Date;
    }
    
    public void SetID(int id)
    {
        this.ID = id;
    }
    
    public void SetName(String name)
    {
        this.Name = name;
    }
    
    public void SetModelNo(String modelno)
    {
        this.Model_No = modelno;
    }
    
    public void SetQuantity(int quantity)
    {
        this.Quantity = quantity;
    }
    
    public void SetPricePerPiece(Double ppp)
    {
        this.Price_Per_Piece = ppp;
    }
    
    public void SetTotalPrice(Double tp)
    {
        this.Total_Price = tp; 
    }
    
    public void SetDate(Date date)
    {
        this.Date = date;
    }
}
