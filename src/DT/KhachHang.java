
package DT;

public class KhachHang {
    private String MaHK, HoTen, SDT;
    boolean gioitinh;
    float tongdoanhthu;
    public KhachHang(){
        MaHK = new String();
        HoTen = new String();
        SDT = new String();
        gioitinh = true;
        tongdoanhthu = 0;
    }

    public String getMaHK() {
        return MaHK;
    }

    public void setMaHK(String MaHK) {
        this.MaHK = MaHK;
    }

    public String getHoten() {
        return HoTen;
    }

    public void setHoten(String Hoten) {
        this.HoTen = Hoten;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public float getTongdoanhthu() {
        return tongdoanhthu;
    }

    public void setTongdoanhthu(float tongdoanhthu) {
        this.tongdoanhthu = tongdoanhthu;
    }
    
}
