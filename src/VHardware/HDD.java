/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VHardware;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Sniper
 */
public class HDD {

    public final String location = new File("").getAbsolutePath() + "/HDD";

    public HDD() {

    }

    public static File read(String loc) {
        return new File(loc);
    }

    public static void write(String loc, String content) {
        File file = new File(loc);
        file.delete();
        File nfile = new File(loc);
        String source = content;
        try {
            FileWriter f2 = new FileWriter(nfile, false);
            f2.write(source);
            f2.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
