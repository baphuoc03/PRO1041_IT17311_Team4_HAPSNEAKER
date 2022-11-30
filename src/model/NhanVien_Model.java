/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author baphuoc
 */
public class NhanVien_Model {
    private String ma;
    private String passWord;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String sđt;
    private String diaChi;
    private ChucVu_Model chucVu;

    public NhanVien_Model() {
    }

    public NhanVien_Model(String ma, String passWord, String hoTen, String gioiTinh, Date ngaySinh, String sđt, String diaChi, ChucVu_Model chucVu) {
        this.ma = ma;
        this.passWord = passWord;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sđt = sđt;
        this.diaChi = diaChi;
        this.chucVu = chucVu;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSđt() {
        return sđt;
    }

    public void setSđt(String sđt) {
        this.sđt = sđt;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public ChucVu_Model getChucVu() {
        return chucVu;
    }

    public void setChucVu(ChucVu_Model chucVu) {
        this.chucVu = chucVu;
    }

    @Override
    public String toString() {
        return "NhanVien_Model{" + "ma=" + ma + ", passWord=" + passWord + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", s\u0111t=" + sđt + ", diaChi=" + diaChi + ", chucVu=" + chucVu + '}';
    }
    
}
