package View;

import DAO.NhanVienDAO;
import DT.NhanVien;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FormNhanVien extends javax.swing.JFrame {

    Connection con;
    PreparedStatement pr;
    DB.Connect db = new DB.Connect();
    SimpleDateFormat dinhdangngay = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat dinhdangnam = new SimpleDateFormat("yyyy-MM-dd");

    public final void khongnhapdata() {
        rbtnNam.setEnabled(false);
        rbtnNu.setEnabled(false);
        txtMaNhanVien.setText("");
        txtCMND.setText("");
        txtEmail.setText("");
        txtHoTenNV.setText("");
        txtMaNhanVien.setText("");
        txtMatKhau.setText("");
        txtQueQuan.setText("");
        txtSDT.setText("");
        txtSoGioLam.setText("");
        txtTamTru.setText("");
        txtTenDangNhap.setText("");
        txtTienLuong.setText("");
        
        txtHoTenNV.setEditable(false);
        txtHoTenNV.setBorder(null);
        //txtHoTenNV.setBackground(null);
        txtHoTenNV.setBackground(new Color(229,223,217));
        
        txtCMND.setEditable(false);
        txtCMND.setBorder(null);
        txtCMND.setBackground(new Color(229,223,217));
        
        txtEmail.setEditable(false);
        txtEmail.setBorder(null);
        txtEmail.setBackground(new Color(229,223,217));
        
        txtMatKhau.setEditable(false);
        txtMatKhau.setBorder(null);
        txtMatKhau.setBackground(new Color(229,223,217));
        
        txtQueQuan.setEditable(false);
        txtQueQuan.setBorder(null);
        txtQueQuan.setBackground(new Color(229,223,217));
        
        txtSDT.setEditable(false);
        txtSDT.setBorder(null);
        txtSDT.setBackground(new Color(229,223,217));
        
        txtTamTru.setEditable(false);
        txtTamTru.setBorder(null);
        txtTamTru.setBackground(new Color(229,223,217));
        
        txtTenDangNhap.setEditable(false);
        txtTenDangNhap.setBorder(null);
        txtTenDangNhap.setBackground(new Color(229,223,217));
        
        cbThuong.setSelectedIndex(0);
        txtTienLuong.setEditable(false);
        txtTienLuong.setBorder(null);
        txtTienLuong.setBackground(new Color(229,223,217));
        
        chooseNgaySinh.setEnabled(false);
        chooseNgaySinh.setBorder(null);
        chooseNgaySinh.setBackground(new Color(229,223,217));
        
        
        cbMucLuong.setSelectedIndex(0);
        cbViTriLamViec.setSelectedIndex(0);
        txtSoGioLam.setEditable(false);
        txtSoGioLam.setBorder(null);
        txtSoGioLam.setBackground(new Color(229,223,217));
        
        btnLuu.setEnabled(false);
        btnLuu.setBorder(null);
        btnLuu.setForeground(null);
        
        btnTinhLuong.setEnabled(false);
        btnTinhLuong.setBorder(null);
        btnTinhLuong.setBackground(null);
        btnTinhLuong.setForeground(null);
        
        btnLamMoi.setEnabled(false);
        btnLamMoi.setBorder(null);
        btnLamMoi.setBackground(null);
        btnLamMoi.setForeground(null);
        
        btnThem.setEnabled(true);
        btnThem.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        btnThem.setForeground(new Color(95,59,24));
        btnThem.setBackground(new Color(204,157,110));
        
        cbMucLuong.setEnabled(false);
        cbMucLuong.setBorder(null);
        cbMucLuong.setBackground(null);
        
        cbThuong.setEnabled(false);
        cbThuong.setBorder(null);
        cbThuong.setBackground(null);
        
        cbViTriLamViec.setEnabled(false);
        cbViTriLamViec.setBorder(null);
        cbViTriLamViec.setBackground(null);
        lbShowPW.setVisible(false);
        lbHidePW.setVisible(false);
    }

    public FormNhanVien() {
        initComponents();
        khongnhapdata();
        btnLamMoi.setEnabled(false);
        btnLuu.setEnabled(false);
        btnCapNhat.setEnabled(false);
        btnXoa.setEnabled(false);
        setLocationRelativeTo(null);
        
        
        txtMatKhau.setEchoChar('\u25cf');
        setIconImage();
        scaleImage();
        this.lbHidePW.setVisible(false);
        
    }
    public void scaleImage(){
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
        
        ImageIcon nvbg = new ImageIcon(getClass().getResource("/Image/nhanvien_background.png"));
        Image nvbg_img = nvbg.getImage();
        Image nvbgImgScale = nvbg_img.getScaledInstance(lblbackground.getWidth(), lblbackground.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon nvbgScaledIcon = new ImageIcon(nvbgImgScale);
        lblbackground.setIcon(nvbgScaledIcon);
        
        ImageIcon nv = new ImageIcon(getClass().getResource("/Image/nhanvien_icon.png"));
        Image nv_img = nv.getImage();
        Image nvImgScale = nv_img.getScaledInstance(lblnhanvienimg.getWidth(), lblnhanvienimg.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon nvScaledIcon = new ImageIcon(nvImgScale);
        lblnhanvienimg.setIcon(nvScaledIcon);
        
        
        //thong tin
        ImageIcon ttsp_icon = new ImageIcon(getClass().getResource("/Image/captaikhoan_background.png"));
        Image ttsp_img = ttsp_icon.getImage();
        Image ttspImgScale = ttsp_img.getScaledInstance(lblcaptaikhoan.getWidth(), lblcaptaikhoan.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ttspScaledIcon = new ImageIcon(ttspImgScale);
        lblcaptaikhoan.setIcon(ttspScaledIcon);
        
        //title
        ImageIcon title_icon = new ImageIcon(getClass().getResource("/Image/nhanvien_title.png"));
        Image title_img = title_icon.getImage();
        Image titleImgScale = title_img.getScaledInstance(lbltitle.getWidth(), lbltitle.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon titleScaledIcon = new ImageIcon(titleImgScale);
        lbltitle.setIcon(titleScaledIcon);
    }
    private void setIconImage(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Image/whitess_logo.png")));
    }
    public void chophepnhapdata() {
        
        txtMaNhanVien.setEditable(true);
        txtMaNhanVien.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        txtMaNhanVien.setBackground(new Color(229,223,217));
        
        txtHoTenNV.setEditable(true);
        txtHoTenNV.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        txtHoTenNV.setBackground(new Color(229,223,217));
        
        txtCMND.setEditable(true);
        txtCMND.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        txtCMND.setBackground(new Color(229,223,217));
        
        txtEmail.setEditable(true);
        txtEmail.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        txtEmail.setBackground(new Color(229,223,217));
        
        txtMatKhau.setEditable(true);
        txtMatKhau.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        txtMatKhau.setBackground(new Color(229,223,217));
        
        txtQueQuan.setEditable(true);
        txtQueQuan.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        txtQueQuan.setBackground(new Color(229,223,217));
        
        txtSDT.setEditable(true);
        txtSDT.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        txtSDT.setBackground(new Color(229,223,217));
        
        txtTamTru.setEditable(true);
        txtTamTru.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        txtTamTru.setBackground(new Color(229,223,217));
        
        txtTenDangNhap.setEditable(true);
        txtTenDangNhap.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        txtTenDangNhap.setBackground(new Color(229,223,217));
        
        cbThuong.setSelectedIndex(0);
        cbThuong.setBorder(BorderFactory.createLineBorder(new Color(169, 134, 98), 3, true));
        cbThuong.setBackground(new Color(196,119,44));
        
        txtTienLuong.setEditable(true);
        txtTienLuong.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        txtTienLuong.setBackground(new Color(229,223,217));
        
        cbMucLuong.setSelectedIndex(0);
        cbMucLuong.setBorder(BorderFactory.createLineBorder(new Color(169, 134, 98), 3, true));
        cbMucLuong.setBackground(new Color(196,119,44));
        
        cbViTriLamViec.setSelectedIndex(0);
        cbViTriLamViec.setBorder(BorderFactory.createLineBorder(new Color(169, 134, 98), 3, true));
        cbViTriLamViec.setBackground(new Color(196,119,44));
        
        txtSoGioLam.setEditable(true);
        txtSoGioLam.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        txtSoGioLam.setBackground(new Color(229,223,217));
        btnLuu.setEnabled(true);
        btnLuu.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        btnLuu.setForeground(new Color(95,59,24));
        btnLuu.setBackground(new Color(204,157,110));
        
        
        btnTinhLuong.setEnabled(true);
        btnTinhLuong.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        btnTinhLuong.setForeground(new Color(95,59,24));
        btnTinhLuong.setBackground(new Color(204,157,110));
        
        cbMucLuong.setEnabled(true);
        cbMucLuong.setBorder(BorderFactory.createLineBorder(new Color(169, 134, 98), 3, true));
        cbMucLuong.setBackground(new Color(196,119,44));
        
        cbThuong.setEnabled(true);
        cbThuong.setBorder(BorderFactory.createLineBorder(new Color(169, 134, 98), 3, true));
        cbThuong.setBackground(new Color(196,119,44));
        
        cbViTriLamViec.setEnabled(true);
        cbViTriLamViec.setBorder(BorderFactory.createLineBorder(new Color(169, 134, 98), 3, true));
        cbViTriLamViec.setBackground(new Color(196,119,44));
        
        chooseNgaySinh.setBorder(BorderFactory.createLineBorder(new Color(169, 134, 98), 3, true));
        chooseNgaySinh.setBackground(new Color(169, 134, 98));
        
        rbtnNam.setEnabled(true);
        rbtnNu.setEnabled(true);
        lbShowPW.setVisible(true);
        
    }

    public boolean kiemtra() {
        StringBuilder baoloi = new StringBuilder();
        if (txtMaNhanVien.getText().trim().equals("")) {
            baoloi.append("Mã nhân viên phải được nhập\n");
        } else if (!txtMaNhanVien.getText().matches("NV\\d{4}$")) {
            baoloi.append("Mã nhân viên không đúng dịnh dạng. VD: NV1234\n");
        }

        if (txtHoTenNV.getText().trim().equals("")) {
            baoloi.append("Họ tên nhân viên phải được nhập.\n");
        }

        if (dinhdangnam.format(chooseNgaySinh.getDate()).compareTo("2003/01/01") >= 0) {
            baoloi.append("Tuổi của nhân viên phải lớn hơn 18 tuổi.\n");
        }
        String cmnd = txtCMND.getText();
        if (cmnd.trim().equals("")) {
            baoloi.append("Số CMND/CCCD phải được nhập.\n");
        } else if (!(cmnd.matches("-?\\d+(\\.\\d+)?"))) {
            baoloi.append("Số CMND/CCCD phải là số.\n");
        } else if (cmnd.length() != 9) {
                if( cmnd.length() != 12){
                     baoloi.append("Số CMND/CCCD phải là số có 9 hoặc 12 chữ số.\n");
                }
            }
        if (txtQueQuan.getText().trim().equals("")) {
            baoloi.append("Quê quán phải được nhập.\n");
        }
        if (txtTamTru.getText().trim().equals("")) {
            baoloi.append("Địa chỉ tạm trú phải được nhập.\n");
        }
        if (!(txtSDT.getText().matches("-?\\d+(\\.\\d+)?"))) {
            baoloi.append("Số điện thoại phải là số.\n");
        } else if ((txtSDT.getText().trim().equals("")) || (txtSDT.getText().length() < 10)) {
            baoloi.append("Số điện thoại phải có ít nhất 10 chứ số.\n");
        }
        if (txtEmail.getText().trim().equals("")) {
            baoloi.append("Email phải được nhập.\n");
        } else if (!txtEmail.getText().trim().matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
            baoloi.append("Email phải được nhập đúng định dạng.\n");
        }

        if (txtTenDangNhap.getText().trim().equals("")) {
            baoloi.append("Tên đăng nhập phải được nhập.\n");
        }
        if ((txtMatKhau.getText().trim().equals("")) || (txtMatKhau.getText().length() < 8)) {
            baoloi.append("Mật khẩu phải được nhập và có ít nhất 8.\n");
        }

        if (baoloi.length() > 0) {
            JOptionPane.showMessageDialog(rootPane, baoloi);
            return false;
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaNhanVien = new javax.swing.JTextField();
        chooseNgaySinh = new com.toedter.calendar.JDateChooser();
        txtCMND = new javax.swing.JTextField();
        txtQueQuan = new javax.swing.JTextField();
        txtTamTru = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtHoTenNV = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        txtMatKhau = new javax.swing.JPasswordField();
        lbShowPW = new javax.swing.JLabel();
        lbHidePW = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lblcaptaikhoan = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        cbMucLuong = new javax.swing.JComboBox<>();
        txtSoGioLam = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cbViTriLamViec = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtTienLuong = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        btnTinhLuong = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        cbThuong = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        rbtnNam = new javax.swing.JRadioButton();
        rbtnNu = new javax.swing.JRadioButton();
        btnThoat = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        lbltitle = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lblnhanvienimg = new javax.swing.JLabel();
        lblbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nhân viên Sweet&Spicy");
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(144, 97, 50));
        jLabel2.setText("Mã nhân viên");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 130, 120, 30);

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(144, 97, 50));
        jLabel3.setText("Họ và tên");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 180, 108, 30);

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(144, 97, 50));
        jLabel4.setText("Ngày sinh");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(30, 260, 108, 30);

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(144, 97, 50));
        jLabel5.setText("Số CMND/CCCD");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(30, 310, 140, 30);

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(144, 97, 50));
        jLabel6.setText("Quên quán");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 370, 108, 30);

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(144, 97, 50));
        jLabel7.setText("Địa chỉ tạm trú");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 440, 140, 30);

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(144, 97, 50));
        jLabel8.setText("Số điện thoại");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 510, 120, 30);

        jLabel9.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(144, 97, 50));
        jLabel9.setText("Địa chỉ Email");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 560, 120, 30);

        jLabel10.setFont(new java.awt.Font("Bahnschrift", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(95, 59, 24));
        jLabel10.setText("THÔNG TIN CÁ NHÂN");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(160, 80, 240, 35);

        txtMaNhanVien.setBackground(new java.awt.Color(229, 223, 217));
        txtMaNhanVien.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtMaNhanVien.setForeground(new java.awt.Color(110, 68, 26));
        txtMaNhanVien.setToolTipText("VD: NV1111");
        txtMaNhanVien.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 134, 98), 3, true));
        txtMaNhanVien.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                txtMaNhanVienMouseMoved(evt);
            }
        });
        txtMaNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtMaNhanVienMouseExited(evt);
            }
        });
        txtMaNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNhanVienActionPerformed(evt);
            }
        });
        txtMaNhanVien.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaNhanVienKeyPressed(evt);
            }
        });
        jPanel1.add(txtMaNhanVien);
        txtMaNhanVien.setBounds(200, 130, 190, 30);

        chooseNgaySinh.setBackground(new java.awt.Color(169, 134, 98));
        chooseNgaySinh.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        jPanel1.add(chooseNgaySinh);
        chooseNgaySinh.setBounds(200, 260, 347, 30);

        txtCMND.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtCMND.setForeground(new java.awt.Color(110, 68, 26));
        jPanel1.add(txtCMND);
        txtCMND.setBounds(200, 310, 250, 30);

        txtQueQuan.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtQueQuan.setForeground(new java.awt.Color(110, 68, 26));
        jPanel1.add(txtQueQuan);
        txtQueQuan.setBounds(200, 350, 347, 62);

        txtTamTru.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtTamTru.setForeground(new java.awt.Color(110, 68, 26));
        txtTamTru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTamTruActionPerformed(evt);
            }
        });
        jPanel1.add(txtTamTru);
        txtTamTru.setBounds(200, 430, 347, 59);

        txtSDT.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtSDT.setForeground(new java.awt.Color(110, 68, 26));
        jPanel1.add(txtSDT);
        txtSDT.setBounds(200, 510, 250, 30);

        txtEmail.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(110, 68, 26));
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });
        jPanel1.add(txtEmail);
        txtEmail.setBounds(200, 560, 347, 30);

        txtHoTenNV.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtHoTenNV.setForeground(new java.awt.Color(110, 68, 26));
        jPanel1.add(txtHoTenNV);
        txtHoTenNV.setBounds(200, 180, 260, 30);

        btnThem.setBackground(new java.awt.Color(204, 157, 110));
        btnThem.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(95, 59, 24));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/addstaff_icon.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 134, 98), 3, true));
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThem.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnThem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem);
        btnThem.setBounds(30, 620, 107, 78);

        btnXoa.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete_icon.png"))); // NOI18N
        btnXoa.setText("Xóa ");
        btnXoa.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXoa.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnXoa.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa);
        btnXoa.setBounds(410, 620, 107, 78);

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
        btnCapNhat.setBounds(280, 620, 107, 78);

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
        jPanel1.add(btnLuu);
        btnLuu.setBounds(150, 620, 107, 78);

        btnTimKiem.setBackground(new java.awt.Color(204, 157, 110));
        btnTimKiem.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(95, 59, 24));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/find_icon.png"))); // NOI18N
        btnTimKiem.setText("Tìm");
        btnTimKiem.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 134, 98), 3, true));
        btnTimKiem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        btnTimKiem.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        jPanel1.add(btnTimKiem);
        btnTimKiem.setBounds(460, 125, 90, 40);

        jPanel2.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(163, 108, 52));
        jLabel11.setText("Tên đăng nhập tài khoản ");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(10, 62, 216, 22);

        jLabel12.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(163, 108, 52));
        jLabel12.setText("Mật khẩu");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(10, 110, 142, 31);

        txtTenDangNhap.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtTenDangNhap.setForeground(new java.awt.Color(110, 68, 26));
        txtTenDangNhap.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(txtTenDangNhap);
        txtTenDangNhap.setBounds(230, 60, 140, 31);

        txtMatKhau.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtMatKhau.setForeground(new java.awt.Color(110, 68, 26));
        txtMatKhau.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauActionPerformed(evt);
            }
        });
        jPanel2.add(txtMatKhau);
        txtMatKhau.setBounds(230, 105, 140, 31);

        lbShowPW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/show_icon.png"))); // NOI18N
        lbShowPW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbShowPWMousePressed(evt);
            }
        });
        jPanel2.add(lbShowPW);
        lbShowPW.setBounds(380, 105, 40, 30);

        lbHidePW.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hide_icon.png"))); // NOI18N
        lbHidePW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbHidePWMousePressed(evt);
            }
        });
        jPanel2.add(lbHidePW);
        lbHidePW.setBounds(380, 105, 40, 30);

        jLabel18.setFont(new java.awt.Font("Bahnschrift", 1, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(95, 59, 24));
        jLabel18.setText("CẤP TÀI KHOẢN");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(140, 6, 200, 40);

        lblcaptaikhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/captaikhoan_background.png"))); // NOI18N
        lblcaptaikhoan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.add(lblcaptaikhoan);
        lblcaptaikhoan.setBounds(0, 0, 434, 150);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(590, 70, 434, 150);

        jLabel15.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(144, 97, 50));
        jLabel15.setText("Mức lương");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(610, 310, 130, 31);

        jLabel16.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(144, 97, 50));
        jLabel16.setText("Số giờ làm việc");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(610, 360, 140, 31);

        cbMucLuong.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbMucLuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10000", "12000", "15000", "14000", " " }));
        jPanel1.add(cbMucLuong);
        cbMucLuong.setBounds(855, 310, 166, 30);

        txtSoGioLam.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtSoGioLam.setForeground(new java.awt.Color(110, 68, 26));
        jPanel1.add(txtSoGioLam);
        txtSoGioLam.setBounds(855, 360, 166, 30);

        jLabel13.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(144, 97, 50));
        jLabel13.setText("Vị trí làm việc");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(610, 260, 140, 23);

        cbViTriLamViec.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbViTriLamViec.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phục vụ", "Pha chế", "Đầu bếp", "Phụ bếp", "Bảo vệ", "Tiếp thực" }));
        jPanel1.add(cbViTriLamViec);
        cbViTriLamViec.setBounds(855, 260, 166, 30);

        jLabel14.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(144, 97, 50));
        jLabel14.setText("Thưởng");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(610, 410, 70, 31);

        txtTienLuong.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        txtTienLuong.setForeground(new java.awt.Color(110, 68, 26));
        jPanel1.add(txtTienLuong);
        txtTienLuong.setBounds(855, 470, 166, 31);

        jLabel17.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(144, 97, 50));
        jLabel17.setText("Tiền lương");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(750, 470, 100, 31);

        btnTinhLuong.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnTinhLuong.setText("Tính lương");
        btnTinhLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhLuongActionPerformed(evt);
            }
        });
        jPanel1.add(btnTinhLuong);
        btnTinhLuong.setBounds(610, 470, 120, 29);

        btnLamMoi.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanel1.add(btnLamMoi);
        btnLamMoi.setBounds(210, 710, 107, 30);

        cbThuong.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        cbThuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50" }));
        cbThuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbThuongActionPerformed(evt);
            }
        });
        jPanel1.add(cbThuong);
        cbThuong.setBounds(855, 410, 70, 33);

        jLabel19.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(144, 97, 50));
        jLabel19.setText("Giới tính");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(30, 220, 108, 32);

        buttonGroup1.add(rbtnNam);
        rbtnNam.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        rbtnNam.setForeground(new java.awt.Color(144, 97, 50));
        rbtnNam.setSelected(true);
        rbtnNam.setText("Nam");
        jPanel1.add(rbtnNam);
        rbtnNam.setBounds(200, 220, 70, 27);

        buttonGroup1.add(rbtnNu);
        rbtnNu.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        rbtnNu.setForeground(new java.awt.Color(144, 97, 50));
        rbtnNu.setText("Nữ");
        jPanel1.add(rbtnNu);
        rbtnNu.setBounds(320, 220, 51, 27);

        btnThoat.setBackground(new java.awt.Color(110, 74, 38));
        btnThoat.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        btnThoat.setForeground(new java.awt.Color(255, 255, 255));
        btnThoat.setText("Thoát");
        btnThoat.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 134, 98), 3, true));
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });
        jPanel1.add(btnThoat);
        btnThoat.setBounds(850, 710, 107, 30);

        jButton1.setBackground(new java.awt.Color(110, 74, 38));
        jButton1.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Trở về");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(169, 134, 98), 3, true));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(670, 710, 107, 30);

        lbltitle.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        lbltitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nhanvien_title.png"))); // NOI18N
        jPanel1.add(lbltitle);
        lbltitle.setBounds(350, 10, 410, 50);

        jLabel20.setFont(new java.awt.Font("Bahnschrift", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(144, 97, 50));
        jLabel20.setText("% Lương");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(940, 410, 80, 33);

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sweetandspicy2_logo.png"))); // NOI18N
        jPanel1.add(jLabel21);
        jLabel21.setBounds(20, 10, 70, 90);

        lblnhanvienimg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nhanvien_icon.png"))); // NOI18N
        jPanel1.add(lblnhanvienimg);
        lblnhanvienimg.setBounds(610, 540, 420, 140);

        lblbackground.setForeground(new java.awt.Color(144, 97, 50));
        lblbackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/nhanvien_background.png"))); // NOI18N
        lblbackground.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(lblbackground);
        lblbackground.setBounds(0, 0, 1051, 758);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        chophepnhapdata();
        btnTimKiem.setEnabled(false);
        btnTimKiem.setBorder(null);
        btnTimKiem.setForeground(null);
        btnLamMoi.setEnabled(true);
        btnLamMoi.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        btnLamMoi.setForeground(new Color(255,255,255));
        btnLamMoi.setBackground(new Color(110,74,38));
        
        txtTenDangNhap.setEnabled(true);
        txtTenDangNhap.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        txtTenDangNhap.setBackground(new Color(229,223,217));
        
        rbtnNam.setEnabled(true);
        rbtnNu.setEnabled(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        khongnhapdata();
        btnTimKiem.setEnabled(true);
        btnTimKiem.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        btnTimKiem.setForeground(new Color(95,59,24));
        
        btnLuu.setEnabled(false);
        btnLuu.setBorder(null);
        btnLuu.setBackground(null);
        
        btnThem.setEnabled(true);
        btnThem.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
        btnThem.setForeground(new Color(95,59,24));
        
        btnCapNhat.setEnabled(false);
        btnCapNhat.setBorder(null);
        btnCapNhat.setBackground(null);
        btnCapNhat.setForeground(null);
        
        btnXoa.setEnabled(false);
        btnXoa.setBorder(null);
        btnXoa.setBackground(null);
        btnXoa.setForeground(null);
        //chooseNgaySinh.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
        
        //cbTimKIem.setFont(new Font(Font.DIALOG, Font.PLAIN, 18));
    }//GEN-LAST:event_btnLamMoiActionPerformed
    /// TÍNH LƯƠNG CHO NHÂN VIÊN
    public float tinhluong() {
        if (!txtSoGioLam.getText().trim().equals("")) {
            float sogio, mucluong, Tienluong, thuong;
            sogio = Float.valueOf(txtSoGioLam.getText());
            mucluong = Float.valueOf((String) cbMucLuong.getSelectedItem());
            thuong = Float.valueOf((String) cbThuong.getSelectedItem());
            Tienluong = (sogio * mucluong) + (((thuong / 100)) * (sogio * mucluong));
            return Tienluong;
        }
        return 0;

    }
    private void btnTinhLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhLuongActionPerformed
        txtTienLuong.setText(String.valueOf(tinhluong()));
    }//GEN-LAST:event_btnTinhLuongActionPerformed

    // button Cập nhật thông tin nhân viên
    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        int check = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn cập nhật thông tin nhân viên đã chọn?");
        con = db.getConn();
        if (kiemtra()) {
            if (check != 1) {
                NhanVienDAO nvd = new NhanVienDAO();
                NhanVien nv = new NhanVien();
                nv.setMaNV(txtMaNhanVien.getText());
                nv.setHoTen(txtHoTenNV.getText());
                nv.setMatKhau(txtMatKhau.getText());
                if (rbtnNam.isSelected()) {
                    nv.setGioitinh(true);
                } else {
                    nv.setGioitinh(false);
                }
                nv.setNgaysinh(chooseNgaySinh.getDate());
                nv.setCMND(txtCMND.getText());
                nv.setQuequan(txtQueQuan.getText());
                nv.setDiachi(txtTamTru.getText());
                nv.setSDT(txtSDT.getText());
                nv.setMail(txtEmail.getText());
                nv.setVitri((String) cbViTriLamViec.getSelectedItem());
                float mucluong = Float.valueOf((String) cbMucLuong.getSelectedItem());
                nv.setMucluong(mucluong);
                nv.setThuong(Float.valueOf((String) cbThuong.getSelectedItem()));
                nv.setGiolam(Float.parseFloat(txtSoGioLam.getText()));
                if (txtTienLuong.getText().trim().equals("")) {
                    nv.setLuong(0);
                } else {
                    nv.setLuong(Float.valueOf(txtTienLuong.getText()));
                }
                if (nvd.CapNhatNV(nv) == true) {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật nhân viên thành công");
                    khongnhapdata();
                    btnThem.setEnabled(true);
                    btnThem.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
                    btnThem.setForeground(new Color(95,59,24));
                    btnThem.setBackground(new Color(204,157,110));
        
                    btnCapNhat.setEnabled(false);
                    btnCapNhat.setBorder(null);
                    btnCapNhat.setBackground(null);
                    btnCapNhat.setForeground(null);
                    
                    btnLuu.setEnabled(false);
                    btnLuu.setBorder(null);
                    btnLuu.setBackground(null);
                    btnLuu.setForeground(null);
                    
                    btnXoa.setEnabled(false);
                    btnXoa.setBorder(null);
                    btnXoa.setBackground(null);
                    btnXoa.setForeground(null);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Cập nhật không thành công!");
                }
            }

        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    // Lưu có tác dụng khi người dùng chọn buuton thêm
    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        NhanVienDAO nvd = new NhanVienDAO();
        NhanVien nv = new NhanVien();
        if (nvd.TimKiemNV(txtMaNhanVien.getText()) == null) {
            if (kiemtra() == true) {

                nv.setMaNV(txtMaNhanVien.getText());
                nv.setHoTen(txtHoTenNV.getText());
                nv.setMatKhau(txtMatKhau.getText());
                if (rbtnNam.isSelected()) {
                    nv.setGioitinh(true);
                } else {
                    nv.setGioitinh(false);
                }
                nv.setNgaysinh(chooseNgaySinh.getDate());
                nv.setCMND(txtCMND.getText());
                nv.setQuequan(txtQueQuan.getText());
                nv.setDiachi(txtTamTru.getText());
                nv.setSDT(txtSDT.getText());
                nv.setMail(txtEmail.getText());
                nv.setVitri((String) cbViTriLamViec.getSelectedItem());
                nv.setMucluong(Float.parseFloat(((String) cbMucLuong.getSelectedItem())));
                nv.setThuong(Float.parseFloat((String) cbThuong.getSelectedItem()));
                if (!txtSoGioLam.getText().trim().equals("")) {
                    nv.setGiolam(Float.parseFloat(txtSoGioLam.getText()));
                } else {
                    nv.setGiolam(0);
                }
                if (txtTienLuong.getText().trim().equals("")) {
                    nv.setLuong(0);
                } else {
                    nv.setLuong(Float.valueOf(txtTienLuong.getText()));
                }
                if (nvd.ThemVN(nv) == true) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm nhân viên mới thành công");
                    khongnhapdata();
                    btnTimKiem.setEnabled(true);
                    btnTimKiem.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
                    btnTimKiem.setForeground(new Color(95,59,24));
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Thêm không thành công!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Mã nhân viên " + txtMaNhanVien.getText() + "đã tồn tại. Vui lòng chọn mã nhân viên khác.");
        }

    }//GEN-LAST:event_btnLuuActionPerformed

    // Tìm kiếm thông tin nhân viên dựa trên mã nhân viên
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String ma = txtMaNhanVien.getText();
        NhanVien nv = new NhanVien();
        NhanVienDAO nvd = new NhanVienDAO();
        nv = nvd.TimKiemNV(ma);
        if (nv != null) {
            chophepnhapdata();
            btnLuu.setEnabled(false);
            btnLuu.setBorder(null);
            btnLuu.setBackground(null);
            btnLuu.setForeground(null);
            
            btnCapNhat.setEnabled(true);
            btnCapNhat.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
            btnCapNhat.setForeground(new Color(95,59,24));
            btnCapNhat.setBackground(new Color(204,157,110));
        
            btnLamMoi.setEnabled(true);
            btnLamMoi.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
            btnLamMoi.setForeground(new Color(255,255,255));
            btnLamMoi.setBackground(new Color(110,74,38));
            
            btnXoa.setEnabled(true);
            btnXoa.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
            btnXoa.setForeground(new Color(95,59,24));
            btnXoa.setBackground(new Color(204,157,110));
            
            btnThem.setEnabled(false);
            btnThem.setBorder(null);
            btnThem.setBackground(null);
            btnThem.setForeground(null);
            
            btnTinhLuong.setEnabled(true);
            btnTinhLuong.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
            btnTinhLuong.setForeground(new Color(95,59,24));
            btnTinhLuong.setBackground(new Color(204,157,110));
        
            cbMucLuong.setEnabled(true);
            cbThuong.setEnabled(true);
            cbViTriLamViec.setEnabled(true);
            txtSoGioLam.setEditable(true);
            txtTenDangNhap.setEnabled(true);
            // hien thi thong tin nhan vien ra man hinh
            txtMatKhau.setText(nv.getMatKhau());
            txtHoTenNV.setText(nv.getHoTen());
            if (nv.getGioitinh() == true) {
                rbtnNam.setSelected(true);
            } else {
                rbtnNu.setSelected(true);
            }
            chooseNgaySinh.setDate(nv.getNgaysinh());
            txtCMND.setText(nv.getCMND());
            txtQueQuan.setText(nv.getQuequan());
            txtTamTru.setText(nv.getDiachi());
            txtSDT.setText(nv.getSDT());
            txtEmail.setText(nv.getMail());
            txtTenDangNhap.setText(nv.getMaNV());
            txtTienLuong.setText(String.valueOf(nv.getLuong()));
            cbMucLuong.getModel().setSelectedItem(String.valueOf(nv.getMucluong()));
            txtSoGioLam.setText(String.valueOf(nv.getGiolam()));
            cbThuong.getModel().setSelectedItem(String.valueOf(nv.getThuong()).trim());
            cbViTriLamViec.getModel().setSelectedItem(nv.getVitri());
            JOptionPane.showMessageDialog(rootPane, "Tìm thấy nhân viên.");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Không tìm thấy nhân viên có mã " + ma);
        }

    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void txtMaNhanVienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaNhanVienKeyPressed
        if (!txtMaNhanVien.getText().trim().equals("")) {
            if (txtMaNhanVien.getText().matches("MC-\\d{4}$")) {
                if (txtTenDangNhap.isEnabled() == true) {
                    txtTenDangNhap.setText(txtMaNhanVien.getText());
                }
            }
        }
    }//GEN-LAST:event_txtMaNhanVienKeyPressed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int xacnhan = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa nhân viên đã chọn?");
        if (xacnhan != 1) {
            NhanVienDAO nvd = new NhanVienDAO();

            if ((nvd.XoaNV(txtMaNhanVien.getText())) == true) {
                JOptionPane.showMessageDialog(rootPane, "Xóa nhân viên thành công.");
                btnCapNhat.setEnabled(false);
                btnCapNhat.setBorder(null);
                btnCapNhat.setBackground(null);
                btnCapNhat.setForeground(null);
                
                btnLuu.setEnabled(false);
                btnLuu.setBorder(null);
                btnLuu.setBackground(null);
                btnLuu.setForeground(null);
                
                btnThem.setEnabled(true);
                btnThem.setBorder(BorderFactory.createLineBorder(new Color(169,134,98), 3));
                btnThem.setForeground(new Color(95,59,24));
                btnThem.setBackground(new Color(204,157,110));
                
                btnXoa.setEnabled(false);
                btnXoa.setBorder(null);
                btnXoa.setBackground(null);
                btnXoa.setForeground(null);
                khongnhapdata();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Xóa nhân viên không thành công!");
            }

        }


    }//GEN-LAST:event_btnXoaActionPerformed

    private void txtMaNhanVienMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaNhanVienMouseMoved
        if (txtTenDangNhap.isEnabled() == false)
            txtTenDangNhap.setText(txtMaNhanVien.getText());
    }//GEN-LAST:event_txtMaNhanVienMouseMoved

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtMaNhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMaNhanVienMouseExited
        if (!txtMaNhanVien.getText().trim().equals("")) {
            if (txtMaNhanVien.getText().matches("NV\\d{4}$")) {
                if (txtTenDangNhap.isEnabled() == true) {
                    txtTenDangNhap.setText(txtMaNhanVien.getText());
                }
            }
        }
    }//GEN-LAST:event_txtMaNhanVienMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new FormQuanLy().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauActionPerformed

    private void txtMaNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNhanVienActionPerformed

    private void txtTamTruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTamTruActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTamTruActionPerformed
    //show
    private void lbShowPWMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbShowPWMousePressed
        // TODO add your handling code here:
        lbHidePW.setVisible(true);
        lbShowPW.setVisible(false);
        txtMatKhau.setEchoChar((char)0);
    }//GEN-LAST:event_lbShowPWMousePressed

    private void lbHidePWMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHidePWMousePressed
        // TODO add your handling code here:
        lbShowPW.setVisible(true);
        lbHidePW.setVisible(false);
        txtMatKhau.setEchoChar('\u25cf');
    }//GEN-LAST:event_lbHidePWMousePressed

    private void cbThuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbThuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbThuongActionPerformed

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
//            java.util.logging.Logger.getLogger(FormNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FormNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FormNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FormNhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FormNhanVien().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTinhLuong;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbMucLuong;
    private javax.swing.JComboBox<String> cbThuong;
    private javax.swing.JComboBox<String> cbViTriLamViec;
    private com.toedter.calendar.JDateChooser chooseNgaySinh;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbHidePW;
    private javax.swing.JLabel lbShowPW;
    private javax.swing.JLabel lblbackground;
    private javax.swing.JLabel lblcaptaikhoan;
    private javax.swing.JLabel lblnhanvienimg;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JRadioButton rbtnNam;
    private javax.swing.JRadioButton rbtnNu;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTenNV;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtQueQuan;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSoGioLam;
    private javax.swing.JTextField txtTamTru;
    private javax.swing.JTextField txtTenDangNhap;
    private javax.swing.JTextField txtTienLuong;
    // End of variables declaration//GEN-END:variables


}
