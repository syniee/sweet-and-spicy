/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.LoaiDAO;
import DAO.SanPhamDAO;
import DT.Loai;
import DT.SanPham;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author ACER PC
 */
public final class FormSanPham extends javax.swing.JFrame {

    Connection con;
    Statement s;
    ResultSet rs;
    PreparedStatement pr;
    DB.Connect db = new DB.Connect();
    DefaultTableModel Bang, TableModel;
    SanPhamDAO spdao = new SanPhamDAO();
    Vector Hang;

    public void reset() {
        txtTenSanPham.setText("");
        cbLoai.setSelectedIndex(0);
        cbSize.setSelectedIndex(0);
        spinnerGia.setEnabled(false);
        spinnerGia.getModel().setValue((float) 12000);
        txtTenSanPham.setEnabled(false);
        //txtTenSanPham.setBackground(new Color(239,222,206));
        cbLoai.setEnabled(false);
        cbSize.setEnabled(false);
        
        btnCapNhat.setEnabled(false);
        btnCapNhat.setForeground(new Color(187,187,187));
        btnCapNhat.setBorder(null);
        btnLuu.setEnabled(false);
        btnLuu.setForeground(new Color(187,187,187));
        btnLuu.setBorder(null);
        btnXoa.setEnabled(false);
        btnXoa.setForeground(new Color(187,187,187));
        btnXoa.setBorder(null);
        btnReset.setEnabled(false);
        btnReset.setForeground(null);
        btnReset.setBorder(null);        
        txtMaSanPham.setEnabled(false);
        txtMaSanPham.setText("");
        txtMaSanPham.setBackground(new Color(60,63,65));
        jPanelTimKiemTheoGia.setVisible(false);
        jPanelTimKiemTheoLoai.setVisible(false);
        jPanelTimKiemTheoSize.setVisible(false);
        btnThem.setEnabled(true);
        btnThem.setForeground(new Color(95,59,24));
        btnThem.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        txtMaSanPham.setBorder(null);
        txtTenSanPham.setBorder(null);
        cbLoai.setBorder(null);
        cbSize.setBorder(null);
        spinnerGia.setBorder(null);

    }

    public FormSanPham() {
        initComponents();       
        setIconImage();
        //Table header
        headerTable();
//        jtableSanPham.getTableHeader().setBackground(new Color(1).YELLOW);
        setComboBox();        
        scaleImage();
        loadLoai();
        reset();
        TableModel = new DefaultTableModel();
        TableModel.addColumn("Mã sản phẩm");
        TableModel.addColumn("Tên sản phẩm");
        TableModel.addColumn("Loại");
        TableModel.addColumn("Size");
        TableModel.addColumn("Giá");
        HienThi();       
    }
    
    private void setIconImage(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/whitess_logo.png")));
    }
    
    public void setComboBox(){
        cbTimKIem.setBackground(new Color(196,119,44));
        cbTimKIem.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        cbTimKIem.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        
    }
    //Table header
    public void headerTable(){
        JTableHeader headertb = jtableSanPham.getTableHeader();
        headertb.setBackground(new Color(110,55,13));
        headertb.setForeground(new Color(95,59,24));
        headertb.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
    }
    public void scaleImage(){
        //background
        ImageIcon sanpham_background = new ImageIcon(getClass().getResource("/Image/sanpham_background.png"));
        Image sanpham_img = sanpham_background.getImage();
        Image sanphamImgScale = sanpham_img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sanphamScaledIcon = new ImageIcon(sanphamImgScale);
        lblbackground.setIcon(sanphamScaledIcon);
        
        //tim kiem
        ImageIcon timkiem_icon = new ImageIcon(getClass().getResource("/Image/timkiemsanpham_background.png"));
        Image timkiem_img = timkiem_icon.getImage();
        Image timkiemImgScale = timkiem_img.getScaledInstance(lblTimKiemBackground.getWidth(), lblTimKiemBackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon timkiemScaledIcon = new ImageIcon(timkiemImgScale);
        lblTimKiemBackground.setIcon(timkiemScaledIcon);
        
        //thong tin
        ImageIcon ttsp_icon = new ImageIcon(getClass().getResource("/Image/sanpham1_background.png"));
        Image ttsp_img = ttsp_icon.getImage();
        Image ttspImgScale = ttsp_img.getScaledInstance(lblthongtinspbg.getWidth(), lblthongtinspbg.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ttspScaledIcon = new ImageIcon(ttspImgScale);
        lblthongtinspbg.setIcon(ttspScaledIcon);
        
        //title
        ImageIcon title_icon = new ImageIcon(getClass().getResource("/Image/sanpham_title.png"));
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
        
//        ImageIcon lg_icon = new ImageIcon(getClass().getResource("/Image/sweetandspicy1_logo.png"));
//        Image lg_img = lg_icon.getImage();
//        Image lgImgScale = lg_img.getScaledInstance(lbllogo.getWidth(), lbllogo.getHeight(), Image.SCALE_SMOOTH);
//        ImageIcon lgScaledIcon = new ImageIcon(lgImgScale);
//        lbllogo.setIcon(lgScaledIcon);
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableSanPham = new javax.swing.JTable();
        jPanelSanPham = new javax.swing.JPanel();
        lblmasp = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenSanPham = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaSanPham = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        spinnerGia = new javax.swing.JSpinner();
        cbLoai = new javax.swing.JComboBox<>();
        cbSize = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        lblthongtinspbg = new javax.swing.JLabel();
        lbltitle = new javax.swing.JLabel();
        btnTroVe = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jPanelFind = new javax.swing.JPanel();
        btnTimKiem = new javax.swing.JButton();
        cbTimKIem = new javax.swing.JComboBox<>();
        jPanelTimKiem = new javax.swing.JPanel();
        jPanelTimKiemTheoSize = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbTimKiemTheoSize = new javax.swing.JComboBox<>();
        jPanelTimKiemTheoGia = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sprinnerGiaTu = new javax.swing.JSpinner();
        spinnerDenGia = new javax.swing.JSpinner();
        jPanelTimKiemTheoMa = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtTimKiemMaSP = new javax.swing.JTextField();
        jPanelTimKiemTheoLoai = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbTimLoai = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        lblTimKiemBackground = new javax.swing.JLabel();
        lbllogo = new javax.swing.JLabel();
        btnQLLoai = new javax.swing.JButton();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sản phẩm Sweet&Spicy");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        jtableSanPham.setBackground(new java.awt.Color(204, 204, 204));
        jtableSanPham.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jtableSanPham.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jtableSanPham.setForeground(new java.awt.Color(144, 89, 35));
        jtableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtableSanPham.setGridColor(new java.awt.Color(95, 59, 24));
        jtableSanPham.setRowHeight(30);
        jtableSanPham.setSelectionBackground(new java.awt.Color(95, 59, 24));
        jtableSanPham.setSelectionForeground(new java.awt.Color(232, 216, 200));
        jtableSanPham.setShowGrid(false);
        jtableSanPham.setShowHorizontalLines(true);
        jtableSanPham.setShowVerticalLines(true);
        jScrollPane1.setViewportView(jtableSanPham);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(10, 550, 980, 170);

        jPanelSanPham.setLayout(null);

        lblmasp.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        lblmasp.setForeground(new java.awt.Color(163, 108, 52));
        lblmasp.setText("Mã sản phẩm");
        jPanelSanPham.add(lblmasp);
        lblmasp.setBounds(40, 70, 116, 25);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(163, 108, 52));
        jLabel3.setText("Tên sản phẩm");
        jPanelSanPham.add(jLabel3);
        jLabel3.setBounds(40, 110, 120, 27);

        txtTenSanPham.setBackground(new java.awt.Color(60, 63, 65));
        txtTenSanPham.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtTenSanPham.setForeground(new java.awt.Color(155, 95, 36));
        jPanelSanPham.add(txtTenSanPham);
        txtTenSanPham.setBounds(200, 110, 193, 30);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(163, 108, 52));
        jLabel4.setText("Loại sản phẩm");
        jPanelSanPham.add(jLabel4);
        jLabel4.setBounds(40, 150, 130, 25);

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(163, 108, 52));
        jLabel5.setText("Size");
        jPanelSanPham.add(jLabel5);
        jLabel5.setBounds(40, 190, 78, 27);

        txtMaSanPham.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaSanPham.setForeground(new java.awt.Color(155, 95, 36));
        txtMaSanPham.setToolTipText("VD: SP1111");
        txtMaSanPham.setEnabled(false);
        jPanelSanPham.add(txtMaSanPham);
        txtMaSanPham.setBounds(200, 70, 193, 30);

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(163, 108, 52));
        jLabel7.setText("Giá");
        jPanelSanPham.add(jLabel7);
        jLabel7.setBounds(40, 230, 90, 30);

        spinnerGia.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        spinnerGia.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(12000.0f), Float.valueOf(12000.0f), Float.valueOf(80000.0f), Float.valueOf(1000.0f)));
        spinnerGia.setEnabled(false);
        jPanelSanPham.add(spinnerGia);
        spinnerGia.setBounds(200, 230, 80, 30);

        cbLoai.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        cbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mỳ Cay", "Trà Sữa", "KimBap", "Nước Ngọt", " " }));
        jPanelSanPham.add(cbLoai);
        cbLoai.setBounds(200, 150, 120, 30);

        cbSize.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        cbSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L" }));
        jPanelSanPham.add(cbSize);
        cbSize.setBounds(200, 190, 60, 30);

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(95, 59, 24));
        jLabel12.setText("Thông tin sản phẩm");
        jPanelSanPham.add(jLabel12);
        jLabel12.setBounds(120, 10, 230, 30);

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
        jPanelSanPham.add(btnCapNhat);
        btnCapNhat.setBounds(250, 270, 106, 78);

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
        jPanelSanPham.add(btnXoa);
        btnXoa.setBounds(370, 270, 107, 78);

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
        jPanelSanPham.add(btnLuu);
        btnLuu.setBounds(130, 270, 107, 78);

        btnThem.setBackground(new java.awt.Color(204, 157, 110));
        btnThem.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add_icon.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnThem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanelSanPham.add(btnThem);
        btnThem.setBounds(10, 270, 107, 78);

        btnReset.setBackground(new java.awt.Color(204, 157, 110));
        btnReset.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnReset.setForeground(new java.awt.Color(95, 59, 24));
        btnReset.setText("Làm mới");
        btnReset.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanelSanPham.add(btnReset);
        btnReset.setBounds(200, 360, 107, 30);

        lblthongtinspbg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sanpham1_background.png"))); // NOI18N
        lblthongtinspbg.setText("jLabel13");
        lblthongtinspbg.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelSanPham.add(lblthongtinspbg);
        lblthongtinspbg.setBounds(0, 0, 490, 400);

        jPanel1.add(jPanelSanPham);
        jPanelSanPham.setBounds(10, 120, 490, 402);

        lbltitle.setFont(new java.awt.Font("Arial", 0, 40)); // NOI18N
        lbltitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sanpham_title.png"))); // NOI18N
        lbltitle.setText("QUẢN LÝ SẢN PHẨM");
        jPanel1.add(lbltitle);
        lbltitle.setBounds(320, 20, 410, 60);

        btnTroVe.setBackground(new java.awt.Color(110, 74, 38));
        btnTroVe.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnTroVe.setForeground(new java.awt.Color(255, 255, 255));
        btnTroVe.setText("Trở về");
        btnTroVe.setToolTipText("Trở về trang quản lý");
        btnTroVe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnTroVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroVeActionPerformed(evt);
            }
        });
        jPanel1.add(btnTroVe);
        btnTroVe.setBounds(400, 730, 107, 40);

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
        btnThoat.setBounds(540, 730, 107, 40);

        jPanelFind.setBackground(new java.awt.Color(204, 204, 204));
        jPanelFind.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelFind.setLayout(null);

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
        jPanelFind.add(btnTimKiem);
        btnTimKiem.setBounds(342, 70, 81, 35);

        cbTimKIem.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbTimKIem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tìm kiếm theo mã ", "Tìm kiếm theo loại ", "Tìm kiếm theo size", "Tìm kiếm theo giá" }));
        cbTimKIem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 134, 98), 3, true));
        cbTimKIem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbTimKIemMouseClicked(evt);
            }
        });
        cbTimKIem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTimKIemActionPerformed(evt);
            }
        });
        jPanelFind.add(cbTimKIem);
        cbTimKIem.setBounds(30, 70, 290, 35);

        jPanelTimKiem.setBackground(new java.awt.Color(204, 204, 204));

        jPanelTimKiemTheoSize.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(163, 108, 52));
        jLabel8.setText("Size ");

        cbTimKiemTheoSize.setBackground(new java.awt.Color(196, 119, 44));
        cbTimKiemTheoSize.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        cbTimKiemTheoSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "S", "M", "L" }));
        cbTimKiemTheoSize.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));

        javax.swing.GroupLayout jPanelTimKiemTheoSizeLayout = new javax.swing.GroupLayout(jPanelTimKiemTheoSize);
        jPanelTimKiemTheoSize.setLayout(jPanelTimKiemTheoSizeLayout);
        jPanelTimKiemTheoSizeLayout.setHorizontalGroup(
            jPanelTimKiemTheoSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemTheoSizeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbTimKiemTheoSize, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanelTimKiemTheoSizeLayout.setVerticalGroup(
            jPanelTimKiemTheoSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemTheoSizeLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanelTimKiemTheoSizeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbTimKiemTheoSize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanelTimKiemTheoGia.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(163, 108, 52));
        jLabel9.setText("Giá từ");

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(163, 108, 52));
        jLabel10.setText("Đến");

        sprinnerGiaTu.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        sprinnerGiaTu.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(12000.0f), Float.valueOf(12000.0f), Float.valueOf(80000.0f), Float.valueOf(1000.0f)));
        sprinnerGiaTu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));

        spinnerDenGia.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        spinnerDenGia.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(12000.0f), Float.valueOf(12000.0f), Float.valueOf(80000.0f), Float.valueOf(1000.0f)));
        spinnerDenGia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));

        javax.swing.GroupLayout jPanelTimKiemTheoGiaLayout = new javax.swing.GroupLayout(jPanelTimKiemTheoGia);
        jPanelTimKiemTheoGia.setLayout(jPanelTimKiemTheoGiaLayout);
        jPanelTimKiemTheoGiaLayout.setHorizontalGroup(
            jPanelTimKiemTheoGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemTheoGiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTimKiemTheoGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelTimKiemTheoGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sprinnerGiaTu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerDenGia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        jPanelTimKiemTheoGiaLayout.setVerticalGroup(
            jPanelTimKiemTheoGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemTheoGiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelTimKiemTheoGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sprinnerGiaTu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelTimKiemTheoGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerDenGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanelTimKiemTheoMa.setBackground(new java.awt.Color(204, 204, 204));

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(163, 108, 52));
        jLabel11.setText("Mã sản phẩm");

        txtTimKiemMaSP.setBackground(new java.awt.Color(239, 222, 206));
        txtTimKiemMaSP.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtTimKiemMaSP.setForeground(new java.awt.Color(110, 68, 26));
        txtTimKiemMaSP.setToolTipText("Nhập mã sản phẩm");
        txtTimKiemMaSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));

        javax.swing.GroupLayout jPanelTimKiemTheoMaLayout = new javax.swing.GroupLayout(jPanelTimKiemTheoMa);
        jPanelTimKiemTheoMa.setLayout(jPanelTimKiemTheoMaLayout);
        jPanelTimKiemTheoMaLayout.setHorizontalGroup(
            jPanelTimKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemTheoMaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiemMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTimKiemTheoMaLayout.setVerticalGroup(
            jPanelTimKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemTheoMaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanelTimKiemTheoMaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTimKiemMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelTimKiemTheoLoai.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(163, 108, 52));
        jLabel6.setText("Loại sản phẩm");

        cbTimLoai.setBackground(new java.awt.Color(196, 119, 44));
        cbTimLoai.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        cbTimLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mỳ Cay", "Trà Sữa", "KimBap", "Nước Ngọt", " " }));
        cbTimLoai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));

        javax.swing.GroupLayout jPanelTimKiemTheoLoaiLayout = new javax.swing.GroupLayout(jPanelTimKiemTheoLoai);
        jPanelTimKiemTheoLoai.setLayout(jPanelTimKiemTheoLoaiLayout);
        jPanelTimKiemTheoLoaiLayout.setHorizontalGroup(
            jPanelTimKiemTheoLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemTheoLoaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTimLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTimKiemTheoLoaiLayout.setVerticalGroup(
            jPanelTimKiemTheoLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemTheoLoaiLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanelTimKiemTheoLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbTimLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelTimKiemLayout = new javax.swing.GroupLayout(jPanelTimKiem);
        jPanelTimKiem.setLayout(jPanelTimKiemLayout);
        jPanelTimKiemLayout.setHorizontalGroup(
            jPanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanelTimKiemTheoMa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTimKiemTheoLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTimKiemTheoGia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelTimKiemTheoSize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTimKiemLayout.setVerticalGroup(
            jPanelTimKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTimKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelTimKiemTheoMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanelTimKiemTheoLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelTimKiemTheoSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelTimKiemTheoGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelFind.add(jPanelTimKiem);
        jPanelTimKiem.setBounds(10, 130, 320, 110);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(95, 59, 24));
        jLabel2.setText("Tìm kiếm");
        jPanelFind.add(jLabel2);
        jLabel2.setBounds(190, 10, 120, 30);

        lblTimKiemBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/timkiemsanpham_background.png"))); // NOI18N
        lblTimKiemBackground.setText("jLabel13");
        jPanelFind.add(lblTimKiemBackground);
        lblTimKiemBackground.setBounds(0, 256, 460, 140);

        jPanel1.add(jPanelFind);
        jPanelFind.setBounds(530, 120, 460, 400);

        lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sweetandspicy_logo.png"))); // NOI18N
        jPanel1.add(lbllogo);
        lbllogo.setBounds(10, 10, 80, 100);

        btnQLLoai.setBackground(new java.awt.Color(110, 74, 38));
        btnQLLoai.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnQLLoai.setForeground(new java.awt.Color(255, 255, 255));
        btnQLLoai.setText("Quản lý Loại");
        btnQLLoai.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnQLLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQLLoaiActionPerformed(evt);
            }
        });
        jPanel1.add(btnQLLoai);
        btnQLLoai.setBounds(850, 730, 140, 40);

        lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sanpham_background.png"))); // NOI18N
        jPanel1.add(lblbackground);
        lblbackground.setBounds(0, 0, 1000, 790);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1001, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 789, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    // cho phep nhập dữ liệu khi nhấn vào button Thêm

    public void chophepnhaplieu() {
        txtTenSanPham.setEnabled(true);
        txtTenSanPham.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        txtTenSanPham.setBackground(new Color(239,222,206));
        
        cbLoai.setEnabled(true);
        cbLoai.setBackground(new Color(196,119,44));
        cbLoai.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        cbLoai.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));

        cbSize.setEnabled(true);
        cbSize.setBackground(new Color(196,119,44));
        cbSize.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        cbSize.setFont(new Font(Font.DIALOG, Font.PLAIN, 14));
        
        btnCapNhat.setEnabled(false);
        btnCapNhat.setForeground(new Color(187,187,187));
        btnCapNhat.setBorder(null);
        
        btnLuu.setEnabled(true);
        btnLuu.setForeground(new Color(95,59,24));
        btnLuu.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
       
        btnThem.setEnabled(false);
        btnThem.setForeground(new Color(187,187,187));
        btnThem.setBorder(null);
        
        btnReset.setEnabled(true);
        btnReset.setForeground(new Color(95,59,24));
        btnReset.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        
        txtMaSanPham.setEnabled(true);
        txtMaSanPham.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        txtMaSanPham.setBackground(new Color(239,222,206));
        
        spinnerGia.setEnabled(true);
//        spinnerGia.setBackground(new Color(196,119,44));
//        spinnerGia.getEditor().getComponent(0).setBackground(Color.red);
        spinnerGia.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));

    }

    //Hiển thị dữ liệu trong bảng
    public void HienThi() {
        LoaiDAO loaidao = new LoaiDAO();
        ArrayList<SanPham> ds = spdao.DanhSachSP();
        ArrayList<Loai> dsloai = loaidao.DSLoaiSP();
        for (int i = 0; i < ds.size(); i++) {
            Hang = new Vector();
            SanPham sp = ds.get(i);
            Hang.add(sp.getMaSP());
            Hang.add(sp.getTenSP());
            for (int j = 0; j < dsloai.size(); j++) {
                Loai l = dsloai.get(j);
                if (sp.getMaLoai().equals(l.getMaLoai())) {
                    Hang.add(l.getTenLoai());
                }
            }
            Hang.add(sp.getSize());
            Hang.add(sp.getGia());
            TableModel.addRow(Hang);
        }
        jtableSanPham.setModel(TableModel);
    }
    
    public void loadLoai(){
        LoaiDAO loaidao = new LoaiDAO();
        ArrayList<Loai> ds = loaidao.DSLoaiSP();
        cbLoai.removeAllItems();
        cbTimLoai.removeAllItems();
        for(int i=0; i< ds.size(); i++){
            Loai loai = ds.get(i);
            cbLoai.addItem(loai.getTenLoai());
            cbTimLoai.addItem(loai.getTenLoai());
        }
    }
    //Kiểm tra dữ liệu nhập có đúng quy định 
    public boolean kiemtra() {
        StringBuilder baoloi = new StringBuilder();
        if (txtMaSanPham.getText().trim().equals("")) {
            baoloi.append("Mã sản phẩm pahir được nhập.\n");
        } else if (!txtMaSanPham.getText().trim().matches("SP\\d{4}$")) {
            baoloi.append("Mã sản phẩm không đúng định dạng. VD: SP1234\n");
        }
        if (txtTenSanPham.getText().trim().equals("")) {
            baoloi.append("Tên sản phẩm phải được nhập\n");
        }
        if (baoloi.length() > 0) {
            JOptionPane.showMessageDialog(rootPane, baoloi);
            return false;
        }
        return true;
    }

    public String LayMaLoai(String tenloai) {
        LoaiDAO loaidao = new LoaiDAO();
        ArrayList<Loai> dsloai = loaidao.DSLoaiSP();
        for (int i = 0; i < dsloai.size(); i++) {
            Loai loai = new Loai();
            loai = dsloai.get(i);
            if (tenloai.equals(loai.getTenLoai())) {
                return loai.getMaLoai();
            }
        }
        return null;
    }

    //Button THêm
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        chophepnhaplieu();

    }//GEN-LAST:event_btnThemActionPerformed

    //Button LƯU
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed

        String maloai = null;
        if (kiemtra()) {
            if (spdao.TimKiemSP(txtMaSanPham.getText()) != null) {
                JOptionPane.showMessageDialog(rootPane, "Mã sản phẩm đã tồn tại!");
            } else {
                SanPham sp = new SanPham();
                sp.setMaSP(txtMaSanPham.getText());
                sp.setTenSP(txtTenSanPham.getText());
                sp.setMaLoai(LayMaLoai((String) cbLoai.getSelectedItem()));
                sp.setSize((String) cbSize.getSelectedItem());
                sp.setGia((float) spinnerGia.getValue());
                if (spdao.ThemSP(sp)) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm sản phẩm thành công!");
                    TableModel.getDataVector().removeAllElements();
                    HienThi();
                    btnTimKiem.setEnabled(true);
                    btnLuu.setEnabled(false);
                    btnLuu.setForeground(new Color(187,187,187));
                    btnThem.setEnabled(true);
                    btnThem.setForeground(new Color(95,59,24));
                    btnThem.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
                    
                    reset();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Thêm sản phẩm không thành công!");
                }

            }

        }
    }//GEN-LAST:event_btnLuuActionPerformed

    //Button CẬP NHẬT
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn cập nhật thông tin món ăn đã chọn");
        if (check != 1) {
            if (kiemtra()) {
                SanPham sp = new SanPham();
                sp.setMaSP(txtMaSanPham.getText());
                sp.setTenSP(txtTenSanPham.getText());
                sp.setMaLoai(LayMaLoai((String) cbLoai.getSelectedItem()));
                sp.setSize((String) cbSize.getSelectedItem());
                sp.setGia((float) spinnerGia.getValue());
                if (spdao.CapNhatSP(sp)) {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công.");
                    reset();
                    btnThem.setEnabled(true);
                    TableModel.getDataVector().removeAllElements();
                    HienThi();
                }

            }
        }

    }//GEN-LAST:event_btnCapNhatActionPerformed

    public String laytenloai(String maloai) {
        LoaiDAO loaidao = new LoaiDAO();
        ArrayList<Loai> dsloai = loaidao.DSLoaiSP();
        for (int i = 0; i < dsloai.size(); i++) {
            Loai loai = new Loai();
            loai = dsloai.get(i);
            if (maloai.equals(loai.getMaLoai())) {
                return loai.getTenLoai();
            }
        }
        return null;
    }

    //BUTTON TÌM KIẾM
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed

        con = db.getConn();
        int kiemtrarong = 0;
        if (cbTimKIem.getSelectedIndex() == 0) {
            SanPham sp = spdao.TimKiemSP(txtTimKiemMaSP.getText());
            if (sp != null) {
                JOptionPane.showMessageDialog(rootPane, "Đã tìm thấy sản phẩm!");
                txtMaSanPham.setText(sp.getMaSP());
                txtTenSanPham.setText(sp.getTenSP());
                String tenloai = laytenloai(sp.getMaLoai());
                cbLoai.getModel().setSelectedItem(tenloai);
                cbSize.getModel().setSelectedItem(sp.getSize().trim());
                spinnerGia.setValue(sp.getGia());
                chophepnhaplieu();
                btnCapNhat.setEnabled(true);
                btnCapNhat.setForeground(new Color(95,59,24));
                btnCapNhat.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));                
                btnXoa.setEnabled(true);
                btnXoa.setForeground(new Color(95,59,24));
                btnXoa.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
                btnLuu.setEnabled(false);
                btnLuu.setForeground(new Color(187,187,187));
                btnLuu.setBorder(null);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Không tìm thấy sản phẩm có mã đã nhập");
            }

        } else if (cbTimKIem.getSelectedIndex() == 1) {
//TÌM KIẾM THEO LOẠI SẢN PHẨM
            TableModel.getDataVector().removeAllElements();
            ArrayList<SanPham> ds = spdao.DanhSachSP();
            for (int i = 0; i < ds.size(); i++) {
                kiemtrarong = 1;
                SanPham sp = ds.get(i);
                if (laytenloai(sp.getMaLoai()).equals(cbTimLoai.getSelectedItem())) {
                    Hang = new Vector();
                    Hang.add(sp.getMaSP());
                    Hang.add(sp.getTenSP());
                    Hang.add(laytenloai(sp.getMaLoai()));
                    Hang.add(sp.getSize());
                    Hang.add(sp.getGia());
                    TableModel.addRow(Hang);
                }
            }
            if (kiemtrarong == 1) {
                jtableSanPham.setModel(TableModel);
                kiemtrarong = 0;
            } else {
                JOptionPane.showMessageDialog(rootPane, "Không tìm thấy kết quả phù hợp với yêu cầu của bạn.");
            }

        } else if (cbTimKIem.getSelectedIndex() == 2) {
//TÌM KIẾM THEO SIZE CỦA SẢN PHẨM
            TableModel.getDataVector().removeAllElements();
            ArrayList<SanPham> ds = spdao.DanhSachSP();
            for (int i = 0; i < ds.size(); i++) {
                kiemtrarong = 1;
                SanPham sp = ds.get(i);
                if (sp.getSize().trim().equals(cbTimKiemTheoSize.getSelectedItem())) {
                    Hang = new Vector();
                    Hang.add(sp.getMaSP());
                    Hang.add(sp.getTenSP());
                    Hang.add(laytenloai(sp.getMaLoai()));
                    Hang.add(sp.getSize());
                    Hang.add(sp.getGia());
                    TableModel.addRow(Hang);
                    kiemtrarong=1;
                }
            }
            if (kiemtrarong == 1) {
                jtableSanPham.setModel(TableModel);
                kiemtrarong = 0;
            } else {
                JOptionPane.showMessageDialog(rootPane, "Không tìm thấy kết quả phù hợp với yêu cầu của bạn.");
            }

    }//GEN-LAST:event_btnTimKiemActionPerformed
        else if (cbTimKIem.getSelectedIndex() == 3) {
            if ((float) sprinnerGiaTu.getValue() <= (float) spinnerDenGia.getValue()) {
                TableModel.getDataVector().removeAllElements();
                ArrayList<SanPham> ds = spdao.DanhSachSP();
                for (int i = 0; i < ds.size(); i++) {
                    kiemtrarong = 1;
                    SanPham sp = ds.get(i);
                    if ((sp.getGia() >= (float) sprinnerGiaTu.getValue()) && (sp.getGia() <= (float) spinnerDenGia.getValue())) {
                        Hang = new Vector();
                        Hang.add(sp.getMaSP());
                        Hang.add(sp.getTenSP());
                        Hang.add(laytenloai(sp.getMaLoai()));
                        Hang.add(sp.getSize());
                        Hang.add(sp.getGia());
                        TableModel.addRow(Hang);
                    }
                }
                if (kiemtrarong == 1) {
                    jtableSanPham.setModel(TableModel);
                    kiemtrarong = 0;
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Không tìm thấy kết quả phù hợp với yêu cầu của bạn.");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Giá từ phải nhỏ hơn giá đến");
            }

        }
    }

    //BUTTON XÓA
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn xóa sản phẩm đã chọn?");
        if (check != 1) {
            if (spdao.XoaSP(txtMaSanPham.getText())) {
                JOptionPane.showMessageDialog(rootPane, "Xóa Sản phẩm thành công");
                TableModel.getDataVector().removeAllElements();
                HienThi();
                btnThem.setEnabled(true);
            }
            else JOptionPane.showMessageDialog(rootPane, "Xóa sản phẩm không thành công.");
            reset();
        }

    }//GEN-LAST:event_btnXoaActionPerformed

    // Hiển thị các jpanel tương ứng với loại tìm kiếm được lựa chọn trong combobox tìm kiếm
    private void cbTimKIemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTimKIemActionPerformed
        if (cbTimKIem.getSelectedIndex() == 0) {
            txtMaSanPham.setEnabled(false);/*Cho t sua*/
            jPanelTimKiemTheoMa.setVisible(true);/*Cho t sua*/
            spinnerGia.setEnabled(false);
            jPanelTimKiemTheoLoai.setVisible(false);
            jPanelTimKiemTheoGia.setVisible(false);
            jPanelTimKiemTheoSize.setVisible(false);

        } else if (cbTimKIem.getSelectedIndex() == 1) {
            txtMaSanPham.setEnabled(false);
            jPanelTimKiemTheoMa.setVisible(false);/*Cho t sua*/
            spinnerGia.setEnabled(false);
            jPanelTimKiemTheoLoai.setVisible(true);
            jPanelTimKiemTheoGia.setVisible(false);
            jPanelTimKiemTheoSize.setVisible(false);
        } else if (cbTimKIem.getSelectedIndex() == 2) {
            txtMaSanPham.setEnabled(false);
            jPanelTimKiemTheoMa.setVisible(false);/*Cho t sua*/
            spinnerGia.setEnabled(false);
            jPanelSanPham.setEnabled(false);
            jPanelTimKiemTheoSize.setVisible(true);
            jPanelTimKiemTheoLoai.setVisible(false);
            jPanelTimKiemTheoGia.setVisible(false);
        } else if (cbTimKIem.getSelectedIndex() == 3) {
            txtMaSanPham.setEnabled(false);
            jPanelTimKiemTheoMa.setVisible(false);/*Cho t sua*/
            spinnerGia.setEnabled(false);
            jPanelSanPham.setEnabled(false);
            jPanelTimKiemTheoGia.setVisible(true);
            jPanelTimKiemTheoLoai.setVisible(false);
            jPanelTimKiemTheoSize.setVisible(false);
        }

    }//GEN-LAST:event_cbTimKIemActionPerformed

    private void cbTimKIemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbTimKIemMouseClicked
        reset();
    }//GEN-LAST:event_cbTimKIemMouseClicked

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnTroVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroVeActionPerformed
        this.setVisible(false);
        new FormQuanLy().setVisible(true);
    }//GEN-LAST:event_btnTroVeActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnQLLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQLLoaiActionPerformed
        new FormLoaiSanPham().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnQLLoaiActionPerformed

////    /**
////     * @param args the command line arguments
////     */
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
//            java.util.logging.Logger.getLogger(FormSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new FormSanPham().setVisible(true);
//            }
//        });
//        
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnQLLoai;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTroVe;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cbLoai;
    private javax.swing.JComboBox<String> cbSize;
    private javax.swing.JComboBox<String> cbTimKIem;
    private javax.swing.JComboBox<String> cbTimKiemTheoSize;
    private javax.swing.JComboBox<String> cbTimLoai;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelFind;
    private javax.swing.JPanel jPanelSanPham;
    private javax.swing.JPanel jPanelTimKiem;
    private javax.swing.JPanel jPanelTimKiemTheoGia;
    private javax.swing.JPanel jPanelTimKiemTheoLoai;
    private javax.swing.JPanel jPanelTimKiemTheoMa;
    private javax.swing.JPanel jPanelTimKiemTheoSize;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtableSanPham;
    private javax.swing.JLabel lblTimKiemBackground;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lblmasp;
    private javax.swing.JLabel lblthongtinspbg;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JSpinner spinnerDenGia;
    private javax.swing.JSpinner spinnerGia;
    private javax.swing.JSpinner sprinnerGiaTu;
    private javax.swing.JTextField txtMaSanPham;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTimKiemMaSP;
    // End of variables declaration//GEN-END:variables
}
