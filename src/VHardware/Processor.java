/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VHardware;

import GUI.DT;
import GUI.FileManager;
import GUI.MusicPlayer;
import GUI.SystemMonitor;
import static GUI.SystemMonitor.items;
import GUI.TextEditor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MR.ROBOT and saddam
 */
public class Processor {

    private static final int timeSlice = 1000;
    public static SystemMonitor sm = new SystemMonitor();
    public static Printer printer = new Printer();

    public Processor() {

    }

    public static void main(String[] args) {
        biosBoot();
        dispatch();
    }

    public static void biosBoot() {
        DT dt = new DT();

        dt.setExtendedState(JFrame.MAXIMIZED_BOTH);
        dt.setResizable(false);
        dt.setTitle("Desktop");
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
    public static void fork(JFrame f) {
        Ram.uploadToRam(f);

        SystemMonitor.items.add(new SystemMonitor.Node(f, "Ready"));

    }

    public static void dispatch() {

        Thread shortTerm = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (!Ram.ready.isEmpty()) {

                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        System.out.println(Ram.ready.size());
                        for (int i = 0; i < items.size(); i++) {
                            if (items.get(i).f.equals(Ram.ramChip[Ram.ready.peek()])) {
                                items.get(i).status = "Running";
                                break;
                            }
                        }
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

        Thread longTerm = new Thread(new Runnable() {
            @Override
            public void run() {

                while (true) {
                    if (!Ram.isFull) {
                        try {
                            String Swapin = null;
                            try {
                                Swapin = removeNthLine(HDD.HDD_LOCATION + "/VM", 0).trim();
                                
                            } catch (NullPointerException ex) {

                            }
                            System.out.println(Swapin);
                            if (!(Swapin == null)) {
                                JFrame frame;
                                switch (Swapin.split("----")[0]) {
                                    case "FileManager":
                                        frame = new FileManager();
                                        fork(frame);
                                        break;
                                    case "SystemMonitor":
                                        frame = new SystemMonitor();
                                        fork(frame);
                                        break;
                                    case "MusicPlayer":
                                        frame = new MusicPlayer(Swapin.split("----")[1]);
                                        fork(frame);
                                        break;
                                    case "TextEditor":
                                        frame = new TextEditor(Swapin.split("----")[1]);
                                        fork(frame);
                                        break;
                                    default:
                                        break;
                                }
                            }

                        } catch (IOException ex) {
                            Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                    }
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });
        longTerm.start();

    }

    public static String removeNthLine(String f, int toRemove) throws IOException {
        String retVal;
        // Leave the n first lines unchanged.
        try (RandomAccessFile raf = new RandomAccessFile(f, "rw")) {
            // Leave the n first lines unchanged.
            retVal = raf.readLine();
            
            // Shift remaining lines upwards.
            long writePos =0;// raf.getFilePointer();
            //raf.readLine();
            long readPos = raf.getFilePointer();
            
            byte[] buf = new byte[1024];
            int n;
            while (-1 != (n = raf.read(buf))) {
                raf.seek(writePos);
                raf.write(buf, 0, n);
                readPos += n;
                writePos += n;
                raf.seek(readPos);
            }

            raf.setLength(writePos);
        }
        return retVal;
    }

    public static void terminate(JFrame f) {
        
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).f.equals(f)) {
                items.remove(i);
                break;
            }
        }
        Ram.releaseFromRam(f);

    }

    public static File readSegnal(String loc) {
        return HDD.read(loc);
    }

    public static void writeSegnal(String loc, String content) {
        HDD.write(loc, content);
    }

    private class context {

    }

}
