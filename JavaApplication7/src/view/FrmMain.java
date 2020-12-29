/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.BConnection;
import java.awt.Color;
import java.awt.Frame;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import model.Account;
import DAO.AccountDAO;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import model.Role;
import static view.FrmLogin.login;

/**
 *
 * @author BinDz
 */
public class FrmMain extends javax.swing.JFrame {
    static boolean maximized = true;
    int xMouse;
    int yMouse;
    Account account;
    List<Account> listacc;
    List<Role> lr;
    public static MessageBox messagebox ;
    
    /**
     * Creates new form FrmMain
     */
    public FrmMain(Account account) {
        initComponents();
        setLocationRelativeTo(null);
        Home h = new Home();
        Body.add(h);
        Body.repaint();
        Body.revalidate();
        this.account = account;
        labelName.setText(account.getName());
//        show_table();
//        load_data();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Main = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        Left = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnHome1 = new rojerusan.RSButtonMetro();
        btnHome3 = new rojerusan.RSButtonMetro();
        btnHome4 = new rojerusan.RSButtonMetro();
        btnHome9 = new rojerusan.RSButtonMetro();
        btnHome10 = new rojerusan.RSButtonMetro();
        btnHome11 = new rojerusan.RSButtonMetro();
        Body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        Main.setBackground(new java.awt.Color(255, 255, 255));
        Main.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Main.setMaximumSize(new java.awt.Dimension(1000, 600));
        Main.setMinimumSize(new java.awt.Dimension(1000, 600));
        Main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(255, 255, 255));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        Header.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                HeaderMouseDragged(evt);
            }
        });
        Header.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                HeaderMousePressed(evt);
            }
        });

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(51, 204, 255));
        rSMaterialButtonCircle1.setText("X");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(51, 204, 255));
        rSMaterialButtonCircle2.setText("-");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addGap(0, 940, Short.MAX_VALUE)
                .addComponent(rSMaterialButtonCircle2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(rSMaterialButtonCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rSMaterialButtonCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(HeaderLayout.createSequentialGroup()
                .addComponent(rSMaterialButtonCircle2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Main.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 30));

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setForeground(new java.awt.Color(255, 255, 255));
        Left.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Left.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 0, 125, 45));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("SINH VIÊN");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 51, 160, 45));

        Left.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 120));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Xin Chào! ");
        jPanel12.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 25, -1, 20));

        labelName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelName.setForeground(new java.awt.Color(255, 0, 0));
        labelName.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_person_25px.png"))); // NOI18N
        labelName.setText("Admin");
        jPanel12.add(labelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 160, 20));

        jLabel12.setText("Đăng xuất");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, 20));

        jLabel2.setText("- Thông tin:");
        jPanel12.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 5, 90, -1));

        Left.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 180, 110));

        btnHome1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_settings_25px.png"))); // NOI18N
        btnHome1.setText("Cài đặt");
        btnHome1.setBorderPainted(false);
        btnHome1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome1MouseExited(evt);
            }
        });
        btnHome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome1ActionPerformed(evt);
            }
        });
        Left.add(btnHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 515, 180, 55));

        btnHome3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_home_25px.png"))); // NOI18N
        btnHome3.setText("Trang Chủ");
        btnHome3.setBorderPainted(false);
        btnHome3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome3MouseExited(evt);
            }
        });
        btnHome3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome3ActionPerformed(evt);
            }
        });
        Left.add(btnHome3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 231, 180, 55));

        btnHome4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_content_25px.png"))); // NOI18N
        btnHome4.setText("Quản lý tài khoản");
        btnHome4.setBorderPainted(false);
        btnHome4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome4MouseExited(evt);
            }
        });
        btnHome4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome4ActionPerformed(evt);
            }
        });
        Left.add(btnHome4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 287, 180, 55));

        btnHome9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_student_male_25px.png"))); // NOI18N
        btnHome9.setText("Quản lý sinh viên");
        btnHome9.setBorderPainted(false);
        btnHome9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome9MouseExited(evt);
            }
        });
        btnHome9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome9ActionPerformed(evt);
            }
        });
        Left.add(btnHome9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 343, 180, 55));

        btnHome10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_books_25px.png"))); // NOI18N
        btnHome10.setText("Quản lý môn học");
        btnHome10.setBorderPainted(false);
        btnHome10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome10MouseExited(evt);
            }
        });
        btnHome10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome10ActionPerformed(evt);
            }
        });
        Left.add(btnHome10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 399, 180, 55));

        btnHome11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_graph_report_25px.png"))); // NOI18N
        btnHome11.setText("Quản lý điểm");
        btnHome11.setBorderPainted(false);
        btnHome11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnHome11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHome11MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHome11MouseExited(evt);
            }
        });
        btnHome11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHome11ActionPerformed(evt);
            }
        });
        Left.add(btnHome11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 455, 180, 59));

        Main.add(Left, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 180, 570));

        Body.setLayout(new java.awt.BorderLayout());
        Main.add(Body, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 820, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Main, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void HeaderMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMousePressed
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_HeaderMousePressed

    private void HeaderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HeaderMouseDragged
        if (maximized) {
            int x = evt.getXOnScreen();
            int y = evt.getYOnScreen();
            this.setLocation(x - xMouse, y - yMouse);
        }
    }//GEN-LAST:event_HeaderMouseDragged

    private void btnHome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHome1ActionPerformed

    private void btnHome3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome3ActionPerformed
        Body.removeAll();
        Home h = new Home();
        Body.add(h);
        Body.repaint();
        Body.revalidate();
    }//GEN-LAST:event_btnHome3ActionPerformed

    private void btnHome4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome4ActionPerformed
        Body.removeAll();
        ManageAccount ma = new ManageAccount();
        Body.add(ma);
        Body.repaint();
        Body.revalidate();


    }//GEN-LAST:event_btnHome4ActionPerformed

    private void btnHome9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome9ActionPerformed
        Body.removeAll();
        ManageStudent mss = new ManageStudent();
        Body.add(mss);
        Body.repaint();
        Body.revalidate();
    }//GEN-LAST:event_btnHome9ActionPerformed

    private void btnHome10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome10ActionPerformed
        Body.removeAll();
        ManageSubject ms = new ManageSubject();
        Body.add(ms);
        Body.repaint();
        Body.revalidate();
    }//GEN-LAST:event_btnHome10ActionPerformed

    private void btnHome11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHome11ActionPerformed
        Body.removeAll();
        ManageMark mk = new ManageMark();
        Body.add(mk);
        Body.repaint();
        Body.revalidate();
    }//GEN-LAST:event_btnHome11ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void btnHome3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome3MouseEntered
        btnHome3.setBackground(new Color(85, 159, 213));
    }//GEN-LAST:event_btnHome3MouseEntered

    private void btnHome3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome3MouseExited
        btnHome3.setBackground(new Color(0, 112, 192));
    }//GEN-LAST:event_btnHome3MouseExited

    private void btnHome4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome4MouseEntered
        btnHome4.setBackground(new Color(85, 159, 213));
    }//GEN-LAST:event_btnHome4MouseEntered

    private void btnHome4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome4MouseExited
        btnHome4.setBackground(new Color(0, 112, 192));
    }//GEN-LAST:event_btnHome4MouseExited

    private void btnHome9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome9MouseEntered
        btnHome9.setBackground(new Color(85, 159, 213));
    }//GEN-LAST:event_btnHome9MouseEntered

    private void btnHome9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome9MouseExited
        btnHome9.setBackground(new Color(0, 112, 192));
    }//GEN-LAST:event_btnHome9MouseExited

    private void btnHome10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome10MouseExited
        btnHome10.setBackground(new Color(0, 112, 192));
    }//GEN-LAST:event_btnHome10MouseExited

    private void btnHome10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome10MouseEntered
        btnHome10.setBackground(new Color(85, 159, 213));
    }//GEN-LAST:event_btnHome10MouseEntered

    private void btnHome11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome11MouseEntered
        btnHome11.setBackground(new Color(85, 159, 213));
    }//GEN-LAST:event_btnHome11MouseEntered

    private void btnHome11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome11MouseExited
        btnHome11.setBackground(new Color(0, 112, 192));
    }//GEN-LAST:event_btnHome11MouseExited

    private void btnHome1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome1MouseExited
        btnHome1.setBackground(new Color(0, 112, 192));
    }//GEN-LAST:event_btnHome1MouseExited

    private void btnHome1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHome1MouseEntered
        btnHome1.setBackground(new Color(85, 159, 213));
    }//GEN-LAST:event_btnHome1MouseEntered

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        int choose = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn đăng xuất!", "Đăng xuất", JOptionPane.YES_NO_OPTION);
        if (choose == JOptionPane.YES_OPTION) {
            FrmLogin login = new FrmLogin();
            login.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jLabel12MouseClicked

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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Main;
    private rojerusan.RSButtonMetro btnHome1;
    private rojerusan.RSButtonMetro btnHome10;
    private rojerusan.RSButtonMetro btnHome11;
    private rojerusan.RSButtonMetro btnHome3;
    private rojerusan.RSButtonMetro btnHome4;
    private rojerusan.RSButtonMetro btnHome9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelName;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    // End of variables declaration//GEN-END:variables
}
