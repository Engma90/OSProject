/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VHardware;

import java.util.PriorityQueue;
import java.util.Queue;
import javax.swing.JFrame;

/**
 *
 * @author MR.ROBOT
 */
public class Processor {

    private Queue Ready = new PriorityQueue();
    Ram ram = new Ram();

   /* private void dispatch() {
        ram.downloadFromRam();
        
        
    }*/
    public void  fork(int id){
       ram.uploadToRam(id);
        
        
    }
    public void dispatch(){
       int selector = ram.downloadFromRam();
            ram.ramChip[selector].setVisible(true);
                
            }
        }
    

    
    

   
    

