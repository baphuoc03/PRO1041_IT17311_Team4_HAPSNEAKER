/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author baphuoc
 */
public class TKSanPham_Model {
    private String maSP;
    private String ten;
    private String mau;
    private String thuongHieu;
    private int slBan;

    public TKSanPham_Model() {
    }

    public TKSanPham_Model(String maSP, String ten, String mau, String thuongHieu, int slBan) {
        this.maSP = maSP;
        this.ten = ten;
        this.mau = mau;
        this.thuongHieu = thuongHieu;
        this.slBan = slBan;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }

    public String getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(String thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public int getSlBan() {
        return slBan;
    }

    public void setSlBan(int slBan) {
        this.slBan = slBan;
    }

    @Override
    public String toString() {
        return "TKSanPham_Model{" + "maSP=" + maSP + ", ten=" + ten + ", mau=" + mau + ", thuongHieu=" + thuongHieu + ", slBan=" + slBan + '}';
    }
    
}
