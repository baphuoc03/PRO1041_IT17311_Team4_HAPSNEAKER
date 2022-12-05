/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author baphuoc
 */
public class ChiTietDH_model {
    private DonHang_Model donHang;
    private ThuocTinhSP_Model thuocTinh;
    private int sl;
    private float donGia;
    private float donGiaSauGiam;

    public ChiTietDH_model() {
    }

    public ChiTietDH_model(DonHang_Model donHang, ThuocTinhSP_Model thuocTinh, int sl, float donGia, float donGiaSauGiam) {
        this.donHang = donHang;
        this.thuocTinh = thuocTinh;
        this.sl = sl;
        this.donGia = donGia;
        this.donGiaSauGiam = donGiaSauGiam;
    }

    

    public DonHang_Model getDonHang() {
        return donHang;
    }

    public void setDonHang(DonHang_Model donHang) {
        this.donHang = donHang;
    }

    public ThuocTinhSP_Model getThuocTinh() {
        return thuocTinh;
    }

    public void setThuocTinh(ThuocTinhSP_Model thuocTinh) {
        this.thuocTinh = thuocTinh;
    }

    public int getSl() {
        return sl;
    }

    public void setSl(int sl) {
        this.sl = sl;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getDonGiaSauGiam() {
        return donGiaSauGiam;
    }

    public void setDonGiaSauGiam(float donGiaSauGiam) {
        this.donGiaSauGiam = donGiaSauGiam;
    }

    @Override
    public String toString() {
        return "ChiTietDH_model{" + "donHang=" + donHang + ", thuocTinh=" + thuocTinh + ", sl=" + sl + ", donGia=" + donGia + ", donGiaSauGiam=" + donGiaSauGiam + '}';
    }
    
    
    
    
}
