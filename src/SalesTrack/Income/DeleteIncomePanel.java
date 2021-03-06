/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesTrack.Income;

import SalesTrack.Stock.*;
import AplicationEnums.Actions;
import Database.IncomeManager;
import Database.StockManager;
import SalesTrack.Models.Income;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author User
 */
public class DeleteIncomePanel extends javax.swing.JPanel {

    
   
   /**
    * The action being made
    */
   private Actions action;
   
   private ArrayList<Income> incomes ;
    /**
     * Creates new form ShortTermCourse
     */
    public DeleteIncomePanel() {
        initComponents();
        this.ShowAllIncomeDetails();
    }

/**
     * Sets the table for displaying all the available incomes
     */
    public  void ShowAllIncomeDetails()
    {
        try{
            DefaultTableModel dm = (DefaultTableModel)DIP_Income_Table.getModel();
            dm.setRowCount(0);
            this.incomes = new IncomeManager().GetAllIncomesAvailable();
            if(null != incomes)
            {
                incomes.stream().forEach((stock) -> 
                {
                    dm.addRow(new Object[]
                    {
                        stock.GetID(),
                        stock.GetName(),
                        stock.GetAmount(),
                        stock.GetDate()
                     });
                });
            }
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    /**
     * Creates a new instance of the panel and sets the course type
     * Also identifies the action being made
     */
 /*   public ViewStockPanel(CourseType type, Actions action) {
        initComponents();
        this.courseType = type;
        this.action = action;  
        this.FilterButtonHolder();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DIP_ItemsHolder_Panel = new javax.swing.JPanel();
        DIP_TableHolder_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DIP_Income_Table = new javax.swing.JTable();
        DeleteIncome_Button = new javax.swing.JButton();
        DIP_search_TF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Delete income details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 11))); // NOI18N

        DIP_ItemsHolder_Panel.setBackground(new java.awt.Color(163, 197, 204));
        DIP_ItemsHolder_Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        DIP_TableHolder_Panel.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setFont(new java.awt.Font("Miriam Fixed", 1, 11)); // NOI18N

        DIP_Income_Table.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        DIP_Income_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "StockID", "StockName"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        DIP_Income_Table.setRowHeight(28);
        DIP_Income_Table.setRowMargin(5);
        jScrollPane1.setViewportView(DIP_Income_Table);

        javax.swing.GroupLayout DIP_TableHolder_PanelLayout = new javax.swing.GroupLayout(DIP_TableHolder_Panel);
        DIP_TableHolder_Panel.setLayout(DIP_TableHolder_PanelLayout);
        DIP_TableHolder_PanelLayout.setHorizontalGroup(
            DIP_TableHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
        );
        DIP_TableHolder_PanelLayout.setVerticalGroup(
            DIP_TableHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DIP_TableHolder_PanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        DeleteIncome_Button.setBackground(new java.awt.Color(255, 51, 51));
        DeleteIncome_Button.setFont(new java.awt.Font("Miriam Fixed", 1, 12)); // NOI18N
        DeleteIncome_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesTrack/Images/delete.png"))); // NOI18N
        DeleteIncome_Button.setText("Delete");
        DeleteIncome_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteIncome_ButtonActionPerformed(evt);
            }
        });

        DIP_search_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        DIP_search_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        DIP_search_TF.setPreferredSize(new java.awt.Dimension(5, 20));
        DIP_search_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                DIP_search_TFKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        jLabel1.setText("Type here to search..");

        javax.swing.GroupLayout DIP_ItemsHolder_PanelLayout = new javax.swing.GroupLayout(DIP_ItemsHolder_Panel);
        DIP_ItemsHolder_Panel.setLayout(DIP_ItemsHolder_PanelLayout);
        DIP_ItemsHolder_PanelLayout.setHorizontalGroup(
            DIP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DIP_ItemsHolder_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DIP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DIP_TableHolder_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DIP_ItemsHolder_PanelLayout.createSequentialGroup()
                        .addComponent(DIP_search_TF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(147, 147, 147)
                        .addComponent(DeleteIncome_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DIP_ItemsHolder_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        DIP_ItemsHolder_PanelLayout.setVerticalGroup(
            DIP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DIP_ItemsHolder_PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DIP_TableHolder_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(8, 8, 8)
                .addGroup(DIP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DeleteIncome_Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DIP_search_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DIP_ItemsHolder_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DIP_ItemsHolder_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteIncome_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteIncome_ButtonActionPerformed
        // Deleting an income
        IncomeManager incomeManager = null;
        ResultSet rs = null;
        int confirm = 0;
        boolean isDeleted = false;
        if(DIP_Income_Table.getSelectedRow() >= 0)
        {
            // Showing a confirmation dialog
            confirm = JOptionPane.showConfirmDialog(null, "Are you sure, that you want to delete the selected income details?");
            
            if (0 == confirm)
            {
                try
                {
                    incomeManager = new IncomeManager();
                    isDeleted = incomeManager.DeleteIncomeDetails(String.valueOf(DIP_Income_Table.getValueAt(DIP_Income_Table.getSelectedRow(), 0)));
                    if(isDeleted)
                    {
                        JOptionPane.showMessageDialog(null, "Record has been deleted...");
                        this.ShowAllIncomeDetails();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Record could not be deleted...");
                    }   
                }
                catch (ClassNotFoundException | SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, " Please select a row to continue...");
        }
    }//GEN-LAST:event_DeleteIncome_ButtonActionPerformed

    private void DIP_search_TFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DIP_search_TFKeyReleased
        // When search words are typed on the search textfield
        IncomeManager incomeManager = null; 
        ResultSet rs = null; 
        
        String searchedValue = DIP_search_TF.getText();
        if( searchedValue.length() > 0 )
        {
            try 
            {
                incomeManager = new IncomeManager();
                rs = incomeManager.GetIncomeDetailsOnSearching(searchedValue);
                if ( null == rs )
                {
                    
                }
                else
                {
                   DIP_Income_Table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                
                // deallocation
                incomeManager.closeConection();
                incomeManager    = null;
                rs         = null;
                
            } 
            catch (ClassNotFoundException | SQLException ex) 
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_DIP_search_TFKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DIP_Income_Table;
    private javax.swing.JPanel DIP_ItemsHolder_Panel;
    private javax.swing.JPanel DIP_TableHolder_Panel;
    private javax.swing.JTextField DIP_search_TF;
    private javax.swing.JButton DeleteIncome_Button;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
