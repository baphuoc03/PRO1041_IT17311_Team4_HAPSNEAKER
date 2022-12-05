/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author baphuoc
 */
public class DonHang_Model {
    private String ma;
    private NhanVien_Model nhanVien;
    private KhachHang_Model khachHang;
    private String ngayTao;
    private int trangThai;

    public DonHang_Model() {
    }

    public DonHang_Model(String ma, NhanVien_Model nhanVien, KhachHang_Model khachHang, String ngayTao, int trangThai) {
        this.ma = ma;
        this.nhanVien = nhanVien;
        this.khachHang = khachHang;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public NhanVien_Model getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien_Model nhanVien) {
        this.nhanVien = nhanVien;
    }

    public KhachHang_Model getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang_Model khachHang) {
        this.khachHang = khachHang;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "DonHang_Model{" + "ma=" + ma + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", ngayTao=" + ngayTao + ", trangThai=" + trangThai + '}';
    }
    
}
