/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VHardware;

import GUI.MusicPlayer;
import GUI.TextEditor;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author MR.ROBOT
 */
public class Ram {
    
   public static  JFrame[] ramChip=new JFrame[2];
    public static  Queue<Integer> ready=new LinkedList<Integer>();
    public static boolean isFull=false;
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
                isFull=true;
                
               try {
                   
               FileWriter fw;
               
                   fw = new FileWriter(HDD.HDD_LOCATION+"/VM",true);
                   if(f.getName().equals("FileManager")||f.getName().equals("SystemMonitor")){
                   fw.append(f.getName()+"\n");
                   }
                   else if(f.getName().equals("MusicPlayer")){
                       MusicPlayer MP=(MusicPlayer)f;
                       fw.append(f.getName()+"----"+MP.getPath()+ "\n");
                   }
                   else if(f.getName().equals("TextEditor")){
                       TextEditor TE=(TextEditor)f;
                       fw.append(f.getName()+"----"+TE.getPath()+ "\n");
                   }
                   //fw.write(f.getName()+"\n");
                   fw.close();
                   
               } catch (IOException ex) {
                   Logger.getLogger(Ram.class.getName()).log(Level.SEVERE, null, ex);
               }
			
               
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
                isFull=false;
                break;
            }
                
        }
        
    }

        
    }

 


