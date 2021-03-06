/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SalesTrack.PersonalCredit;
import Database.PersonalCreditManager;
import SalesTrack.Models.PersonalCredit;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


/**
 *
 * @author Panickar
 */
public class AddPCPanel extends javax.swing.JPanel {

    /**
     * Creates new form ShortTermCourse
     */
    public AddPCPanel() {
        initComponents();
    }
    
    private void SetFieldsEmpty()
    {
        AEP_Name_TF.setText(null);
        AEP_Amount_TF.setText(null);
        ((JTextField)AEP_DateChooser.getDateEditor().getUiComponent()).setText(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AddExpenseHolderPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        AEP_Name_TF = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        AddExpenseButton = new javax.swing.JButton();
        AEP_Amount_TF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        AEP_DateChooser = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Add personal credit details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Miriam Fixed", 0, 11))); // NOI18N

        AddExpenseHolderPanel.setBackground(new java.awt.Color(204, 219, 222));
        AddExpenseHolderPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel2.setText("Name");

        AEP_Name_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        AEP_Name_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        AEP_Name_TF.setPreferredSize(new java.awt.Dimension(5, 20));
        AEP_Name_TF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AEP_Name_TFActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel19.setText("Date");

        AddExpenseButton.setBackground(new java.awt.Color(51, 153, 0));
        AddExpenseButton.setFont(new java.awt.Font("Miriam Fixed", 1, 14)); // NOI18N
        AddExpenseButton.setForeground(new java.awt.Color(255, 255, 255));
        AddExpenseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/SalesTrack/Images/add.png"))); // NOI18N
        AddExpenseButton.setText("Add new personal credit");
        AddExpenseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddExpenseButtonActionPerformed(evt);
            }
        });

        AEP_Amount_TF.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        AEP_Amount_TF.setMinimumSize(new java.awt.Dimension(5, 20));
        AEP_Amount_TF.setPreferredSize(new java.awt.Dimension(5, 20));

        jLabel4.setFont(new java.awt.Font("Miriam Fixed", 0, 14)); // NOI18N
        jLabel4.setText("Amount");

        javax.swing.GroupLayout AddExpenseHolderPanelLayout = new javax.swing.GroupLayout(AddExpenseHolderPanel);
        AddExpenseHolderPanel.setLayout(AddExpenseHolderPanelLayout);
        AddExpenseHolderPanelLayout.setHorizontalGroup(
            AddExpenseHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddExpenseHolderPanelLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(AddExpenseHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(AddExpenseHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AEP_Amount_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AEP_Name_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AEP_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AddExpenseButton))
                .addGap(82, 82, 82))
        );
        AddExpenseHolderPanelLayout.setVerticalGroup(
            AddExpenseHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddExpenseHolderPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(AddExpenseHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AEP_Name_TF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(AddExpenseHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AEP_Amount_TF, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31)
                .addGroup(AddExpenseHolderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AEP_DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(AddExpenseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddExpenseHolderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(AddExpenseHolderPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void AddExpenseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddExpenseButtonActionPerformed
     boolean isCreditAdded = false;
        
        String name = AEP_Name_TF.getText();
        Double amount = Double.parseDouble(AEP_Amount_TF.getText());
        java.sql.Date date =  new java.sql.Date(AEP_DateChooser.getDate().getTime());
        
        if (AEP_Name_TF.getText().isEmpty() || AEP_Amount_TF.getText().isEmpty() || ((JTextField)AEP_DateChooser.getDateEditor().getUiComponent()).getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "Some fields are empty! Please check.");
        }
        else
        {
           try
            {
                PersonalCredit newPersonalCredit = new PersonalCredit(0, name, amount, date);
                PersonalCreditManager newPersonalCreditManager = new PersonalCreditManager();
                isCreditAdded = newPersonalCreditManager.AddPersonalCredit(newPersonalCredit)? true: false;

                if(isCreditAdded)
                {
                    JOptionPane.showMessageDialog(null, "New personal credit added!");
                    this.SetFieldsEmpty();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error! while adding the personal credit. Pease check again.");
                }
            }
            catch (Exception ex)
            {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } 
        }   
    }//GEN-LAST:event_AddExpenseButtonActionPerformed

    private void AEP_Name_TFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AEP_Name_TFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AEP_Name_TFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField AEP_Amount_TF;
    private com.toedter.calendar.JDateChooser AEP_DateChooser;
    private javax.swing.JTextField AEP_Name_TF;
    private javax.swing.JButton AddExpenseButton;
    private javax.swing.JPanel AddExpenseHolderPanel;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
