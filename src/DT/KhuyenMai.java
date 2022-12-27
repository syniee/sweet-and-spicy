
package DT;

import java.util.Date;


public class KhuyenMai {
    String MaKM, TenKM, LoaiSanPham,UuDai;
    int Phantramgiam;
    float HoaDon;
    Date TuNgay, DenNgay;
    public KhuyenMai(){
        MaKM = new String();
        TenKM = new String();
        LoaiSanPham = new String();
        UuDai = new String();
        Phantramgiam = 0;
        HoaDon = 0;
        TuNgay = new Date();
        DenNgay = new Date();               
    }

    public String getMaKM() {
        return MaKM;
    }

    public void setMaKM(String MaKM) {
        this.MaKM = MaKM;
    }

    public String getTenKM() {
        return TenKM;
    }

    public void setTenKM(String TenKM) {
        this.TenKM = TenKM;
    }

    public String getLoaiSanPham() {
        return LoaiSanPham;
    }

    public void setLoaiSanPham(String SanPham) {
        this.LoaiSanPham = SanPham;
    }

    public String getUuDai() {
        return UuDai;
    }

    public void setUuDai(String UuDai) {
        this.UuDai = UuDai;
    }

    public int getPhantramgiam() {
        return Phantramgiam;
    }

    public void setPhantramgiam(int Phantramgiam) {
        this.Phantramgiam = Phantramgiam;
    }

    public float getHoaDon() {
        return HoaDon;
    }

    public void setHoaDon(float HoaDon) {
        this.HoaDon = HoaDon;
    }

    public Date getTuNgay() {
        return TuNgay;
    }

    public void setTuNgay(Date TuNgay) {
        this.TuNgay = TuNgay;
    }

    public Date getDenNgay() {
        return DenNgay;
    }

    public void setDenNgay(Date DenNgay) {
        this.DenNgay = DenNgay;
    }

    
}
