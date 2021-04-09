package luongnd.view;

import luongnd.Server2.ArmorServer;
import luongnd.dto.ArmorDTO;
import luongnd.Server2.ArmorInterface;
import luongnd.Server2.Validate;
import java.awt.HeadlessException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ArmorUI extends javax.swing.JFrame {

    Validate v = new Validate();
    List<ArmorDTO> listArmor;
    String url = "rmi://localhost:1098/armor";
    ArmorInterface ai;
    DefaultTableModel model = new DefaultTableModel();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    boolean checkAddNew = true;

    Date date;

    public ArmorUI() {
        initComponents();
        try {
            ai = (ArmorInterface) Naming.lookup(url);
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            // e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Start server please.");
        }
        listArmor = new ArrayList<>();
        loadData();
        txtTimeOfCreate.setEnabled(false);
    }

    private void displayArmor() {
        model = (DefaultTableModel) tblArmor.getModel();
        model.setRowCount(0);

        Object[] row = new Object[4];
        for (int i = 0; i < listArmor.size(); i++) {
            row[0] = listArmor.get(i).getArmorID();
            row[1] = listArmor.get(i).getClassification();
            row[2] = listArmor.get(i).getDate();
            row[3] = listArmor.get(i).getDefense();
            model.addRow(row);
        }
    }

    private void loadData() {
        try {
            model = (DefaultTableModel) tblArmor.getModel();
            model.setRowCount(0);
            listArmor = ai.findAllArmor();
        } catch (RemoteException ex) {
            Logger.getLogger(ArmorUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void clearTextField() {
        txtArmorID.setText("");
        txtClassification.setText("");
        txtDefense.setText("");
        txtDescription.setText("");
        txtStatus.setText("");
        txtTimeOfCreate.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblArmor = new javax.swing.JTable();
        btnGetAll = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        txtArmorID = new javax.swing.JTextField();
        txtClassification = new javax.swing.JTextField();
        txtTimeOfCreate = new javax.swing.JTextField();
        txtDefense = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        txtStatus = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblArmor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Classification", "Time Of Create", "Defense"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblArmor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblArmorMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblArmor);

        btnGetAll.setText("Get All");
        btnGetAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGetAllActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Armor Client");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Armor's Detail"));

        jLabel2.setText("ArmorID: ");

        jLabel3.setText("Classification:");

        jLabel4.setText("TimeOfCreate:");

        jLabel5.setText("Defense:");

        jLabel6.setText("Description:");

        jLabel7.setText("Status:");

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        txtDescription.setColumns(20);
        txtDescription.setRows(5);
        jScrollPane2.setViewportView(txtDescription);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtArmorID, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                            .addComponent(txtClassification))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(29, 29, 29)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(97, 97, 97)
                                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTimeOfCreate, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                        .addComponent(txtDefense))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCreate)
                                .addGap(76, 76, 76)
                                .addComponent(btnUpdate)
                                .addGap(74, 74, 74)
                                .addComponent(btnRemove)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtArmorID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtClassification, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel6)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTimeOfCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDefense, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnUpdate)
                    .addComponent(btnRemove))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(btnGetAll)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(377, 377, 377)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addComponent(btnGetAll))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblArmorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblArmorMouseClicked
        // TODO add your handling code here:
        checkAddNew = false;
        int index = tblArmor.getSelectedRow();
        if (index >= 0) {
            String codeSelect = tblArmor.getValueAt(index, 0).toString();
            txtArmorID.setEnabled(false);
            if (listArmor.size() > 0) {
                for (ArmorDTO x : listArmor) {
                    if (x.getArmorID().equalsIgnoreCase(codeSelect)) {
                        txtArmorID.setText("" + x.getArmorID());
                        txtClassification.setText("" + x.getClassification());
                        txtDefense.setText("" + x.getDefense());
                        txtDescription.setText("" + x.getDescription());
                        txtStatus.setText("" + x.getStatus());
                        txtTimeOfCreate.setText("" + x.getDate());
                        
                    }
                }
            }
        }
    }//GEN-LAST:event_tblArmorMouseClicked

    private void btnGetAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetAllActionPerformed
        // TODO add your handling code here:
        if (listArmor.isEmpty()) {
            JOptionPane.showMessageDialog(this, "There is no Armor to display.");
            return;
        }

        displayArmor();
        txtArmorID.setEnabled(false);
    }//GEN-LAST:event_btnGetAllActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        checkAddNew = true;
        clearTextField();
        date = new Date();
        String dateString = formatter.format(date);
        txtTimeOfCreate.setText(dateString);
        txtTimeOfCreate.setEnabled(false);
        txtArmorID.setEnabled(true);
        
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        String idArmor = txtArmorID.getText();
        if (idArmor.equals("")) {
            JOptionPane.showMessageDialog(this, "Please choose a row to delete.");
            return;
        }

        int index = tblArmor.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Please choose a row to delete.");
            return;
        }

        model = (DefaultTableModel) tblArmor.getModel();

        int input = JOptionPane.showConfirmDialog(this, "Are you sure to delete?", "Delete", JOptionPane.YES_NO_OPTION);
        if (input == 0) {
            int row = tblArmor.getSelectedRow();

            try {
                boolean checkDelete = ai.removeArmor(idArmor);
                if (checkDelete == true) {
                    JOptionPane.showMessageDialog(this, "Delete Successful!");
                } else {
                    JOptionPane.showMessageDialog(this, "Can't delete because exception.");
                }
            } catch (RemoteException ex) {
                Logger.getLogger(ArmorUI.class.getName()).log(Level.SEVERE, null, ex);
            }

            model.removeRow(row);
            clearTextField();
        }
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        String armorIDInsert = txtArmorID.getText();
        String classificationInsert = txtClassification.getText();
        String descriptionInsert = txtDescription.getText();
        String statusInsert = txtStatus.getText();
        String timeOfCreateInsert = txtTimeOfCreate.getText();
        int defenseInsert = 0;
        if (checkAddNew == true) {

            if (txtArmorID.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "ID can't be blank");
                txtArmorID.requestFocus();
                return;
            }
            if (txtClassification.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Classification can't be blank");
                txtClassification.requestFocus();
                return;
            }
            if (txtDescription.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Description can't be blank");
                txtDescription.requestFocus();
                return;
            }
            if (txtStatus.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Status can't be blank");
                txtStatus.requestFocus();
                return;
            }
            if (txtDefense.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Defense can't be blank");
                txtDefense.requestFocus();
                return;
            }

            for (ArmorDTO x : listArmor) {
                if (armorIDInsert.equalsIgnoreCase(x.getArmorID())) {
                    JOptionPane.showMessageDialog(this, "Duplicate ID, please input other ID");
                    txtArmorID.requestFocus();
                    return;
                }
            }

            boolean checkClassification = v.checkClassification(classificationInsert);
            if (checkClassification == false) {
                JOptionPane.showMessageDialog(this, "Classification cann't contains specail character like: #$%^&...");
                txtClassification.requestFocus();
                return;
            }
            if (txtClassification.getText().length() > 30) {
                JOptionPane.showMessageDialog(this, "The Classification's length have to smaller than 30");
                return;
            }

            boolean checkDescription = v.checkDescription(descriptionInsert);
            if (checkDescription == false) {
                JOptionPane.showMessageDialog(this, "Description cann't contains specail character like: #$%^&...");
                txtDescription.requestFocus();
                return;
            }
            if (txtDescription.getText().length() > 300) {
                JOptionPane.showMessageDialog(this, "Description's length have to smaller than 300 characters.");
            }

            try {
                defenseInsert = Integer.parseInt(txtDefense.getText());
                boolean checkDefense = v.checkDefense(defenseInsert);
                if (checkDefense == true) {
                    JOptionPane.showMessageDialog(this, "Defense must be > 0");
                    txtDefense.requestFocus();
                    return;
                }
            } catch (HeadlessException | NumberFormatException E) {
                JOptionPane.showMessageDialog(this, "Defense must be a digit");
                txtDefense.requestFocus();
                return;
            }

            ArmorDTO dto = new ArmorDTO(armorIDInsert, classificationInsert, descriptionInsert, statusInsert, timeOfCreateInsert, defenseInsert);

            listArmor.add(dto);
            clearTextField();
            date = new Date();
            String dateString = formatter.format(date);
            txtTimeOfCreate.setText(dateString);

            try {
                boolean checkInsert = ai.createArmor(dto);
                if (checkInsert == true) {
                    JOptionPane.showMessageDialog(this, "Insert Successful!");
                } else {
                    JOptionPane.showMessageDialog(this, "Can't Insert, please check data");
                    return;
                }
            } catch (RemoteException ex) {
                ex.printStackTrace();
            }

            displayArmor();
        }

        if (checkAddNew == false) {
            String id = txtArmorID.getText();
            String cla = txtClassification.getText();
            String decrip = txtDescription.getText();
            String status = txtStatus.getText();
            String defen = txtDefense.getText();
            String date = txtTimeOfCreate.getText();
            if (txtClassification.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Classification can't be blank");
                txtClassification.requestFocus();
                return;
            }
            if (txtDescription.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Description can't be blank");
                txtDescription.requestFocus();
                return;
            }
            if (txtStatus.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Status can't be blank");
                txtStatus.requestFocus();
                return;
            }
            if (txtDefense.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Defense can't be blank");
                txtDefense.requestFocus();
                return;
            }
            boolean checkClassification = v.checkClassification(classificationInsert);
            if (checkClassification == false) {
                JOptionPane.showMessageDialog(this, "Classification cann't contains specail character like: #$%^&...");
                txtClassification.requestFocus();
                return;
            }
            if (txtClassification.getText().length() > 30) {
                JOptionPane.showMessageDialog(this, "The Classification's length have to smaller than 30");
                return;
            }

            boolean checkDescription = v.checkDescription(descriptionInsert);
            if (checkDescription == false) {
                JOptionPane.showMessageDialog(this, "Description cann't contains specail character like: #$%^&...");
                txtDescription.requestFocus();
                return;
            }
            if (txtDescription.getText().length() > 300) {
                JOptionPane.showMessageDialog(this, "Description's length have to smaller than 300 characters.");
            }

            try {
                defenseInsert = Integer.parseInt(txtDefense.getText());
                boolean checkDefense = v.checkDefense(defenseInsert);
                if (checkDefense == true) {
                    JOptionPane.showMessageDialog(this, "Defense must be > 0");
                    txtDefense.requestFocus();
                    return;
                }
            } catch (HeadlessException | NumberFormatException E) {
                JOptionPane.showMessageDialog(this, "Defense must be a digit");
                txtDefense.requestFocus();
                return;
            }
            ArmorDTO dto = new ArmorDTO(id, cla, decrip, status, date, Integer.parseInt(defen));
            try {
                boolean check = ai.updateArmor(dto);
                if (check == true) {
                    JOptionPane.showMessageDialog(this, "Update success");
                    loadData();
                    displayArmor();
                }
            } catch (RemoteException ex) {
                Logger.getLogger(ArmorUI.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ArmorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ArmorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ArmorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ArmorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ArmorUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnGetAll;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblArmor;
    private javax.swing.JTextField txtArmorID;
    private javax.swing.JTextField txtClassification;
    private javax.swing.JTextField txtDefense;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtTimeOfCreate;
    // End of variables declaration//GEN-END:variables
}
