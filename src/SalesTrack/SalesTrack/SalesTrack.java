/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SalesTrack.SalesTrack;

import SalesTrack.Login.LoginForm;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author arun
 */
public class SalesTrack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try
        {
            // TODO code application logic here
            // Setting the look and feel for the application
            try {
                // Set cross-platform Java L&F (also called "Metal")
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            }
            catch (UnsupportedLookAndFeelException e) {
                // handle exception
            }
            catch (ClassNotFoundException e) {
                // handle exception
            }
            catch (InstantiationException e) {
                // handle exception
            }
            catch (IllegalAccessException e) {
                // handle exception
            }
            
            new LoginForm().setVisible(true);
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
}
