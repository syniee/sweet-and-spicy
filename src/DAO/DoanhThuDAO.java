package DAO;

import DB.Connect;
import DT.DoanhThu;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DoanhThuDAO {

    Connect db = new Connect();
    Connection con = db.getConn();
    PreparedStatement pr;
    ResultSet rs;

    public DoanhThu DoanhThuTheoLoai(String tenloai) {
        try {
            pr = con.prepareStatement("select * from Loai where TenLoai=?");
            pr.setString(1, tenloai);
            rs = pr.executeQuery();
            DoanhThu dt = new DoanhThu();
            if (rs.next()) {
                String Maloai = rs.getString("MaLoai");
                pr = con.prepareStatement("select * from SanPham join CTHoaDon on CTHoaDon.MaSP=SanPham.MaSP where MaLoai=?");
                pr.setString(1, Maloai);
                rs = pr.executeQuery();
                float doanhthu = 0;
                int sl = 0;
                while (rs.next()) {
                    doanhthu += rs.getFloat("ThanhTien");
                    sl += rs.getInt("SoLuong");
                }
                dt.setDoanhthu(doanhthu);
                dt.setSoluong(sl);
                return dt;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DoanhThuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public DoanhThu DoanhThuTheoSanPham(String ma) {
        try {
            pr = con.prepareStatement("select * from CTHoaDon where MaSP=?");
            pr.setString(1, ma);
            rs = pr.executeQuery();
            DoanhThu dt = new DoanhThu();
            float doanhthu = 0;
            int sl = 0;
            while (rs.next()) {
                doanhthu += rs.getFloat("ThanhTien");
                sl += rs.getInt("SoLuong");
            }
            dt.setDoanhthu(doanhthu);
            dt.setSoluong(sl);
            return dt;
        } catch (SQLException ex) {
            Logger.getLogger(DoanhThuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public DoanhThu DoanhThuTheoNgay(String ngay){
        try {
            pr = con.prepareStatement("select * from CTHoaDon join HoaDon on HoaDon.MaHD=CTHoaDon.MaHD where NgayTao=?");
            pr.setString(1, ngay);
            rs = pr.executeQuery();
            DoanhThu dt = new DoanhThu();
            float doanhthu = 0;
            int sl = 0;
            while (rs.next()) {
                doanhthu += rs.getFloat("ThanhTien");
                sl += rs.getInt("SoLuong");
            }
            dt.setDoanhthu(doanhthu);
            dt.setSoluong(sl);
            return dt;
        } catch (SQLException ex) {
            Logger.getLogger(DoanhThuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public DoanhThu DTTheoKhoangThoiGian(String d1, String d2){
                try {
            pr = con.prepareStatement("select * from CTHoaDon join HoaDon on HoaDon.MaHD=CTHoaDon.MaHD where NgayTao>=? and NgayTao<=?");
            pr.setString(1, d1);
            pr.setString(2, d2);
            rs = pr.executeQuery();
            DoanhThu dt = new DoanhThu();
            float doanhthu = 0;
            int sl = 0;
            while (rs.next()) {
                doanhthu += rs.getFloat("ThanhTien");
                sl += rs.getInt("SoLuong");
            }
            dt.setDoanhthu(doanhthu);
            dt.setSoluong(sl);
            return dt;
        } catch (SQLException ex) {
            Logger.getLogger(DoanhThuDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        
    }
}
