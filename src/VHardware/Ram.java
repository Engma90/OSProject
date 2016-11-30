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
    
   public static  JFrame[] ramChip=new JFrame[10];
    public static  Queue<Integer> ready=new LinkedList<Integer>();
    //private JFrame []process = {TextEditor};
    
    
    
    public Ram(){
        
    }
   
    public static  void uploadToRam(JFrame f){
       for(int i=0; i<ramChip.length;i++){
           if(ramChip[i]==null){
               ramChip[i]=f;
               ready.add(i);
             //  System.out.println("id  is "+ready.peek());
               break;
               
               //
              
               
               
           }
           else if(i==(ramChip.length-1)){
                System.out.println("Ram is Full");
               
           }
          
          //System.out.println("content in Ramchip is " +ramChip[i].getName());
         
           
       }
       
        
        
        
           
       }
       
        
    
   
    public int downloadFromRam(){
            return ready.poll();
        }
    
    public static void releaseFromRam(JFrame f){
        for(int i = 0;i<ramChip.length;i++){
            if(ramChip[i]==f){
                ramChip[i]=null;
                
                break;
            }
                
        }
        
    }

        
    }

 


