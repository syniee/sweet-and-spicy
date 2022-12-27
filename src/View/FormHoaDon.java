package View;

import DAO.CTHoaDonDAO;
import DAO.HoaDonDAO;
import DAO.LoaiDAO;
import DT.CTHoaDon;
import DT.HoaDon;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;

public class FormHoaDon extends javax.swing.JFrame {

    DefaultTableModel BangTK, BangCT;
    Vector Hang;
    HoaDon hd;
    HoaDonDAO hddao = new HoaDonDAO();

    public FormHoaDon() {
        initComponents();
        taobang();
        panelThongKeTheoKhach.setVisible(false);
        panelKM.setVisible(false);
        panelLoai.setVisible(false);
        panelMaNV.setVisible(false);
        panelNgayLap.setVisible(false);
        panelTKSp.setVisible(false);
        panelMaHD.setVisible(true);
        btnChiTietHD.setVisible(true);
        panelCTHD.setVisible(false);
        lblchitiethoadon.setVisible(false);
        
        loadcbLoai();
        
        setComboBox();
        headerTable();
        scaleImage();
        setIconImage();
    }
    //Title icon
    private void setIconImage(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/whitess_logo.png")));
    }
    public void setComboBox(){
        cbThongKeTheo.setBackground(new Color(196,119,44));
//        cbThongKeTheo.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        cbThongKeTheo.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        
    }
    public void scaleImage(){
        //logo
        ImageIcon logo_icon = new ImageIcon(getClass().getResource("/Image/sweetandspicy_logo.png"));
        Image logo_img = logo_icon.getImage();
        Image logoImgScale = logo_img.getScaledInstance(lbllogo.getWidth(), lbllogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon logoScaledIcon = new ImageIcon(logoImgScale);
        lbllogo.setIcon(logoScaledIcon);
        //title
        ImageIcon title_icon = new ImageIcon(getClass().getResource("/Image/hoadon_title.png"));
        Image title_img = title_icon.getImage();
        Image titleImgScale = title_img.getScaledInstance(lbltitle.getWidth(), lbltitle.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon titleScaledIcon = new ImageIcon(titleImgScale);
        lbltitle.setIcon(titleScaledIcon);
        //background
        ImageIcon sanpham_background = new ImageIcon(getClass().getResource("/Image/hoadon_background.png"));
        Image sanpham_img = sanpham_background.getImage();
        Image sanphamImgScale = sanpham_img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sanphamScaledIcon = new ImageIcon(sanphamImgScale);
        lblbackground.setIcon(sanphamScaledIcon);
        
        ImageIcon bill_background = new ImageIcon(getClass().getResource("/Image/hoadon_icon.png"));
        Image bill_img = bill_background.getImage();
        Image billImgScale = bill_img.getScaledInstance(lblbill.getWidth(), lblbill.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon billScaledIcon = new ImageIcon(billImgScale);
        lblbill.setIcon(billScaledIcon);
        
        ImageIcon bill1_background = new ImageIcon(getClass().getResource("/Image/hoadon1_icon.png"));
        Image bill1_img = bill1_background.getImage();
        Image bill1ImgScale = bill1_img.getScaledInstance(lblbill1.getWidth(), lblbill1.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon bill1ScaledIcon = new ImageIcon(bill1ImgScale);
        lblbill1.setIcon(bill1ScaledIcon);
    }
    public void headerTable(){
        //header table thong ke
        JTableHeader headertb = TableThongKe.getTableHeader();
        headertb.setBackground(new Color(110,55,13));
        headertb.setForeground(new Color(95,59,24));
        headertb.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
        
        //header table chi tiet hoa don
        JTableHeader headertb1 = TableChiTietHD.getTableHeader();
        headertb1.setBackground(new Color(110,55,13));
        headertb1.setForeground(new Color(95,59,24));
        headertb1.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
    }
    public void taobang() {
        BangTK = new DefaultTableModel();
        BangTK.addColumn("Mã hóa đơn");
        BangTK.addColumn("Mã nhân viên");
        BangTK.addColumn("Mã khách hàng");
        BangTK.addColumn("Mã khuyến mãi");
        BangTK.addColumn("Ngày lập");
        BangTK.addColumn("Thành tiền");
        BangTK.addColumn("Ghi chú");

        ArrayList<HoaDon> ds = hddao.DSHD();
        for (int i = 0; i < ds.size(); i++) {
            hd = ds.get(i);
            Hang = new Vector();
            Hang.add(hd.getMaHD());
            Hang.add(hd.getMaNV());
            Hang.add(hd.getMaKH());
            Hang.add(hd.getMaKM());
            Hang.add(hd.getNgayTao());
            Hang.add(hd.getThanhTien());
            Hang.add(hd.getGhiChu());
            BangTK.addRow(Hang);
        }
        TableThongKe.setModel(BangTK);
        BangCT = new DefaultTableModel();
        BangCT.addColumn("Mã sản phẩm");
        BangCT.addColumn("Size");
        BangCT.addColumn("Đơn giá");
        BangCT.addColumn("Số lượng");
        BangCT.addColumn("Thành tiền");
        TableChiTietHD.setModel(BangCT);
    }

    public void loadcbLoai() {
        LoaiDAO loaidao = new LoaiDAO();
        ArrayList<Loai> ds = loaidao.DSLoaiSP();
        cbLoai.removeAllItems();
        for (int i = 0; i < ds.size(); i++) {
            Loai l = ds.get(i);
            cbLoai.addItem(l.getTenLoai());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbltitle = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        panelLoai = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cbLoai = new javax.swing.JComboBox<>();
        panelTKSp = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        panelKM = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtMaKM = new javax.swing.JTextField();
        panelNgayLap = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        DateChooser = new com.toedter.calendar.JDateChooser();
        panelMaHD = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        panelMaNV = new javax.swing.JPanel();
        txtMaNV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        panelThongKeTheoKhach = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        btnThongKe = new javax.swing.JButton();
        btnChiTietHD = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        cbThongKeTheo = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        panelThongKe = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableThongKe = new javax.swing.JTable();
        panelCTHD = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableChiTietHD = new javax.swing.JTable();
        btnTRoVe = new javax.swing.JButton();
        btnSangCTHoaDon = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        lblchitiethoadon = new javax.swing.JLabel();
        lblthongtinhoadon = new javax.swing.JLabel();
        lbllogo = new javax.swing.JLabel();
        lblbill = new javax.swing.JLabel();
        lblbill1 = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hóa đơn Sweet&Spicy");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel1.setLayout(null);

        lbltitle.setFont(new java.awt.Font("Dialog", 0, 44)); // NOI18N
        lbltitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hoadon_title.png"))); // NOI18N
        jPanel1.add(lbltitle);
        lbltitle.setBounds(500, 30, 430, 60);

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelLoai.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(144, 97, 50));
        jLabel6.setText("Loại");

        cbLoai.setBackground(new java.awt.Color(196, 119, 44));
        cbLoai.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbLoai.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelLoaiLayout = new javax.swing.GroupLayout(panelLoai);
        panelLoai.setLayout(panelLoaiLayout);
        panelLoaiLayout.setHorizontalGroup(
            panelLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoaiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );
        panelLoaiLayout.setVerticalGroup(
            panelLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoaiLayout.createSequentialGroup()
                .addGroup(panelLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        panelTKSp.setBackground(new java.awt.Color(204, 204, 204));

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(144, 97, 50));
        jLabel7.setText("Mã sản phẩm");

        txtMaSP.setBackground(new java.awt.Color(229, 223, 217));
        txtMaSP.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaSP.setForeground(new java.awt.Color(110, 68, 26));
        txtMaSP.setToolTipText("VD: SP1111");
        txtMaSP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        txtMaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelTKSpLayout = new javax.swing.GroupLayout(panelTKSp);
        panelTKSp.setLayout(panelTKSpLayout);
        panelTKSpLayout.setHorizontalGroup(
            panelTKSpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTKSpLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelTKSpLayout.setVerticalGroup(
            panelTKSpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTKSpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTKSpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelKM.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(144, 97, 50));
        jLabel8.setText("Mã khuyến mãi");

        txtMaKM.setBackground(new java.awt.Color(229, 223, 217));
        txtMaKM.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaKM.setForeground(new java.awt.Color(110, 68, 26));
        txtMaKM.setToolTipText("VD: KM111");
        txtMaKM.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout panelKMLayout = new javax.swing.GroupLayout(panelKM);
        panelKM.setLayout(panelKMLayout);
        panelKMLayout.setHorizontalGroup(
            panelKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKMLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panelKMLayout.setVerticalGroup(
            panelKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelKMLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(panelKMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaKM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        panelNgayLap.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(144, 97, 50));
        jLabel9.setText("Ngày");

        DateChooser.setBackground(new java.awt.Color(169, 134, 98));
        DateChooser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelNgayLapLayout = new javax.swing.GroupLayout(panelNgayLap);
        panelNgayLap.setLayout(panelNgayLapLayout);
        panelNgayLapLayout.setHorizontalGroup(
            panelNgayLapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelNgayLapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        panelNgayLapLayout.setVerticalGroup(
            panelNgayLapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelNgayLapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelNgayLapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DateChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelMaHD.setBackground(new java.awt.Color(204, 204, 204));

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(144, 97, 50));
        jLabel10.setText("Mã hóa đơn");

        txtMaHD.setBackground(new java.awt.Color(229, 223, 217));
        txtMaHD.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaHD.setForeground(new java.awt.Color(110, 68, 26));
        txtMaHD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout panelMaHDLayout = new javax.swing.GroupLayout(panelMaHD);
        panelMaHD.setLayout(panelMaHDLayout);
        panelMaHDLayout.setHorizontalGroup(
            panelMaHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMaHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        panelMaHDLayout.setVerticalGroup(
            panelMaHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMaHDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMaHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMaNV.setBackground(new java.awt.Color(204, 204, 204));

        txtMaNV.setBackground(new java.awt.Color(229, 223, 217));
        txtMaNV.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaNV.setForeground(new java.awt.Color(110, 68, 26));
        txtMaNV.setToolTipText("VD: NV1111");
        txtMaNV.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel5.setBackground(new java.awt.Color(204, 204, 204));
        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(144, 97, 50));
        jLabel5.setText("Mã nhân viên");

        javax.swing.GroupLayout panelMaNVLayout = new javax.swing.GroupLayout(panelMaNV);
        panelMaNV.setLayout(panelMaNVLayout);
        panelMaNVLayout.setHorizontalGroup(
            panelMaNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMaNVLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        panelMaNVLayout.setVerticalGroup(
            panelMaNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMaNVLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMaNVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );

        panelThongKeTheoKhach.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(144, 97, 50));
        jLabel4.setText("Mã khách hàng");

        txtMaKH.setBackground(new java.awt.Color(229, 223, 217));
        txtMaKH.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaKH.setForeground(new java.awt.Color(110, 68, 26));
        txtMaKH.setToolTipText("VD: KH1111");
        txtMaKH.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout panelThongKeTheoKhachLayout = new javax.swing.GroupLayout(panelThongKeTheoKhach);
        panelThongKeTheoKhach.setLayout(panelThongKeTheoKhachLayout);
        panelThongKeTheoKhachLayout.setHorizontalGroup(
            panelThongKeTheoKhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongKeTheoKhachLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        panelThongKeTheoKhachLayout.setVerticalGroup(
            panelThongKeTheoKhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongKeTheoKhachLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelThongKeTheoKhachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelTKSp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelThongKeTheoKhach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelNgayLap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTKSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelKM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelThongKeTheoKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel7);
        jPanel7.setBounds(70, 240, 390, 70);

        btnThongKe.setBackground(new java.awt.Color(204, 157, 110));
        btnThongKe.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(95, 59, 24));
        btnThongKe.setText("Thống kê");
        btnThongKe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });
        jPanel1.add(btnThongKe);
        btnThongKe.setBounds(70, 370, 130, 29);

        btnChiTietHD.setBackground(new java.awt.Color(204, 157, 110));
        btnChiTietHD.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnChiTietHD.setForeground(new java.awt.Color(95, 59, 24));
        btnChiTietHD.setText("Xem chi tiết hóa đơn");
        btnChiTietHD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnChiTietHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietHDActionPerformed(evt);
            }
        });
        jPanel1.add(btnChiTietHD);
        btnChiTietHD.setBounds(230, 370, 230, 29);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(144, 97, 50));
        jLabel3.setText("Thống kê hóa đơn theo");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 170, 210, 32);

        cbThongKeTheo.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        cbThongKeTheo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MaHD", "Khách hàng", "Nhân viên", "Loại sản phẩm", "Sản phẩm", "Khuyến mãi", "Ngày lập" }));
        cbThongKeTheo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbThongKeTheo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbThongKeTheoItemStateChanged(evt);
            }
        });
        cbThongKeTheo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbThongKeTheoActionPerformed(evt);
            }
        });
        jPanel1.add(cbThongKeTheo);
        cbThongKeTheo.setBounds(310, 170, 181, 30);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        panelThongKe.setBackground(new java.awt.Color(204, 204, 204));
        panelThongKe.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

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
        jScrollPane1.setViewportView(TableThongKe);

        javax.swing.GroupLayout panelThongKeLayout = new javax.swing.GroupLayout(panelThongKe);
        panelThongKe.setLayout(panelThongKeLayout);
        panelThongKeLayout.setHorizontalGroup(
            panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 898, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelThongKeLayout.setVerticalGroup(
            panelThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelThongKeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelCTHD.setBackground(new java.awt.Color(204, 204, 204));
        panelCTHD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        TableChiTietHD.setBackground(new java.awt.Color(204, 204, 204));
        TableChiTietHD.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        TableChiTietHD.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        TableChiTietHD.setForeground(new java.awt.Color(144, 89, 35));
        TableChiTietHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TableChiTietHD.setGridColor(new java.awt.Color(95, 59, 24));
        TableChiTietHD.setRowHeight(30);
        TableChiTietHD.setSelectionBackground(new java.awt.Color(95, 59, 24));
        TableChiTietHD.setSelectionForeground(new java.awt.Color(232, 216, 200));
        jScrollPane2.setViewportView(TableChiTietHD);

        javax.swing.GroupLayout panelCTHDLayout = new javax.swing.GroupLayout(panelCTHD);
        panelCTHD.setLayout(panelCTHDLayout);
        panelCTHDLayout.setHorizontalGroup(
            panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCTHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        panelCTHDLayout.setVerticalGroup(
            panelCTHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCTHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCTHD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelCTHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(520, 170, 930, 230);

        btnTRoVe.setBackground(new java.awt.Color(110, 74, 38));
        btnTRoVe.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnTRoVe.setForeground(new java.awt.Color(255, 255, 255));
        btnTRoVe.setText("Trở về");
        btnTRoVe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnTRoVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTRoVeActionPerformed(evt);
            }
        });
        jPanel1.add(btnTRoVe);
        btnTRoVe.setBounds(960, 470, 103, 29);

        btnSangCTHoaDon.setBackground(new java.awt.Color(110, 74, 38));
        btnSangCTHoaDon.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnSangCTHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnSangCTHoaDon.setText("Quản lý chi tiết hóa đơn");
        btnSangCTHoaDon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnSangCTHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSangCTHoaDonActionPerformed(evt);
            }
        });
        jPanel1.add(btnSangCTHoaDon);
        btnSangCTHoaDon.setBounds(700, 470, 220, 29);

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
        btnThoat.setBounds(1100, 470, 107, 29);

        lblchitiethoadon.setFont(new java.awt.Font("Bahnschrift", 1, 20)); // NOI18N
        lblchitiethoadon.setForeground(new java.awt.Color(95, 59, 24));
        lblchitiethoadon.setText("CHI TIẾT HÓA ĐƠN");
        jPanel1.add(lblchitiethoadon);
        lblchitiethoadon.setBounds(910, 120, 220, 40);

        lblthongtinhoadon.setFont(new java.awt.Font("Bahnschrift", 1, 20)); // NOI18N
        lblthongtinhoadon.setForeground(new java.awt.Color(95, 59, 24));
        lblthongtinhoadon.setText("THỐNG KÊ");
        jPanel1.add(lblthongtinhoadon);
        lblthongtinhoadon.setBounds(950, 120, 220, 40);

        lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sweetandspicy_logo.png"))); // NOI18N
        jPanel1.add(lbllogo);
        lbllogo.setBounds(20, 10, 90, 100);

        lblbill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hoadon_icon.png"))); // NOI18N
        jPanel1.add(lblbill);
        lblbill.setBounds(100, 430, 330, 90);

        lblbill1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hoadon1_icon.png"))); // NOI18N
        jPanel1.add(lblbill1);
        lblbill1.setBounds(1310, 60, 140, 100);

        lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hoadon_background.png"))); // NOI18N
        lblbackground.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(lblbackground);
        lblbackground.setBounds(0, 0, 1478, 533);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1478, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaSPActionPerformed

    private void cbThongKeTheoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbThongKeTheoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbThongKeTheoActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        //panelThongKe.setVisible(true);
        if (cbThongKeTheo.getSelectedIndex() == 0) {
            if (txtMaHD.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Mã hóa đơn phải được nhập.");
            } else {
                panelCTHD.setVisible(false);
                panelThongKe.setVisible(true);
                hd = hddao.TimTheoMa(Integer.valueOf(txtMaHD.getText()));
                BangTK.getDataVector().removeAllElements();
                Hang = new Vector();
                Hang.add(hd.getMaHD());
                Hang.add(hd.getMaNV());
                Hang.add(hd.getMaKH());
                Hang.add(hd.getMaKM());
                Hang.add(hd.getNgayTao());
                Hang.add(hd.getThanhTien());
                Hang.add(hd.getGhiChu());
                BangTK.addRow(Hang);
                TableThongKe.setModel(BangTK);
            }
        } else if (cbThongKeTheo.getSelectedIndex() == 1) {
            if (txtMaKH.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Mã khách hàng phải được nhập.");
            } else {
                ArrayList<HoaDon> ds = hddao.TimTheoKH(txtMaKH.getText());
                BangTK.getDataVector().removeAllElements();
                for (int i = 0; i < ds.size(); i++) {
                    Hang = new Vector();
                    hd = ds.get(i);
                    Hang.add(hd.getMaHD());
                    Hang.add(hd.getMaNV());
                    Hang.add(hd.getMaKH());
                    Hang.add(hd.getMaKM());
                    Hang.add(hd.getNgayTao());
                    Hang.add(hd.getThanhTien());
                    Hang.add(hd.getGhiChu());
                    BangTK.addRow(Hang);
                }
                TableThongKe.setModel(BangTK);
                if (ds.size() == 0) {
                    JOptionPane.showMessageDialog(panelThongKe, "Không tìm thầy kết quả phù hợp.");
                }
            }

        } else if (cbThongKeTheo.getSelectedIndex() == 2) {
            if (txtMaNV.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Mã nhân viên phải được nhập.");
            } else {
                ArrayList<HoaDon> ds = hddao.TimTheoNV(txtMaNV.getText());
                BangTK.getDataVector().removeAllElements();
                for (int i = 0; i < ds.size(); i++) {
                    Hang = new Vector();
                    hd = ds.get(i);
                    Hang.add(hd.getMaHD());
                    Hang.add(hd.getMaNV());
                    Hang.add(hd.getMaKH());
                    Hang.add(hd.getMaKM());
                    Hang.add(hd.getNgayTao());
                    Hang.add(hd.getThanhTien());
                    Hang.add(hd.getGhiChu());
                    BangTK.addRow(Hang);
                }
                if (ds.size() == 0) {
                    JOptionPane.showMessageDialog(panelThongKe, "Không tìm thầy kết quả phù hợp.");
                }
                TableThongKe.setModel(BangTK);
            }
        } else if (cbThongKeTheo.getSelectedIndex() == 3) {
            ArrayList<HoaDon> ds = hddao.TimTheoLoai((String) cbLoai.getSelectedItem());
            BangTK.getDataVector().removeAllElements();
            for (int i = 0; i < ds.size(); i++) {
                Hang = new Vector();
                hd = ds.get(i);
                Hang.add(hd.getMaHD());
                Hang.add(hd.getMaNV());
                Hang.add(hd.getMaKH());
                Hang.add(hd.getMaKM());
                Hang.add(hd.getNgayTao());
                Hang.add(hd.getThanhTien());
                Hang.add(hd.getGhiChu());
                BangTK.addRow(Hang);
            }
            if (ds.size() == 0) {
                JOptionPane.showMessageDialog(panelThongKe, "Không tìm thầy kết quả phù hợp.");
            }
            TableThongKe.setModel(BangTK);
        } else if (cbThongKeTheo.getSelectedIndex() == 4) {
            if (txtMaSP.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Mã sản phẩm phải được nhập.");
            } else {
                ArrayList<HoaDon> ds = hddao.TimTheoSP(txtMaSP.getText());
                BangTK.getDataVector().removeAllElements();
                for (int i = 0; i < ds.size(); i++) {
                    Hang = new Vector();
                    hd = ds.get(i);
                    Hang.add(hd.getMaHD());
                    Hang.add(hd.getMaNV());
                    Hang.add(hd.getMaKH());
                    Hang.add(hd.getMaKM());
                    Hang.add(hd.getNgayTao());
                    Hang.add(hd.getThanhTien());
                    Hang.add(hd.getGhiChu());
                    BangTK.addRow(Hang);
                }
                if (ds.size() == 0) {
                    JOptionPane.showMessageDialog(panelThongKe, "Không tìm thầy kết quả phù hợp.");
                }
                TableThongKe.setModel(BangTK);
            }
        } else if (cbThongKeTheo.getSelectedIndex() == 5) {
            TableChiTietHD.setVisible(false);
            TableThongKe.setVisible(true);
            if (txtMaKM.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Mã khuyến mãi phải được nhập.");
            } else {
                ArrayList<HoaDon> ds = hddao.TimTheoKM(txtMaKM.getText());
                BangTK.getDataVector().removeAllElements();
                for (int i = 0; i < ds.size(); i++) {
                    Hang = new Vector();
                    hd = ds.get(i);
                    Hang.add(hd.getMaHD());
                    Hang.add(hd.getMaNV());
                    Hang.add(hd.getMaKH());
                    Hang.add(hd.getMaKM());
                    Hang.add(hd.getNgayTao());
                    Hang.add(hd.getThanhTien());
                    Hang.add(hd.getGhiChu());
                    BangTK.addRow(Hang);
                }
                if (ds.size() == 0) {
                    JOptionPane.showMessageDialog(panelThongKe, "Không tìm thầy kết quả phù hợp.");
                }
                TableThongKe.setModel(BangTK);
            }
        } else {
            TableChiTietHD.setVisible(false);
            TableThongKe.setVisible(true);
            Date date = DateChooser.getDate();
            ArrayList<HoaDon> ds = hddao.TimTheoNgayLap(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(date)));
            BangTK.getDataVector().removeAllElements();
            for (int i = 0; i < ds.size(); i++) {
                Hang = new Vector();
                hd = ds.get(i);
                Hang.add(hd.getMaHD());
                Hang.add(hd.getMaNV());
                Hang.add(hd.getMaKH());
                Hang.add(hd.getMaKM());
                Hang.add(hd.getNgayTao());
                Hang.add(hd.getThanhTien());
                Hang.add(hd.getGhiChu());
                BangTK.addRow(Hang);
            }
            TableThongKe.setModel(BangTK);
            if (ds.size() == 0) {
                JOptionPane.showMessageDialog(panelThongKe, "Không tìm thầy kết quả phù hợp.");
            }
        }


    }//GEN-LAST:event_btnThongKeActionPerformed

    private void cbThongKeTheoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbThongKeTheoItemStateChanged
        if (cbThongKeTheo.getSelectedIndex() == 0) {
            panelThongKeTheoKhach.setVisible(false);
            panelKM.setVisible(false);
            panelLoai.setVisible(false);
            panelMaNV.setVisible(false);
            panelNgayLap.setVisible(false);
            panelTKSp.setVisible(false);
            panelMaHD.setVisible(true);
            btnChiTietHD.setVisible(true);
            panelCTHD.setVisible(true);
            lblchitiethoadon.setVisible(true);
            
            panelThongKe.setVisible(false);
            lblthongtinhoadon.setVisible(false);
        } else if (cbThongKeTheo.getSelectedIndex() == 1) {
            panelThongKeTheoKhach.setVisible(true);
            panelKM.setVisible(false);
            panelLoai.setVisible(false);
            panelMaNV.setVisible(false);
            panelNgayLap.setVisible(false);
            panelTKSp.setVisible(false);
            panelMaHD.setVisible(false);
            btnChiTietHD.setVisible(false);
            panelCTHD.setVisible(false);
            lblchitiethoadon.setVisible(false);
            
            panelThongKe.setVisible(true);
            lblthongtinhoadon.setVisible(true);
        } else if (cbThongKeTheo.getSelectedIndex() == 2) {
            panelThongKeTheoKhach.setVisible(false);
            panelKM.setVisible(false);
            panelLoai.setVisible(false);
            panelMaNV.setVisible(true);
            panelNgayLap.setVisible(false);
            panelTKSp.setVisible(false);
            panelMaHD.setVisible(false);
            btnChiTietHD.setVisible(false);
            TableChiTietHD.setVisible(false);            
            TableThongKe.setVisible(true);
        } else if (cbThongKeTheo.getSelectedIndex() == 3) {
            panelThongKeTheoKhach.setVisible(false);
            panelKM.setVisible(false);
            panelLoai.setVisible(true);
            panelMaNV.setVisible(false);
            panelNgayLap.setVisible(false);
            panelTKSp.setVisible(false);
            panelMaHD.setVisible(false);
            btnChiTietHD.setVisible(false);
            panelCTHD.setVisible(false);
            lblchitiethoadon.setVisible(false);
            panelThongKe.setVisible(true);
            lblthongtinhoadon.setVisible(true);
        } else if (cbThongKeTheo.getSelectedIndex() == 4) {
            panelThongKeTheoKhach.setVisible(false);
            panelKM.setVisible(false);
            panelLoai.setVisible(false);
            panelMaNV.setVisible(false);
            panelNgayLap.setVisible(false);
            panelTKSp.setVisible(true);
            panelMaHD.setVisible(false);
            btnChiTietHD.setVisible(false);
            TableChiTietHD.setVisible(false);
            TableThongKe.setVisible(true);
        } else if (cbThongKeTheo.getSelectedIndex() == 5) {
            panelThongKeTheoKhach.setVisible(false);
            panelKM.setVisible(true);
            panelLoai.setVisible(false);
            panelMaNV.setVisible(false);
            panelNgayLap.setVisible(false);
            panelTKSp.setVisible(false);
            panelMaHD.setVisible(false);
            panelCTHD.setVisible(false);
            lblchitiethoadon.setVisible(false);
            panelThongKe.setVisible(true);
            lblthongtinhoadon.setVisible(true);
            TableThongKe.setVisible(true);
        } else if (cbThongKeTheo.getSelectedIndex() == 6) {
            panelThongKeTheoKhach.setVisible(false);
            panelKM.setVisible(false);
            panelLoai.setVisible(false);
            panelMaNV.setVisible(false);
            panelNgayLap.setVisible(true);
            panelTKSp.setVisible(false);
            panelMaHD.setVisible(false);
            btnChiTietHD.setVisible(false);
            panelCTHD.setVisible(false);
            lblchitiethoadon.setVisible(false);
            panelThongKe.setVisible(true);
            lblthongtinhoadon.setVisible(true);
        }
    }//GEN-LAST:event_cbThongKeTheoItemStateChanged

    private void btnChiTietHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietHDActionPerformed
        if (!txtMaHD.getText().trim().equals("")) {
            panelThongKe.setVisible(false);
            lblthongtinhoadon.setVisible(false);
            panelCTHD.setVisible(true);
            lblchitiethoadon.setVisible(true);
            CTHoaDonDAO ctdao = new CTHoaDonDAO();
            ArrayList<CTHoaDon> ds = ctdao.TimKiemTheoMa(Integer.valueOf(txtMaHD.getText().trim()));
            BangCT.getDataVector().removeAllElements();
            for (int i = 0; i < ds.size(); i++) {
                CTHoaDon ct = ds.get(i);
                Hang = new Vector();
                Hang.add(ct.getMaSP());
                Hang.add(ct.getSize());
                Hang.add(ct.getDonGia());
                Hang.add(ct.getSoLuong());
                System.out.println(ct.getSoLuong());
                Hang.add(ct.getThanhTien());
                BangCT.addRow(Hang);
            }
            TableChiTietHD.setModel(BangCT);
        } else
            JOptionPane.showMessageDialog(panelThongKe, "Mã hóa đơn phải được nhập.");
    }//GEN-LAST:event_btnChiTietHDActionPerformed

    private void btnSangCTHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSangCTHoaDonActionPerformed
        new FormCTHoaDon("QL-0001","").setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnSangCTHoaDonActionPerformed

    private void btnTRoVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTRoVeActionPerformed
        new FormQuanLy().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnTRoVeActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

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
//            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormHoaDon().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DateChooser;
    private javax.swing.JTable TableChiTietHD;
    private javax.swing.JTable TableThongKe;
    private javax.swing.JButton btnChiTietHD;
    private javax.swing.JButton btnSangCTHoaDon;
    private javax.swing.JButton btnTRoVe;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JComboBox<String> cbLoai;
    private javax.swing.JComboBox<String> cbThongKeTheo;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lblbill;
    private javax.swing.JLabel lblbill1;
    private javax.swing.JLabel lblchitiethoadon;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lblthongtinhoadon;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JPanel panelCTHD;
    private javax.swing.JPanel panelKM;
    private javax.swing.JPanel panelLoai;
    private javax.swing.JPanel panelMaHD;
    private javax.swing.JPanel panelMaNV;
    private javax.swing.JPanel panelNgayLap;
    private javax.swing.JPanel panelTKSp;
    private javax.swing.JPanel panelThongKe;
    private javax.swing.JPanel panelThongKeTheoKhach;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaKM;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMaSP;
    // End of variables declaration//GEN-END:variables
}
