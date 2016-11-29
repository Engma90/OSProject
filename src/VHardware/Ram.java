/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VHardware;

import javax.swing.JFrame;

/**
 *
 * @author MR.ROBOT
 */
public class Ram {
    
    public final JFrame[] ramChip=new JFrame[10];
    //public 
    
    public Ram(){
        
    }
    
    public void uploadToRam(int location,JFrame content){
        
        ramChip[location]=content;
        
    }
    
    public JFrame downloadFromRam(int location){
        
        return ramChip[location];
        
    }
    
}
