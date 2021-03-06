/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Panel;

import QuanLySinhVien.Check;
import QuanLySinhVien.MonHoc;
import com.mysql.jdbc.Statement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author DMX PHO THANH
 */
public class FrmMH extends javax.swing.JPanel {

    /**
     * Creates new form FrmMH
     */
    public FrmMH() {
        initComponents();

        try {
            DbKetNoi.Db.getConnection();
            hienthidanhmonhoc();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Hiện thị thành công", "", 1);
        }
    }

    //Lấy danh sách môn học : 
    public ArrayList<MonHoc> laydanhsachmonhoc() {
        ArrayList<MonHoc> list = new ArrayList<>();
        try {

            Connection conn = (Connection) DbKetNoi.Db.getConnection();
            java.sql.Statement st = (java.sql.Statement) conn.createStatement();
            String sql = "SELECT * FROM monhoc";
            ResultSet rs = st.executeQuery(sql);

            MonHoc mh;
            while (rs.next()) {
                mh = new MonHoc(rs.getString("mamh"), rs.getString("tenmh"), rs.getInt("tinchi"), rs.getString("khoa"));

                list.add(mh);

            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }

    //Hiển thị danh sách môn học:
    public void hienthidanhmonhoc() {
        String co1tieude[] = new String[]{"Mã môn học", "Tên môn học", "Số tín chỉ", "Khoa"};

        ArrayList<MonHoc> list = laydanhsachmonhoc();

        DefaultTableModel model = new DefaultTableModel(co1tieude, 0);

        Object[] row;
        for (int i = 0; i < list.size(); i++) {
            row = new Object[4];

            //gán giá trị
            row[0] = list.get(i).getMamh();
            row[1] = list.get(i).getTenmh();
            row[2] = list.get(i).getTinchi();
            row[3] = list.get(i).getKhoa();

            //thêm vao model
            model.addRow(row);

            //hien thi Jtable
            jTableMonHoc.setModel(model);

        }
    }

    //Kiểm tra các texBox:
    public boolean checkinfo() {
        Check c = new Check();
        if (!c.checkID(txtMa.getText())) {
            JOptionPane.showMessageDialog(this, "Nhập mã sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtMa.setText("");
            txtMa.requestFocus();
            return false;
        } else if (!c.checkSpace(txtTen.getText()) || !c.check(txtTen.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên or sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtTen.setText("");
            txtTen.requestFocus();
            return false;

        } else if (!c.checkSpace(txtSoTinChi.getText()) || !c.checkNumber(txtSoTinChi.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập or sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtSoTinChi.setText("");
            txtSoTinChi.requestFocus();
            return false;
        } else if (!c.checkSpace(txtKhoa.getText()) || !c.check(txtKhoa.getText())) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập or sai", "Hãy nhập lại", JOptionPane.ERROR_MESSAGE);
            txtKhoa.setText("");
            txtKhoa.requestFocus();
            return false;

        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        txtMa = new javax.swing.JTextField();
        txtTen = new javax.swing.JTextField();
        txtSoTinChi = new javax.swing.JTextField();
        txtKhoa = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMonHoc = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnInsert = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnResert = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));

        txtMa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtTen.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtSoTinChi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtKhoa.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Số tín chỉ : ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Khoa : ");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Mã môn học : ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Tên môn học : ");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save.png"))); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(txtSoTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoTinChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txtKhoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        jTableMonHoc.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTableMonHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã Môn Học : ", "Tên Môn Học : ", "Số Tín Chỉ : ", "Khoa"
            }
        ));
        jTableMonHoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMonHocMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMonHoc);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        btnInsert.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnInsert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/new.png"))); // NOI18N
        btnInsert.setText("Inset");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Update.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnResert.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnResert.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/reset.png"))); // NOI18N
        btnResert.setText("Resert");
        btnResert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResertActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnResert, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInsert, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnInsert)
                .addGap(20, 20, 20)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(btnResert)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Package-Accept-icon.png"))); // NOI18N
        jLabel5.setText("BẢNG MÔN HỌC");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(208, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        // TODO add your handling code here:
        try {
            Connection conn = (Connection) DbKetNoi.Db.getConnection();
            Statement st = (Statement) conn.createStatement();

            String query = "INSERT INTO monhoc(mamh, tenmh, tinchi, khoa) VALUES ('"
                    + txtMa.getText() + "','"
                    + txtTen.getText() + "', '"
                    + txtSoTinChi.getText() + "', '"
                    + txtKhoa.getText()
                    + "')";

            st.executeUpdate(query);
            //Kiểm tra dữ liêu:
            Check c = new Check();
            if (!checkinfo()) {
                return;
            }
            hienthidanhmonhoc();

            JOptionPane.showMessageDialog(null, "Thêm Thành Công", "Thông Báo", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi . Trùng MÃ MH !", "Thông Báo", 1);
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:

        try {
            Connection con = (Connection) DbKetNoi.Db.getConnection();
            Statement st = (Statement) con.createStatement();
            String query = "UPDATE monhoc SET mamh = '"
                    + txtMa.getText()
                    + "', tenmh = '"
                    + txtTen.getText()
                    + "', tinchi = '"
                    + txtSoTinChi.getText()
                    + "',khoa = '"
                    + txtKhoa.getText()
                    + "' WHERE mamh = '"
                    + txtMa.getText()
                    + "'";

            st.executeUpdate(query);
            //Kiểm tra dữ liệu
            Check c = new Check();
            if (!checkinfo()) {
                return;
            }
            hienthidanhmonhoc();

            JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công", "Thông Báo", 1);
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "Lỗi . vui lòng nhập lại", "Thông Báo", 1);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:

        try {
            Connection conn = (Connection) DbKetNoi.Db.getConnection();
            Statement st = (Statement) conn.createStatement();
            String query = "DELETE FROM monhoc WHERE mamh = '" + txtMa.getText() + "'";

            st.executeUpdate(query);
            hienthidanhmonhoc();

            JOptionPane.showMessageDialog(null, "Xóa Thành Công", "Thông Báo", 1);
        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "Lỗi . vui lòng nhập lại", "Thông Báo", 1);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnResertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResertActionPerformed
        // TODO add your handling code here:
        txtMa.setText("");
        txtTen.setText("");
        txtSoTinChi.setText("");
        txtKhoa.setText("");
        txtMa.getFocusListeners();

        //
        btnInsert.setEnabled(true);
        btnDelete.setEnabled(false);
        btnUpdate.setEnabled(false);
        txtKhoa.setEnabled(true);
        txtMa.setEnabled(true);
    }//GEN-LAST:event_btnResertActionPerformed

    private void jTableMonHocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMonHocMouseClicked
        // TODO add your handling code here:
        try {
            int i = jTableMonHoc.getSelectedRow();
            TableModel model = jTableMonHoc.getModel();

            txtMa.setText(model.getValueAt(i, 0).toString());
            txtTen.setText(model.getValueAt(i, 1).toString());
            txtSoTinChi.setText(model.getValueAt(i, 2).toString());
            txtKhoa.setText(model.getValueAt(i, 3).toString());

        } catch (Exception e2) {
            JOptionPane.showMessageDialog(null, "Chưa có dữ liệu. vui lòng thêm dữ liệu", "Thông Báo", 1);
        }
        btnInsert.setEnabled(false);
        btnDelete.setEnabled(true);
        btnUpdate.setEnabled(true);
        txtMa.setEnabled(false);
    }//GEN-LAST:event_jTableMonHocMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            java.io.File file = chooser.getSelectedFile();
            try {
                FileWriter out = new FileWriter(file + ".xls");
                BufferedWriter bwrite = new BufferedWriter(out);
                DefaultTableModel model = (DefaultTableModel) jTableMonHoc.getModel();
                // ten Cot
                for (int j = 0; j < jTableMonHoc.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < jTableMonHoc.getRowCount(); j++) {
                    for (int k = 0; k < jTableMonHoc.getColumnCount(); k++) {
                        bwrite.write(model.getValueAt(j, k) + "\t");
                    }
                    bwrite.write("\n");
                }
                bwrite.close();
                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnResert;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMonHoc;
    private javax.swing.JTextField txtKhoa;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtSoTinChi;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables

}
