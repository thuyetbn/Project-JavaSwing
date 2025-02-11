/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAO.ClassDAO;
import DAO.KhoaHocDAO;
import DAO.MarkDAO;
import DAO.StudentDAO;
import DAO.SubjectDAO;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.PatternSyntaxException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.Account;
import model.ClassRoom;
import model.KhoaHoc;
import model.Mark;
import model.Student;
import model.Subject;

/**
 *
 * @author BinDz
 */
public class ManageMark extends javax.swing.JPanel {

    /**
     * Creates new form ManageMark
     */
    public ManageMark() {
        initComponents();
        load_data();
        loadFilercb();
        loadCbClass();
        jLabel2.setVisible(false);
        jTextField1.setVisible(false);
        jComboBox1.setVisible(false);
        
    }
    List<Mark> listm;
    Mark mark;
    DefaultTableModel dtm;
    List<ClassRoom> lstc;
    List<KhoaHoc> lstkh;
    ClassRoom cr;
    KhoaHoc kh;
    Subject sj;
    List<Subject> lstsj;
    

    private void loadFilercb() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        SubjectDAO kh = new SubjectDAO();
        lstsj = kh.getAllSubject();
        dcbm.addElement("Chọn môn học:");
        for (Subject cc : lstsj) {
            dcbm.addElement(cc.getName());
        }
        filterClass.setModel(dcbm);
    }

    private void loadCbClass() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        ClassDAO kh = new ClassDAO();
        lstc = kh.getAllClass();
        dcbm.addElement("Chọn lớp học:");
        for (ClassRoom cc : lstc) {
            dcbm.addElement(cc.getName());
        }
        jComboBox1.setModel(dcbm);
    }

    private void load_data() {
        MarkDAO ad = new MarkDAO();
        listm = ad.getAllMark();
        String columns[] = {"STT", "MSV", "Lớp", "Tên", "Môn học", "Điểm", "Trạng thái", "Ghi chú", "Ngày kêt thúc môn"};
        dtm = new DefaultTableModel(columns, 0);
        Integer i = 1;
        for (Mark m : listm) {
            int diem = (int) m.getMark();
            dtm.addRow(new Object[]{i, m.getS_MSV(), m.getClass_Name(), m.getS_name(), m.getSJ_name() == null ? "Chưa cập nhật" : m.getSJ_name(), m.getMark() == 0 ? "Chưa cập nhật" : m.getMark(), diem <= 10 && diem > 8 ? "Tốt" : diem > 7 ? "Khá" : diem >= 5 ? "Đạt" : "Trượt", m.getNote(), m.getEx_date() == null ? "Chưa cập nhật" : m.getEx_date()});
            i++;
        }
        tbMark.setModel(dtm);
        tbMark.setRowHeight(25);
//        if (listm.size() > 0) {
//            tbMark.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//                @Override
//                public void valueChanged(ListSelectionEvent lse) {
//                    int pos = tbMark.getSelectedRow();
//                    if (pos < 0) {
//                        pos = 0;
//                    }
//                    mark = listm.get(pos);
//                }
//            });
//        }
    }

    void load_find(String name1) {
        MarkDAO ad = new MarkDAO();
        listm = ad.findStudentMark(name1);
        String columns[] = {"STT", "Mã SV", "Tên", "Môn học", "Điểm", "Trạng thái", "Ghi chú", "Ngày kêt thúc môn"};
        dtm = new DefaultTableModel(columns, 0);
        Integer i = 1;
        for (Mark m : listm) {
            int diem = (int) m.getMark();
            dtm.addRow(new Object[]{i, m.getS_MSV(), m.getClass_Name(), m.getS_name(), m.getSJ_name() == null ? "Chưa cập nhật" : m.getSJ_name(), m.getMark() == 0 ? "Chưa cập nhật" : m.getMark(), diem <= 10 && diem > 8 ? "Tốt" : diem > 7 ? "Khá" : diem >= 5 ? "Đạt" : "Trượt", m.getNote(), m.getEx_date()});
            i++;
        }
        tbMark.setModel(dtm);
        tbMark.setRowHeight(25);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMark = new javax.swing.JPopupMenu();
        View_mark = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        rSButtonMetro14 = new rojerusan.RSButtonMetro();
        rSButtonMetro15 = new rojerusan.RSButtonMetro();
        rSButtonMetro16 = new rojerusan.RSButtonMetro();
        jPanel21 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        rSButtonMetro6 = new rojerusan.RSButtonMetro();
        rSButtonMetro17 = new rojerusan.RSButtonMetro();
        filterClass = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        rSButtonMetro7 = new rojerusan.RSButtonMetro();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbMark = new javax.swing.JTable();

        View_mark.setText("Xem chi tiết");
        View_mark.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                View_markActionPerformed(evt);
            }
        });
        jPopupMark.add(View_mark);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel20.add(rSButtonMetro14, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 70, 70));

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
        jPanel20.add(rSButtonMetro15, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 70, 70));

        rSButtonMetro16.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonMetro16.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonMetro16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_update_50px.png"))); // NOI18N
        rSButtonMetro16.setText("Cập nhật");
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
        jPanel20.add(rSButtonMetro16, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 70, 70));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_graph_report_50px.png"))); // NOI18N
        jLabel10.setText("Quản lý điểm");
        jPanel21.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 1, 260, 70));

        jPanel20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 2, 260, 70));

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
        jPanel20.add(rSButtonMetro6, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 10, 70, 70));

        rSButtonMetro17.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonMetro17.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonMetro17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_ball_point_pen_50px.png"))); // NOI18N
        rSButtonMetro17.setText("Thêm");
        rSButtonMetro17.setBorderPainted(false);
        rSButtonMetro17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rSButtonMetro17.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        rSButtonMetro17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSButtonMetro17MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSButtonMetro17MouseExited(evt);
            }
        });
        rSButtonMetro17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro17ActionPerformed(evt);
            }
        });
        jPanel20.add(rSButtonMetro17, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 60, 70));

        filterClass.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                filterClassItemStateChanged(evt);
            }
        });
        filterClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterClassActionPerformed(evt);
            }
        });
        jPanel20.add(filterClass, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, 120, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Filter:");
        jPanel20.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, 20));

        rSButtonMetro7.setBackground(new java.awt.Color(255, 255, 255));
        rSButtonMetro7.setForeground(new java.awt.Color(0, 0, 0));
        rSButtonMetro7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_microsoft_excel_25px.png"))); // NOI18N
        rSButtonMetro7.setText("Export Excel");
        rSButtonMetro7.setBorderPainted(false);
        rSButtonMetro7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rSButtonMetro7.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        rSButtonMetro7.setPreferredSize(new java.awt.Dimension(100, 100));
        rSButtonMetro7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rSButtonMetro7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                rSButtonMetro7MouseExited(evt);
            }
        });
        rSButtonMetro7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButtonMetro7ActionPerformed(evt);
            }
        });
        jPanel20.add(rSButtonMetro7, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, 120, 20));

        jPanel20.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 120, -1));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel20.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 160, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Tên muốn tìm kiếm:");
        jPanel20.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, 20));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        tbMark.setModel(new javax.swing.table.DefaultTableModel(
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
        tbMark.setGridColor(new java.awt.Color(0, 0, 0));
        tbMark.setSelectionBackground(new java.awt.Color(51, 204, 255));
        tbMark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbMarkMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbMark);

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 568, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGap(118, 118, 118)
                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void rSButtonMetro14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro14MouseEntered
        rSButtonMetro14.setBackground(new Color(85, 159, 213));
    }//GEN-LAST:event_rSButtonMetro14MouseEntered

    private void rSButtonMetro14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro14MouseExited
        rSButtonMetro14.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_rSButtonMetro14MouseExited

    private void rSButtonMetro14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro14ActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        FrmFind ff = new FrmFind(frame, true);
        ff.setTitle("Tìm kiếm môn học theo tên");
        ff.setVisible(true);
        String a = ff.getData();
        load_find(a);
    }//GEN-LAST:event_rSButtonMetro14ActionPerformed

    private void rSButtonMetro15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro15MouseEntered
        rSButtonMetro15.setBackground(new Color(85, 159, 213));
    }//GEN-LAST:event_rSButtonMetro15MouseEntered

    private void rSButtonMetro15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro15MouseExited
        rSButtonMetro15.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_rSButtonMetro15MouseExited

    private void rSButtonMetro15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro15ActionPerformed
        int pos = tbMark.getSelectedRow();
        if (pos < 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì để xoá!");
        } else {
            int s_id = mark.getStudent_ID();
            int sj_id = mark.getSubject_ID();
            MarkDAO md = new MarkDAO();
            int choose = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xoá điểm môn " + mark.getSJ_name() + " của " + mark.getS_name() + " chứ!", "Xoá", JOptionPane.YES_NO_OPTION);
            if (choose == JOptionPane.YES_OPTION) {
                md.delete(s_id, sj_id);
                JOptionPane.showMessageDialog(null, "Đã Xoá");
                load_data();
            }
        }


    }//GEN-LAST:event_rSButtonMetro15ActionPerformed

    private void rSButtonMetro16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro16MouseEntered
        rSButtonMetro16.setBackground(new Color(85, 159, 213));
    }//GEN-LAST:event_rSButtonMetro16MouseEntered

    private void rSButtonMetro16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro16MouseExited
        rSButtonMetro16.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_rSButtonMetro16MouseExited

    private void rSButtonMetro16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro16ActionPerformed

        int pos = tbMark.getSelectedRow();
        if (pos < 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì cả");
        }
        
        String value = tbMark.getModel().getValueAt(pos, 1).toString();
//        JOptionPane.showMessageDialog(null, value);
        MarkDAO md = new MarkDAO();
        listm = md.findStudentMark1(value);
//        JOptionPane.showMessageDialog(null, listm);
        mark = listm.get(0);
        if (mark == null) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì cả");
        } else if (mark.getMark() == 0) {
            JOptionPane.showMessageDialog(null, "Môn học chưa có điểm để cập nhật");
        } else {
            String updatea = "Cập nhật";
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            FrmDialogMark fmark = new FrmDialogMark(frame, true, mark, updatea);
            fmark.setLocationRelativeTo(this);
            fmark.setTitle("Cập nhật");
            fmark.setVisible(true);
            load_data();
        }

    }//GEN-LAST:event_rSButtonMetro16ActionPerformed

    private void rSButtonMetro6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro6MouseEntered
        rSButtonMetro6.setBackground(new Color(85, 159, 213));
    }//GEN-LAST:event_rSButtonMetro6MouseEntered

    private void rSButtonMetro6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro6MouseExited
        rSButtonMetro6.setBackground(new Color(255, 255, 255));
    }//GEN-LAST:event_rSButtonMetro6MouseExited

    private void rSButtonMetro6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro6ActionPerformed
        load_data();
    }//GEN-LAST:event_rSButtonMetro6ActionPerformed

    private void tbMarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbMarkMouseClicked
        if (evt.getButton() == MouseEvent.BUTTON3) {
            jPopupMark.show(tbMark, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tbMarkMouseClicked

    private void View_markActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_View_markActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        viewInfoMark fview = new viewInfoMark(frame, true, mark);
        fview.setLocationRelativeTo(this);
        fview.setTitle("Thông tin sinh viên");
        fview.setVisible(true);
        load_data();
    }//GEN-LAST:event_View_markActionPerformed

    private void rSButtonMetro17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro17MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonMetro17MouseEntered

    private void rSButtonMetro17MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro17MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonMetro17MouseExited

    private void rSButtonMetro17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro17ActionPerformed
        int pos = tbMark.getSelectedRow();
        if (pos < 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì cả");
        } else if (mark != null) {
            String updatea = "Thêm mới";
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            FrmDialogMark fmark = new FrmDialogMark(frame, true, mark, updatea);
            fmark.setLocationRelativeTo(this);
            fmark.setVisible(true);
//            fmark.setTitle("Thêm mới");
            load_data();
        } else {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn gì cả");
        }
    }//GEN-LAST:event_rSButtonMetro17ActionPerformed

    private void filterClassItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_filterClassItemStateChanged

        String name1 = filterClass.getSelectedItem().toString();
        if (name1 == "Chọn môn học:") {
            load_data();
        } else {
            MarkDAO ad = new MarkDAO();
            listm = ad.findMarkBySubject(name1);
            String columns[] = {"STT", "Mã SV", "Lớp", "Tên", "Môn học", "Điểm", "Trạng thái", "Ghi chú", "Ngày kêt thúc môn"};
            dtm = new DefaultTableModel(columns, 0);
            Integer i = 1;
            for (Mark m : listm) {
                int diem = (int) m.getMark();
                dtm.addRow(new Object[]{i, m.getS_MSV(), m.getClass_Name(), m.getS_name(), m.getSJ_name() == null ? "Chưa cập nhật" : m.getSJ_name(), m.getMark() == 0 ? "Chưa cập nhật" : m.getMark(), diem <= 10 && diem > 8 ? "Tốt" : diem > 7 ? "Khá" : diem >= 5 ? "Đạt" : "Trượt", m.getNote(), m.getEx_date()});
                i++;
            }
            tbMark.setModel(dtm);
            tbMark.setRowHeight(25);
            if (listm.size() > 0) {
                tbMark.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent lse) {
                        int pos = tbMark.getSelectedRow();
                        if (pos < 0) {
                            pos = 0;
                        }
                        mark = listm.get(pos);
                    }
                });
            }
        }

    }//GEN-LAST:event_filterClassItemStateChanged

    private void rSButtonMetro7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro7MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonMetro7MouseEntered

    private void rSButtonMetro7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSButtonMetro7MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_rSButtonMetro7MouseExited

    private void rSButtonMetro7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButtonMetro7ActionPerformed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        ExportToExcel ee = new ExportToExcel(frame, true);
        ee.setLocationRelativeTo(this);
        ee.setVisible(true);
    }//GEN-LAST:event_rSButtonMetro7ActionPerformed

    private void filter(String query) {
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(dtm);
        tbMark.setRowSorter(tr);

        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        String query = jTextField1.getText();
        if (query != null) {
            filter(query);
        }

    }//GEN-LAST:event_jTextField1KeyReleased

    private void filterClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterClassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem View_mark;
    private javax.swing.JComboBox<String> filterClass;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPopupMenu jPopupMark;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private rojerusan.RSButtonMetro rSButtonMetro14;
    private rojerusan.RSButtonMetro rSButtonMetro15;
    private rojerusan.RSButtonMetro rSButtonMetro16;
    private rojerusan.RSButtonMetro rSButtonMetro17;
    private rojerusan.RSButtonMetro rSButtonMetro6;
    private rojerusan.RSButtonMetro rSButtonMetro7;
    private javax.swing.JTable tbMark;
    // End of variables declaration//GEN-END:variables
}
