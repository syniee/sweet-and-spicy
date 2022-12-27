package DAO;

import DB.Connect;
import DT.HoaDon;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HoaDonDAO {

    Connect db = new Connect();
    Connection con = db.getConn();
    PreparedStatement pr;
    ResultSet rs;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;
    KhachHangDAO khachdao = new KhachHangDAO();

    public boolean ThemHD(HoaDon hd) {
        try {
            con = db.getConn();
            pr = con.prepareStatement("insert into HoaDon values(?,?,?,?,?,?,?)");
            pr.setInt(1, hd.getMaHD());
            pr.setString(2, hd.getMaNV());
            pr.setString(3, hd.getMaKH());
            pr.setString(4, hd.getMaKM());
            pr.setString(5, hd.getNgayTao().format(dateFormatter));
            pr.setFloat(6, hd.getThanhTien());
            pr.setString(7, hd.getGhiChu());
            if (pr.executeUpdate() > 0) {
                khachdao.CapNhatDoanhThu(hd.getMaKH(), hd.getThanhTien());
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int MaxMa() {
        try {
            pr = con.prepareStatement("select Max(MaHD) from HoaDon");
            rs = pr.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public HoaDon TimTheoMa(int ma) {
        try {
            pr = con.prepareStatement("select * from HoaDon where MaHD=?");
            pr.setInt(1, ma);
            rs = pr.executeQuery();
            if (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaNV(rs.getString(2));
                hd.setMaKH(rs.getString(3));
                hd.setMaKM(rs.getString(4));
                hd.setNgayTao(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate(5))));
                hd.setThanhTien(rs.getFloat(6));
                hd.setGhiChu(rs.getString(7));
                return hd;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<HoaDon> TimTheoNV(String manv) {
        try {
            pr = con.prepareStatement("select * from HoaDon where MaNhanVien=?");
            pr.setString(1, manv);
            rs = pr.executeQuery();
            ArrayList<HoaDon> ds = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaNV(rs.getString(2));
                hd.setMaKH(rs.getString(3));
                hd.setMaKM(rs.getString(4));
                hd.setNgayTao(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate(5))));
                hd.setThanhTien(rs.getFloat(6));
                hd.setGhiChu(rs.getString(7));
                ds.add(hd);
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<HoaDon> TimTheoKH(String makh) {
        try {
            pr = con.prepareStatement("select * from HoaDon where MaKH=?");
            pr.setString(1, makh);
            rs = pr.executeQuery();
            ArrayList<HoaDon> ds = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaNV(rs.getString(2));
                hd.setMaKH(rs.getString(3));
                hd.setMaKM(rs.getString(4));
                hd.setNgayTao(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate(5))));
                hd.setThanhTien(rs.getFloat(6));
                hd.setGhiChu(rs.getString(7));
                ds.add(hd);
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<HoaDon> TimTheoKM(String makm) {
        try {
            pr = con.prepareStatement("select * from HoaDon where MaKM=?");
            pr.setString(1, makm);
            rs = pr.executeQuery();
            ArrayList<HoaDon> ds = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaNV(rs.getString(2));
                hd.setMaKH(rs.getString(3));
                hd.setMaKM(rs.getString(4));
                hd.setNgayTao(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate(5))));
                hd.setThanhTien(rs.getFloat(6));
                hd.setGhiChu(rs.getString(7));
                ds.add(hd);
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<HoaDon> TimTheoSP(String masp) {
        try {
            pr = con.prepareStatement("select * from CTHoaDon join HoaDon on HoaDon.MaHD=CTHoaDon.MaHD where MaSP=? Order by HoaDon.MaHD");
            pr.setString(1, masp);
            rs = pr.executeQuery();
            ArrayList<HoaDon> ds = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt("MaHD"));
                hd.setMaNV(rs.getString("MaNhanVien"));
                hd.setMaKH(rs.getString("MaKH"));
                hd.setMaKM(rs.getString("MaKM"));
                hd.setNgayTao(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("NgayTao"))));
                hd.setThanhTien(rs.getFloat("TongThanhTien"));
                hd.setGhiChu(rs.getString("GhiChu"));
                ds.add(hd);
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<HoaDon> TimTheoLoai(String tenloai) {
        try {
            pr = con.prepareStatement("select MaLoai from Loai where TenLoai=?");
            pr.setString(1, tenloai);
            rs = pr.executeQuery();
            rs.next();
            String maloai = rs.getString(1);

            pr = con.prepareStatement("select * from SanPham join Loai on SanPham.MaLoai=Loai.MaLoai join CTHoaDon on SanPham.MaSP=CTHoaDon.MaSP join HoaDon on HoaDon.MaHD=CTHoaDon.MaHD where Loai.MaLoai=? ORDER BY HoaDon.MaHD");
            pr.setString(1, maloai);
            rs = pr.executeQuery();
            //pr = con.pre
            ArrayList<HoaDon> ds = new ArrayList<>();
            while (rs.next()) {
                int kt = 0;
                HoaDon hd = new HoaDon();
                for (int i = 0; i < ds.size(); i++) {
                    if (ds.get(i).getMaHD() == rs.getInt("MaHD")) {
                        kt = 1;
                    }
                }
                if (kt == 0) {
                    hd.setMaHD(rs.getInt("MaHD"));
                    hd.setMaNV(rs.getString("MaNhanVien"));
                    hd.setMaKH(rs.getString("MaKH"));
                    hd.setMaKM(rs.getString("MaKM"));
                    hd.setNgayTao(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("NgayTao"))));
                    hd.setThanhTien(rs.getFloat("TongThanhTien"));
                    hd.setGhiChu(rs.getString("GhiChu"));
                    ds.add(hd);
                }

            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<HoaDon> TimTheoNgayLap(LocalDate ngay) {
        try {
            pr = con.prepareStatement("select * from HoaDon where NgayTao=?");
            pr.setString(1, ngay.format(dateFormatter));
            rs = pr.executeQuery();
            ArrayList<HoaDon> ds = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaNV(rs.getString(2));
                hd.setMaKH(rs.getString(3));
                hd.setMaKM(rs.getString(4));
                hd.setNgayTao(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate(5))));
                hd.setThanhTien(rs.getFloat(6));
                hd.setGhiChu(rs.getString(7));
                ds.add(hd);
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
        public ArrayList<HoaDon> DSHD() {
        try {
            pr = con.prepareStatement("select * from HoaDon");
            rs = pr.executeQuery();
            ArrayList<HoaDon> ds = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaNV(rs.getString(2));
                hd.setMaKH(rs.getString(3));
                hd.setMaKM(rs.getString(4));
                hd.setNgayTao(LocalDate.parse(new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate(5))));
                hd.setThanhTien(rs.getFloat(6));
                hd.setGhiChu(rs.getString(7));
                ds.add(hd);
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
