package View;

import DAO.KhachHangDAO;
import DT.KhachHang;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FormThemKhachHang extends javax.swing.JFrame {

    KhachHangDAO khachdao = new KhachHangDAO();
    String MaNV, sdt = "";

    public FormThemKhachHang(String nv) {
        MaNV = nv;
        initComponents();
        reset();
        scaleImage();
        setIconImage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGioiTinhj = new javax.swing.ButtonGroup();
        jPanelThongTin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        rbtnNam = new javax.swing.JRadioButton();
        rbtnNu = new javax.swing.JRadioButton();
        txtSDT = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        lbltitle = new javax.swing.JLabel();
        btnTroVe = new javax.swing.JButton();
        lbllogo = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thêm khách hàng Sweet&Spicy");
        setResizable(false);

        jPanelThongTin.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), java.awt.Color.black));
        jPanelThongTin.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(163, 108, 52));
        jLabel2.setText("Mã khách hàng");
        jPanelThongTin.add(jLabel2);
        jLabel2.setBounds(70, 130, 129, 30);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(163, 108, 52));
        jLabel3.setText("Họ và tên:");
        jPanelThongTin.add(jLabel3);
        jLabel3.setBounds(70, 180, 113, 30);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(163, 108, 52));
        jLabel4.setText("Giới tính:");
        jPanelThongTin.add(jLabel4);
        jLabel4.setBounds(70, 230, 113, 30);

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(163, 108, 52));
        jLabel5.setText("Số điện thoại");
        jPanelThongTin.add(jLabel5);
        jLabel5.setBounds(70, 270, 113, 30);

        txtMaKH.setBackground(new java.awt.Color(239, 222, 206));
        txtMaKH.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaKH.setForeground(new java.awt.Color(110, 68, 26));
        txtMaKH.setToolTipText("VD: KH1111");
        txtMaKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        jPanelThongTin.add(txtMaKH);
        txtMaKH.setBounds(230, 130, 110, 30);

        txtHoTen.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtHoTen.setForeground(new java.awt.Color(110, 68, 26));
        jPanelThongTin.add(txtHoTen);
        txtHoTen.setBounds(230, 180, 236, 30);

        buttonGroupGioiTinhj.add(rbtnNam);
        rbtnNam.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        rbtnNam.setForeground(new java.awt.Color(163, 108, 52));
        rbtnNam.setSelected(true);
        rbtnNam.setText("Nam");
        jPanelThongTin.add(rbtnNam);
        rbtnNam.setBounds(230, 230, 91, 27);

        buttonGroupGioiTinhj.add(rbtnNu);
        rbtnNu.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        rbtnNu.setForeground(new java.awt.Color(163, 108, 52));
        rbtnNu.setText("Nữ");
        jPanelThongTin.add(rbtnNu);
        rbtnNu.setBounds(340, 230, 91, 27);

        txtSDT.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtSDT.setForeground(new java.awt.Color(110, 68, 26));
        jPanelThongTin.add(txtSDT);
        txtSDT.setBounds(230, 270, 236, 30);

        btnThem.setBackground(new java.awt.Color(204, 157, 110));
        btnThem.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(95, 59, 24));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/addcustomer_icon.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnThem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanelThongTin.add(btnThem);
        btnThem.setBounds(100, 330, 107, 78);

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
        jPanelThongTin.add(btnCapNhat);
        btnCapNhat.setBounds(340, 330, 107, 78);

        btnLuu.setBackground(new java.awt.Color(204, 157, 110));
        btnLuu.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save_icon.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLuu.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnLuu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        jPanelThongTin.add(btnLuu);
        btnLuu.setBounds(220, 330, 107, 78);

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
        jPanelThongTin.add(btnTimKiem);
        btnTimKiem.setBounds(380, 125, 90, 35);

        lbltitle.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        lbltitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/themkhachhang_title.png"))); // NOI18N
        jPanelThongTin.add(lbltitle);
        lbltitle.setBounds(100, 20, 380, 60);

        btnTroVe.setBackground(new java.awt.Color(110, 74, 38));
        btnTroVe.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnTroVe.setForeground(new java.awt.Color(255, 255, 255));
        btnTroVe.setText("Trở về");
        btnTroVe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnTroVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroVeActionPerformed(evt);
            }
        });
        jPanelThongTin.add(btnTroVe);
        btnTroVe.setBounds(220, 450, 107, 29);

        lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sweetandspicy_logo.png"))); // NOI18N
        jPanelThongTin.add(lbllogo);
        lbllogo.setBounds(10, 10, 70, 80);

        lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/themkhachhang_background.png"))); // NOI18N
        lblbackground.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelThongTin.add(lblbackground);
        lblbackground.setBounds(0, 0, 547, 506);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelThongTin, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelThongTin, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //title

    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/whitess_logo.png")));
    }

    public void scaleImage() {
        //background
        ImageIcon background_icon = new ImageIcon(getClass().getResource("/Image/themkhachhang_background.png"));
        Image background_img = background_icon.getImage();
        Image backgroundImgScale = background_img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon backgroundScaledIcon = new ImageIcon(backgroundImgScale);
        lblbackground.setIcon(backgroundScaledIcon);

        //title
        ImageIcon title_icon = new ImageIcon(getClass().getResource("/Image/themkhachhang_title.png"));
        Image title_img = title_icon.getImage();
        Image titleImgScale = title_img.getScaledInstance(lbltitle.getWidth(), lbltitle.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon titleScaledIcon = new ImageIcon(titleImgScale);
        lbltitle.setIcon(titleScaledIcon);
        //logo
        ImageIcon logo_icon = new ImageIcon(getClass().getResource("/Image/sweetandspicy_logo.png"));
        Image logo_img = logo_icon.getImage();
        Image logoImgScale = logo_img.getScaledInstance(lbllogo.getWidth(), lbllogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon logoScaledIcon = new ImageIcon(logoImgScale);
        lbllogo.setIcon(logoScaledIcon);
    }

    //Button mau
    public void colorButton(JButton btn) {
        btn.setForeground(new Color(95, 59, 24));
        btn.setBorder(BorderFactory.createLineBorder(new Color(169, 134, 98), 3));

    }

    //Button mac dinh
    public void nullColorButton(JButton btn) {

        btn.setForeground(null);
        btn.setBorder(null);
    }

    //Txt mau
    public void colorTXT(JTextField txt) {
        txt.setBorder(BorderFactory.createLineBorder(new Color(169, 134, 98), 3));
        txt.setBackground(new Color(239, 222, 206));
    }

    //Txt mac dinh
    public void nullColorTXT(JTextField txt) {
        txt.setBackground(new Color(229, 223, 217));
        txt.setBorder(null);
    }

    public void reset() {
        txtMaKH.setText("");
        txtHoTen.setText("");
        txtSDT.setText("");
        rbtnNam.setSelected(true);
        // txtMaKH.setEnabled(false);
        txtHoTen.setEnabled(false);
        nullColorTXT(txtHoTen);
        txtSDT.setEnabled(false);
        nullColorTXT(txtSDT);
        btnCapNhat.setEnabled(false);
        nullColorButton(btnCapNhat);
        btnLuu.setEnabled(false);
        nullColorButton(btnLuu);
        btnThem.setEnabled(true);
        colorButton(btnThem);
        rbtnNam.setSelected(true);
        rbtnNu.setEnabled(false);
//        btnLamMoi.setEnabled(false);
//        nullColorButton(btnLamMoi);
    }

    public void chophepnhaplieu() {
        txtMaKH.setEnabled(true);
        colorTXT(txtMaKH);
        txtHoTen.setEnabled(true);
        colorTXT(txtHoTen);
        txtSDT.setEnabled(true);
        colorTXT(txtSDT);
        btnCapNhat.setEnabled(true);
        colorButton(btnCapNhat);
        btnLuu.setEnabled(true);
        colorButton(btnLuu);
        rbtnNu.setEnabled(true);
//        btnLamMoi.setEnabled(true);
//        colorButton(btnLamMoi);

    }

    public boolean kiemtra() {
        StringBuilder baoloi = new StringBuilder();
        if (txtMaKH.getText().trim().equals("")) {
            baoloi.append("Mã khách hàng phải được nhập.\n");
        } else if (!txtMaKH.getText().matches("KH\\d{4}")) {
            baoloi.append("Mã khách hàng phải đúng định dạng. VD: KH1234.\n");
        }
        if (txtHoTen.getText().trim().equals("")) {
            baoloi.append("Họ và tên khách hàng phải được nhập.\n");
        }
        if (txtSDT.getText().trim().equals("")) {
            baoloi.append("Số điện thoại phải được nhập.\n");
        } else if (!(txtSDT.getText().matches("-?\\d+(\\.\\d+)?")) || (txtSDT.getText().length() < 10) || (txtSDT.getText().length() > 12)) {
            baoloi.append("Số điện thoại phải là số và có từ 10-13 chữ số.\n");
        }
        if (baoloi.length() > 0) {
            JOptionPane.showMessageDialog(rootPane, baoloi);
            return false;
        }
        return true;
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        reset();
        chophepnhaplieu();
        btnCapNhat.setEnabled(false);
        nullColorButton(btnCapNhat);
//        btnThem.setEnabled(false);
//        nullColorButton(btnThem);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn cập nhật thông tin khách hàng?");
        if (check != 1) {
            if (kiemtra()) {
                KhachHang khach = new KhachHang();
                khach.setMaHK(txtMaKH.getText());
                khach.setHoten(txtHoTen.getText());
                if (rbtnNam.isSelected()) {
                    khach.setGioitinh(true);
                } else {
                    khach.setGioitinh(false);
                }
                khach.setSDT(txtSDT.getText());
                khach.setTongdoanhthu(0);
                sdt = txtSDT.getText();

                if (khachdao.CapNhatKH(khach)) {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thông tin khách hàng thành công.");
                                        reset();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thong tin khách hàng không thành công");
                }
            }
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        if (kiemtra()) {
            KhachHang khach = new KhachHang();
            khach.setMaHK(txtMaKH.getText());
            khach.setHoten(txtHoTen.getText());
            sdt = txtSDT.getText();
            if (rbtnNam.isSelected()) {
                khach.setGioitinh(true);
            } else {
                khach.setGioitinh(false);
            }
            khach.setSDT(txtSDT.getText());
            khach.setTongdoanhthu(0);
            if (khachdao.TimKiemKH(txtMaKH.getText()) != null) {
                JOptionPane.showMessageDialog(rootPane, "Mã khách hàng đã tồn tại vui lòng chọn mã khách hàng khác!");
            } else {
                if (khachdao.ThemKH(khach)) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm khách hàng mới thành công.");
                    reset();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Thêm khách hàng không thành công.");
                }

            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if (txtMaKH.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Bạn vui lòng nhập mã khách hàng cần tìm.");
        } else if (!(txtMaKH.getText().matches("KH\\d{4}"))) {
            JOptionPane.showMessageDialog(rootPane, "Mã khách hàng phải đúng định dạng. VD: KH1234.\n");
        }
        if (khachdao.TimKiemKH(txtMaKH.getText()) != null) {
            chophepnhaplieu();
            JOptionPane.showMessageDialog(rootPane, "Tìm thấy khách hàng có mã " + txtMaKH.getText());
            KhachHang khach = khachdao.TimKiemKH(txtMaKH.getText());
            txtMaKH.setText(khach.getMaHK());
            txtHoTen.setText(khach.getHoten());
            if (khach.getGioitinh() == true) {
                rbtnNam.setSelected(true);
            } else {
                rbtnNu.setSelected(true);
            }
            txtSDT.setText(khach.getSDT());
            btnThem.setEnabled(true);
            colorButton(btnThem);
            btnLuu.setEnabled(false);
            nullColorButton(btnLuu);
            sdt = txtSDT.getText();

        } else {
            JOptionPane.showMessageDialog(rootPane, "Mã khách hàng không tồn tại.");
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnTroVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroVeActionPerformed
        new FormCTHoaDon(MaNV, sdt).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTroVeActionPerformed

    /**
     * @param args the command line arguments
     */
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
//            java.util.logging.Logger.getLogger(FormThemKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormThemKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormThemKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormThemKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormThemKhachHang().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTroVe;
    private javax.swing.ButtonGroup buttonGroupGioiTinhj;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelThongTin;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JRadioButton rbtnNam;
    private javax.swing.JRadioButton rbtnNu;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables
}
