/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesTrack.Stock;
import Database.StockManager;
import SalesTrack.Models.Stock;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Panickar
 */
public class AddStockPanel extends javax.swing.JPanel {

    /**
     * Creates new form ShortTermCourse
     */
    Stock newStocks;
    private ArrayList<Stock> allStocks ;
    private static Double CART_TOTAL;
    private static int CART_INDEX;
    
    public AddStockPanel() {
        initComponents();
        this.allStocks = new ArrayList<Stock>();
        CART_TOTAL = 0.0;
        CART_INDEX = 0;
    }
    
    private boolean AreFieldsEmpty()
    {
        if (ASP_Name_TF.getText().isEmpty() || ASP_Model_TF.getText().isEmpty() ||ASP_Quantity_TF.getText().isEmpty() || 
                ASP_PPP_TF.getText().isEmpty() || ASP_TotalPrice_TF.getText().isEmpty() ||
                        ((JTextField)ASP_DateChooser.getDateEditor().getUiComponent()).getText().isEmpty())
        {
            return true;
        }
        
        return false;
            
    }
    
    private void SetFieldsEmpty()
    {
        ASP_Model_TF.setText(null);
        ASP_Quantity_TF.setText(null);
        ASP_PPP_TF.setText(null);
        ASP_TotalPrice_TF.setText(null);
        ((JTextField)ASP_DateChooser.getDateEditor().getUiComponent()).setText(null);
    }

    /**
     * Populates the stock cart with added stocks
     */
    private void PopulateStockCart()
    {
        String name = ASP_Name_TF.getText();
        String modelNo = ASP_Model_TF.getText();
        int quantity = Integer.parseInt(ASP_Quantity_TF.getText());
        Double pricePerPiece = Double.parseDouble(ASP_PPP_TF.getText());
        Double totalPrice = Double.parseDouble(ASP_TotalPrice_TF.getText());
        java.sql.Date date =  new java.sql.Date(ASP_DateChooser.getDate().getTime());
        try
        {
            newStocks = new Stock();
            StockManager stockManager = new StockManager();
            try
            {
                // Initializing a new stock
                newStocks.SetName(name);
                newStocks.SetModelNo(modelNo);
                newStocks.SetQuantity(quantity);
                newStocks.SetPricePerPiece(pricePerPiece);
                newStocks.SetTotalPrice(totalPrice);
                newStocks.SetDate(date);
                
                // Adding the first stck to the cart
                this.allStocks.add(newStocks);
                if (this.PopulateStockCartTable())
                {
                    JOptionPane.showMessageDialog(null, "New stock added to the cart!");
                    this.SetFieldsEmpty();                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error! while adding the stock to cart. Pease check again.");
                }
                                       
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
        catch (Exception ex)
        {
                
        }
    }
    
    /**
     * Populates the display table while adding the stocks
     */
    private boolean PopulateStockCartTable()
    {
        CART_INDEX = 0;
        CART_TOTAL = 0.0;
        DefaultTableModel dm = (DefaultTableModel)ASP_Cart_Table.getModel();
        try
        {
            dm.setRowCount(0);
            if(null != this.allStocks)
            {
                this.allStocks.stream().forEach((stock) -> 
                {
                    CART_TOTAL += stock.GetTotalPrice();
                    dm.addRow(new Object[]
                    {
                        ++CART_INDEX,
                        stock.GetName(),
                        stock.GetModelNo(),
                        stock.GetQuantity(),
                        stock.GetPricePerPiece(),
                        stock.GetTotalPrice(),
                     });
                });
            }
            
            // Setting the cart_total
            ASP_CartTotal_TF.setText(Double.toString(CART_TOTAL));
        } 
        catch (Exception ex) 
        {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return dm.getRowCount() == this.allStocks.size();
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
    
    /***
     * Removes from the stock cart
     * @param rowNo
     * @return 
     */
    private boolean RemoveFromCart(int rowNo)
    {
        int currentSalesCount = this.allStocks.size();
        try
        {
            if (currentSalesCount > 0)
            {
                this.allStocks.remove(rowNo);
            }
        }
        catch (Exception ex) 
        {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return this.allStocks.size() == currentSalesCount - 1;
    }
    
    private void ClearFieldsAfterSaving()
    {
        // Clearing the Cart population table
        DefaultTableModel dm = (DefaultTableModel)ASP_Cart_Table.getModel();
        dm.setRowCount(0);
        this.allStocks.clear();
        // Clearing the total amount
        ASP_CartTotal_TF.setText(null);
        ASP_Name_TF.setText(null);
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
        AddStockItemsHolderPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ASP_Name_TF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        AddStockButton = new javax.swing.JButton();
        ASP_PPP_TF = new javax.swing.JTextField();
        ASP_TotalPrice_TF = new javax.swing.JTextField();
        ASP_Quantity_TF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ASP_DateChooser = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        ASP_Model_TF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ASP_Cart_Table = new javax.swing.JTable();
        ASP_CartTotal_TF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ASP_RefreshButton = new javax.swing.JButton();
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
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Add a new stock", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 11))); // NOI18N

        AddStockItemsHolderPanel.setBackground(new java.awt.Color(204, 219, 222));
        AddStockItemsHolderPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel2.setText("Name");

        ASP_Name_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ASP_Name_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        ASP_Name_TF.setPreferredSize(new java.awt.Dimension(5, 20));
        ASP_Name_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ASP_Name_TFMouseClicked(evt);
            }
        });
        ASP_Name_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASP_Name_TFActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel3.setText("Price per piece");

        jLabel8.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel8.setText("Total price");

        jLabel19.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel19.setText("Date");

        AddStockButton.setBackground(new java.awt.Color(51, 153, 0));
        AddStockButton.setFont(new java.awt.Font("Miriam Fixed", 1, 14)); // NOI18N
        AddStockButton.setForeground(new java.awt.Color(255, 255, 255));
        AddStockButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesTrack/Images/add.png"))); // NOI18N
        AddStockButton.setText("Add stock");
        AddStockButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStockButtonActionPerformed(evt);
            }
        });

        ASP_PPP_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ASP_PPP_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        ASP_PPP_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        ASP_TotalPrice_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ASP_TotalPrice_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        ASP_TotalPrice_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        ASP_Quantity_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ASP_Quantity_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        ASP_Quantity_TF.setPreferredSize(new java.awt.Dimension(5, 20));
        ASP_Quantity_TF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ASP_Quantity_TFMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel4.setText("Quantity");

        jLabel5.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel5.setText("Model no");

        ASP_Model_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ASP_Model_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        ASP_Model_TF.setPreferredSize(new java.awt.Dimension(5, 20));
        ASP_Model_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASP_Model_TFActionPerformed(evt);
            }
        });

        ASP_Cart_Table.setFont(new java.awt.Font("Miriam Fixed", 0, 12)); // NOI18N
        ASP_Cart_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Sl no", "Name", "Model no", "Quantity", "Date", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ASP_Cart_Table.setToolTipText("");
        jScrollPane1.setViewportView(ASP_Cart_Table);

        ASP_CartTotal_TF.setEditable(false);
        ASP_CartTotal_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        ASP_CartTotal_TF.setForeground(new java.awt.Color(153, 0, 0));
        ASP_CartTotal_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        ASP_CartTotal_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel6.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel6.setText("Total");

        ASP_RefreshButton.setBackground(new java.awt.Color(0, 51, 204));
        ASP_RefreshButton.setFont(new java.awt.Font("Miriam Fixed", 1, 12)); // NOI18N
        ASP_RefreshButton.setForeground(new java.awt.Color(255, 255, 255));
        ASP_RefreshButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesTrack/Images/clear.png"))); // NOI18N
        ASP_RefreshButton.setText("Refresh");
        ASP_RefreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASP_RefreshButtonActionPerformed(evt);
            }
        });

        ASPS_RemoveFromCart_Button.setBackground(new java.awt.Color(255, 51, 51));
        ASPS_RemoveFromCart_Button.setFont(new java.awt.Font("Miriam Fixed", 1, 14)); // NOI18N
        ASPS_RemoveFromCart_Button.setForeground(new java.awt.Color(255, 255, 255));
        ASPS_RemoveFromCart_Button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesTrack/Images/delete.png"))); // NOI18N
        ASPS_RemoveFromCart_Button.setText("Remove from cart");
        ASPS_RemoveFromCart_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ASPS_RemoveFromCart_ButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout AddStockItemsHolderPanelLayout = new javax.swing.GroupLayout(AddStockItemsHolderPanel);
        AddStockItemsHolderPanel.setLayout(AddStockItemsHolderPanelLayout);
        AddStockItemsHolderPanelLayout.setHorizontalGroup(
            AddStockItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, AddStockItemsHolderPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(AddStockItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(AddStockItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ASP_Model_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASP_Quantity_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASP_Name_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASP_PPP_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASP_TotalPrice_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASP_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASP_RefreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ASPS_RemoveFromCart_Button))
                .addGap(61, 61, 61)
                .addGroup(AddStockItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(AddStockItemsHolderPanelLayout.createSequentialGroup()
                        .addComponent(AddStockButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ASP_CartTotal_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        AddStockItemsHolderPanelLayout.setVerticalGroup(
            AddStockItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddStockItemsHolderPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(AddStockItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddStockItemsHolderPanelLayout.createSequentialGroup()
                        .addGroup(AddStockItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ASP_Name_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(AddStockItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ASP_Model_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(AddStockItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ASP_Quantity_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(AddStockItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(AddStockItemsHolderPanelLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel19))
                            .addGroup(AddStockItemsHolderPanelLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(ASP_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addGroup(AddStockItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ASP_PPP_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(15, 15, 15)
                        .addGroup(AddStockItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ASP_TotalPrice_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(ASP_RefreshButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(AddStockItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddStockItemsHolderPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 19, Short.MAX_VALUE)
                        .addGroup(AddStockItemsHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ASP_CartTotal_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(AddStockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(AddStockItemsHolderPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ASPS_RemoveFromCart_Button, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddStockItemsHolderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddStockItemsHolderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddStockButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddStockButtonActionPerformed
        if (this.allStocks.isEmpty())
        {
            JOptionPane.showMessageDialog(null, "The cart seems to be empty!");
        }
        else
        {
            // logic to add stock from cart to DB
            int stockAddedCount = 0;
            boolean isStockAdded = false, isCompanyUpdated = false;
            try
            {
                StockManager stockManager = new StockManager();
                if(null != this.allStocks)
                {
                    for (Stock newStock : this.allStocks)
                    {
                         isStockAdded = stockManager.AddStock(newStock);
                         isCompanyUpdated = stockManager.MapStockToCompany(newStock);
                         if (isStockAdded && isCompanyUpdated)
                         {
                             ++stockAddedCount;
                         }
                         else
                         {
                             break;
                         }
                    }
                }
                
                // Validating the stockAddition to DB
                if (stockAddedCount == this.allStocks.size())
                {
                    JOptionPane.showMessageDialog(null, "Stock saved successfully!");  
                    this.SetFieldsEmpty();
                    this.ClearFieldsAfterSaving();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Problem while saving stock! Please try again!");
                }
            } 
            catch (Exception ex) 
            {
               JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_AddStockButtonActionPerformed

    private void ASP_Name_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASP_Name_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ASP_Name_TFActionPerformed

    private void ASP_Model_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASP_Model_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ASP_Model_TFActionPerformed

    private void ASP_RefreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASP_RefreshButtonActionPerformed
        // Calculates the final amount
        if (this.AreFieldsEmpty())
        {
            JOptionPane.showMessageDialog(null, "Make sure that you have entered all valid fields!");
        }
        else
        {
            this.PopulateStockCart();
        }
    }//GEN-LAST:event_ASP_RefreshButtonActionPerformed

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
            ASP_Name_TF.setText(String.valueOf(ChooserDialogTable.getValueAt( ChooserDialogTable.getSelectedRow() ,1)));
            

            // dispose the search dialog
            ChooserDialog.dispose();
        }
    }//GEN-LAST:event_ChooserDialogOKButtonActionPerformed

    private void ChooserDialogCloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChooserDialogCloseButtonActionPerformed
        // Disposing search dialog
        ChooserDialog.dispose();
    }//GEN-LAST:event_ChooserDialogCloseButtonActionPerformed

    private void ASP_Quantity_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ASP_Quantity_TFMouseClicked
          
    }//GEN-LAST:event_ASP_Quantity_TFMouseClicked

    private void ASP_Name_TFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ASP_Name_TFMouseClicked
        ChooserDialog.setSize(800, 500);
        ChooserDialog.setLocationRelativeTo(this);
        ChooserDialog.setVisible(true);
        this.PopulateStockDetails(); 
    }//GEN-LAST:event_ASP_Name_TFMouseClicked

    private void ASPS_RemoveFromCart_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ASPS_RemoveFromCart_ButtonActionPerformed
        // Removing an item from
        int confirm = 0;
        boolean isRemoved = false;
        int selectedRow = ASP_Cart_Table.getSelectedRow();
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
                    this.PopulateStockCartTable();
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
    private javax.swing.JButton ASPS_RemoveFromCart_Button;
    private javax.swing.JTextField ASP_CartTotal_TF;
    private javax.swing.JTable ASP_Cart_Table;
    private com.toedter.calendar.JDateChooser ASP_DateChooser;
    private javax.swing.JTextField ASP_Model_TF;
    private javax.swing.JTextField ASP_Name_TF;
    private javax.swing.JTextField ASP_PPP_TF;
    private javax.swing.JTextField ASP_Quantity_TF;
    private javax.swing.JButton ASP_RefreshButton;
    private javax.swing.JTextField ASP_TotalPrice_TF;
    private javax.swing.JButton AddStockButton;
    private javax.swing.JPanel AddStockItemsHolderPanel;
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
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
