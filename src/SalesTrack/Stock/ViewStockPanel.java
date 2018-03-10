/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesTrack.Stock;

import AplicationEnums.Actions;
import Database.StockManager;
import SalesTrack.Models.Stock;
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
public class ViewStockPanel extends javax.swing.JPanel {

    
   
   /**
    * The action being made
    */
   private Actions action;
   
    private ArrayList<Stock> stocks ;
   
    /**
     * Creates new form ShortTermCourse
     */
    public ViewStockPanel() {
        initComponents();
        this.ShowAllStockDetails();        
    }

    /**
     * Sets the table for displaying all the available stocks
     */
    public  void ShowAllStockDetails()
    {
        try{
            DefaultTableModel dm = (DefaultTableModel)VS_Stock_Table.getModel();
            dm.setRowCount(0);
            this.stocks = new StockManager().GetAllStocksAvailable();
            if(null != stocks)
            {
                stocks.stream().forEach((stock) -> 
                {
                    dm.addRow(new Object[]
                    {
                        stock.GetID(),
                        stock.GetName(),
                        stock.GetModelNo(),
                        stock.GetQuantity(),
                        stock.GetPricePerPiece(),
                        stock.GetTotalPrice(),
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

        VS_ItemsHolder_Panel = new javax.swing.JPanel();
        VS_TableHolder_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        VS_Stock_Table = new javax.swing.JTable();
        VSP_search_TF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "View stock details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 11))); // NOI18N

        VS_ItemsHolder_Panel.setBackground(new java.awt.Color(163, 197, 204));
        VS_ItemsHolder_Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        VS_TableHolder_Panel.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setFont(new java.awt.Font("Miriam Fixed", 1, 11)); // NOI18N

        VS_Stock_Table.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        VS_Stock_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Stock ID", "Name of stock", "Model no", "Quantity", "Price per piece", "Total price", "Added date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        VS_Stock_Table.setRowHeight(28);
        VS_Stock_Table.setRowMargin(5);
        jScrollPane1.setViewportView(VS_Stock_Table);

        javax.swing.GroupLayout VS_TableHolder_PanelLayout = new javax.swing.GroupLayout(VS_TableHolder_Panel);
        VS_TableHolder_Panel.setLayout(VS_TableHolder_PanelLayout);
        VS_TableHolder_PanelLayout.setHorizontalGroup(
            VS_TableHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
        );
        VS_TableHolder_PanelLayout.setVerticalGroup(
            VS_TableHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VS_TableHolder_PanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        VSP_search_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        VSP_search_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        VSP_search_TF.setPreferredSize(new java.awt.Dimension(5, 20));
        VSP_search_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VSP_search_TFActionPerformed(evt);
            }
        });
        VSP_search_TF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                VSP_search_TFKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        jLabel1.setText("Type here to search..");

        javax.swing.GroupLayout VS_ItemsHolder_PanelLayout = new javax.swing.GroupLayout(VS_ItemsHolder_Panel);
        VS_ItemsHolder_Panel.setLayout(VS_ItemsHolder_PanelLayout);
        VS_ItemsHolder_PanelLayout.setHorizontalGroup(
            VS_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, VS_ItemsHolder_PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(VS_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VS_TableHolder_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(VS_ItemsHolder_PanelLayout.createSequentialGroup()
                        .addComponent(VSP_search_TF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(106, 106, 106)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap())
        );
        VS_ItemsHolder_PanelLayout.setVerticalGroup(
            VS_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VS_ItemsHolder_PanelLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(VS_TableHolder_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(VS_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VSP_search_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
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

    private void VSP_search_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VSP_search_TFActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_VSP_search_TFActionPerformed

    private void VSP_search_TFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_VSP_search_TFKeyReleased
        // When search words are typed on the search textfield
        StockManager stockManager = null; 
        ResultSet rs = null; 
        
        String searchedValue = VSP_search_TF.getText();
        if( searchedValue.length() > 0 )
        {
            try 
            {
                stockManager = new StockManager();
                rs = stockManager.GetStockDetailsOnSearching(searchedValue);
                if ( null == rs )
                {
                    
                }
                else
                {
                   VS_Stock_Table.setModel(DbUtils.resultSetToTableModel(rs));
                }
                
                // deallocation
                stockManager.closeConection();
                stockManager    = null;
                rs         = null;
                
            } 
            catch (ClassNotFoundException | SQLException ex) 
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_VSP_search_TFKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField VSP_search_TF;
    private javax.swing.JPanel VS_ItemsHolder_Panel;
    private javax.swing.JTable VS_Stock_Table;
    private javax.swing.JPanel VS_TableHolder_Panel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}