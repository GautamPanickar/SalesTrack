/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesTrack.Stock;
import Database.StockManager;
import SalesTrack.Models.Stock;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author User
 */
public class StockUpdatePanel extends javax.swing.JPanel {
    
    
    private static String COMPANY_NAME;
    private static int COMPANY_ID;
    private static Double COMPANY_AMOUNT;
    private static Double AMOUNT_BEFORE_UPDATE;
    private static Double COMPANY_AMOUNT_TO_BE_UPDATED;
    /**
     * Creates new form 
     */
    public StockUpdatePanel() {
        initComponents();
        COMPANY_NAME = null;
        COMPANY_ID = 0;
        COMPANY_AMOUNT = 0.0;
        AMOUNT_BEFORE_UPDATE = 0.0;
        COMPANY_AMOUNT_TO_BE_UPDATED = 0.0;
    }

    public void PopulateStockDetails()
    {
       StockManager manager = null; 
        ResultSet rs = null; 
        try 
            {
                manager = new StockManager();
                rs = manager.GetAllStocks();
                if ( null == rs )
                {
                    
                }
                else
                {
                   ChooserDialogTable.setModel(DbUtils.resultSetToTableModel(rs));
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
    
    private void SetFieldsEmpty()
    {
        SUP_StockID_TF.setText(null);
        SUP_Name_TF.setText(null);
        SUP_Model_TF.setText(null);
        SUP_Quantity_TF.setText(null);
        SUP_PPP_TF.setText(null);
        SUP_TotalPrice_TF.setText(null);
        ((JTextField)SUP_DateChooser.getDateEditor().getUiComponent()).setText(null);
    }
    
    private boolean IsAmountUpdateNeeded(Double amount)
    {
        if (AMOUNT_BEFORE_UPDATE == amount)
        {
            return false;
        }
        else
        {
            Double stepValue = amount - AMOUNT_BEFORE_UPDATE;
            COMPANY_AMOUNT_TO_BE_UPDATED = COMPANY_AMOUNT + stepValue;
            return true;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ChooserDialog = new javax.swing.JDialog();
        ChosserDialogBasePanel = new javax.swing.JPanel();
        ChooserDialogTextBox = new javax.swing.JTextField();
        ChooserDialogScrollPane = new javax.swing.JScrollPane();
        ChooserDialogTable = new javax.swing.JTable();
        ChooserDialogOKButton = new javax.swing.JButton();
        ChooserDialogCloseButton = new javax.swing.JButton();
        SubjectChooserLabel = new javax.swing.JLabel();
        SUP_ItemsHolder_Panel = new javax.swing.JPanel();
        SUP_StockID_TF = new javax.swing.JTextField();
        SUP_UpdateStock_Button = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SUP_TotalPrice_TF = new javax.swing.JTextField();
        SUP_PPP_TF = new javax.swing.JTextField();
        SUP_DateChooser = new com.toedter.calendar.JDateChooser();
        SUP_Quantity_TF = new javax.swing.JTextField();
        SUP_Model_TF = new javax.swing.JTextField();
        SUP_Name_TF = new javax.swing.JTextField();

        ChosserDialogBasePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 12))); // NOI18N

        ChooserDialogTextBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ChooserDialogTextBoxKeyReleased(evt);
            }
        });

        ChooserDialogTable.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        ChooserDialogTable.setForeground(new java.awt.Color(102, 0, 0));
        ChooserDialogTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        ChooserDialogScrollPane.setViewportView(ChooserDialogTable);

        ChooserDialogOKButton.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ChooserDialogOKButton.setText("OK");
        ChooserDialogOKButton.setBorder(null);
        ChooserDialogOKButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooserDialogOKButtonActionPerformed(evt);
            }
        });

        ChooserDialogCloseButton.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ChooserDialogCloseButton.setText("CLOSE");
        ChooserDialogCloseButton.setBorder(null);
        ChooserDialogCloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChooserDialogCloseButtonActionPerformed(evt);
            }
        });

        SubjectChooserLabel.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        SubjectChooserLabel.setText("Enter here to search");

        javax.swing.GroupLayout ChosserDialogBasePanelLayout = new javax.swing.GroupLayout(ChosserDialogBasePanel);
        ChosserDialogBasePanel.setLayout(ChosserDialogBasePanelLayout);
        ChosserDialogBasePanelLayout.setHorizontalGroup(
            ChosserDialogBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChosserDialogBasePanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(SubjectChooserLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ChosserDialogBasePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ChosserDialogBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChooserDialogTextBox)
                    .addComponent(ChooserDialogScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ChosserDialogBasePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ChooserDialogOKButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ChooserDialogCloseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        ChosserDialogBasePanelLayout.setVerticalGroup(
            ChosserDialogBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChosserDialogBasePanelLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(SubjectChooserLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ChooserDialogTextBox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ChooserDialogScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(ChosserDialogBasePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ChooserDialogOKButton, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(ChooserDialogCloseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout ChooserDialogLayout = new javax.swing.GroupLayout(ChooserDialog.getContentPane());
        ChooserDialog.getContentPane().setLayout(ChooserDialogLayout);
        ChooserDialogLayout.setHorizontalGroup(
            ChooserDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ChosserDialogBasePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        ChooserDialogLayout.setVerticalGroup(
            ChooserDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ChosserDialogBasePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Update stock details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 11))); // NOI18N

        SUP_ItemsHolder_Panel.setBackground(new java.awt.Color(204, 219, 222));
        SUP_ItemsHolder_Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        SUP_StockID_TF.setEditable(false);
        SUP_StockID_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        SUP_StockID_TF.setEnabled(false);
        SUP_StockID_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        SUP_StockID_TF.setPreferredSize(new java.awt.Dimension(5, 20));
        SUP_StockID_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SUP_StockID_TFMouseClicked(evt);
            }
        });
        SUP_StockID_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUP_StockID_TFActionPerformed(evt);
            }
        });

        SUP_UpdateStock_Button.setBackground(new java.awt.Color(0, 102, 255));
        SUP_UpdateStock_Button.setFont(new java.awt.Font("Miriam Fixed", 1, 14)); // NOI18N
        SUP_UpdateStock_Button.setForeground(new java.awt.Color(255, 255, 255));
        SUP_UpdateStock_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesTrack/Images/update.png"))); // NOI18N
        SUP_UpdateStock_Button.setText("Update");
        SUP_UpdateStock_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUP_UpdateStock_ButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel5.setText("Click here to select");

        jLabel2.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel6.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel6.setText("Model no");

        jLabel4.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel4.setText("Quantity");

        jLabel19.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel19.setText("Date");

        jLabel3.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel3.setText("Price per piece");

        jLabel8.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel8.setText("Total price");

        SUP_TotalPrice_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        SUP_TotalPrice_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        SUP_TotalPrice_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        SUP_PPP_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        SUP_PPP_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        SUP_PPP_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        SUP_Quantity_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        SUP_Quantity_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        SUP_Quantity_TF.setPreferredSize(new java.awt.Dimension(5, 20));
        SUP_Quantity_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SUP_Quantity_TFMouseClicked(evt);
            }
        });

        SUP_Model_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        SUP_Model_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        SUP_Model_TF.setPreferredSize(new java.awt.Dimension(5, 20));
        SUP_Model_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUP_Model_TFActionPerformed(evt);
            }
        });

        SUP_Name_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        SUP_Name_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        SUP_Name_TF.setPreferredSize(new java.awt.Dimension(5, 20));
        SUP_Name_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SUP_Name_TFMouseClicked(evt);
            }
        });
        SUP_Name_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUP_Name_TFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SUP_ItemsHolder_PanelLayout = new javax.swing.GroupLayout(SUP_ItemsHolder_Panel);
        SUP_ItemsHolder_Panel.setLayout(SUP_ItemsHolder_PanelLayout);
        SUP_ItemsHolder_PanelLayout.setHorizontalGroup(
            SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SUP_ItemsHolder_PanelLayout.createSequentialGroup()
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SUP_ItemsHolder_PanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(SUP_StockID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SUP_ItemsHolder_PanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SUP_Model_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SUP_Quantity_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SUP_Name_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SUP_PPP_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SUP_TotalPrice_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SUP_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SUP_UpdateStock_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        SUP_ItemsHolder_PanelLayout.setVerticalGroup(
            SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SUP_ItemsHolder_PanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SUP_StockID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SUP_Name_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SUP_Model_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(SUP_Quantity_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SUP_ItemsHolder_PanelLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel19))
                    .addGroup(SUP_ItemsHolder_PanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(SUP_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SUP_PPP_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SUP_TotalPrice_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SUP_UpdateStock_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SUP_ItemsHolder_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(SUP_ItemsHolder_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void SUP_UpdateStock_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUP_UpdateStock_ButtonActionPerformed
        boolean isStockUpdated = false;
        boolean isCompanyMapped = false;
        int stockID = Integer.parseInt(SUP_StockID_TF.getText());
        String name = SUP_Name_TF.getText();
        String modelNo = SUP_Model_TF.getText();
        int quantity = Integer.parseInt(SUP_Quantity_TF.getText());
        Double pricePerPiece = Double.parseDouble(SUP_PPP_TF.getText());
        Double totalPrice = Double.parseDouble(SUP_TotalPrice_TF.getText());
        String dateText = ((JTextField)SUP_DateChooser.getDateEditor().getUiComponent()).getText();
        java.sql.Date date =  new java.sql.Date(SUP_DateChooser.getDate().getTime());
        
        if(SUP_StockID_TF.getText().isEmpty() || SUP_Name_TF.getText().isEmpty() || SUP_Quantity_TF.getText().isEmpty()
                || SUP_PPP_TF.getText().isEmpty() || SUP_TotalPrice_TF.getText().isEmpty() || dateText.isEmpty())
        {
               JOptionPane.showMessageDialog(null, "Cannot update with empty fields!");
        }
        else
        {
            try
            {                
                // Initializing a new stock
                Stock newstock = new Stock(stockID, name, modelNo, quantity, pricePerPiece, totalPrice, date);
                StockManager stockManager = new StockManager();
                isStockUpdated = stockManager.UpdateStock(newstock)? true: false;
                if (COMPANY_NAME.equals(name))
                {                    
                    if (this.IsAmountUpdateNeeded(totalPrice))
                    {
                        newstock.SetTotalPrice(COMPANY_AMOUNT_TO_BE_UPDATED);
                        isCompanyMapped= stockManager.UpdateStockToCompanyMap(newstock, false, true, COMPANY_ID);
                        
                    }
                    else
                    {
                        isCompanyMapped= stockManager.UpdateStockToCompanyMap(newstock, false, false, COMPANY_ID);
                    }
                }
                else
                {
                    if (this.IsAmountUpdateNeeded(totalPrice))
                    {
                        newstock.SetTotalPrice(COMPANY_AMOUNT_TO_BE_UPDATED);
                        isCompanyMapped= stockManager.UpdateStockToCompanyMap(newstock, true, true, COMPANY_ID);
                    }
                    else
                    {
                        isCompanyMapped= stockManager.UpdateStockToCompanyMap(newstock, true, false, COMPANY_ID);
                    }
                }
                
                if(isStockUpdated && isCompanyMapped)
                {
                    JOptionPane.showMessageDialog(null, "Stock has been updated!");
                    this.SetFieldsEmpty();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error! while updating the stock. Pease check again.");
                }
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }       
        }        
    }//GEN-LAST:event_SUP_UpdateStock_ButtonActionPerformed

    private void ChooserDialogTextBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ChooserDialogTextBoxKeyReleased
        // When searched for
        StockManager manager = null;
        ResultSet rs = null;
        String searchWord = ChooserDialogTextBox.getText();
        if(searchWord .length() > 0)
        {
            try {
                manager = new StockManager();
                rs = manager.GetStockDetailsOnSearching(searchWord);
                if ( null == rs )
                {

                }
                else
                {
                    ChooserDialogTable.setModel( DbUtils.resultSetToTableModel(rs));
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
    }//GEN-LAST:event_ChooserDialogTextBoxKeyReleased

    private void ChooserDialogOKButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooserDialogOKButtonActionPerformed
        // On clicking the Ok button 
        if( ChooserDialogTable.getSelectedRow() >= 0)
        {
            // Set text field
            SUP_StockID_TF.setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,0)));
            
            COMPANY_NAME = String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,1));
            
            try
            {
                // Instantly saving the company ID and amount locally from the stock to company mapping info in DB
                // This is required to identify whether the company name is getting upadetd for an already mapped company
                StockManager manager = new StockManager();
                COMPANY_ID = manager.GetCompanyIDForStock(COMPANY_NAME);
                COMPANY_AMOUNT = manager.GetCompanyAmountForStock(COMPANY_ID);
                manager = null;
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            SUP_Name_TF.setText(COMPANY_NAME);
            SUP_Model_TF.setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,2)));
            SUP_Quantity_TF.setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,3)));
            SUP_PPP_TF.setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,4)));
            
            AMOUNT_BEFORE_UPDATE = Double.valueOf(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,5)));
            
            SUP_TotalPrice_TF.setText(String.valueOf(AMOUNT_BEFORE_UPDATE));
            
            
            // dispose the search dialog
            ChooserDialog.dispose();            
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please select a row to continue...");
        }
    }//GEN-LAST:event_ChooserDialogOKButtonActionPerformed

    private void ChooserDialogCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooserDialogCloseButtonActionPerformed
        // Disposing search dialog
        ChooserDialog.dispose();
    }//GEN-LAST:event_ChooserDialogCloseButtonActionPerformed

    private void SUP_StockID_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUP_StockID_TFActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_SUP_StockID_TFActionPerformed

    private void SUP_StockID_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SUP_StockID_TFMouseClicked
        ChooserDialog.setSize(800, 500);
        ChooserDialog.setLocationRelativeTo(this);
        ChooserDialog.setVisible(true);
        this.PopulateStockDetails();
    }//GEN-LAST:event_SUP_StockID_TFMouseClicked

    private void SUP_Quantity_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SUP_Quantity_TFMouseClicked

    }//GEN-LAST:event_SUP_Quantity_TFMouseClicked

    private void SUP_Model_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUP_Model_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SUP_Model_TFActionPerformed

    private void SUP_Name_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SUP_Name_TFMouseClicked
       
    }//GEN-LAST:event_SUP_Name_TFMouseClicked

    private void SUP_Name_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUP_Name_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SUP_Name_TFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog ChooserDialog;
    private javax.swing.JButton ChooserDialogCloseButton;
    private javax.swing.JButton ChooserDialogOKButton;
    private javax.swing.JScrollPane ChooserDialogScrollPane;
    private javax.swing.JTable ChooserDialogTable;
    private javax.swing.JTextField ChooserDialogTextBox;
    private javax.swing.JPanel ChosserDialogBasePanel;
    private com.toedter.calendar.JDateChooser SUP_DateChooser;
    private javax.swing.JPanel SUP_ItemsHolder_Panel;
    private javax.swing.JTextField SUP_Model_TF;
    private javax.swing.JTextField SUP_Name_TF;
    private javax.swing.JTextField SUP_PPP_TF;
    private javax.swing.JTextField SUP_Quantity_TF;
    private javax.swing.JTextField SUP_StockID_TF;
    private javax.swing.JTextField SUP_TotalPrice_TF;
    private javax.swing.JButton SUP_UpdateStock_Button;
    private javax.swing.JLabel SubjectChooserLabel;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables


}