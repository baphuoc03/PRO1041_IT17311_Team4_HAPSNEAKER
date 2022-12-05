/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

/**
 *
 * @author baphuoc
 */
public class ChiTietDH_View {
    private int stt;
    private String maSP;
    private String tenSP;
    private float size;
    private int SL;
    private float donGia;
    private float thanhTien;
    private int khuyenMai;
    private float tienSauGiam;

    public ChiTietDH_View() {
    }

    public ChiTietDH_View(int stt, String maSP, String tenSP, float size, int SL, float donGia, float thanhTien, int khuyenMai, float tienSauGiam) {
        this.stt = stt;
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.size = size;
        this.SL = SL;
        this.donGia = donGia;
        this.thanhTien = thanhTien;
        this.khuyenMai = khuyenMai;
        this.tienSauGiam = tienSauGiam;
    }

   

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public int getSL() {
        return SL;
    }

    public void setSL(int SL) {
        this.SL = SL;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public int getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(int khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public float getTienSauGiam() {
        return tienSauGiam;
    }

    public void setTienSauGiam(float tienSauGiam) {
        this.tienSauGiam = tienSauGiam;
    }

    @Override
    public String toString() {
        return "ChiTietDH_View{" + "stt=" + stt + ", maSP=" + maSP + ", tenSP=" + tenSP + ", size=" + size + ", SL=" + SL + ", donGia=" + donGia + ", thanhTien=" + thanhTien + ", khuyenMai=" + khuyenMai + ", tienSauGiam=" + tienSauGiam + '}';
    }
    
}
