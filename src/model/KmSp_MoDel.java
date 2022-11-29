/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author baphuoc
 */
public class KmSp_Model {
    private KhuyenMai_Model khuyenMai;
    private SanPham_Model sanPham;

    public KmSp_Model() {
    }

    public KmSp_Model(KhuyenMai_Model khuyenMai, SanPham_Model sanPham) {
        this.khuyenMai = khuyenMai;
        this.sanPham = sanPham;
    }

    public KhuyenMai_Model getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(KhuyenMai_Model khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    public SanPham_Model getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham_Model sanPham) {
        this.sanPham = sanPham;
    }
    
}
