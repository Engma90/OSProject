/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VHardware;

import java.io.File;

/**
 *
 * @author Sniper
 */
public class HDD {
    private final String location=new File("").getAbsolutePath()+"/HDD";
    
    public HDD(){
        File HD=new File(location);
        System.out.println(location);
        System.out.println(HD.isDirectory());//
    }
    
    
}
