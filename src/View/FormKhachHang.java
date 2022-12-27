package View;

import DAO.KhachHangDAO;
import DT.KhachHang;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class FormKhachHang extends javax.swing.JFrame {

    Vector Hang;
    DefaultTableModel TableMoodel;
    KhachHangDAO khachdao = new KhachHangDAO();

    public FormKhachHang() {
        initComponents();
        TableMoodel = new DefaultTableModel();
        TableMoodel.addColumn("Mã khách hàng");
        TableMoodel.addColumn("Tên khách hàng");
        TableMoodel.addColumn("Giới tính");
        TableMoodel.addColumn("Số điện thoại");
        TableMoodel.addColumn("Tổng doanh thu");
        Hienthi();
        reset();
        jPanelTimKiemTheoDoanhThu.setVisible(false);
        jPanelTimKiemTheoGioiTinh.setVisible(false);
        jPanelTimKiemTheoSDT.setVisible(false);
        txtDoanhThu.setEnabled(false);
        headerTable();
        setComboBox();
        setIconImage();
        scaleImage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanelThongTin = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        rbtnNam = new javax.swing.JRadioButton();
        rbtnNu = new javax.swing.JRadioButton();
        txtSDT = new javax.swing.JTextField();
        txtDoanhThu = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        lblkhachhangbackground = new javax.swing.JLabel();
        lbltitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableThongKe = new javax.swing.JTable();
        btnTrove = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanelTimKiem = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanelTimKiemTheoDoanhThu = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtDoanhThuTu = new javax.swing.JTextField();
        txtDoanhTHuDEn = new javax.swing.JTextField();
        jPanelTimKiemTheoMa = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtTimKiemTheoMa = new javax.swing.JTextField();
        jPanelTimKiemTheoGioiTinh = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbGioiTinh = new javax.swing.JComboBox<>();
        jPanelTimKiemTheoSDT = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtTimKIemTheoSDT = new javax.swing.JTextField();
        cbTimKiemKhachHang = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        lbltimkiemkhachhang = new javax.swing.JLabel();
        lbllogo = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Khách hàng Sweet&Spicy");

        jPanel1.setLayout(null);

        jPanelThongTin.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), java.awt.Color.black));
        jPanelThongTin.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(163, 108, 52));
        jLabel2.setText("Mã khách hàng");
        jPanelThongTin.add(jLabel2);
        jLabel2.setBounds(22, 22, 145, 30);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(163, 108, 52));
        jLabel3.setText("Họ và tên:");
        jPanelThongTin.add(jLabel3);
        jLabel3.setBounds(22, 67, 104, 30);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(163, 108, 52));
        jLabel4.setText("Giới tính:");
        jPanelThongTin.add(jLabel4);
        jLabel4.setBounds(20, 109, 145, 30);

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(163, 108, 52));
        jLabel6.setText("Đã thanh toán");
        jPanelThongTin.add(jLabel6);
        jLabel6.setBounds(20, 194, 145, 30);

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(163, 108, 52));
        jLabel5.setText("Số điện thoại");
        jPanelThongTin.add(jLabel5);
        jLabel5.setBounds(20, 151, 122, 30);

        txtMaKH.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaKH.setForeground(new java.awt.Color(110, 68, 26));
        txtMaKH.setToolTipText("VD: KH1111");
        jPanelThongTin.add(txtMaKH);
        txtMaKH.setBounds(197, 21, 156, 30);

        txtHoTen.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtHoTen.setForeground(new java.awt.Color(110, 68, 26));
        jPanelThongTin.add(txtHoTen);
        txtHoTen.setBounds(197, 64, 236, 30);

        buttonGroup1.add(rbtnNam);
        rbtnNam.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        rbtnNam.setForeground(new java.awt.Color(163, 108, 52));
        rbtnNam.setText("Nam");
        jPanelThongTin.add(rbtnNam);
        rbtnNam.setBounds(197, 106, 91, 27);

        buttonGroup1.add(rbtnNu);
        rbtnNu.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        rbtnNu.setForeground(new java.awt.Color(163, 108, 52));
        rbtnNu.setText("Nữ");
        jPanelThongTin.add(rbtnNu);
        rbtnNu.setBounds(300, 106, 91, 27);

        txtSDT.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtSDT.setForeground(new java.awt.Color(110, 68, 26));
        jPanelThongTin.add(txtSDT);
        txtSDT.setBounds(197, 151, 156, 30);

        txtDoanhThu.setBackground(new java.awt.Color(239, 222, 206));
        txtDoanhThu.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtDoanhThu.setForeground(new java.awt.Color(110, 68, 26));
        txtDoanhThu.setDisabledTextColor(new java.awt.Color(110, 68, 26));
        jPanelThongTin.add(txtDoanhThu);
        txtDoanhThu.setBounds(197, 193, 156, 30);

        btnThem.setBackground(new java.awt.Color(204, 157, 110));
        btnThem.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
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
        btnThem.setBounds(20, 251, 107, 78);

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
        btnCapNhat.setBounds(246, 251, 107, 78);

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
        jPanelThongTin.add(btnXoa);
        btnXoa.setBounds(359, 251, 107, 78);

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
        btnLuu.setBounds(133, 251, 107, 78);

        btnLamMoi.setBackground(new java.awt.Color(204, 157, 110));
        btnLamMoi.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanelThongTin.add(btnLamMoi);
        btnLamMoi.setBounds(190, 358, 107, 30);

        lblkhachhangbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/thongtinkhachhang_background.png"))); // NOI18N
        lblkhachhangbackground.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelThongTin.add(lblkhachhangbackground);
        lblkhachhangbackground.setBounds(0, 0, 480, 400);

        jPanel1.add(jPanelThongTin);
        jPanelThongTin.setBounds(30, 130, 480, 400);

        lbltitle.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        lbltitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/khachhang_title.png"))); // NOI18N
        jPanel1.add(lbltitle);
        lbltitle.setBounds(330, 10, 450, 55);

        TableThongKe.setBackground(new java.awt.Color(204, 204, 204));
        TableThongKe.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TableThongKe.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        TableThongKe.setForeground(new java.awt.Color(144, 89, 35));
        TableThongKe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TableThongKe.setGridColor(new java.awt.Color(95, 59, 24));
        TableThongKe.setRowHeight(30);
        TableThongKe.setSelectionBackground(new java.awt.Color(95, 59, 24));
        TableThongKe.setSelectionForeground(new java.awt.Color(232, 216, 200));
        TableThongKe.setShowGrid(false);
        TableThongKe.setShowHorizontalLines(true);
        TableThongKe.setShowVerticalLines(true);
        jScrollPane1.setViewportView(TableThongKe);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 550, 980, 140);

        btnTrove.setBackground(new java.awt.Color(110, 74, 38));
        btnTrove.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnTrove.setForeground(new java.awt.Color(255, 255, 255));
        btnTrove.setText("Trở về");
        btnTrove.setToolTipText("Về quản lý mỳ cay - trà sữa");
        btnTrove.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnTrove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroveActionPerformed(evt);
            }
        });
        jPanel1.add(btnTrove);
        btnTrove.setBounds(390, 710, 107, 30);

        btnThoat.setBackground(new java.awt.Color(110, 74, 38));
        btnThoat.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Thoát");
        btnThoat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        jPanel1.add(btnThoat);
        btnThoat.setBounds(560, 710, 107, 30);

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(95, 59, 24));
        jLabel13.setText("Tìm kiếm");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(740, 90, 131, 30);

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(95, 59, 24));
        jLabel12.setText("Thông tin khách hàng");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(150, 90, 260, 30);

        jPanelTimKiem.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTimKiem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelTimKiem.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jPanelTimKiemTheoDoanhThu.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTimKiemTheoDoanhThu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(163, 108, 52));
        jLabel8.setText("Thanh toán từ");

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(163, 108, 52));
        jLabel9.setText("Đến");

        txtDoanhThuTu.setBackground(new java.awt.Color(239, 222, 206));
        txtDoanhThuTu.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtDoanhThuTu.setForeground(new java.awt.Color(110, 68, 26));
        txtDoanhThuTu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));

        txtDoanhTHuDEn.setBackground(new java.awt.Color(239, 222, 206));
        txtDoanhTHuDEn.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtDoanhTHuDEn.setForeground(new java.awt.Color(110, 68, 26));
        txtDoanhTHuDEn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));

        javax.swing.GroupLayout jPanelTimKiemTheoDoanhThuLayout = new javax.swing.GroupLayout(jPanelTimKiemTheoDoanhThu);
        jPanelTimKiemTheoDoanhThu.setLayout(jPanelTimKiemTheoDoanhThuLayout);
        jPanelTimKiemTheoDoanhThuLayout.setHorizontalGroup(
            jPanelTimKiemTheoDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemTheoDoanhThuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTimKiemTheoDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelTimKiemTheoDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDoanhThuTu, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(txtDoanhTHuDEn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTimKiemTheoDoanhThuLayout.setVerticalGroup(
            jPanelTimKiemTheoDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemTheoDoanhThuLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanelTimKiemTheoDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDoanhThuTu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelTimKiemTheoDoanhThuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDoanhTHuDEn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelTimKiemTheoMa.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTimKiemTheoMa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(163, 108, 52));
        jLabel10.setText("Mã khách hàng");

        txtTimKiemTheoMa.setBackground(new java.awt.Color(239, 222, 206));
        txtTimKiemTheoMa.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtTimKiemTheoMa.setForeground(new java.awt.Color(110, 68, 26));
        txtTimKiemTheoMa.setToolTipText("Nhập mã khách hàng");
        txtTimKiemTheoMa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));

        javax.swing.GroupLayout jPanelTimKiemTheoMaLayout = new javax.swing.GroupLayout(jPanelTimKiemTheoMa);
        jPanelTimKiemTheoMa.setLayout(jPanelTimKiemTheoMaLayout);
        jPanelTimKiemTheoMaLayout.setHorizontalGroup(
            jPanelTimKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemTheoMaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiemTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTimKiemTheoMaLayout.setVerticalGroup(
            jPanelTimKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemTheoMaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTimKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiemTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTimKiemTheoGioiTinh.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTimKiemTheoGioiTinh.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(163, 108, 52));
        jLabel7.setText("Giới tính");

        cbGioiTinh.setBackground(new java.awt.Color(196, 119, 44));
        cbGioiTinh.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        cbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cbGioiTinh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));

        javax.swing.GroupLayout jPanelTimKiemTheoGioiTinhLayout = new javax.swing.GroupLayout(jPanelTimKiemTheoGioiTinh);
        jPanelTimKiemTheoGioiTinh.setLayout(jPanelTimKiemTheoGioiTinhLayout);
        jPanelTimKiemTheoGioiTinhLayout.setHorizontalGroup(
            jPanelTimKiemTheoGioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemTheoGioiTinhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(cbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTimKiemTheoGioiTinhLayout.setVerticalGroup(
            jPanelTimKiemTheoGioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemTheoGioiTinhLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTimKiemTheoGioiTinhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTimKiemTheoSDT.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTimKiemTheoSDT.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(163, 108, 52));
        jLabel11.setText("Số điện thoại");

        txtTimKIemTheoSDT.setBackground(new java.awt.Color(239, 222, 206));
        txtTimKIemTheoSDT.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtTimKIemTheoSDT.setForeground(new java.awt.Color(110, 68, 26));
        txtTimKIemTheoSDT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));

        javax.swing.GroupLayout jPanelTimKiemTheoSDTLayout = new javax.swing.GroupLayout(jPanelTimKiemTheoSDT);
        jPanelTimKiemTheoSDT.setLayout(jPanelTimKiemTheoSDTLayout);
        jPanelTimKiemTheoSDTLayout.setHorizontalGroup(
            jPanelTimKiemTheoSDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemTheoSDTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(txtTimKIemTheoSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanelTimKiemTheoSDTLayout.setVerticalGroup(
            jPanelTimKiemTheoSDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTimKiemTheoSDTLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTimKiemTheoSDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimKIemTheoSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelTimKiemTheoSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTimKiemTheoDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTimKiemTheoGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTimKiemTheoMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanelTimKiemTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTimKiemTheoGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTimKiemTheoDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTimKiemTheoSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTimKiem.add(jPanel2);
        jPanel2.setBounds(20, 90, 424, 130);

        cbTimKiemKhachHang.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbTimKiemKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm kiếm theo mã", "Tìm kiếm theo giới tính", "Tìm kiếm theo doanh thu", "Tìm kiếm qua SDT", " " }));
        cbTimKiemKhachHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTimKiemKhachHangItemStateChanged(evt);
            }
        });
        cbTimKiemKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTimKiemKhachHangActionPerformed(evt);
            }
        });
        jPanelTimKiem.add(cbTimKiemKhachHang);
        cbTimKiemKhachHang.setBounds(30, 30, 300, 30);

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
        jPanelTimKiem.add(btnTimKiem);
        btnTimKiem.setBounds(350, 30, 90, 35);

        lbltimkiemkhachhang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/timkhachhang_icon.png"))); // NOI18N
        jPanelTimKiem.add(lbltimkiemkhachhang);
        lbltimkiemkhachhang.setBounds(0, 260, 460, 140);

        jPanel1.add(jPanelTimKiem);
        jPanelTimKiem.setBounds(550, 130, 460, 400);

        lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sweetandspicy_logo.png"))); // NOI18N
        jPanel1.add(lbllogo);
        lbllogo.setBounds(30, 5, 90, 90);

        lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/khachhang_background.png"))); // NOI18N
        lblbackground.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(lblbackground);
        lblbackground.setBounds(0, 0, 1037, 757);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1037, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 757, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    //title
    private void setIconImage(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/whitess_logo.png")));
    }
    public void scaleImage(){
        //thong tin khach hang
        ImageIcon thongtinKhachHang_icon = new ImageIcon(getClass().getResource("/Image/thongtinkhachhang_background.png"));
        Image thongtinKH_img = thongtinKhachHang_icon.getImage();
        Image thongtinKHImgScale = thongtinKH_img.getScaledInstance(lblkhachhangbackground.getWidth(), lblkhachhangbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon thongtinKHScaledIcon = new ImageIcon(thongtinKHImgScale);
        lblkhachhangbackground.setIcon(thongtinKHScaledIcon);
        
        //tim kiem
        ImageIcon find_icon = new ImageIcon(getClass().getResource("/Image/timkhachhang_icon.png"));
        Image find_img = find_icon.getImage();
        Image findImgScale = find_img.getScaledInstance(lbltimkiemkhachhang.getWidth(), lbltimkiemkhachhang.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon findScaledIcon = new ImageIcon(findImgScale);
        lbltimkiemkhachhang.setIcon(findScaledIcon);
        
        //title
        ImageIcon title_icon = new ImageIcon(getClass().getResource("/Image/khachhang_title.png"));
        Image title_img = title_icon.getImage();
        Image titleImgScale = title_img.getScaledInstance(lbltitle.getWidth(), lbltitle.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon titleScaledIcon = new ImageIcon(titleImgScale);
        lbltitle.setIcon(titleScaledIcon);
        
        //background
        ImageIcon background_icon = new ImageIcon(getClass().getResource("/Image/khachhang_background.png"));
        Image background_img = background_icon.getImage();
        Image backgroundImgScale = background_img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon backgroundScaledIcon = new ImageIcon(backgroundImgScale);
        lblbackground.setIcon(backgroundScaledIcon);
        
        //logo
        ImageIcon logo_icon = new ImageIcon(getClass().getResource("/Image/sweetandspicy_logo.png"));
        Image logo_img = logo_icon.getImage();
        Image logoImgScale = logo_img.getScaledInstance(lbllogo.getWidth(), lbllogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon logoScaledIcon = new ImageIcon(logoImgScale);
        lbllogo.setIcon(logoScaledIcon);
    }
    public void Hienthi() {
        ArrayList<KhachHang> ds = khachdao.danhsachKH();
        for (int i = 0; i < ds.size(); i++) {
            Hang = new Vector();
            KhachHang khach = ds.get(i);
            Hang.add(khach.getMaHK());
            Hang.add(khach.getHoten());
            if (khach.getGioitinh() == true) {
                Hang.add("Nam");
            } else {
                Hang.add("Nữ");
            }
            Hang.add(khach.getSDT());
            Hang.add(khach.getTongdoanhthu());
            TableMoodel.addRow(Hang);
        }
        TableThongKe.setModel(TableMoodel);

    }
    public void headerTable(){
        JTableHeader headertb = TableThongKe.getTableHeader();
        headertb.setBackground(new Color(110,55,13));
        headertb.setForeground(new Color(95,59,24));
        headertb.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
    }
    public void setComboBox(){
        cbTimKiemKhachHang.setBackground(new Color(196,119,44));
        cbTimKiemKhachHang.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        cbTimKiemKhachHang.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        
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
        txtMaKH.setText("");
        txtHoTen.setText("");
        txtSDT.setText("");
        txtDoanhThu.setText("");
        rbtnNam.setSelected(true);
        
        txtMaKH.setEnabled(false);
        nullColorTXT(txtMaKH);
        txtDoanhThu.setEnabled(false);
        nullColorTXT(txtDoanhThu);
        txtHoTen.setEnabled(false);
        nullColorTXT(txtHoTen);
        txtSDT.setEnabled(false);
        nullColorTXT(txtSDT);
        
        btnCapNhat.setEnabled(false);
        nullColorButton(btnCapNhat);
        
        btnXoa.setEnabled(false);
        nullColorButton(btnXoa);
        
        btnLuu.setEnabled(false);
        nullColorButton(btnLuu);
        
        rbtnNam.setSelected(true);
        rbtnNu.setEnabled(false);
        
        btnLamMoi.setEnabled(false);
        nullColorButton(btnLamMoi);
        
        btnThem.setEnabled(true);
        colorButton(btnThem);
    }

    public void chophepnhaplieu() {
        txtDoanhThu.setEnabled(false);
        nullColorTXT(txtDoanhThu);
        txtMaKH.setEnabled(true);
        colorTXT(txtMaKH);
        txtHoTen.setEnabled(true);
        colorTXT(txtHoTen);
        txtSDT.setEnabled(true);
        colorTXT(txtSDT);
        
        btnCapNhat.setEnabled(true);
        colorButton(btnCapNhat);
        
        btnXoa.setEnabled(true);
        colorButton(btnXoa);
        
        btnLuu.setEnabled(true);
        colorButton(btnLuu);
        
        rbtnNu.setEnabled(true);
        btnLamMoi.setEnabled(true);
        colorButton(btnLamMoi);
        
        btnXoa.setEnabled(false);
        nullColorButton(btnXoa);
        
        btnCapNhat.setEnabled(false);
        nullColorButton(btnCapNhat);
        
        btnThem.setEnabled(false);
        nullColorButton(btnThem);
        
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
    private void btnTroveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroveActionPerformed
        new FormQuanLy().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTroveActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        chophepnhaplieu();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
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
            if (khachdao.ThemKH(khach)) {
                JOptionPane.showMessageDialog(rootPane, "Thêm khách hàng mới thành công.");
                reset();
                TableMoodel.getDataVector().removeAllElements();
                Hienthi();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thêm khách hàng không thành công.");
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        //TÌM KIẾM KHÁCH HÀNG THEO MÃ KHÁCH HÀNG
        if (cbTimKiemKhachHang.getSelectedIndex() == 0) {
            if (txtTimKiemTheoMa.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Bạn vui lòng nhập mã khách hàng cần tìm.");
            } else if (!(txtTimKiemTheoMa.getText().matches("KH\\d{4}"))) {
                JOptionPane.showMessageDialog(rootPane, "Mã khách hàng phải đúng định dạng. VD: KH1234.\n");
            }
            if (khachdao.TimKiemKH(txtTimKiemTheoMa.getText()) != null) {
                chophepnhaplieu();
                JOptionPane.showMessageDialog(rootPane, "Tìm thấy khách hàng có mã " + txtTimKiemTheoMa.getText());
                KhachHang khach = khachdao.TimKiemKH(txtTimKiemTheoMa.getText());
                txtMaKH.setText(khach.getMaHK());
                txtHoTen.setText(khach.getHoten());
                if (khach.getGioitinh() == true) {
                    rbtnNam.setSelected(true);
                } else {
                    rbtnNu.setSelected(true);
                }
                txtSDT.setText(khach.getSDT());
                txtDoanhThu.setText(String.valueOf(khach.getTongdoanhthu()));
//                txtDoanhThu.setBackground(new Color(239,222,206));
//                txtDoanhThu.setEnabled(true);
                colorTXT(txtDoanhThu);
//                txtDoanhThu.setBackground(new Color(239,222,206));
                btnCapNhat.setEnabled(true);
                colorButton(btnCapNhat);
                btnXoa.setEnabled(true);
                colorButton(btnXoa);
                
                btnThem.setEnabled(false);
                nullColorButton(btnThem);
                btnLuu.setEnabled(false);
                nullColorButton(btnLuu);

            } else {
                JOptionPane.showMessageDialog(rootPane, "Mã khách hàng không tồn tại.");
            }
            //TÌM KIẾM KHÁCH HÀNG THEO GIỚI TÍNH
        } else if (cbTimKiemKhachHang.getSelectedIndex() == 1) {
            if (cbGioiTinh.getSelectedIndex() == 0) { // giới tính nam
                TableMoodel.getDataVector().removeAllElements();
                ArrayList<KhachHang> ds = khachdao.danhsachKH();
                for (int i = 0; i < ds.size(); i++) {
                    Hang = new Vector();
                    KhachHang khach = ds.get(i);
                    if (khach.getGioitinh() == true) {
                        Hang.add(khach.getMaHK());
                        Hang.add(khach.getHoten());
                        Hang.add("Nam");
                        Hang.add(khach.getSDT());
                        Hang.add(khach.getTongdoanhthu());
                        TableMoodel.addRow(Hang);
                    }
                }
                TableThongKe.setModel(TableMoodel);
            } else {
                ArrayList<KhachHang> ds = khachdao.danhsachKH();
                TableMoodel.getDataVector().removeAllElements();
                for (int i = 0; i < ds.size(); i++) {
                    Hang = new Vector();
                    KhachHang khach = ds.get(i);
                    if (khach.getGioitinh() == false) { // giới tính nữ
                        Hang.add(khach.getMaHK());
                        Hang.add(khach.getHoten());
                        Hang.add("Nữ");
                        Hang.add(khach.getSDT());
                        Hang.add(khach.getTongdoanhthu());
                        TableMoodel.addRow(Hang);
                    }
                }
                TableThongKe.setModel(TableMoodel);
            }
// TÌM KIẾM KHÁCH HÀNG THEO KHOẢNG DOANH THU
    }//GEN-LAST:event_btnTimKiemActionPerformed
        else if (cbTimKiemKhachHang.getSelectedIndex() == 2) {
            if (txtDoanhThuTu.getText().trim().equals("") || txtDoanhTHuDEn.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Bạn vui lòng nhập khoảng doanh thu của khách hàng.");
            } else if (!txtDoanhThuTu.getText().matches("-?\\d+(\\.\\d+)?") || !txtDoanhTHuDEn.getText().matches("-?\\d+(\\.\\d+)?")) {
                JOptionPane.showMessageDialog(rootPane, "Khoảng doanh thu phải là số");
            } else {
                ArrayList<KhachHang> ds = khachdao.danhsachKH();
                TableMoodel.getDataVector().removeAllElements();
                for (int i = 0; i < ds.size(); i++) {
                    Hang = new Vector();
                    KhachHang khach = ds.get(i);
                    if (khach.getTongdoanhthu() >= (Float.valueOf(txtDoanhThuTu.getText()))) {
                        if (khach.getTongdoanhthu() <= (Float.valueOf(txtDoanhTHuDEn.getText()))) {
                            Hang.add(khach.getMaHK());
                            Hang.add(khach.getHoten());
                            if (khach.getGioitinh() == true) {
                                Hang.add("Nam");
                            } else {
                                Hang.add("Nữ");
                            }
                            Hang.add(khach.getSDT());
                            Hang.add(khach.getTongdoanhthu());
                            TableMoodel.addRow(Hang);

                        }
                    }
                }
                TableThongKe.setModel(TableMoodel);
            }

        } else {
            ArrayList<KhachHang> ds = khachdao.danhsachKH();
            TableMoodel.getDataVector().removeAllElements();
            for (int i = 0; i < ds.size(); i++) {
                Hang = new Vector();
                KhachHang khach = ds.get(i);
                if (khach.getSDT().trim().equals(txtTimKIemTheoSDT.getText().trim())) {
                    Hang.add(khach.getMaHK());
                    Hang.add(khach.getHoten());
                            if (khach.getGioitinh() == true) {
                                Hang.add("Nam");
                            } else {
                                Hang.add("Nữ");
                            }
                    Hang.add(khach.getSDT());
                    Hang.add(khach.getTongdoanhthu());
                    TableMoodel.addRow(Hang);

                }
            }
            TableThongKe.setModel(TableMoodel);

        }
    }
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
                if (khachdao.CapNhatKH(khach)) {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thông tin khách hàng thành công.");
                    reset();
                    TableMoodel.getDataVector().removeAllElements();
                    Hienthi();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thong tin khách hàng không thành công");
                }
            }
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn xóa khách hàng có mã " + txtMaKH.getText());
        if (check != 1) {
            if (khachdao.XoaKH(txtMaKH.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Xóa khách hàng thành công");
                reset();
                TableMoodel.getDataVector().removeAllElements();
                Hienthi();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Xóa khách hàng không thành công");
            }

        }
    }//GEN-LAST:event_btnXoaActionPerformed
    // HIÊN THỊ COMBOBOX TÌM KIẾM THEO NHU CẦU TÌM KIẾM
    private void cbTimKiemKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTimKiemKhachHangActionPerformed
        if (cbTimKiemKhachHang.getSelectedIndex() == 0) {
            jPanelTimKiemTheoGioiTinh.setVisible(false);
            jPanelTimKiemTheoDoanhThu.setVisible(false);
            jPanelTimKiemTheoMa.setVisible(true);
            jPanelTimKiemTheoSDT.setVisible(false);
        } else if (cbTimKiemKhachHang.getSelectedIndex() == 1) {
            jPanelTimKiemTheoGioiTinh.setVisible(true);
            jPanelTimKiemTheoDoanhThu.setVisible(false);
            jPanelThongTin.setEnabled(false);
            jPanelTimKiemTheoMa.setVisible(false);
            jPanelTimKiemTheoSDT.setVisible(false);
        } else if (cbTimKiemKhachHang.getSelectedIndex() == 2) {
            jPanelTimKiemTheoGioiTinh.setVisible(false);
            jPanelTimKiemTheoDoanhThu.setVisible(true);
            jPanelThongTin.setEnabled(false);
            jPanelTimKiemTheoMa.setVisible(false);
            jPanelTimKiemTheoSDT.setVisible(false);
        } else {
            jPanelTimKiemTheoGioiTinh.setVisible(false);
            jPanelTimKiemTheoDoanhThu.setVisible(false);
            jPanelThongTin.setEnabled(false);
            jPanelTimKiemTheoMa.setVisible(false);
            jPanelTimKiemTheoSDT.setVisible(true);
        }
    }//GEN-LAST:event_cbTimKiemKhachHangActionPerformed

    private void cbTimKiemKhachHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTimKiemKhachHangItemStateChanged
        if (cbTimKiemKhachHang.getSelectedIndex() == 0) {
            jPanelTimKiemTheoGioiTinh.setVisible(false);
            jPanelTimKiemTheoDoanhThu.setVisible(false);
            jPanelTimKiemTheoMa.setVisible(true);
            jPanelTimKiemTheoSDT.setVisible(false);
        } else if (cbTimKiemKhachHang.getSelectedIndex() == 1) {
            jPanelTimKiemTheoGioiTinh.setVisible(true);
            jPanelTimKiemTheoDoanhThu.setVisible(false);
            jPanelThongTin.setEnabled(false);
            jPanelTimKiemTheoMa.setVisible(false);
            jPanelTimKiemTheoSDT.setVisible(false);
        } else if (cbTimKiemKhachHang.getSelectedIndex() == 2) {
            jPanelTimKiemTheoGioiTinh.setVisible(false);
            jPanelTimKiemTheoDoanhThu.setVisible(true);
            jPanelThongTin.setEnabled(false);
            jPanelTimKiemTheoMa.setVisible(false);
            jPanelTimKiemTheoSDT.setVisible(false);
        } else {
            jPanelTimKiemTheoGioiTinh.setVisible(false);
            jPanelTimKiemTheoDoanhThu.setVisible(false);
            jPanelThongTin.setEnabled(false);
            jPanelTimKiemTheoMa.setVisible(false);
            jPanelTimKiemTheoSDT.setVisible(true);
        }
    }//GEN-LAST:event_cbTimKiemKhachHangItemStateChanged

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        reset();
    }//GEN-LAST:event_btnLamMoiActionPerformed

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
//            java.util.logging.Logger.getLogger(FormKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormKhachHang().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableThongKe;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTrove;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbGioiTinh;
    private javax.swing.JComboBox<String> cbTimKiemKhachHang;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelThongTin;
    private javax.swing.JPanel jPanelTimKiem;
    private javax.swing.JPanel jPanelTimKiemTheoDoanhThu;
    private javax.swing.JPanel jPanelTimKiemTheoGioiTinh;
    private javax.swing.JPanel jPanelTimKiemTheoMa;
    private javax.swing.JPanel jPanelTimKiemTheoSDT;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lblkhachhangbackground;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lbltimkiemkhachhang;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JRadioButton rbtnNam;
    private javax.swing.JRadioButton rbtnNu;
    private javax.swing.JTextField txtDoanhTHuDEn;
    private javax.swing.JTextField txtDoanhThu;
    private javax.swing.JTextField txtDoanhThuTu;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTimKIemTheoSDT;
    private javax.swing.JTextField txtTimKiemTheoMa;
    // End of variables declaration//GEN-END:variables
}
