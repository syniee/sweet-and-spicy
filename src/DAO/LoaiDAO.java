package DAO;

import DT.Loai;
import View.FormLoaiSanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoaiDAO {

    Connection con;
    PreparedStatement pr;
    ResultSet rs;
    DB.Connect db = new DB.Connect();

    public ArrayList<Loai> DSLoaiSP() {
        con = db.getConn();
        ArrayList<Loai> ds = new ArrayList<>();
        try {
            pr = con.prepareStatement("select * from Loai");
            rs = pr.executeQuery();
            while (rs.next()) {
                Loai loai = new Loai();
                loai.setMaLoai(rs.getString("MaLoai"));
                loai.setTenLoai(rs.getString("TenLoai"));
                ds.add(loai);
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(LoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean ThemLoai(Loai loai) {
        con = db.getConn();
        try {
            pr = con.prepareStatement("insert into Loai values(?,?)");
            pr.setString(1, loai.getMaLoai());
            pr.setString(2, loai.getTenLoai());
            if (pr.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean CapNhatLoai(Loai loai) {
        con = db.getConn();
        try {
            pr = con.prepareStatement("update Loai set TenLoai=? where MaLoai=?");
            pr.setString(1, loai.getTenLoai());
            pr.setString(2, loai.getMaLoai());
            if (pr.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean XoaLoaiSP(String ma) {
        con = db.getConn();
        try {
            pr = con.prepareStatement("delete from Loai where MaLoai=?");
            pr.setString(1, ma);
            if (pr.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Loai TimKiemLoai(String ma) {
        con = db.getConn();
        try {
            pr = con.prepareStatement("select * from Loai where MaLoai=?");
            pr.setString(1, ma);
            rs = pr.executeQuery();
            if (rs.next()) {
                Loai loai = new Loai();
                loai.setMaLoai(rs.getString("MaLoai"));
                loai.setTenLoai(rs.getString("TenLoai"));
                return loai;
            }

        } catch (SQLException ex) {
            Logger.getLogger(LoaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int Soluong() {
        con = db.getConn();
        try {
            pr = con.prepareStatement("Select count(*) as soluong from Loai");
            rs = pr.executeQuery();
            if (rs.next()) {
                return rs.getInt("soluong");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormLoaiSanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
}
