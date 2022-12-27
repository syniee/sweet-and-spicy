package DAO;

import DT.KhachHang;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhachHangDAO {

    Connection con;
    DB.Connect db = new DB.Connect();
    PreparedStatement pr;
    ResultSet rs;

    public ArrayList<KhachHang> danhsachKH() {
        ArrayList<KhachHang> ds = new ArrayList<>();
        con = db.getConn();
        try {
            pr = con.prepareStatement("select * from KhachHang");
            rs = pr.executeQuery();
            while (rs.next()) {
                KhachHang khach = new KhachHang();
                khach.setMaHK(rs.getString("MaKH"));
                khach.setHoten(rs.getString("HoTen"));
                khach.setGioitinh(rs.getBoolean("GioiTinh"));
                khach.setSDT(rs.getString("SDT"));
                khach.setTongdoanhthu(rs.getFloat("DoanhThu"));
                ds.add(khach);
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public KhachHang TimKiemKH(String ma) {
        con = db.getConn();
        try {
            pr = con.prepareStatement("select * from KhachHang where MaKH=?");
            pr.setString(1, ma);
            rs = pr.executeQuery();
            if (rs.next()) {
                KhachHang khach = new KhachHang();
                khach.setMaHK(rs.getString("MaKH"));
                khach.setHoten(rs.getString("HoTen"));
                khach.setGioitinh(rs.getBoolean("GioiTinh"));
                khach.setSDT(rs.getString("SDT"));
                khach.setTongdoanhthu(rs.getFloat("DoanhThu"));
                return khach;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean ThemKH(KhachHang khach) {
        con = db.getConn();
        try {
            pr = con.prepareStatement("insert into KhachHang values(?,?,?,?,?)");
            pr.setString(1, khach.getMaHK());
            pr.setString(2, khach.getHoten());
            pr.setBoolean(3, khach.getGioitinh());
            pr.setString(4, khach.getSDT());
            pr.setFloat(5, khach.getTongdoanhthu());
            if (pr.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean CapNhatKH(KhachHang khach) {
        con = db.getConn();
        try {
            pr = con.prepareStatement("update KhachHang set HoTen=?, GioiTinh=?, SDT=?, Doanhthu=? where MaKH=?");
            pr.setString(1, khach.getHoten());
            pr.setBoolean(2, khach.getGioitinh());
            pr.setString(3, khach.getSDT());
            pr.setFloat(4, khach.getTongdoanhthu());
            pr.setString(5, khach.getMaHK());
            if (pr.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean XoaKH(String ma) {
        con = db.getConn();
        try {
            pr = con.prepareStatement("select * from HoaDon where MaKH=?");
            pr.setString(1, ma);
            rs = pr.executeQuery();
            if (rs.next()) {
                return false;
            } else {
                pr = con.prepareStatement("delete from KhachHang where MaKH=?");
                pr.setString(1, ma);
                if (pr.executeUpdate() > 0) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public int TongKH() {
        con = db.getConn();
        try {
            pr = con.prepareStatement("select count(*) as soluong from KhachHang");
            rs = pr.executeQuery();
            if (rs.next()) {
                return rs.getInt("soluong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public KhachHang TimKiemTheoSDT(String sdt) {
        con = db.getConn();
        try {
            pr = con.prepareStatement("select * from KhachHang where SDT=?");
            pr.setString(1, sdt);
            rs = pr.executeQuery();
            if (rs.next()) {
                KhachHang khach = new KhachHang();
                khach.setMaHK(rs.getString("MaKH"));
                khach.setHoten(rs.getString("HoTen"));
                khach.setGioitinh(rs.getBoolean("GioiTinh"));
                khach.setSDT(rs.getString("SDT"));
                khach.setTongdoanhthu(rs.getFloat("DoanhThu"));
                return khach;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void CapNhatDoanhThu(String ma, float thanhtien) {
        con = db.getConn();
        try {
            pr = con.prepareStatement("select * from KhachHang where MaKH=?");
            pr.setString(1, ma);
            rs = pr.executeQuery();
            rs.next();
            float doanhthu = rs.getFloat("DoanhThu");
            pr = con.prepareStatement("update KhachHang set DoanhThu=? where MaKH=?");
            pr.setFloat(1, doanhthu + thanhtien);
            pr.setString(2, ma);
            if (pr.executeUpdate() > 0) {
                System.out.println("Cập nhật doanh thu thành công");
            } else {
                System.out.println("Cập nhật doanh thu không thành công.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
