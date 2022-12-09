/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author baphuoc
 */
public class SanPham_Model {
    private String ma;
    private String ten;
    private ThuongHieu_Model thuongHieu;
    private MauSac_Model mauSac;
    private String moTa;
    private float giaNhap;
    private float giaBan;
    private int trangThai;
    private String hinh;
    public SanPham_Model() {
    }

    public SanPham_Model(String ma, String ten, ThuongHieu_Model thuongHieu, MauSac_Model mauSac, String moTa, float giaNhap, float giaBan, int trangThai, String hinh) {
        this.ma = ma;
        this.ten = ten;
        this.thuongHieu = thuongHieu;
        this.mauSac = mauSac;
        this.moTa = moTa;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.trangThai = trangThai;
        this.hinh = hinh;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public ThuongHieu_Model getThuongHieu() {
        return thuongHieu;
    }

    public void setThuongHieu(ThuongHieu_Model thuongHieu) {
        this.thuongHieu = thuongHieu;
    }

    public MauSac_Model getMauSac() {
        return mauSac;
    }

    public void setMauSac(MauSac_Model mauSac) {
        this.mauSac = mauSac;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    

    @Override
    public String toString() {
        return "SanPham_Model{" + "ma=" + ma + ", ten=" + ten + ", thuongHieu=" + thuongHieu + ", mauSac=" + mauSac + ", moTa=" + moTa + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", trangThai=" + trangThai + '}';
    }
    
}
