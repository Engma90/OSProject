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
 * @author MR.ROBOT and saddam
 */
public  class Processor {
     public Processor() {
        
    }


    
    public static void main(String[] args) {
        biosBoot();
        dispatch();
    }
    public static void biosBoot(){
        DT dt=new DT();
        
         dt.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                dt.setResizable(false);
                dt.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowActivated(WindowEvent e) {
                        //dt.setAlwaysOnTop(true);
                        //dt.toBack();
                    }
                });
                Processor.fork(dt);
        //dt.setVisible(true);
    }
    
   //Ram ram = new Ram();

    public static void  fork(JFrame f){
       Ram.uploadToRam(f);
       
        
        
    }
    
    public static void  dispatch(){
       
        Thread shortTerm =new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    if(!Ram.ready.isEmpty()){
                        
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        
                        System.out.println(Ram.ready.size());
                        Ram.ramChip[Ram.ready.poll()].setVisible(true);
                        System.out.println(Ram.ready.size());
                        
                        
                    }
                    try {
                            Thread.sleep(timeSlice);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }


            }
        });
        shortTerm.start();
        
                
            }
        
    

    
    

   
    

   

    private static final int timeSlice = 1000;
    
    public static void terminate(JFrame f){
        Ram.releaseFromRam(f);
        
        
    }
   
  


    private class context {

    }

}
