package models;

public class SanPham {

    private int ma;
    private String ten;
    private String trangThai;
    private int giaBan;

    public SanPham() {
    }

    public SanPham(int ma, String ten, String trangThai, int giaBan) {
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
        this.giaBan = giaBan;
    }

    public int getMa() {
        return ma;
    }

    public void setMa(int ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

}
