/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VHardware;

import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Sniper
 */
public final class Printer {

    public static Queue<JFrame> PrintQueue = new LinkedList<>();
    static Thread T = null;

    public Printer() {
        Start();
    }

    public void Start() {

        T = new Thread(() -> {
            while (true) {
                while (!PrintQueue.isEmpty()) {
                    
                    try {
                        PrintQueue.peek().setTitle(PrintQueue.peek().getTitle() + " -- Printing");
                        Thread.sleep(5000);
                        PrintQueue.peek().setTitle(PrintQueue.poll().getTitle().replace(" -- Printing", ""));
                        //JOptionPane.showMessageDialog(null, "Printing Finished","Task compleated", JOptionPane.INFORMATION_MESSAGE);
                    } catch (InterruptedException ex) {
                        System.out.println("Printer interrupted");
                    }

                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Printer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        T.start();
    }

    public static void print(JFrame f) {
        PrintQueue.add(f);
    }

}