/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import VHardware.Ram;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author MR.ROBOT
 */
public class SystemMonitor extends javax.swing.JFrame {
   public static class Node{
       public JFrame f;
       public String status;
       public Node(JFrame f ,String s){
           this.f = f;
           this.status = s;
       }
       public Node(){
           
       }
      
   }
   public static LinkedList<Node>items = new LinkedList<Node>();

    /**
     * Creates new form SystemMonitor
     */
     public void clearRows() {
         DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        int rowCount = model.getRowCount();
//Remove rows one by one from the end of the table
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    public SystemMonitor() {
        initComponents();
        setAlwaysOnTop(true);
            monitor();
    }

     /*   Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        // try {
                        
                        for (int i = 0; i < Ram.ramChip.length; i++) {
                            if(Ram.ramChip[i]!=null){
                               // Thread.sleep(1000);
                           model.addRow(new Object[]{Ram.ramChip[i].getTitle(), "READY"});
                         //  Thread.sleep(2000);
                        System.out.println("1");}
                            else{
                                Thread.sleep(500);
                            }
                        
                        
                        
                        
                        
                        
                        }
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SystemMonitor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                       // 
                          
        //    Thread t2= new Thread(new Runnable() {
                //        @Override
                 //       public void run() {
                           //   try {
                        // }
                        // } catch (InterruptedException ex) {
                        //  Logger.getLogger(SystemMonitor.class.getName()).log(Level.SEVERE, null, ex);
                        //  }
                        
                        //  try {
                        
                        // DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                      //  clearRows();
                         
                      //  for (int i = 0; i < Ram.ramChip.length; i++) {
                         //   if(Ram.ramChip[i]!=null){
                            //    Thread.sleep(2000);
                         //   model.addRow(new Object[]{Ram.ramChip[i].getTitle(), "Running"});
                        //    Thread.sleep(1000);
                      //  System.out.println("2");}
                          //  else{
                           //     Thread.sleep(500);
                         //   }
                     //   }
                  //  } catch (InterruptedException ex) {
                  //      Logger.getLogger(SystemMonitor.class.getName()).log(Level.SEVERE, null, ex);
                 //   }
                //        }
                //    });
         //   t2.start();
                  
                        
                        //for (int i = 0; i < Ram.ramChip.length; i++) {
                           // model.addRow(new Object[]{Ram.ramChip[i].getName(), "Ready"});
                           

                      //  }
                   // } catch (InterruptedException ex) {
                    //    Logger.getLogger(SystemMonitor.class.getName()).log(Level.SEVERE, null, ex);
                   // }

              //  }
           // }

          //  private void Thread(Runnable runnable) {
           //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         //   }
      //  });
       // t.start();
    }
            }
                });
         t.start();
    }
        */
    
    public  void monitor(){
          
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
             DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
                while(true){
                    
                    for (int i = 0; i < items.size(); i++) {
                        
                        model.addRow(new Object[]{items.get(i).f.getTitle(),items.get(i).status});
                        
                    }
                            
                 try {
                     Thread.sleep(1000);
                 } catch (InterruptedException ex) {
                     Logger.getLogger(SystemMonitor.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 clearRows();
               
                
                    
                   
                           
                   
                
                      
                    
                    
                
            }
            }
        });
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Process", "State"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SystemMonitor sm = new SystemMonitor();
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
