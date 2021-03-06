/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesTrack.Sales;
import Database.CreditManager;
import Database.SalesManager;
import SalesTrack.Models.Credit;
import SalesTrack.Models.Sales;
import SalesTrack.Stock.*;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author User
 */
public class SalesUpdatePanel extends javax.swing.JPanel {
    
    private int quantity;
    private Double gst;
    private Double finalAmount;
    private Double amount;
    
    /**
     * Creates new form 
     */
    public SalesUpdatePanel() {
        initComponents();
         this.quantity = 0;
        this.gst = 0.0;
        this.finalAmount = 0.0;
        this.amount = 0.0;
    }

    
    public void PopulateSalesDetails()
    {
       SalesManager manager = null; 
        ResultSet rs = null; 
        try 
            {
                manager = new SalesManager();
                rs = manager.GetAllSales();
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
        SUPS_SalesID_TF.setText(null);
        SUPS_StockID_TF.setText(null);
        SUPS_Name_TF.setText(null);
        SUPS_Quantity_TF.setText(null);
        SUPS_Amount_TF.setText(null);
        SUPS_GST_TF.setText(null);
        SUPS_FinalAmount_TF.setText(null);
        ((JTextField)SUPS_DateChooser.getDateEditor().getUiComponent()).setText(null);
    }
    
    private boolean AreFieldsEmpty()
    {
        if(SUPS_SalesID_TF.getText().isEmpty() || SUPS_StockID_TF.getText().isEmpty() || SUPS_Name_TF.getText().isEmpty() || SUPS_Quantity_TF.getText().isEmpty() ||
                SUPS_Amount_TF.getText().isEmpty() || SUPS_GST_TF.getText().isEmpty() || SUPS_FinalAmount_TF.getText().isEmpty() ||
                ((JTextField)SUPS_DateChooser.getDateEditor().getUiComponent()).getText().isEmpty())
        {
            return true;
        }
        
        return false;
    }
    
    private void CalculateFinalAmount()
    {
        this.quantity = Integer.parseInt(SUPS_Quantity_TF.getText());
        this.amount = Double.parseDouble(SUPS_Amount_TF.getText());
        this.gst = Double.parseDouble(SUPS_GST_TF.getText());
        Double gstValue = (this.gst * this.amount) / 100;
        Double amountWithGST = this.amount + gstValue;
        this.finalAmount = this.quantity * amountWithGST;
        SUPS_FinalAmount_TF.setText(this.finalAmount.toString());
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
        SUPS_UpdateSales_Button = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        SUPS_FinalAmount_TF = new javax.swing.JTextField();
        SUPS_GST_TF = new javax.swing.JTextField();
        SUPS_DateChooser = new com.toedter.calendar.JDateChooser();
        SUPS_Amount_TF = new javax.swing.JTextField();
        SUPS_Quantity_TF = new javax.swing.JTextField();
        SUPS_Name_TF = new javax.swing.JTextField();
        SUPS_StockID_TF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        SUPS_SalesID_TF = new javax.swing.JTextField();
        SUPS_RefreshButton = new javax.swing.JButton();

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
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Update sales details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 11))); // NOI18N

        SUP_ItemsHolder_Panel.setBackground(new java.awt.Color(204, 219, 222));
        SUP_ItemsHolder_Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        SUPS_UpdateSales_Button.setBackground(new java.awt.Color(0, 102, 255));
        SUPS_UpdateSales_Button.setFont(new java.awt.Font("Miriam Fixed", 1, 14)); // NOI18N
        SUPS_UpdateSales_Button.setForeground(new java.awt.Color(255, 255, 255));
        SUPS_UpdateSales_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesTrack/Images/update.png"))); // NOI18N
        SUPS_UpdateSales_Button.setText("Update");
        SUPS_UpdateSales_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUPS_UpdateSales_ButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel2.setText("Stock ID");

        jLabel4.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel5.setText("Quantity");

        jLabel3.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel3.setText("Amount");

        jLabel19.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel19.setText("Date");

        jLabel8.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel8.setText("GST (%)");

        jLabel9.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel9.setText("Final Amount");

        SUPS_FinalAmount_TF.setEditable(false);
        SUPS_FinalAmount_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        SUPS_FinalAmount_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        SUPS_FinalAmount_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        SUPS_GST_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        SUPS_GST_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        SUPS_GST_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        SUPS_Amount_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        SUPS_Amount_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        SUPS_Amount_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        SUPS_Quantity_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        SUPS_Quantity_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        SUPS_Quantity_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        SUPS_Name_TF.setEditable(false);
        SUPS_Name_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        SUPS_Name_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        SUPS_Name_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        SUPS_StockID_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        SUPS_StockID_TF.setEnabled(false);
        SUPS_StockID_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        SUPS_StockID_TF.setPreferredSize(new java.awt.Dimension(5, 20));
        SUPS_StockID_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUPS_StockID_TFActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel6.setText("Click here ..");

        SUPS_SalesID_TF.setEditable(false);
        SUPS_SalesID_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        SUPS_SalesID_TF.setEnabled(false);
        SUPS_SalesID_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        SUPS_SalesID_TF.setPreferredSize(new java.awt.Dimension(5, 20));
        SUPS_SalesID_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SUPS_SalesID_TFMouseClicked(evt);
            }
        });
        SUPS_SalesID_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUPS_SalesID_TFActionPerformed(evt);
            }
        });

        SUPS_RefreshButton.setBackground(new java.awt.Color(153, 153, 0));
        SUPS_RefreshButton.setFont(new java.awt.Font("Miriam Fixed", 1, 12)); // NOI18N
        SUPS_RefreshButton.setForeground(new java.awt.Color(255, 255, 255));
        SUPS_RefreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesTrack/Images/clear.png"))); // NOI18N
        SUPS_RefreshButton.setText("Refresh");
        SUPS_RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUPS_RefreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SUP_ItemsHolder_PanelLayout = new javax.swing.GroupLayout(SUP_ItemsHolder_Panel);
        SUP_ItemsHolder_Panel.setLayout(SUP_ItemsHolder_PanelLayout);
        SUP_ItemsHolder_PanelLayout.setHorizontalGroup(
            SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SUP_ItemsHolder_PanelLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(SUP_ItemsHolder_PanelLayout.createSequentialGroup()
                        .addComponent(SUPS_RefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SUPS_UpdateSales_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SUP_ItemsHolder_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SUPS_SalesID_TF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(SUP_ItemsHolder_PanelLayout.createSequentialGroup()
                        .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SUPS_Quantity_TF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SUPS_DateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SUPS_GST_TF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SUPS_FinalAmount_TF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SUPS_Name_TF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SUPS_StockID_TF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SUPS_Amount_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        SUP_ItemsHolder_PanelLayout.setVerticalGroup(
            SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SUP_ItemsHolder_PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(SUPS_SalesID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SUPS_StockID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(15, 15, 15)
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SUPS_Name_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(15, 15, 15)
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SUPS_Quantity_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SUPS_Amount_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(15, 15, 15)
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SUPS_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SUP_ItemsHolder_PanelLayout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(12, 12, 12)))
                .addGap(15, 15, 15)
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(SUPS_GST_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SUPS_FinalAmount_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SUP_ItemsHolder_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SUPS_UpdateSales_Button)
                    .addComponent(SUPS_RefreshButton))
                .addGap(14, 14, 14))
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

    private void SUPS_UpdateSales_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUPS_UpdateSales_ButtonActionPerformed
        boolean isSalesUpdated = false;
        
        int salesID = Integer.parseInt(SUPS_SalesID_TF.getText());
        int stockID = Integer.parseInt(SUPS_StockID_TF.getText());
        String name = SUPS_Name_TF.getText();
        Double amount = Double.parseDouble(SUPS_Amount_TF.getText());
        int quantity = Integer.parseInt(SUPS_Quantity_TF.getText());
        Double gst = Double.parseDouble(SUPS_GST_TF.getText());
        Double finalAmount = Double.parseDouble(SUPS_FinalAmount_TF.getText());
        String dateText = ((JTextField)SUPS_DateChooser.getDateEditor().getUiComponent()).getText();
        java.sql.Date date =  new java.sql.Date(SUPS_DateChooser.getDate().getTime());  
        if(this.AreFieldsEmpty())
        {
               JOptionPane.showMessageDialog(null, "Cannot update with empty fields!");
        }
        else
        {
            try
            {
                // Initializing a new sale
                Sales newSales = new Sales(salesID, stockID, name, quantity, amount, gst, finalAmount, date);
                SalesManager salesManager = new SalesManager();
                isSalesUpdated = salesManager.UpdateSales(newSales)? true: false;

                if(isSalesUpdated)
                {
                    JOptionPane.showMessageDialog(null, "Sales has been updated!");
                    this.SetFieldsEmpty();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error! while updating the sale. Pease check again.");
                }
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }       
        }
    }//GEN-LAST:event_SUPS_UpdateSales_ButtonActionPerformed

    private void SUPS_StockID_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUPS_StockID_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SUPS_StockID_TFActionPerformed

    private void SUPS_SalesID_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUPS_SalesID_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SUPS_SalesID_TFActionPerformed

    private void SUPS_RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUPS_RefreshButtonActionPerformed
        //// Calculates the final amount
        if (SUPS_Quantity_TF.getText().isEmpty() || SUPS_Amount_TF.getText().isEmpty() || SUPS_GST_TF.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Make sure that you have entered all valid fields!");
        }
        else
        {
            this.CalculateFinalAmount();
        }
    }//GEN-LAST:event_SUPS_RefreshButtonActionPerformed

    private void ChooserDialogTextBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ChooserDialogTextBoxKeyReleased
        // When searched for
        SalesManager manager = null;
        ResultSet rs = null;
        String searchWord = ChooserDialogTextBox.getText();
        if(searchWord .length() > 0)
        {
            try {
                manager = new SalesManager();
                rs = manager.GetSalesDetailsOnSearching(searchWord);
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
            SUPS_SalesID_TF.setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,0)));
            SUPS_StockID_TF.setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,1)));
            SUPS_Name_TF.setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,2)));
            SUPS_Quantity_TF.setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,3)));
            SUPS_Amount_TF.setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,4)));
            SUPS_GST_TF.setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,5)));
            SUPS_FinalAmount_TF.setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,6)));
////            ((JTextField)SUPS_DateChooser.getDateEditor().getUiComponent()).setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,7)));

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

    private void SUPS_SalesID_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SUPS_SalesID_TFMouseClicked
        ChooserDialog.setSize(800, 500);
        ChooserDialog.setLocationRelativeTo(this);
        ChooserDialog.setVisible(true);
        this.PopulateSalesDetails(); 
    }//GEN-LAST:event_SUPS_SalesID_TFMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog ChooserDialog;
    private javax.swing.JButton ChooserDialogCloseButton;
    private javax.swing.JButton ChooserDialogOKButton;
    private javax.swing.JScrollPane ChooserDialogScrollPane;
    private javax.swing.JTable ChooserDialogTable;
    private javax.swing.JTextField ChooserDialogTextBox;
    private javax.swing.JPanel ChosserDialogBasePanel;
    private javax.swing.JTextField SUPS_Amount_TF;
    private com.toedter.calendar.JDateChooser SUPS_DateChooser;
    private javax.swing.JTextField SUPS_FinalAmount_TF;
    private javax.swing.JTextField SUPS_GST_TF;
    private javax.swing.JTextField SUPS_Name_TF;
    private javax.swing.JTextField SUPS_Quantity_TF;
    private javax.swing.JButton SUPS_RefreshButton;
    private javax.swing.JTextField SUPS_SalesID_TF;
    private javax.swing.JTextField SUPS_StockID_TF;
    private javax.swing.JButton SUPS_UpdateSales_Button;
    private javax.swing.JPanel SUP_ItemsHolder_Panel;
    private javax.swing.JLabel SubjectChooserLabel;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables


}
