/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesTrack.Sales;
import Database.SalesManager;
import Database.StockManager;
import SalesTrack.Models.Sales;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Panickar
 */
public class AddSalesPanel extends javax.swing.JPanel {

    private int quantity;
    private Double gst;
    private Double finalAmount;
    private Double amount;
    private Sales newSales;
    private Double totalPurchaseAmount;
    private ArrayList<Sales> allSales ;
    private static int CART_INDEX;
    private static Double CART_TOTAL;
    private static int ITEM_QUANTITY;
    
    /**
     * Creates new form ShortTermCourse
     */
    public AddSalesPanel() {
        initComponents();
        this.quantity = 0;
        this.gst = 0.0;
        this.finalAmount = 0.0;
        this.amount = 0.0;
        this.totalPurchaseAmount = 0.0;
        this.allSales = new ArrayList<Sales>();
        CART_INDEX = 0;
        CART_TOTAL = 0.0;  
        ITEM_QUANTITY = 0;
        this.SetCurrentDateAsDefault();
        this.CopyDetailsToTempTable();
    }
    
    private void CopyDetailsToTempTable()
    {        
        // To copy everything from the main stock table to temporary table
        try
        {
            StockManager stockManager = new StockManager();   
            stockManager.CopyStockToTemp();
            stockManager = null;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    private void SetCurrentDateAsDefault()
    {
        Date currentDate = new Date();
        ASPS_DateChooser.setDate(currentDate);        
    }
    
    private void PopulateSalesDetails()
    {
        StockManager manager = null; 
        ResultSet rs = null; 
        try 
            {
                manager = new StockManager();
                rs = manager.GetAllTemporaryStocks();
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

    private void CalculateFinalAmount()
    {
        this.quantity = Integer.parseInt(ASPS_Quantity_TF.getText());
        this.amount = Double.parseDouble(ASPS_Amount_TF.getText());
        this.gst = Double.parseDouble(ASPS_GST_TF.getText());
        Double gstValue = (this.gst * this.amount) / 100;
        Double amountWithGST = this.amount + gstValue;
        this.finalAmount = this.quantity * amountWithGST;
        ASPS_FinalAmount_TF.setText(this.finalAmount.toString());
    }
    
    private void SetFieldsEmpty()
    {
        ASPS_StockID_TF.setText(null);
        ASPS_Name_TF.setText(null);
        ASPS_Quantity_TF.setText(null);
        ASPS_Amount_TF.setText(null);
        ASPS_GST_TF.setText(null);
        ASPS_FinalAmount_TF.setText(null);
        ((JTextField)ASPS_DateChooser.getDateEditor().getUiComponent()).setText(null);
        this.SetCurrentDateAsDefault();
        
        this.quantity = 0;
        this.gst = 0.0;
        this.finalAmount = 0.0;
        this.amount = 0.0;
    }
    
    private boolean AreFieldsEmpty()
    {
        if(ASPS_StockID_TF.getText().isEmpty() || ASPS_Name_TF.getText().isEmpty() || ASPS_Quantity_TF.getText().isEmpty() ||
                ASPS_Amount_TF.getText().isEmpty() || ASPS_GST_TF.getText().isEmpty() || ASPS_FinalAmount_TF.getText().isEmpty() ||
                ((JTextField)ASPS_DateChooser.getDateEditor().getUiComponent()).getText().isEmpty())
        {
            return true;
        }
        
        return false;
    }
    
    /**
     * Populates the customer cart
     * @return true or false
     */
    private boolean PopulateCart()
    {
        CART_INDEX = 0;
        CART_TOTAL = 0.0;
        DefaultTableModel dm = (DefaultTableModel)ASPS_Cart_Table.getModel();
        try
        {
            dm.setRowCount(0);
            if(null != this.allSales)
            {
                this.allSales.stream().forEach((sales) -> 
                {
                    CART_TOTAL += sales.GetFinalAmount();
                    dm.addRow(new Object[]
                    {
                        ++CART_INDEX,
                        sales.GetStockName(),
                        sales.GetQuantity(),
                        sales.GetDate(),
                        sales.GetFinalAmount()
                     });
                });
            }
            
            // Setting the cart_total
            ASPS_CartTotal_TF.setText(Double.toString(CART_TOTAL));
        } 
        catch (Exception ex) 
        {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return dm.getRowCount() == this.allSales.size();
    }
    
    private void ClearFieldsAfterSaving()
    {
        // Clearing the Cart population table
        DefaultTableModel dm = (DefaultTableModel)ASPS_Cart_Table.getModel();
        dm.setRowCount(0);
        this.allSales.clear();
        // Clearing the total amount
        ASPS_CartTotal_TF.setText(null);
    }
    
    private boolean RemoveFromCart(int rowNo)
    {
        int currentSalesCount = this.allSales.size();
        try
        {
            if (currentSalesCount > 0)
            {
                this.allSales.remove(rowNo);
            }
        }
        catch (Exception ex) 
        {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return this.allSales.size() == currentSalesCount - 1;
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
        AddSalesItemsHolderPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ASPS_StockID_TF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ASPS_AddCartButton = new javax.swing.JButton();
        ASPS_Amount_TF = new javax.swing.JTextField();
        ASPS_GST_TF = new javax.swing.JTextField();
        ASPS_Name_TF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ASPS_FinalAmount_TF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        ASPS_DateChooser = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        ASPS_RefreshButton = new javax.swing.JButton();
        ASPS_Table_Panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ASPS_Cart_Table = new javax.swing.JTable();
        ASPS_SaveAndPrint_Button = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        ASPS_Quantity_TF = new javax.swing.JTextField();
        ASPS_CartTotal_TF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ASPS_RemoveFromCart_Button = new javax.swing.JButton();

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
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Add a new sale", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 11))); // NOI18N

        AddSalesItemsHolderPanel.setBackground(new java.awt.Color(204, 219, 222));
        AddSalesItemsHolderPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel2.setText("Stock ID");

        ASPS_StockID_TF.setEditable(false);
        ASPS_StockID_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ASPS_StockID_TF.setForeground(new java.awt.Color(153, 0, 0));
        ASPS_StockID_TF.setEnabled(false);
        ASPS_StockID_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        ASPS_StockID_TF.setPreferredSize(new java.awt.Dimension(5, 20));
        ASPS_StockID_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ASPS_StockID_TFMouseClicked(evt);
            }
        });
        ASPS_StockID_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASPS_StockID_TFActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel3.setText("Amount");

        jLabel8.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel8.setText("GST (%)");

        ASPS_AddCartButton.setBackground(new java.awt.Color(153, 51, 0));
        ASPS_AddCartButton.setFont(new java.awt.Font("Miriam Fixed", 1, 14)); // NOI18N
        ASPS_AddCartButton.setForeground(new java.awt.Color(255, 255, 255));
        ASPS_AddCartButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesTrack/Images/cart.png"))); // NOI18N
        ASPS_AddCartButton.setText("Add to cart");
        ASPS_AddCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASPS_AddCartButtonActionPerformed(evt);
            }
        });

        ASPS_Amount_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ASPS_Amount_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        ASPS_Amount_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        ASPS_GST_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ASPS_GST_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        ASPS_GST_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        ASPS_Name_TF.setEditable(false);
        ASPS_Name_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ASPS_Name_TF.setForeground(new java.awt.Color(153, 0, 0));
        ASPS_Name_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        ASPS_Name_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel4.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel4.setText("Name");

        ASPS_FinalAmount_TF.setEditable(false);
        ASPS_FinalAmount_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ASPS_FinalAmount_TF.setForeground(new java.awt.Color(153, 0, 0));
        ASPS_FinalAmount_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        ASPS_FinalAmount_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel9.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel9.setText("Final Amount");

        jLabel19.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel19.setText("Date");

        ASPS_RefreshButton.setBackground(new java.awt.Color(0, 51, 204));
        ASPS_RefreshButton.setFont(new java.awt.Font("Miriam Fixed", 1, 12)); // NOI18N
        ASPS_RefreshButton.setForeground(new java.awt.Color(255, 255, 255));
        ASPS_RefreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesTrack/Images/clear.png"))); // NOI18N
        ASPS_RefreshButton.setText("Refresh");
        ASPS_RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASPS_RefreshButtonActionPerformed(evt);
            }
        });

        ASPS_Table_Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ASPS_Cart_Table.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        ASPS_Cart_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Sl no", "Name", "Quantity", "Date", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(ASPS_Cart_Table);

        javax.swing.GroupLayout ASPS_Table_PanelLayout = new javax.swing.GroupLayout(ASPS_Table_Panel);
        ASPS_Table_Panel.setLayout(ASPS_Table_PanelLayout);
        ASPS_Table_PanelLayout.setHorizontalGroup(
            ASPS_Table_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 522, Short.MAX_VALUE)
            .addGroup(ASPS_Table_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE))
        );
        ASPS_Table_PanelLayout.setVerticalGroup(
            ASPS_Table_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(ASPS_Table_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE))
        );

        ASPS_SaveAndPrint_Button.setBackground(new java.awt.Color(51, 153, 0));
        ASPS_SaveAndPrint_Button.setFont(new java.awt.Font("Miriam Fixed", 1, 14)); // NOI18N
        ASPS_SaveAndPrint_Button.setForeground(new java.awt.Color(255, 255, 255));
        ASPS_SaveAndPrint_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesTrack/Images/print.png"))); // NOI18N
        ASPS_SaveAndPrint_Button.setText("Save & Print");
        ASPS_SaveAndPrint_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASPS_SaveAndPrint_ButtonActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel5.setText("Quantity");

        ASPS_Quantity_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ASPS_Quantity_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        ASPS_Quantity_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        ASPS_CartTotal_TF.setEditable(false);
        ASPS_CartTotal_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ASPS_CartTotal_TF.setForeground(new java.awt.Color(153, 0, 0));
        ASPS_CartTotal_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        ASPS_CartTotal_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel6.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel6.setText("Total");

        ASPS_RemoveFromCart_Button.setBackground(new java.awt.Color(255, 51, 51));
        ASPS_RemoveFromCart_Button.setFont(new java.awt.Font("Miriam Fixed", 1, 14)); // NOI18N
        ASPS_RemoveFromCart_Button.setForeground(new java.awt.Color(255, 255, 255));
        ASPS_RemoveFromCart_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesTrack/Images/delete.png"))); // NOI18N
        ASPS_RemoveFromCart_Button.setText("Remove");
        ASPS_RemoveFromCart_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASPS_RemoveFromCart_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddSalesItemsHolderPanelLayout = new javax.swing.GroupLayout(AddSalesItemsHolderPanel);
        AddSalesItemsHolderPanel.setLayout(AddSalesItemsHolderPanelLayout);
        AddSalesItemsHolderPanelLayout.setHorizontalGroup(
            AddSalesItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddSalesItemsHolderPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(AddSalesItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, AddSalesItemsHolderPanelLayout.createSequentialGroup()
                        .addComponent(ASPS_RefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addComponent(ASPS_AddCartButton))
                    .addGroup(AddSalesItemsHolderPanelLayout.createSequentialGroup()
                        .addGroup(AddSalesItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AddSalesItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ASPS_Quantity_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(ASPS_DateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(ASPS_GST_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(ASPS_FinalAmount_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(ASPS_Name_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(ASPS_StockID_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(ASPS_Amount_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))))
                .addGap(76, 76, 76)
                .addGroup(AddSalesItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddSalesItemsHolderPanelLayout.createSequentialGroup()
                        .addComponent(ASPS_RemoveFromCart_Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ASPS_SaveAndPrint_Button)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ASPS_CartTotal_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ASPS_Table_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        AddSalesItemsHolderPanelLayout.setVerticalGroup(
            AddSalesItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddSalesItemsHolderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(AddSalesItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddSalesItemsHolderPanelLayout.createSequentialGroup()
                        .addGroup(AddSalesItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ASPS_StockID_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(15, 15, 15)
                        .addGroup(AddSalesItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ASPS_Name_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(15, 15, 15)
                        .addGroup(AddSalesItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ASPS_Quantity_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(AddSalesItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ASPS_Amount_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(15, 15, 15)
                        .addGroup(AddSalesItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ASPS_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddSalesItemsHolderPanelLayout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(12, 12, 12)))
                        .addGap(15, 15, 15)
                        .addGroup(AddSalesItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(ASPS_GST_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(AddSalesItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ASPS_FinalAmount_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addComponent(ASPS_Table_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10)
                .addGroup(AddSalesItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ASPS_AddCartButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASPS_RefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASPS_CartTotal_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(ASPS_RemoveFromCart_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASPS_SaveAndPrint_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddSalesItemsHolderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddSalesItemsHolderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ASPS_AddCartButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASPS_AddCartButtonActionPerformed
        
        newSales = new Sales();
        StockManager stockManager = null;
        boolean isTempStockUpdated = false;
        int stockID = Integer.parseInt(ASPS_StockID_TF.getText());
        String stockName = ASPS_Name_TF.getText();
        java.sql.Date date =  new java.sql.Date(ASPS_DateChooser.getDate().getTime());
        
        if(this.AreFieldsEmpty())
        {
            JOptionPane.showMessageDialog(null, "Some fields are empty! Please check.");
        }
        else
        {
            
            try
            {
                // Logic to validate if stock is empty
                stockManager = new StockManager();
                int currentStockQuantity = stockManager.GetQuantityForTempStock(stockID);
                int updatedStockQuantity = currentStockQuantity - this.quantity;
                if (updatedStockQuantity >= 0)
                {
                    try
                    {
                        // Initializing a new sale
                        newSales.SetStockID(stockID);
                        newSales.SetStockName(stockName);
                        newSales.SetQuantity(this.quantity);
                        newSales.SetAmount(this.amount);
                        newSales.SetDate(date);
                        newSales.SetGST(this.gst);
                        newSales.SetFinalAmount(this.finalAmount);

                        // Updating the temporaryStockTable in DB
                        isTempStockUpdated = stockManager.UpdateTempStockQuantity(newSales.GetStockID(), updatedStockQuantity);
                        if(isTempStockUpdated)
                        {
                            // Adding the first purchase to the cart
                            this.allSales.add(newSales);
                            if (this.PopulateCart())
                            {
                                JOptionPane.showMessageDialog(null, "New sales added to the cart!");
                                this.SetFieldsEmpty();                    
                            }
                            else
                            {
                                JOptionPane.showMessageDialog(null, "Error! while adding the sale to cart. Pease check again.");
                            }
                        }                        
                    }
                    catch (Exception ex)
                    {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Required quantity is not available in stock!!");
                    this.SetFieldsEmpty();
                }
            }
            catch (Exception ex)
            {
                
            }
            
        }
    }//GEN-LAST:event_ASPS_AddCartButtonActionPerformed

    private void ASPS_StockID_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASPS_StockID_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ASPS_StockID_TFActionPerformed

    private void ASPS_RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASPS_RefreshButtonActionPerformed
        //// Calculates the final amount
        if (ASPS_Quantity_TF.getText().isEmpty() || ASPS_Amount_TF.getText().isEmpty() || ASPS_GST_TF.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Make sure that you have entered all valid fields!");
        }
        else
        {
            this.CalculateFinalAmount();
        }
    }//GEN-LAST:event_ASPS_RefreshButtonActionPerformed

    private void ASPS_SaveAndPrint_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASPS_SaveAndPrint_ButtonActionPerformed
        if (this.allSales.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "The cart seems to be empty!");
        }
        else
        {
            // logic to add sales from cart to DB
            int salesAddedCount = 0;
            boolean isSalesAdded = false;
            try
            {
                SalesManager salesManager = new SalesManager();
                if(null != this.allSales)
                {
                    for (Sales newSale : this.allSales)
                    {
                         isSalesAdded = salesManager.AddSales(newSale);
                         if (isSalesAdded)
                         {
                             ++salesAddedCount;
                         }
                    }
                }
                
                // Validating the salesAddition to DB
                if (salesAddedCount == this.allSales.size())
                {
                    JOptionPane.showMessageDialog(null, "Sales saved successfully!");                    
                    int confirm = JOptionPane.showConfirmDialog(null, "Proceed to printing");
                    if (confirm == 0)
                    {
                        try
                        {
                            MessageFormat header = new MessageFormat
                                                  ("FEMINE CITY MOBILES - Billed on : " + new Date()
                                                 + "---------------------------------------------------"
                                                  );
                            MessageFormat footer = new MessageFormat
                                                  ("---------------------------------------------------"
                                                 + "Total Amount - " + CART_TOTAL
                                                  );
                            ASPS_Cart_Table.print(JTable.PrintMode.FIT_WIDTH,header, footer, true, null, true);
                        }
                        catch(Exception ex)
                        {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    }
                    this.SetFieldsEmpty();
                    this.ClearFieldsAfterSaving();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Problem while saving sales! Please try again!");
                }
            } 
            catch (Exception ex) 
            {
               JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_ASPS_SaveAndPrint_ButtonActionPerformed

    private void ChooserDialogTextBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ChooserDialogTextBoxKeyReleased
        // When searched for
        StockManager manager = null;
        ResultSet rs = null;
        String searchWord = ChooserDialogTextBox.getText();
        if(searchWord .length() > 0)
        {
            try {
                manager = new StockManager();
                rs = manager.GetTempStockDetailsOnSearching(searchWord);
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
            String quantity = String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,2));
            ITEM_QUANTITY = Integer.parseInt(quantity);
            if (ITEM_QUANTITY > 0)
            {
                // Set text field
                ASPS_StockID_TF.setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,0)));
                ASPS_Name_TF.setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,1)));
            }
            else
            {
                JOptionPane.showMessageDialog(null, "The selected item's stock is EMPTY!");
            }            

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

    private void ASPS_StockID_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ASPS_StockID_TFMouseClicked
        ChooserDialog.setSize(800, 500);
        ChooserDialog.setLocationRelativeTo(this);
        ChooserDialog.setVisible(true);
        this.PopulateSalesDetails();       
    }//GEN-LAST:event_ASPS_StockID_TFMouseClicked

    private void ASPS_RemoveFromCart_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASPS_RemoveFromCart_ButtonActionPerformed
        // Removing an item from
        int confirm = 0;
        boolean isRemoved = false;
        int selectedRow = ASPS_Cart_Table.getSelectedRow();
        if(selectedRow >= 0)
        {
            // Showing a confirmation dialog
            confirm = JOptionPane.showConfirmDialog(null, "Are you sure, that you want to remove the item from cart?");
            
            if (0 == confirm)
            {
                isRemoved = this.RemoveFromCart(selectedRow);
                if(isRemoved)
                {
                    JOptionPane.showMessageDialog(null, "Item removed from the cart!");
                    this.PopulateCart();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Item could not be removed!");
                }  
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, " Please select a row to continue...");
        }
    }//GEN-LAST:event_ASPS_RemoveFromCart_ButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ASPS_AddCartButton;
    private javax.swing.JTextField ASPS_Amount_TF;
    private javax.swing.JTextField ASPS_CartTotal_TF;
    private javax.swing.JTable ASPS_Cart_Table;
    private com.toedter.calendar.JDateChooser ASPS_DateChooser;
    private javax.swing.JTextField ASPS_FinalAmount_TF;
    private javax.swing.JTextField ASPS_GST_TF;
    private javax.swing.JTextField ASPS_Name_TF;
    private javax.swing.JTextField ASPS_Quantity_TF;
    private javax.swing.JButton ASPS_RefreshButton;
    private javax.swing.JButton ASPS_RemoveFromCart_Button;
    private javax.swing.JButton ASPS_SaveAndPrint_Button;
    private javax.swing.JTextField ASPS_StockID_TF;
    private javax.swing.JPanel ASPS_Table_Panel;
    private javax.swing.JPanel AddSalesItemsHolderPanel;
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
