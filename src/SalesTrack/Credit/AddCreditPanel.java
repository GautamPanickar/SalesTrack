/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesTrack.Credit;
import Database.CreditManager;
import Database.ExpenseManager;
import Database.StockManager;
import SalesTrack.Models.Credit;
import SalesTrack.Models.Expense;
import SalesTrack.Stock.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Panickar
 */
public class AddCreditPanel extends javax.swing.JPanel {

    
    private static Double AMOUNT_BEFORE_CREDIT_ADD;
    private static Double NEW_CREDIT_AMOUNT;
    private static Double AMOUNT_AFTER_CREDIT_ADD;
    /**
     * Creates new form ShortTermCourse
     */
    public AddCreditPanel() {
        initComponents();
        AMOUNT_BEFORE_CREDIT_ADD = 0.0;
        NEW_CREDIT_AMOUNT = 0.0;
        AMOUNT_AFTER_CREDIT_ADD = 0.0;
    }
    
    public void PopulateStockDetails()
    {
       StockManager manager = null; 
        ResultSet rs = null; 
        try 
            {
                manager = new StockManager();
                rs = manager.GetAllStockToCompanyMAappings();
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
        ACP_StockID_TF.setText(null);
        ACP_Name_TF.setText(null);
        ACP_Amount_TF.setText(null);
        ((JTextField)ACP_DateChooser.getDateEditor().getUiComponent()).setText(null);
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
        AddCreditItemsHolderPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ACP_StockID_TF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        AddCreditButton = new javax.swing.JButton();
        ACP_Amount_TF = new javax.swing.JTextField();
        ACP_Name_TF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ACP_DateChooser = new com.toedter.calendar.JDateChooser();

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
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Add credit", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 11))); // NOI18N

        AddCreditItemsHolderPanel.setBackground(new java.awt.Color(204, 219, 222));
        AddCreditItemsHolderPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel2.setText("Company ID");

        ACP_StockID_TF.setEditable(false);
        ACP_StockID_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ACP_StockID_TF.setEnabled(false);
        ACP_StockID_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        ACP_StockID_TF.setPreferredSize(new java.awt.Dimension(5, 20));
        ACP_StockID_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ACP_StockID_TFMouseClicked(evt);
            }
        });
        ACP_StockID_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ACP_StockID_TFActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel3.setText("Amount");

        jLabel19.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel19.setText("Date");

        AddCreditButton.setBackground(new java.awt.Color(51, 153, 0));
        AddCreditButton.setFont(new java.awt.Font("Miriam Fixed", 1, 14)); // NOI18N
        AddCreditButton.setForeground(new java.awt.Color(255, 255, 255));
        AddCreditButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesTrack/Images/add.png"))); // NOI18N
        AddCreditButton.setText("Add credit");
        AddCreditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCreditButtonActionPerformed(evt);
            }
        });

        ACP_Amount_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ACP_Amount_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        ACP_Amount_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        ACP_Name_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ACP_Name_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        ACP_Name_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel4.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel4.setText("Name");

        javax.swing.GroupLayout AddCreditItemsHolderPanelLayout = new javax.swing.GroupLayout(AddCreditItemsHolderPanel);
        AddCreditItemsHolderPanel.setLayout(AddCreditItemsHolderPanelLayout);
        AddCreditItemsHolderPanelLayout.setHorizontalGroup(
            AddCreditItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddCreditItemsHolderPanelLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(AddCreditItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(AddCreditItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ACP_Name_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ACP_StockID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ACP_Amount_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ACP_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddCreditButton))
                .addGap(82, 82, 82))
        );
        AddCreditItemsHolderPanelLayout.setVerticalGroup(
            AddCreditItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddCreditItemsHolderPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(AddCreditItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AddCreditItemsHolderPanelLayout.createSequentialGroup()
                        .addGroup(AddCreditItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ACP_StockID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(AddCreditItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ACP_Name_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(15, 15, 15)
                        .addGroup(AddCreditItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ACP_Amount_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(ACP_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(AddCreditButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(99, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddCreditItemsHolderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddCreditItemsHolderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddCreditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCreditButtonActionPerformed
        boolean isCreditAdded = false, isMapUpdated =  false;
        
        int companyID = Integer.parseInt(ACP_StockID_TF.getText()); 
        String name = ACP_Name_TF.getText();
        NEW_CREDIT_AMOUNT = Double.parseDouble(ACP_Amount_TF.getText());
        java.sql.Date date =  new java.sql.Date(ACP_DateChooser.getDate().getTime());
        
        if (ACP_StockID_TF.getText().isEmpty() || ACP_Name_TF.getText().isEmpty() || ACP_Amount_TF.getText().isEmpty() ||
                ((JTextField)ACP_DateChooser.getDateEditor().getUiComponent()).getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Some fields are empty! Please check.");
        }
        else
        {
           if (NEW_CREDIT_AMOUNT <= AMOUNT_BEFORE_CREDIT_ADD)
           {
               try               
                {
                    // Calculating the updated amount for the company
                    AMOUNT_AFTER_CREDIT_ADD = AMOUNT_BEFORE_CREDIT_ADD - NEW_CREDIT_AMOUNT;
                    // Initializing a new credit                
                    Credit newCredit = new Credit(0, companyID, name, NEW_CREDIT_AMOUNT, date, "OPEN");
                    CreditManager creditManager = new CreditManager();
                    isCreditAdded = creditManager.AddCredit(newCredit)? true: false;                    
                    if(isCreditAdded)
                    {
                        isMapUpdated = new StockManager().UpdateStockToCompanyMapAmount(companyID, AMOUNT_AFTER_CREDIT_ADD);
                        if(isMapUpdated)
                        {
                            JOptionPane.showMessageDialog(null, "New credit added!");
                            this.SetFieldsEmpty();
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Error! while adding the credit. Pease check again.");
                    }
                }
                catch (Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                } 
           }
           else
           {
               JOptionPane.showMessageDialog(null, "The total credit for the company is : " + AMOUNT_BEFORE_CREDIT_ADD);
           }
        }        
    }//GEN-LAST:event_AddCreditButtonActionPerformed

    private void ACP_StockID_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ACP_StockID_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ACP_StockID_TFActionPerformed

    private void ChooserDialogTextBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ChooserDialogTextBoxKeyReleased
        // When searched for
        CreditManager manager = null;
        ResultSet rs = null;
        String searchWord = ChooserDialogTextBox.getText();
        if(searchWord .length() > 0)
        {
            try {
                manager = new CreditManager();
                rs = manager.GetCreditDetailsOnSearching(searchWord);
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
            ACP_StockID_TF.setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,0)));
            ACP_Name_TF.setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,1)));
            AMOUNT_BEFORE_CREDIT_ADD = Double.valueOf(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,2)));
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

    private void ACP_StockID_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ACP_StockID_TFMouseClicked
        ChooserDialog.setSize(800, 500);
        ChooserDialog.setLocationRelativeTo(this);
        ChooserDialog.setVisible(true);
        this.PopulateStockDetails(); 
    }//GEN-LAST:event_ACP_StockID_TFMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ACP_Amount_TF;
    private com.toedter.calendar.JDateChooser ACP_DateChooser;
    private javax.swing.JTextField ACP_Name_TF;
    private javax.swing.JTextField ACP_StockID_TF;
    private javax.swing.JButton AddCreditButton;
    private javax.swing.JPanel AddCreditItemsHolderPanel;
    private javax.swing.JDialog ChooserDialog;
    private javax.swing.JButton ChooserDialogCloseButton;
    private javax.swing.JButton ChooserDialogOKButton;
    private javax.swing.JScrollPane ChooserDialogScrollPane;
    private javax.swing.JTable ChooserDialogTable;
    private javax.swing.JTextField ChooserDialogTextBox;
    private javax.swing.JPanel ChosserDialogBasePanel;
    private javax.swing.JLabel SubjectChooserLabel;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
