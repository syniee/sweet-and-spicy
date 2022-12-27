package View;

import DAO.DoanhThuDAO;
import DAO.LoaiDAO;
import DT.DoanhThu;
import DT.Loai;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class FormDoanhThu extends javax.swing.JFrame {

    DoanhThuDAO dtdao = new DoanhThuDAO();
    DoanhThu dt;
    DefaultTableModel Bang;
    Vector Hang;

    public FormDoanhThu() {
        initComponents();
        Bang = new DefaultTableModel();
        Bang.addColumn("Số lượng bán");
        Bang.addColumn("Tổng doanh thu");
        loadcbLoai();
        panelLoai.setVisible(true);
        panelMaSP.setVisible(false);
        panelTheoKhoangThoiGian.setVisible(false);
        panelTheoNgay.setVisible(false);
        
        setIconImage();
        headerTable();
    }
    
    //title
    private void setIconImage(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/whitess_logo.png")));
    }
    
    //
    public void headerTable(){
        JTableHeader headertb = TableThongKe.getTableHeader();
        headertb.setBackground(new Color(110,55,13));
        headertb.setForeground(new Color(95,59,24));
        headertb.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
    }
    public void scaleImage(){
        //background
        ImageIcon sanpham_background = new ImageIcon(getClass().getResource("/Image/doanhthu_background.png"));
        Image sanpham_img = sanpham_background.getImage();
        Image sanphamImgScale = sanpham_img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon sanphamScaledIcon = new ImageIcon(sanphamImgScale);
        lblbackground.setIcon(sanphamScaledIcon);
        //title
        ImageIcon title_icon = new ImageIcon(getClass().getResource("/Image/doanhthu_title.png"));
        Image title_img = title_icon.getImage();
        Image titleImgScale = title_img.getScaledInstance(lbltitle.getWidth(), lbltitle.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon titleScaledIcon = new ImageIcon(titleImgScale);
        lbltitle.setIcon(titleScaledIcon);
        //logo_icon
        ImageIcon logo_icon = new ImageIcon(getClass().getResource("/Image/sweetandspicy3_logo.png"));
        Image logo_img = logo_icon.getImage();
        Image logoImgScale = logo_img.getScaledInstance(lbllogo.getWidth(), lbllogo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon logoScaledIcon = new ImageIcon(logoImgScale);
        lbllogo.setIcon(logoScaledIcon);
    }
    public void loadcbLoai() {
        LoaiDAO loaidao = new LoaiDAO();
        ArrayList<Loai> ds = loaidao.DSLoaiSP();
        CbLoai.removeAllItems();
        for (int i = 0; i < ds.size(); i++) {
            CbLoai.addItem(ds.get(i).getTenLoai());
        }
    }

    public void hienthi(int sl, float Doanhthu) {

        Bang.getDataVector().removeAllElements();
        Hang = new Vector();
        Hang.add(sl);
        Hang.add(Doanhthu);
        Bang.addRow(Hang);
        TableThongKe.setModel(Bang);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lbltitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        panelLoai = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        CbLoai = new javax.swing.JComboBox<>();
        panelMaSP = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        panelTheoNgay = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        DatChooserNgay = new com.toedter.calendar.JDateChooser();
        panelTheoKhoangThoiGian = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        DateChooserTu = new com.toedter.calendar.JDateChooser();
        DateChooserDen = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableThongKe = new javax.swing.JTable();
        cbThongkeTheo = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnThongKe = new javax.swing.JButton();
        lbllogo = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Doanh thu Sweet&Spicy");
        setResizable(false);

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel1.setLayout(null);

        lbltitle.setFont(new java.awt.Font("Dialog", 0, 41)); // NOI18N
        lbltitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/doanhthu_title.png"))); // NOI18N
        jPanel1.add(lbltitle);
        lbltitle.setBounds(80, 30, 450, 55);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        panelLoai.setBackground(new java.awt.Color(204, 204, 204));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(144, 97, 50));
        jLabel3.setText("Loại sản phẩm");

        CbLoai.setBackground(new java.awt.Color(196, 119, 44));
        CbLoai.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        CbLoai.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelLoaiLayout = new javax.swing.GroupLayout(panelLoai);
        panelLoai.setLayout(panelLoaiLayout);
        panelLoaiLayout.setHorizontalGroup(
            panelLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoaiLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(CbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelLoaiLayout.setVerticalGroup(
            panelLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoaiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLoaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(CbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelMaSP.setBackground(new java.awt.Color(204, 204, 204));

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(144, 97, 50));
        jLabel4.setText("Mã sản phẩm");

        txtMaSP.setBackground(new java.awt.Color(239, 222, 206));
        txtMaSP.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaSP.setForeground(new java.awt.Color(110, 68, 26));
        txtMaSP.setToolTipText("VD: SP1111");
        txtMaSP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout panelMaSPLayout = new javax.swing.GroupLayout(panelMaSP);
        panelMaSP.setLayout(panelMaSPLayout);
        panelMaSPLayout.setHorizontalGroup(
            panelMaSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMaSPLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelMaSPLayout.setVerticalGroup(
            panelMaSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMaSPLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMaSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        panelTheoNgay.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(144, 97, 50));
        jLabel5.setText("Ngày");

        DatChooserNgay.setBackground(new java.awt.Color(169, 134, 98));
        DatChooserNgay.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelTheoNgayLayout = new javax.swing.GroupLayout(panelTheoNgay);
        panelTheoNgay.setLayout(panelTheoNgayLayout);
        panelTheoNgayLayout.setHorizontalGroup(
            panelTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTheoNgayLayout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 96, Short.MAX_VALUE)
                .addComponent(DatChooserNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelTheoNgayLayout.setVerticalGroup(
            panelTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTheoNgayLayout.createSequentialGroup()
                .addGroup(panelTheoNgayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DatChooserNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 8, Short.MAX_VALUE))
        );

        panelTheoKhoangThoiGian.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(144, 97, 50));
        jLabel6.setText("Từ ngày");

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(144, 97, 50));
        jLabel7.setText("Đến ngày");

        DateChooserTu.setBackground(new java.awt.Color(169, 134, 98));
        DateChooserTu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        DateChooserDen.setBackground(new java.awt.Color(169, 134, 98));
        DateChooserDen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        javax.swing.GroupLayout panelTheoKhoangThoiGianLayout = new javax.swing.GroupLayout(panelTheoKhoangThoiGian);
        panelTheoKhoangThoiGian.setLayout(panelTheoKhoangThoiGianLayout);
        panelTheoKhoangThoiGianLayout.setHorizontalGroup(
            panelTheoKhoangThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTheoKhoangThoiGianLayout.createSequentialGroup()
                .addGroup(panelTheoKhoangThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelTheoKhoangThoiGianLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(panelTheoKhoangThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DateChooserTu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DateChooserDen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelTheoKhoangThoiGianLayout.setVerticalGroup(
            panelTheoKhoangThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTheoKhoangThoiGianLayout.createSequentialGroup()
                .addGroup(panelTheoKhoangThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTheoKhoangThoiGianLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTheoKhoangThoiGianLayout.createSequentialGroup()
                        .addComponent(DateChooserTu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(panelTheoKhoangThoiGianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DateChooserDen, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelTheoKhoangThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelTheoKhoangThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(80, 180, 410, 130);

        jButton2.setBackground(new java.awt.Color(110, 74, 38));
        jButton2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Trở về");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(160, 560, 107, 30);

        jButton3.setBackground(new java.awt.Color(110, 74, 38));
        jButton3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Thoát");
        jButton3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(310, 560, 107, 30);

        jScrollPane1.setBackground(new java.awt.Color(204, 204, 204));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setForeground(new java.awt.Color(144, 89, 35));
        jScrollPane1.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N

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

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(80, 410, 410, 114);

        cbThongkeTheo.setBackground(new java.awt.Color(196, 119, 44));
        cbThongkeTheo.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbThongkeTheo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Loại sản phẩm", "Sản phẩm", "Ngày", "Khoảng thời gian" }));
        cbThongkeTheo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        cbThongkeTheo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbThongkeTheoItemStateChanged(evt);
            }
        });
        jPanel1.add(cbThongkeTheo);
        cbThongkeTheo.setBounds(280, 140, 210, 30);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(144, 97, 50));
        jLabel2.setText("Thống kê doanh thu theo");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(40, 140, 230, 30);

        btnThongKe.setBackground(new java.awt.Color(110, 74, 38));
        btnThongKe.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKe.setText("Thống kê");
        btnThongKe.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(169, 134, 98), 3));
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });
        jPanel1.add(btnThongKe);
        btnThongKe.setBounds(230, 330, 107, 30);

        lbllogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sweetandspicy3_logo.png"))); // NOI18N
        jPanel1.add(lbllogo);
        lbllogo.setBounds(10, 10, 60, 80);

        lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/doanhthu_background.png"))); // NOI18N
        lblbackground.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel1.add(lblbackground);
        lblbackground.setBounds(0, 0, 561, 616);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        if (cbThongkeTheo.getSelectedIndex() == 0) {
            dt = dtdao.DoanhThuTheoLoai((String) CbLoai.getSelectedItem());
            if (dt != null) {
                hienthi(dt.getSoluong(), dt.getDoanhthu());
            } else {
                JOptionPane.showMessageDialog(panelTheoNgay, "Không có.");
            }

        } else if (cbThongkeTheo.getSelectedIndex() == 1) {
            if (txtMaSP.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(panelTheoNgay, "Mã sản phẩm phải được nhập");
            } else if (!(txtMaSP.getText().trim().matches("SP\\d{4}"))) {
                JOptionPane.showMessageDialog(panelTheoNgay, "Mã sản phẩm phải đúng định dạng. VD: SP1234");
            } else {
                dt = dtdao.DoanhThuTheoSanPham(txtMaSP.getText().trim());
                if (dt != null) {
                    hienthi(dt.getSoluong(), dt.getDoanhthu());
                } else {
                    JOptionPane.showMessageDialog(panelTheoNgay, "Không tìm thấy.");
                }
            }
        } else if (cbThongkeTheo.getSelectedIndex() == 2) {
            String ngay = new SimpleDateFormat("yyyy-MM-dd").format(DatChooserNgay.getDate());
            dt = dtdao.DoanhThuTheoNgay(ngay);
            if (dt != null) {
                hienthi(dt.getSoluong(), dt.getDoanhthu());
            } else {
                JOptionPane.showMessageDialog(panelTheoNgay, "Không tìm thấy");
            }
        } else if (cbThongkeTheo.getSelectedIndex() == 3) {
            String tungay = new SimpleDateFormat("yyyy-MM-dd").format(DateChooserTu.getDate());
            String denngay = new SimpleDateFormat("yyyy-MM-dd").format(DateChooserDen.getDate());
            dt = dtdao.DTTheoKhoangThoiGian(tungay, denngay);
            if (dt != null) {
                hienthi(dt.getSoluong(), dt.getDoanhthu());
            }
        }

    }//GEN-LAST:event_btnThongKeActionPerformed

    private void cbThongkeTheoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbThongkeTheoItemStateChanged
        if (cbThongkeTheo.getSelectedIndex() == 0) {
            panelLoai.setVisible(true);
            panelMaSP.setVisible(false);
            panelTheoKhoangThoiGian.setVisible(false);
            panelTheoNgay.setVisible(false);
        } else if (cbThongkeTheo.getSelectedIndex() == 1) {
            panelLoai.setVisible(false);
            panelMaSP.setVisible(true);
            panelTheoKhoangThoiGian.setVisible(false);
            panelTheoNgay.setVisible(false);
        } else if (cbThongkeTheo.getSelectedIndex() == 2) {
            panelLoai.setVisible(false);
            panelMaSP.setVisible(false);
            panelTheoKhoangThoiGian.setVisible(false);
            panelTheoNgay.setVisible(true);
        } else {
            panelLoai.setVisible(false);
            panelMaSP.setVisible(false);
            panelTheoKhoangThoiGian.setVisible(true);
            panelTheoNgay.setVisible(false);
        }
    }//GEN-LAST:event_cbThongkeTheoItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new FormQuanLy().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
//            java.util.logging.Logger.getLogger(FormDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormDoanhThu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormDoanhThu().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CbLoai;
    private com.toedter.calendar.JDateChooser DatChooserNgay;
    private com.toedter.calendar.JDateChooser DateChooserDen;
    private com.toedter.calendar.JDateChooser DateChooserTu;
    private javax.swing.JTable TableThongKe;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JComboBox<String> cbThongkeTheo;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lbllogo;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JPanel panelLoai;
    private javax.swing.JPanel panelMaSP;
    private javax.swing.JPanel panelTheoKhoangThoiGian;
    private javax.swing.JPanel panelTheoNgay;
    private javax.swing.JTextField txtMaSP;
    // End of variables declaration//GEN-END:variables
}
