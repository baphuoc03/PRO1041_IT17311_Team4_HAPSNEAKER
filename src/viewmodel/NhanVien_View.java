/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.Date;
import model.ChucVu_Model;

/**
 *
 * @author admin
 */
public class NhanVien_View {
    private String ma;
    private String hoTen;
    private String gioiTinh;
    private Date ngaySinh;
    private String sđt;
    private String diaChi;
    private String passWord;
    private ChucVu_Model chucVu;

    public NhanVien_View() {
    }

    public NhanVien_View(String ma, String hoTen, String gioiTinh, Date ngaySinh, String sđt, String diaChi, String passWord, ChucVu_Model chucVu) {
        this.ma = ma;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.sđt = sđt;
        this.diaChi = diaChi;
        this.passWord = passWord;
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
    
    
}
