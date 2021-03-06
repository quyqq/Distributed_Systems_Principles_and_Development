/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPFileSharing;

import UDP.*;
import java.io.File;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author quyqq
 */
public class PPFileSharing extends javax.swing.JFrame implements IView{
    private final IPMulticast iPMulticast;
    /**
     * Creates new form PPFileSharing
     */
    public PPFileSharing() {
        initComponents();        
        
        iPMulticast = new IPMulticast(this);        
        jTextFieldPeerID.setText("Peer"+String.valueOf((int)(Math.random()*20000)+1000));
        jTextFieldReceivingPort.setText(String.valueOf((int)(Math.random()*20000)+10000));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextFieldGroupIP = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaLogUDP = new javax.swing.JTextArea();
        jButtonEdit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldGroupPort = new javax.swing.JTextField();
        jTextFieldReceivingPort = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldPeerID = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldFileName = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButtonleave = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaLogTCP = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelPath = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListListShearingFile = new javax.swing.JList<>();
        jButtonListShearingFile = new javax.swing.JButton();
        jButtonOpenSelectedFile = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jProgressBarUpload = new javax.swing.JProgressBar();
        jProgressBarDownload = new javax.swing.JProgressBar();
        jTextFieldPath = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shearing File System");
        setResizable(false);

        jTextFieldGroupIP.setText("224.0.0.0");
        jTextFieldGroupIP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGroupIPActionPerformed(evt);
            }
        });

        jTextAreaLogUDP.setEditable(false);
        jTextAreaLogUDP.setColumns(20);
        jTextAreaLogUDP.setRows(5);
        jScrollPane1.setViewportView(jTextAreaLogUDP);

        jButtonEdit.setText("Join Group");
        jButtonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditActionPerformed(evt);
            }
        });

        jLabel1.setText("Group IP:");

        jLabel2.setText("Receiving Port:");

        jLabel3.setText("Group Port:");

        jTextFieldGroupPort.setText("6789");

        jTextFieldReceivingPort.setText("5000");

        jLabel4.setText("Peer ID:");

        jTextFieldPeerID.setText("Peer1");

        jLabel5.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel5.setText("Setting");

        jLabel6.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel6.setText("Search");

        jLabel7.setText("File Name:");

        jButtonSearch.setText("Search");
        jButtonSearch.setEnabled(false);
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel8.setText("Log UDP");

        jButtonleave.setText("Leave Group");
        jButtonleave.setEnabled(false);
        jButtonleave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonleaveActionPerformed(evt);
            }
        });

        jTextAreaLogTCP.setEditable(false);
        jTextAreaLogTCP.setColumns(20);
        jTextAreaLogTCP.setRows(5);
        jScrollPane2.setViewportView(jTextAreaLogTCP);

        jLabel9.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabel9.setText("Log TCP");

        jLabelPath.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        jLabelPath.setText("Files in shared folder:");

        jScrollPane3.setViewportView(jListListShearingFile);

        jButtonListShearingFile.setText("List sharing files");
        jButtonListShearingFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListShearingFileActionPerformed(evt);
            }
        });

        jButtonOpenSelectedFile.setText("Open Selected File");
        jButtonOpenSelectedFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenSelectedFileActionPerformed(evt);
            }
        });

        jLabel10.setText("Upload:");

        jLabel11.setText("Download:");

        jTextFieldPath.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabelPath)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPath))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jSeparator4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(29, 29, 29)
                                .addComponent(jProgressBarUpload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jProgressBarDownload, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButtonListShearingFile)
                                .addGap(220, 220, 220))
                            .addComponent(jScrollPane3)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldGroupIP)
                                            .addComponent(jTextFieldGroupPort, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldReceivingPort)
                                            .addComponent(jTextFieldPeerID, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jSeparator1)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jSeparator2)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                        .addComponent(jLabel7)
                                                        .addGap(24, 24, 24)
                                                        .addComponent(jTextFieldFileName, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jButtonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(64, 64, 64)
                                                .addComponent(jButtonleave, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(100, 100, 100))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(211, 211, 211)
                                .addComponent(jButtonOpenSelectedFile)))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldGroupIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldPeerID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldGroupPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldReceivingPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEdit)
                    .addComponent(jButtonleave))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(6, 6, 6)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldFileName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jProgressBarUpload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11))
                            .addComponent(jProgressBarDownload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPath)
                    .addComponent(jTextFieldPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonListShearingFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonOpenSelectedFile)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        iPMulticast.broadcastMSG();
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jButtonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditActionPerformed
        
        iPMulticast.joinGroup();  
    }//GEN-LAST:event_jButtonEditActionPerformed

    private void jButtonleaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonleaveActionPerformed
       iPMulticast.leaveGroup();
    }//GEN-LAST:event_jButtonleaveActionPerformed

    private void jTextFieldGroupIPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGroupIPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGroupIPActionPerformed

    private void jButtonListShearingFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListShearingFileActionPerformed
       iPMulticast.reloadListFiles();
    }//GEN-LAST:event_jButtonListShearingFileActionPerformed

    private void jButtonOpenSelectedFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenSelectedFileActionPerformed
        if(jListListShearingFile.getSelectedIndex()>=0)
            iPMulticast.openFile(jListListShearingFile.getSelectedValue());
        else
            showErrorDialog("Please select a file in the list");
    }//GEN-LAST:event_jButtonOpenSelectedFileActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
         try {
            new File("SharedFolder").mkdir();
        } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "SharedFolder can not be created: "+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        
        
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
            java.util.logging.Logger.getLogger(PPFileSharing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PPFileSharing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PPFileSharing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PPFileSharing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        new File("SharedFolder").mkdir();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PPFileSharing().setVisible(true);               
                IPMulticast.reloadListFiles();

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonEdit;
    private javax.swing.JButton jButtonListShearingFile;
    private javax.swing.JButton jButtonOpenSelectedFile;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JButton jButtonleave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelPath;
    private javax.swing.JList<String> jListListShearingFile;
    private javax.swing.JProgressBar jProgressBarDownload;
    private javax.swing.JProgressBar jProgressBarUpload;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea jTextAreaLogTCP;
    private javax.swing.JTextArea jTextAreaLogUDP;
    private javax.swing.JTextField jTextFieldFileName;
    private javax.swing.JTextField jTextFieldGroupIP;
    private javax.swing.JTextField jTextFieldGroupPort;
    private javax.swing.JTextField jTextFieldPath;
    private javax.swing.JTextField jTextFieldPeerID;
    private javax.swing.JTextField jTextFieldReceivingPort;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getGroupIP() {
     
        return jTextFieldGroupIP.getText();
    }

    @Override
    public String getGroupPort() {
        return jTextFieldGroupPort.getText();
    }

    @Override
    public String getPeerID() {
        return jTextFieldPeerID.getText();
    }

    @Override
    public String getRecievingPort() {
        return jTextFieldReceivingPort.getText();
    }

    @Override
    public void showErrorDialog(String msg) {
        JOptionPane.showMessageDialog(this, msg,"Error",JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public String getFileName() {
        return jTextFieldFileName.getText();
    }
   

    @Override
    public void setLogUDP(String msg) {
        jTextAreaLogUDP.setText(msg+"\n"+jTextAreaLogUDP.getText());
    }
    @Override
    public void setLogTCP(String msg) {
        jTextAreaLogTCP.setText(msg+"\n"+jTextAreaLogTCP.getText());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setListFiles(Set<String> list) {
       DefaultListModel defaultListModel = new DefaultListModel();
       list.forEach(x->defaultListModel.addElement(x));
       jListListShearingFile.setModel(defaultListModel);
    }

    @Override
    public void setPathSharedFolder(String path) {
        jTextFieldPath.setText(path);
    }

    @Override
    public void setUploadePorcess(int current,int max) {
        
        jProgressBarUpload.setMaximum(max);
        jProgressBarUpload.setValue(current);
    }

    @Override
    public void setDownloadProcess(int current,int max) {
        jProgressBarDownload.setMaximum(max);
        jProgressBarDownload.setValue(current);
    }

    @Override
    public void setEnable(boolean state) {
        jTextFieldGroupIP.setEnabled(state);
        jTextFieldGroupPort.setEnabled(state);
        jTextFieldPeerID.setEnabled(state);
        jTextFieldReceivingPort.setEnabled(state);
        jButtonSearch.setEnabled(!state);
        jButtonEdit.setEnabled(state);
        jButtonleave.setEnabled(!state);
    }
    
}
