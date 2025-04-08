/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.sena.examplejdbc.bd.view;

import co.edu.sena.examplejdbc.bd.controllers.EmployeeControllers;
import co.edu.sena.examplejdbc.bd.controllers.IEmployeeControllers;
import co.edu.sena.examplejdbc.bd.controllers.IKeyControllers;
import co.edu.sena.examplejdbc.bd.controllers.IRecordControllers;
import co.edu.sena.examplejdbc.bd.controllers.KeyControllers;
import co.edu.sena.examplejdbc.bd.controllers.RecordControllers;
import co.edu.sena.examplejdbc.bd.utils.MessageUtils;
import co.edu.sena.examplejdbc.model.Employee;
import co.edu.sena.examplejdbc.model.Key;
import co.edu.sena.examplejdbc.model.Record;
import java.time.LocalDate;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rojas
 */
public class JFrameRecord extends javax.swing.JFrame {
    private IRecordControllers recordControllers = new RecordControllers();
    private IEmployeeControllers employeeControllers = new EmployeeControllers();
    private IKeyControllers keyControllers = new KeyControllers();
    
    /**
     * Creates new form JFrameRecord
     */
    public JFrameRecord() {
        initComponents();
        fillCombos();
        fillTable();
    }
    
    public void fillCombos()
    {
        try {
            List<Employee> employees = employeeControllers.findAll();
            DefaultComboBoxModel model = new DefaultComboBoxModel();
            jComboBoxEmployee.setModel(model);
            model.addAll(employees);
            List <Key> keys = keyControllers.findALL();
            model = new DefaultComboBoxModel();
            jComboBoxKeys.setModel(model);
            jComboBoxStatus.addItem("ACTIVO");
            jComboBoxStatus.addItem("INACTIVO");
            jComboBoxStatus.addItem("PENDIENTE");


            model.addAll(keys);
        } catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
    
    public void  fillTable()
    {
        try {
            DefaultTableModel model = new DefaultTableModel();
            jTableRecord.setModel(model);
            model.addColumn("Id");
            model.addColumn("Fecha");
            model.addColumn("Hora inicio");
            model.addColumn("Hora fin");
            model.addColumn("Funcionario");
            model.addColumn("Llave");
            model.addColumn("Estado");
            
            String [] rows = new String [7];
            List <Record> records = recordControllers.findALL();
            for(Record r: records)
            {
                rows[0] = String.valueOf(r.getId());
                rows [1] = r.getDateRecord();
                rows [2] = r.getStartTime();
                rows [3] = r.getEndTime();
                rows [4] = r.getEmployeeId().getFullname();
                rows [5] = r.getKeyId().getName();
                rows [6] = r.getStatus();
                model.addRow(rows);
            }
        } catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }
            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelRecord = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelId = new javax.swing.JLabel();
        jLabelDate = new javax.swing.JLabel();
        jLabelStarttime = new javax.swing.JLabel();
        jLabelEndtime = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        timePickerStartTime = new com.github.lgooddatepicker.components.TimePicker();
        timePickerEndTime = new com.github.lgooddatepicker.components.TimePicker();
        jLabelEmployee = new javax.swing.JLabel();
        jLabelKey = new javax.swing.JLabel();
        jLabelStatus = new javax.swing.JLabel();
        jComboBoxStatus = new javax.swing.JComboBox<>();
        jComboBoxEmployee = new javax.swing.JComboBox<>();
        jComboBoxKeys = new javax.swing.JComboBox<>();
        datePickerDate = new com.github.lgooddatepicker.components.DatePicker();
        jButtonInsert = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonClean = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRecord = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro");

        jPanelRecord.setBackground(new java.awt.Color(0, 102, 51));
        jPanelRecord.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanelRecord.setForeground(new java.awt.Color(255, 255, 255));

        jLabelTitle.setText("Record");
        jLabelTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(255, 255, 255));

        jLabelId.setText("Id:");
        jLabelId.setBackground(new java.awt.Color(255, 255, 255));
        jLabelId.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelId.setForeground(new java.awt.Color(255, 255, 255));

        jLabelDate.setText("Fecha:");
        jLabelDate.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelDate.setForeground(new java.awt.Color(255, 255, 255));

        jLabelStarttime.setText("Hora  inicio:");
        jLabelStarttime.setBackground(new java.awt.Color(255, 255, 255));
        jLabelStarttime.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelStarttime.setForeground(new java.awt.Color(255, 255, 255));

        jLabelEndtime.setText("Hora fin:");
        jLabelEndtime.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEndtime.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelEndtime.setForeground(new java.awt.Color(255, 255, 255));

        jTextFieldId.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTextFieldId.setBackground(new java.awt.Color(255, 255, 255));
        jTextFieldId.setForeground(new java.awt.Color(0, 102, 51));

        timePickerStartTime.setBackground(new java.awt.Color(0, 102, 51));

        timePickerEndTime.setBackground(new java.awt.Color(0, 102, 51));

        jLabelEmployee.setText("Funcionario:");
        jLabelEmployee.setBackground(new java.awt.Color(255, 255, 255));
        jLabelEmployee.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelEmployee.setForeground(new java.awt.Color(255, 255, 255));

        jLabelKey.setText("Llave:");
        jLabelKey.setBackground(new java.awt.Color(255, 255, 255));
        jLabelKey.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelKey.setForeground(new java.awt.Color(255, 255, 255));

        jLabelStatus.setText("Estado:");
        jLabelStatus.setBackground(new java.awt.Color(255, 255, 255));
        jLabelStatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabelStatus.setForeground(new java.awt.Color(255, 255, 255));

        jComboBoxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion...." }));
        jComboBoxStatus.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxStatus.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBoxStatus.setForeground(new java.awt.Color(0, 102, 51));

        jComboBoxEmployee.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona una opcion....", " " }));
        jComboBoxEmployee.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxEmployee.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBoxEmployee.setForeground(new java.awt.Color(0, 102, 51));

        jComboBoxKeys.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una opcion...", " " }));
        jComboBoxKeys.setBackground(new java.awt.Color(255, 255, 255));
        jComboBoxKeys.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboBoxKeys.setForeground(new java.awt.Color(0, 102, 51));

        datePickerDate.setBackground(new java.awt.Color(0, 102, 51));

        jButtonInsert.setText("Crear");
        jButtonInsert.setBackground(new java.awt.Color(255, 255, 255));
        jButtonInsert.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonInsert.setForeground(new java.awt.Color(0, 102, 51));
        jButtonInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInsertActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Modificar");
        jButtonUpdate.setBackground(new java.awt.Color(255, 255, 255));
        jButtonUpdate.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonUpdate.setForeground(new java.awt.Color(0, 102, 51));
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonClean.setText("Limpiar");
        jButtonClean.setBackground(new java.awt.Color(255, 255, 255));
        jButtonClean.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonClean.setForeground(new java.awt.Color(0, 102, 51));
        jButtonClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCleanActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Eliminar");
        jButtonDelete.setBackground(new java.awt.Color(255, 255, 255));
        jButtonDelete.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButtonDelete.setForeground(new java.awt.Color(0, 102, 51));
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jTableRecord.setBackground(new java.awt.Color(255, 255, 255));
        jTableRecord.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTableRecord.setForeground(new java.awt.Color(0, 102, 51));
        jTableRecord.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableRecord.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRecordMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRecord);

        javax.swing.GroupLayout jPanelRecordLayout = new javax.swing.GroupLayout(jPanelRecord);
        jPanelRecord.setLayout(jPanelRecordLayout);
        jPanelRecordLayout.setHorizontalGroup(
            jPanelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecordLayout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jLabelTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelRecordLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRecordLayout.createSequentialGroup()
                        .addGroup(jPanelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelRecordLayout.createSequentialGroup()
                                .addGroup(jPanelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelRecordLayout.createSequentialGroup()
                                        .addComponent(jLabelStarttime)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRecordLayout.createSequentialGroup()
                                        .addComponent(jLabelId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)))
                                .addGroup(jPanelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(timePickerStartTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48)
                                .addGroup(jPanelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelEndtime)
                                    .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(timePickerEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(datePickerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)
                                .addGroup(jPanelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelKey, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelStatus)
                                    .addComponent(jLabelEmployee))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE))
                            .addGroup(jPanelRecordLayout.createSequentialGroup()
                                .addComponent(jButtonInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jButtonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)))
                        .addComponent(jButtonClean, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRecordLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxEmployee, 0, 192, Short.MAX_VALUE)
                            .addComponent(jComboBoxKeys, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanelRecordLayout.setVerticalGroup(
            jPanelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRecordLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabelTitle)
                .addGap(18, 18, 18)
                .addGroup(jPanelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelId)
                    .addComponent(jLabelDate)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(datePickerDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmployee)
                    .addComponent(jComboBoxEmployee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelStarttime)
                    .addComponent(timePickerStartTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEndtime)
                    .addComponent(timePickerEndTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelKey)
                    .addComponent(jComboBoxKeys, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(jPanelRecordLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClean)
                    .addComponent(jButtonDelete)
                    .addComponent(jButtonInsert)
                    .addComponent(jButtonUpdate))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelRecord, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTableRecordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRecordMouseClicked
        int rowSelected = jTableRecord.getSelectedRow();
        if(rowSelected != -1)
        {
            int idSelected = Integer.parseInt(jTableRecord.getValueAt(rowSelected,0).toString());
            try {
                Record r =  recordControllers.findById(idSelected);
                jTextFieldId.setText(String.valueOf(idSelected));
                datePickerDate.setDate(LocalDate.parse(r.getDateRecord()));
                timePickerEndTime.setText(r.getEndTime() != null ? r.getEndTime() : null);
                timePickerStartTime.setText(r.getStartTime());
                jComboBoxEmployee.getModel().setSelectedItem(r.getEmployeeId());
                jComboBoxKeys.getModel().setSelectedItem(r.getKeyId());
                jComboBoxStatus.setSelectedItem(r.getStatus());
                
                jButtonInsert.setEnabled(false);
                jButtonUpdate.setEnabled(true);
                jButtonDelete.setEnabled(true);
                timePickerEndTime.setEnabled(true);
            } catch (Exception e) {
                MessageUtils.showInfoMessage(e.getMessage());
            }
        }
    }//GEN-LAST:event_jTableRecordMouseClicked

    private void jButtonCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCleanActionPerformed
        clean();
    }//GEN-LAST:event_jButtonCleanActionPerformed

    private void jButtonInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInsertActionPerformed
        try {
             Record record = new Record();
        record.setDateRecord(datePickerDate.getDate().toString());
        record.setStartTime(timePickerStartTime.getTime().toString());
        //record.setEndTime(timePickerEndTime.getTime() != null ? timePickerEndTime.getTime().toString(): null);
        record.setEndTime(null);
        
        //FK
        Employee employee = (Employee) jComboBoxEmployee.getSelectedItem();
        record.setEmployeeId(employee);
        
        Key key = (Key) jComboBoxKeys.getSelectedItem();
        record.setKeyId(key);
        record.setStatus(jComboBoxStatus.getSelectedItem().toString());
        recordControllers.insert(record);
        fillTable();
        fillCombos();
        clean();
        MessageUtils.showInfoMessage("Registro creado exitosamente");
        } catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
   
    }//GEN-LAST:event_jButtonInsertActionPerformed

    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        try {
             Record record = new Record();
            record.setId(Integer.parseInt(jTextFieldId.getText()));
            record.setDateRecord(datePickerDate.getDate().toString());
            record.setStartTime(timePickerStartTime.getTime().toString());
            record.setEndTime(timePickerEndTime.getTime() != null ? timePickerEndTime.getTime().toString(): null);
            //FK
            Employee employee = (Employee) jComboBoxEmployee.getSelectedItem();
            record.setEmployeeId(employee);
            Key key = (Key) jComboBoxKeys.getSelectedItem();
            record.setKeyId(key);
            record.setStatus(jComboBoxStatus.getSelectedItem().toString());
            recordControllers.update(record);
            MessageUtils.showInfoMessage("Registro modifcado exitosamente");
            fillTable();
            clean();
        } catch (Exception e) {
           MessageUtils.showErrorMessage(e.getMessage());
        }
    }//GEN-LAST:event_jButtonUpdateActionPerformed

    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        try {
            int option = JOptionPane.showConfirmDialog(rootPane, "Esta seguro de eliminar el registro?", 
                         "Confirmacion", JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.YES_OPTION)
            {
                recordControllers.delete(Integer.parseInt(jTextFieldId.getText()));
                MessageUtils.showInfoMessage(" El registro fue eliminado exitosamente");
                fillTable();
            }
            clean();
        } catch (Exception e) {
            MessageUtils.showErrorMessage(e.getMessage());
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed
    
    public void clean (){
        jTextFieldId.setText("");
        datePickerDate.setText("");
        timePickerStartTime.setText("");
        timePickerEndTime.setText("");
        jTableRecord.clearSelection();
        jComboBoxEmployee.setSelectedIndex(0);
        jComboBoxKeys.setSelectedIndex(0);
        jComboBoxStatus.setSelectedIndex(0);
        jButtonInsert.setEnabled(true);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        
        
        
    
}
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
            java.util.logging.Logger.getLogger(JFrameRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameRecord().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker datePickerDate;
    private javax.swing.JButton jButtonClean;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonInsert;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox<String> jComboBoxEmployee;
    private javax.swing.JComboBox<String> jComboBoxKeys;
    private javax.swing.JComboBox<String> jComboBoxStatus;
    private javax.swing.JLabel jLabelDate;
    private javax.swing.JLabel jLabelEmployee;
    private javax.swing.JLabel jLabelEndtime;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelKey;
    private javax.swing.JLabel jLabelStarttime;
    private javax.swing.JLabel jLabelStatus;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPanel jPanelRecord;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRecord;
    private javax.swing.JTextField jTextFieldId;
    private com.github.lgooddatepicker.components.TimePicker timePickerEndTime;
    private com.github.lgooddatepicker.components.TimePicker timePickerStartTime;
    // End of variables declaration//GEN-END:variables
}
