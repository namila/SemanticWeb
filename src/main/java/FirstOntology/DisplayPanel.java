/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FirstOntology;

import com.sun.org.apache.xml.internal.dtm.DTM;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class DisplayPanel extends javax.swing.JFrame {

    /**
     * Creates new form DisplayPanel
     */
    public DisplayPanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_ResourceName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_getInferences = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_ResultTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txt_ResourceName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 110, -1));

        jLabel1.setText("Resource Name");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        btn_getInferences.setText("Get Inferences");
        btn_getInferences.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_getInferencesActionPerformed(evt);
            }
        });
        getContentPane().add(btn_getInferences, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 110, -1));

        table_ResultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject", "Predicate", "Object"
            }
        ));
        jScrollPane1.setViewportView(table_ResultTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 590, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_getInferencesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_getInferencesActionPerformed
        String resourceName = txt_ResourceName.getText();
        String resultString = ReasonerTrial.printStatements(resourceName);

        String[] resultsArray = resultString.split("\n");
        int numberOfResults=resultsArray.length;
        DefaultTableModel dtm=(DefaultTableModel) table_ResultTable.getModel();
        dtm.setRowCount(0);
        for (int i = 0; i < numberOfResults;++i) {
            Vector myVector=new Vector();
            StringBuilder currentBuilder=new StringBuilder(resultsArray[i]);
            currentBuilder.deleteCharAt(0);
            currentBuilder.deleteCharAt(currentBuilder.length()-1);
            String[] elementCollection=currentBuilder.toString().split(" ");
            
            for(int j=0;j<elementCollection.length;++j){
                if(elementCollection[j].contains("http://www.semanticweb.org/tmkasun/ontologies/2015/4/FIT#")){
                    myVector.add(elementCollection[j].split("#")[1]);
                }
                
                else{
                    myVector.add(elementCollection[j]);
                }
            }
            dtm.addRow(myVector);
        }


    }//GEN-LAST:event_btn_getInferencesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DisplayPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DisplayPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DisplayPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DisplayPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_getInferences;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_ResultTable;
    private javax.swing.JTextField txt_ResourceName;
    // End of variables declaration//GEN-END:variables
}
