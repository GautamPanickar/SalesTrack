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
public class Income {
    
    private int ID;
    private String Name;
    private Double Amount;
    private Date Date;
    
    public Income(int id, String name, Double amount, Date date)
    {
        this.ID = id;
        this.Name = name;
        this.Amount = amount;
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
     
    public Double GetAmount()
    {
        return this.Amount;
    }
    
    public Date GetDate()
    {
        return this.Date;
    }
}
