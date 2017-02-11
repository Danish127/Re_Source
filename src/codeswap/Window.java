/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeswap;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author daniel
 */
public class Window extends javax.swing.JFrame {

    /**
     * Creates new form Window
     */
    private File inputFile;
    private File outputFile;
    FileFilter filter = new FileNameExtensionFilter("Java source file", "java");

    public Window() {
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

        inputBrowser = new javax.swing.JFileChooser();
        outputBrowser = new javax.swing.JFileChooser();
        inputBrowserField = new javax.swing.JTextField();
        inputBrowserButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        codeWindow = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        variableList = new javax.swing.JList<>();
        analyzeButton = new javax.swing.JButton();
        outputBrowserField = new javax.swing.JTextField();
        outputBrowserButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputBrowserField.setText("Select a file...");
        inputBrowserField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputBrowserFieldActionPerformed(evt);
            }
        });

        inputBrowserButton.setText("Browse...");
        inputBrowserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputBrowserButtonActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(codeWindow);

        variableList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(variableList);

        analyzeButton.setText("Analyze");
        analyzeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analyzeButtonActionPerformed(evt);
            }
        });

        outputBrowserField.setText("Select output destination...");

        outputBrowserButton.setText("Browse...");
        outputBrowserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputBrowserButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputBrowserField)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputBrowserButton)))
            .addComponent(analyzeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(outputBrowserField, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputBrowserButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputBrowserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputBrowserField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(analyzeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outputBrowserField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputBrowserButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputBrowserFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputBrowserFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputBrowserFieldActionPerformed

    private void inputBrowserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputBrowserButtonActionPerformed
        // TODO add your handling code here:
        inputBrowser.setFileFilter(filter);
        inputBrowser.showOpenDialog(this);

        if (inputBrowser.getSelectedFile() != null) {
            inputFile = inputBrowser.getSelectedFile();
            try {
                inputBrowserField.setText(inputFile.getCanonicalPath());
                FileReader reader = new FileReader(inputFile.getCanonicalPath());
                BufferedReader br = new BufferedReader(reader);
                codeWindow.read(br, null);
                br.close();
                codeWindow.requestFocus();
            } catch (IOException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_inputBrowserButtonActionPerformed

    private void outputBrowserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputBrowserButtonActionPerformed
        // TODO add your handling code here:
        outputBrowser.setFileFilter(filter);
        outputBrowser.showSaveDialog(this);
        if (outputBrowser.getSelectedFile() != null) {
            outputFile = outputBrowser.getSelectedFile();
            try {
                outputBrowserField.setText(outputFile.getCanonicalPath() + ".java");
                FileWriter writer = new FileWriter(outputFile.getCanonicalPath() + ".java");
                BufferedWriter bw = new BufferedWriter(writer);
                codeWindow.write(bw);
                bw.close();
                //codeWindow.setText("");
                codeWindow.requestFocus();
            } catch (IOException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_outputBrowserButtonActionPerformed

    private void analyzeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analyzeButtonActionPerformed
        // TODO add your handling code here:
        AnalyzeParser analyze = new AnalyzeParser(codeWindow, variableList);
        analyze.analyze();
        codeWindow = analyze.getFormattedOutputWindow();
    }//GEN-LAST:event_analyzeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analyzeButton;
    private javax.swing.JFormattedTextField codeWindow;
    private javax.swing.JFileChooser inputBrowser;
    private javax.swing.JButton inputBrowserButton;
    private javax.swing.JTextField inputBrowserField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JFileChooser outputBrowser;
    private javax.swing.JButton outputBrowserButton;
    private javax.swing.JTextField outputBrowserField;
    private javax.swing.JList<String> variableList;
    // End of variables declaration//GEN-END:variables
}
