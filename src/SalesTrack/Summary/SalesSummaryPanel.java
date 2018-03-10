/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesTrack.Summary;

import AplicationEnums.Actions;
import Database.SalesManager;
import SalesTrack.Models.Sales;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author User
 */
public class SalesSummaryPanel extends javax.swing.JPanel {

    
   
   /**
    * The action being made
    */
   private Actions action;
   
    private ArrayList<Sales> sales ;
    /**
     * Creates new form ShortTermCourse
     */
    public SalesSummaryPanel() {
        initComponents();
        this.ShowAllSalesDetails();
    }

    /**
     * Sets the table for displaying all the available expenses
     */
    public  void ShowAllSalesDetails()
    {
        try{
            DefaultTableModel dm = (DefaultTableModel)SSP_Summary_Table.getModel();
            dm.setRowCount(0);
            this.sales = new SalesManager().GetAllSalesAvailable();
            if(null != sales)
            {
                sales.stream().forEach((sale) -> 
                {
                    dm.addRow(new Object[]
                    {
                        sale.GetID(),
                        sale.GetStockID(),
                        sale.GetStockName(),
                        sale.GetQuantity(),
                        sale.GetAmount(),
                        sale.GetGST(),
                        sale.GetFinalAmount(),
                        sale.GetDate()
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
 /*   public ViewSalesPanel(CourseType type, Actions action) {
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

        VS_ItemsHolder_Panel = new javax.swing.JPanel();
        VS_TableHolder_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        SSP_Summary_Table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        SSP_DateChooser = new com.toedter.calendar.JDateChooser();
        SSP_Summary_Button = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "View sales details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 11))); // NOI18N

        VS_ItemsHolder_Panel.setBackground(new java.awt.Color(163, 197, 204));
        VS_ItemsHolder_Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        VS_TableHolder_Panel.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setFont(new java.awt.Font("Miriam Fixed", 1, 11)); // NOI18N

        SSP_Summary_Table.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        SSP_Summary_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sales ID", "Stock ID", "Stock name", "Quantity", "Amount", "GST", "Final amount", "Sold date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        SSP_Summary_Table.setRowHeight(28);
        SSP_Summary_Table.setRowMargin(5);
        jScrollPane1.setViewportView(SSP_Summary_Table);

        javax.swing.GroupLayout VS_TableHolder_PanelLayout = new javax.swing.GroupLayout(VS_TableHolder_Panel);
        VS_TableHolder_Panel.setLayout(VS_TableHolder_PanelLayout);
        VS_TableHolder_PanelLayout.setHorizontalGroup(
            VS_TableHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
        );
        VS_TableHolder_PanelLayout.setVerticalGroup(
            VS_TableHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        jLabel1.setText("Choose date");

        SSP_Summary_Button.setBackground(new java.awt.Color(51, 153, 0));
        SSP_Summary_Button.setFont(new java.awt.Font("Miriam Fixed", 1, 14)); // NOI18N
        SSP_Summary_Button.setForeground(new java.awt.Color(255, 255, 255));
        SSP_Summary_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesTrack/Images/summarry.png"))); // NOI18N
        SSP_Summary_Button.setText("Show summary");
        SSP_Summary_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SSP_Summary_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout VS_ItemsHolder_PanelLayout = new javax.swing.GroupLayout(VS_ItemsHolder_Panel);
        VS_ItemsHolder_Panel.setLayout(VS_ItemsHolder_PanelLayout);
        VS_ItemsHolder_PanelLayout.setHorizontalGroup(
            VS_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VS_ItemsHolder_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VS_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VS_TableHolder_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(VS_ItemsHolder_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(SSP_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SSP_Summary_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)))
                .addContainerGap())
        );
        VS_ItemsHolder_PanelLayout.setVerticalGroup(
            VS_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VS_ItemsHolder_PanelLayout.createSequentialGroup()
                .addGroup(VS_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VS_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(VS_ItemsHolder_PanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(SSP_Summary_Button))
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SSP_DateChooser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VS_TableHolder_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VS_ItemsHolder_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VS_ItemsHolder_Panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SSP_Summary_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SSP_Summary_ButtonActionPerformed
        java.sql.Date date =  new java.sql.Date(SSP_DateChooser.getDate().getTime());
        ResultSet rs = null;
        if (((JTextField)SSP_DateChooser.getDateEditor().getUiComponent()).getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Date field cannot be empty!");
        }
        else
        {
            try 
            {
                SalesManager manager = new SalesManager();
                rs = manager.GetAllSalesOnDate(date);
                if ( null == rs )
                {
                    
                }
                else
                {
                   SSP_Summary_Table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                
                // deallocation
                manager.closeConection();
                manager    = null;
                rs         = null;
                
            } 
            catch (ClassNotFoundException | SQLException ex) 
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_SSP_Summary_ButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser SSP_DateChooser;
    private javax.swing.JButton SSP_Summary_Button;
    private javax.swing.JTable SSP_Summary_Table;
    private javax.swing.JPanel VS_ItemsHolder_Panel;
    private javax.swing.JPanel VS_TableHolder_Panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}