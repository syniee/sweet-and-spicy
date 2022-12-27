
package DT;

import java.util.Date;


public class NhanVien {
     String MaNV,HoTen,Quequan,Diachi,SDT,CMND,Mail;
     String MatKhau, Vitri;
    private float giolam, luong, thuong, Mucluong;
    private Date ngaysinh;
    private boolean gioitinh;
    
    public NhanVien(){
        MaNV = new String();
        HoTen = new String();
        Quequan = new String();
        Diachi = new String();
        SDT = new String();
        CMND = new String();
        Mail = new String();
        MatKhau = new String();
        Vitri = new String();
        giolam = 0;
        luong = 0;
        thuong = 0;
        Mucluong = 0;
        ngaysinh = new Date();
        gioitinh=true;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getQuequan() {
        return Quequan;
    }

    public void setQuequan(String Quequan) {
        this.Quequan = Quequan;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String Diachi) {
        this.Diachi = Diachi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getVitri() {
        return Vitri;
    }

    public void setVitri(String Vitri) {
        this.Vitri = Vitri;
    }

    public float getGiolam() {
        return giolam;
    }

    public void setGiolam(float giolam) {
        this.giolam = giolam;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public float getThuong() {
        return thuong;
    }

    public void setThuong(float thuong) {
        this.thuong = thuong;
    }

    public float getMucluong() {
        return Mucluong;
    }

    public void setMucluong(float Mucluong) {
        this.Mucluong = Mucluong;
    }

    public Date getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(Date ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public boolean getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }
    
}
