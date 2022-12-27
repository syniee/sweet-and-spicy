package View;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;

public class FormDangNhap extends javax.swing.JFrame {
    public static String MaNV;
    Connection conn;
    PreparedStatement pr;
    ResultSet rs;
    DB.Connect db = new DB.Connect();
    
    public FormDangNhap() {
        initComponents();
        setSize(545, 465);
        setLocationRelativeTo(null);
        //Title icon
        setIconImage();
        
        //Scale icon
        scaleImage();
        
        //ComboBox
        setComboBox();
        
        //Replacing the password character to dot
        txtMatKhau.setEchoChar('\u25cf');
        
        //
        this.lbHidePW.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbTenDangNhap = new javax.swing.JLabel();
        lbMatKhau = new javax.swing.JLabel();
        lbChucVu = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        cbChucVu = new javax.swing.JComboBox<>();
        btnDangNhap = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        lbShowPW = new javax.swing.JLabel();
        lbHidePW = new javax.swing.JLabel();
        lbNen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng nhập");
        setBackground(new java.awt.Color(223, 216, 213));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(223, 216, 213));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setOpaque(false);
        jPanel2.setLayout(null);

        lbTenDangNhap.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbTenDangNhap.setForeground(new java.awt.Color(115, 65, 16));
        lbTenDangNhap.setText("Tên đăng nhập");
        jPanel2.add(lbTenDangNhap);
        lbTenDangNhap.setBounds(50, 120, 140, 30);

        lbMatKhau.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbMatKhau.setForeground(new java.awt.Color(115, 65, 16));
        lbMatKhau.setText("Mật khẩu");
        jPanel2.add(lbMatKhau);
        lbMatKhau.setBounds(100, 170, 90, 30);

        lbChucVu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbChucVu.setForeground(new java.awt.Color(115, 65, 16));
        lbChucVu.setText("Chức vụ");
        jPanel2.add(lbChucVu);
        lbChucVu.setBounds(100, 220, 90, 30);

        txtTenDangNhap.setBackground(new java.awt.Color(243, 235, 226));
        txtTenDangNhap.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtTenDangNhap.setForeground(new java.awt.Color(153, 102, 0));
        txtTenDangNhap.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtTenDangNhap.setToolTipText("Tên đăng nhập là mã số");
        txtTenDangNhap.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 120, 72), 4, true));
        txtTenDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtTenDangNhap.setVerifyInputWhenFocusTarget(false);
        jPanel2.add(txtTenDangNhap);
        txtTenDangNhap.setBounds(210, 120, 180, 30);

        txtMatKhau.setBackground(new java.awt.Color(243, 235, 226));
        txtMatKhau.setForeground(new java.awt.Color(153, 102, 0));
        txtMatKhau.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMatKhau.setToolTipText("Nhập mật khẩu");
        txtMatKhau.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 120, 72), 4, true));
        jPanel2.add(txtMatKhau);
        txtMatKhau.setBounds(210, 170, 180, 30);

        cbChucVu.setBackground(new java.awt.Color(128, 85, 43));
        cbChucVu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbChucVu.setForeground(new java.awt.Color(153, 99, 0));
        cbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhân viên" }));
        cbChucVu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(168, 120, 72), 3));
        jPanel2.add(cbChucVu);
        cbChucVu.setBounds(210, 220, 180, 30);
        cbChucVu.getAccessibleContext().setAccessibleName("");

        btnDangNhap.setBackground(new java.awt.Color(105, 72, 9));
        btnDangNhap.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnDangNhap.setForeground(new java.awt.Color(224, 206, 188));
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 120, 72), 2, true));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        jPanel2.add(btnDangNhap);
        btnDangNhap.setBounds(100, 280, 130, 50);

        btnThoat.setBackground(new java.awt.Color(105, 72, 9));
        btnThoat.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(224, 206, 188));
        btnThoat.setText("Thoát");
        btnThoat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(168, 120, 72), 2, true));
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        jPanel2.add(btnThoat);
        btnThoat.setBounds(300, 280, 130, 50);

        lbShowPW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/show_icon.png"))); // NOI18N
        lbShowPW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbShowPWMousePressed(evt);
            }
        });
        jPanel2.add(lbShowPW);
        lbShowPW.setBounds(400, 170, 40, 30);

        lbHidePW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hide_icon.png"))); // NOI18N
        lbHidePW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHidePWMousePressed(evt);
            }
        });
        jPanel2.add(lbHidePW);
        lbHidePW.setBounds(400, 170, 40, 30);

        lbNen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/login_background.png"))); // NOI18N
        jPanel2.add(lbNen);
        lbNen.setBounds(10, 10, 500, 400);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //Title icon
    private void setIconImage(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/whitess_logo.png")));
    }
    
    //Scale image
     public void scaleImage(){
        //Background
        ImageIcon test = new ImageIcon(getClass().getResource("/Image/login_background.png"));
        Image test_img = test.getImage();
        Image testImgScale = test_img.getScaledInstance(lbNen.getWidth(), lbNen.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon testScaledIcon = new ImageIcon(testImgScale);
        lbNen.setIcon(testScaledIcon);
        
        //Show password icon
        ImageIcon show_icon = new ImageIcon(getClass().getResource("/Image/show_icon.png"));
        Image showicon_img = show_icon.getImage();
        Image showIconImgScale = showicon_img.getScaledInstance(lbShowPW.getWidth(), lbShowPW.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon showIconScaledIcon = new ImageIcon(showIconImgScale);
        lbShowPW.setIcon(showIconScaledIcon);
        
        //Hide password icon
        ImageIcon hide_icon = new ImageIcon(getClass().getResource("/Image/hide_icon.png"));
        Image hideicon_img = hide_icon.getImage();
        Image hideIconImgScale = hideicon_img.getScaledInstance(lbHidePW.getWidth(), lbHidePW.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon hideIconScaledIcon = new ImageIcon(hideIconImgScale);
        lbHidePW.setIcon(hideIconScaledIcon);
    }
    
    public void setComboBox(){
        //Font combobox
        cbChucVu.setFont(new Font(Font.DIALOG, Font.PLAIN, 16));
    }
    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        KiemTra();
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed
    //Show password
    private void lbShowPWMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbShowPWMousePressed
        lbHidePW.setVisible(true);
        lbShowPW.setVisible(false);
        txtMatKhau.setEchoChar((char)0);
    }//GEN-LAST:event_lbShowPWMousePressed
    //Hide password
    private void lbHidePWMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHidePWMousePressed
        lbShowPW.setVisible(true);
        lbHidePW.setVisible(false);
        txtMatKhau.setEchoChar('\u25cf');
    }//GEN-LAST:event_lbHidePWMousePressed

    public void KiemTra() {

        if (txtTenDangNhap.getText().trim().equals("")) {
            JOptionPane.showConfirmDialog(rootPane, "Tên đăng nhập không được để trống.");
            return;
        }

        if (txtMatKhau.getText().trim().equals("")) {
            JOptionPane.showConfirmDialog(rootPane, "Mật khẩu không được để trống.");
            return;
        }
        if (cbChucVu.getSelectedIndex() == 0) {
            String sqlQuanli = "SELECT * FROM QUANLI WHERE TenDN=? and MatKhau = ?";
            System.out.println("1");
            try {
                conn = db.getConn();
                pr = conn.prepareStatement(sqlQuanli);
                pr.setString(1, txtTenDangNhap.getText());
                pr.setString(2, txtMatKhau.getText());
                rs = pr.executeQuery();
                if (rs.next()) {
                    new FormQuanLy().setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Tên đăng nhập hoặc mật khẩu sai.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Không thế kết nối đến cơ sở dữ liệu");
            }
        }
        if (cbChucVu.getSelectedIndex() == 1) {
            String sqlNhanVien = "SELECT * FROM NhanVien WHERE MaNhanVien=? and MatKhau = ?";
            try {
                conn = db.getConn();
                pr = conn.prepareStatement(sqlNhanVien);
                pr.setString(1, txtTenDangNhap.getText());
                pr.setString(2, txtMatKhau.getText());
                rs = pr.executeQuery();
                if (rs.next()) {
                    MaNV = txtTenDangNhap.getText();
                    FormCTHoaDon FromCTHD = new FormCTHoaDon(MaNV," ");
                    FromCTHD.setVisible(true);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Tên đăng nhập hoặc mật khẩu sai@!!@");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Không thế kết nối đến cơ sở dữ liệu");
            }
        }

    }

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
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> cbChucVu;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbChucVu;
    private javax.swing.JLabel lbHidePW;
    private javax.swing.JLabel lbMatKhau;
    private javax.swing.JLabel lbNen;
    private javax.swing.JLabel lbShowPW;
    private javax.swing.JLabel lbTenDangNhap;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables

}
