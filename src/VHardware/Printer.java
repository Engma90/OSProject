/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VHardware;

import GUI.SystemMonitor;
import static GUI.SystemMonitor.items;
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
                        for (int i = 0; i < items.size(); i++) {
                            if (items.get(i).f.equals(PrintQueue.peek())) {
                                items.get(i).status="Waiting";
                                break;
                            }
                        }
                        Thread.sleep(10000);
                        for (int i = 0; i < items.size(); i++) {
                            if (items.get(i).f.equals(PrintQueue.peek())) {
                                
                                items.get(i).status="Ready";
                                Thread.sleep(2000);
                                items.get(i).status="Running";
                                break;
                            }
                        }
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