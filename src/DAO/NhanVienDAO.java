package DAO;

import DT.NhanVien;
import View.FormNhanVien;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class NhanVienDAO {

    Connection con;
    DB.Connect db = new DB.Connect();
    PreparedStatement pr;
    ResultSet rs;
    SimpleDateFormat dinhdangngay = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat dinhdangnam = new SimpleDateFormat("yyyy-MM-dd");

    public ArrayList<NhanVien> getDanhSachNhanVien() {
        con = db.getConn();
        try {
            pr = con.prepareStatement("select * from NhanVien");
            ArrayList<NhanVien> dsnv = new ArrayList<>();
            rs = pr.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNhanVien"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setGioitinh(rs.getBoolean("GioiTinh"));
                nv.setNgaysinh(rs.getDate("NgaySinh"));
                nv.setCMND(rs.getString("CMND"));
                nv.setQuequan(rs.getString("QueQuan"));
                nv.setDiachi(rs.getString("DiaChiTamTru"));
                nv.setSDT(rs.getString("SoDienThoai"));
                nv.setMail(rs.getString("ViTri"));
                nv.setMucluong(rs.getFloat("MucLuong"));
                nv.setLuong(rs.getFloat("TienLuong"));
                nv.setGiolam(rs.getFloat("SoGioLamViec"));
                nv.setThuong(rs.getFloat("Thuong"));
                dsnv.add(nv);
            }
            return dsnv;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public NhanVien TimKiemNV(String ma) {
        con = db.getConn();
        try {
            pr = con.prepareStatement("select * from NhanVien where MaNhanVien = ?");
            pr.setString(1, ma);
            rs = pr.executeQuery();
            if (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setMaNV(rs.getString("MaNhanVien"));
                nv.setMatKhau(rs.getString("MatKhau"));
                nv.setHoTen(rs.getString("HoTen"));
                nv.setGioitinh(rs.getBoolean("GioiTinh"));
                nv.setNgaysinh(rs.getDate("NgaySinh"));
                nv.setCMND(rs.getString("CMND"));
                nv.setQuequan(rs.getString("QueQuan"));
                nv.setDiachi(rs.getString("DiaChiTamTru"));
                nv.setSDT(rs.getString("SoDienThoai"));
                nv.setMail(rs.getString("Email"));
                nv.setVitri(rs.getString("ViTri"));
                nv.setMucluong(rs.getFloat("MucLuong"));
                nv.setGiolam(rs.getFloat("SoGioLamViec"));
                nv.setThuong(rs.getFloat("Thuong"));
                nv.setLuong(rs.getFloat("TienLuong"));
                return nv;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean ThemVN(NhanVien nv) {
        con = db.getConn();
        try {
            pr = con.prepareStatement("insert into NhanVien values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pr.setString(1, nv.getMaNV());
            pr.setString(2, nv.getMatKhau());
            pr.setString(3, nv.getHoTen());
            pr.setBoolean(4, nv.getGioitinh());
            pr.setString(5, dinhdangnam.format(nv.getNgaysinh()));
            pr.setString(6, nv.getCMND());
            pr.setString(7, nv.getQuequan());
            pr.setString(8, nv.getDiachi());
            pr.setString(9, nv.getSDT());
            pr.setString(10, nv.getMail());
            pr.setString(11, nv.getVitri());
            pr.setFloat(12, nv.getMucluong());
            pr.setFloat(13, nv.getGiolam());
            pr.setFloat(14, nv.getThuong());
            pr.setFloat(15, nv.getLuong());
            if (pr.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean CapNhatNV(NhanVien nv) {

        String capnhatNV = "UPDATE NhanVien SET MatKhau=?, HoTen=?, GioiTinh=?, NgaySinh=?, CMND=?, QueQuan=?, DiaChiTamTru=?, SoDienThoai=?,"
                + "Email=?, Vitri=?, MucLuong=?, SoGioLamViec=?, Thuong=?, TienLuong=? where MaNhanVien=?";
        con = db.getConn();

        try {
            pr = con.prepareStatement(capnhatNV);
            pr.setString(1, nv.getMatKhau());
            pr.setString(2, nv.getHoTen());            
            pr.setBoolean(3, nv.getGioitinh());            
            pr.setString(4, dinhdangnam.format(nv.getNgaysinh()));
            pr.setString(5, nv.getCMND());
            pr.setString(6, nv.getQuequan());
            pr.setString(7,nv.getDiachi());
            pr.setString(8, nv.getSDT());
            pr.setString(9, nv.getMail());
            pr.setString(10,nv.getVitri());
            pr.setFloat(11, nv.getMucluong());           
            pr.setFloat(12, nv.getGiolam());            
            pr.setFloat(13, nv.getThuong());
            pr.setFloat(14, nv.getLuong());
            pr.setString(15, nv.getMaNV());
            if (pr.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            //
        }
        return false;
    }
    
    public boolean XoaNV(String ma){
        con = db.getConn();
        try {
            pr = con.prepareStatement("delete from NhanVien where MaNhanVien=?");
            pr.setString(1, ma);
            if(pr.executeUpdate()>0) return true;
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
}
