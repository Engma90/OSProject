/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VHardware;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author MR.ROBOT
 */
public class Processor {

    public Processor() {
        dispatch();
    }

    private final int timeSlice = 100;
    //private Queue Ready=new PriorityQueue();
    Ram ram = new Ram();

    public void open(JFrame f) {
        for (int i = 0; i < ram.ramChip.length; i++) {
            if (ram.ramChip[i] == null) {
                ram.ramChip[i] = f;
            }
        }
    }

    private void dispatch() {
        Thread dispatcher = new Thread(new Runnable() {
            @Override
            public void run() {
                
                    for (int i = 0; i < ram.ramChip.length; i++) {
                        
                        if (ram.ramChip[i] != null) {
                            try {
                                Thread.sleep(3000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            ram.ramChip[i].setVisible(true);
                        }
                    }
                

            }
        });
        dispatcher.start();
    }

    private class context {

    }

}
