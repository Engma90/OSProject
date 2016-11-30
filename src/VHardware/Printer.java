/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VHardware;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sniper
 */
public class Printer {
    
    public static void print(){
        try {
            Thread.sleep(15000);
            JOptionPane.showMessageDialog(null, "Printing Finished","Task compleated", JOptionPane.INFORMATION_MESSAGE);
        } catch (InterruptedException ex) {
            System.out.println("Printer interrupted");
        }
    }
    
}
