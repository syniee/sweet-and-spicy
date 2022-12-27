
package DT;

import java.time.LocalDate;


public class HoaDon {
    String MaKH, MaNV, MaKM;
    int MaHD;
    LocalDate NgayTao;
    float ThanhTien;
    String GhiChu;
    public HoaDon(){
        MaKH = new String();
        MaNV = new String();
        MaKM = new String();
        MaHD = 0;
        GhiChu = new String();
        NgayTao = LocalDate.now();
        ThanhTien = 0;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public LocalDate getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(LocalDate NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public float getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(float ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
}
