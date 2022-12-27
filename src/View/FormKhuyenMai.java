package View;

import DAO.KhuyenMaiDAO;
import DAO.LoaiDAO;
import DT.KhuyenMai;
import DT.Loai;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

public class FormKhuyenMai extends javax.swing.JFrame {

    KhuyenMai km;
    KhuyenMaiDAO daoKM = new KhuyenMaiDAO();
    Loai loai;
    LoaiDAO loaidao = new LoaiDAO();
    ArrayList<KhuyenMai> dsKM;
    ArrayList<Loai> dsloai;
    Vector Hang;
    DefaultTableModel Bang;
    SimpleDateFormat dinhdangnam = new SimpleDateFormat("yyyy-MM-dd");

    public FormKhuyenMai() {
        initComponents();
        loadLoaiSP();
        reset();
        Bang = new DefaultTableModel();
        Bang.addColumn("Mã khuyến mãi");
        Bang.addColumn("Tên khuyến mãi");
        Bang.addColumn("Ưu đãi");
        Bang.addColumn("Loại sản phẩm áp dụng");
        Bang.addColumn("Phần trăm giảm giá");
        Bang.addColumn("Áp dụng cho hoán đơn trên");
        Bang.addColumn("Ngày bắt đầu");
        Bang.addColumn("Ngày kết thúc");
        HienTHiBang();

        headerTable();

        setIconImage();

        scaleImage();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbltitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaKhuyenMai = new javax.swing.JTextField();
        txtTenKM = new javax.swing.JTextField();
        DatechooseTu = new com.toedter.calendar.JDateChooser();
        DateChooseDen = new com.toedter.calendar.JDateChooser();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnLamMOi = new javax.swing.JButton();
        jPanelUuDai = new javax.swing.JPanel();
        panelGiamGiatheoHD = new javax.swing.JPanel();
        labelHDTren = new javax.swing.JLabel();
        spinnerGiamGiaHDTu = new javax.swing.JSpinner();
        panelGiamGia = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        spinnerPhanTramGiamGia = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        panelSPApDung = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbSanpham = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cbLoaiUuDai = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        lbldiscount = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableKhuyenMai = new javax.swing.JTable();
        btnTroVe = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        cbTimKiemTheo = new javax.swing.JComboBox<>();
        btnTimKiem = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        panelTimKiemTheoMa = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtTimKiemTheoMa = new javax.swing.JTextField();
        panelTimKiemTheoUudai = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        cbTimKiemTheoUudai = new javax.swing.JComboBox<>();
        panelTimKiemTheoNgay = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        DateChooseTKTu = new com.toedter.calendar.JDateChooser();
        DateChooseTKDen = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        panelTimKiemTheoSP = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        cbTimKiemTheoSP = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        lblbackgroundfind = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lbllogo = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Khuyến mãi Sweet&Spicy");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(null);

        lbltitle.setFont(new java.awt.Font("Dialog", 0, 43)); // NOI18N
        lbltitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/khuyenmai_title.png"))); // NOI18N
        jPanel1.add(lbltitle);
        lbltitle.setBounds(460, 20, 530, 50);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(163, 108, 52));
        jLabel2.setText("Mã khuyến mãi");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(30, 60, 160, 30);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(163, 108, 52));
        jLabel3.setText("Tên chương trình");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(30, 100, 150, 30);

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(114, 75, 37));
        jLabel7.setText("Thời gian áp dụng");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(120, 280, 160, 30);

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(163, 108, 52));
        jLabel8.setText("Từ ngày");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 320, 80, 30);

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(163, 108, 52));
        jLabel9.setText("Đến ngày");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(30, 370, 100, 28);

        txtMaKhuyenMai.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaKhuyenMai.setForeground(new java.awt.Color(110, 68, 26));
        txtMaKhuyenMai.setToolTipText("VD: KM111");
        jPanel2.add(txtMaKhuyenMai);
        txtMaKhuyenMai.setBounds(270, 60, 110, 30);

        txtTenKM.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtTenKM.setForeground(new java.awt.Color(110, 68, 26));
        jPanel2.add(txtTenKM);
        txtTenKM.setBounds(270, 100, 270, 30);

        DatechooseTu.setBackground(new java.awt.Color(169, 134, 98));
        DatechooseTu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(DatechooseTu);
        DatechooseTu.setBounds(161, 320, 190, 30);

        DateChooseDen.setBackground(new java.awt.Color(169, 134, 98));
        DateChooseDen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(DateChooseDen);
        DateChooseDen.setBounds(161, 370, 190, 30);

        btnThem.setBackground(new java.awt.Color(204, 157, 110));
        btnThem.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/addsale_icon.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setToolTipText("");
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnThem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel2.add(btnThem);
        btnThem.setBounds(380, 320, 107, 78);

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
        jPanel2.add(btnXoa);
        btnXoa.setBounds(740, 320, 107, 78);

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
        jPanel2.add(btnCapNhat);
        btnCapNhat.setBounds(620, 320, 107, 78);

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
        jPanel2.add(btnLuu);
        btnLuu.setBounds(500, 320, 107, 78);

        btnLamMOi.setBackground(new java.awt.Color(204, 157, 110));
        btnLamMOi.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnLamMOi.setText("Làm mới");
        btnLamMOi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMOiActionPerformed(evt);
            }
        });
        jPanel2.add(btnLamMOi);
        btnLamMOi.setBounds(560, 420, 110, 30);

        jPanelUuDai.setBackground(new java.awt.Color(204, 204, 204));

        panelGiamGiatheoHD.setBackground(new java.awt.Color(204, 204, 204));

        labelHDTren.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        labelHDTren.setForeground(new java.awt.Color(163, 108, 52));
        labelHDTren.setText("Hóa đơn trên");

        spinnerGiamGiaHDTu.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        spinnerGiamGiaHDTu.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), Float.valueOf(0.0f), Float.valueOf(1.0E7f), Float.valueOf(10000.0f)));
        spinnerGiamGiaHDTu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelGiamGia.setBackground(new java.awt.Color(204, 204, 204));

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(163, 108, 52));
        jLabel13.setText("Giảm giá");

        spinnerPhanTramGiamGia.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        spinnerPhanTramGiamGia.setModel(new javax.swing.SpinnerNumberModel(0, 0, 100, 5));
        spinnerPhanTramGiamGia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(163, 108, 52));
        jLabel10.setText("%");

        javax.swing.GroupLayout panelGiamGiaLayout = new javax.swing.GroupLayout(panelGiamGia);
        panelGiamGia.setLayout(panelGiamGiaLayout);
        panelGiamGiaLayout.setHorizontalGroup(
            panelGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGiamGiaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spinnerPhanTramGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        panelGiamGiaLayout.setVerticalGroup(
            panelGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(spinnerPhanTramGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout panelGiamGiatheoHDLayout = new javax.swing.GroupLayout(panelGiamGiatheoHD);
        panelGiamGiatheoHD.setLayout(panelGiamGiatheoHDLayout);
        panelGiamGiatheoHDLayout.setHorizontalGroup(
            panelGiamGiatheoHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGiamGiatheoHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelHDTren, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(spinnerGiamGiaHDTu, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelGiamGiatheoHDLayout.createSequentialGroup()
                .addComponent(panelGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelGiamGiatheoHDLayout.setVerticalGroup(
            panelGiamGiatheoHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGiamGiatheoHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGiamGiatheoHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelHDTren, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(spinnerGiamGiaHDTu, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelSPApDung.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(163, 108, 52));
        jLabel6.setText("Áp dụng với loại sản phẩm");

        cbSanpham.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbSanpham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả sản phẩm", "Mỳ Cay", "Trà Sữa", "Kimbap", "Nước Ngọt" }));
        cbSanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSanphamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSPApDungLayout = new javax.swing.GroupLayout(panelSPApDung);
        panelSPApDung.setLayout(panelSPApDungLayout);
        panelSPApDungLayout.setHorizontalGroup(
            panelSPApDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPApDungLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbSanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        panelSPApDungLayout.setVerticalGroup(
            panelSPApDungLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSPApDungLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panelSPApDungLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbSanpham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelUuDaiLayout = new javax.swing.GroupLayout(jPanelUuDai);
        jPanelUuDai.setLayout(jPanelUuDaiLayout);
        jPanelUuDaiLayout.setHorizontalGroup(
            jPanelUuDaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUuDaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelUuDaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelUuDaiLayout.createSequentialGroup()
                        .addComponent(panelSPApDung, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(jPanelUuDaiLayout.createSequentialGroup()
                        .addComponent(panelGiamGiatheoHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanelUuDaiLayout.setVerticalGroup(
            jPanelUuDaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelUuDaiLayout.createSequentialGroup()
                .addComponent(panelGiamGiatheoHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(panelSPApDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        jPanel2.add(jPanelUuDai);
        jPanelUuDai.setBounds(20, 180, 490, 90);

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(163, 108, 52));
        jLabel5.setText("Loại ưu đãi");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 145, 120, 30);

        cbLoaiUuDai.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbLoaiUuDai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mua 2 tặng 1", "Giảm giá cho tất cả hóa đơn", "Giảm giá cho hóa đơn ", " " }));
        cbLoaiUuDai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLoaiUuDaiItemStateChanged(evt);
            }
        });
        jPanel2.add(cbLoaiUuDai);
        cbLoaiUuDai.setBounds(270, 140, 270, 33);

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(95, 59, 24));
        jLabel11.setText("Thông tin khuyến mãi");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(300, 10, 290, 40);

        lbldiscount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sale_icon.png"))); // NOI18N
        jPanel2.add(lbldiscount);
        lbldiscount.setBounds(590, 60, 230, 200);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 80, 860, 460);

        TableKhuyenMai.setBackground(new java.awt.Color(204, 204, 204));
        TableKhuyenMai.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TableKhuyenMai.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        TableKhuyenMai.setForeground(new java.awt.Color(144, 89, 35));
        TableKhuyenMai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TableKhuyenMai.setGridColor(new java.awt.Color(95, 59, 24));
        TableKhuyenMai.setRowHeight(30);
        TableKhuyenMai.setSelectionBackground(new java.awt.Color(95, 59, 24));
        TableKhuyenMai.setSelectionForeground(new java.awt.Color(232, 216, 200));
        TableKhuyenMai.setShowHorizontalLines(true);
        TableKhuyenMai.setShowVerticalLines(true);
        jScrollPane1.setViewportView(TableKhuyenMai);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(20, 550, 1400, 130);

        btnTroVe.setText("Trở về");
        btnTroVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroVeActionPerformed(evt);
            }
        });
        jPanel1.add(btnTroVe);
        btnTroVe.setBounds(996, 896, 73, 22);

        jButton2.setText("Thoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(1087, 896, 73, 22);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(null);

        cbTimKiemTheo.setBackground(new java.awt.Color(196, 119, 44));
        cbTimKiemTheo.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbTimKiemTheo.setForeground(new java.awt.Color(95, 59, 24));
        cbTimKiemTheo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm kiếm theo mã", "Tìm kiếm theo ưu đãi", "Tìm kiếm theo sản phẩm áp dụng", "Tìm kiếm theo ngày áp dụng" }));
        cbTimKiemTheo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbTimKiemTheo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbTimKiemTheoItemStateChanged(evt);
            }
        });
        jPanel5.add(cbTimKiemTheo);
        cbTimKiemTheo.setBounds(30, 90, 314, 31);

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
        jPanel5.add(btnTimKiem);
        btnTimKiem.setBounds(390, 90, 90, 35);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        panelTimKiemTheoMa.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(163, 108, 52));
        jLabel4.setText("Mã khuyến mãi");

        txtTimKiemTheoMa.setBackground(new java.awt.Color(239, 222, 206));
        txtTimKiemTheoMa.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtTimKiemTheoMa.setForeground(new java.awt.Color(110, 68, 26));
        txtTimKiemTheoMa.setToolTipText("Nhập mã khuyến mãi");
        txtTimKiemTheoMa.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtTimKiemTheoMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemTheoMaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTimKiemTheoMaLayout = new javax.swing.GroupLayout(panelTimKiemTheoMa);
        panelTimKiemTheoMa.setLayout(panelTimKiemTheoMaLayout);
        panelTimKiemTheoMaLayout.setHorizontalGroup(
            panelTimKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTimKiemTheoMaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiemTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTimKiemTheoMaLayout.setVerticalGroup(
            panelTimKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTimKiemTheoMaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTimKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimKiemTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelTimKiemTheoUudai.setBackground(new java.awt.Color(204, 204, 204));

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(163, 108, 52));
        jLabel16.setText("Ưu đãi");

        cbTimKiemTheoUudai.setBackground(new java.awt.Color(196, 119, 44));
        cbTimKiemTheoUudai.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        cbTimKiemTheoUudai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mua 2 tặng 1", "Giảm giá cho tất cả hóa đơn", "Giảm giá cho hóa đơn " }));
        cbTimKiemTheoUudai.setToolTipText("");
        cbTimKiemTheoUudai.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelTimKiemTheoUudaiLayout = new javax.swing.GroupLayout(panelTimKiemTheoUudai);
        panelTimKiemTheoUudai.setLayout(panelTimKiemTheoUudaiLayout);
        panelTimKiemTheoUudaiLayout.setHorizontalGroup(
            panelTimKiemTheoUudaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTimKiemTheoUudaiLayout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(cbTimKiemTheoUudai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        panelTimKiemTheoUudaiLayout.setVerticalGroup(
            panelTimKiemTheoUudaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTimKiemTheoUudaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTimKiemTheoUudaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(cbTimKiemTheoUudai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6))
        );

        panelTimKiemTheoNgay.setBackground(new java.awt.Color(204, 204, 204));

        jLabel18.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(163, 108, 52));
        jLabel18.setText("Từ ngày");

        DateChooseTKTu.setBackground(new java.awt.Color(196, 119, 44));
        DateChooseTKTu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        DateChooseTKDen.setBackground(new java.awt.Color(196, 119, 44));
        DateChooseTKDen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel19.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(163, 108, 52));
        jLabel19.setText("Đến ngày");

        javax.swing.GroupLayout panelTimKiemTheoNgayLayout = new javax.swing.GroupLayout(panelTimKiemTheoNgay);
        panelTimKiemTheoNgay.setLayout(panelTimKiemTheoNgayLayout);
        panelTimKiemTheoNgayLayout.setHorizontalGroup(
            panelTimKiemTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTimKiemTheoNgayLayout.createSequentialGroup()
                .addGroup(panelTimKiemTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addGroup(panelTimKiemTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DateChooseTKTu, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(DateChooseTKDen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTimKiemTheoNgayLayout.setVerticalGroup(
            panelTimKiemTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTimKiemTheoNgayLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelTimKiemTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DateChooseTKTu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelTimKiemTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DateChooseTKDen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTimKiemTheoSP.setBackground(new java.awt.Color(204, 204, 204));

        jLabel17.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(163, 108, 52));
        jLabel17.setText("Loại sản phẩm");

        cbTimKiemTheoSP.setBackground(new java.awt.Color(196, 119, 44));
        cbTimKiemTheoSP.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        cbTimKiemTheoSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả sản phẩm", "Mỳ Cay", "Trà Sữa", "Kimbap", "Nước Ngọt" }));
        cbTimKiemTheoSP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelTimKiemTheoSPLayout = new javax.swing.GroupLayout(panelTimKiemTheoSP);
        panelTimKiemTheoSP.setLayout(panelTimKiemTheoSPLayout);
        panelTimKiemTheoSPLayout.setHorizontalGroup(
            panelTimKiemTheoSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTimKiemTheoSPLayout.createSequentialGroup()
                .addComponent(jLabel17)
                .addGap(18, 18, 18)
                .addComponent(cbTimKiemTheoSP, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        panelTimKiemTheoSPLayout.setVerticalGroup(
            panelTimKiemTheoSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTimKiemTheoSPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTimKiemTheoSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(cbTimKiemTheoSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTimKiemTheoSP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTimKiemTheoMa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTimKiemTheoUudai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTimKiemTheoNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(panelTimKiemTheoSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTimKiemTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTimKiemTheoUudai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTimKiemTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        jPanel5.add(jPanel4);
        jPanel4.setBounds(20, 140, 480, 130);

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(95, 59, 24));
        jLabel12.setText("Tìm kiếm");
        jPanel5.add(jLabel12);
        jLabel12.setBounds(230, 10, 110, 40);

        lblbackgroundfind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/discountfind_icon.png"))); // NOI18N
        jPanel5.add(lblbackgroundfind);
        lblbackgroundfind.setBounds(0, 310, 530, 150);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(890, 80, 530, 460);

        jButton1.setBackground(new java.awt.Color(110, 74, 38));
        jButton1.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Thoát");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(790, 700, 110, 30);

        jButton3.setBackground(new java.awt.Color(110, 74, 38));
        jButton3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Trở về");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(580, 700, 110, 30);

        lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sweetandspicy_logo.png"))); // NOI18N
        jPanel1.add(lbllogo);
        lbllogo.setBounds(20, 3, 60, 75);

        lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/khuyenmai_background.png"))); // NOI18N
        lblbackground.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(lblbackground);
        lblbackground.setBounds(0, 0, 1446, 744);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1446, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 744, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // LOAD DỮ LIỆU CHO COMBOBOX LOAI SAN PHẨM

    public void loadLoaiSP() {
        dsloai = loaidao.DSLoaiSP();
        cbSanpham.removeAllItems();
        cbSanpham.addItem("Tất cả sản phẩm");
        cbTimKiemTheoSP.removeAllItems();
        cbTimKiemTheoSP.addItem("Tất cả sản phẩm");
        for (int i = 0; i < dsloai.size(); i++) {
            loai = dsloai.get(i);
            cbSanpham.addItem(loai.getTenLoai());
            cbTimKiemTheoSP.addItem(loai.getTenLoai());
        }
    }

    //HIỂN THỊ BẢNG KHUYẾN MÃI
    public void HienTHiBang() {
        dsKM = daoKM.dsKhuyenMai();
        Bang.getDataVector().removeAllElements();
        for (int i = 0; i < dsKM.size(); i++) {
            km = dsKM.get(i);
            Hang = new Vector();
            Hang.add(km.getMaKM());
            Hang.add(km.getTenKM());
            Hang.add(km.getUuDai());
            Hang.add(km.getLoaiSanPham());
            Hang.add(km.getPhantramgiam());
            Hang.add(km.getHoaDon());
            Hang.add(km.getTuNgay());
            Hang.add(km.getDenNgay());
            Bang.addRow(Hang);
        }
        TableKhuyenMai.setModel(Bang);
    }

    //Title icon
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/whitess_logo.png")));
    }

    public void scaleImage() {
        //background
        ImageIcon sanpham_background = new ImageIcon(getClass().getResource("/Image/khuyenmai_background.png"));
        Image sanpham_img = sanpham_background.getImage();
        Image sanphamImgScale = sanpham_img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sanphamScaledIcon = new ImageIcon(sanphamImgScale);
        lblbackground.setIcon(sanphamScaledIcon);

        //tim kiem
        ImageIcon timkiem_icon = new ImageIcon(getClass().getResource("/Image/discountfind_icon.png"));
        Image timkiem_img = timkiem_icon.getImage();
        Image timkiemImgScale = timkiem_img.getScaledInstance(lblbackgroundfind.getWidth(), lblbackgroundfind.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon timkiemScaledIcon = new ImageIcon(timkiemImgScale);
        lblbackgroundfind.setIcon(timkiemScaledIcon);

        //thong tin
        ImageIcon ttsp_icon = new ImageIcon(getClass().getResource("/Image/sale_icon.png"));
        Image ttsp_img = ttsp_icon.getImage();
        Image ttspImgScale = ttsp_img.getScaledInstance(lbldiscount.getWidth(), lbldiscount.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ttspScaledIcon = new ImageIcon(ttspImgScale);
        lbldiscount.setIcon(ttspScaledIcon);

        //title
        ImageIcon title_icon = new ImageIcon(getClass().getResource("/Image/khuyenmai_title.png"));
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

    //Table header
    public void headerTable() {
        JTableHeader headertb = TableKhuyenMai.getTableHeader();
        headertb.setBackground(new Color(110, 55, 13));
        headertb.setForeground(new Color(95, 59, 24));
        headertb.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
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

    //Combobox mau
    public void setComboBox(JComboBox cb) {
        cb.setBackground(new Color(196, 119, 44));
        cb.setBorder(BorderFactory.createLineBorder(new Color(169, 134, 98), 3));
        cb.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));

    }

    //Combobox mac dinh
    public void setNullComboBox(JComboBox cb) {
        cb.setBackground(null);
        cb.setBorder(null);
        cb.setFont(null);
    }

    // LÀM MỚI FORM
    public void reset() {
        txtMaKhuyenMai.setText("");

        btnCapNhat.setEnabled(false);
        nullColorButton(btnCapNhat);
        btnThem.setEnabled(true);
        colorButton(btnThem);
        btnLamMOi.setEnabled(false);
        nullColorButton(btnLamMOi);
        btnLuu.setEnabled(false);
        nullColorButton(btnLuu);
        btnXoa.setEnabled(false);
        nullColorButton(btnXoa);

        txtTenKM.setEnabled(false);
        nullColorTXT(txtTenKM);

        cbLoaiUuDai.setEnabled(false);
        setNullComboBox(cbLoaiUuDai);
        cbSanpham.setEnabled(false);
        setNullComboBox(cbSanpham);

        DateChooseDen.setEnabled(false);
        DatechooseTu.setEnabled(false);

        txtMaKhuyenMai.setEnabled(false);
        nullColorTXT(txtMaKhuyenMai);
        //spinnerGiamGiaHDTu.setEnabled(false);
        //spinnerPhanTramGiamGia.setEnabled(false);
        panelGiamGiatheoHD.setVisible(false);
        panelTimKiemTheoNgay.setVisible(false);
        panelTimKiemTheoSP.setVisible(false);
        panelTimKiemTheoUudai.setVisible(false);

    }

    // KIỂM TRA LỖI 
    public boolean kiemtra() {
        StringBuilder baoloi = new StringBuilder();
        if (txtMaKhuyenMai.getText().trim().equals("")) {
            baoloi.append("Mã khuyến mãi phải được nhập.\n");
        } else if (!txtMaKhuyenMai.getText().trim().matches("KM\\d{3}")) {
            baoloi.append("Mã Khuyến mãi phải đúng định dạng. VD: KM123.\n");
        }
        if (txtTenKM.getText().trim().equals("")) {
            baoloi.append("Tên khuyến mãi phải được nhập.\n");
        }
        if (DatechooseTu.getDate().before(java.sql.Date.valueOf(LocalDate.now()))) {
            baoloi.append("Ngày bắt đâu khuyến mãi không được trước ngày hôm nay.\n");
        }
        if (DateChooseDen.getDate().before(java.sql.Date.valueOf(LocalDate.now()))) {
            baoloi.append("Ngày kết thúc khuyến mãi không được trước ngày hôm nay.\n");
        } else if (DateChooseDen.getDate().before(DatechooseTu.getDate())) {
            baoloi.append("Ngày kết thúc khuyến mãi phải sau ngày bắt đầu.\n");
        }
        if (baoloi.length() > 0) {
            JOptionPane.showMessageDialog(rootPane, baoloi);
            return false;
        }
        return true;
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        btnLuu.setEnabled(true);
        colorButton(btnLuu);
        btnLamMOi.setEnabled(true);
        colorButton(btnLamMOi);

        cbLoaiUuDai.setEnabled(true);
        setComboBox(cbLoaiUuDai);
        cbSanpham.setEnabled(true);
        setComboBox(cbSanpham);

        txtTenKM.setEnabled(true);
        colorTXT(txtTenKM);
        txtMaKhuyenMai.setEnabled(true);
        colorTXT(txtMaKhuyenMai);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        if (kiemtra()) {
            km = new KhuyenMai();
            km.setMaKM(txtMaKhuyenMai.getText());
            km.setTenKM(txtTenKM.getText());
            if (cbLoaiUuDai.getSelectedIndex() == 0) {
                km.setLoaiSanPham((String) cbSanpham.getSelectedItem());
                km.setPhantramgiam(0);
                km.setHoaDon(0);
            } else if (cbLoaiUuDai.getSelectedIndex() == 1) {
                km.setLoaiSanPham((String) cbSanpham.getSelectedItem());
                km.setPhantramgiam((int) spinnerPhanTramGiamGia.getValue());
                km.setHoaDon(0);
            } else {
                km.setLoaiSanPham((String) cbSanpham.getSelectedItem());
                km.setPhantramgiam((int) spinnerPhanTramGiamGia.getValue());
                km.setHoaDon((float) spinnerGiamGiaHDTu.getValue());
            }
            km.setUuDai((String) cbLoaiUuDai.getSelectedItem());

            km.setTuNgay(DatechooseTu.getDate());
            km.setDenNgay(DateChooseDen.getDate());
            if (daoKM.Them(km)) {
                JOptionPane.showMessageDialog(rootPane, "Thêm khuyến mãi thành công.");
                reset();
                HienTHiBang();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Thêm khuyến mãi không thành công.");
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void cbLoaiUuDaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLoaiUuDaiItemStateChanged
        if (cbLoaiUuDai.getSelectedIndex() == 0) {
            panelGiamGiatheoHD.setVisible(false);
            // panelGiamGiatheoHD.setVisible(false);
            panelSPApDung.setVisible(true);
        }
        if (cbLoaiUuDai.getSelectedIndex() == 1) {
            panelSPApDung.setVisible(false);
            panelGiamGia.setVisible(true);
            panelGiamGiatheoHD.setVisible(true);
            //spinnerPhanTramGiamGia.setEnabled(true);
            spinnerGiamGiaHDTu.setVisible(false);
            labelHDTren.setVisible(false);
        } else if (cbLoaiUuDai.getSelectedIndex() == 2) {
            panelGiamGiatheoHD.setVisible(true);
            panelSPApDung.setVisible(false);
            panelGiamGia.setVisible(true);
            spinnerGiamGiaHDTu.setVisible(true);
            spinnerGiamGiaHDTu.setEnabled(true);
            labelHDTren.setVisible(true);
        }
    }//GEN-LAST:event_cbLoaiUuDaiItemStateChanged

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn cập nhật khuyến mãi đã chọn?");
        if (check != 1) {
            if (kiemtra()) {
                km = new KhuyenMai();
                km.setMaKM(txtMaKhuyenMai.getText());
                km.setTenKM(txtTenKM.getText());
                km.setUuDai((String) cbLoaiUuDai.getSelectedItem());
                km.setLoaiSanPham((String) cbSanpham.getSelectedItem());
                if (spinnerPhanTramGiamGia.isEnabled() == false) {
                    km.setPhantramgiam(0);
                } else {
                    km.setPhantramgiam((int) spinnerPhanTramGiamGia.getValue());
                }
                if (spinnerGiamGiaHDTu.isEnabled() == false) {
                    km.setHoaDon(0);
                } else {
                    km.setHoaDon((float) spinnerGiamGiaHDTu.getValue());
                }
                km.setTuNgay(DatechooseTu.getDate());
                km.setDenNgay(DateChooseDen.getDate());
                if (daoKM.Capnhat(km)) {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật khuyến mãi thành công.");
                    reset();
                    HienTHiBang();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Cập khuyến mãi không thành công.");
                }
            }
        }

    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        int dem = 0;
        if (cbTimKiemTheo.getSelectedIndex() == 0) {
            btnLuu.setEnabled(false);
            nullColorButton(btnLuu);
            btnLamMOi.setEnabled(true);
            colorButton(btnLamMOi);
            cbLoaiUuDai.setEnabled(true);
            setComboBox(cbLoaiUuDai);
            cbSanpham.setEnabled(true);
            setComboBox(cbSanpham);
            txtTenKM.setEnabled(true);
            colorTXT(txtTenKM);
            btnCapNhat.setEnabled(true);
            colorButton(btnCapNhat);
            btnXoa.setEnabled(true);
            colorButton(btnXoa);
            btnThem.setEnabled(false);
            nullColorButton(btnThem);

            //Hiển thi dữ liệu tương ứng mã khuyến mãi trên form
            if (daoKM.timkiem(txtTimKiemTheoMa.getText()) != null) {
                km = daoKM.timkiem(txtTimKiemTheoMa.getText());
                txtMaKhuyenMai.setText(km.getMaKM());
                txtTenKM.setText(km.getTenKM());
                cbLoaiUuDai.setSelectedItem(km.getUuDai());
                if (cbLoaiUuDai.getSelectedIndex() == 0) {
                    panelGiamGiatheoHD.setVisible(false);
                } else {
                    panelGiamGiatheoHD.setVisible(true);
                    spinnerGiamGiaHDTu.setEnabled(true);
                    spinnerPhanTramGiamGia.setEnabled(true);
                }
                cbSanpham.setSelectedItem(km.getLoaiSanPham());
                spinnerGiamGiaHDTu.setValue(km.getHoaDon());
                spinnerPhanTramGiamGia.setValue(km.getPhantramgiam());
                DatechooseTu.setDate(km.getTuNgay());
                DateChooseDen.setDate(km.getDenNgay());
            } else {
                JOptionPane.showMessageDialog(rootPane, "Không tìn thấy mã khuyến mãi " + txtMaKhuyenMai.getText());
            }
            // TÌM KIẾM THEO ƯU ĐÃI
        } else if (cbTimKiemTheo.getSelectedIndex() == 1) {
            dsKM = daoKM.dsKhuyenMai();
            Bang.getDataVector().removeAllElements();
            if (dsKM.size() > 0) {
                for (int i = 0; i < dsKM.size(); i++) {
                    KhuyenMai km = dsKM.get(i);
                    if (km.getUuDai().equals(cbTimKiemTheoUudai.getSelectedItem())) {
                        dem = 1;
                        Hang = new Vector();
                        Hang.add(km.getMaKM());
                        Hang.add(km.getTenKM());
                        Hang.add(km.getUuDai());
                        Hang.add(km.getLoaiSanPham());
                        Hang.add(km.getPhantramgiam());
                        Hang.add(km.getHoaDon());
                        Hang.add(km.getTuNgay());
                        Hang.add(km.getDenNgay());
                        Bang.addRow(Hang);
                    }
                }
                TableKhuyenMai.setModel(Bang);
            }
            if (dem != 1) {
                JOptionPane.showMessageDialog(rootPane, "Không tìm thấy dữ liệu bạn yêu câu");
                dem = 0;
            }
            // TÌM KIẾM THEO LOẠI SẢN PHẦM
        } else if (cbTimKiemTheo.getSelectedIndex() == 2) {
            dsKM = daoKM.dsKhuyenMai();
            Bang.getDataVector().removeAllElements();
            for (int i = 0; i < dsKM.size(); i++) {
                KhuyenMai km = dsKM.get(i);

                if (km.getLoaiSanPham().equals(cbTimKiemTheoSP.getSelectedItem())) {
                    Hang = new Vector();
                    Hang.add(km.getMaKM());
                    Hang.add(km.getTenKM());
                    Hang.add(km.getUuDai());
                    Hang.add(km.getLoaiSanPham());
                    Hang.add(km.getPhantramgiam());
                    Hang.add(km.getHoaDon());
                    Hang.add(km.getTuNgay());
                    Hang.add(km.getDenNgay());
                    Bang.addRow(Hang);
                    dem = 1;
                }
            }
            TableKhuyenMai.setModel(Bang);
            if (dem != 1) {
                dem = 0;
                JOptionPane.showMessageDialog(rootPane, "Không tìm thấy dữ liệu bạn yêu câu");
            }
            //TÌM KIẾM THEO KHOẢNG THỜI GIAN
        } else if (cbTimKiemTheo.getSelectedIndex() == 3) {
            dsKM = daoKM.dsKhuyenMai();
            Bang.getDataVector().removeAllElements();
            if (DatechooseTu.getDate().before(DateChooseDen.getDate())) {
                for (int i = 0; i < dsKM.size(); i++) {
                    KhuyenMai km = dsKM.get(i);

                    String tungay = dinhdangnam.format(DateChooseTKTu.getDate());
                    String denngay = dinhdangnam.format(DateChooseTKDen.getDate());
                    dinhdangnam.format(km.getTuNgay());
                    String tu = dinhdangnam.format(km.getTuNgay());
                    String den = dinhdangnam.format(km.getDenNgay());
                    if (tu.compareTo(tungay) <= 0 && den.compareTo(denngay) >= 0) {
                        Hang = new Vector();
                        dem = 1;
                        Hang.add(km.getMaKM());
                        Hang.add(km.getTenKM());
                        Hang.add(km.getUuDai());
                        Hang.add(km.getLoaiSanPham());
                        Hang.add(km.getPhantramgiam());
                        Hang.add(km.getHoaDon());
                        Hang.add(km.getTuNgay());
                        Hang.add(km.getDenNgay());
                        Bang.addRow(Hang);
                    }
                }
                TableKhuyenMai.setModel(Bang);
                if (dem != 1) {
                    dem = 0;
                    JOptionPane.showMessageDialog(rootPane, "Không tìm thấy dữ liệu bạn yêu câu");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Ngày kết thúc khuyến mãi phải sau ngày bắt đầu.");
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn xóa khuyến mãi đã chọn?");
        if (check != 1) {
            if (daoKM.Xoa(txtMaKhuyenMai.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Xóa khuyến mãi thành công.");
                reset();
                HienTHiBang();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Xóa không thành công.");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLamMOiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMOiActionPerformed
        reset();
    }//GEN-LAST:event_btnLamMOiActionPerformed

    private void cbTimKiemTheoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbTimKiemTheoItemStateChanged
        if (cbTimKiemTheo.getSelectedIndex() == 0) {
            panelTimKiemTheoMa.setVisible(true);
            panelTimKiemTheoNgay.setVisible(false);
            panelTimKiemTheoSP.setVisible(false);
            panelTimKiemTheoUudai.setVisible(false);
        } else if (cbTimKiemTheo.getSelectedIndex() == 1) {
            panelTimKiemTheoMa.setVisible(false);
            panelTimKiemTheoNgay.setVisible(false);
            panelTimKiemTheoSP.setVisible(false);
            panelTimKiemTheoUudai.setVisible(true);
        } else if (cbTimKiemTheo.getSelectedIndex() == 2) {
            panelTimKiemTheoMa.setVisible(false);
            panelTimKiemTheoNgay.setVisible(false);
            panelTimKiemTheoSP.setVisible(true);
            panelTimKiemTheoSP.setLocation(300, 150);
            panelTimKiemTheoUudai.setVisible(false);
        } else if (cbTimKiemTheo.getSelectedIndex() == 3) {
            panelTimKiemTheoMa.setVisible(false);
            panelTimKiemTheoNgay.setVisible(true);
            panelTimKiemTheoSP.setVisible(false);
            panelTimKiemTheoUudai.setVisible(false);
        }
    }//GEN-LAST:event_cbTimKiemTheoItemStateChanged

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnTroVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroVeActionPerformed
        new FormQuanLy().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTroVeActionPerformed

    private void txtTimKiemTheoMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemTheoMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemTheoMaActionPerformed

    private void cbSanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSanphamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSanphamActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new FormQuanLy().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

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
//            java.util.logging.Logger.getLogger(FormKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormKhuyenMai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormKhuyenMai().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooseDen;
    private com.toedter.calendar.JDateChooser DateChooseTKDen;
    private com.toedter.calendar.JDateChooser DateChooseTKTu;
    private com.toedter.calendar.JDateChooser DatechooseTu;
    private javax.swing.JTable TableKhuyenMai;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMOi;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTroVe;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbLoaiUuDai;
    private javax.swing.JComboBox<String> cbSanpham;
    private javax.swing.JComboBox<String> cbTimKiemTheo;
    private javax.swing.JComboBox<String> cbTimKiemTheoSP;
    private javax.swing.JComboBox<String> cbTimKiemTheoUudai;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelUuDai;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelHDTren;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lblbackgroundfind;
    private javax.swing.JLabel lbldiscount;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JPanel panelGiamGia;
    private javax.swing.JPanel panelGiamGiatheoHD;
    private javax.swing.JPanel panelSPApDung;
    private javax.swing.JPanel panelTimKiemTheoMa;
    private javax.swing.JPanel panelTimKiemTheoNgay;
    private javax.swing.JPanel panelTimKiemTheoSP;
    private javax.swing.JPanel panelTimKiemTheoUudai;
    private javax.swing.JSpinner spinnerGiamGiaHDTu;
    private javax.swing.JSpinner spinnerPhanTramGiamGia;
    private javax.swing.JTextField txtMaKhuyenMai;
    private javax.swing.JTextField txtTenKM;
    private javax.swing.JTextField txtTimKiemTheoMa;
    // End of variables declaration//GEN-END:variables

}
