/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.SubjectDAO;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.Subject;
/**
 *
 * @author BinDz
 */
public class ManageSubject extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel1
     */
    public ManageSubject() {
        initComponents();
        load_data();
    }
    Subject sub;
    List<Subject> listsub;
    private void load_data() {
        SubjectDAO sd = new SubjectDAO();
        listsub = sd.getAllSubject();
        String columns[] = {"STT", "Tên", "Số tín chỉ","Khoá học", "Trạng thái"};
        DefaultTableModel dtm = new DefaultTableModel(columns, 0);
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer i = 1;
        for (Subject s : listsub) {
            dtm.addRow(new Object[]{i, s.getName(),s.getCredits(),s.getKH_Name(), s.getStatus() == 0 ? "Đang hoạt động" : "Đã ngừng dạy"});
            i++;
        }
        tbSubject.setModel(dtm);
        tbSubject.setRowHeight(25);
        if (listsub.size() > 0) {
            tbSubject.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    int pos = tbSubject.getSelectedRow();
                    if (pos < 0) {
                        pos = 0;
                    }

                    sub = listsub.get(pos);
                }
            });
        }
    }
    void load_find(String name) {
        SubjectDAO ad = new SubjectDAO();
        listsub = ad.findSubject(name);
        String columns[] = {"STT", "Tên", "Số tín chỉ", "Trạng thái"};
        DefaultTableModel dtm = new DefaultTableModel(columns, 0);
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Integer i = 1;
        for (Subject s : listsub) {
            dtm.addRow(new Object[]{i, s.getName(),s.getCredits(), s.getStatus() == 0 ? "Đang hoạt động" : "Đã ngừng dạy"});
            i++;
        }
        tbSubject.setModel(dtm);
        tbSubject.setRowHeight(25);
        if (listsub.size() > 0) {
            tbSubject.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent lse) {
                    int pos = tbSubject.getSelectedRow();
                    if (pos < 0) {
                        pos = 0;
                    }

                    sub = listsub.get(pos);
                }
            });
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

        jPanel1 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        rSButtonMetro13 = new rojerusan.RSButtonMetro();
        rSButtonMetro14 = new rojerusan.RSButtonMetro();
        rSButtonMetro15 = new rojerusan.RSButtonMetro();
        rSButtonMetro16 = new rojerusan.RSButtonMetro();
        jPanel21 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        rSButtonMetro6 = new rojerusan.RSButtonMetro();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbSubject = new javax.swing.JTable();

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rSButtonMetro13.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonMetro13.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonMetro13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_update_50px.png"))); // NOI18N
        rSButtonMetro13.setText("Sửa");
        rSButtonMetro13.setBorderPainted(false);
        rSButtonMetro13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rSButtonMetro13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rSButtonMetro13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSButtonMetro13MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSButtonMetro13MouseExited(evt);
            }
        });
        rSButtonMetro13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro13ActionPerformed(evt);
            }
        });
        jPanel20.add(rSButtonMetro13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, 70, 70));

        rSButtonMetro14.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonMetro14.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonMetro14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_search_more_50px_1.png"))); // NOI18N
        rSButtonMetro14.setText("Tìm kiếm");
        rSButtonMetro14.setBorderPainted(false);
        rSButtonMetro14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rSButtonMetro14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rSButtonMetro14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSButtonMetro14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSButtonMetro14MouseExited(evt);
            }
        });
        rSButtonMetro14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro14ActionPerformed(evt);
            }
        });
        jPanel20.add(rSButtonMetro14, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 20, 70, 70));

        rSButtonMetro15.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonMetro15.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonMetro15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_delete_bin_50px.png"))); // NOI18N
        rSButtonMetro15.setText("Xoá");
        rSButtonMetro15.setBorderPainted(false);
        rSButtonMetro15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rSButtonMetro15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rSButtonMetro15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSButtonMetro15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSButtonMetro15MouseExited(evt);
            }
        });
        rSButtonMetro15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro15ActionPerformed(evt);
            }
        });
        jPanel20.add(rSButtonMetro15, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 70, 70));

        rSButtonMetro16.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonMetro16.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonMetro16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_ball_point_pen_50px.png"))); // NOI18N
        rSButtonMetro16.setText("Thêm");
        rSButtonMetro16.setBorderPainted(false);
        rSButtonMetro16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rSButtonMetro16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rSButtonMetro16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSButtonMetro16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSButtonMetro16MouseExited(evt);
            }
        });
        rSButtonMetro16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro16ActionPerformed(evt);
            }
        });
        jPanel20.add(rSButtonMetro16, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 70, 70));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_books_50px.png"))); // NOI18N
        jLabel10.setText("Quản lý môn học");
        jPanel21.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 260, 110));

        jPanel20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 260, 110));

        rSButtonMetro6.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonMetro6.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonMetro6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_refresh_50px.png"))); // NOI18N
        rSButtonMetro6.setText("Refresh");
        rSButtonMetro6.setBorderPainted(false);
        rSButtonMetro6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rSButtonMetro6.setPreferredSize(new java.awt.Dimension(100, 100));
        rSButtonMetro6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rSButtonMetro6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSButtonMetro6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSButtonMetro6MouseExited(evt);
            }
        });
        rSButtonMetro6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro6ActionPerformed(evt);
            }
        });
        jPanel20.add(rSButtonMetro6, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 70, 70));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        tbSubject.setModel(new javax.swing.table.DefaultTableModel(
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
        tbSubject.setGridColor(new java.awt.Color(0, 0, 0));
        tbSubject.setSelectionBackground(new java.awt.Color(51, 204, 255));
        jScrollPane4.setViewportView(tbSubject);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(118, 118, 118)
                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void rSButtonMetro13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro13MouseEntered
        rSButtonMetro13.setBackground(new Color(85, 159, 213));
    }//GEN-LAST:event_rSButtonMetro13MouseEntered

    private void rSButtonMetro13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro13MouseExited
        rSButtonMetro13.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_rSButtonMetro13MouseExited

    private void rSButtonMetro14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro14MouseEntered
        rSButtonMetro14.setBackground(new Color(85, 159, 213));
    }//GEN-LAST:event_rSButtonMetro14MouseEntered

    private void rSButtonMetro14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro14MouseExited
        rSButtonMetro14.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_rSButtonMetro14MouseExited

    private void rSButtonMetro15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro15MouseEntered
        rSButtonMetro15.setBackground(new Color(85, 159, 213));
    }//GEN-LAST:event_rSButtonMetro15MouseEntered

    private void rSButtonMetro15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro15MouseExited
        rSButtonMetro15.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_rSButtonMetro15MouseExited

    private void rSButtonMetro16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro16MouseEntered
        rSButtonMetro16.setBackground(new Color(85, 159, 213));
    }//GEN-LAST:event_rSButtonMetro16MouseEntered

    private void rSButtonMetro16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro16MouseExited
        rSButtonMetro16.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_rSButtonMetro16MouseExited

    private void rSButtonMetro16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro16ActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        FrmDialogSubject fsub = new FrmDialogSubject(frame, true,null);
        fsub.setVisible(true);
        load_data();
    }//GEN-LAST:event_rSButtonMetro16ActionPerformed

    private void rSButtonMetro13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro13ActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        FrmDialogSubject fsub = new FrmDialogSubject(frame, true,sub);
        
        fsub.setVisible(true);
        load_data();
    }//GEN-LAST:event_rSButtonMetro13ActionPerformed

    private void rSButtonMetro15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonMetro15ActionPerformed

    private void rSButtonMetro6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro6MouseEntered
        rSButtonMetro6.setBackground(new Color(85, 159, 213));
    }//GEN-LAST:event_rSButtonMetro6MouseEntered

    private void rSButtonMetro6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro6MouseExited
        rSButtonMetro6.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_rSButtonMetro6MouseExited

    private void rSButtonMetro6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro6ActionPerformed
        load_data();
    }//GEN-LAST:event_rSButtonMetro6ActionPerformed

    private void rSButtonMetro14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro14ActionPerformed
       JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        FrmFind ff = new FrmFind(frame, true);
        ff.setTitle("Tìm kiếm môn học theo tên");
        ff.setVisible(true);
        String a = ff.getData();
        load_find(a);
    }//GEN-LAST:event_rSButtonMetro14ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JScrollPane jScrollPane4;
    private rojerusan.RSButtonMetro rSButtonMetro13;
    private rojerusan.RSButtonMetro rSButtonMetro14;
    private rojerusan.RSButtonMetro rSButtonMetro15;
    private rojerusan.RSButtonMetro rSButtonMetro16;
    private rojerusan.RSButtonMetro rSButtonMetro6;
    private javax.swing.JTable tbSubject;
    // End of variables declaration//GEN-END:variables
}
