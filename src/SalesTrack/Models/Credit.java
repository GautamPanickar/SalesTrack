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
public class Credit {
    
    private int ID;
    private int Company_ID;
    private String Company_Name;
    private Double Amount;
    private Date Date;
    private String Status;
    
    public Credit(int id, int companyID, String companyName, Double amount, Date date, String status)
    {
        this.ID = id;
        this.Company_ID = companyID;
        this.Company_Name = companyName;
        this.Amount = amount;
        this.Date = date;   
        this.Status = status;
    }
    
    public int GetID()
    {
        return this.ID;
    }
    
    public int GetCompanyID()
    {
        return this.Company_ID;
    }
    
    public String GetCompanyName()
    {
        return this.Company_Name;
    }
     
    public Double GetAmount()
    {
        return this.Amount;
    }
    
    public Date GetDate()
    {
        return this.Date;
    }
    
    public String GetStatus()
    {
        return this.Status;
    }
}
