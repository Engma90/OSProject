/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VHardware;

import GUI.DT;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.PriorityQueue;
import java.util.Queue;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;

/**
 *
 * @author MR.ROBOT
 */
public  class Processor {
     public Processor() {
        
    }


    
    public static void main(String[] args) {
        biosBoot();
    }
    public static void biosBoot(){
        DT dt=new DT();
        Processor.fork(dt);
         dt.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                dt.setResizable(false);
                dt.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowActivated(WindowEvent e) {
                        //dt.setAlwaysOnTop(true);
                        //dt.toBack();
                    }
                });
        dt.setVisible(true);
    }
    
   //Ram ram = new Ram();

    public static void  fork(JFrame f){
       Ram.uploadToRam(f);
       
        
        
    }
//    public void  dispatch(){
//       int selector = ram.downloadFromRam();
//            ram.ramChip[selector].setVisible(true);
//            System.out.println("ramchip");
//                
//            }
        
    

    
    

   
    

   

    private final int timeSlice = 100;
    
    public static void terminate(JFrame f){
        Ram.releaseFromRam(f);
        
        
    }
   
  


    private class context {

    }

}
