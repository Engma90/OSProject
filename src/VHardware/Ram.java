/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VHardware;

import GUI.TextEditor;
import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JFrame;

/**
 *
 * @author MR.ROBOT
 */
public class Ram {
    
   public JFrame[] ramChip=new JFrame[3];
    public Queue<Integer> ready=new LinkedList<Integer>();
    //private JFrame []process = {TextEditor};
    
    
    
    public Ram(){
        
    }
    
    public void uploadToRam(int id){
        ready.add(id);
        System.out.println("id  is"+ready.peek());
           
       }
       
        
    
   
    public int downloadFromRam(){
            return ready.poll();
        }

        
    }

 


