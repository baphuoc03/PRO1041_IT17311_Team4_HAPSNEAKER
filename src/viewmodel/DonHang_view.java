/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.Date;

/**
 *
 * @author baphuoc
 */
public class DonHang_view {
    private int stt;
    private String maHD;
    private String tenNV;
    private String sđt;
    private String tenKH;
    private Date ngayTao;
    private String trangThai;

    public DonHang_view() {
    }

    public DonHang_view(int stt, String maHD, String tenNV, String sđt, String tenKH, Date ngayTao, String trangThai) {
        this.stt = stt;
        this.maHD = maHD;
        this.tenNV = tenNV;
        this.sđt = sđt;
        this.tenKH = tenKH;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public String getSđt() {
        return sđt;
    }

    public void setSđt(String sđt) {
        this.sđt = sđt;
    }

    

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
    
}
