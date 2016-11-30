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
public  class Processor {
     public Processor() {
        
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
        
    }
   
  


    private class context {

    }

}
