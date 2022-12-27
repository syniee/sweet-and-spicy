package DAO;

import DT.SanPham;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SanPhamDAO {

    Connection con;
    PreparedStatement pr;
    ResultSet rs;
    DB.Connect db = new DB.Connect();

    public ArrayList<SanPham> DanhSachSP() {
        con = db.getConn();
        try {
            ArrayList<SanPham> ds = new ArrayList<>();
            pr = con.prepareStatement("select * from SanPham join Loai on SanPham.MaLoai=Loai.MaLoai");
            rs = pr.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setMaLoai(rs.getString("MaLoai"));
                sp.setSize(rs.getString("Size"));
                sp.setGia(rs.getFloat("Gia"));
                ds.add(sp);
            }
            return ds;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean ThemSP(SanPham sp) {
        con = db.getConn();
        try {
            pr = con.prepareStatement("insert into SanPham values(?,?,?,?,?)");
            pr.setString(1, sp.getMaSP());
            pr.setString(2, sp.getTenSP());
            pr.setString(3, sp.getMaLoai());
            pr.setString(4, sp.getSize());
            pr.setFloat(5, sp.getGia());
            if (pr.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean CapNhatSP(SanPham sp) {
        con = db.getConn();
        try {
            pr = con.prepareStatement("update SanPham set TenSP=?, MaLoai=?, Size=?, Gia=? where MaSP=?");
            pr.setString(1, sp.getTenSP());
            pr.setString(2, sp.getMaLoai());
            pr.setString(3, sp.getSize());
            pr.setFloat(4, sp.getGia());
            pr.setString(5, sp.getMaSP());
            if(pr.executeUpdate()>0) 
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean XoaSP(String ma){
        con = db.getConn();
        try {
            pr = con.prepareStatement("select * from CTHoaDon where MaSP=?");
            pr.setString(1, ma);
            rs = pr.executeQuery();
            if(rs.next()){
                return  false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
        try {
            pr = con.prepareStatement("delete from SanPham where MaSP=?");
            pr.setString(1, ma);
            if(pr.executeUpdate()>0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public SanPham TimKiemSP(String ma){
        con = db.getConn();
        try {
            pr = con.prepareStatement("select * from SanPham where MaSP=?");
            pr.setString(1, ma);
            rs = pr.executeQuery();
            SanPham sp = new SanPham();
            if(rs.next()){
                sp.setMaSP(rs.getString("MaSP"));
                sp.setTenSP(rs.getString("TenSP"));
                sp.setMaLoai(rs.getString("MaLoai"));
                sp.setSize(rs.getString("Size"));
                sp.setGia(rs.getFloat("Gia"));
                return sp;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;        
    }
    
    public int SoLuongSP(){
        con = db.getConn();
        try {
            pr = con.prepareStatement("select count(*) as soluong from SanPham");
            rs = pr.executeQuery();
            if(rs.next())
                return rs.getInt("soluong");
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public float LayGia(String ma){
        try {
            pr = con.prepareStatement("select * from SanPham where MaSP=?");
            pr.setString(1, ma);
            rs = pr.executeQuery();
            if(rs.next()) return rs.getFloat("Gia");
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public String layTenSP(String ma){
                try {
            pr = con.prepareStatement("select * from SanPham where MaSP=?");
            pr.setString(1, ma);
            rs = pr.executeQuery();
            if(rs.next()) return rs.getString("TenSP");
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
