/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.AccountController;
import controllers.EmployeeController;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import models.Account;
import models.Employee;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Lenovo
 */
public class RegisterView extends javax.swing.JFrame {
    
    private EmployeeController controller;
    private AccountController accountController;
    private SessionFactory factory = HibernateUtil.getSessionFactory();
    private String[] tabelHeader;
    private List<Employee> listEmployee;
    public static int employeeID;
    private DefaultTableModel dtm;
    int row;

    /**
     * Creates new form EmployeeSearch
     */
    public RegisterView() {
        initComponents();
        controller = new EmployeeController(factory);
        accountController = new AccountController(factory);
        tabelHeader = new String[]{"No", "Employee ID", "First Name", "Last Name", "Email", "No Telp",
            "Hire Date", "Job ID"
        };
        dtm = new DefaultTableModel(null, tabelHeader);
        tabelEmployee.setModel(dtm);
        refreshTabel("Index");
        textEmployeeID.setRequestFocusEnabled(false);
    }
    
    private void refreshTabel(String key) {
        if (key == "Index") {
            listEmployee = controller.search("");
        } else {
            listEmployee = controller.search(textSearch.getText());
        }
        dtm = (DefaultTableModel) tabelEmployee.getModel();
        dtm.setRowCount(0);
        int no = 1;
        for (Employee employee : listEmployee) {
            dtm.addRow(new Object[]{
                no,
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getPhoneNumber(),
                employee.getHireDate(),
                employee.getJob().getTittle()
            });
            no = no + 1;
        }
        if (tabelEmployee.getRowCount() > 0) {
            row = tabelEmployee.getRowCount() - 1;
            tabelEmployee.setRowSelectionInterval(row, row);
        }
        
    }
    
    private void validasiRegister(String password) {
//        System.out.println(password);
         if (!password.matches("^(?=.*[0-9])(?=.*[a-zA-Z])[a-zA-Z0-9]+$")) {
            JOptionPane.showMessageDialog(null, "Password Harus Kombinasi Huruf dan Angka");
            
        } else if (password.equals(password.toUpperCase()) || password.equals(password.toLowerCase())) {
            JOptionPane.showMessageDialog(null, "Password Tidak Boleh Huruf Kecil/Besar Semua!");
        }else {
            String status = accountController.register(textEmployeeID.getText(), textUsername.getText(), textPassword.getText());
            if (status == "Data Berhasil Disimpan") {
                JOptionPane.showMessageDialog(this, "Pendaftaran Berhasil");
                Account acc = new Account();
                acc.setUname(textUsername.getText());
                MainMenu main = new MainMenu();
                main.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Pendaftaran Gagal");
            }
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

        dialogEmployee = new javax.swing.JDialog();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelEmployee = new javax.swing.JTable();
        textSearch = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        textEmployeeID = new javax.swing.JTextField();
        panel11 = new javax.swing.JPanel();
        buttonSearch = new javax.swing.JLabel();
        textUsername = new javax.swing.JTextField();
        textPassword = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        textUlang = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        buttonDaftar = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        buttonBatal = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();

        jPanel5.setBackground(new java.awt.Color(36, 56, 55));

        tabelEmployee.setAutoCreateRowSorter(true);
        tabelEmployee.setBackground(new java.awt.Color(36, 56, 55));
        tabelEmployee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelEmployee.setForeground(new java.awt.Color(255, 255, 255));
        tabelEmployee.setModel(new javax.swing.table.DefaultTableModel(
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
        tabelEmployee.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelEmployeeMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelEmployee);

        textSearch.setBackground(new java.awt.Color(36, 56, 55));
        textSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textSearch.setForeground(new java.awt.Color(255, 255, 255));
        textSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textSearchKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textSearchKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Masukan First Name/Last Name Anda");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dialogEmployeeLayout = new javax.swing.GroupLayout(dialogEmployee.getContentPane());
        dialogEmployee.getContentPane().setLayout(dialogEmployeeLayout);
        dialogEmployeeLayout.setHorizontalGroup(
            dialogEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dialogEmployeeLayout.setVerticalGroup(
            dialogEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(36, 56, 55));
        jPanel2.setForeground(new java.awt.Color(36, 56, 55));
        jPanel2.setToolTipText("");

        jPanel1.setBackground(new java.awt.Color(11, 184, 170));

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("HALAMAN REGISTER");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Silahkan Lengkapi Formulir Dengan Benar");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/note.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(93, 93, 93))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(36, 36, 36)
                .addComponent(jLabel2)
                .addGap(50, 50, 50)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password");

        textEmployeeID.setBackground(new java.awt.Color(36, 56, 55));
        textEmployeeID.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textEmployeeID.setForeground(new java.awt.Color(255, 255, 255));
        textEmployeeID.setText("Pilih Data Anda");
        textEmployeeID.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        textEmployeeID.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textEmployeeIDFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textEmployeeIDFocusLost(evt);
            }
        });

        panel11.setBackground(new java.awt.Color(11, 184, 170));
        panel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panel11MouseClicked(evt);
            }
        });

        buttonSearch.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonSearch.setText("...");
        buttonSearch.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        buttonSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonSearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panel11Layout = new javax.swing.GroupLayout(panel11);
        panel11.setLayout(panel11Layout);
        panel11Layout.setHorizontalGroup(
            panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel11Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(buttonSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panel11Layout.setVerticalGroup(
            panel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
        );

        textUsername.setBackground(new java.awt.Color(36, 56, 55));
        textUsername.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textUsername.setForeground(new java.awt.Color(255, 255, 255));
        textUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        textUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                textUsernameFocusLost(evt);
            }
        });

        textPassword.setBackground(new java.awt.Color(36, 56, 55));
        textPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textPassword.setForeground(new java.awt.Color(255, 255, 255));
        textPassword.setToolTipText("");
        textPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Username");

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nomor Karyawan");

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ulangi Password");

        textUlang.setBackground(new java.awt.Color(36, 56, 55));
        textUlang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textUlang.setForeground(new java.awt.Color(255, 255, 255));
        textUlang.setToolTipText("");
        textUlang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jPanel3.setBackground(new java.awt.Color(11, 184, 170));

        buttonDaftar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonDaftar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonDaftar.setText("DAFTAR");
        buttonDaftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buttonDaftarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 85, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(buttonDaftar, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(buttonDaftar, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(11, 184, 170));

        buttonBatal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        buttonBatal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonBatal.setText("BATAL");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonBatal, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(buttonBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lblId.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblId, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(textEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel6)
                            .addComponent(textUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(textUlang, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(25, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(lblId)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textEmployeeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textUlang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void textSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSearchKeyPressed

    private void textSearchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSearchKeyTyped
        refreshTabel("search");
    }//GEN-LAST:event_textSearchKeyTyped

    private void tabelEmployeeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelEmployeeMouseClicked
        row = tabelEmployee.getSelectedRow();
        textEmployeeID.setText(dtm.getValueAt(row, 1).toString());
        textEmployeeID.requestFocus();
        dialogEmployee.setVisible(false);
    }//GEN-LAST:event_tabelEmployeeMouseClicked

    private void panel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panel11MouseClicked
        dialogEmployee.setSize(980, 450);
        dialogEmployee.setVisible(true);
        dialogEmployee.setLocationRelativeTo(this);
    }//GEN-LAST:event_panel11MouseClicked

    private void buttonSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonSearchMouseClicked
        dialogEmployee.setSize(980, 450);
        dialogEmployee.setVisible(true);
        dialogEmployee.setLocationRelativeTo(this);
    }//GEN-LAST:event_buttonSearchMouseClicked

    private void textEmployeeIDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textEmployeeIDFocusLost
    }//GEN-LAST:event_textEmployeeIDFocusLost

    private void textUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textUsernameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_textUsernameFocusLost

    private void buttonDaftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonDaftarMouseClicked
        if (!textPassword.getText().equals(textUlang.getText())) {
            JOptionPane.showMessageDialog(this, "Password Tidak Sama!");
        }else{
            validasiRegister(textPassword.getText());
        }
    }//GEN-LAST:event_buttonDaftarMouseClicked

    private void textEmployeeIDFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textEmployeeIDFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_textEmployeeIDFocusGained

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
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel buttonBatal;
    private javax.swing.JLabel buttonDaftar;
    private javax.swing.JLabel buttonSearch;
    private javax.swing.JDialog dialogEmployee;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblId;
    private javax.swing.JPanel panel11;
    private javax.swing.JTable tabelEmployee;
    private javax.swing.JTextField textEmployeeID;
    private javax.swing.JPasswordField textPassword;
    private javax.swing.JTextField textSearch;
    private javax.swing.JPasswordField textUlang;
    private javax.swing.JTextField textUsername;
    // End of variables declaration//GEN-END:variables
}
