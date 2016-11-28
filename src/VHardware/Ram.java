/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VHardware;

/**
 *
 * @author MR.ROBOT
 */
public class Ram {
    
    private final String[] ramChip=new String[10];
    
    public Ram(){
        
    }
    
    public void uploadToRam(int location,String content){
        
        ramChip[location]=content;
        
    }
    
    public String downloadFromRam(int location){
        
        return ramChip[location];
        
    }
    
}
