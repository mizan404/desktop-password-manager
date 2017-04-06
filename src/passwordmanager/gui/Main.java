/*
 * Copyright (C) 2017 Abdullah Shekhar
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package passwordmanager.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import passwordmanager.Global;
import passwordmanager.PasswordManager;
import passwordmanager.bean.Account;
import passwordmanager.service.AccountService;

/**
 *
 * @author Abdullah Shekhar
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        setButtonIcon();
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/password.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane(){
            Image image = Toolkit.getDefaultToolkit().getImage(UserLogin.class.getResource("/resources/res/background.jpg"));
            Image newimage = image.getScaledInstance(1000,700,Image.SCALE_SMOOTH);

            //ImageIcon icon = new ImageIcon("res/background.jpg");
            //Image image = icon.getImage();

            //Image newimage = image.getScaledInstance(1000,700,Image.SCALE_SMOOTH);

            @Override
            protected void paintComponent(Graphics g)
            {
                super.paintComponent(g);
                g.drawImage(newimage, 0, 0,getWidth(), getHeight(), this);
            }
        };
        toolBar = new javax.swing.JToolBar();
        btnAccount = new javax.swing.JButton();
        btnUser = new javax.swing.JButton();
        btnBackup = new javax.swing.JButton();
        btnRestore = new javax.swing.JButton();
        btnHelp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Password Manager");
        getContentPane().add(desktopPane, java.awt.BorderLayout.CENTER);

        toolBar.setRollover(true);

        btnAccount.setText("Account");
        btnAccount.setFocusable(false);
        btnAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });
        toolBar.add(btnAccount);

        btnUser.setText("Settings");
        btnUser.setFocusable(false);
        btnUser.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUser.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserActionPerformed(evt);
            }
        });
        toolBar.add(btnUser);

        btnBackup.setText("Backup");
        btnBackup.setFocusable(false);
        btnBackup.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnBackup.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackupActionPerformed(evt);
            }
        });
        toolBar.add(btnBackup);

        btnRestore.setText("Restore");
        btnRestore.setFocusable(false);
        btnRestore.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRestore.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRestore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestoreActionPerformed(evt);
            }
        });
        toolBar.add(btnRestore);

        btnHelp.setText("Help");
        btnHelp.setFocusable(false);
        btnHelp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHelp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });
        toolBar.add(btnHelp);

        getContentPane().add(toolBar, java.awt.BorderLayout.PAGE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountActionPerformed
        Accounts m = new Accounts();
        m.setSize(700, 550);
        Dimension desktopSize = desktopPane.getSize();
        Dimension jInternalFrameSize = m.getSize();
        m.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
        m.setVisible(true);
        m.setClosable(true);
        m.setResizable(true);
        m.setMaximizable(true);
        m.setIconifiable(true);
        desktopPane.add(m);
        try {
            m.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_btnAccountActionPerformed

    private void btnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserActionPerformed
        UpdateUser m = new UpdateUser();
        Dimension desktopSize = desktopPane.getSize();
        Dimension jInternalFrameSize = m.getSize();
        m.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
        m.setVisible(true);
        m.setClosable(true);
        m.setResizable(false);
        m.setMaximizable(false);
        m.setIconifiable(true);
        desktopPane.add(m);
        try {
            m.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }


    }//GEN-LAST:event_btnUserActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        Help m = new Help();
        //Dimension desktopSize = desktopPane.getSize();
        //Dimension jInternalFrameSize = m.getSize();
        //m.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
        //(desktopSize.height - jInternalFrameSize.height) / 2);

        m.setSize(desktopPane.getSize());
        m.setVisible(true);
        m.setClosable(true);
        m.setResizable(true);
        m.setMaximizable(true);
        m.setIconifiable(true);
        desktopPane.add(m);
        try {
            m.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupActionPerformed
        if (AccountService.readAccounts() != null) {

            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save");
            FileFilter filter = new FileNameExtensionFilter("ser file", new String[] {"ser"});
            fileChooser.setFileFilter(filter);
            fileChooser.addChoosableFileFilter(filter);
            int userSelection = fileChooser.showSaveDialog(this);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                try {
                    ArrayList<Account> accountList = AccountService.readAccounts();
                    
                    FileOutputStream fos = new FileOutputStream(fileChooser.getSelectedFile() + ".ser");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(accountList);
                    oos.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //JOptionPane.showMessageDialog(this, fileChooser.getSelectedFile());
                //File fileToSave = fileChooser.getSelectedFile();
                //System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            }
        } else {
            JOptionPane.showMessageDialog(this, "You Have No Data To Backup!");
        }
    }//GEN-LAST:event_btnBackupActionPerformed

    private void btnRestoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestoreActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open");
        int userSelection = fileChooser.showOpenDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            try {
                //read data from backup file
                ArrayList<Account> accountList2 = new ArrayList<>();
                if (AccountService.readAccountsRestore(fileChooser.getSelectedFile().getAbsolutePath()) != null) {
                    accountList2 = AccountService.readAccountsRestore(fileChooser.getSelectedFile().getAbsolutePath());
                    ArrayList<Account> accountList = new ArrayList<>();
                    if (AccountService.readAccounts() != null) {
                        accountList = AccountService.readAccounts();
                        accountList2.addAll(accountList);
                    }
                    //If the data file not exist or for first time uses
                    File file = new File(Global.ACCOUNT_FILE);
                    if (!file.exists()) {
                        new File(Global.ACCOUNT_FILE_PATH).mkdirs();
                        try {
                            file.createNewFile();
                        } catch (Exception ex) {
                            Logger.getLogger(PasswordManager.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    //Insert to main datafile
                    if(AccountService.insertAccount(accountList2)){
                        JOptionPane.showMessageDialog(this, "Data restored successfully!!", "Password Manager", 1);
                    }

                } else {
                    JOptionPane.showMessageDialog(this, "The file have no data!", "Password Manager", 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnRestoreActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    private void setButtonIcon() {
        Image image = Toolkit.getDefaultToolkit().getImage(UserLogin.class.getResource("/resources/res/account.png"));
        Image newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newimg);
        btnAccount.setIcon(imageIcon);

        image = Toolkit.getDefaultToolkit().getImage(UserLogin.class.getResource("/resources/res/user_settings.png"));
        newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        btnUser.setIcon(imageIcon);

        image = Toolkit.getDefaultToolkit().getImage(UserLogin.class.getResource("/resources/res/help.png"));
        newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        btnHelp.setIcon(imageIcon);

        image = Toolkit.getDefaultToolkit().getImage(UserLogin.class.getResource("/resources/res/backup.png"));
        newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        btnBackup.setIcon(imageIcon);

        image = Toolkit.getDefaultToolkit().getImage(UserLogin.class.getResource("/resources/res/restore.png"));
        newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        btnRestore.setIcon(imageIcon);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnBackup;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnRestore;
    private javax.swing.JButton btnUser;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables

}
