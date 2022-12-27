
package View;

import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;


public class FormQuanLy extends javax.swing.JFrame {

    public FormQuanLy() {
        initComponents();
        setSize (1030,580);
        
        //Title icon
        setIconImage();
        
        //Scale icon
        scaleImage();
        
    }
    
    //Title icon
    private void setIconImage(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/whitess_logo.png")));
    }
    
    //Scale image
    public void scaleImage(){
      
        //manager_icon
        ImageIcon manager_icon = new ImageIcon(getClass().getResource("/Image/manager_icon.png"));
        Image manager_img = manager_icon.getImage();
        Image managerImgScale = manager_img.getScaledInstance(lbManager.getWidth(), lbManager.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon managerScaledIcon = new ImageIcon(managerImgScale);
        lbManager.setIcon(managerScaledIcon);
        
        //title_icon
        ImageIcon title_icon = new ImageIcon(getClass().getResource("/Image/title_icon.png"));
        Image title_img = title_icon.getImage();
        Image titleImgScale = title_img.getScaledInstance(lbTitle.getWidth(), lbTitle.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon titleScaledIcon = new ImageIcon(titleImgScale);
        lbTitle.setIcon(titleScaledIcon);
        
        //logo_icon
        ImageIcon logo_icon = new ImageIcon(getClass().getResource("/Image/sweetandspicy_logo.png"));
        Image logo_img = logo_icon.getImage();
        Image logoImgScale = logo_img.getScaledInstance(lbLogo.getWidth(), lbLogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon logoScaledIcon = new ImageIcon(logoImgScale);
        lbLogo.setIcon(logoScaledIcon);
        
        
        //manage_background
        ImageIcon manage_background = new ImageIcon(getClass().getResource("/Image/manage_background.png"));
        Image managebackground_img = manage_background.getImage();
        Image managebackgroundImgScale = managebackground_img.getScaledInstance(lbCaroBackground.getWidth(), lbCaroBackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon managebackgroundScaledIcon = new ImageIcon(managebackgroundImgScale);
        lbCaroBackground.setIcon(managebackgroundScaledIcon);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbManager = new javax.swing.JLabel();
        btnNhanVien = new javax.swing.JButton();
        btnHoaDon = new javax.swing.JButton();
        btnKhuyenMai = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnDoanhThu = new javax.swing.JButton();
        btnMonAn = new javax.swing.JButton();
        btnDangXuat = new javax.swing.JButton();
        lbTitle = new javax.swing.JLabel();
        lbLogo = new javax.swing.JLabel();
        lbCaroBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sweet&Spicy");
        setBackground(new java.awt.Color(105, 65, 22));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(223, 216, 213));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setPreferredSize(new java.awt.Dimension(1014, 510));
        jPanel1.setLayout(null);

        lbManager.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/manager_icon.png"))); // NOI18N
        lbManager.setPreferredSize(new java.awt.Dimension(400, 363));
        jPanel1.add(lbManager);
        lbManager.setBounds(0, 160, 418, 363);

        btnNhanVien.setBackground(new java.awt.Color(163, 128, 110));
        btnNhanVien.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnNhanVien.setForeground(new java.awt.Color(82, 56, 46));
        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/staff_icon.png"))); // NOI18N
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(172, 123, 74), 4, true));
        btnNhanVien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNhanVien.setPreferredSize(new java.awt.Dimension(141, 113));
        btnNhanVien.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnNhanVien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });
        jPanel1.add(btnNhanVien);
        btnNhanVien.setBounds(602, 166, 141, 113);

        btnHoaDon.setBackground(new java.awt.Color(163, 128, 110));
        btnHoaDon.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnHoaDon.setForeground(new java.awt.Color(82, 56, 46));
        btnHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bill_icon.png"))); // NOI18N
        btnHoaDon.setText("Hóa đơn");
        btnHoaDon.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(172, 123, 74), 4, true));
        btnHoaDon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHoaDon.setPreferredSize(new java.awt.Dimension(141, 113));
        btnHoaDon.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnHoaDon.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoaDonActionPerformed(evt);
            }
        });
        jPanel1.add(btnHoaDon);
        btnHoaDon.setBounds(426, 314, 141, 113);

        btnKhuyenMai.setBackground(new java.awt.Color(163, 128, 110));
        btnKhuyenMai.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnKhuyenMai.setForeground(new java.awt.Color(82, 56, 46));
        btnKhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/discount_icon.png"))); // NOI18N
        btnKhuyenMai.setText("Khuyến mãi");
        btnKhuyenMai.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(172, 123, 74), 4, true));
        btnKhuyenMai.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhuyenMai.setPreferredSize(new java.awt.Dimension(141, 113));
        btnKhuyenMai.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnKhuyenMai.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhuyenMaiActionPerformed(evt);
            }
        });
        jPanel1.add(btnKhuyenMai);
        btnKhuyenMai.setBounds(602, 314, 141, 113);

        btnKhachHang.setBackground(new java.awt.Color(163, 128, 110));
        btnKhachHang.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnKhachHang.setForeground(new java.awt.Color(82, 56, 46));
        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/customer_icon.png"))); // NOI18N
        btnKhachHang.setText("Khách hàng");
        btnKhachHang.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(172, 123, 74), 4, true));
        btnKhachHang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnKhachHang.setPreferredSize(new java.awt.Dimension(141, 113));
        btnKhachHang.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnKhachHang.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });
        jPanel1.add(btnKhachHang);
        btnKhachHang.setBounds(776, 166, 141, 113);

        btnDoanhThu.setBackground(new java.awt.Color(163, 128, 110));
        btnDoanhThu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnDoanhThu.setForeground(new java.awt.Color(82, 56, 46));
        btnDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/revenue_icon.png"))); // NOI18N
        btnDoanhThu.setText("Doanh thu");
        btnDoanhThu.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(172, 123, 74), 4, true));
        btnDoanhThu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDoanhThu.setPreferredSize(new java.awt.Dimension(141, 113));
        btnDoanhThu.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnDoanhThu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoanhThuActionPerformed(evt);
            }
        });
        jPanel1.add(btnDoanhThu);
        btnDoanhThu.setBounds(776, 314, 141, 113);

        btnMonAn.setBackground(new java.awt.Color(163, 128, 110));
        btnMonAn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnMonAn.setForeground(new java.awt.Color(82, 56, 46));
        btnMonAn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/food_icon.png"))); // NOI18N
        btnMonAn.setText("Sản phẩm");
        btnMonAn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(172, 123, 74), 4, true));
        btnMonAn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnMonAn.setPreferredSize(new java.awt.Dimension(141, 113));
        btnMonAn.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnMonAn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnMonAn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMonAnActionPerformed(evt);
            }
        });
        jPanel1.add(btnMonAn);
        btnMonAn.setBounds(426, 166, 141, 113);

        btnDangXuat.setBackground(new java.awt.Color(112, 75, 51));
        btnDangXuat.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnDangXuat.setForeground(new java.awt.Color(227, 204, 196));
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(92, 50, 22), 4, true));
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        jPanel1.add(btnDangXuat);
        btnDangXuat.setBounds(776, 453, 141, 30);

        lbTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/title_icon.png"))); // NOI18N
        jPanel1.add(lbTitle);
        lbTitle.setBounds(8, 32, 804, 56);

        lbLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sweetandspicy_logo.png"))); // NOI18N
        lbLogo.setToolTipText("");
        jPanel1.add(lbLogo);
        lbLogo.setBounds(845, 16, 94, 120);

        lbCaroBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/manage_background.png"))); // NOI18N
        jPanel1.add(lbCaroBackground);
        lbCaroBackground.setBounds(10, 10, 981, 510);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        new FormNhanVien().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoaDonActionPerformed
        // TODO add your handling code here:
        new FormHoaDon().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnHoaDonActionPerformed

    private void btnKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhuyenMaiActionPerformed
        // TODO add your handling code here:
        new FormKhuyenMai().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnKhuyenMaiActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        // TODO add your handling code here:
        new FormKhachHang().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanhThuActionPerformed
        // TODO add your handling code here:
        new FormDoanhThu().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDoanhThuActionPerformed

    private void btnMonAnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMonAnActionPerformed
        new FormSanPham().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMonAnActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed

        new FormDangNhap().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnDangXuatActionPerformed

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
//            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormQuanLy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormQuanLy().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangXuat;
    private javax.swing.JButton btnDoanhThu;
    private javax.swing.JButton btnHoaDon;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnKhuyenMai;
    private javax.swing.JButton btnMonAn;
    private javax.swing.JButton btnNhanVien;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbCaroBackground;
    private javax.swing.JLabel lbLogo;
    private javax.swing.JLabel lbManager;
    private javax.swing.JLabel lbTitle;
    // End of variables declaration//GEN-END:variables
}
