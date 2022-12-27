package View;

import DAO.LoaiDAO;
import DT.Loai;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

public final class FormLoaiSanPham extends javax.swing.JFrame {

    Vector Hang;
    DefaultTableModel TableMoodel;
    LoaiDAO loaidao = new LoaiDAO();

    public FormLoaiSanPham() {
        initComponents();
        TableMoodel = new DefaultTableModel();
        TableMoodel.addColumn("Mã loại");
        TableMoodel.addColumn("Tên Loại");
        Hienthi();
        txtTongso.setText(String.valueOf(loaidao.Soluong()));
        reset();      
        headerTable();
        setIconImage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLua = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        txtMaLoai = new javax.swing.JTextField();
        txtTenLoai = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableThongKe = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTongso = new javax.swing.JTextField();
        btntrove = new javax.swing.JButton();
        btnqualisanpham = new javax.swing.JButton();
        lbltitle = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lbllogo = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Loại sản phẩm Sweet&Spicy");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(95, 59, 24));
        jLabel2.setText("Mã loại");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(90, 125, 66, 24);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(95, 59, 24));
        jLabel3.setText("Tên loại");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(90, 174, 73, 26);

        btnThem.setBackground(new java.awt.Color(204, 157, 110));
        btnThem.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(95, 59, 24));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add_icon.png"))); // NOI18N
        btnThem.setText("Thêm ");
        btnThem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnThem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem);
        btnThem.setBounds(40, 230, 107, 78);

        btnCapNhat.setBackground(new java.awt.Color(204, 157, 110));
        btnCapNhat.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/update_icon.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCapNhat.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCapNhat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        jPanel1.add(btnCapNhat);
        btnCapNhat.setBounds(320, 230, 107, 78);

        btnXoa.setBackground(new java.awt.Color(204, 157, 110));
        btnXoa.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete_icon.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXoa.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa);
        btnXoa.setBounds(460, 230, 107, 78);

        btnLua.setBackground(new java.awt.Color(204, 157, 110));
        btnLua.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnLua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save_icon.png"))); // NOI18N
        btnLua.setText("Lưu");
        btnLua.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLua.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnLua.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuaActionPerformed(evt);
            }
        });
        jPanel1.add(btnLua);
        btnLua.setBounds(180, 230, 107, 78);

        btnTimKiem.setBackground(new java.awt.Color(204, 157, 110));
        btnTimKiem.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(95, 59, 24));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/find_icon.png"))); // NOI18N
        btnTimKiem.setText("Tìm");
        btnTimKiem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnTimKiem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnTimKiem.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        jPanel1.add(btnTimKiem);
        btnTimKiem.setBounds(400, 120, 90, 35);

        txtMaLoai.setBackground(new java.awt.Color(239, 222, 206));
        txtMaLoai.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaLoai.setForeground(new java.awt.Color(110, 68, 26));
        txtMaLoai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        jPanel1.add(txtMaLoai);
        txtMaLoai.setBounds(180, 120, 150, 30);

        txtTenLoai.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtTenLoai.setForeground(new java.awt.Color(110, 68, 26));
        jPanel1.add(txtTenLoai);
        txtTenLoai.setBounds(180, 170, 150, 30);

        jTableThongKe.setBackground(new java.awt.Color(204, 204, 204));
        jTableThongKe.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTableThongKe.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jTableThongKe.setForeground(new java.awt.Color(144, 89, 35));
        jTableThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableThongKe.setGridColor(new java.awt.Color(95, 59, 24));
        jTableThongKe.setRowHeight(30);
        jTableThongKe.setSelectionBackground(new java.awt.Color(95, 59, 24));
        jTableThongKe.setSelectionForeground(new java.awt.Color(232, 216, 200));
        jScrollPane1.setViewportView(jTableThongKe);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(70, 380, 453, 210);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(95, 59, 24));
        jLabel4.setText("Tổng số");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 605, 82, 23);

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(95, 59, 24));
        jLabel5.setText("Loại");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(480, 605, 59, 23);

        txtTongso.setBackground(new java.awt.Color(239, 222, 206));
        txtTongso.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtTongso.setForeground(new java.awt.Color(110, 68, 26));
        txtTongso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        jPanel1.add(txtTongso);
        txtTongso.setBounds(350, 600, 114, 30);

        btntrove.setBackground(new java.awt.Color(110, 74, 38));
        btntrove.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btntrove.setForeground(new java.awt.Color(255, 255, 255));
        btntrove.setText("Quản lý chung");
        btntrove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btntrove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntroveActionPerformed(evt);
            }
        });
        jPanel1.add(btntrove);
        btntrove.setBounds(250, 680, 167, 29);

        btnqualisanpham.setBackground(new java.awt.Color(110, 74, 38));
        btnqualisanpham.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnqualisanpham.setForeground(new java.awt.Color(255, 255, 255));
        btnqualisanpham.setText("Quản lý sản phẩm");
        btnqualisanpham.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnqualisanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnqualisanphamActionPerformed(evt);
            }
        });
        jPanel1.add(btnqualisanpham);
        btnqualisanpham.setBounds(30, 680, 186, 29);

        lbltitle.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbltitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/loaisanpham_title.png"))); // NOI18N
        jPanel1.add(lbltitle);
        lbltitle.setBounds(90, 30, 460, 56);

        jButton1.setBackground(new java.awt.Color(204, 157, 110));
        jButton1.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(95, 59, 24));
        jButton1.setText("Làm mới");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(250, 320, 110, 30);

        jButton2.setBackground(new java.awt.Color(110, 74, 38));
        jButton2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Thoát");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(460, 680, 100, 29);

        lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sweetandspicy3_logo.png"))); // NOI18N
        jPanel1.add(lbllogo);
        lbllogo.setBounds(10, 10, 60, 80);

        lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/loaisanpham_background.png"))); // NOI18N
        lblbackground.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(lblbackground);
        lblbackground.setBounds(0, 0, 591, 736);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void Hienthi() {

        ArrayList<Loai> ds = loaidao.DSLoaiSP();
        TableMoodel.getDataVector().removeAllElements();
        for (int i = 0; i < ds.size(); i++) {
            Hang = new Vector();
            Loai loai = ds.get(i);
            Hang.add(loai.getMaLoai());
            Hang.add(loai.getTenLoai());
            TableMoodel.addRow(Hang);
        }
        jTableThongKe.setModel(TableMoodel);
    }
    //Title icon
    private void setIconImage(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/whitess_logo.png")));
    }
    //Table header
    public void headerTable(){
        JTableHeader headertb = jTableThongKe.getTableHeader();
        headertb.setBackground(new Color(110,55,13));
        headertb.setForeground(new Color(95,59,24));
        headertb.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
    }
    public void scaleImage(){
        //background
        ImageIcon sanpham_background = new ImageIcon(getClass().getResource("/Image/loaisanpham_background.png"));
        Image sanpham_img = sanpham_background.getImage();
        Image sanphamImgScale = sanpham_img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sanphamScaledIcon = new ImageIcon(sanphamImgScale);
        lblbackground.setIcon(sanphamScaledIcon);
        
        //title
        ImageIcon title_icon = new ImageIcon(getClass().getResource("/Image/loaisanpham_title.png"));
        Image title_img = title_icon.getImage();
        Image titleImgScale = title_img.getScaledInstance(lbltitle.getWidth(), lbltitle.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon titleScaledIcon = new ImageIcon(titleImgScale);
        lbltitle.setIcon(titleScaledIcon);
        
        //logo
        ImageIcon logo_icon = new ImageIcon(getClass().getResource("/Image/sweetandspicy3_logo.png"));
        Image logo_img = logo_icon.getImage();
        Image logoImgScale = logo_img.getScaledInstance(lbllogo.getWidth(), lbllogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon logoScaledIcon = new ImageIcon(logoImgScale);
        lbllogo.setIcon(logoScaledIcon);
    }
    //Button mau
    public void colorButton(JButton btn){
        btn.setForeground(new Color(95,59,24));
        btn.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        
    }
    //Button mac dinh
    public void nullColorButton(JButton btn){
        
        btn.setForeground(null);
        btn.setBorder(null);
    }
    //Txt mau
    public void colorTXT(JTextField txt){
        txt.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        txt.setBackground(new Color(239,222,206));
    }
    //Txt mac dinh
    public void nullColorTXT(JTextField txt){
        txt.setBackground(new Color(229,223,217));
        txt.setBorder(null);
    }
    public void reset() {
        txtMaLoai.setText("");
        txtTenLoai.setText("");
        txtTenLoai.setEnabled(false);
        nullColorTXT(txtTenLoai);
        btnCapNhat.setEnabled(false);
        nullColorButton(btnCapNhat);
        btnXoa.setEnabled(false);
        nullColorButton(btnXoa);
        btnLua.setEnabled(false);
        nullColorButton(btnLua);
        btnThem.setEnabled(true);
        colorButton(btnThem);
        btnTimKiem.setEnabled(true);
        colorButton(btnTimKiem);
    }

    public boolean kiemtra() {
        StringBuilder baoloi = new StringBuilder();
        if (txtMaLoai.getText().trim().equals("")) {
            baoloi.append("Mã loại phải được nhập.\n");
        }
        if (txtTenLoai.getText().trim().equals("")) {
            baoloi.append("Tên loại phải được nhập.\n");
        }
        if (baoloi.length() > 0) {
            JOptionPane.showMessageDialog(rootPane, baoloi);
            return false;
        }
        return true;
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        btnCapNhat.setEnabled(false);
        nullColorButton(btnCapNhat);
        
        btnTimKiem.setEnabled(false);
        nullColorButton(btnTimKiem);
        
        btnLua.setEnabled(true);
        colorButton(btnLua);
        
        txtTenLoai.setEnabled(true);
        colorTXT(txtTenLoai);
        
        btnThem.setEnabled(false);
        nullColorButton(btnThem);

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuaActionPerformed
        if (kiemtra()) {
            Loai loai = new Loai();
            if ((loaidao.TimKiemLoai(txtMaLoai.getText())) == null) {
                loai.setMaLoai(txtMaLoai.getText());
                loai.setTenLoai(txtTenLoai.getText());
                if (loaidao.ThemLoai(loai)) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm loại mới thành công!");
                     TableMoodel.getDataVector().removeAllElements();
                   
                    txtTongso.setText(String.valueOf(loaidao.Soluong()));
                    btnThem.setEnabled(true);
                    colorButton(btnThem);
                    
                    btnTimKiem.setEnabled(true);
                    colorButton(btnTimKiem);
                     Hienthi();
                    reset();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Thêm loại mới khồn thành công!");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Mã loại " + txtMaLoai.getText() + " đã tồn tại. Vui lòng chọn mã loại khác!");
            }

        }
    }//GEN-LAST:event_btnLuaActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn cập nhật thông tin loại sản phẩm?");
        if (check != 1) {
            if (kiemtra()) {
                Loai loai = new Loai();
                loai.setMaLoai(txtMaLoai.getText());
                loai.setTenLoai(txtTenLoai.getText());
                if (loaidao.CapNhatLoai(loai)) {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật loại thành công!");
                    TableMoodel.getDataVector().removeAllElements();
                    Hienthi();
                    txtTongso.setText(String.valueOf(loaidao.Soluong()));
                    btnThem.setEnabled(true);
                    colorButton(btnThem);
                    reset();
                }
                else JOptionPane.showMessageDialog(rootPane, "Cập nhật không thành công!");
            }
        }

    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        Loai loai = loaidao.TimKiemLoai(txtMaLoai.getText());
        if (loai != null) {
            JOptionPane.showMessageDialog(rootPane, "Tìm thấy sản sản phẩm");
            txtTenLoai.setEnabled(true);
            colorTXT(txtTenLoai);
            
            txtTenLoai.setText(loai.getTenLoai());
            btnCapNhat.setEnabled(true);
            colorButton(btnCapNhat);
            
            btnThem.setEnabled(false);
            nullColorButton(btnThem);
            
            btnLua.setEnabled(false);
            nullColorButton(btnLua);
            
            btnXoa.setEnabled(true);
            colorButton(btnXoa);

        } else
            JOptionPane.showMessageDialog(rootPane, "Không tìm thấy loại sản phẩm có mã " + txtMaLoai.getText());
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắc muốn xóa loại sản phẩm đã chọn?");
        if (check != 1) {

            if (loaidao.XoaLoaiSP(txtMaLoai.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
                TableMoodel.getDataVector().removeAllElements();
                Hienthi();
                btnThem.setEnabled(true);
                colorButton(btnThem);
                reset();
                txtTongso.setText(String.valueOf(loaidao.Soluong()));
            } else {
                JOptionPane.showMessageDialog(rootPane, "Xóa loại không thành công");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btntroveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntroveActionPerformed
        new FormQuanLy().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btntroveActionPerformed

    private void btnqualisanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnqualisanphamActionPerformed
        new FormSanPham().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnqualisanphamActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

//
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FormLoaiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormLoaiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormLoaiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormLoaiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormLoaiSanPham().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnqualisanpham;
    private javax.swing.JButton btntrove;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableThongKe;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JTextField txtMaLoai;
    private javax.swing.JTextField txtTenLoai;
    private javax.swing.JTextField txtTongso;
    // End of variables declaration//GEN-END:variables
}
