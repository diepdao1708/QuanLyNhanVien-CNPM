/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view.registershift;

import controller.RegistrationDAO;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.Employee;
import model.Registration;
import view.login.HomeFrm;

/**
 *
 * @author Admin
 */
public class RegisterShiftFrm extends javax.swing.JFrame {

    /**
     * Creates new form DangKyCaLamFrm
     */
    
    private Employee employee;
    DefaultTableModel tm;
    private ArrayList<Registration> listRegistration;
    RegistrationDAO registrationDAO = new RegistrationDAO();

    public RegisterShiftFrm(Employee employee) {
        this.employee = employee;
        initComponents();
        
        setTitle("Đăng ký ca làm tuần tới");
        setSize(620, 380);
        setLocationRelativeTo(this);
        getContentPane().setBackground(Color.white);
        
        txtId.setText(String.valueOf(employee.getId()));
        txtName.setText(employee.getName());
        txtEmail.setText(employee.getEmail());
        txtAddress.setText(employee.getAddress());
        txtPhoneNumber.setText(employee.getPhoneNumber());
        
        // Set thời gian tuần tới
        String firstDayNextWeek = new SimpleDateFormat("dd/MM/yyyy").format(firstDayNextWeek());
        String lastDayNextWeek = new SimpleDateFormat("dd/MM/yyyy").format(lastDayNextWeek());
        thoiGianTxt.setText(firstDayNextWeek + " - " + lastDayNextWeek);
        thoiGianTxt.setHorizontalAlignment(JTextField.CENTER);
        
        listRegistration = registrationDAO.checkRegistration(employee, firstDayNextWeek(), lastDayNextWeek());
        if (!listRegistration.isEmpty()) {
            tblRegistration.setEnabled(false);
            btnSave.setEnabled(false);
        }
        
        // tạo bảng đăng ký
        tm = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return switch (columnIndex) {
                    case 0 -> String.class;
                    case 1 -> Boolean.class;
                    default -> Boolean.class;
                };
            }
        };
        tblRegistration.setModel(tm);
        tm.addColumn("Thứ");
        tm.addColumn("Ca 1");
        tm.addColumn("Ca 2");
        if (listRegistration.isEmpty()) {
            for (int i = 0; i < 7; i++){
                tm.addRow(new Object[0]);
                if (i == 6) {
                    tm.setValueAt("CN", i, 0);
                } else {
                    tm.setValueAt(String.valueOf(i+2), i, 0);
                }
                tm.setValueAt(false, i, 1);
                tm.setValueAt(false, i, 2);
            }
        } else {
            for (int i = 0; i < 7; i++){
                tm.addRow(new Object[0]);
                if (i == 6) {
                    tm.setValueAt("CN", i, 0);
                } else {
                    tm.setValueAt(String.valueOf(i+2), i, 0);
                }
                tm.setValueAt(listRegistration.get(i).getMorningShift(), i, 1);
                tm.setValueAt(listRegistration.get(i).getNightShift(), i, 2);
            }
        }
    }
    
    private Date firstDayNextWeek() {
        Calendar calendar = Calendar.getInstance();
        String dayString = new SimpleDateFormat("EEEE").format(calendar.getTime());
        while (!"Monday".equals(dayString)) {
            calendar.add(Calendar.DATE, 1);
            dayString = new SimpleDateFormat("EEEE").format(calendar.getTime());
        }
        return calendar.getTime();
    }
    
    private Date lastDayNextWeek() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDayNextWeek());
        calendar.add(Calendar.DATE, 6);
        return calendar.getTime();
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        backBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtAddress = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        thoiGianTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblRegistration = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        backBtn.setText("<");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Đăng ký ca làm tuần tới");

        jLabel2.setText("MNV: ");

        txtId.setEditable(false);

        jLabel3.setText("Email: ");

        txtName.setEditable(false);

        jLabel4.setText("Địa chỉ: ");

        jLabel5.setText("SĐT: ");

        jLabel6.setText("Tên NV: ");

        txtEmail.setEditable(false);

        txtAddress.setEditable(false);
        txtAddress.setText(" ");

        txtPhoneNumber.setEditable(false);

        thoiGianTxt.setEditable(false);
        thoiGianTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoiGianTxtActionPerformed(evt);
            }
        });

        tblRegistration.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblRegistration);

        btnSave.setBackground(new java.awt.Color(233, 110, 21));
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Lưu");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtId)
                    .addComponent(txtName)
                    .addComponent(txtEmail)
                    .addComponent(txtAddress)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(143, 143, 143))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(thoiGianTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(backBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(thoiGianTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        (new SearchEmployeeRegisterShiftFrm()).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        Boolean showDialog = false;
        for (int i=0; i<=6; i++) {
            Boolean caSang = (Boolean) tm.getValueAt(i, 1);
            Boolean caToi = (Boolean) tm.getValueAt(i, 2);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(firstDayNextWeek());
            calendar.add(Calendar.DATE, i);
            Date ngay = calendar.getTime();
            Boolean chapNhan = false;
            Registration registration = new Registration(employee.getId(), caSang, caToi, ngay, chapNhan);
            
            showDialog = registrationDAO.addRegistration(registration);
        }
        if(showDialog){
            JOptionPane.showMessageDialog(this, "Lưu thành công");
            (new HomeFrm()).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Lưu thất bại");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void thoiGianTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoiGianTxtActionPerformed
        // TODO add your handling code here  
    }//GEN-LAST:event_thoiGianTxtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblRegistration;
    private javax.swing.JTextField thoiGianTxt;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    // End of variables declaration//GEN-END:variables
}
