
package DT;


public class SanPham {
    private String MaSP, TenSP, size;
    private float gia;
    private String  MaLoai;
    
    public SanPham(){
        MaSP = new String();
        TenSP = new String();
        size = new String();
        gia = 0;
        MaLoai = new String();
    }

    public String getMaSP() {
        return MaSP;
    }

    public void setMaSP(String MaSP) {
        this.MaSP = MaSP;
    }

    public String getTenSP() {
        return TenSP;
    }

    public void setTenSP(String TenSP) {
        this.TenSP = TenSP;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }
    
    
}
