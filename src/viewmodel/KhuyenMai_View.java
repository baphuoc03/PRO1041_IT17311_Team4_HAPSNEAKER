/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package viewmodel;

import java.util.Date;

/**
 *
 * @author phamtuananh
 */
public class KhuyenMai_View {
    private int stt;
    private String ma;
    private String ten;
    private int giamGia;
    private Date ngayBatDau;
    private Date ngayKetThuc;

    public KhuyenMai_View() {
    }

    public KhuyenMai_View(int stt, String ma, String ten, int giamGia, Date ngayBatDau, Date ngayKetThuc) {
        this.stt = stt;
        this.ma = ma;
        this.ten = ten;
        this.giamGia = giamGia;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
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

    public int getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(int giamGia) {
        this.giamGia = giamGia;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    @Override
    public String toString() {
        return "KhuyenMai_View{" + "stt=" + stt + ", ma=" + ma + ", ten=" + ten + ", giamGia=" + giamGia + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + '}';
    }
    

 
    
}
