package DAO;

import DB.Connect;
import DT.CTHoaDon;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CTHoaDonDAO {

    Connect db = new Connect();
    Connection con = db.getConn();
    PreparedStatement pr;
    ResultSet rs;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE;

    public ArrayList<CTHoaDon> dsCTHD() {
        try {
            pr = con.prepareStatement("select * from CTHoaDon");
            rs = pr.executeQuery();
            ArrayList<CTHoaDon> ds = new ArrayList<>();
            while (rs.next()) {
                CTHoaDon hd = new CTHoaDon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaSP(rs.getString(2));
                hd.setSize(rs.getString(3));
                hd.setDonGia(rs.getFloat(4));
                hd.setSoLuong(rs.getInt(5));
                hd.setThanhTien(rs.getFloat(6));
                ds.add(hd);
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean ThemCTHD(CTHoaDon hd) {
        try {
            pr = con.prepareStatement("insert into CTHoaDon values(?,?,?,?,?,?)");
            pr.setInt(1, hd.getMaHD());
            pr.setString(2, hd.getMaSP());
            pr.setString(3, hd.getSize());
            pr.setFloat(4, hd.getDonGia());
            pr.setInt(5, hd.getSoLuong());
            pr.setFloat(6, hd.getThanhTien());
            if (pr.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean CapNhatCTHD(CTHoaDon hd) {
        try {
            pr = con.prepareStatement("update CTHoaDon set Size=?, Gia=?, SoLuong=?, ThanhTien=? where MaHD=? and MaSP=?");
            pr.setString(1, hd.getSize());
            pr.setFloat(2, hd.getDonGia());
            pr.setInt(3, hd.getSoLuong());
            pr.setFloat(4, hd.getThanhTien());
            pr.setInt(5, hd.getMaHD());
            pr.setString(6, hd.getMaSP());
            if (pr.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean xoaCTHD(int ma, String MaSP){
        try {
            pr = con.prepareStatement("delete from CTHoaDon where MaHD=? and MaSP=?");
            pr.setInt(1, ma);
            pr.setString(2, MaSP);
            if(pr.executeUpdate()>0) return true;
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public CTHoaDon TimKiem(int ma, String masp){
        try {
            pr = con.prepareStatement("select * from CTHoaDon where MaHD=? and MaSP=?");
            pr.setInt(1, ma);
            pr.setString(2, masp);
            rs = pr.executeQuery();
            if(rs.next()){
                CTHoaDon hd = new CTHoaDon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaSP(rs.getString(2));
                hd.setSize(rs.getString(3));
                hd.setDonGia(rs.getFloat(4));
                hd.setSoLuong(rs.getInt(5));
                hd.setThanhTien(rs.getFloat(6));
                return hd;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
        public ArrayList<CTHoaDon> TimKiemTheoMa(int ma){
        try {
            pr = con.prepareStatement("select * from CTHoaDon where MaHD=?");
            pr.setInt(1, ma);
            rs = pr.executeQuery();
            ArrayList<CTHoaDon> ds = new  ArrayList<>();
            while(rs.next()){
                CTHoaDon hd = new CTHoaDon();
                hd.setMaHD(rs.getInt(1));
                hd.setMaSP(rs.getString(2));
                hd.setSize(rs.getString(3));
                hd.setDonGia(rs.getFloat(4));
                hd.setSoLuong(rs.getInt(5));
                hd.setThanhTien(rs.getFloat(6));
                ds.add(hd);
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(CTHoaDonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
