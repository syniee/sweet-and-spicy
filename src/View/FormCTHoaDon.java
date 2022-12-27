package View;

import DAO.CTHoaDonDAO;
import DAO.HoaDonDAO;
import DAO.KhachHangDAO;
import DAO.KhuyenMaiDAO;
import DAO.LoaiDAO;
import DAO.SanPhamDAO;
import DT.CTHoaDon;
import DT.HoaDon;
import DT.KhachHang;
import DT.KhuyenMai;
import DT.Loai;
import DT.NhanVien;
import DT.SanPham;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import DAO.NhanVienDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.time.LocalDate;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

public class FormCTHoaDon extends javax.swing.JFrame {

    KhachHang kh;
    KhachHangDAO khDAO = new KhachHangDAO();
    SanPham sp;
    SanPhamDAO spDAO = new SanPhamDAO();
    Loai loai;
    LoaiDAO loaiDao = new LoaiDAO();
    KhuyenMai km;
    KhuyenMaiDAO kmDAO = new KhuyenMaiDAO();
    HoaDon hd;
    HoaDonDAO hdDao = new HoaDonDAO();
    CTHoaDon cthd;
    CTHoaDonDAO cthddao = new CTHoaDonDAO();
    DefaultTableModel Bang;
    NhanVien nv;
    NhanVienDAO nvdao = new NhanVienDAO();
    Vector Hang;
    String manv;
    String maCTKhuyenMai = null;
    SimpleDateFormat dinhdangnam = new SimpleDateFormat("yyyy-MM-dd");

    public FormCTHoaDon(String NV, String sdt) {
        manv = NV;
        initComponents();
        Bang = new DefaultTableModel();
        txtHienTenDangNhap.setText(manv);
        Bang.addColumn("STT");
        Bang.addColumn("Mã sản phẩm");
        Bang.addColumn("Tên sản phẩm");
        Bang.addColumn("Size");
        Bang.addColumn("Giá");
        Bang.addColumn("Số lượng");
        Bang.addColumn("Thành tiền");
        TableDanhSachSP.setModel(Bang);
        panelKhuyenMai.setVisible(false);
        loadCBLoai();
        loadCbSP();

        txtMaHD.setText(String.valueOf(hdDao.MaxMa() + 1));
        btnThemKH.setVisible(false);
        panelTienGiamGia.setVisible(false);
        if (!(manv.equals("QL-0001"))) {
            btnTroVe.setText("Đăng xuất");
        } else {
            btnTroVe.setText("Trở về");
        }
        reset();
        txtSDTKhach.setText(sdt);
        loadKhuyenMai();
        setIconImage();
        headerTable();
        scaleImage();
    }

    public void scaleImage() {
        //logo
        ImageIcon logo_icon = new ImageIcon(getClass().getResource("/Image/sweetandspicy_logo.png"));
        Image logo_img = logo_icon.getImage();
        Image logoImgScale = logo_img.getScaledInstance(lbllogo.getWidth(), lbllogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon logoScaledIcon = new ImageIcon(logoImgScale);
        lbllogo.setIcon(logoScaledIcon);

        //title
        ImageIcon title_icon = new ImageIcon(getClass().getResource("/Image/chitiethoadon_title.png"));
        Image title_img = title_icon.getImage();
        Image titleImgScale = title_img.getScaledInstance(lbltitle.getWidth(), lbltitle.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon titleScaledIcon = new ImageIcon(titleImgScale);
        lbltitle.setIcon(titleScaledIcon);

        //left background
        ImageIcon backgroundleft_icon = new ImageIcon(getClass().getResource("/Image/chitiethoadonleft_background.png"));
        Image backgroundleft_img = backgroundleft_icon.getImage();
        Image backgroundLeftImgScale = backgroundleft_img.getScaledInstance(lblbackgroundleft.getWidth(), lblbackgroundleft.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon backgroundLeftScaledIcon = new ImageIcon(backgroundLeftImgScale);
        lblbackgroundleft.setIcon(backgroundLeftScaledIcon);

        //right background
        ImageIcon backgroundright_icon = new ImageIcon(getClass().getResource("/Image/chitiethoadonleft_background.png"));
        Image backgroundright_img = backgroundright_icon.getImage();
        Image backgroundRightImgScale = backgroundright_img.getScaledInstance(lblbackgroundright.getWidth(), lblbackgroundright.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon backgroundRightScaledIcon = new ImageIcon(backgroundRightImgScale);
        lblbackgroundright.setIcon(backgroundRightScaledIcon);

    }

    //title
    private void setIconImage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/whitess_logo.png")));
    }

    public void headerTable() {
        JTableHeader headertb = TableDanhSachSP.getTableHeader();
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

    FormCTHoaDon(String MaNV) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtHienTenDangNhap = new javax.swing.JTextField();
        panelHD = new javax.swing.JPanel();
        jPanelLeft = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbKhachHang = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbLoaiSP = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbSize = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        SpinnerSoLuong = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cbSP = new javax.swing.JComboBox<>();
        panelKhuyenMai = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtKM = new javax.swing.JTextField();
        txtSPAD = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        btnThanhToan = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        panelNhapSDT = new javax.swing.JPanel();
        lablenhapSDT = new javax.swing.JLabel();
        txtSDTKhach = new javax.swing.JTextField();
        btnTimKiemKH = new javax.swing.JButton();
        btnThemKH = new javax.swing.JButton();
        lblbackgroundleft = new javax.swing.JLabel();
        jPanelRight = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDanhSachSP = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtNgayLap = new javax.swing.JTextField();
        txtMaHDHD = new javax.swing.JTextField();
        txtMaKHHD = new javax.swing.JTextField();
        txtMaNVHD = new javax.swing.JTextField();
        txtMaKMHD = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        btnTaoHD = new javax.swing.JButton();
        txtGhiChu = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lableThanhTien = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        panelTienGiamGia = new javax.swing.JPanel();
        txtSoTienGiam = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtSoTienCanThanhToanSauGiam = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        txtTienNhanTuKhach = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        btnTroVe = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        lbllogo = new javax.swing.JLabel();
        lblbackgroundright = new javax.swing.JLabel();
        lbltitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chi tiết hóa đơn Sweet&Spicy");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtHienTenDangNhap.setBackground(new java.awt.Color(110, 74, 38));
        txtHienTenDangNhap.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        txtHienTenDangNhap.setForeground(new java.awt.Color(255, 255, 255));
        txtHienTenDangNhap.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtHienTenDangNhap.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        panelHD.setBackground(new java.awt.Color(190, 162, 131));
        panelHD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        panelHD.setLayout(null);

        jPanelLeft.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelLeft.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(163, 108, 52));
        jLabel2.setText("Khách hàng");
        jLabel2.setMinimumSize(new java.awt.Dimension(30, 30));
        jPanelLeft.add(jLabel2);
        jLabel2.setBounds(57, 10, 113, 29);

        cbKhachHang.setBackground(new java.awt.Color(196, 119, 44));
        cbKhachHang.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbKhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm kiếm", "Thêm mới" }));
        cbKhachHang.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbKhachHang.setMinimumSize(new java.awt.Dimension(30, 30));
        cbKhachHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbKhachHangItemStateChanged(evt);
            }
        });
        cbKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKhachHangActionPerformed(evt);
            }
        });
        jPanelLeft.add(cbKhachHang);
        cbKhachHang.setBounds(250, 10, 213, 30);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(163, 108, 52));
        jLabel3.setText("Mã khách hàng");
        jPanelLeft.add(jLabel3);
        jLabel3.setBounds(57, 130, 129, 28);

        txtMaKH.setBackground(new java.awt.Color(239, 222, 206));
        txtMaKH.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaKH.setForeground(new java.awt.Color(110, 68, 26));
        txtMaKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        txtMaKH.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                txtMaKHComponentShown(evt);
            }
        });
        jPanelLeft.add(txtMaKH);
        txtMaKH.setBounds(310, 130, 156, 30);

        txtTenKH.setBackground(new java.awt.Color(239, 222, 206));
        txtTenKH.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtTenKH.setForeground(new java.awt.Color(110, 68, 26));
        txtTenKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        jPanelLeft.add(txtTenKH);
        txtTenKH.setBounds(310, 170, 156, 30);

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(163, 108, 52));
        jLabel11.setText("Tên khách hàng");
        jPanelLeft.add(jLabel11);
        jLabel11.setBounds(57, 170, 148, 27);

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel4.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(95, 59, 24));
        jLabel4.setText("THÊM SẢN PHẨM VÀO HÓA ĐƠN");
        jPanel4.add(jLabel4);
        jLabel4.setBounds(110, 20, 290, 30);

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(163, 108, 52));
        jLabel5.setText("Loại sản phẩm");
        jPanel4.add(jLabel5);
        jLabel5.setBounds(15, 120, 140, 30);

        cbLoaiSP.setBackground(new java.awt.Color(196, 119, 44));
        cbLoaiSP.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbLoaiSP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbLoaiSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbLoaiSPItemStateChanged(evt);
            }
        });
        cbLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLoaiSPActionPerformed(evt);
            }
        });
        jPanel4.add(cbLoaiSP);
        cbLoaiSP.setBounds(187, 117, 140, 30);

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(163, 108, 52));
        jLabel6.setText("Tên sản phẩm");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(15, 170, 120, 30);

        cbSize.setBackground(new java.awt.Color(196, 119, 44));
        cbSize.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L" }));
        cbSize.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbSize.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSizeItemStateChanged(evt);
            }
        });
        jPanel4.add(cbSize);
        cbSize.setBounds(410, 117, 80, 30);

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(163, 108, 52));
        jLabel7.setText("Số lượng");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(15, 215, 127, 30);

        SpinnerSoLuong.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        SpinnerSoLuong.setModel(new javax.swing.SpinnerNumberModel(1, 1, 50, 1));
        SpinnerSoLuong.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.add(SpinnerSoLuong);
        SpinnerSoLuong.setBounds(187, 210, 68, 33);

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(163, 108, 52));
        jLabel8.setText("Size");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(360, 120, 40, 30);

        txtMaHD.setBackground(new java.awt.Color(239, 222, 206));
        txtMaHD.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaHD.setForeground(new java.awt.Color(110, 68, 26));
        txtMaHD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        jPanel4.add(txtMaHD);
        txtMaHD.setBounds(187, 70, 140, 30);

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(163, 108, 52));
        jLabel10.setText("Mã hóa đơn");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(15, 70, 127, 30);

        cbSP.setBackground(new java.awt.Color(196, 119, 44));
        cbSP.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbSP.setForeground(new java.awt.Color(110, 68, 26));
        cbSP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbSPActionPerformed(evt);
            }
        });
        jPanel4.add(cbSP);
        cbSP.setBounds(187, 165, 217, 30);

        panelKhuyenMai.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(163, 108, 52));
        jLabel9.setText("Khuyến mãi");

        txtKM.setBackground(new java.awt.Color(239, 222, 206));
        txtKM.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtKM.setForeground(new java.awt.Color(110, 68, 26));
        txtKM.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));

        txtSPAD.setBackground(new java.awt.Color(239, 222, 206));
        txtSPAD.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtSPAD.setForeground(new java.awt.Color(110, 68, 26));
        txtSPAD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(163, 108, 52));
        jLabel13.setText("Sản phẩm");

        javax.swing.GroupLayout panelKhuyenMaiLayout = new javax.swing.GroupLayout(panelKhuyenMai);
        panelKhuyenMai.setLayout(panelKhuyenMaiLayout);
        panelKhuyenMaiLayout.setHorizontalGroup(
            panelKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKhuyenMaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(panelKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKM, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSPAD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );
        panelKhuyenMaiLayout.setVerticalGroup(
            panelKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKhuyenMaiLayout.createSequentialGroup()
                .addGroup(panelKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtKM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelKhuyenMaiLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(panelKhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSPAD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.add(panelKhuyenMai);
        panelKhuyenMai.setBounds(7, 250, 380, 80);

        btnThanhToan.setBackground(new java.awt.Color(204, 157, 110));
        btnThanhToan.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(95, 59, 24));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        jPanel4.add(btnThanhToan);
        btnThanhToan.setBounds(180, 430, 150, 29);

        btnThem.setBackground(new java.awt.Color(204, 157, 110));
        btnThem.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add_icon.png"))); // NOI18N
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
        jPanel4.add(btnThem);
        btnThem.setBounds(20, 340, 107, 78);

        btnCapNhat.setBackground(new java.awt.Color(204, 157, 110));
        btnCapNhat.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/update_icon.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnCapNhat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCapNhat.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnCapNhat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });
        jPanel4.add(btnCapNhat);
        btnCapNhat.setBounds(140, 340, 107, 78);

        btnXoa.setBackground(new java.awt.Color(204, 157, 110));
        btnXoa.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete_icon.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXoa.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel4.add(btnXoa);
        btnXoa.setBounds(260, 340, 107, 78);

        btnTimKiem.setBackground(new java.awt.Color(204, 157, 110));
        btnTimKiem.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
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
        jPanel4.add(btnTimKiem);
        btnTimKiem.setBounds(410, 163, 90, 35);

        btnLamMoi.setBackground(new java.awt.Color(204, 157, 110));
        btnLamMoi.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(95, 59, 24));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/update1_icon.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnLamMoi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLamMoi.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnLamMoi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanel4.add(btnLamMoi);
        btnLamMoi.setBounds(380, 340, 107, 78);

        jPanelLeft.add(jPanel4);
        jPanel4.setBounds(10, 210, 510, 470);

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        panelNhapSDT.setBackground(new java.awt.Color(204, 204, 204));

        lablenhapSDT.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        lablenhapSDT.setForeground(new java.awt.Color(163, 108, 52));
        lablenhapSDT.setText("Nhập số điện thoại");
        lablenhapSDT.setMinimumSize(new java.awt.Dimension(30, 30));

        txtSDTKhach.setBackground(new java.awt.Color(239, 222, 206));
        txtSDTKhach.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtSDTKhach.setForeground(new java.awt.Color(110, 68, 26));
        txtSDTKhach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        txtSDTKhach.setMinimumSize(new java.awt.Dimension(30, 30));
        txtSDTKhach.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtSDTKhachInputMethodTextChanged(evt);
            }
        });

        btnTimKiemKH.setBackground(new java.awt.Color(204, 157, 110));
        btnTimKiemKH.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnTimKiemKH.setForeground(new java.awt.Color(95, 59, 24));
        btnTimKiemKH.setText("Tìm");
        btnTimKiemKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnTimKiemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelNhapSDTLayout = new javax.swing.GroupLayout(panelNhapSDT);
        panelNhapSDT.setLayout(panelNhapSDTLayout);
        panelNhapSDTLayout.setHorizontalGroup(
            panelNhapSDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNhapSDTLayout.createSequentialGroup()
                .addComponent(lablenhapSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtSDTKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiemKH)
                .addContainerGap())
        );
        panelNhapSDTLayout.setVerticalGroup(
            panelNhapSDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNhapSDTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelNhapSDTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lablenhapSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDTKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThemKH.setBackground(new java.awt.Color(204, 157, 110));
        btnThemKH.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnThemKH.setForeground(new java.awt.Color(95, 59, 24));
        btnThemKH.setText("Thêm khách hàng");
        btnThemKH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnThemKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelNhapSDT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(31, 31, 31))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelNhapSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelLeft.add(jPanel8);
        jPanel8.setBounds(50, 50, 423, 60);

        lblbackgroundleft.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/chitiethoadonleft_background.png"))); // NOI18N
        lblbackgroundleft.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelLeft.add(lblbackgroundleft);
        lblbackgroundleft.setBounds(0, 0, 530, 690);

        panelHD.add(jPanelLeft);
        jPanelLeft.setBounds(10, 10, 530, 690);

        jPanelRight.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelRight.setLayout(null);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        TableDanhSachSP.setBackground(new java.awt.Color(204, 204, 204));
        TableDanhSachSP.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TableDanhSachSP.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        TableDanhSachSP.setForeground(new java.awt.Color(144, 89, 35));
        TableDanhSachSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TableDanhSachSP.setRowHeight(30);
        TableDanhSachSP.setSelectionBackground(new java.awt.Color(95, 59, 24));
        TableDanhSachSP.setSelectionForeground(new java.awt.Color(232, 216, 200));
        jScrollPane1.setViewportView(TableDanhSachSP);

        jPanelRight.add(jScrollPane1);
        jScrollPane1.setBounds(10, 210, 850, 190);

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(163, 108, 52));
        jLabel15.setText("Mã hóa đơn");
        jPanelRight.add(jLabel15);
        jLabel15.setBounds(40, 60, 110, 30);

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(95, 59, 24));
        jLabel12.setText("DANH SÁCH CÁC SẢN PHẨM ĐÃ CHỌN");
        jPanelRight.add(jLabel12);
        jLabel12.setBounds(290, 170, 360, 40);

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(163, 108, 52));
        jLabel16.setText("Mã khách hàng");
        jPanelRight.add(jLabel16);
        jLabel16.setBounds(40, 110, 129, 30);

        jLabel17.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(163, 108, 52));
        jLabel17.setText("Mã nhân viên");
        jPanelRight.add(jLabel17);
        jLabel17.setBounds(320, 60, 130, 30);

        jLabel18.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(163, 108, 52));
        jLabel18.setText("Mã khuyến mãi");
        jPanelRight.add(jLabel18);
        jLabel18.setBounds(320, 110, 130, 30);

        jLabel19.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(163, 108, 52));
        jLabel19.setText("Ngày lập ");
        jPanelRight.add(jLabel19);
        jLabel19.setBounds(610, 110, 100, 30);

        txtNgayLap.setBackground(new java.awt.Color(239, 222, 206));
        txtNgayLap.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtNgayLap.setForeground(new java.awt.Color(110, 68, 26));
        txtNgayLap.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNgayLap.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        jPanelRight.add(txtNgayLap);
        txtNgayLap.setBounds(720, 110, 97, 30);

        txtMaHDHD.setBackground(new java.awt.Color(239, 222, 206));
        txtMaHDHD.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaHDHD.setForeground(new java.awt.Color(110, 68, 26));
        txtMaHDHD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        jPanelRight.add(txtMaHDHD);
        txtMaHDHD.setBounds(190, 60, 97, 30);

        txtMaKHHD.setBackground(new java.awt.Color(239, 222, 206));
        txtMaKHHD.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaKHHD.setForeground(new java.awt.Color(110, 68, 26));
        txtMaKHHD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        jPanelRight.add(txtMaKHHD);
        txtMaKHHD.setBounds(190, 110, 97, 30);

        txtMaNVHD.setBackground(new java.awt.Color(239, 222, 206));
        txtMaNVHD.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaNVHD.setForeground(new java.awt.Color(110, 68, 26));
        txtMaNVHD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        jPanelRight.add(txtMaNVHD);
        txtMaNVHD.setBounds(470, 60, 97, 30);

        txtMaKMHD.setBackground(new java.awt.Color(239, 222, 206));
        txtMaKMHD.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaKMHD.setForeground(new java.awt.Color(110, 68, 26));
        txtMaKMHD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        jPanelRight.add(txtMaKMHD);
        txtMaKMHD.setBounds(470, 110, 97, 30);

        jLabel23.setFont(new java.awt.Font("Bahnschrift", 1, 22)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(95, 59, 24));
        jLabel23.setText("SWEET & SPICY");
        jPanelRight.add(jLabel23);
        jLabel23.setBounds(380, 10, 180, 28);

        btnTaoHD.setBackground(new java.awt.Color(204, 157, 110));
        btnTaoHD.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnTaoHD.setForeground(new java.awt.Color(95, 59, 24));
        btnTaoHD.setText("Tạo Hóa Đơn");
        btnTaoHD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnTaoHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHDActionPerformed(evt);
            }
        });
        jPanelRight.add(btnTaoHD);
        btnTaoHD.setBounds(580, 570, 150, 29);

        txtGhiChu.setBackground(new java.awt.Color(239, 222, 206));
        txtGhiChu.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtGhiChu.setForeground(new java.awt.Color(110, 68, 26));
        txtGhiChu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanelRight.add(txtGhiChu);
        txtGhiChu.setBounds(450, 460, 410, 90);

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(163, 108, 52));
        jLabel14.setText("Ghi chú");
        jPanelRight.add(jLabel14);
        jLabel14.setBounds(620, 430, 70, 23);

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel5.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        lableThanhTien.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        lableThanhTien.setForeground(new java.awt.Color(163, 108, 52));
        lableThanhTien.setText("Thành tiền");

        txtThanhTien.setBackground(new java.awt.Color(239, 222, 206));
        txtThanhTien.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtThanhTien.setForeground(new java.awt.Color(110, 68, 26));
        txtThanhTien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lableThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lableThanhTien)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5.add(jPanel6);
        jPanel6.setBounds(8, 18, 400, 46);

        panelTienGiamGia.setBackground(new java.awt.Color(204, 204, 204));
        panelTienGiamGia.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txtSoTienGiam.setBackground(new java.awt.Color(239, 222, 206));
        txtSoTienGiam.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtSoTienGiam.setForeground(new java.awt.Color(110, 68, 26));
        txtSoTienGiam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));

        jLabel25.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(163, 108, 52));
        jLabel25.setText("Tiền phải thanh toán");

        jLabel24.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(163, 108, 52));
        jLabel24.setText("Giảm ");

        txtSoTienCanThanhToanSauGiam.setBackground(new java.awt.Color(239, 222, 206));
        txtSoTienCanThanhToanSauGiam.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtSoTienCanThanhToanSauGiam.setForeground(new java.awt.Color(110, 68, 26));
        txtSoTienCanThanhToanSauGiam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));

        javax.swing.GroupLayout panelTienGiamGiaLayout = new javax.swing.GroupLayout(panelTienGiamGia);
        panelTienGiamGia.setLayout(panelTienGiamGiaLayout);
        panelTienGiamGiaLayout.setHorizontalGroup(
            panelTienGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTienGiamGiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTienGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(panelTienGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSoTienGiam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoTienCanThanhToanSauGiam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        panelTienGiamGiaLayout.setVerticalGroup(
            panelTienGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTienGiamGiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTienGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSoTienGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTienGiamGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtSoTienCanThanhToanSauGiam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(panelTienGiamGia);
        panelTienGiamGia.setBounds(8, 70, 400, 82);

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        txtTienNhanTuKhach.setBackground(new java.awt.Color(239, 222, 206));
        txtTienNhanTuKhach.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtTienNhanTuKhach.setForeground(new java.awt.Color(110, 68, 26));
        txtTienNhanTuKhach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        txtTienNhanTuKhach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTienNhanTuKhachMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtTienNhanTuKhachMouseExited(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(163, 108, 52));
        jLabel21.setText("Tiền nhận từ khách");

        txtTienThua.setBackground(new java.awt.Color(239, 222, 206));
        txtTienThua.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtTienThua.setForeground(new java.awt.Color(110, 68, 26));
        txtTienThua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));

        jLabel22.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(163, 108, 52));
        jLabel22.setText("Tiền thừa");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTienNhanTuKhach, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTienNhanTuKhach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel7);
        jPanel7.setBounds(8, 158, 400, 82);

        jPanelRight.add(jPanel5);
        jPanel5.setBounds(10, 410, 420, 270);

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
        jPanelRight.add(btnTroVe);
        btnTroVe.setBounds(490, 650, 107, 30);

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
        jPanelRight.add(btnThoat);
        btnThoat.setBounds(720, 650, 107, 30);

        lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sweetandspicy_logo.png"))); // NOI18N
        jPanelRight.add(lbllogo);
        lbllogo.setBounds(750, 5, 80, 100);

        lblbackgroundright.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/chitiethoadonright_background.png"))); // NOI18N
        lblbackgroundright.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelRight.add(lblbackgroundright);
        lblbackgroundright.setBounds(0, 0, 870, 690);

        panelHD.add(jPanelRight);
        jPanelRight.setBounds(560, 10, 870, 690);

        lbltitle.setFont(new java.awt.Font("Dialog", 0, 40)); // NOI18N
        lbltitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/chitiethoadon_title.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtHienTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(396, 396, 396)
                        .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelHD, javax.swing.GroupLayout.PREFERRED_SIZE, 1438, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtHienTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(panelHD, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void loadCBLoai() {
        ArrayList<Loai> dsloai = loaiDao.DSLoaiSP();
        cbLoaiSP.removeAllItems();
        for (int i = 0; i < dsloai.size(); i++) {
            loai = dsloai.get(i);
            cbLoaiSP.addItem(loai.getTenLoai());
        }
    }

    public void loadCbSP() {
        ArrayList<SanPham> dssp = spDAO.DanhSachSP();
        ArrayList<Loai> dsloai = loaiDao.DSLoaiSP();
        cbSP.removeAllItems();
        String thuocloai = "";
        for (int i = 0; i < dsloai.size(); i++) {
            loai = dsloai.get(i);
            if (cbLoaiSP.getSelectedItem().equals(loai.getTenLoai())) {
                thuocloai = loai.getMaLoai();
            }

        }
        for (int i = 0; i < dssp.size(); i++) {
            SanPham sp = dssp.get(i);
            if (thuocloai.equals(sp.getMaLoai()) && cbSize.getSelectedItem().equals(sp.getSize().trim())) {
                cbSP.addItem(sp.getTenSP());
            }
        }

    }

    public void loadKhuyenMai() {

        ArrayList<KhuyenMai> dskm = kmDAO.dsKhuyenMai();

        for (int i = 0; i < dskm.size(); i++) {
            km = dskm.get(i);
            Date ngayhientai;
            if (((km.getTuNgay().before(java.sql.Date.valueOf(LocalDate.now()))) || (km.getTuNgay().equals(java.sql.Date.valueOf(LocalDate.now()))))
                    && ((km.getDenNgay().after(java.sql.Date.valueOf(LocalDate.now()))) || (km.getDenNgay().equals(java.sql.Date.valueOf(LocalDate.now()))))) {
                if (km.getUuDai().trim().equals("Mua 2 tặng 1")) {
                    panelKhuyenMai.setVisible(true);
                    txtKM.setText(km.getUuDai());
                    txtSPAD.setText(km.getLoaiSanPham());
                    maCTKhuyenMai = km.getMaKM();
                }

            }
        }
    }

    // RESET FORM
    public void reset() {
        btnCapNhat.setEnabled(false);
        nullColorButton(btnCapNhat);
        btnThem.setEnabled(true);
        colorButton(btnThem);
        btnThanhToan.setEnabled(true);
        colorButton(btnThanhToan);
        btnLamMoi.setEnabled(true);
        colorButton(btnLamMoi);
        btnTimKiem.setEnabled(false);
        nullColorButton(btnTimKiem);
        btnXoa.setEnabled(false);
        nullColorButton(btnXoa);
        
        Bang.getDataVector().removeAllElements();
        TableDanhSachSP.setModel(Bang);
        txtMaHD.setText(String.valueOf(hdDao.MaxMa() + 1));
        txtMaKH.setText("");
        txtSDTKhach.setText("");
        txtGhiChu.setText("");
        //txtKM.setText("");
        txtMaHDHD.setText("");
        txtMaKHHD.setText("");
        txtMaKMHD.setText("");
        txtMaNVHD.setText("");
        txtNgayLap.setText("");
        txtSoTienCanThanhToanSauGiam.setText("");
        txtSoTienGiam.setText("");
        txtThanhTien.setText("");
        txtTienNhanTuKhach.setText("");
        txtTienThua.setText("");
        txtTenKH.setText("");

    }
// Lấy mã sản phẩm dựa trên tên sp và size

    public String LayMaSP(String tensp, String size) {
        ArrayList<SanPham> dssp = spDAO.DanhSachSP();
        for (int i = 0; i < dssp.size(); i++) {
            sp = dssp.get(i);
            if (sp.getTenSP().trim().equals(tensp) && sp.getSize().trim().equals(size.trim())) {
                return sp.getMaSP();
            }
        }
        return null;
    }
    private void cbLoaiSPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbLoaiSPItemStateChanged
        loadCbSP();
    }//GEN-LAST:event_cbLoaiSPItemStateChanged

    private void cbSizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSizeItemStateChanged
        loadCbSP();
    }//GEN-LAST:event_cbSizeItemStateChanged

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        cthd = new CTHoaDon();
        String ma = LayMaSP((String) cbSP.getSelectedItem(), (String) cbSize.getSelectedItem());
        cthd.setMaHD(Integer.valueOf(txtMaHD.getText()));
        cthd.setMaSP(ma);
        cthd.setSize((String) cbSize.getSelectedItem());
        cthd.setDonGia(spDAO.LayGia(ma));
        // Nếu có chương trình khuyến mãi vào thời điểm hiện tại
        if (kmDAO.timkiem(maCTKhuyenMai) != null) {
            km = kmDAO.timkiem(maCTKhuyenMai);
            // Nếu chương trình khuyến mãi áp dụng cho loại sản phẩm cụ thể
            if (km.getLoaiSanPham().trim().equals(cbLoaiSP.getSelectedItem()) && ((int) SpinnerSoLuong.getValue() >= 2)) {
                int tang = (int) SpinnerSoLuong.getValue() / 2;
                int sl = (int) SpinnerSoLuong.getValue();
                cthd.setThanhTien(sl * cthd.getDonGia());
                cthd.setSoLuong(tang + ((int) SpinnerSoLuong.getValue()));
            } // Nếu chương trình khuyến mãi áp dụng cho tất cả sản phẩm
            else if (km.getLoaiSanPham().trim().equals("Tất cả sản phẩm")&&(int) SpinnerSoLuong.getValue() >= 2) {
                int tang = (int) SpinnerSoLuong.getValue() / 2;
                int sl = (int) SpinnerSoLuong.getValue();
                cthd.setSoLuong(tang + ((int) SpinnerSoLuong.getValue()));
                cthd.setThanhTien(sl * cthd.getDonGia());
            } else {
                cthd.setSoLuong((int) SpinnerSoLuong.getValue());
                cthd.setThanhTien(cthd.getSoLuong() * cthd.getDonGia());
            }
        } else {
            cthd.setSoLuong((int) SpinnerSoLuong.getValue());
            cthd.setThanhTien(cthd.getSoLuong() * cthd.getDonGia());
        }

        if (cthddao.ThemCTHD(cthd)) {
            JOptionPane.showMessageDialog(rootPane, "Đã thêm.");
            btnThanhToan.setVisible(true);
            colorButton(btnThanhToan);
            btnTimKiem.setEnabled(true);
            colorButton(btnTimKiem);

        }
        // Cập nhật lại bảng sản phẩm trong hóa đơn.
        Bang.getDataVector().removeAllElements();
        ArrayList<CTHoaDon> ds = cthddao.dsCTHD();
        int j = 0;
        for (int i = 0; i < ds.size(); i++) {
            Hang = new Vector();
            cthd = ds.get(i);
            if (cthd.getMaHD() == (Integer.valueOf(txtMaHD.getText()))) {
                Hang.add(j);
                Hang.add(cthd.getMaSP());
                String ten = spDAO.layTenSP(cthd.getMaSP());
                Hang.add(ten);
                Hang.add(cthd.getSize());
                Hang.add(cthd.getDonGia());
                Hang.add(cthd.getSoLuong());

                Hang.add(cthd.getThanhTien());
                Bang.addRow(Hang);
                j += 1;
            }

        }
        TableDanhSachSP.setModel(Bang);
        txtMaKHHD.setText(txtMaKH.getText());
        txtMaHDHD.setText(txtMaHD.getText());
        txtMaNVHD.setText(txtHienTenDangNhap.getText());
        // Thêm mã khuyến mãi vào chi tiết hóa đơn
        if (!txtKM.getText().equals("")) {
            txtMaKMHD.setText(maCTKhuyenMai);
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String masp = LayMaSP((String) cbSP.getSelectedItem(), (String) cbSize.getSelectedItem());
        if (cthddao.TimKiem(Integer.valueOf(txtMaHD.getText()), masp) != null) {
            Bang.getDataVector().removeAllElements();
            cthd = cthddao.TimKiem(Integer.valueOf(txtMaHD.getText()), masp);
            SpinnerSoLuong.setValue(cthd.getSoLuong());
            Hang = new Vector();
            Hang.add(1);
            Hang.add(cthd.getMaSP());
            String ten = spDAO.layTenSP(cthd.getMaSP());
            Hang.add(ten);
            Hang.add(cthd.getSize());
            Hang.add(cthd.getDonGia());
            Hang.add(cthd.getSoLuong());
            Hang.add(cthd.getThanhTien());
            Bang.addRow(Hang);
            TableDanhSachSP.setModel(Bang);
            JOptionPane.showMessageDialog(rootPane, "TÌm thấy sản phẩm trong chi tiết hóa đơn.");
            btnCapNhat.setEnabled(true);
            colorButton(btnCapNhat);
            btnXoa.setEnabled(true);
            colorButton(btnXoa);
            btnThem.setEnabled(false);
            nullColorButton(btnThem);
        } else
            JOptionPane.showMessageDialog(rootPane, "Sản phẩm không có trong hóa đơn");
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn xóa sản phẩm đã chọn ra khỏi háo đơn");
        if (check != 1) {
            String masp = LayMaSP((String) cbSP.getSelectedItem(), (String) cbSize.getSelectedItem());
            if (cthddao.xoaCTHD((Integer.valueOf(txtMaHD.getText())), masp)) {
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
                Bang.getDataVector().removeAllElements();
                ArrayList<CTHoaDon> ds = cthddao.dsCTHD();
                int j = 1;
                for (int i = 0; i < ds.size(); i++) {
                    Hang = new Vector();
                    cthd = ds.get(i);
                    if (cthd.getMaHD() == (Integer.valueOf(txtMaHD.getText()))) {
                        Hang.add(j);
                        Hang.add(cthd.getMaSP());
                        String ten = spDAO.layTenSP(cthd.getMaSP());
                        Hang.add(ten);
                        Hang.add(cthd.getSize());
                        Hang.add(cthd.getDonGia());
                        Hang.add(cthd.getSoLuong());
                        Hang.add(cthd.getThanhTien());
                        Bang.addRow(Hang);
                        j += 1;
                    }

                }
                TableDanhSachSP.setModel(Bang);
                // if(j==1) TableDanhSachSP.setModel(null);
                btnXoa.setEnabled(false);
                nullColorButton(btnXoa);
                btnThem.setEnabled(true);
                colorButton(btnThem);
                btnCapNhat.setEnabled(false);
                nullColorButton(btnCapNhat);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Xóa không thành công.");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void cbKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKhachHangActionPerformed

    private void cbKhachHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbKhachHangItemStateChanged
        if (cbKhachHang.getSelectedIndex() == 0) {
            btnThemKH.setVisible(false);
            panelNhapSDT.setVisible(true);
        } else if (cbKhachHang.getSelectedIndex() == 1) {
            panelNhapSDT.setVisible(false);
            btnThemKH.setVisible(true);
        }
    }//GEN-LAST:event_cbKhachHangItemStateChanged

    private void btnThemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemKHActionPerformed
        new FormThemKhachHang(manv).setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnThemKHActionPerformed

    private void btnTimKiemKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemKHActionPerformed
        if (khDAO.TimKiemTheoSDT(txtSDTKhach.getText().trim()) != null) {
            kh = khDAO.TimKiemTheoSDT(txtSDTKhach.getText().trim());
            txtMaKH.setText(kh.getMaHK());
            txtTenKH.setText(kh.getHoten());
        } else
            JOptionPane.showMessageDialog(rootPane, "Không tìm thấy khách hàng có số điện thoại tương tự");
    }//GEN-LAST:event_btnTimKiemKHActionPerformed

    private void btnTaoHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHDActionPerformed
       if(!txtTienThua.getText().trim().equals("")){
           hd = new HoaDon();
        hd.setMaHD(Integer.valueOf(txtMaHD.getText()));
        hd.setMaKH(txtMaKH.getText());
        if (txtMaKMHD.getText().equals("")) {
            hd.setMaKM("No");
        } else {
            hd.setMaKM(txtMaKMHD.getText());
        }
        hd.setMaNV(txtMaNVHD.getText());

        hd.setNgayTao(LocalDate.now());
        if (panelTienGiamGia.isVisible() == false) {
            hd.setThanhTien(Float.valueOf(txtThanhTien.getText()));
        } else {
            hd.setThanhTien(Float.valueOf(txtSoTienCanThanhToanSauGiam.getText()));
        }
        if (txtGhiChu.getText().trim().equals("")) {
            hd.setGhiChu("NO");
        } else {
            hd.setGhiChu(txtGhiChu.getText());
        }
        if (hdDao.ThemHD(hd)) {
            reset();
            JOptionPane.showMessageDialog(rootPane, "Tạo hóa đơn thành công.");
        } else
            JOptionPane.showMessageDialog(rootPane, "Không tạo được hóa đơn.");
       }
        
    }//GEN-LAST:event_btnTaoHDActionPerformed

    private void txtMaKHComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_txtMaKHComponentShown
        txtMaKHHD.setText(txtMaKH.getText());
    }//GEN-LAST:event_txtMaKHComponentShown

    private void txtSDTKhachInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtSDTKhachInputMethodTextChanged
        txtMaKHHD.setText(txtMaKH.getText());
    }//GEN-LAST:event_txtSDTKhachInputMethodTextChanged

    // CẬP NHẬT
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        cthd = new CTHoaDon();
        String ma = LayMaSP((String) cbSP.getSelectedItem(), (String) cbSize.getSelectedItem());
        cthd.setMaHD(Integer.valueOf(txtMaHD.getText()));
        cthd.setMaSP(ma);
        cthd.setSize((String) cbSize.getSelectedItem());
        cthd.setDonGia(spDAO.LayGia(ma));
        // Nếu có chương trình khuyến mãi vào thời điểm hiện tại
        if (kmDAO.timkiem(maCTKhuyenMai) != null) {
            km = kmDAO.timkiem(maCTKhuyenMai);
            // Nếu chương trình khuyến mãi áp dụng cho loại sản phẩm cụ thể
            if (km.getLoaiSanPham().trim().equals(cbLoaiSP.getSelectedItem()) && ((int) SpinnerSoLuong.getValue() >= 2)) {
                int tang = (int) SpinnerSoLuong.getValue() / 2;
                int sl = (int) SpinnerSoLuong.getValue();
                cthd.setThanhTien(sl * cthd.getDonGia());
                cthd.setSoLuong(tang + sl);
            } // Nếu chương trình khuyến mãi áp dụng cho tất cả sản phẩm
            else if (km.getUuDai().trim().equals("Mua 2 tang 1") && (int) SpinnerSoLuong.getValue() >= 2) {
                int tang = (int) SpinnerSoLuong.getValue() / 2;
                int sl = (int) SpinnerSoLuong.getValue();
                cthd.setThanhTien(sl * cthd.getDonGia());
                cthd.setSoLuong(sl+tang);
            } else {
                cthd.setSoLuong((int) SpinnerSoLuong.getValue());
                cthd.setThanhTien(cthd.getSoLuong() * cthd.getDonGia());
            }
        } else {
            cthd.setSoLuong((int) SpinnerSoLuong.getValue());
            cthd.setThanhTien(cthd.getSoLuong() * cthd.getDonGia());
        }
        if (cthddao.CapNhatCTHD(cthd)) {
            JOptionPane.showMessageDialog(rootPane, "Đã cập nhật số lượng sản phẩm đã chọn");
            btnCapNhat.setEnabled(false);
            nullColorButton(btnCapNhat);
            btnThem.setEnabled(true);
            colorButton(btnThem);
            btnXoa.setEnabled(false);
            nullColorButton(btnXoa);
        }

        // Cập nhật lại bảng sản phẩm trong hóa đơn.
        Bang.getDataVector().removeAllElements();
        ArrayList<CTHoaDon> ds = cthddao.dsCTHD();
        int j = 0;
        for (int i = 0; i < ds.size(); i++) {
            Hang = new Vector();
            cthd = ds.get(i);
            if (cthd.getMaHD() == (Integer.valueOf(txtMaHD.getText()))) {
                Hang.add(j);
                Hang.add(cthd.getMaSP());
                String ten = spDAO.layTenSP(cthd.getMaSP());
                Hang.add(ten);
                Hang.add(cthd.getSize());
                Hang.add(cthd.getDonGia());
                Hang.add(cthd.getSoLuong());
                Hang.add(cthd.getThanhTien());
                Bang.addRow(Hang);
                j += 1;
            }
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    public void UuDaiGiam() {
        ArrayList<KhuyenMai> dskm = kmDAO.dsKhuyenMai();
        for (int i = 0; i < dskm.size(); i++) {
            km = dskm.get(i);
            Date ngayhientai;
            if (((km.getTuNgay().before(java.sql.Date.valueOf(LocalDate.now()))) || (km.getTuNgay().equals(java.sql.Date.valueOf(LocalDate.now()))))
                    && ((km.getDenNgay().after(java.sql.Date.valueOf(LocalDate.now()))) || (km.getDenNgay().equals(java.sql.Date.valueOf(LocalDate.now()))))) {
                if (km.getUuDai().trim().equals("Giảm giá cho tất cả hóa đơn")) {
                    txtMaKMHD.setText(km.getMaKM());
                    panelTienGiamGia.setVisible(true);
                    //0974632643
                    float thanhtien = Float.valueOf(txtThanhTien.getText());
                    float tiengiam = thanhtien * ((float) km.getPhantramgiam() / 100);
                    txtSoTienGiam.setText(String.valueOf(tiengiam));
                    txtSoTienCanThanhToanSauGiam.setText(String.valueOf(thanhtien - tiengiam));
                } else if (km.getUuDai().trim().equals("Giảm giá cho hóa đơn")) {
                    float thanhtien = Float.valueOf(txtThanhTien.getText());
                    if (thanhtien >= km.getHoaDon()) {
                        txtMaKMHD.setText(km.getMaKM());
                        panelTienGiamGia.setVisible(true);
                        float tiengiam = thanhtien * ((float) km.getPhantramgiam() / 100);
                        txtSoTienGiam.setText(String.valueOf(tiengiam));
                        txtSoTienCanThanhToanSauGiam.setText(String.valueOf(thanhtien - tiengiam));
                        //txtTienThua.setText(txtTienNhanTuKhach.);
                    }
                }
            }
        }
    }
    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (!txtMaKH.getText().trim().equals("")) {
            ArrayList<CTHoaDon> ds = cthddao.dsCTHD();
            int j = 0;
            float TongTien = 0;
            Bang.getDataVector().removeAllElements();
            for (int i = 0; i < ds.size(); i++) {
                cthd = ds.get(i);
                if (txtMaHD.getText().trim().equals(String.valueOf(cthd.getMaHD()))) {
                    TongTien += cthd.getThanhTien();
                    Hang = new Vector();
                    Hang.add(j + 1);
                    Hang.add(cthd.getMaSP());
                    String ten = spDAO.layTenSP(cthd.getMaSP());
                    Hang.add(ten);
                    Hang.add(cthd.getSize());
                    Hang.add(cthd.getDonGia());
                    Hang.add(cthd.getSoLuong());
                    Hang.add(cthd.getThanhTien());
                    Bang.addRow(Hang);
                    j += 1;
                }

            }

            TableDanhSachSP.setModel(Bang);
            txtThanhTien.setText(String.valueOf(TongTien));
            txtMaKHHD.setText(txtMaKH.getText());
            txtMaHDHD.setText(txtMaHD.getText());
            txtMaNVHD.setText(txtHienTenDangNhap.getText());
            // Thêm mã khuyến mãi vào chi tiết hóa đơn
            if (!txtKM.getText().equals("")) {
                txtMaKMHD.setText(maCTKhuyenMai);
            } else {
                UuDaiGiam();
            }
            txtNgayLap.setText(dinhdangnam.format(java.sql.Date.valueOf(LocalDate.now())));
            btnCapNhat.setEnabled(false);
            nullColorButton(btnCapNhat);
            btnLamMoi.setEnabled(false);
            nullColorButton(btnLamMoi);
            btnThem.setEnabled(false);
            nullColorButton(btnThem);
            btnXoa.setEnabled(false);
            nullColorButton(btnXoa);
            btnThanhToan.setEnabled(false);
            nullColorButton(btnThanhToan);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Thông tin khách hàng cần được nhập.");
        }

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void txtTienNhanTuKhachMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienNhanTuKhachMouseExited
        if (tienthua == 1) {
            if (panelTienGiamGia.isVisible() == false) {
                float tongtien = Float.valueOf(txtThanhTien.getText().trim());
                float tiennhan = Float.valueOf(txtTienNhanTuKhach.getText().trim());
                txtTienThua.setText(String.valueOf(tiennhan - tongtien));
            } else {
                float tongtien = Float.valueOf(txtSoTienCanThanhToanSauGiam.getText().trim());
                float tiennhan = Float.valueOf(txtTienNhanTuKhach.getText().trim());
                txtTienThua.setText(String.valueOf(tiennhan - tongtien));
            }
        }


    }//GEN-LAST:event_txtTienNhanTuKhachMouseExited

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnTroVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroVeActionPerformed
        if (txtHienTenDangNhap.getText().trim().equals("Quản Lý")) {
            new FormHoaDon().setVisible(true);
            this.setVisible(false);
        } else {
            new FormDangNhap().setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_btnTroVeActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        btnCapNhat.setEnabled(false);
        nullColorButton(btnCapNhat);
        btnThem.setEnabled(true);
        colorButton(btnThem);
        btnTimKiem.setEnabled(true);
        colorButton(btnTimKiem);
        btnXoa.setEnabled(false);
        nullColorButton(btnXoa);
    }//GEN-LAST:event_btnLamMoiActionPerformed
    int tienthua = 0;
    private void cbSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbSPActionPerformed

    private void cbLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLoaiSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbLoaiSPActionPerformed

    private void txtTienNhanTuKhachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienNhanTuKhachMouseClicked
        tienthua = 1;
    }//GEN-LAST:event_txtTienNhanTuKhachMouseClicked

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
//            java.util.logging.Logger.getLogger(FormCTHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormCTHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormCTHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormCTHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new FormCTHoaDon("NV0001", "").setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner SpinnerSoLuong;
    private javax.swing.JTable TableDanhSachSP;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemKH;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimKiemKH;
    private javax.swing.JButton btnTroVe;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbKhachHang;
    private javax.swing.JComboBox<String> cbLoaiSP;
    private javax.swing.JComboBox<String> cbSP;
    private javax.swing.JComboBox<String> cbSize;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelLeft;
    private javax.swing.JPanel jPanelRight;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lableThanhTien;
    private javax.swing.JLabel lablenhapSDT;
    private javax.swing.JLabel lblbackgroundleft;
    private javax.swing.JLabel lblbackgroundright;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JPanel panelHD;
    private javax.swing.JPanel panelKhuyenMai;
    private javax.swing.JPanel panelNhapSDT;
    private javax.swing.JPanel panelTienGiamGia;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtHienTenDangNhap;
    private javax.swing.JTextField txtKM;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaHDHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaKHHD;
    private javax.swing.JTextField txtMaKMHD;
    private javax.swing.JTextField txtMaNVHD;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtSDTKhach;
    private javax.swing.JTextField txtSPAD;
    private javax.swing.JTextField txtSoTienCanThanhToanSauGiam;
    private javax.swing.JTextField txtSoTienGiam;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTienNhanTuKhach;
    private javax.swing.JTextField txtTienThua;
    // End of variables declaration//GEN-END:variables
}
