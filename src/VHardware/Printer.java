/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VHardware;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JFrame;

/**
 *
 * @author Sniper
 */
public final class Printer {

    static Queue<JFrame> PrintQueue = new LinkedList<>();
    static Thread T = null;

    public Printer() {
        Start();
    }

    public void Start() {

        T = new Thread(() -> {
            while (true) {
                while (!PrintQueue.isEmpty()) {
                    System.out.println("1111111111");
                    try {
                        PrintQueue.peek().setTitle(PrintQueue.peek().getTitle() + " -- Printing");
                        Thread.sleep(5000);
                        PrintQueue.poll().setTitle(PrintQueue.peek().getTitle().replace(" -- Printing", ""));
                        //JOptionPane.showMessageDialog(null, "Printing Finished","Task compleated", JOptionPane.INFORMATION_MESSAGE);
                    } catch (InterruptedException ex) {
                        System.out.println("Printer interrupted");
                    }

                }

            }
        });
        T.start();
    }

    public static void print(JFrame f) {
        PrintQueue.add(f);
    }

}
