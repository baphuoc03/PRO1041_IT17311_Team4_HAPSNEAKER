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
public class KhachHang_Model {
    private String sđt;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String email;
    private String diaChi;

    public KhachHang_Model() {
    }

    public KhachHang_Model(String sđt, String hoTen, String gioiTinh, Date ngaySinh, String email, String diaChi) {
        this.sđt = sđt;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.diaChi = diaChi;
    }

    public String getSđt() {
        return sđt;
    }

    @Override
    public String toString() {
        return "KhachHang_Model{" + "s\u0111t=" + sđt + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", email=" + email + ", diaChi=" + diaChi + '}';
    }

    public void setSđt(String sđt) {
        this.sđt = sđt;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }
    
}
