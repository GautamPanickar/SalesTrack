/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesTrack.Action;
import javax.swing.JPanel;
import AplicationEnums.Functionality;
import SalesTrack.Summary.ExpenseSummaryPanel;
import SalesTrack.Summary.SalesSummaryPanel;

/**
 *
 * @author User
 */
public class SummaryActionPanel extends javax.swing.JPanel {

    /**
     *  The course panel
     */
    private Functionality option;
    
    
    /**
     * Creates new form CourseActionPanel
     */
    public SummaryActionPanel() {
        initComponents();
    }
     
    /**
     * The parameterized constructor
     * @param panel 
     */
    public SummaryActionPanel(Functionality option)
    {
        initComponents();
        this.option = option;
    }
    
    /**
     * Sets the panel visibility
     * @param panel 
     */
    private void SetPanelVisibility( JPanel panel ){
        
        this.AP_ActionPanelHolder_Panel.removeAll();
        this.AP_ActionPanelHolder_Panel.repaint();
        this.AP_ActionPanelHolder_Panel.revalidate();
        
        this.AP_ActionPanelHolder_Panel.add(panel);
        this.AP_ActionPanelHolder_Panel.repaint();
        this.AP_ActionPanelHolder_Panel.revalidate();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CAP_ButtonHolder_Panel = new javax.swing.JPanel();
        ActionPanel_SalesButton = new javax.swing.JButton();
        ActionPanel_ExpenseButton = new javax.swing.JButton();
        AP_ActionPanelHolder_Panel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        CAP_ButtonHolder_Panel.setLayout(new java.awt.GridLayout(1, 0));

        ActionPanel_SalesButton.setBackground(new java.awt.Color(51, 153, 0));
        ActionPanel_SalesButton.setFont(new java.awt.Font("Miriam Fixed", 1, 12)); // NOI18N
        ActionPanel_SalesButton.setForeground(new java.awt.Color(255, 255, 255));
        ActionPanel_SalesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesTrack/Images/sales.png"))); // NOI18N
        ActionPanel_SalesButton.setText("Sales summary");
        ActionPanel_SalesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPanel_SalesButtonActionPerformed(evt);
            }
        });
        CAP_ButtonHolder_Panel.add(ActionPanel_SalesButton);

        ActionPanel_ExpenseButton.setBackground(new java.awt.Color(0, 102, 102));
        ActionPanel_ExpenseButton.setFont(new java.awt.Font("Miriam Fixed", 1, 12)); // NOI18N
        ActionPanel_ExpenseButton.setForeground(new java.awt.Color(255, 255, 255));
        ActionPanel_ExpenseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesTrack/Images/expense.png"))); // NOI18N
        ActionPanel_ExpenseButton.setText("Expense summary");
        ActionPanel_ExpenseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionPanel_ExpenseButtonActionPerformed(evt);
            }
        });
        CAP_ButtonHolder_Panel.add(ActionPanel_ExpenseButton);

        AP_ActionPanelHolder_Panel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        AP_ActionPanelHolder_Panel.setLayout(new java.awt.GridLayout(1, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(CAP_ButtonHolder_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
            .addComponent(AP_ActionPanelHolder_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(CAP_ButtonHolder_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(AP_ActionPanelHolder_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
     
    
    /**
     * On clicking new button 
     * @param evt 
     */
    private void ActionPanel_SalesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionPanel_SalesButtonActionPerformed
        SalesSummaryPanel salesSummaryPanel = new SalesSummaryPanel();
        this.SetPanelVisibility(salesSummaryPanel);
    }//GEN-LAST:event_ActionPanel_SalesButtonActionPerformed

    /**
     * On clicking the update course button
     * @param evt 
     */
    private void ActionPanel_ExpenseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ActionPanel_ExpenseButtonActionPerformed
        ExpenseSummaryPanel expenseSummaryPanel = new ExpenseSummaryPanel();
        this.SetPanelVisibility(expenseSummaryPanel);
    }//GEN-LAST:event_ActionPanel_ExpenseButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AP_ActionPanelHolder_Panel;
    private javax.swing.JButton ActionPanel_ExpenseButton;
    private javax.swing.JButton ActionPanel_SalesButton;
    private javax.swing.JPanel CAP_ButtonHolder_Panel;
    // End of variables declaration//GEN-END:variables
}