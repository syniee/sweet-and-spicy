package DAO;
import DB.Connect;
import DT.KhuyenMai;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KhuyenMaiDAO {
    Connect db = new Connect();
    Connection con = db.getConn();
    PreparedStatement pr;
    ResultSet rs;
    SimpleDateFormat dinhdangngay = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat dinhdangnam = new SimpleDateFormat("yyyy-MM-dd");
    public ArrayList<KhuyenMai> dsKhuyenMai(){
        
        try {
            ArrayList<KhuyenMai> ds = new ArrayList<>();
            pr = con.prepareStatement("select * from KhuyenMai");
            rs = pr.executeQuery();
            while(rs.next()){
                KhuyenMai km = new KhuyenMai();
                km.setMaKM(rs.getString(1));
                km.setTenKM(rs.getString(2));
                km.setUuDai(rs.getString(3));
                km.setLoaiSanPham(rs.getString(4));
                km.setPhantramgiam(rs.getInt(5));
                km.setHoaDon(rs.getFloat(6));
                km.setTuNgay(rs.getDate(7));
                km.setDenNgay(rs.getDate(8));
                ds.add(km);
            }
            return ds;
                    
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean Them(KhuyenMai km){
        try {
            pr = con.prepareStatement("insert into KhuyenMai values(?,?,?,?,?,?,?,?)");
            pr.setString(1, km.getMaKM());
            pr.setString(2, km.getTenKM());
            pr.setString(3, km.getUuDai());
            pr.setString(4, km.getLoaiSanPham());
            pr.setInt(5, km.getPhantramgiam());
            pr.setFloat(6, km.getHoaDon());
            pr.setString(7,dinhdangnam.format(km.getTuNgay()));
            pr.setString(8, dinhdangnam.format(km.getDenNgay()));
            if(pr.executeUpdate()>0)
                return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean Capnhat(KhuyenMai km){
        try {
            pr = con.prepareStatement("update KhuyenMai set TenKM=?, UuDai=?, LoaiSanPham=?,PhanTramGiam=?, "
                    + "HoaDon=?, TuNgay=?, DenNgay=? where MaKM=?");
            pr.setString(1, km.getTenKM());
            pr.setString(2,km.getUuDai());
            pr.setString(3, km.getLoaiSanPham());
            pr.setInt(4, km.getPhantramgiam());
            pr.setFloat(5, km.getHoaDon());
            pr.setString(6, dinhdangnam.format(km.getTuNgay()));
            pr.setString(7, dinhdangnam.format(km.getDenNgay()));
            pr.setString(8, km.getMaKM());
            if(pr.executeUpdate()>0) return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean Xoa(String ma){
        try {
            pr = con.prepareStatement("delete from KhuyenMai where MaKM=?");
            pr.setString(1, ma);
            if(pr.executeUpdate()>0) return true;
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public KhuyenMai timkiem(String ma){
        try {
            pr = con.prepareStatement("select * from KhuyenMai where MaKM=?");
            pr.setString(1, ma);
            rs = pr.executeQuery();
            if(rs.next()){
                KhuyenMai km = new KhuyenMai();
                km.setMaKM(rs.getString(1));
                km.setTenKM(rs.getString(2));
                km.setUuDai(rs.getString(3));
                km.setLoaiSanPham(rs.getString(4));
                km.setPhantramgiam(rs.getInt(5));
                km.setHoaDon(rs.getFloat(6));
                km.setTuNgay(rs.getDate(7));
                km.setDenNgay(rs.getDate(8));
                return km;
            }
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
