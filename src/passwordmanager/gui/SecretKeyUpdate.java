/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager.gui;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import passwordmanager.Global;
import passwordmanager.bean.Account;
import passwordmanager.service.AccountService;
import passwordmanager.util.PasswordDigest;

/**
 *
 * @author Abdullah Shekhar
 */
public class SecretKeyUpdate extends javax.swing.JInternalFrame {

    /**
     * Creates new form SecretKeyUpdate
     */
    public SecretKeyUpdate() {
        initComponents();
        setButtonIcon();
        this.setTitle("Secret Key Settings");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlInfo = new javax.swing.JPanel();
        lblOldSecretKey = new javax.swing.JLabel();
        txtOldSecretKey = new javax.swing.JTextField();
        lblNewSecretKey = new javax.swing.JLabel();
        txtNewSecretKey = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        pnlInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Secret Key Info"));

        lblOldSecretKey.setText("Old Secret Key:");

        lblNewSecretKey.setText("New Secret Key:");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnClear.setText("Clear");

        javax.swing.GroupLayout pnlInfoLayout = new javax.swing.GroupLayout(pnlInfo);
        pnlInfo.setLayout(pnlInfoLayout);
        pnlInfoLayout.setHorizontalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblOldSecretKey)
                    .addComponent(lblNewSecretKey))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInfoLayout.createSequentialGroup()
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClear))
                    .addComponent(txtOldSecretKey, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNewSecretKey, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        pnlInfoLayout.setVerticalGroup(
            pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOldSecretKey)
                    .addComponent(txtOldSecretKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewSecretKey)
                    .addComponent(txtNewSecretKey, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUpdate)
                    .addComponent(btnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (txtOldSecretKey.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter your old secret key", Global.APP_NAME, 1);
            txtOldSecretKey.grabFocus();
        } else if (txtNewSecretKey.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter your new secret key", Global.APP_NAME, 1);
            txtNewSecretKey.grabFocus();
        } else {
            String oldSecretKey = "";
            String newSecretKey = "";
            try {
                oldSecretKey = PasswordDigest.digest(txtOldSecretKey.getText().trim());
                newSecretKey = PasswordDigest.digest(txtNewSecretKey.getText().trim());
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(SecretKeyUpdate.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(SecretKeyUpdate.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (Global.secretKey.equals(oldSecretKey)) {
                //Add Secret Key
                Preferences prefsRoot = Preferences.userRoot();
                Preferences myPrefs = prefsRoot.node(Global.USER_PREF);
                myPrefs.put("secretKey", newSecretKey);
                Global.secretKey = newSecretKey;

                //update account records
                ArrayList<Account> accountList = new ArrayList<>();
                if (AccountService.readAccounts() != null) {
                    accountList = AccountService.readAccounts();
                    ArrayList<Account> accountList2 = new ArrayList<>();
                    for (int i = 0; i < accountList.size(); i++) {
                        Account account=new Account();
                        account.setUserName(accountList.get(i).getUserName());
                        account.setPassword(accountList.get(i).getPassword());
                        account.setType(accountList.get(i).getType());
                        account.setUrl(accountList.get(i).getUrl());
                        account.setSecretKey(Global.secretKey);
                        accountList2.add(account);
                        
                    }
                    AccountService.insertAccount(accountList2);
                    JOptionPane.showMessageDialog(this, "Saved Successfully", Global.APP_NAME, 1);
                    dispose();
                }

            } else {
                JOptionPane.showMessageDialog(this, "Incorrect old secret key!", Global.APP_NAME, 0);
                txtOldSecretKey.setText("");
                txtOldSecretKey.grabFocus();
            }

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void setButtonIcon() {
        Image image = Toolkit.getDefaultToolkit().getImage(UserLogin.class.getResource("/resources/res/save.jpg"));
        Image newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(newimg);
        btnUpdate.setIcon(imageIcon);

        image = Toolkit.getDefaultToolkit().getImage(UserLogin.class.getResource("/resources/res/clear.jpg"));
        newimg = image.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(newimg);
        btnClear.setIcon(imageIcon);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel lblNewSecretKey;
    private javax.swing.JLabel lblOldSecretKey;
    private javax.swing.JPanel pnlInfo;
    private javax.swing.JTextField txtNewSecretKey;
    private javax.swing.JTextField txtOldSecretKey;
    // End of variables declaration//GEN-END:variables
}